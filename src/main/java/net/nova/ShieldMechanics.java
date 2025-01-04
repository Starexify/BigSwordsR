package net.nova;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.nova.init.BSItems;

public class ShieldMechanics {
    public static final ThreadLocal<Integer> blockedDamage = new ThreadLocal<>();

    public static void register() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, damageSource, baseDamageTaken, damageTaken, blocked) -> {
            if (entity instanceof PlayerEntity player && player.isBlocking()) {
                ItemStack shield = player.getBlockingItem();
                Entity attacker = damageSource.getAttacker();
                Entity sourceEntity = damageSource.getSource();
                double randomChance = Math.random();
                if (blockedDamage.get() == null) blockedDamage.set(0);

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
                            player.sendMessage(Text.literal("Took damage" + blockedDamage.get()), false);
                            player.damageShield(blockedDamage.get() * 4);
                            //player.blockedByShield(damageSource);
                            player.sendMessage(Text.literal("Took damage" + blockedDamage.get()), false);
                        }
                    }
                }

            }
        });
    }
}
