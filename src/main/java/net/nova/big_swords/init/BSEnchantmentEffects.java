package net.nova.big_swords.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.enchantments.effects.SoulStealEffect;

public class BSEnchantmentEffects {
    public static final RegistryKey<Enchantment> SOUL_STEALER = of("soul_stealer");
    public static MapCodec<SoulStealEffect> SOUL_STEAL = register("soul_steal", SoulStealEffect.CODEC);

    public static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, BigSwordsR.rl(id), codec);
    }

    public static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, BigSwordsR.rl(id));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Enchantment Effects");
    }
}
