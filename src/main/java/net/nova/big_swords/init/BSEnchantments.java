package net.nova.big_swords.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.enchantments.effects.SoulStealEffect;

public interface BSEnchantments {
  MapCodec<SoulStealEffect> SOUL_STEAL = register("soul_steal", SoulStealEffect.CODEC);

  static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
    return Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, BigSwordsR.rl(id), codec);
  }

  static void initialize() {
    BigSwordsR.LOGGER.info("Registering Enchantment Effects");
  }
}
