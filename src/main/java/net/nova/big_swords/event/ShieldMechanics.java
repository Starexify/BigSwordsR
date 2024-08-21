package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.nova.big_swords.init.BSItems;

import static net.nova.big_swords.BigSwordsR.MODID;
import static net.nova.big_swords.BigSwordsR.playSound;

@EventBusSubscriber(modid = MODID)
public class ShieldMechanics {

    @SubscribeEvent
    public static void onShieldBlock(LivingShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack shield = player.getUseItem();
            Entity attacker = event.getDamageSource().getEntity();
            Entity sourceEntity = event.getDamageSource().getDirectEntity();
            DamageSource damageSource = event.getDamageSource();
            float blockedDamage = event.getBlockedDamage();
            float shieldDamage = event.shieldDamage();
            double randomChance = Math.random();

            // Wooden Shields
            boolean isWoodenShield = shield.is(BSItems.WOODEN_SHIELD);
            boolean isGildedWoodenShield = shield.is(BSItems.GILDED_WOODEN_SHIELD);
            if ((isWoodenShield || isGildedWoodenShield) && damageSource.is(DamageTypes.ARROW) && event.getBlocked()) {
                if (sourceEntity instanceof Arrow arrow) {
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
                    if (arrow.isOnFire()) {
                        event.setShieldDamage(shieldDamage * 4);
                    }
                }
            }

            // Stone Shields
            boolean isStoneShield = shield.is(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = shield.is(BSItems.GILDED_STONE_SHIELD);
            if ((isStoneShield || isGildedStoneShield) && event.getBlocked()) {
                // Perk
                if (sourceEntity instanceof Fireball || (sourceEntity instanceof Arrow arrow && arrow.isOnFire())) {
                    event.setShieldDamage(0);
                    sourceEntity.remove(Entity.RemovalReason.DISCARDED);
                    playSound(player.level(), player, SoundEvents.FIRE_EXTINGUISH);
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
            if ((isIronShield || isGildedIronShield) && (damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION)) && event.getBlocked()) {
                // Perk
                if (isIronShield) {
                    event.setShieldDamage(shieldDamage / 2);
                } else if (isGildedIronShield) {
                    event.setShieldDamage(0);
                }
            }

            // Diamond Shields
            boolean isDiamondShield = shield.is(BSItems.DIAMOND_SHIELD);
            boolean isGildedDiamondShield = shield.is(BSItems.GILDED_DIAMOND_SHIELD);
            if ((isDiamondShield || isGildedDiamondShield) && event.getBlocked()) {
                float reflectChance = isGildedDiamondShield ? 0.75f : 0.5f;
                // Perk
                if (randomChance < reflectChance) {
                    if (sourceEntity instanceof Projectile originalProjectile && !(originalProjectile instanceof ThrownTrident)) {
                        boolean wasOnFire = originalProjectile.isOnFire();
                        originalProjectile.discard();
                        Projectile newProjectile = (Projectile) originalProjectile.getType().create(player.level());

                        if (newProjectile != null && attacker != null) {
                            newProjectile.setPos(player.getX(), originalProjectile.getY(), player.getZ());
                            newProjectile.setOwner(player);

                            if (wasOnFire) {
                                newProjectile.igniteForSeconds(100);
                            }

                            Vec3 directionToAttacker = attacker.position().subtract(player.position()).normalize();

                            float velocity = 1.0f;
                            newProjectile.shoot(directionToAttacker.x, directionToAttacker.y, directionToAttacker.z, velocity, 0.0f);

                            player.level().addFreshEntity(newProjectile);
                        }

                        // Weakness
                        event.setShieldDamage(shieldDamage * 4);
                    }
                }
            }

            // Netherite Shields
            boolean isNetheriteShield = shield.is(BSItems.NETHERITE_SHIELD);
            boolean isGildedNetheriteShield = shield.is(BSItems.GILDED_NETHERITE_SHIELD);
            if ((isNetheriteShield || isGildedNetheriteShield) && event.getBlocked()) {
                float damageToReflect = isGildedNetheriteShield ? blockedDamage * 0.5f : blockedDamage * 0.3f;
                float cooldownChance = isGildedNetheriteShield ? 0.1f : 0.15f;
                int cooldownTime = isGildedNetheriteShield ? 80 : 160;

                // Perk
                if (randomChance < 0.5 && attacker != null) {
                    attacker.hurt(damageSource, damageToReflect);

                    // Weakness
                    if (randomChance < cooldownChance) {
                        player.getCooldowns().addCooldown(shield.getItem(), cooldownTime);
                        player.stopUsingItem();
                    }
                }
            }
        }
    }

    // Iron Shield Weakness
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();

        if (player.level().isClientSide) return;

        ItemStack mainHandItem = player.getMainHandItem();
        ItemStack offHandItem = player.getOffhandItem();

        boolean isIronShieldInMainHand = mainHandItem.is(BSItems.IRON_SHIELD);
        boolean isGildedIronShieldInMainHand = mainHandItem.is(BSItems.GILDED_IRON_SHIELD);
        boolean isIronShieldInOffHand = offHandItem.is(BSItems.IRON_SHIELD);
        boolean isGildedIronShieldInOffHand = offHandItem.is(BSItems.GILDED_IRON_SHIELD);

        if (player.isInWater()) {
            if (isIronShieldInMainHand || isGildedIronShieldInMainHand) {
                decayItem(mainHandItem, player);
            }
            if (isIronShieldInOffHand || isGildedIronShieldInOffHand) {
                decayItem(offHandItem, player);
            }
        }
    }

    private static void decayItem(ItemStack itemStack, Player player) {
        if (!itemStack.isEmpty() && itemStack.isDamageableItem()) {
            if (itemStack.getDamageValue() < itemStack.getMaxDamage() - 1) {
                itemStack.hurtAndBreak(1, player, itemStack.getEquipmentSlot());
            }
        }
    }
}
