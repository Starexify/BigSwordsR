package net.nova.big_swords.init;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSTrimMaterials;
import net.nova.big_swords.item.*;

import java.util.function.Function;

public class BSItems {
    // Extra
    public static Item BIOMASS_SEED = registerItem("biomass_seed", createBlockItemWithUniqueName(BSBlocks.BIOMASS));
    public static Item CREEP_BALL = registerItem("creep_ball", CreepBall::new);
    public static Item SOUL = registerItem("soul", Item::new);
    public static Item BLOOD_VIAL = registerItem("blood_vial", BloodVial::new);

    // Sticks
    public static Item GIANT_WOODEN_STICK = registerItem("giant_wooden_stick", Item::new);
    public static Item GIANT_BLAZE_ROD = registerItem("giant_blaze_rod", Item::new);
    public static Item GIANT_LIVINGMETAL_HANDLE = registerItem("giant_livingmetal_handle", Item::new);

    // Ender Template
    public static Item ENDER_UPGRADE_SMITHING_TEMPLATE = registerItem("ender_upgrade_smithing_template", properties -> EnderSmithingTemplate.createEnderUpgradeTemplate(properties.rarity(Rarity.RARE)));

    // Livingmetal Stuff
    public static Item LIVINGMETAL_INGOT = registerItem("livingmetal_ingot", properties -> new Item(properties.trimMaterial(BSTrimMaterials.LIVINGMETAL)));
    public static Item LIVINGMETAL_HELMET = registerItem("livingmetal_helmet", new Item.Settings().armor(BSArmorMaterial.LIVINGMETAL, EquipmentType.HELMET));
    public static Item LIVINGMETAL_CHESTPLATE = registerItem("livingmetal_chestplate", new Item.Settings().armor(BSArmorMaterial.LIVINGMETAL, EquipmentType.CHESTPLATE));
    public static Item LIVINGMETAL_LEGGINGS = registerItem("livingmetal_leggings", new Item.Settings().armor(BSArmorMaterial.LIVINGMETAL, EquipmentType.LEGGINGS));
    public static Item LIVINGMETAL_BOOTS = registerItem("livingmetal_boots", new Item.Settings().armor(BSArmorMaterial.LIVINGMETAL, EquipmentType.BOOTS));
    public static Item LIVINGMETAL_SWORD = registerItem("livingmetal_sword", new Item.Settings().sword(BSToolMaterial.LIVINGMETAL, 3.0F, 2.4F));
    public static Item LIVINGMETAL_PICKAXE = registerItem("livingmetal_pickaxe", new Item.Settings().pickaxe(BSToolMaterial.LIVINGMETAL, 1.0F, -2.8F));
    public static Item LIVINGMETAL_AXE = registerItem("livingmetal_axe", properties -> new AxeItem(BSToolMaterial.LIVINGMETAL, 6.0F, -3.0F, properties));
    public static Item LIVINGMETAL_SHOVEL = registerItem("livingmetal_shovel", properties -> new ShovelItem(BSToolMaterial.LIVINGMETAL, 1.5F, -3.0F, properties));
    public static Item LIVINGMETAL_HOE = registerItem("livingmetal_hoe", properties -> new HoeItem(BSToolMaterial.LIVINGMETAL, -2.5F, 0.0F, properties));

    // Biomass Stuff
    public static Item BIOMASS = registerItem("biomass", Item::new);
    public static Item BIOMASS_HELMET = registerItem("biomass_helmet", new Item.Settings().armor(BSArmorMaterial.BIOMASS, EquipmentType.HELMET));
    public static Item BIOMASS_CHESTPLATE = registerItem("biomass_chestplate", new Item.Settings().armor(BSArmorMaterial.BIOMASS, EquipmentType.CHESTPLATE));
    public static Item BIOMASS_LEGGINGS = registerItem("biomass_leggings", new Item.Settings().armor(BSArmorMaterial.BIOMASS, EquipmentType.LEGGINGS));
    public static Item BIOMASS_BOOTS = registerItem("biomass_boots", new Item.Settings().armor(BSArmorMaterial.BIOMASS, EquipmentType.BOOTS));
    public static Item BIOMASS_SWORD = registerItem("biomass_sword", new Item.Settings().sword(BSToolMaterial.BIOMASS, 3.0F, -2.4F));
    public static Item BIOMASS_PICKAXE = registerItem("biomass_pickaxe", new Item.Settings().pickaxe(BSToolMaterial.BIOMASS, 1.0F, -2.8F));
    public static Item BIOMASS_AXE = registerItem("biomass_axe", properties -> new AxeItem(BSToolMaterial.BIOMASS, 6.0F, -3.0F, properties));
    public static Item BIOMASS_SHOVEL = registerItem("biomass_shovel", properties -> new ShovelItem(BSToolMaterial.BIOMASS, 1.5F, -3.0F, properties));
    public static Item BIOMASS_HOE = registerItem("biomass_hoe", properties -> new HoeItem(BSToolMaterial.BIOMASS, -2.0F, -0.5F, properties));

