package net.nova.big_swords.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.nova.big_swords.init.BSItems;

import static net.nova.big_swords.BigSwordsR.MODID;
import static net.nova.big_swords.BigSwordsR.playSound;

@EventBusSubscriber(modid = MODID)
public class ShieldMechanics {

    @SubscribeEvent
    public static void onShieldBlock(LivingShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player && event.getBlocked()) {
            ItemStack shield = player.getUseItem();
            Entity attacker = event.getDamageSource().getEntity();
            Entity sourceEntity = event.getDamageSource().getDirectEntity();
            DamageSource damageSource = event.getDamageSource();
            float blockedDamage = event.getBlockedDamage();
            float shieldDamage = event.shieldDamage();
            double randomChance = Math.random();
            double randomChanceE = Math.random();
            Level level = player.level();
            RandomSource random = level.getRandom();
            int fireAspectLevel = attacker instanceof LivingEntity livingEntity ? livingEntity.getWeaponItem().getEnchantmentLevel(player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) : 0;
            int soulFireAspectLevel = attacker instanceof LivingEntity livingEntity ?
                    player.level().registryAccess()
                            .lookupOrThrow(Registries.ENCHANTMENT)
                            .get(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.withDefaultNamespace("soul_fire_aspect")))
                            .map(enchantment -> livingEntity.getWeaponItem().getEnchantmentLevel(enchantment))
                            .orElse(0)
                    : 0;

            // Wooden Shields
            boolean isWoodenShield = shield.is(BSItems.WOODEN_SHIELD);
            boolean isGildedWoodenShield = shield.is(BSItems.GILDED_WOODEN_SHIELD);
            if ((isWoodenShield || isGildedWoodenShield)) {
                if (damageSource.is(DamageTypes.ARROW) && sourceEntity instanceof Arrow arrow) {
                    // Perk
                    double catchChance = isGildedWoodenShield ? 0.7 : 0.4;
                    if (randomChance < catchChance) {
                        arrow.remove(Entity.RemovalReason.DISCARDED);

                        ItemStack arrowStack = new ItemStack(Items.ARROW);
                        if (!player.getInventory().add(arrowStack)) {
                            player.drop(arrowStack, false);
                        }
                    }

                    // Weakness
                    if (arrow.isOnFire()) event.setShieldDamage(shieldDamage * 4);
                }

                // Weakness (Comp with Soul fire'd)
                if (fireAspectLevel > 0) event.setShieldDamage(shieldDamage * switch (fireAspectLevel) {
                    case 1 -> 3;
                    case 2 -> 5;
                    default -> 1;
                });

                if (soulFireAspectLevel > 0) event.setShieldDamage(shieldDamage * switch (soulFireAspectLevel) {
                    case 1 -> 6;
                    case 2 -> 10;
                    default -> 1;
                });
            }

            // Stone Shields
            boolean isStoneShield = shield.is(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = shield.is(BSItems.GILDED_STONE_SHIELD);
            if ((isStoneShield || isGildedStoneShield)) {
                // Perk
                if (fireAspectLevel > 0 || soulFireAspectLevel > 0) {
                    event.setShieldDamage(0);
                    playSound(level, player, SoundEvents.FIRE_EXTINGUISH);
                }
                if (sourceEntity instanceof Fireball || (sourceEntity instanceof Projectile projectile && projectile.isOnFire())) {
                    event.setShieldDamage(0);
                    sourceEntity.remove(Entity.RemovalReason.DISCARDED);
                    playSound(level, player, SoundEvents.FIRE_EXTINGUISH);
                }

                // Weakness
                if ((damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION))) {
                    float damageToPlayer = blockedDamage / 3;
                    event.setBlockedDamage(blockedDamage - damageToPlayer);
                    event.setShieldDamage(shieldDamage + damageToPlayer);
                }
            }

