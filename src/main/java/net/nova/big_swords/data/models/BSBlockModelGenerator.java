package net.nova.big_swords.data.models;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BSBlockModelGenerator extends BlockModelGenerators {
    public BSBlockModelGenerator(Consumer<BlockStateGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    @Override
    public void run() {
        createCreepBlock();
        createTrivialCube(BSBlocks.LIVINGMETAL_BLOCK.get());
        createTrivialCube(BSBlocks.BIOMASS_BLOCK.get());
        createCrossCropBlock(BSBlocks.BIOMASS.get(), BlockStateProperties.AGE_3, 0, 1, 2, 3);
    }

    // Models
    public void createCrossCropBlock(Block cropBlock, Property<Integer> ageProperty, int... ageToVisualStageMapping) {
        if (ageProperty.getPossibleValues().size() != ageToVisualStageMapping.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<ResourceLocation> int2objectmap = new Int2ObjectOpenHashMap<>();
            PropertyDispatch propertydispatch = PropertyDispatch.property(ageProperty)
                    .generate(p_388091_ -> {
                        int i = ageToVisualStageMapping[p_388091_];
                        ResourceLocation resourcelocation = int2objectmap.computeIfAbsent(
                                i, p_387534_ -> this.createSuffixedVariant(cropBlock, "_stage" + i, ModelTemplates.CROSS.extend().renderType("cutout").build(), TextureMapping::cross)
                        );
                        return Variant.variant().with(VariantProperties.MODEL, resourcelocation);
                    });
            this.registerSimpleFlatItemModel(cropBlock.asItem());
            this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(cropBlock).with(propertydispatch));
        }
    }

    public void createCreepBlock() {
        TextureMapping normalMapping = new TextureMapping()
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK.get(), "_top"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.SOUL_SAND))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK.get(), "_side"));

        TextureMapping tilledMapping = new TextureMapping()
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK.get(), "_top_tilled"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.SOUL_SAND))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK.get(), "_side"));

        ResourceLocation normalModel = ModelTemplates.CUBE_BOTTOM_TOP.create(
                BSBlocks.CREEP_BLOCK.get(), normalMapping, this.modelOutput);
        ResourceLocation tilledModel = ModelTemplates.CUBE_BOTTOM_TOP.create(
                TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK.get(), "_tilled"), tilledMapping, this.modelOutput);

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(BSBlocks.CREEP_BLOCK.get())
                .with(PropertyDispatch.property(CreepBlock.TILLED)
                        .select(false, Variant.variant().with(VariantProperties.MODEL, normalModel))
                        .select(true, Variant.variant().with(VariantProperties.MODEL, tilledModel))));
    }
}