    // Big Swords
    public static Item WOODEN_BIG_SWORD = registerItem("wooden_big_sword", new Item.Settings().sword(ToolMaterial.WOOD, 6.5F, -2.8F).maxDamage(ToolMaterial.WOOD.durability() * 2));
    public static Item STONE_BIG_SWORD = registerItem("stone_big_sword", new Item.Settings().sword(ToolMaterial.STONE, 6.5F, -2.8F).maxDamage(ToolMaterial.STONE.durability() * 2));
    public static Item IRON_BIG_SWORD = registerItem("iron_big_sword", new Item.Settings().sword(ToolMaterial.IRON, 6.5F, -2.8F).maxDamage(ToolMaterial.IRON.durability() * 2));
    public static Item GOLDEN_BIG_SWORD = registerItem("golden_big_sword", new Item.Settings().sword(ToolMaterial.GOLD, 6.5F, -2.8F).maxDamage(ToolMaterial.GOLD.durability() * 2));
    public static Item DIAMOND_BIG_SWORD = registerItem("diamond_big_sword", new Item.Settings().sword(ToolMaterial.DIAMOND, 6.5F, -2.8F).maxDamage(ToolMaterial.DIAMOND.durability() * 2));
    public static Item NETHERITE_BIG_SWORD = registerItem("netherite_big_sword", new Item.Settings().sword(ToolMaterial.NETHERITE, 6.5F, -2.8F).maxDamage(ToolMaterial.NETHERITE.durability() * 2).fireproof());
    public static Item PATCHWORK_BIG_SWORD = registerItem("patchwork_big_sword", new Item.Settings().sword(BSToolMaterial.PATCHWORK, 6.5F, -2.4F).maxDamage(BSToolMaterial.PATCHWORK.durability() * 2));
    public static Item SKULL_BIG_SWORD = registerItem("skull_big_sword", new Item.Settings().sword(BSToolMaterial.SKULL, 6.5F, -2.6F).maxDamage(BSToolMaterial.SKULL.durability() * 2));
    public static Item QUARTZ_BIG_SWORD = registerItem("quartz_big_sword", new Item.Settings().sword(BSToolMaterial.QUARTZ, 6.5F, -2.8F).maxDamage(BSToolMaterial.QUARTZ.durability() * 2));
    public static Item OBSIDIAN_BIG_SWORD = registerItem("obsidian_big_sword", new Item.Settings().sword(BSToolMaterial.OBSIDIAN, 6.5F, -2.8F).maxDamage(BSToolMaterial.OBSIDIAN.durability() * 2));
    public static Item ENDER_BIG_SWORD = registerItem("ender_big_sword", new Item.Settings().sword(BSToolMaterial.ENDER, 6.5F, -2.8F).fireproof().maxDamage(BSToolMaterial.ENDER.durability() * 2));
    public static Item LIVINGMETAL_BIG_SWORD = registerItem("livingmetal_big_sword", new Item.Settings().sword(BSToolMaterial.LIVINGMETAL, 6.5F, -2.8F).maxDamage(BSToolMaterial.LIVINGMETAL.durability() * 2));
    public static Item BIOMASS_BIG_SWORD = registerItem("biomass_big_sword", new Item.Settings().sword(BSToolMaterial.BIOMASS, 6.5F, -2.8F).maxDamage(BSToolMaterial.BIOMASS.durability() * 2));

