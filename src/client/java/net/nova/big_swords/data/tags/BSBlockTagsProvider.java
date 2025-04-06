package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.nova.big_swords.init.BSBlocks;

import java.util.concurrent.CompletableFuture;

public class BSBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public BSBlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(BSBlocks.LIVINGMETAL_BLOCK);
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(BSBlocks.CREEP_BLOCK);
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE).add(BSBlocks.BIOMASS_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(BSBlocks.LIVINGMETAL_BLOCK);

        getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS).add(BSBlocks.CREEP_BLOCK);
        getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(BSBlocks.CREEP_BLOCK);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(BSBlocks.LIVINGMETAL_BLOCK);
    }
}
