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

  public static <T> DeferredRegister<T> create(RegistryKey key, String namespace) {
    return new DeferredRegister<>(key, namespace);
  }

  public <I extends T> Supplier<I> register(final String name, final Supplier<I> factory) {
    this.entries.put(name, factory);
    return factory;
  }

  public <I extends T> Supplier<I> register(final String name, final Function<String, I> factory) {
    Supplier<I> supplier = () -> factory.apply(name);
    this.entries.put(name, supplier);
    return supplier;
  }

  public static void registerItems(IdRegistry<Item> registry) {
    RegistryKey targetKey = RegistryKey.of("minecraft:items");
    short nextId = 2268; // Hardcoded so last registered ID is used bcz moiang

    for (DeferredRegister<?> register : REGISTERS) {
      if (!register.registryKey.equals(targetKey)) continue;

      for (Map.Entry<String, Supplier<?>> entry : register.entries.entrySet()) {
        if (nextId > 31999) throw new IllegalStateException("BigSwords registry has exhausted the 1.7.10 32000 short ID limit!");

        String rawID = entry.getKey();
        Supplier<?> factory = entry.getValue();

        String id = register.namespace + ":" + rawID;
        Item createdItem = (Item) factory.get();
        createdItem.setKey(rawID);

        registry.register(nextId++, id, createdItem);
      }
    }
  }
}