    // Glaives
    public static Item WOODEN_GLAIVE = registerItem("wooden_glaive", properties -> new GlaiveItem(ToolMaterial.WOOD, 2, -2.2F, 3F, 4F, properties));
    public static Item STONE_GLAIVE = registerItem("stone_glaive", properties -> new GlaiveItem(ToolMaterial.STONE, 2, -2.2F, 3.5F, 4.5F, properties));
    public static Item IRON_GLAIVE = registerItem("iron_glaive", properties -> new GlaiveItem(ToolMaterial.IRON, 2, -2.2F, 4F, 5F, properties));
    public static Item GOLDEN_GLAIVE = registerItem("golden_glaive", properties -> new GlaiveItem(ToolMaterial.GOLD, 2, -2.2F, 3F, 4F, properties));
    public static Item DIAMOND_GLAIVE = registerItem("diamond_glaive", properties -> new GlaiveItem(ToolMaterial.DIAMOND, 2, -2.2F, 4.5F, 5.5F, properties));
    public static Item NETHERITE_GLAIVE = registerItem("netherite_glaive", properties -> new GlaiveItem(ToolMaterial.NETHERITE, 2, -2.2F, 5.5F, 6.5F, properties.fireproof()));
    public static Item BIOMASS_GLAIVE = registerItem("biomass_glaive", properties -> new GlaiveItem(BSToolMaterial.BIOMASS, 2, -2.2F, 5.4F, 6.0F, properties));
    public static Item LIVINGMETAL_GLAIVE = registerItem("livingmetal_glaive", properties -> new GlaiveItem(BSToolMaterial.LIVINGMETAL, 2, -2.2F, 4.5F, 5.5F, properties));

    // Scythes
    public static Item WOODEN_SCYTHE = registerItem("wooden_scythe", properties -> new ScytheItem(ToolMaterial.WOOD, 1, -2.0F, 2F, 3F, properties));
    public static Item STONE_SCYTHE = registerItem("stone_scythe", properties -> new ScytheItem(ToolMaterial.STONE, 1, -2.0F, 2.5F, 3.5F, properties));
    public static Item IRON_SCYTHE = registerItem("iron_scythe", properties -> new ScytheItem(ToolMaterial.IRON, 1, -2.0F, 3F, 4F, properties));
    public static Item GOLDEN_SCYTHE = registerItem("golden_scythe", properties -> new ScytheItem(ToolMaterial.GOLD, 1, -2.0F, 2F, 3F, properties));
    public static Item DIAMOND_SCYTHE = registerItem("diamond_scythe", properties -> new ScytheItem(ToolMaterial.DIAMOND, 1, -2.0F, 3.5F, 4.5F, properties));
    public static Item NETHERITE_SCYTHE = registerItem("netherite_scythe", properties -> new ScytheItem(ToolMaterial.NETHERITE, 1, -2.0F, 4.5F, 5.5F, properties.fireproof()));
    public static Item BIOMASS_SCYTHE = registerItem("biomass_scythe", properties -> new ScytheItem(BSToolMaterial.BIOMASS, 1, -2.0F, 3F, 3.5F, properties));
    public static Item LIVINGMETAL_SCYTHE = registerItem("livingmetal_scythe", properties -> new ScytheItem(BSToolMaterial.LIVINGMETAL, 1, -2.0F, 3.5F, 4.5F, properties));
    public static Item BONE_SCYTHE = registerItem("bone_scythe", properties -> new ScytheItem(BSToolMaterial.SKULL, 1, -2.0F, 2F, 2.06F, properties));
    public static Item SOUL_REAPER = registerItem("soul_reaper", properties -> new ScytheItem(BSToolMaterial.REAPER, 1, -2.0F, 9F, 10F, properties.rarity(Rarity.EPIC).fireproof()));

