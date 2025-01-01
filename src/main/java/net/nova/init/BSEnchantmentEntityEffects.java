package net.nova.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.nova.BigSwordsR;
import net.nova.enchantments.effects.SoulStealEffect;

public class BSEnchantmentEntityEffects {
    public static MapCodec<SoulStealEffect> SOUL_STEAL = register("soul_steal", SoulStealEffect.CODEC);

    public static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, BigSwordsR.rl(id), codec);
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Enchantment Effects");
    }
}
