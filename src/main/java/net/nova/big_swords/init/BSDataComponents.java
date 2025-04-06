package net.nova.big_swords.init;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.enchantment.TargetedConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.nova.big_swords.BigSwordsR;

import java.util.List;
import java.util.function.UnaryOperator;

public class BSDataComponents {
    public static final DataComponentType<Integer> BLOOD_LEVEL = register(
            "blood_level", builder -> builder.persistent(ExtraCodecs.intRange(0, 9)).networkSynchronized(ByteBufCodecs.VAR_INT));

    public static final DataComponentType<List<TargetedConditionalEffect<EnchantmentEntityEffect>>> POST_DEATH = registerEnchantment(
            "post_death", builder -> builder.persistent(TargetedConditionalEffect.codec(EnchantmentEntityEffect.CODEC, LootContextParamSets.ENCHANTED_DAMAGE).listOf()));

    // Registers
    public static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, BigSwordsR.rl(name), builderOperator.apply(DataComponentType.builder()).build());
    }

    public static <T> DataComponentType<T> registerEnchantment(String id, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, id, builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Data Components");
    }
}
