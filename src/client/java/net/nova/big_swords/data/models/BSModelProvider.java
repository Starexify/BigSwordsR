package net.nova.big_swords.data.models;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class BSModelProvider extends FabricModelProvider {
    public BSModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        new BSBlockModelGenerator(blockStateModelGenerator.blockStateCollector, blockStateModelGenerator.itemModelOutput, blockStateModelGenerator.modelCollector).register();
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        new BSItemModelGenerator(itemModelGenerator.output, itemModelGenerator.modelCollector).register();
    }
}
