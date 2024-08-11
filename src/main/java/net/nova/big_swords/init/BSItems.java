package net.nova.big_swords.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Big Swords
    public static DeferredItem<Item> WOODEN_BIG_SWORD = ITEMS.register("wooden_big_sword",
            () -> new SwordItem(Tiers.WOOD, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, 3, -3F))));
}
