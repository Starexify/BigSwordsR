package net.nova.big_swords.init;

import net.minecraft.component.ComponentType;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.TargetedEnchantmentEffect;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.dynamic.Codecs;
import net.nova.big_swords.BigSwordsR;

import java.util.List;
import java.util.function.UnaryOperator;

public class BSDataComponents {
    public static final ComponentType<Integer> BLOOD_LEVEL = register(
            "blood_level", builder -> builder.codec(Codecs.rangedInt(0, 9)).packetCodec(PacketCodecs.VAR_INT)
    );

    public static final ComponentType<List<TargetedEnchantmentEffect<EnchantmentEntityEffect>>> POST_DEATH = registerEnchantment("post_death", (builder) -> builder.codec(TargetedEnchantmentEffect.createPostAttackCodec(EnchantmentEntityEffect.CODEC, LootContextTypes.ENCHANTED_DAMAGE).listOf()));

    // Registers
    public static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, BigSwordsR.rl(name), builderOperator.apply(ComponentType.builder()).build());
    }

    public static <T> ComponentType<T> registerEnchantment(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, id, builderOperator.apply(ComponentType.builder()).build());
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Data Components");
    }
}
