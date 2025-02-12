package net.nova.big_swords.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.block.CreepBlock;
import oshi.util.tuples.Pair;

import java.util.function.Function;

public class BSBlocks {
    public static Block LIVINGMETAL_BLOCK = registerBlockWithItem("livingmetal_block", Block::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.LIGHT_BLUE)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresTool()
            .strength(5.0F, 6.0F)
            .sounds(BSBlockSoundGroup.LIVINGMETAL_BLOCK));

    public static Block BIOMASS_BLOCK = registerBlockWithItem("biomass_block", Block::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .strength(4.0F, 3.0F)
            .sounds(BlockSoundGroup.WART_BLOCK));

    public static Block CREEP_BLOCK = registerBlockWithItem("creep_block", CreepBlock::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .instrument(NoteBlockInstrument.COW_BELL)
            .strength(1.5F)
            .sounds(BlockSoundGroup.SOUL_SAND));

    public static Block BIOMASS = registerBlock("biomass", BiomassCrop::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .noCollision()
            .ticksRandomly()
            .breakInstantly()
            .sounds(BlockSoundGroup.CROP)
            .pistonBehavior(PistonBehavior.DESTROY)
    );

    // Methods
    public static <T extends Block> T registerBlockWithItem(String name, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings) {
        T block = registerBlock(name, factory, settings);
        BSItems.registerItem(name, properties -> new BlockItem(block, properties.useBlockPrefixedTranslationKey()));
        return block;
    }

    public static <T extends Block> T registerBlock(String name, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, BigSwordsR.rl(name));
        return Registry.register(Registries.BLOCK, key, factory.apply(settings.registryKey(key)));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Blocks");
    }
}
