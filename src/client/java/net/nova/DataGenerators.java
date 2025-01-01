package net.nova;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.nova.data.*;
import net.nova.data.models.BSEquipmentModelProvider;
import net.nova.data.models.BSModelProvider;
import net.nova.data.recipe.BSRecipeProvider;
import net.nova.data.tags.BSBlockTagsProvider;
import net.nova.data.tags.BSEnchantmentTagsProvider;
import net.nova.data.tags.BSEntityTypeTagsProvider;
import net.nova.data.tags.BSItemTagsProvider;

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
		/*
		event.addProvider(new BSLootTableProvider(output, lookupProvider));

		event.addProvider(BSAdvancementsProvider.create(output, lookupProvider));

		event.addProvider(new GlobalLootModifier(output, lookupProvider));

		event.addProvider(new DatapackProvider(output, lookupProvider));*/
    }
}
