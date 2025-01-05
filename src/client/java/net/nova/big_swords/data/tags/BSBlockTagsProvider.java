package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nova.big_swords.init.BSBlocks;

import java.util.concurrent.CompletableFuture;

public class BSBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public BSBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(BSBlocks.LIVINGMETAL_BLOCK);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(BSBlocks.CREEP_BLOCK);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(BSBlocks.BIOMASS_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(BSBlocks.LIVINGMETAL_BLOCK);

        getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS).add(BSBlocks.CREEP_BLOCK);
        getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(BSBlocks.CREEP_BLOCK);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(BSBlocks.LIVINGMETAL_BLOCK);
    }
}
