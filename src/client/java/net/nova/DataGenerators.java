package net.nova;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.nova.data.BSEnchantments;
import net.nova.data.BSTrimMaterials;
import net.nova.data.LangProvider;
import net.nova.data.tags.BSBlockTagsProvider;
import net.nova.data.tags.BSEnchantmentTagsProvider;
import net.nova.data.tags.BSEntityTypeTagsProvider;
import net.nova.data.tags.BSItemTagsProvider;

public class DataGenerators implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

/*
		event.addProvider(new BSModelProvider(output));
		event.addProvider(new BSEquipmentModelProvider(output));

		event.addProvider(new BSRecipeProvider.Runner(output, lookupProvider));*/

        pack.addProvider(LangProvider::new);

        pack.addProvider(BSBlockTagsProvider::new);
        pack.addProvider(BSItemTagsProvider::new);
        pack.addProvider(BSEntityTypeTagsProvider::new);
        pack.addProvider(BSEnchantmentTagsProvider::new);

        pack.addProvider(BSTrimMaterials::new);
        pack.addProvider(BSEnchantments::new);

		/*
		event.addProvider(new BSLootTableProvider(output, lookupProvider));

		event.addProvider(new BSDataMapProvider(output, lookupProvider));

		event.addProvider(new SoundsProvider(output));

		event.addProvider(BSAdvancementsProvider.create(output, lookupProvider));

		event.addProvider(new GlobalLootModifier(output, lookupProvider));

		event.addProvider(new DatapackProvider(output, lookupProvider));

		event.addProvider(new AtlasesProvider(output, lookupProvider));*/
    }


}
