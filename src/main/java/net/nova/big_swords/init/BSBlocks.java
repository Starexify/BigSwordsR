package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.block.CreepBlock;

import java.util.function.Function;
import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static DeferredBlock<Block> LIVINGMETAL_BLOCK = registerBlock("livingmetal_block",
            properties -> new Block(properties
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(BSSoundTypes.LIVINGMETAL_BLOCK)));

    public static DeferredBlock<Block> BIOMASS_BLOCK = registerBlock("biomass_block",
            properties -> new Block(properties
                    .mapColor(MapColor.COLOR_RED)
                    .strength(4.0F, 3.0F)
                    .sound(SoundType.WART_BLOCK)));

    public static DeferredBlock<Block> CREEP_BLOCK = registerBlock("creep_block",
            properties -> new CreepBlock(properties
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .strength(1.5F)
                    .sound(SoundType.SOUL_SAND)));

    public static DeferredBlock<Block> BIOMASS = BLOCKS.register("biomass", () -> new BiomassCrop(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY)
            .setId(blockId("biomass"))
    ));


    // Registers
    public static ResourceKey<Block> blockId(String name) {
        return ResourceKey.create(Registries.BLOCK, BigSwordsR.rl(name));
    }

    public static ResourceKey<Item> itemId(String name) {
        return ResourceKey.create(Registries.ITEM, BigSwordsR.rl(name));
    }

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockCreator) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, () -> blockCreator.apply(BlockBehaviour.Properties.of().setId(blockId(name))));
        registerBlockItems(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        BSItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(itemId(name)).useBlockDescriptionPrefix()));
    }
}
