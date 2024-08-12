package net.nova.big_swords.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.item.BigSwordItem;
import net.nova.big_swords.item.EnderSmithingTemplate;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Sticks
    public static DeferredItem<Item> GIANT_WOODEN_STICK = ITEMS.register("giant_wooden_stick", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> GIANT_BLAZE_ROD = ITEMS.register("giant_blaze_rod", () -> new Item(new Item.Properties()));

    // Ender Template
    public static DeferredItem<Item> ENDER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ender_upgrade_smithing_template", EnderSmithingTemplate::createEnderUpgradeTemplate);

    // Big Swords
    public static DeferredItem<Item> WOODEN_BIG_SWORD = ITEMS.register("wooden_big_sword", () -> new BigSwordItem(Tiers.WOOD, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.WOOD, 5, -2.8F))));
    public static DeferredItem<Item> STONE_BIG_SWORD = ITEMS.register("stone_big_sword", () -> new BigSwordItem(Tiers.STONE, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.STONE, 5, -2.8F))));
    public static DeferredItem<Item> IRON_BIG_SWORD = ITEMS.register("iron_big_sword", () -> new BigSwordItem(Tiers.IRON, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.IRON, 5, -2.8F))));
    public static DeferredItem<Item> GOLDEN_BIG_SWORD = ITEMS.register("golden_big_sword", () -> new BigSwordItem(Tiers.GOLD, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.GOLD, 5, -2.8F))));
    public static DeferredItem<Item> DIAMOND_BIG_SWORD = ITEMS.register("diamond_big_sword", () -> new BigSwordItem(Tiers.DIAMOND, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.DIAMOND, 5, -2.8F))));
    public static DeferredItem<Item> NETHERITE_BIG_SWORD = ITEMS.register("netherite_big_sword", () -> new BigSwordItem(Tiers.NETHERITE, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.NETHERITE, 5, -2.8F))));
    public static DeferredItem<Item> PATCHWORK_BIG_SWORD = ITEMS.register("patchwork_big_sword", () -> new BigSwordItem(BSTiers.PATCHWORK, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.PATCHWORK, 5, -2.8F))));
    public static DeferredItem<Item> SKULL_BIG_SWORD = ITEMS.register("skull_big_sword", () -> new BigSwordItem(BSTiers.SKULL, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.SKULL, 5, -2.8F))));
    public static DeferredItem<Item> QUARTZ_BIG_SWORD = ITEMS.register("quartz_big_sword", () -> new BigSwordItem(BSTiers.QUARTZ, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.QUARTZ, 5, -2.8F))));
    public static DeferredItem<Item> OBSIDIAN_BIG_SWORD = ITEMS.register("obsidian_big_sword", () -> new BigSwordItem(BSTiers.OBSIDIAN, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.OBSIDIAN, 5, -2.8F))));
    public static DeferredItem<Item> ENDER_BIG_SWORD = ITEMS.register("ender_big_sword", () -> new BigSwordItem(BSTiers.ENDER, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.ENDER, 5, -2.8F))));
}
