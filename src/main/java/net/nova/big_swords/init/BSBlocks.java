package net.nova.big_swords.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.CreativeModeTab;
import net.nova.big_swords.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

  public static Supplier<Block> LIVINGMETAL_BLOCK = registerBlockWithItem("livingmetal_block", () -> new Block(Material.STONE).setCreativeModeTab(CreativeModeTab.COMBAT));

  public static <T extends Block> Supplier<T> registerBlockWithItem(String name, Supplier<T> blockCreator) {
    Supplier<T> block = BLOCKS.registerBlock(name, blockCreator);
    BSItems.ITEMS.registerSimpleBlockItem(name, block);
    return block;
  }
}