    // Shields
    public static Item WOODEN_SHIELD = registerItem("wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD, properties, 2));
    public static Item GILDED_WOODEN_SHIELD = registerItem("gilded_wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD, properties, 4));
    public static Item STONE_SHIELD = registerItem("stone_shield", properties -> new TieredShield(ToolMaterial.STONE, properties));
    public static Item GILDED_STONE_SHIELD = registerItem("gilded_stone_shield", properties -> new TieredShield(ToolMaterial.STONE, properties, 2));
    public static Item IRON_SHIELD = registerItem("iron_shield", properties -> new TieredShield(ToolMaterial.IRON, properties));
    public static Item GILDED_IRON_SHIELD = registerItem("gilded_iron_shield", properties -> new TieredShield(ToolMaterial.IRON, properties, 1, ToolMaterial.IRON.durability() / 2));
    public static Item DIAMOND_SHIELD = registerItem("diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND, properties, 1, -(ToolMaterial.DIAMOND.durability() / 2)));
    public static Item GILDED_DIAMOND_SHIELD = registerItem("gilded_diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND, properties, 1, -653));
    public static Item NETHERITE_SHIELD = registerItem("netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE, properties, 1, -(ToolMaterial.NETHERITE.durability() / 2)));
    public static Item GILDED_NETHERITE_SHIELD = registerItem("gilded_netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE, properties, 1, -793));
    public static Item ENDER_SHIELD = registerItem("ender_shield", properties -> new TieredShield(BSToolMaterial.ENDER, properties, 1, -(BSToolMaterial.ENDER.durability() / 2)));
    public static Item GILDED_ENDER_SHIELD = registerItem("gilded_ender_shield", properties -> new TieredShield(BSToolMaterial.ENDER, properties, 1, -1190));
    public static Item QUARTZ_SHIELD = registerItem("quartz_shield", properties -> new TieredShield(BSToolMaterial.QUARTZ, properties));
    public static Item GILDED_QUARTZ_SHIELD = registerItem("gilded_quartz_shield", properties -> new TieredShield(BSToolMaterial.QUARTZ, properties, 2));
    public static Item PATCHWORK_SHIELD = registerItem("patchwork_shield", properties -> new TieredShield(BSToolMaterial.PATCHWORK, properties, 2));
    public static Item GILDED_PATCHWORK_SHIELD = registerItem("gilded_patchwork_shield", properties -> new TieredShield(BSToolMaterial.PATCHWORK, properties, 3));
    public static Item SKULL_SHIELD = registerItem("skull_shield", properties -> new TieredShield(BSToolMaterial.SKULL, properties, 2));
    public static Item GILDED_SKULL_SHIELD = registerItem("gilded_skull_shield", properties -> new TieredShield(BSToolMaterial.SKULL, properties, 3, BSToolMaterial.SKULL.durability() / 2));
    public static Item BIOMASS_SHIELD = registerItem("biomass_shield", properties -> new TieredShield(BSToolMaterial.BIOMASS, properties, 1, BSToolMaterial.BIOMASS.durability() / 2));
    public static Item GILDED_BIOMASS_SHIELD = registerItem("gilded_biomass_shield", properties -> new TieredShield(BSToolMaterial.BIOMASS, properties, 2));
    public static Item LIVINGMETAL_SHIELD = registerItem("livingmetal_shield", properties -> new TieredShield(BSToolMaterial.LIVINGMETAL, properties, 1));
    public static Item GILDED_LIVINGMETAL_SHIELD = registerItem("gilded_livingmetal_shield", properties -> new TieredShield(BSToolMaterial.LIVINGMETAL, properties, 2, BSToolMaterial.LIVINGMETAL.durability() / 2));

    // Methods
    public static <T extends Item> T registerItem(String name, Function<Item.Settings, T> factory) {
        return register(name, factory, new Item.Settings());
    }

    public static Item registerItem(String name, Item.Settings settings) {
        return register(name, Item::new, settings);
    }

    public static <T extends Item> T register(String name, Function<Item.Settings, T> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, BigSwordsR.rl(name));
        return Registry.register(Registries.ITEM, key, factory.apply(settings.registryKey(key)));
    }

    public static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Items");

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(BSItems.GIANT_WOODEN_STICK, 700);
            builder.add(BSItems.GIANT_BLAZE_ROD, 16800);
            builder.add(BSItems.WOODEN_BIG_SWORD, 200);
            builder.add(BSItems.WOODEN_SCYTHE, 200);
            builder.add(BSItems.WOODEN_GLAIVE, 200);
        });
    }
}
