package net.nova.data.models;

import it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.nova.block.CreepBlock;
import net.nova.init.BSBlocks;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class BSBlockModelGenerator extends BlockStateModelGenerator {
    public BSBlockModelGenerator(Consumer<BlockStateSupplier> blockStateCollector, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelSupplier> modelCollector) {
        super(blockStateCollector, itemModelOutput, modelCollector);
    }

    @Override
    public void register() {
        registerCreepBlock();
        registerSimpleBlock(BSBlocks.LIVINGMETAL_BLOCK);
        registerSimpleBlock(BSBlocks.BIOMASS_BLOCK);
        createCrossCrop(BSBlocks.BIOMASS, Properties.AGE_3, 0, 1, 2, 3);
    }

    // Models
    public void registerSimpleBlock(Block block) {
        registerSimpleCubeAll(block);
        registerParentedItemModel(block, ModelIds.getBlockModelId(block));
    }

    public void createCrossCrop(Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
        if (ageProperty.getValues().size() != ageTextureIndices.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap<>();
            BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty)
                    .register(integer -> {
                        int i = ageTextureIndices[integer];
                        Identifier identifier = int2ObjectMap.computeIfAbsent(i, (Int2ObjectFunction<? extends Identifier>) (j ->
                                createSubModel(crop, "_stage" + i, Models.CROSS, TextureMap::cross)
                        ));
                        return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
                    });
            registerItemModel(crop.asItem());
            this.blockStateCollector.accept(VariantsBlockStateSupplier.create(crop).coordinate(blockStateVariantMap));
        }
    }

    public void registerCreepBlock() {
        TextureMap normalMapping = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(BSBlocks.CREEP_BLOCK, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getId(Blocks.SOUL_SAND))
                .put(TextureKey.SIDE, TextureMap.getSubId(BSBlocks.CREEP_BLOCK, "_side"));

        TextureMap tilledMapping = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(BSBlocks.CREEP_BLOCK, "_top_tilled"))
                .put(TextureKey.BOTTOM, TextureMap.getId(Blocks.SOUL_SAND))
                .put(TextureKey.SIDE, TextureMap.getSubId(BSBlocks.CREEP_BLOCK, "_side"));

        Identifier normalModel = Models.CUBE_BOTTOM_TOP.upload(
                BSBlocks.CREEP_BLOCK, normalMapping, this.modelCollector);
        Identifier tilledModel = Models.CUBE_BOTTOM_TOP.upload(
                TextureMap.getSubId(BSBlocks.CREEP_BLOCK, "_tilled"), tilledMapping, this.modelCollector);

        registerParentedItemModel(BSBlocks.CREEP_BLOCK, ModelIds.getBlockModelId(BSBlocks.CREEP_BLOCK));
        this.blockStateCollector.accept(VariantsBlockStateSupplier.create(BSBlocks.CREEP_BLOCK)
                .coordinate(BlockStateVariantMap.create(CreepBlock.TILLED)
                        .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, normalModel))
                        .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, tilledModel))));
    }
}
