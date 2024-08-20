package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        if (event.getEntity() instanceof Player player) {
            ItemStack shield = player.getUseItem();
            Entity sourceEntity = event.getDamageSource().getDirectEntity();
            DamageSource damageSource = event.getDamageSource();
            float blockedDamage = event.getBlockedDamage();

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
                        event.setShieldDamage(event.shieldDamage() * 4);
                    }
                }
            }

            // Stone Shields
            boolean isStoneShield = shield.is(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = shield.is(BSItems.GILDED_STONE_SHIELD);
            if (isStoneShield || isGildedStoneShield) {

                player.sendSystemMessage(Component.literal("On fire: " + damageSource.is(DamageTypes.ON_FIRE))); // Debug
                player.sendSystemMessage(Component.literal("In fire: " + damageSource.is(DamageTypes.IN_FIRE))); // Debug
                player.sendSystemMessage(Component.literal("FIREBALL: " + damageSource.is(DamageTypes.FIREBALL))); // Debug
                player.sendSystemMessage(Component.literal("UNATTRIBUTED FIREBALL: " + damageSource.is(DamageTypes.UNATTRIBUTED_FIREBALL))); // Debug

                // Perk
                if (sourceEntity instanceof Arrow arrow && event.getBlocked()) {
                    event.setShieldDamage(0);
                    if (arrow.isOnFire()) {
                        arrow.remove(Entity.RemovalReason.DISCARDED);
                    }

                    player.sendSystemMessage(Component.literal("Shield Damage: " + event.shieldDamage())); // Debug
                    playSound(player.level(), player, SoundEvents.FIRE_EXTINGUISH);

                    // Weakness
                } else if (damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION)) {
                    float damageToPlayer = blockedDamage / 3;
                    event.setBlockedDamage(blockedDamage - damageToPlayer);
                    event.setShieldDamage(event.shieldDamage() + damageToPlayer);
                }
            }

        }
    }
}
