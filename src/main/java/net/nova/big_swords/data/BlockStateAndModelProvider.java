package net.nova.big_swords.data;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;

public class BlockStateAndModelProvider {
/*    protected void registerStatesAndModels() {
        normalBlock(BSBlocks.LIVINGMETAL_BLOCK.get());
        normalBlock(BSBlocks.BIOMASS_BLOCK.get());

        creepBlock(BSBlocks.CREEP_BLOCK.get());

        biomassCrop(BSBlocks.BIOMASS.get(), BlockStateProperties.AGE_3, 0, 1, 2, 3);
    }

    public void biomassCrop(Block pCropBlock, IntegerProperty pAgeProperty, int... pAgeToVisualStageMapping) {
        if (pAgeProperty.getPossibleValues().size() != pAgeToVisualStageMapping.length) {
            throw new IllegalArgumentException("Number of ages and visual stages must match");
        }

        getVariantBuilder(pCropBlock).forAllStates(state -> {
            int age = state.getValue(pAgeProperty);
            String stageName = "stage" + pAgeToVisualStageMapping[age];
            return ConfiguredModel.builder()
                    .modelFile(models().cross(name(pCropBlock) + "_" + stageName, modLoc("block/" + name(pCropBlock) + "_" + stageName)).renderType(RenderType.CUTOUT.name))
                    .build();
        });
    }

    public void normalBlock(Block block) {
        simpleBlock(block, models().cubeAll(name(block), modLoc("block/" + name(block))));
    }

    public void creepBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean tilled = state.getValue(CreepBlock.TILLED);
            String topTexture = tilled ? "block/" + name(block) + "_top_tilled" : "block/" + name(block) + "_top";

            ModelFile model = models().getBuilder(name(block) + (tilled ? "_tilled" : ""))
                    .parent(models().getExistingFile(mcLoc("block/cube_bottom_top")))
                    .texture("bottom", mcLoc("block/soul_sand"))
                    .texture("side", "block/" + name(block) + "_side")
                    .texture("top", topTexture);

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .build();
        });
    }

    // Other stuff
    public ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    public String name(Block block) {
        return key(block).getPath();
    }*/
}
