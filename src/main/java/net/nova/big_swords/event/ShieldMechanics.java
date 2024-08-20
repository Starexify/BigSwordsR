package net.nova.big_swords.event;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.nova.big_swords.init.BSItems;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID)
public class ShieldMechanics {

    // Shield Mechanics

    // Stone
    @SubscribeEvent
    public static void onShieldBlock(LivingShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player) {

            // Stone Mechanic
            if (player.getUseItem().is(BSItems.STONE_SHIELD)) {
                if (event.getDamageSource().is(DamageTypes.EXPLOSION) || event.getDamageSource().is(DamageTypes.PLAYER_EXPLOSION)) {

                    float blockedDamage = event.getBlockedDamage();
                    float damageToPlayer = blockedDamage / 3;
                    event.setBlockedDamage(blockedDamage - damageToPlayer);
                    event.setShieldDamage(event.shieldDamage() + damageToPlayer);
                    // player.sendSystemMessage(Component.literal("Dealt damage to Entity" + damageToPlayer)); // Debug
                }
            }
        }
    }
}
