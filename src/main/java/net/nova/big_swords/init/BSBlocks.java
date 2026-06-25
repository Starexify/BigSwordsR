package net.nova.big_swords.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.CreativeModeTab;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

  public static Supplier<Block> LIVINGMETAL_BLOCK = BLOCKS.registerBlock("livingmetal_block", () -> new Block(Material.IRON)
      .setStrength(5.0F).setBlastResistance(6.0F)
      .setSounds(Block.METAL_SOUNDS)
      .setCreativeModeTab(CreativeModeTab.COMBAT)
  );

  public static Supplier<Block> BIOMASS_BLOCK = BLOCKS.registerBlock("biomass_block", () -> new Block(Material.PLANT)
      .setStrength(4.0F).setBlastResistance(3.0F)
      .setCreativeModeTab(CreativeModeTab.COMBAT)
  );

  public static Supplier<Block> CREEP_BLOCK = BLOCKS.registerBlock("creep_block", () -> new Block(Material.SAND)
      .setStrength(1.5F)
      .setSounds(Block.SAND_SOUNDS)
      .setCreativeModeTab(CreativeModeTab.COMBAT)
  );

  public static Supplier<Block> BIOMASS = BLOCKS.registerBlock("biomass", BiomassCrop::new);

  public static void init() {}
}