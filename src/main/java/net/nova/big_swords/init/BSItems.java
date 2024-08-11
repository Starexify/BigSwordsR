package net.nova.big_swords.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.item.BigSwordItem;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Sticks
    public static DeferredItem<Item> GIANT_WOODEN_STICK = ITEMS.register("giant_wooden_stick", () -> new Item(new Item.Properties()));

    // Big Swords
    public static DeferredItem<Item> WOODEN_BIG_SWORD = ITEMS.register("wooden_big_sword",
            () -> new BigSwordItem(Tiers.WOOD, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.WOOD, 5, -3F))));

    public static DeferredItem<Item> STONE_BIG_SWORD = ITEMS.register("stone_big_sword",
            () -> new BigSwordItem(Tiers.STONE, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.STONE, 5, -3F))));

    public static DeferredItem<Item> IRON_BIG_SWORD = ITEMS.register("iron_big_sword",
            () -> new BigSwordItem(Tiers.IRON, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.IRON, 5, -3F))));

    public static DeferredItem<Item> GOLDEN_BIG_SWORD = ITEMS.register("golden_big_sword",
            () -> new BigSwordItem(Tiers.GOLD, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.GOLD, 5, -3F))));
}
