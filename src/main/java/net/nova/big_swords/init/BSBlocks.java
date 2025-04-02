package net.nova.big_swords.init;

import net.minecraft.world.level.block.Block;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.block.CreepBlock;

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
