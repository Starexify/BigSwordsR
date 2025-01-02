package net.nova;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.nova.init.BSItems;

import java.util.Random;

public class ShieldMechanics {

    public static void register() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, damageSource, baseDamageTaken, damageTaken, blocked) -> {
            if (entity instanceof PlayerEntity player && player.isBlocking()) {
                ItemStack shield = player.getBlockingItem();
                Entity attacker = damageSource.getAttacker();
                Entity sourceEntity = damageSource.getSource();
                double randomChance = Math.random();
                double randomChanceE = Math.random();
                Random random = new Random();
                World level = player.getWorld();

                boolean isWoodenShield = shield.isOf(BSItems.WOODEN_SHIELD);
                boolean isGildedWoodenShield = shield.isOf(BSItems.GILDED_WOODEN_SHIELD);
                if ((isWoodenShield || isGildedWoodenShield)) {
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
                            player.damageShield(baseDamageTaken * 4);
                            shield.damage((int) (baseDamageTaken * 4), player);
                        }
                    }
                }

            }
        });
    }
}
