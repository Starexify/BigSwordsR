package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.nova.big_swords.init.BSBlocks;

import java.util.concurrent.CompletableFuture;

public class BSBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
  public BSBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    builder(BlockTags.MINEABLE_WITH_PICKAXE).add(BSBlocks.LIVINGMETAL_BLOCK.getSecond());
    builder(BlockTags.MINEABLE_WITH_SHOVEL).add(BSBlocks.CREEP_BLOCK.getSecond());
    builder(BlockTags.MINEABLE_WITH_HOE).add(BSBlocks.BIOMASS_BLOCK.getSecond());

    builder(BlockTags.NEEDS_IRON_TOOL).add(BSBlocks.LIVINGMETAL_BLOCK.getSecond());

    builder(BlockTags.SOUL_SPEED_BLOCKS).add(BSBlocks.CREEP_BLOCK.getSecond());
    builder(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(BSBlocks.CREEP_BLOCK.getSecond());

    builder(BlockTags.BEACON_BASE_BLOCKS).add(BSBlocks.LIVINGMETAL_BLOCK.getSecond());
  }
}
