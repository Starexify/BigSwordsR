package net.nova.big_swords.registries;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.IdRegistry;
import net.ornithemc.osl.core.api.registry.RegistryKey;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class DeferredRegister<T> {
  private static final List<DeferredRegister<?>> REGISTERS = new ArrayList<>();

  private static final Map<String, Integer> BLOCK_IDS = new HashMap<>();
  private static short START_ID = 2268; // Hardcoded so last registered ID is used bcz moiang

  private final RegistryKey registryKey;
  public final String modid;
  private final Map<String, Supplier<?>> entries = new LinkedHashMap<>();

  public DeferredRegister(RegistryKey registryKey, String namespace) {
    this.registryKey = Objects.requireNonNull(registryKey);
    this.modid = Objects.requireNonNull(namespace);
    REGISTERS.add(this);
  }

  public static <T> DeferredRegister<T> create(RegistryKey key, String modid) {
    return new DeferredRegister<>(key, modid);
  }

  public static DeferredRegister.Items createItems(String modid) {
    return new Items(modid);
  }

  public static DeferredRegister.Blocks createBlocks(String modid) {
    return new Blocks(modid);
  }

  public <I extends T> Supplier<I> register(final String name, final Supplier<I> factory) {
    this.entries.put(name, factory);
    return factory;
  }

  public static class Blocks extends DeferredRegister<Block> {
    public static short ID = 176; // Hardcoded so last registered ID is used bcz moiang

    public Blocks(String namespace) {
      super(RegistryKey.of("minecraft:blocks"), namespace);
    }

    public <I extends Block> Supplier<I> registerBlock(final String name, final Supplier<I> factory) {
      return register(name, () -> {
        I block = factory.get();
        String blockName = this.modid + ":" + name;
        block.setKey(blockName).setSpriteName(blockName);
        return block;
      });
    }

    public static void registerBlocks(IdRegistry<Block> registry) {
      RegistryKey targetKey = RegistryKey.of("minecraft:blocks");

      for (DeferredRegister<?> register : REGISTERS) {
        if (!register.registryKey.equals(targetKey)) continue;

        for (Map.Entry<String, Supplier<?>> entry : register.entries.entrySet()) {
          if (START_ID > 31999) throw new IllegalStateException("BigSwords registry has exhausted the 1.7.10 32000 short ID limit!");

          String id = entry.getKey();
          Supplier<?> factory = entry.getValue();
          Block block = (Block) factory.get();

          int assignedId = START_ID++;
          BLOCK_IDS.put(id, assignedId);
          registry.register(assignedId, id, block);
        }
      }
    }
  }

  public static class Items extends DeferredRegister<Item> {
    public static short ID = 2268; // Hardcoded so last registered ID is used bcz moiang

    public Items(String namespace) {
      super(RegistryKey.of("minecraft:items"), namespace);
    }

    public <I extends Item> Supplier<I> registerItem(final String name, final Supplier<I> factory) {
      return register(name, () -> {
        I item = factory.get();
        String itemName = this.modid + ":" + name;
        item.setKey(itemName).setSpriteName(itemName);
        return item;
      });
    }

    public <I extends BlockItem> Supplier<I> registerBlockItem(final String name, Supplier<? extends Block> block, Function<Block, I> blockBuilder) {
      return registerItem(name, () -> blockBuilder.apply(block.get()));
    }

    public Supplier<BlockItem> registerSimpleBlockItem(final String name, Supplier<? extends Block> block) {
      return this.registerBlockItem(name, block, BlockItem::new);
    }

    public static void registerItems(IdRegistry<Item> registry) {
      RegistryKey targetKey = RegistryKey.of("minecraft:items");

      for (DeferredRegister<?> register : REGISTERS) {
        if (!register.registryKey.equals(targetKey)) continue;

        for (Map.Entry<String, Supplier<?>> entry : register.entries.entrySet()) {
          if (START_ID > 31999) throw new IllegalStateException("BigSwords registry has exhausted the 1.7.10 32000 short ID limit!");

          String id = entry.getKey();
          Supplier<?> factory = entry.getValue();
          Item item = (Item) factory.get();

          if (BLOCK_IDS.containsKey(id)) {
            int blockId = BLOCK_IDS.get(id);
            registry.register(blockId, id, item);
          }
          else {
          registry.register(START_ID++, id, item);
          }
        }
      }
    }
  }
}