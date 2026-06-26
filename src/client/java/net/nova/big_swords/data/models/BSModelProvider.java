package net.nova.big_swords.data.models;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class BSModelProvider extends FabricModelProvider {
  public BSModelProvider(FabricPackOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators blockModels) {
    new BSBlockModelGenerator(blockModels.blockStateOutput, blockModels.itemModelOutput, blockModels.modelOutput).run();
  }

  @Override
  public void generateItemModels(ItemModelGenerators itemModels) {
    new BSItemModelGenerator(itemModels.itemModelOutput, itemModels.modelOutput).run();
  }
}
