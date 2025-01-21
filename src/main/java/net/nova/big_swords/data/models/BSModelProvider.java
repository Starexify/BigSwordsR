package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSModelProvider extends ModelProvider {
    public BSModelProvider(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        new BSBlockModelGenerator(blockModels.blockStateOutput, itemModels.itemModelOutput, blockModels.modelOutput).run();
        new BSItemModelGenerator(itemModels.itemModelOutput, itemModels.modelOutput).run();
    }
}
