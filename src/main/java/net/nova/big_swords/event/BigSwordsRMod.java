package net.nova.big_swords.event;

import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.nova.big_swords.init.BSAttributes;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class BigSwordsRMod {
    @SubscribeEvent
    public static void attributeModificationEvent(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, BSAttributes.CHARGED_DAMAGE);
    }
}
