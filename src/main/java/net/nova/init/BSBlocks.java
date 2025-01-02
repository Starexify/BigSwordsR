package net.nova.init;

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
import net.nova.BigSwordsR;
import net.nova.block.BiomassCrop;
import net.nova.block.CreepBlock;

import java.util.function.Function;

public class BSBlocks {
    public static Block LIVINGMETAL_BLOCK = registerBlock("livingmetal_block", Block::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.LIGHT_BLUE)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresTool()
            .strength(5.0F, 6.0F)
            .sounds(BSBlockSoundGroup.LIVINGMETAL_BLOCK));

    public static Block BIOMASS_BLOCK = registerBlock("biomass_block", Block::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .strength(4.0F, 3.0F)
            .sounds(BlockSoundGroup.WART_BLOCK));

    public static Block CREEP_BLOCK = registerBlock("creep_block", CreepBlock::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .instrument(NoteBlockInstrument.COW_BELL)
            .strength(1.5F)
            .sounds(BlockSoundGroup.SOUL_SAND));

    public static Block BIOMASS = register("biomass", BiomassCrop::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .noCollision()
            .ticksRandomly()
            .breakInstantly()
            .sounds(BlockSoundGroup.CROP)
            .pistonBehavior(PistonBehavior.DESTROY)
    );

    // Methods
    public static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = register(name, factory, settings);
        BSItems.registerItem(name, properties -> new BlockItem(block, properties.useBlockPrefixedTranslationKey()));
        return block;
    }

    public static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Registry.register(Registries.BLOCK, RegistryKey.of(RegistryKeys.BLOCK, BigSwordsR.rl(name)), factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, BigSwordsR.rl(name)))));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Blocks");
    }
}
