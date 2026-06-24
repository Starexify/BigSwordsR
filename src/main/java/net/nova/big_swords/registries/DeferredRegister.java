package net.nova.big_swords.registries;

import net.minecraft.item.Item;
import net.minecraft.util.registry.IdRegistry;
import net.ornithemc.osl.core.api.registry.RegistryKey;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class DeferredRegister<T> {
  private static final List<DeferredRegister<?>> REGISTERS = new ArrayList<>();

  private final RegistryKey registryKey;
  private final String namespace;
  private final Map<String, Supplier<?>> entries = new LinkedHashMap<>();

  public DeferredRegister(RegistryKey registryKey, String namespace) {
    this.registryKey = Objects.requireNonNull(registryKey);
    this.namespace = Objects.requireNonNull(namespace);
    REGISTERS.add(this);
  }

  public static <T> DeferredRegister<T> create(RegistryKey key, String modid) {
    return new DeferredRegister<>(key, modid);
  }

  public static DeferredRegister.Items createItems(String modid) {
    return new Items(modid);
  }

  public <I extends T> Supplier<I> register(final String name, final Supplier<I> factory) {
    this.entries.put(name, factory);
    return factory;
  }

  public static class Items extends DeferredRegister<Item> {
    public static short ID = 2268; // Hardcoded so last registered ID is used bcz moiang

    public Items(String namespace) {
      super(RegistryKey.of("minecraft:items"), namespace);
    }

    public <I extends Item> Supplier<I> registerItem(final String name, final Supplier<I> factory) {
      return register(name, () -> {
        I item = factory.get();
        item.setKey(name);
        return item;
      });
    }

    public static void registerItems(IdRegistry<Item> registry) {
      RegistryKey targetKey = RegistryKey.of("minecraft:items");

      for (DeferredRegister<?> register : REGISTERS) {
        if (!register.registryKey.equals(targetKey)) continue;

        for (Map.Entry<String, Supplier<?>> entry : register.entries.entrySet()) {
          if (ID > 31999) throw new IllegalStateException("BigSwords registry has exhausted the 1.7.10 32000 short ID limit!");

          String rawID = entry.getKey();
          Supplier<?> factory = entry.getValue();

          String id = register.namespace + ":" + rawID;
          Item createdItem = (Item) factory.get();

          registry.register(ID++, id, createdItem);
        }
      }
    }
  }
}