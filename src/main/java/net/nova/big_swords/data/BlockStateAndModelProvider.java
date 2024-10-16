package net.nova.big_swords.data;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BlockStateAndModelProvider extends BlockStateProvider {
    public BlockStateAndModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlock(BSBlocks.LIVINGMETAL_BLOCK.get());
        normalBlock(BSBlocks.BIOMASS_BLOCK.get());

        creepBlock(BSBlocks.CREEP_BLOCK.get());

        biomassCrop(BSBlocks.BIOMASS.get(), BlockStateProperties.AGE_3, 0, 1, 2, 3);
    }

    private void biomassCrop(Block pCropBlock, IntegerProperty pAgeProperty, int... pAgeToVisualStageMapping) {
        if (pAgeProperty.getPossibleValues().size() != pAgeToVisualStageMapping.length) {
            throw new IllegalArgumentException("Number of ages and visual stages must match");
        }

        getVariantBuilder(pCropBlock)
                .forAllStates(state -> {
                    int age = state.getValue(pAgeProperty);
                    String stageName = "stage" + pAgeToVisualStageMapping[age];
                    return ConfiguredModel.builder()
                            .modelFile(models().cross(name(pCropBlock) + "_" + stageName, modLoc("block/" + name(pCropBlock) + "_" + stageName)).renderType(RenderType.CUTOUT.name))
                            .build();
                });

        itemModels().getBuilder(name(pCropBlock))
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", modLoc("item/" + name(pCropBlock)));
    }

    private void normalBlock(Block block) {
        simpleBlockWithItem(block, models().cubeAll(name(block), modLoc("block/" + name(block))));
    }

    private void creepBlock(Block block) {
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

        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + name(block))));
    }

    // Other stuff
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }
}
