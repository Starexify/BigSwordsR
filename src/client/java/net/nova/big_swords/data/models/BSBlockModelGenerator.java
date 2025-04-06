package net.nova.big_swords.data.models;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
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
    public BSBlockModelGenerator(Consumer<BlockModelDefinitionGenerator> consumer, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> biConsumer) {
        super(consumer, itemModelOutput, biConsumer);
    }

    @Override
    public void run() {
        registerCreepBlock();
        createTrivialCube(BSBlocks.LIVINGMETAL_BLOCK);
        createTrivialCube(BSBlocks.BIOMASS_BLOCK);
        createCrossBlock(BSBlocks.BIOMASS, BlockStateProperties.AGE_3, 0, 1, 2, 3);
    }

    // Models
    public void createCrossBlock(Block cropBlock, Property<Integer> ageProperty, int... ageToVisualStageMapping) {
        this.registerSimpleFlatItemModel(cropBlock.asItem());
        if (ageProperty.getPossibleValues().size() != ageToVisualStageMapping.length)
            throw new IllegalArgumentException();
        else {
            Int2ObjectMap<ResourceLocation> int2objectmap = new Int2ObjectOpenHashMap<>();
            this.blockStateOutput.accept(MultiVariantGenerator.dispatch(cropBlock).with(PropertyDispatch.initial(ageProperty).generate(
                    p_408977_ -> {
                        int i = ageToVisualStageMapping[p_408977_];
                        return plainVariant(int2objectmap.computeIfAbsent(i, p_387308_ -> this.createSuffixedVariant(
                                cropBlock, "_stage" + p_387308_, ModelTemplates.CROSS, TextureMapping::cross
                        )));
                    }))
            );
        }
    }

    public void registerCreepBlock() {
        TextureMapping normalMapping = new TextureMapping()
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK, "_top"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.SOUL_SAND))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK, "_side"));

        TextureMapping tilledMapping = new TextureMapping()
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK, "_top_tilled"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.SOUL_SAND))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK, "_side"));

        MultiVariant normalModel = plainVariant(ModelTemplates.CUBE_BOTTOM_TOP.create(BSBlocks.CREEP_BLOCK, normalMapping, this.modelOutput));
        MultiVariant tilledModel = plainVariant(ModelTemplates.CUBE_BOTTOM_TOP.create(TextureMapping.getBlockTexture(BSBlocks.CREEP_BLOCK, "_tilled"), tilledMapping, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(BSBlocks.CREEP_BLOCK).with(createEmptyOrFullDispatch(CreepBlock.TILLED, true, normalModel, tilledModel)));
    }
}
