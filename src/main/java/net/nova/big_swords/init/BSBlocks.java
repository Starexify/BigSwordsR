package net.nova.big_swords.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.block.CreepBlock;

import java.util.function.Function;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static DeferredBlock<Block> LIVINGMETAL_BLOCK = registerBlockWithItem("livingmetal_block", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_BLUE)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(BSSoundTypes.LIVINGMETAL_BLOCK));

    public static DeferredBlock<Block> BIOMASS_BLOCK = registerBlockWithItem("biomass_block", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .strength(4.0F, 3.0F)
            .sound(SoundType.WART_BLOCK));

    public static DeferredBlock<Block> CREEP_BLOCK = registerBlockWithItem("creep_block", CreepBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .instrument(NoteBlockInstrument.COW_BELL)
            .strength(1.5F)
            .sound(SoundType.SOUL_SAND));

    public static DeferredBlock<Block> BIOMASS = BLOCKS.registerBlock("biomass", BiomassCrop::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY));


    // Registers
    public static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> blockCreator, BlockBehaviour.Properties properties) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, blockCreator, properties);
        BSItems.ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }
}
