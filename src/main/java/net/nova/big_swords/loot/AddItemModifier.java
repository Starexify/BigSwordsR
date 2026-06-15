package net.nova.big_swords.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
  public static Supplier<MapCodec<AddItemModifier>> CODEC = Suppliers.memoize(() ->
      RecordCodecBuilder.mapCodec(instance -> AddItemModifier.codecStart(instance)
          .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(instance2 -> instance2.item))
          .apply(instance, AddItemModifier::new)));

  public final Item item;

  public AddItemModifier(LootItemCondition[] conditionsIn, int priority, Item item) {
    super(conditionsIn, priority);
    this.item = item;
  }

  @Override
  protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
    for (LootItemCondition condition : this.conditions) {
      if (!condition.test(context)) return generatedLoot;
    }

    generatedLoot.add(new ItemStack(this.item));
    return generatedLoot;
  }

  @Override
  public MapCodec<? extends IGlobalLootModifier> codec() {
    return CODEC.get();
  }
}
