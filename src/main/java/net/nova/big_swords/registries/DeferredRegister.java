package net.nova.big_swords.registries;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.ornithemc.osl.blocks.api.BlockRegistry;
import net.ornithemc.osl.core.api.util.NamespacedIdentifiers;
import net.ornithemc.osl.items.api.ItemRegistry;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class DeferredRegister {
  private static short START_ID = 2268; // Hardcoded so last registered ID is used bcz moiang

  public final String modid;

  public DeferredRegister(String namespace) {
    this.modid = Objects.requireNonNull(namespace);
  }

  public static <T> DeferredRegister create(String modid) {
    return new DeferredRegister(modid);
  }

  public static DeferredRegister.Items createItems(String modid) {
    return new Items(modid);
  }

  public static DeferredRegister.Blocks createBlocks(String modid) {
    return new Blocks(modid);
  }

  public static class Blocks extends DeferredRegister {
    public Blocks(String namespace) {
      super(namespace);
    }

    public <I extends Block> Supplier<I> registerBlock(final String name, final Supplier<I> factory) {
      I block = factory.get();
      String blockName = this.modid + ":" + name;
      block.setKey(blockName).setSpriteName(blockName);

      BlockRegistry.register(START_ID++, NamespacedIdentifiers.from(this.modid, name), block);
      return () -> block;
    }
  }

  public static class Items extends DeferredRegister {
    public Items(String namespace) {
      super(namespace);
    }

    public <I extends Item> Supplier<I> registerItem(final String name, final Supplier<I> factory) {
      I item = factory.get();
      String itemName = this.modid + ":" + name;
      item.setKey(itemName).setSpriteName(itemName);

      ItemRegistry.register(START_ID++, NamespacedIdentifiers.from(this.modid, name), item);
      return () -> item;
    }

    public <I extends BlockItem> Supplier<I> registerBlockItem(final String name, Supplier<? extends Block> block, Function<Block, I> blockBuilder) {
      return registerItem(name, () -> blockBuilder.apply(block.get()));
    }

    public Supplier<BlockItem> registerSimpleBlockItem(final String name, Supplier<? extends Block> block) {
      return this.registerBlockItem(name, block, BlockItem::new);
    }
  }
}