package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
            Entity sourceEntity = event.getDamageSource().getDirectEntity();
            DamageSource damageSource = event.getDamageSource();
            float blockedDamage = event.getBlockedDamage();
            float shieldDamage = event.shieldDamage();

            // Wooden Shields
            boolean isWoodenShield = shield.is(BSItems.WOODEN_SHIELD);
            boolean isGildedWoodenShield = shield.is(BSItems.GILDED_WOODEN_SHIELD);
            if ((isWoodenShield || isGildedWoodenShield) && damageSource.is(DamageTypes.ARROW) && event.getBlocked()) {
                if (sourceEntity instanceof Arrow arrow) {
                    // Perk
                    if (isGildedWoodenShield || Math.random() < 0.5) {
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
            if (isStoneShield || isGildedStoneShield) {
                // Perk
                if (event.getBlocked()) {
                    if (sourceEntity instanceof Fireball || (sourceEntity instanceof Arrow arrow && arrow.isOnFire())) {
                        event.setShieldDamage(0);
                        sourceEntity.remove(Entity.RemovalReason.DISCARDED);
                        playSound(player.level(), player, SoundEvents.FIRE_EXTINGUISH);
                    }
                }

                // Weakness
                if ((damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION)) && event.getBlocked()) {
                    float damageToPlayer = blockedDamage / 3;
                    event.setBlockedDamage(blockedDamage - damageToPlayer);
                    event.setShieldDamage(event.shieldDamage() + damageToPlayer);
                }
            }

            // Iron Shields
            boolean isIronShield = shield.is(BSItems.IRON_SHIELD);
            boolean isGildedIronShield = shield.is(BSItems.GILDED_IRON_SHIELD);
            if (isIronShield || isGildedIronShield) {
                // Perk
                if ((damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION)) && event.getBlocked()) {
                    if (isIronShield) {
                        event.setShieldDamage(shieldDamage / 2);
                    } else {
                        event.setShieldDamage(0);
                    }
                }
            }

            boolean isDiamondShield = shield.is(BSItems.IRON_SHIELD);
            boolean isGildedDiamondShield = shield.is(BSItems.GILDED_IRON_SHIELD);
            if (isDiamondShield || isGildedDiamondShield) {

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
