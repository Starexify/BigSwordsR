package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.nova.big_swords.init.BSEnchantmentEffects;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSEnchantmentTagsProvider extends FabricTagsProvider<Enchantment> {
  public BSEnchantmentTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
    super(output, Registries.ENCHANTMENT, registryLookupFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    builder(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(BSEnchantmentEffects.SOUL_STEALER);
    builder(Tags.EnchantmentTags.SCYTHE_EXCLUSIVE).addOptional(BSEnchantmentEffects.SOUL_STEALER);
  }
}
