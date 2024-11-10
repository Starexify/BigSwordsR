package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.item.*;

import java.util.function.Function;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Extra
    public static DeferredItem<Item> BIOMASS_SEED = registerItem("biomass_seed", properties -> createBlockItemWithCustomItemName(BSBlocks.BIOMASS.get(), properties));
    public static DeferredItem<Item> CREEP_BALL = registerItem("creep_ball", properties -> new CreepBall(properties));
    public static DeferredItem<Item> SOUL = registerItem("soul", properties -> new Soul(properties));

    // Sticks
    public static DeferredItem<Item> GIANT_WOODEN_STICK = registerItem("giant_wooden_stick", properties -> new Item(properties));
    public static DeferredItem<Item> GIANT_BLAZE_ROD = registerItem("giant_blaze_rod", properties -> new Item(properties));
    public static DeferredItem<Item> GIANT_LIVINGMETAL_HANDLE = registerItem("giant_livingmetal_handle", properties -> new Item(properties));

    // Ender Template
    public static DeferredItem<Item> ENDER_UPGRADE_SMITHING_TEMPLATE = registerItem("ender_upgrade_smithing_template", properties -> EnderSmithingTemplate.createEnderUpgradeTemplate(properties));

    // Livingmetal Stuff
    public static DeferredItem<Item> LIVINGMETAL_INGOT = registerItem("livingmetal_ingot", properties -> new Item(properties));
    public static DeferredItem<Item> LIVINGMETAL_HELMET = registerItem("livingmetal_helmet", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL.get(), ArmorType.HELMET, properties));
    public static DeferredItem<Item> LIVINGMETAL_CHESTPLATE = registerItem("livingmetal_chestplate", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL.get(), ArmorType.CHESTPLATE, properties));
    public static DeferredItem<Item> LIVINGMETAL_LEGGINGS = registerItem("livingmetal_leggings", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL.get(), ArmorType.LEGGINGS, properties));
    public static DeferredItem<Item> LIVINGMETAL_BOOTS = registerItem("livingmetal_boots", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL.get(), ArmorType.BOOTS, properties));
    public static DeferredItem<Item> LIVINGMETAL_SWORD = registerItem("livingmetal_sword", properties -> new SwordItem(BSTiers.LIVINGMETAL, 3.0F, 2.4F, properties));
    public static DeferredItem<Item> LIVINGMETAL_PICKAXE = registerItem("livingmetal_pickaxe", properties -> new PickaxeItem(BSTiers.LIVINGMETAL, 1.0F, -2.8F, properties));
    public static DeferredItem<Item> LIVINGMETAL_AXE = registerItem("livingmetal_axe", properties -> new AxeItem(BSTiers.LIVINGMETAL, 6.0F, -3.0F, properties));
    public static DeferredItem<Item> LIVINGMETAL_SHOVEL = registerItem("livingmetal_shovel", properties -> new ShovelItem(BSTiers.LIVINGMETAL, 1.5F, -3.0F, properties));
    public static DeferredItem<Item> LIVINGMETAL_HOE = registerItem("livingmetal_hoe", properties -> new HoeItem(BSTiers.LIVINGMETAL, -2.5F, 0.0F, properties));

    // Biomass Stuff
    public static DeferredItem<Item> BIOMASS = registerItem("biomass", properties -> new Item(properties));
    public static DeferredItem<Item> BIOMASS_HELMET = registerItem("biomass_helmet", properties -> new ArmorItem(BSArmorMaterial.BIOMASS.get(), ArmorType.HELMET, properties));
    public static DeferredItem<Item> BIOMASS_CHESTPLATE = registerItem("biomass_chestplate", properties -> new ArmorItem(BSArmorMaterial.BIOMASS.get(), ArmorType.CHESTPLATE, properties));
    public static DeferredItem<Item> BIOMASS_LEGGINGS = registerItem("biomass_leggings", properties -> new ArmorItem(BSArmorMaterial.BIOMASS.get(), ArmorType.LEGGINGS, properties));
    public static DeferredItem<Item> BIOMASS_BOOTS = registerItem("biomass_boots", properties -> new ArmorItem(BSArmorMaterial.BIOMASS.get(), ArmorType.BOOTS, properties));
    public static DeferredItem<Item> BIOMASS_SWORD = registerItem("biomass_sword", properties -> new SwordItem(BSTiers.BIOMASS, 3.0F, -2.4F, properties));
    public static DeferredItem<Item> BIOMASS_PICKAXE = registerItem("biomass_pickaxe", properties -> new PickaxeItem(BSTiers.BIOMASS, 1.0F, -2.8F, properties));
    public static DeferredItem<Item> BIOMASS_AXE = registerItem("biomass_axe", properties -> new AxeItem(BSTiers.BIOMASS, 6.0F, -3.0F, properties));
    public static DeferredItem<Item> BIOMASS_SHOVEL = registerItem("biomass_shovel", properties -> new ShovelItem(BSTiers.BIOMASS, 1.5F, -3.0F, properties));
    public static DeferredItem<Item> BIOMASS_HOE = registerItem("biomass_hoe", properties -> new HoeItem(BSTiers.BIOMASS, -2.0F, -0.5F, properties));

    // Big Swords
    public static DeferredItem<Item> WOODEN_BIG_SWORD = registerItem("wooden_big_sword", properties -> new BigSwordItem(ToolMaterial.WOOD, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> STONE_BIG_SWORD = registerItem("stone_big_sword", properties -> new BigSwordItem(ToolMaterial.STONE, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> IRON_BIG_SWORD = registerItem("iron_big_sword", properties -> new BigSwordItem(ToolMaterial.IRON, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> GOLDEN_BIG_SWORD = registerItem("golden_big_sword", properties -> new BigSwordItem(ToolMaterial.GOLD, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> DIAMOND_BIG_SWORD = registerItem("diamond_big_sword", properties -> new BigSwordItem(ToolMaterial.DIAMOND, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> NETHERITE_BIG_SWORD = registerItem("netherite_big_sword", properties -> new BigSwordItem(ToolMaterial.NETHERITE, 6.5F, -2.8F, properties.fireResistant()));
    public static DeferredItem<Item> PATCHWORK_BIG_SWORD = registerItem("patchwork_big_sword", properties -> new BigSwordItem(BSTiers.PATCHWORK, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> SKULL_BIG_SWORD = registerItem("skull_big_sword", properties -> new BigSwordItem(BSTiers.SKULL, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> QUARTZ_BIG_SWORD = registerItem("quartz_big_sword", properties -> new BigSwordItem(BSTiers.QUARTZ, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> OBSIDIAN_BIG_SWORD = registerItem("obsidian_big_sword", properties -> new BigSwordItem(BSTiers.OBSIDIAN, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> ENDER_BIG_SWORD = registerItem("ender_big_sword", properties -> new BigSwordItem(BSTiers.ENDER, 6.5F, -2.8F, properties.fireResistant()));
    public static DeferredItem<Item> LIVINGMETAL_BIG_SWORD = registerItem("livingmetal_big_sword", properties -> new BigSwordItem(BSTiers.LIVINGMETAL, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> BIOMASS_BIG_SWORD = registerItem("biomass_big_sword", properties -> new BigSwordItem(BSTiers.BIOMASS, 6.5F, -2.8F, properties));

    // Glaives
    public static DeferredItem<Item> WOODEN_GLAIVE = registerItem("wooden_glaive", properties -> new GlaiveItem(ToolMaterial.WOOD, 2, -2.2F, 3F, 4F, properties));
    public static DeferredItem<Item> STONE_GLAIVE = registerItem("stone_glaive", properties -> new GlaiveItem(ToolMaterial.STONE, 2, -2.2F, 3.5F, 4.5F, properties));
    public static DeferredItem<Item> IRON_GLAIVE = registerItem("iron_glaive", properties -> new GlaiveItem(ToolMaterial.IRON, 2, -2.2F, 4F, 5F, properties));
    public static DeferredItem<Item> GOLDEN_GLAIVE = registerItem("golden_glaive", properties -> new GlaiveItem(ToolMaterial.GOLD, 2, -2.2F, 3F, 4F, properties));
    public static DeferredItem<Item> DIAMOND_GLAIVE = registerItem("diamond_glaive", properties -> new GlaiveItem(ToolMaterial.DIAMOND, 2, -2.2F, 4.5F, 5.5F, properties));
    public static DeferredItem<Item> NETHERITE_GLAIVE = registerItem("netherite_glaive", properties -> new GlaiveItem(ToolMaterial.NETHERITE, 2, -2.2F, 5.5F, 6.5F, properties.fireResistant()));
    public static DeferredItem<Item> BIOMASS_GLAIVE = registerItem("biomass_glaive", properties -> new GlaiveItem(BSTiers.BIOMASS, 2, -2.2F, 4F, 4.5F, properties));
    public static DeferredItem<Item> LIVINGMETAL_GLAIVE = registerItem("livingmetal_glaive", properties -> new GlaiveItem(BSTiers.LIVINGMETAL, 2, -2.2F, 4.5F, 5.5F, properties));

    // Scythes
    public static DeferredItem<Item> WOODEN_SCYTHE = registerItem("wooden_scythe", properties -> new ScytheItem(ToolMaterial.WOOD, 1, -2.0F, 2F, 3F, properties));
    public static DeferredItem<Item> STONE_SCYTHE = registerItem("stone_scythe", properties -> new ScytheItem(ToolMaterial.STONE, 1, -2.0F, 2.5F, 3.5F, properties));
    public static DeferredItem<Item> IRON_SCYTHE = registerItem("iron_scythe", properties -> new ScytheItem(ToolMaterial.IRON, 1, -2.0F, 3F, 4F, properties));
    public static DeferredItem<Item> GOLDEN_SCYTHE = registerItem("golden_scythe", properties -> new ScytheItem(ToolMaterial.GOLD, 1, -2.0F, 2F, 3F, properties));
    public static DeferredItem<Item> DIAMOND_SCYTHE = registerItem("diamond_scythe", properties -> new ScytheItem(ToolMaterial.DIAMOND, 1, -2.0F, 3.5F, 4.5F, properties));
    public static DeferredItem<Item> NETHERITE_SCYTHE = registerItem("netherite_scythe", properties -> new ScytheItem(ToolMaterial.NETHERITE, 1, -2.0F, 4.5F, 5.5F, properties.fireResistant()));
    public static DeferredItem<Item> BIOMASS_SCYTHE = registerItem("biomass_scythe", properties -> new ScytheItem(BSTiers.BIOMASS, 1, -2.0F, 3F, 3.5F, properties));
    public static DeferredItem<Item> LIVINGMETAL_SCYTHE = registerItem("livingmetal_scythe", properties -> new ScytheItem(BSTiers.LIVINGMETAL, 1, -2.0F, 3.5F, 4.5F, properties));
    public static DeferredItem<Item> BONE_SCYTHE = registerItem("bone_scythe", properties -> new ScytheItem(BSTiers.SKULL, 1, -2.0F, 2F, 2.06F, properties));
    public static DeferredItem<Item> SOUL_REAPER = registerItem("soul_reaper", properties -> new ScytheItem(BSTiers.REAPER, 1, -2.0F, 9F, 10F, properties.rarity(Rarity.EPIC).fireResistant()));

    // Shields
    public static DeferredItem<Item> WOODEN_SHIELD = registerItem("wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD, properties, 2));
    public static DeferredItem<Item> GILDED_WOODEN_SHIELD = registerItem("gilded_wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD, properties, 4));
    public static DeferredItem<Item> STONE_SHIELD = registerItem("stone_shield", properties -> new TieredShield(ToolMaterial.STONE, properties));
    public static DeferredItem<Item> GILDED_STONE_SHIELD = registerItem("gilded_stone_shield", properties -> new TieredShield(ToolMaterial.STONE, properties, 2));
    public static DeferredItem<Item> IRON_SHIELD = registerItem("iron_shield", properties -> new TieredShield(ToolMaterial.IRON, properties));
    public static DeferredItem<Item> GILDED_IRON_SHIELD = registerItem("gilded_iron_shield", properties -> new TieredShield(ToolMaterial.IRON, properties, 1, ToolMaterial.IRON.durability() / 2));
    public static DeferredItem<Item> DIAMOND_SHIELD = registerItem("diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND, properties, 1, -(ToolMaterial.DIAMOND.durability() / 2)));
    public static DeferredItem<Item> GILDED_DIAMOND_SHIELD = registerItem("gilded_diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND, properties, 1, -653));
    public static DeferredItem<Item> NETHERITE_SHIELD = registerItem("netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE, properties, 1, -(ToolMaterial.NETHERITE.durability() / 2)));
    public static DeferredItem<Item> GILDED_NETHERITE_SHIELD = registerItem("gilded_netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE, properties, 1, -793));
    public static DeferredItem<Item> ENDER_SHIELD = registerItem("ender_shield", properties -> new TieredShield(BSTiers.ENDER, properties, 1, -(BSTiers.ENDER.durability() / 2)));
    public static DeferredItem<Item> GILDED_ENDER_SHIELD = registerItem("gilded_ender_shield", properties -> new TieredShield(BSTiers.ENDER, properties, 1, -1190));
    public static DeferredItem<Item> QUARTZ_SHIELD = registerItem("quartz_shield", properties -> new TieredShield(BSTiers.QUARTZ, properties));
    public static DeferredItem<Item> GILDED_QUARTZ_SHIELD = registerItem("gilded_quartz_shield", properties -> new TieredShield(BSTiers.QUARTZ, properties, 2));
    public static DeferredItem<Item> PATCHWORK_SHIELD = registerItem("patchwork_shield", properties -> new TieredShield(BSTiers.PATCHWORK, properties, 2));
    public static DeferredItem<Item> GILDED_PATCHWORK_SHIELD = registerItem("gilded_patchwork_shield", properties -> new TieredShield(BSTiers.PATCHWORK, properties, 3));
    public static DeferredItem<Item> SKULL_SHIELD = registerItem("skull_shield", properties -> new TieredShield(BSTiers.SKULL, properties, 2));
    public static DeferredItem<Item> GILDED_SKULL_SHIELD = registerItem("gilded_skull_shield", properties -> new TieredShield(BSTiers.SKULL, properties, 3, BSTiers.SKULL.durability() / 2));
    public static DeferredItem<Item> BIOMASS_SHIELD = registerItem("biomass_shield", properties -> new TieredShield(BSTiers.BIOMASS, properties, 1, BSTiers.BIOMASS.durability() / 2));
    public static DeferredItem<Item> GILDED_BIOMASS_SHIELD = registerItem("gilded_biomass_shield", properties -> new TieredShield(BSTiers.BIOMASS, properties, 2));
    public static DeferredItem<Item> LIVINGMETAL_SHIELD = registerItem("livingmetal_shield", properties -> new TieredShield(BSTiers.LIVINGMETAL, properties, 1));
    public static DeferredItem<Item> GILDED_LIVINGMETAL_SHIELD = registerItem("gilded_livingmetal_shield", properties -> new TieredShield(BSTiers.LIVINGMETAL, properties, 2, BSTiers.LIVINGMETAL.durability() / 2));

    public static Item createBlockItemWithCustomItemName(Block block, Item.Properties properties) {
        return new BlockItem(block, properties.useItemDescriptionPrefix());
    }

    public static ResourceKey<Item> itemId(String name) {
        return ResourceKey.create(Registries.ITEM, BigSwordsR.rl(name));
    }

    public static <T extends Item> DeferredItem<T> registerItem(String name, Function<Item.Properties, T> itemCreator) {
        return ITEMS.register(name, () -> itemCreator.apply(new Item.Properties().setId(itemId(name))));
    }
}