            // Iron Shields
            boolean isIronShield = shield.is(BSItems.IRON_SHIELD);
            boolean isGildedIronShield = shield.is(BSItems.GILDED_IRON_SHIELD);
            if ((isIronShield || isGildedIronShield) && (damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION))) {
                // Perk
                float newShieldDamage = isGildedIronShield ? 0 : shieldDamage / 2;
                event.setShieldDamage(newShieldDamage);
            }

            // Diamond Shields
            boolean isDiamondShield = shield.is(BSItems.DIAMOND_SHIELD);
            boolean isGildedDiamondShield = shield.is(BSItems.GILDED_DIAMOND_SHIELD);
            if ((isDiamondShield || isGildedDiamondShield)) {
                float reflectChance = isGildedDiamondShield ? 0.75f : 0.5f;
                // Perk
                if (randomChance < reflectChance) {
                    if (sourceEntity instanceof Projectile originalProjectile && !(originalProjectile instanceof ThrownTrident)) {
                        boolean wasOnFire = originalProjectile.isOnFire();
                        originalProjectile.discard();
                        Projectile newProjectile = (Projectile) originalProjectile.getType().create(level, EntitySpawnReason.EVENT);

                        if (newProjectile != null && attacker != null) {
                            newProjectile.setPos(player.getX(), originalProjectile.getY(), player.getZ());
                            newProjectile.setOwner(player);

                            if (wasOnFire) newProjectile.igniteForSeconds(100);

                            Vec3 directionToAttacker = attacker.position().subtract(player.position()).normalize();

                            float velocity = 1.0f;
                            newProjectile.shoot(directionToAttacker.x, directionToAttacker.y, directionToAttacker.z, velocity, 0.0f);

                            level.addFreshEntity(newProjectile);
                        }

                        // Weakness
                        event.setShieldDamage(shieldDamage * 4);
                    }
                }
            }

            // Netherite Shields
            boolean isNetheriteShield = shield.is(BSItems.NETHERITE_SHIELD);
            boolean isGildedNetheriteShield = shield.is(BSItems.GILDED_NETHERITE_SHIELD);
            if ((isNetheriteShield || isGildedNetheriteShield)) {
                float damageToReflect = isGildedNetheriteShield ? blockedDamage * 0.5f : blockedDamage * 0.3f;
                float cooldownChance = isGildedNetheriteShield ? 0.1f : 0.15f;
                int cooldownTime = isGildedNetheriteShield ? 80 : 160;

                // Perk
                if (randomChance < 0.5 && attacker != null) {
                    attacker.hurt(damageSource, damageToReflect);

                    // Weakness
                    if (randomChanceE < cooldownChance) {
                        player.getCooldowns().addCooldown(shield, cooldownTime);
                        player.stopUsingItem();
                    }
                }
            }

            // Ender Shields
            boolean isEnderShield = shield.is(BSItems.ENDER_SHIELD);
            boolean isGildedEnderShield = shield.is(BSItems.GILDED_ENDER_SHIELD);
            if ((isEnderShield || isGildedEnderShield)) {
                // Perk
                float teleportDisplaceChance = isGildedEnderShield ? 0.4f : 0.2f;
                if ((randomChance < teleportDisplaceChance) && attacker != null && !(attacker instanceof AbstractSkeleton || attacker instanceof WitherBoss)) {
                    Vec3 playerPos = player.position();
                    Vec3 playerFacing = player.getLookAngle().normalize();
                    // Random angle between -45 and 45 degrees
                    double angle = (randomChance * 90 - 45) * Math.PI / 180;

                    // Calculate the teleport vector
                    Vec3 randomVector = new Vec3(Math.cos(angle), 0, Math.sin(angle)).normalize();

                    double blendFactor = 0.7; // Adjust this value to control how much it follows the player's look direction
                    Vec3 teleportVector = playerFacing.scale(blendFactor).add(randomVector.scale(1 - blendFactor)).normalize();

                    double teleportDistance = 10 + (randomChance * 5);
                    Vec3 newAttackerPosition = playerPos.add(teleportVector.scale(teleportDistance));

                    // Adjust Y position to find a safe spot
                    BlockPos blockPos = new BlockPos((int) Math.floor(newAttackerPosition.x), (int) Math.floor(newAttackerPosition.y), (int) Math.floor(newAttackerPosition.z));
                    BlockPos safePos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos);

                    attacker.teleportTo(safePos.getX() + 0.5, safePos.getY(), safePos.getZ() + 0.5);
                    attacker.playSound(SoundEvents.ENDERMAN_TELEPORT);
                }

                // Weakness
                if (attacker instanceof EnderMan || attacker instanceof EnderDragon || attacker instanceof Endermite)
                    event.setBlocked(false);
            }

            // Quartz Shields
            boolean isQuartzShield = shield.is(BSItems.QUARTZ_SHIELD);
            boolean isGildedQuartzShield = shield.is(BSItems.GILDED_QUARTZ_SHIELD);
            if ((isQuartzShield || isGildedQuartzShield)) {
                // Perk
                float quartzBarrierChance = isGildedQuartzShield ? 0.25f : 0.15f;
                if (randomChance < quartzBarrierChance) {
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 30 * 20, 2, false, false));

                    // Weakness
                    float hungerChance = isGildedQuartzShield ? 0.3f : 0.2f;
                    if (randomChanceE < hungerChance) {
                        int hungerReduction = 8; // Reduces 1 full food bar (2 hunger points)
                        float saturationReduction = 10.5f; // Adjust as needed
                        player.getFoodData().eat(-hungerReduction, -saturationReduction);
                    }
                }
            }

            // Patchwork Shields
            boolean isPatchworkShield = shield.is(BSItems.PATCHWORK_SHIELD);
            boolean isGildedPatchworkShield = shield.is(BSItems.GILDED_PATCHWORK_SHIELD);
            if ((isPatchworkShield || isGildedPatchworkShield)) {
                // Perk
                float perkChance = isGildedPatchworkShield ? 0.5f : 0.25f;
                if (randomChance < perkChance && attacker instanceof LivingEntity livingAttacker)
                    livingAttacker.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10 * 20, 0, false, false));


                // Weakness
                float weaknessChance = isGildedPatchworkShield ? 0.25f : 0.5f;
                if (randomChanceE < weaknessChance) event.setBlocked(false);

            }

            // Skull Shields
            boolean isSkullShield = shield.is(BSItems.SKULL_SHIELD);
            boolean isGildedSkullShield = shield.is(BSItems.GILDED_SKULL_SHIELD);
            if ((isSkullShield || isGildedSkullShield)) {
                // Perk
                float perkChance = isGildedPatchworkShield ? 0.25f : 0.15f;
                if (randomChance < perkChance && attacker instanceof Mob mob) setNearestTarget(mob, player);

                // Weakness
                float weaknessChance = isGildedPatchworkShield ? 0.15f : 0.35f;
                if (randomChance < weaknessChance) event.setShieldDamage(shieldDamage * 3);
            }

            // Biomass Shields
            boolean isBiomassShield = shield.is(BSItems.BIOMASS_SHIELD);
            boolean isGildedBiomassShield = shield.is(BSItems.GILDED_BIOMASS_SHIELD);
            if ((isBiomassShield || isGildedBiomassShield)) {
                // Perk
                if (randomChance < 0.45) {
                    float healthToRestore = blockedDamage * 0.30f;
                    player.heal(healthToRestore);
                }

                // Weakness
                if (randomChanceE < 0.15) {
                    float damagePercentage = isGildedBiomassShield ? 0.2f : 0.4f;
                    float healthToDamage = blockedDamage - (blockedDamage * damagePercentage);
                    event.setBlockedDamage(healthToDamage);
                }
            }

            // Livingmetal Shields
            boolean isLivingmetalShield = shield.is(BSItems.LIVINGMETAL_SHIELD);
            boolean isGildedLivingmetalShield = shield.is(BSItems.GILDED_LIVINGMETAL_SHIELD);
            if ((isLivingmetalShield || isGildedLivingmetalShield)) {
                // Perk
                float perkChance = isGildedLivingmetalShield ? 0.4f : 0.25f;
                if (randomChance < perkChance) {
                    // Weakness
                    float chanceToUseMoreXP = isGildedLivingmetalShield ? 0.15f : 0.2f;
                    int minXP = 2;
                    int maxXP = 4;
                    int xpToUse = randomChanceE < chanceToUseMoreXP ? maxXP + random.nextInt(3) : minXP + random.nextInt(3);

                    float xpToHealthRatio = 2.0f;
                    float healthToHeal = xpToUse * xpToHealthRatio;

                    if (player.experienceLevel >= xpToUse && player.getMaxHealth() - 2 > player.getHealth()) {
                        player.heal(healthToHeal);
                        player.giveExperienceLevels(-xpToUse);
                    }
                }
            }
        }
    }

    public static void setNearestTarget(Mob mob, Player blockingPlayer) {
        double SEARCH_RANGE = 16.0;
        Level level = mob.level();
        AABB boundingBox = new AABB(
                mob.getX() - SEARCH_RANGE, mob.getY() - SEARCH_RANGE, mob.getZ() - SEARCH_RANGE,
                mob.getX() + SEARCH_RANGE, mob.getY() + SEARCH_RANGE, mob.getZ() + SEARCH_RANGE
        );

        // Find entities in the bounding box
        LivingEntity nearestEntity = null;
        double nearestDistance = Double.MAX_VALUE;

        for (Entity entity : level.getEntities(mob, boundingBox, e -> e instanceof LivingEntity && !e.equals(blockingPlayer))) {
            if (entity instanceof LivingEntity livingEntity) {
                double distance = mob.distanceToSqr(livingEntity);
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestEntity = livingEntity;
                }
            }
        }

        mob.setTarget(nearestEntity);
    }
}
