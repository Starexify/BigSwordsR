package net.nova.big_swords;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementProvider;
import net.nova.big_swords.data.*;
import net.nova.big_swords.data.advancement.BigSwordsAdvancements;
import net.nova.big_swords.data.loot.BlockLootTables;
import net.nova.big_swords.data.models.BSEquipmentModelProvider;
import net.nova.big_swords.data.models.BSModelProvider;
import net.nova.big_swords.data.recipe.BSRecipeProvider;
import net.nova.big_swords.data.tags.BSBlockTagsProvider;
import net.nova.big_swords.data.tags.BSEnchantmentTagsProvider;
import net.nova.big_swords.data.tags.BSEntityTypeTagsProvider;
import net.nova.big_swords.data.tags.BSItemTagsProvider;
import net.nova.big_swords.equipment.BSTrimMaterials;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataGenerators implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(LangProvider::new);

    pack.addProvider(BSModelProvider::new);
    pack.addProvider(BSEquipmentModelProvider::new);

    pack.addProvider(BSBlockTagsProvider::new);
    pack.addProvider(BSItemTagsProvider::new);
    pack.addProvider(BSEntityTypeTagsProvider::new);
    pack.addProvider(BSEnchantmentTagsProvider::new);

    pack.addProvider(BSRecipeProvider::new);
    pack.addProvider(AtlasesProvider::new);
    pack.addProvider(SoundsProvider::new);

    pack.addProvider(BlockLootTables::new);

    pack.addProvider((output, registries) ->
        new AdvancementProvider(output, registries, List.of(
            new BigSwordsAdvancements()
        ))
    );

    pack.addProvider(BSRDynamicRegistry::new);
  }

  @Override
  public void buildRegistry(RegistrySetBuilder registryBuilder) {
    registryBuilder.add(Registries.TRIM_MATERIAL, BSTrimMaterials::bootstrap);
    registryBuilder.add(Registries.ENCHANTMENT, BSEnchantments::bootstrap);
  }

  static class BSRDynamicRegistry extends FabricDynamicRegistryProvider {
    public BSRDynamicRegistry(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
      super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
      entries.addAll(registries.lookupOrThrow(Registries.ENCHANTMENT));
      entries.addAll(registries.lookupOrThrow(Registries.TRIM_MATERIAL));
    }

    @Override
    public String getName() {
      return "BSR DynamicRegistry";
    }
  }
}
