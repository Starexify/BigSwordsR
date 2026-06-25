package net.nova.big_swords.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.CreativeModeTab;
import net.nova.big_swords.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

  public static Supplier<Block> LIVINGMETAL_BLOCK = BLOCKS.registerBlock("livingmetal_block", () -> new Block(Material.STONE).setCreativeModeTab(CreativeModeTab.COMBAT));

  public static void init() {}
}