package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.nova.big_swords.init.BSBlocks;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlockTagsProvider extends BlockTagsProvider {
    public BSBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BSBlocks.LIVINGMETAL_BLOCK.getKey());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BSBlocks.CREEP_BLOCK.getKey());
        tag(BlockTags.MINEABLE_WITH_HOE).add(BSBlocks.BIOMASS_BLOCK.getKey());

        tag(BlockTags.NEEDS_IRON_TOOL).add(BSBlocks.LIVINGMETAL_BLOCK.getKey());

        tag(BlockTags.SOUL_SPEED_BLOCKS).add(BSBlocks.CREEP_BLOCK.getKey());
        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(BSBlocks.CREEP_BLOCK.getKey());

        tag(BlockTags.BEACON_BASE_BLOCKS).add(BSBlocks.LIVINGMETAL_BLOCK.getKey());
    }
}
