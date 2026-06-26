package net.nova.big_swords.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Unit;
import net.minecraft.util.context.ContextKeySet;
import net.minecraft.world.item.enchantment.TargetedConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.storage.loot.Validatable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.item.component.SpecialShield;

import java.util.List;
import java.util.function.UnaryOperator;

public class BSDataComponents {
  public static final DataComponentType<Integer> BLOOD_LEVEL = register(
      "blood_level", b -> b
          .persistent(ExtraCodecs.intRange(0, 9))
          .networkSynchronized(ByteBufCodecs.VAR_INT)
  );

  public static final DataComponentType<WeatheringCopper.WeatherState> OXIDATION_STATE = register(
      "oxidation_state", b -> b
          .persistent(WeatheringCopper.WeatherState.CODEC)
          .networkSynchronized(WeatheringCopper.WeatherState.STREAM_CODEC)
  );

  public static final DataComponentType<Boolean> WAXED = register(
      "waxed", b -> b.persistent(Codec.BOOL)
  );

  public static final DataComponentType<Unit> DEGRADES_UNDERWATER = register(
      "degrades_underwater", b -> b.persistent(Unit.CODEC)
  );

  public static final DataComponentType<SpecialShield> SPECIAL_SHIELD = register(
      "special_shield", b -> b.persistent(SpecialShield.CODEC).networkSynchronized(SpecialShield.STREAM_CODEC)
  );

  public static final DataComponentType<List<TargetedConditionalEffect<EnchantmentEntityEffect>>> POST_DEATH = registerEnchantment(
      "post_death", b -> b
          .persistent(validatedListCodec(TargetedConditionalEffect.codec(EnchantmentEntityEffect.CODEC), LootContextParamSets.ENCHANTED_DAMAGE))
  );

  private static <T extends Validatable> Codec<List<T>> validatedListCodec(Codec<T> elementCodec, ContextKeySet paramSet) {
    return elementCodec.listOf().validate(Validatable.listValidatorForContext(paramSet));
  }

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
