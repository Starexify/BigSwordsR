package net.nova.big_swords;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
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

    pack.addProvider(BSTrimMaterials::new);
    pack.addProvider(BSEnchantments::new);

    pack.addProvider(BSRecipeProvider::new);
    pack.addProvider(AtlasesProvider::new);
    pack.addProvider(SoundsProvider::new);

    pack.addProvider(BlockLootTables::new);

    pack.addProvider((output, registries) ->
        new AdvancementProvider(output, registries, List.of(
            new BigSwordsAdvancements()
        )));
  }
}
