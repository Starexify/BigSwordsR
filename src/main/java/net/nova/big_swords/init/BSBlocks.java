package net.nova.big_swords.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.block.CreepBlock;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static RegistryObject<Block> LIVINGMETAL_BLOCK = registerBlock("livingmetal_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_BLUE)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(BSSoundTypes.LIVINGMETAL_BLOCK)
    ));

    public static RegistryObject<Block> BIOMASS_BLOCK = registerBlock("biomass_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .strength(4.0F, 3.0F)
            .sound(SoundType.WART_BLOCK)
    ));

    public static RegistryObject<Block> CREEP_BLOCK = registerBlock("creep_block", () -> new CreepBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .instrument(NoteBlockInstrument.COW_BELL)
            .strength(1.5F)
            .sound(SoundType.SOUL_SAND)
    ));

    public static RegistryObject<Block> BIOMASS = BLOCKS.register("biomass", () -> new BiomassCrop(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY)
    ));


    // Registers
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItems(String name, Supplier<T> block) {
        return BSItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
