package net.nova.big_swords;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSItems;

import java.util.Random;
import java.util.Set;

import static net.nova.big_swords.BigSwordsR.playSound;

public class ShieldMechanics {
    public static final ThreadLocal<Integer> blockedDamage = new ThreadLocal<>();

    public static void register() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, damageSource, baseDamageTaken, damageTaken, blocked) -> {
            if (entity instanceof PlayerEntity player && player.isBlocking()) {
                ItemStack shield = entity.getBlockingItem();
                BlocksAttacksComponent blockingComponent = shield.get(DataComponentTypes.BLOCKS_ATTACKS);

                Entity attacker = damageSource.getAttacker();
                Entity sourceEntity = damageSource.getSource();
                double randomChance = Math.random();
                double randomChanceE = Math.random();
                Random random = new Random();
                if (blockedDamage.get() == null) blockedDamage.set(0);
                World level = entity.getWorld();

                // Wooden Shields
                boolean isWoodenShield = shield.isOf(BSItems.WOODEN_SHIELD);
                boolean isGildedWoodenShield = shield.isOf(BSItems.GILDED_WOODEN_SHIELD);
                if (isWoodenShield || isGildedWoodenShield) {
                    if (damageSource.isOf(DamageTypes.ARROW) && sourceEntity instanceof ArrowEntity arrow) {
                        // Perk
                        double catchChance = isGildedWoodenShield ? 0.7 : 0.4;
                        if (randomChance < catchChance) {
                            arrow.remove(Entity.RemovalReason.DISCARDED);

                            ItemStack arrowStack = new ItemStack(Items.ARROW);
                            if (!player.giveItemStack(arrowStack)) {
                                player.dropItem(arrowStack, false);
                            }
                        }

                        // Weakness
                        if (arrow.isOnFire()) {
                            blockingComponent.onShieldHit(level, shield, entity, );
                            //player.damageShield(blockedDamage.get() * 4);
                        }
                    }

                    // Weakness
                    if (attacker instanceof LivingEntity livingAttacker) {
                        ItemStack attackerWeapon = livingAttacker.getWeaponStack();
                        int fireAspectLevel = attackerWeapon.getEnchantments().getLevel(BigSwordsR.getEnchantment(level, Enchantments.FIRE_ASPECT));
                        switch (fireAspectLevel) {
                            case 1:
                                //player.damageShield(blockedDamage.get() * 3);
                                break;
                            case 2:
                                //player.damageShield(blockedDamage.get() * 5);
                                break;
                        }
                    }
                }

                // Stone Shields
                boolean isStoneShield = shield.isOf(BSItems.STONE_SHIELD);
                boolean isGildedStoneShield = shield.isOf(BSItems.GILDED_STONE_SHIELD);
                if (isStoneShield || isGildedStoneShield) {
                    // Perk
                    if (attacker instanceof LivingEntity livingAttacker) {
                        ItemStack attackerWeapon = livingAttacker.getWeaponStack();
                        int fireAspectLevel = attackerWeapon.getEnchantments().getLevel(BigSwordsR.getEnchantment(level, Enchantments.FIRE_ASPECT));
                        if (fireAspectLevel > 0) {
                            playSound(level, entity, SoundEvents.BLOCK_FIRE_EXTINGUISH);
                        }
                    }
                    if (sourceEntity instanceof FireballEntity || (sourceEntity instanceof ProjectileEntity projectile && projectile.isOnFire())) {
                        sourceEntity.remove(Entity.RemovalReason.DISCARDED);
                        playSound(level, entity, SoundEvents.BLOCK_FIRE_EXTINGUISH);
                    }

                    // Weakness
                    if ((damageSource.isOf(DamageTypes.EXPLOSION) || damageSource.isOf(DamageTypes.PLAYER_EXPLOSION))) {
                        int damageToPlayer = blockedDamage.get() / 3;
                        if (level instanceof ServerWorld serverWorld) {
                            entity.damage(serverWorld, damageSource, damageToPlayer);
                        }
                        //player.damageShield(blockedDamage.get() + damageToPlayer);
                    }
                }

                // Iron Shields
                boolean isIronShield = shield.isOf(BSItems.IRON_SHIELD);
                boolean isGildedIronShield = shield.isOf(BSItems.GILDED_IRON_SHIELD);
                if ((isIronShield || isGildedIronShield) && (damageSource.isOf(DamageTypes.EXPLOSION) || damageSource.isOf(DamageTypes.PLAYER_EXPLOSION))) {
                    // Perk
                    int newShieldDamage = isGildedIronShield ? 0 : (isIronShield ? blockedDamage.get() / 2 : blockedDamage.get());
                    // player.damageShield(newShieldDamage);
                }

                // Diamond Shields
                boolean isDiamondShield = shield.isOf(BSItems.DIAMOND_SHIELD);
                boolean isGildedDiamondShield = shield.isOf(BSItems.GILDED_DIAMOND_SHIELD);
                if ((isDiamondShield || isGildedDiamondShield)) {
                    float reflectChance = isGildedDiamondShield ? 0.75f : 0.5f;
                    // Perk
                    if (randomChance < reflectChance) {
                        if (sourceEntity instanceof ProjectileEntity originalProjectile && !(originalProjectile instanceof TridentEntity)) {
                            boolean wasOnFire = originalProjectile.isOnFire();
                            originalProjectile.discard();
                            ProjectileEntity newProjectile = (ProjectileEntity) originalProjectile.getType().create(level, SpawnReason.EVENT);

                            if (newProjectile != null && attacker != null) {
                                newProjectile.setPos(entity.getX(), originalProjectile.getY(), entity.getZ());
                                newProjectile.setOwner(entity);

                                if (wasOnFire) {
                                    newProjectile.setOnFireFor(100);
                                }

                                Vec3d directionToAttacker = attacker.getPos().subtract(entity.getPos()).normalize();

                                float velocity = 1.0f;
                                newProjectile.setVelocity(directionToAttacker.x, directionToAttacker.y, directionToAttacker.z, velocity, 0.0f);

                                level.spawnEntity(newProjectile);
                            }

                            // Weakness
                            // player.damageShield(blockedDamage.get() * 4);
                        }
                    }
                }

                // Netherite Shields
                boolean isNetheriteShield = shield.isOf(BSItems.NETHERITE_SHIELD);
                boolean isGildedNetheriteShield = shield.isOf(BSItems.GILDED_NETHERITE_SHIELD);
                if ((isNetheriteShield || isGildedNetheriteShield)) {
                    float damageToReflect = isGildedNetheriteShield ? blockedDamage.get() * 0.5f : blockedDamage.get() * 0.3f;
                    float cooldownChance = isGildedNetheriteShield ? 0.1f : 0.15f;
                    int cooldownTime = isGildedNetheriteShield ? 80 : 160;

                    // Perk
                    if (randomChance < 0.5 && attacker != null) {
                        if (level instanceof ServerWorld serverWorld) {
                            attacker.damage(serverWorld, damageSource, damageToReflect);
                        }

                        // Weakness
                        if (randomChanceE < cooldownChance) {
                            player.getItemCooldownManager().set(shield, cooldownTime);
                            entity.stopUsingItem();
                        }
                    }
                }

                // Ender Shields
                boolean isEnderShield = shield.isOf(BSItems.ENDER_SHIELD);
                boolean isGildedEnderShield = shield.isOf(BSItems.GILDED_ENDER_SHIELD);
                if ((isEnderShield || isGildedEnderShield)) {
                    // Perk
                    float teleportDisplaceChance = isGildedEnderShield ? 0.4f : 0.2f;
                    if (level instanceof ServerWorld serverWorld) {
                        if ((randomChance < teleportDisplaceChance) && attacker != null && !(attacker instanceof AbstractSkeletonEntity || attacker instanceof WitherEntity)) {
                            Vec3d playerPos = entity.getPos();
                            Vec3d playerFacing = entity.getRotationVector();
                            // Random angle between -45 and 45 degrees
                            double angle = (randomChance * 90 - 45) * Math.PI / 180;

                            // Calculate the teleport vector
                            Vec3d randomVector = new Vec3d(Math.cos(angle), 0, Math.sin(angle)).normalize();

                            double blendFactor = 0.7; // Adjust this value to control how much it follows the player's look direction
                            Vec3d teleportVector = playerFacing.multiply(blendFactor).add(randomVector.multiply(1 - blendFactor)).normalize();

                            double teleportDistance = 10 + (randomChance * 5);
                            Vec3d newAttackerPosition = playerPos.add(teleportVector.multiply(teleportDistance));

                            // Adjust Y position to find a safe spot
                            BlockPos blockPos = new BlockPos((int) Math.floor(newAttackerPosition.x), (int) Math.floor(newAttackerPosition.y), (int) Math.floor(newAttackerPosition.z));
                            BlockPos safePos = level.getTopPosition(Heightmap.Type.MOTION_BLOCKING, blockPos);
                            Vec3d finalPos = new Vec3d(safePos.getX() + 0.5, safePos.getY(), safePos.getZ() + 0.5);

                            TeleportTarget target = new TeleportTarget(serverWorld, finalPos, Vec3d.ZERO, attacker.getYaw(), attacker.getPitch(), false, false, Set.of(), TeleportTarget.NO_OP);

                            attacker.teleportTo(target);
                            attacker.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                        }
                    }
                }

                // Quartz Shields
                boolean isQuartzShield = shield.isOf(BSItems.QUARTZ_SHIELD);
                boolean isGildedQuartzShield = shield.isOf(BSItems.GILDED_QUARTZ_SHIELD);
                if ((isQuartzShield || isGildedQuartzShield)) {
                    // Perk
                    float quartzBarrierChance = isGildedQuartzShield ? 0.25f : 0.15f;
                    if (randomChance < quartzBarrierChance) {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 30 * 20, 2, false, false));

                        // Weakness
                        float hungerChance = isGildedQuartzShield ? 0.3f : 0.2f;
                        if (randomChanceE < hungerChance) {
                            int hungerReduction = 8; // Reduces 1 full food bar (2 hunger points)
                            float saturationReduction = 10.5f;
                            player.getHungerManager().add(-hungerReduction, -saturationReduction);
                        }
                    }
                }

                // Patchwork Shields
                boolean isPatchworkShield = shield.isOf(BSItems.PATCHWORK_SHIELD);
                boolean isGildedPatchworkShield = shield.isOf(BSItems.GILDED_PATCHWORK_SHIELD);
                if ((isPatchworkShield || isGildedPatchworkShield)) {
                    // Perk
                    float perkChance = isGildedPatchworkShield ? 0.5f : 0.25f;
                    if (randomChance < perkChance && attacker instanceof LivingEntity livingAttacker) {
                        livingAttacker.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10 * 20, 0, false, false));
                    }
                }

                // Skull Shields
                boolean isSkullShield = shield.isOf(BSItems.SKULL_SHIELD);
                boolean isGildedSkullShield = shield.isOf(BSItems.GILDED_SKULL_SHIELD);
                if ((isSkullShield || isGildedSkullShield)) {
                    // Perk
                    float perkChance = isGildedPatchworkShield ? 0.25f : 0.15f;
                    if (randomChance < perkChance && attacker instanceof MobEntity mob) {
                        setNearestTarget(mob, player);

                    }

                    // Weakness
                    float weaknessChance = isGildedPatchworkShield ? 0.15f : 0.35f;
                    if (randomChance < weaknessChance) {
                        //player.damageShield(blockedDamage.get() * 3);
                    }
                }

                // Biomass Shields
                boolean isBiomassShield = shield.isOf(BSItems.BIOMASS_SHIELD);
                boolean isGildedBiomassShield = shield.isOf(BSItems.GILDED_BIOMASS_SHIELD);
                if ((isBiomassShield || isGildedBiomassShield)) {
                    // Perk
                    if (randomChance < 0.45) {
                        float healthToRestore = blockedDamage.get() * 0.30f;
                        entity.heal(healthToRestore);
                    }

                    // Weakness
                    if (randomChanceE < 0.15) {
                        float damagePercentage = isGildedBiomassShield ? 0.2f : 0.4f;
                        float healthToDamage = blockedDamage.get() - (blockedDamage.get() * damagePercentage);
                        // player.damageShield(healthToDamage);
                    }
                }

                // Livingmetal Shields
                boolean isLivingmetalShield = shield.isOf(BSItems.LIVINGMETAL_SHIELD);
                boolean isGildedLivingmetalShield = shield.isOf(BSItems.GILDED_LIVINGMETAL_SHIELD);
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

                        if (player.experienceLevel >= xpToUse && entity.getMaxHealth() - 2 > player.getHealth()) {
                            entity.heal(healthToHeal);
                            player.addExperienceLevels(-xpToUse);
                        }
                    }
                }

                ShieldMechanics.blockedDamage.remove();
            }
        });
    }

    private static void setNearestTarget(MobEntity mob, PlayerEntity blockingPlayer) {
        double SEARCH_RANGE = 16.0;
        World level = mob.getWorld();
        Box boundingBox = new Box(
                mob.getX() - SEARCH_RANGE, mob.getY() - SEARCH_RANGE, mob.getZ() - SEARCH_RANGE,
                mob.getX() + SEARCH_RANGE, mob.getY() + SEARCH_RANGE, mob.getZ() + SEARCH_RANGE
        );

        // Find entities in the bounding box
        LivingEntity nearestEntity = null;
        double nearestDistance = Double.MAX_VALUE;

        for (Entity entity : level.getOtherEntities(mob, boundingBox, e -> e instanceof LivingEntity && !e.equals(blockingPlayer))) {
            if (entity instanceof LivingEntity livingEntity) {
                double distance = mob.distanceTo(livingEntity);
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestEntity = livingEntity;
                }
            }
        }

        mob.setTarget(nearestEntity);
    }
}
