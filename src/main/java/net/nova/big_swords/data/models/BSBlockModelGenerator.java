package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@OnlyIn(Dist.CLIENT)
public class BSBlockModelGenerator extends BlockModelGenerators {
    public BSBlockModelGenerator(Consumer<BlockStateGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    @Override
    public void run() {
        createTrivialCube(BSBlocks.CREEP_BLOCK.get());
        createTrivialCube(BSBlocks.LIVINGMETAL_BLOCK.get());
        createTrivialCube(BSBlocks.BIOMASS_BLOCK.get());
        createCropBlock(BSBlocks.BIOMASS.get(), BlockStateProperties.AGE_3, 0, 1, 2, 3);
    }

    public void createCreepBlock() {
        TextureMapping texturemapping = new TextureMapping()
                .put(TextureSlot.DIRT, TextureMapping.getBlockTexture(Blocks.NETHERRACK))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.FARMLAND));
        TextureMapping texturemapping1 = new TextureMapping()
                .put(TextureSlot.DIRT, TextureMapping.getBlockTexture(Blocks.NETHERRACK))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK.get(), "_tilled"));
        ResourceLocation resourcelocation = ModelTemplates.FARMLAND.create(BSBlocks.CREEP_BLOCK.get(), texturemapping, modelOutput);
        ResourceLocation resourcelocation1 = ModelTemplates.FARMLAND
                .create(TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK.get(), "_tilled"), texturemapping1, modelOutput);

        this.blockStateOutput
                .accept(
                        MultiVariantGenerator.multiVariant(BSBlocks.CREEP_BLOCK.get()).with(PropertyDispatch.property(CreepBlock.TILLED).select(
                                false, Variant.variant().with(VariantProperties.MODEL, TexturedModel.CUBE_TOP_BOTTOM.create(BSBlocks.CREEP_BLOCK.get(), modelOutput))
                        ).select(true,
                                Variant.variant().with(
                                        VariantProperties.MODEL, TexturedModel.CUBE_TOP_BOTTOM
                                                .get(BSBlocks.CREEP_BLOCK.get())
                                                .updateTextures(p_386917_ -> p_386917_.put(TextureSlot.TOP, resourcelocation))
                                                .createWithSuffix(BSBlocks.CREEP_BLOCK.get(), "_tilled", modelOutput)
                                )))
                );
    }
}
