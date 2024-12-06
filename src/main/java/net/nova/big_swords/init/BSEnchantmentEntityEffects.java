package net.nova.big_swords.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.enchantments.effects.SoulStealEffect;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSEnchantmentEntityEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_EFFECT = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> SOUL_STEAL = ENTITY_EFFECT.register("soul_steal", () -> SoulStealEffect.CODEC);
}
