package net.nova.big_swords.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.block.CreepBlock;

import java.util.function.Function;

public class BSBlocks {
    public static Block LIVINGMETAL_BLOCK = registerBlockWithItem("livingmetal_block", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_BLUE)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(BSSoundTypes.LIVINGMETAL_BLOCK));

    public static Block BIOMASS_BLOCK = registerBlockWithItem("biomass_block", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .strength(4.0F, 3.0F)
            .sound(SoundType.WART_BLOCK));

    public static Block CREEP_BLOCK = registerBlockWithItem("creep_block", CreepBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .instrument(NoteBlockInstrument.COW_BELL)
            .strength(1.5F)
            .sound(SoundType.SOUL_SAND));

    public static Block BIOMASS = registerBlock("biomass", BiomassCrop::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY)
    );

    // Methods
    public static <T extends Block> T registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> function, BlockBehaviour.Properties properties) {
        T block = registerBlock(name, function, properties);
        BSItems.registerItem(name, itemProperties -> new BlockItem(block, itemProperties.useBlockDescriptionPrefix()));
        return block;
    }

    public static <T extends Block> T registerBlock(String name, Function<BlockBehaviour.Properties, T> function, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, BigSwordsR.rl(name));
        return Registry.register(BuiltInRegistries.BLOCK, key, function.apply(properties.setId(key)));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Blocks");
    }
}
