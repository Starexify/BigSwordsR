package net.nova.big_swords.init;

import net.minecraft.item.CreativeModeTab;
import net.minecraft.item.Item;
import net.nova.big_swords.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

  public static Supplier<Item> GIANT_WOODEN_STICK = ITEMS.registerItem("giant_wooden_stick", () -> new Item().setCreativeModeTab(CreativeModeTab.COMBAT));
  public static Supplier<Item> GIANT_BLAZE_ROD = ITEMS.registerItem("giant_blaze_rod", () -> new Item().setCreativeModeTab(CreativeModeTab.COMBAT));
  public static Supplier<Item> GIANT_LIVINGMETAL_HANDLE = ITEMS.registerItem("giant_livingmetal_handle", () -> new Item().setCreativeModeTab(CreativeModeTab.COMBAT));
}
