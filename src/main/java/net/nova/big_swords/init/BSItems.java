package net.nova.big_swords.init;

import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.item.*;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Extra
    public static DeferredItem<Item> CREEP_BALL = ITEMS.register("creep_ball", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> BIOMASS_SEED = ITEMS.register("biomass_seed", () -> new ItemNameBlockItem(BSBlocks.BIOMASS.get(), new Item.Properties()));

    // Sticks
    public static DeferredItem<Item> GIANT_WOODEN_STICK = ITEMS.register("giant_wooden_stick", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> GIANT_BLAZE_ROD = ITEMS.register("giant_blaze_rod", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> GIANT_LIVINGMETAL_HANDLE = ITEMS.register("giant_livingmetal_handle", () -> new Item(new Item.Properties()));

    // Ender Template
    public static DeferredItem<Item> ENDER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ender_upgrade_smithing_template", EnderSmithingTemplate::createEnderUpgradeTemplate);

    // Livingmetal Stuff
    public static DeferredItem<Item> LIVINGMETAL_INGOT = ITEMS.register("livingmetal_ingot", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> LIVINGMETAL_HELMET = ITEMS.register("livingmetal_helmet", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(29))));
    public static DeferredItem<Item> LIVINGMETAL_CHESTPLATE = ITEMS.register("livingmetal_chestplate", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(29))));
    public static DeferredItem<Item> LIVINGMETAL_LEGGINGS = ITEMS.register("livingmetal_leggings", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(29))));
    public static DeferredItem<Item> LIVINGMETAL_BOOTS = ITEMS.register("livingmetal_boots", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(29))));
    public static DeferredItem<Item> LIVINGMETAL_SWORD = ITEMS.register("livingmetal_sword", () -> new SwordItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(SwordItem.createAttributes(BSTiers.LIVINGMETAL, 3, -2.4F))));
    public static DeferredItem<Item> LIVINGMETAL_PICKAXE = ITEMS.register("livingmetal_pickaxe", () -> new PickaxeItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(PickaxeItem.createAttributes(BSTiers.LIVINGMETAL, 1.0F, -2.8F))));
    public static DeferredItem<Item> LIVINGMETAL_AXE = ITEMS.register("livingmetal_axe", () -> new AxeItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(AxeItem.createAttributes(BSTiers.LIVINGMETAL, 6.0F, -3.0F))));
    public static DeferredItem<Item> LIVINGMETAL_SHOVEL = ITEMS.register("livingmetal_shovel", () -> new ShovelItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(ShovelItem.createAttributes(BSTiers.LIVINGMETAL, 1.5F, -3.0F))));
    public static DeferredItem<Item> LIVINGMETAL_HOE = ITEMS.register("livingmetal_hoe", () -> new HoeItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(HoeItem.createAttributes(BSTiers.LIVINGMETAL, -2.5F, -0.5F))));

    // Biomass Stuff
    public static DeferredItem<Item> BIOMASS = ITEMS.register("biomass", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> BIOMASS_HELMET = ITEMS.register("biomass_helmet", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(29))));
    public static DeferredItem<Item> BIOMASS_CHESTPLATE = ITEMS.register("biomass_chestplate", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(29))));
    public static DeferredItem<Item> BIOMASS_LEGGINGS = ITEMS.register("biomass_leggings", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(29))));
    public static DeferredItem<Item> BIOMASS_BOOTS = ITEMS.register("biomass_boots", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(29))));
    public static DeferredItem<Item> BIOMASS_SWORD = ITEMS.register("biomass_sword", () -> new SwordItem(BSTiers.BIOMASS, new Item.Properties().attributes(SwordItem.createAttributes(BSTiers.BIOMASS, 3, -2.4F))));
    public static DeferredItem<Item> BIOMASS_PICKAXE = ITEMS.register("biomass_pickaxe", () -> new PickaxeItem(BSTiers.BIOMASS, new Item.Properties().attributes(PickaxeItem.createAttributes(BSTiers.BIOMASS, 1.0F, -2.8F))));
    public static DeferredItem<Item> BIOMASS_AXE = ITEMS.register("biomass_axe", () -> new AxeItem(BSTiers.BIOMASS, new Item.Properties().attributes(AxeItem.createAttributes(BSTiers.BIOMASS, 6.0F, -3.0F))));
    public static DeferredItem<Item> BIOMASS_SHOVEL = ITEMS.register("biomass_shovel", () -> new ShovelItem(BSTiers.BIOMASS, new Item.Properties().attributes(ShovelItem.createAttributes(BSTiers.BIOMASS, 1.5F, -3.0F))));
    public static DeferredItem<Item> BIOMASS_HOE = ITEMS.register("biomass_hoe", () -> new HoeItem(BSTiers.BIOMASS, new Item.Properties().attributes(HoeItem.createAttributes(BSTiers.BIOMASS, -2.5F, -0.5F))));


    // Big Swords
    public static DeferredItem<Item> WOODEN_BIG_SWORD = ITEMS.register("wooden_big_sword", () -> new BigSwordItem(Tiers.WOOD, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.WOOD, 5, -2.8F))));
    public static DeferredItem<Item> STONE_BIG_SWORD = ITEMS.register("stone_big_sword", () -> new BigSwordItem(Tiers.STONE, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.STONE, 5, -2.8F))));
    public static DeferredItem<Item> IRON_BIG_SWORD = ITEMS.register("iron_big_sword", () -> new BigSwordItem(Tiers.IRON, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.IRON, 5, -2.8F))));
    public static DeferredItem<Item> GOLDEN_BIG_SWORD = ITEMS.register("golden_big_sword", () -> new BigSwordItem(Tiers.GOLD, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.GOLD, 5, -2.8F))));
    public static DeferredItem<Item> DIAMOND_BIG_SWORD = ITEMS.register("diamond_big_sword", () -> new BigSwordItem(Tiers.DIAMOND, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.DIAMOND, 5, -2.8F))));
    public static DeferredItem<Item> NETHERITE_BIG_SWORD = ITEMS.register("netherite_big_sword", () -> new BigSwordItem(Tiers.NETHERITE, new Item.Properties().attributes(BigSwordItem.createAttributes(Tiers.NETHERITE, 5, -2.8F)).fireResistant()));
    public static DeferredItem<Item> PATCHWORK_BIG_SWORD = ITEMS.register("patchwork_big_sword", () -> new BigSwordItem(BSTiers.PATCHWORK, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.PATCHWORK, 5, -2.8F))));
    public static DeferredItem<Item> SKULL_BIG_SWORD = ITEMS.register("skull_big_sword", () -> new BigSwordItem(BSTiers.SKULL, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.SKULL, 5, -2.8F))));
    public static DeferredItem<Item> QUARTZ_BIG_SWORD = ITEMS.register("quartz_big_sword", () -> new BigSwordItem(BSTiers.QUARTZ, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.QUARTZ, 5, -2.8F))));
    public static DeferredItem<Item> OBSIDIAN_BIG_SWORD = ITEMS.register("obsidian_big_sword", () -> new BigSwordItem(BSTiers.OBSIDIAN, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.OBSIDIAN, 5, -2.8F))));
    public static DeferredItem<Item> ENDER_BIG_SWORD = ITEMS.register("ender_big_sword", () -> new BigSwordItem(BSTiers.ENDER, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.ENDER, 5, -2.8F)).fireResistant()));
    public static DeferredItem<Item> LIVINGMETAL_BIG_SWORD = ITEMS.register("livingmetal_big_sword", () -> new BigSwordItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.LIVINGMETAL, 5, -2.8F))));
    public static DeferredItem<Item> BIOMASS_BIG_SWORD = ITEMS.register("biomass_big_sword", () -> new BigSwordItem(BSTiers.BIOMASS, new Item.Properties().attributes(BigSwordItem.createAttributes(BSTiers.BIOMASS, 5, -2.8F))));

    // Glaives
    public static DeferredItem<Item> WOODEN_GLAIVE = ITEMS.register("wooden_glaive", () -> new GlaiveItem(Tiers.WOOD, new Item.Properties().attributes(GlaiveItem.createAttributes(Tiers.WOOD, 2, -2.2F)), 3F, 4F));
    public static DeferredItem<Item> STONE_GLAIVE = ITEMS.register("stone_glaive", () -> new GlaiveItem(Tiers.STONE, new Item.Properties().attributes(GlaiveItem.createAttributes(Tiers.STONE, 2, -2.2F)), 3.5F, 4.5F));
    public static DeferredItem<Item> IRON_GLAIVE = ITEMS.register("iron_glaive", () -> new GlaiveItem(Tiers.IRON, new Item.Properties().attributes(GlaiveItem.createAttributes(Tiers.IRON, 2, -2.2F)), 4F, 5F));
    public static DeferredItem<Item> GOLDEN_GLAIVE = ITEMS.register("golden_glaive", () -> new GlaiveItem(Tiers.GOLD, new Item.Properties().attributes(GlaiveItem.createAttributes(Tiers.GOLD, 2, -2.2F)), 3F, 4F));
    public static DeferredItem<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive", () -> new GlaiveItem(Tiers.DIAMOND, new Item.Properties().attributes(GlaiveItem.createAttributes(Tiers.DIAMOND, 2, -2.2F)), 4.5F, 5.5F));
    public static DeferredItem<Item> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive", () -> new GlaiveItem(Tiers.NETHERITE, new Item.Properties().attributes(GlaiveItem.createAttributes(Tiers.NETHERITE, 2, -2.2F)).fireResistant(), 5.5F, 6.5F));
    public static DeferredItem<Item> BIOMASS_GLAIVE = ITEMS.register("biomass_glaive", () -> new GlaiveItem(BSTiers.BIOMASS, new Item.Properties().attributes(GlaiveItem.createAttributes(BSTiers.BIOMASS, 2, -2.2F)), 4F, 4.5F));
    public static DeferredItem<Item> LIVINGMETAL_GLAIVE = ITEMS.register("livingmetal_glaive", () -> new GlaiveItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(GlaiveItem.createAttributes(BSTiers.LIVINGMETAL, 2, -2.2F)), 4.5F, 5.5F));

    // Scythes
    public static DeferredItem<Item> WOODEN_SCYTHE = ITEMS.register("wooden_scythe", () -> new ScytheItem(Tiers.WOOD, new Item.Properties().attributes(ScytheItem.createAttributes(Tiers.WOOD, 1, -2.0F)), 2F, 3F));
    public static DeferredItem<Item> STONE_SCYTHE = ITEMS.register("stone_scythe", () -> new ScytheItem(Tiers.STONE, new Item.Properties().attributes(ScytheItem.createAttributes(Tiers.STONE, 1, -2.0F)), 2.5F, 3.5F));
    public static DeferredItem<Item> IRON_SCYTHE = ITEMS.register("iron_scythe", () -> new ScytheItem(Tiers.IRON, new Item.Properties().attributes(ScytheItem.createAttributes(Tiers.IRON, 1, -2.0F)), 3F, 4F));
    public static DeferredItem<Item> GOLDEN_SCYTHE = ITEMS.register("golden_scythe", () -> new ScytheItem(Tiers.GOLD, new Item.Properties().attributes(ScytheItem.createAttributes(Tiers.GOLD, 1, -2.0F)), 2F, 3F));
    public static DeferredItem<Item> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe", () -> new ScytheItem(Tiers.DIAMOND, new Item.Properties().attributes(ScytheItem.createAttributes(Tiers.DIAMOND, 1, -2.0F)), 3.5F, 4.5F));
    public static DeferredItem<Item> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe", () -> new ScytheItem(Tiers.NETHERITE, new Item.Properties().attributes(ScytheItem.createAttributes(Tiers.NETHERITE, 1, -2.0F)).fireResistant(), 4.5F, 5.5F));
    public static DeferredItem<Item> BIOMASS_SCYTHE = ITEMS.register("biomass_scythe", () -> new ScytheItem(BSTiers.BIOMASS, new Item.Properties().attributes(ScytheItem.createAttributes(BSTiers.BIOMASS, 1, -2.0F)), 3F, 3.5F));
    public static DeferredItem<Item> LIVINGMETAL_SCYTHE = ITEMS.register("livingmetal_scythe", () -> new ScytheItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(ScytheItem.createAttributes(BSTiers.LIVINGMETAL, 1, -2.0F)), 3.5F, 4.5F));
    public static DeferredItem<Item> BONE_SCYTHE = ITEMS.register("bone_scythe", () -> new ScytheItem(BSTiers.SKULL, new Item.Properties().attributes(ScytheItem.createAttributes(BSTiers.SKULL, 1, -2.0F)), 2F, 2.1F));
    public static DeferredItem<Item> SOUL_REAPER = ITEMS.register("soul_reaper", () -> new ScytheItem(BSTiers.REAPER, new Item.Properties().attributes(ScytheItem.createAttributes(BSTiers.REAPER, 1, -2.0F)).rarity(Rarity.EPIC).fireResistant(), 9F, 10F));

    // Shields
    public static DeferredItem<Item> WOODEN_SHIELD = ITEMS.register("wooden_shield", () -> new TieredShield(Tiers.WOOD, new Item.Properties(), 2));
    public static DeferredItem<Item> GILDED_WOODEN_SHIELD = ITEMS.register("gilded_wooden_shield", () -> new GildedTieredShield(Tiers.WOOD, new Item.Properties(), 4));
    public static DeferredItem<Item> STONE_SHIELD = ITEMS.register("stone_shield", () -> new TieredShield(Tiers.STONE, new Item.Properties()));
    public static DeferredItem<Item> GILDED_STONE_SHIELD = ITEMS.register("gilded_stone_shield", () -> new GildedTieredShield(Tiers.STONE, new Item.Properties(), 2));
    public static DeferredItem<Item> IRON_SHIELD = ITEMS.register("iron_shield", () -> new TieredShield(Tiers.IRON, new Item.Properties()));
    public static DeferredItem<Item> GILDED_IRON_SHIELD = ITEMS.register("gilded_iron_shield", () -> new GildedTieredShield(Tiers.IRON, new Item.Properties(), 1, 125));
    public static DeferredItem<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> new TieredShield(Tiers.DIAMOND, new Item.Properties(), 1, -(Tiers.DIAMOND.getUses() / 2)));
    public static DeferredItem<Item> GILDED_DIAMOND_SHIELD = ITEMS.register("gilded_diamond_shield", () -> new GildedTieredShield(Tiers.DIAMOND, new Item.Properties(), 1, -653));
    public static DeferredItem<Item> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> new TieredShield(Tiers.NETHERITE, new Item.Properties(), 1, -(Tiers.NETHERITE.getUses() / 2)));
    public static DeferredItem<Item> GILDED_NETHERITE_SHIELD = ITEMS.register("gilded_netherite_shield", () -> new GildedTieredShield(Tiers.NETHERITE, new Item.Properties(), 1, -793));
}
