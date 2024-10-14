package net.nova.big_swords.init;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nova.big_swords.item.*;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Extra
    public static RegistryObject<Item> BIOMASS_SEED = ITEMS.register("biomass_seed", () -> new ItemNameBlockItem(BSBlocks.BIOMASS.get(), new Item.Properties()));
    public static RegistryObject<Item> CREEP_BALL = ITEMS.register("creep_ball", () -> new CreepBall(new Item.Properties()));
    public static RegistryObject<Item> SOUL = ITEMS.register("soul", () -> new Soul(new Item.Properties()));

    // Sticks
    public static RegistryObject<Item> GIANT_WOODEN_STICK = ITEMS.register("giant_wooden_stick", () -> new BurnItem(new Item.Properties(), 700));
    public static RegistryObject<Item> GIANT_BLAZE_ROD = ITEMS.register("giant_blaze_rod", () -> new BurnItem(new Item.Properties(), 16800));
    public static RegistryObject<Item> GIANT_LIVINGMETAL_HANDLE = ITEMS.register("giant_livingmetal_handle", () -> new Item(new Item.Properties()));

    // Ender Template
    public static RegistryObject<Item> ENDER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ender_upgrade_smithing_template", EnderSmithingTemplate::createEnderUpgradeTemplate);

    // Livingmetal Stuff
    public static RegistryObject<Item> LIVINGMETAL_INGOT = ITEMS.register("livingmetal_ingot", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_HELMET = ITEMS.register("livingmetal_helmet", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_CHESTPLATE = ITEMS.register("livingmetal_chestplate", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_LEGGINGS = ITEMS.register("livingmetal_leggings", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_BOOTS = ITEMS.register("livingmetal_boots", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_SWORD = ITEMS.register("livingmetal_sword", () -> new SwordItem(BSTiers.LIVINGMETAL, 3, -2.4F, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_PICKAXE = ITEMS.register("livingmetal_pickaxe", () -> new PickaxeItem(BSTiers.LIVINGMETAL, 1, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_AXE = ITEMS.register("livingmetal_axe", () -> new AxeItem(BSTiers.LIVINGMETAL, 6.0F, -3.0F, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_SHOVEL = ITEMS.register("livingmetal_shovel", () -> new ShovelItem(BSTiers.LIVINGMETAL, 1.5F, -3.0F, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_HOE = ITEMS.register("livingmetal_hoe", () -> new BSHoeItem(BSTiers.LIVINGMETAL, -2.5F, -0.5F, new Item.Properties()));

    // Biomass Stuff
    public static RegistryObject<Item> BIOMASS = ITEMS.register("biomass", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_HELMET = ITEMS.register("biomass_helmet", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_CHESTPLATE = ITEMS.register("biomass_chestplate", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_LEGGINGS = ITEMS.register("biomass_leggings", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_BOOTS = ITEMS.register("biomass_boots", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_SWORD = ITEMS.register("biomass_sword", () -> new SwordItem(BSTiers.BIOMASS, 3, -2.4F, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_PICKAXE = ITEMS.register("biomass_pickaxe", () -> new PickaxeItem(BSTiers.BIOMASS, 1, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_AXE = ITEMS.register("biomass_axe", () -> new AxeItem(BSTiers.BIOMASS, 6.0F, -3.0F, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_SHOVEL = ITEMS.register("biomass_shovel", () -> new ShovelItem(BSTiers.BIOMASS, 1.5F, -3.0F, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_HOE = ITEMS.register("biomass_hoe", () -> new HoeItem(BSTiers.BIOMASS, -2, -0.5F, new Item.Properties()));

    // Big Swords
    public static RegistryObject<Item> WOODEN_BIG_SWORD = ITEMS.register("wooden_big_sword", () -> new BigSwordItem(Tiers.WOOD, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> STONE_BIG_SWORD = ITEMS.register("stone_big_sword", () -> new BigSwordItem(Tiers.STONE, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> IRON_BIG_SWORD = ITEMS.register("iron_big_sword", () -> new BigSwordItem(Tiers.IRON, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> GOLDEN_BIG_SWORD = ITEMS.register("golden_big_sword", () -> new BigSwordItem(Tiers.GOLD, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> DIAMOND_BIG_SWORD = ITEMS.register("diamond_big_sword", () -> new BigSwordItem(Tiers.DIAMOND, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> NETHERITE_BIG_SWORD = ITEMS.register("netherite_big_sword", () -> new BigSwordItem(Tiers.NETHERITE, 6.5F, -2.8F, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> PATCHWORK_BIG_SWORD = ITEMS.register("patchwork_big_sword", () -> new BigSwordItem(BSTiers.PATCHWORK, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> SKULL_BIG_SWORD = ITEMS.register("skull_big_sword", () -> new BigSwordItem(BSTiers.SKULL, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> QUARTZ_BIG_SWORD = ITEMS.register("quartz_big_sword", () -> new BigSwordItem(BSTiers.QUARTZ, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> OBSIDIAN_BIG_SWORD = ITEMS.register("obsidian_big_sword", () -> new BigSwordItem(BSTiers.OBSIDIAN, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> ENDER_BIG_SWORD = ITEMS.register("ender_big_sword", () -> new BigSwordItem(BSTiers.ENDER, 6.5F, -2.8F, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> LIVINGMETAL_BIG_SWORD = ITEMS.register("livingmetal_big_sword", () -> new BigSwordItem(BSTiers.LIVINGMETAL, 6.5F, -2.8F, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_BIG_SWORD = ITEMS.register("biomass_big_sword", () -> new BigSwordItem(BSTiers.BIOMASS, 6.5F, -2.8F, new Item.Properties()));

    // Glaives
    public static RegistryObject<Item> WOODEN_GLAIVE = ITEMS.register("wooden_glaive", () -> new GlaiveItem(Tiers.WOOD, 2, -2.2F, new Item.Properties(), 3F, 4F));
    public static RegistryObject<Item> STONE_GLAIVE = ITEMS.register("stone_glaive", () -> new GlaiveItem(Tiers.STONE, 2, -2.2F, new Item.Properties(), 3.5F, 4.5F));
    public static RegistryObject<Item> IRON_GLAIVE = ITEMS.register("iron_glaive", () -> new GlaiveItem(Tiers.IRON, 2, -2.2F, new Item.Properties(), 4F, 5F));
    public static RegistryObject<Item> GOLDEN_GLAIVE = ITEMS.register("golden_glaive", () -> new GlaiveItem(Tiers.GOLD, 2, -2.2F, new Item.Properties(), 3F, 4F));
    public static RegistryObject<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive", () -> new GlaiveItem(Tiers.DIAMOND, 2, -2.2F, new Item.Properties(), 4.5F, 5.5F));
    public static RegistryObject<Item> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive", () -> new GlaiveItem(Tiers.NETHERITE, 2, -2.2F, new Item.Properties().fireResistant(), 5.5F, 6.5F));
    public static RegistryObject<Item> BIOMASS_GLAIVE = ITEMS.register("biomass_glaive", () -> new GlaiveItem(BSTiers.BIOMASS, 2, -2.2F, new Item.Properties(), 4F, 4.5F));
    public static RegistryObject<Item> LIVINGMETAL_GLAIVE = ITEMS.register("livingmetal_glaive", () -> new GlaiveItem(BSTiers.LIVINGMETAL, 2, -2.2F, new Item.Properties(), 4.5F, 5.5F));

    // Scythes
    public static RegistryObject<Item> WOODEN_SCYTHE = ITEMS.register("wooden_scythe", () -> new ScytheItem(Tiers.WOOD, 1, -2.0F, new Item.Properties(), 2F, 3F));
    public static RegistryObject<Item> STONE_SCYTHE = ITEMS.register("stone_scythe", () -> new ScytheItem(Tiers.STONE, 1, -2.0F, new Item.Properties(), 2.5F, 3.5F));
    public static RegistryObject<Item> IRON_SCYTHE = ITEMS.register("iron_scythe", () -> new ScytheItem(Tiers.IRON, 1, -2.0F, new Item.Properties(), 3F, 4F));
    public static RegistryObject<Item> GOLDEN_SCYTHE = ITEMS.register("golden_scythe", () -> new ScytheItem(Tiers.GOLD, 1, -2.0F, new Item.Properties(), 2F, 3F));
    public static RegistryObject<Item> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe", () -> new ScytheItem(Tiers.DIAMOND, 1, -2.0F, new Item.Properties(), 3.5F, 4.5F));
    public static RegistryObject<Item> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe", () -> new ScytheItem(Tiers.NETHERITE, 1, -2.0F, new Item.Properties().fireResistant(), 4.5F, 5.5F));
    public static RegistryObject<Item> BIOMASS_SCYTHE = ITEMS.register("biomass_scythe", () -> new ScytheItem(BSTiers.BIOMASS, 1, -2.0F, new Item.Properties(), 3F, 3.5F));
    public static RegistryObject<Item> LIVINGMETAL_SCYTHE = ITEMS.register("livingmetal_scythe", () -> new ScytheItem(BSTiers.LIVINGMETAL, 1, -2.0F, new Item.Properties(), 3.5F, 4.5F));
    public static RegistryObject<Item> BONE_SCYTHE = ITEMS.register("bone_scythe", () -> new ScytheItem(BSTiers.SKULL, 1, -2.0F, new Item.Properties(), 2F, 2.06F));
    public static RegistryObject<Item> SOUL_REAPER = ITEMS.register("soul_reaper", () -> new ScytheItem(BSTiers.REAPER, 1, -2.0F, new Item.Properties().rarity(Rarity.EPIC).fireResistant(), 9F, 10F));

    // Shields
    public static RegistryObject<Item> WOODEN_SHIELD = ITEMS.register("wooden_shield", () -> new TieredShield(Tiers.WOOD, new Item.Properties(), 2));
    public static RegistryObject<Item> GILDED_WOODEN_SHIELD = ITEMS.register("gilded_wooden_shield", () -> new TieredShield(Tiers.WOOD, new Item.Properties(), 4));
    public static RegistryObject<Item> STONE_SHIELD = ITEMS.register("stone_shield", () -> new TieredShield(Tiers.STONE, new Item.Properties()));
    public static RegistryObject<Item> GILDED_STONE_SHIELD = ITEMS.register("gilded_stone_shield", () -> new TieredShield(Tiers.STONE, new Item.Properties(), 2));
    public static RegistryObject<Item> IRON_SHIELD = ITEMS.register("iron_shield", () -> new TieredShield(Tiers.IRON, new Item.Properties()));
    public static RegistryObject<Item> GILDED_IRON_SHIELD = ITEMS.register("gilded_iron_shield", () -> new TieredShield(Tiers.IRON, new Item.Properties(), 1, Tiers.IRON.getUses() / 2));
    public static RegistryObject<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> new TieredShield(Tiers.DIAMOND, new Item.Properties(), 1, -(Tiers.DIAMOND.getUses() / 2)));
    public static RegistryObject<Item> GILDED_DIAMOND_SHIELD = ITEMS.register("gilded_diamond_shield", () -> new TieredShield(Tiers.DIAMOND, new Item.Properties(), 1, -653));
    public static RegistryObject<Item> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> new TieredShield(Tiers.NETHERITE, new Item.Properties(), 1, -(Tiers.NETHERITE.getUses() / 2)));
    public static RegistryObject<Item> GILDED_NETHERITE_SHIELD = ITEMS.register("gilded_netherite_shield", () -> new TieredShield(Tiers.NETHERITE, new Item.Properties(), 1, -793));
    public static RegistryObject<Item> ENDER_SHIELD = ITEMS.register("ender_shield", () -> new TieredShield(BSTiers.ENDER, new Item.Properties(), 1, -(BSTiers.ENDER.getUses() / 2)));
    public static RegistryObject<Item> GILDED_ENDER_SHIELD = ITEMS.register("gilded_ender_shield", () -> new TieredShield(BSTiers.ENDER, new Item.Properties(), 1, -1190));
    public static RegistryObject<Item> QUARTZ_SHIELD = ITEMS.register("quartz_shield", () -> new TieredShield(BSTiers.QUARTZ, new Item.Properties()));
    public static RegistryObject<Item> GILDED_QUARTZ_SHIELD = ITEMS.register("gilded_quartz_shield", () -> new TieredShield(BSTiers.QUARTZ, new Item.Properties(), 2));
    public static RegistryObject<Item> PATCHWORK_SHIELD = ITEMS.register("patchwork_shield", () -> new TieredShield(BSTiers.PATCHWORK, new Item.Properties(), 2));
    public static RegistryObject<Item> GILDED_PATCHWORK_SHIELD = ITEMS.register("gilded_patchwork_shield", () -> new TieredShield(BSTiers.PATCHWORK, new Item.Properties(), 3));
    public static RegistryObject<Item> SKULL_SHIELD = ITEMS.register("skull_shield", () -> new TieredShield(BSTiers.SKULL, new Item.Properties(), 2));
    public static RegistryObject<Item> GILDED_SKULL_SHIELD = ITEMS.register("gilded_skull_shield", () -> new TieredShield(BSTiers.SKULL, new Item.Properties(), 3, BSTiers.SKULL.getUses() / 2));
    public static RegistryObject<Item> BIOMASS_SHIELD = ITEMS.register("biomass_shield", () -> new TieredShield(BSTiers.BIOMASS, new Item.Properties(), 1, BSTiers.BIOMASS.getUses() / 2));
    public static RegistryObject<Item> GILDED_BIOMASS_SHIELD = ITEMS.register("gilded_biomass_shield", () -> new TieredShield(BSTiers.BIOMASS, new Item.Properties(), 2));
    public static RegistryObject<Item> LIVINGMETAL_SHIELD = ITEMS.register("livingmetal_shield", () -> new TieredShield(BSTiers.LIVINGMETAL, new Item.Properties(), 1));
    public static RegistryObject<Item> GILDED_LIVINGMETAL_SHIELD = ITEMS.register("gilded_livingmetal_shield", () -> new TieredShield(BSTiers.LIVINGMETAL, new Item.Properties(), 2, BSTiers.LIVINGMETAL.getUses() / 2));
}
