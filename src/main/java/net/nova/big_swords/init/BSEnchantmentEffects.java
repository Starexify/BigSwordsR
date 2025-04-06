package net.nova.big_swords.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.enchantments.effects.SoulStealEffect;

public class BSEnchantmentEffects {
    public static final ResourceKey<Enchantment> SOUL_STEALER = of("soul_stealer");
    public static MapCodec<SoulStealEffect> SOUL_STEAL = register("soul_steal", SoulStealEffect.CODEC);

    public static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, BigSwordsR.rl(id), codec);
    }

    public static ResourceKey<Enchantment> of(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, BigSwordsR.rl(id));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Enchantment Effects");
    }
}
