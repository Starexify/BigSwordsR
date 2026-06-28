package net.nova.big_swords.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.enchantments.effects.SoulStealEffect;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

public class BSEnchantments {
  public static final ResourceKey<Enchantment> SOUL_STEALER = key("soul_stealer");

  public static void bootstrap(final BootstrapContext<Enchantment> context) {
    HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);
    HolderGetter<Item> items = context.lookup(Registries.ITEM);

    register(context, SOUL_STEALER, Enchantment.enchantment(Enchantment.definition(
            items.getOrThrow(Tags.BSItemTags.SCYTHES),
            2,
            3,
            Enchantment.dynamicCost(17, 8),
            Enchantment.dynamicCost(36, 8),
            3,
            EquipmentSlotGroup.MAINHAND
        ))
        .exclusiveWith(enchantments.getOrThrow(Tags.EnchantmentTags.SCYTHE_EXCLUSIVE))
        .withEffect(
            BSDataComponents.POST_DEATH,
            EnchantmentTarget.ATTACKER,
            EnchantmentTarget.VICTIM,
            new SoulStealEffect(LevelBasedValue.perLevel(0.3F), BSItems.SOUL.getFirst())
        ));
  }

  private static void register(final BootstrapContext<Enchantment> context, final ResourceKey<Enchantment> key, final Enchantment.Builder builder) {
    context.register(key, builder.build(key.identifier()));
  }

  private static ResourceKey<Enchantment> key(final String id) {
    return ResourceKey.create(Registries.ENCHANTMENT, BigSwordsR.rl(id));
  }
}
