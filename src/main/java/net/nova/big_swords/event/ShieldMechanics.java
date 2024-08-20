package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
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

@EventBusSubscriber(modid = MODID)
public class ShieldMechanics {

    @SubscribeEvent
    public static void onShieldBlock(LivingShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack shield = player.getUseItem();
            Entity sourceEntity = event.getDamageSource().getDirectEntity();
            DamageSource damageSource = event.getDamageSource();

            // Wooden Shields
            boolean isWoodenShield = shield.is(BSItems.WOODEN_SHIELD);
            boolean isGildedWoodenShield = shield.is(BSItems.GILDED_WOODEN_SHIELD);
            if ((isWoodenShield || isGildedWoodenShield) && damageSource.is(DamageTypes.ARROW) && event.getBlocked()) {
                if (sourceEntity instanceof Arrow arrow) {
                    // Weakness
                    if (arrow.isOnFire()) {
                        event.setShieldDamage(event.shieldDamage() * 4);
                    }

                    // Perk
                    if (isGildedWoodenShield || Math.random() < 0.5) {
                        arrow.remove(Entity.RemovalReason.DISCARDED);

                        ItemStack arrowStack = new ItemStack(Items.ARROW);
                        if (!player.getInventory().add(arrowStack)) {
                            player.drop(arrowStack, false);
                        }
                    }
                }
            }

            // Stone Shields
            boolean isStoneShield = shield.is(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = shield.is(BSItems.GILDED_STONE_SHIELD);
            if (isStoneShield || isGildedStoneShield) {

                // Weakness
                if (event.getDamageSource().is(DamageTypes.EXPLOSION) || event.getDamageSource().is(DamageTypes.PLAYER_EXPLOSION)) {
                    event.setBlocked(false);

                    player.sendSystemMessage(Component.literal("Blocked explosion? " + event.getBlocked())); // Debug
                }

            }

        }
    }
}
