package net.nova.big_swords.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Unit;
import net.minecraft.util.context.ContextKeySet;
import net.minecraft.world.item.enchantment.TargetedConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.storage.loot.Validatable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSDataComponents {
  public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MODID);

  public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> BLOOD_LEVEL = COMPONENTS.registerComponentType(
      "blood_level", b -> b
          .persistent(ExtraCodecs.intRange(0, 9))
          .networkSynchronized(ByteBufCodecs.VAR_INT)
  );

  public static final DeferredHolder<DataComponentType<?>, DataComponentType<Unit>> DEGRADES_UNDERWATER = COMPONENTS.registerComponentType(
      "degrades_underwater", b -> b.persistent(Unit.CODEC)
  );

  public static final DeferredRegister.DataComponents ENCHANTMENT_COMPONENTS = DeferredRegister.createDataComponents(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, MODID);

  public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<TargetedConditionalEffect<EnchantmentEntityEffect>>>> POST_DEATH = ENCHANTMENT_COMPONENTS.registerComponentType(
      "post_death",
      b -> b.persistent(validatedListCodec(TargetedConditionalEffect.codec(EnchantmentEntityEffect.CODEC), LootContextParamSets.ENCHANTED_DAMAGE))
  );

  private static <T extends Validatable> Codec<List<T>> validatedListCodec(Codec<T> elementCodec, ContextKeySet paramSet) {
    return elementCodec.listOf().validate(Validatable.listValidatorForContext(paramSet));
  }
}