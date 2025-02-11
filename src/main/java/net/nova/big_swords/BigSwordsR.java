package net.nova.big_swords;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.nova.big_swords.init.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.nova.big_swords.BigSwordsR.MODID;

@Mod(MODID)
public class BigSwordsR {
    public static final String MODID = "big_swords";
    public static final Logger logger = LoggerFactory.getLogger(BigSwordsR.class);

    public BigSwordsR(IEventBus bus) {
        Sounds.SOUND_EVENTS.register(bus);
        BSEnchantmentEntityEffects.ENTITY_EFFECT.register(bus);
        BSAttributes.ATTRIBUTES.register(bus);
        BSDataComponents.COMPONENTS.register(bus);
        BSDataComponents.ENCHANTMENT_COMPONENTS.register(bus);
        BSItems.ITEMS.register(bus);
        BSBlocks.BLOCKS.register(bus);
        CreativeTab.CREATIVE_TAB.register(bus);
        BSLootModifier.LOOT_MODIFIERS.register(bus);
    }

    // Util
    public static void playSound(Level level, Player player, SoundEvent sound) {
        if (!player.level().isClientSide) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }

    public static void playSound(Level level, LivingEntity livingEntity, SoundEvent sound) {
        if (!livingEntity.level().isClientSide) {
            level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static double getModifierValue(List<ItemAttributeModifiers.Entry> modifiers, ResourceLocation modifierId) {
        return modifiers.stream()
                .filter(entry -> entry.modifier().is(modifierId))
                .mapToDouble(entry -> entry.modifier().amount())
                .findFirst().orElse(0.0);
    }
}
