package net.nova.init;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;
import net.nova.BigSwordsR;

import java.util.function.Function;

public class BSItems {
    public static Item BIOMASS_SEED = registerItem("biomass_seed", new Item.Settings());

    public static Item registerItem(String name, Item.Settings settings) {
        return register(name, Item::new, settings);
    }

    public static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, BigSwordsR.rl(name)), factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, BigSwordsR.rl(name)))));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Items");
    }
}
