package net.nova.big_swords.init;

import net.minecraft.item.CreativeModeTab;
import net.minecraft.item.Item;
import net.nova.big_swords.registries.DeferredRegister;
import net.ornithemc.osl.core.api.registry.RegistryKey;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(RegistryKey.of("minecraft:items"), MODID);

  public static Supplier<Item> GIANT_WOODEN_STICK = ITEMS.register("giant_wooden_stick", () -> new Item().setCreativeModeTab(CreativeModeTab.COMBAT));
}
