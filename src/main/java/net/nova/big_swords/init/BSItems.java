package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.item.*;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Extra
    public static DeferredItem<BlockItem> BIOMASS_SEED = registerSimpleBlockItem("biomass_seed", BSBlocks.BIOMASS);
    public static DeferredItem<Item> CREEP_BALL = ITEMS.registerItem("creep_ball", CreepBall::new);
    public static DeferredItem<Item> SOUL = ITEMS.registerItem("soul", Soul::new);
    public static DeferredItem<Item> BLOOD_VIAL = ITEMS.registerItem("blood_vial", BloodVial::new);

    // Sticks
    public static DeferredItem<Item> GIANT_WOODEN_STICK = ITEMS.registerSimpleItem("giant_wooden_stick");
    public static DeferredItem<Item> GIANT_BLAZE_ROD = ITEMS.registerSimpleItem("giant_blaze_rod");
    public static DeferredItem<Item> GIANT_LIVINGMETAL_HANDLE = ITEMS.registerSimpleItem("giant_livingmetal_handle");

    // Ender Template
    public static DeferredItem<Item> ENDER_UPGRADE_SMITHING_TEMPLATE = ITEMS.registerItem("ender_upgrade_smithing_template", properties -> EnderSmithingTemplate.createEnderUpgradeTemplate(properties.rarity(Rarity.RARE)));

    // Livingmetal Stuff
    public static DeferredItem<Item> LIVINGMETAL_INGOT = ITEMS.registerSimpleItem("livingmetal_ingot");
    public static DeferredItem<Item> LIVINGMETAL_HELMET = ITEMS.registerItem("livingmetal_helmet", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorType.HELMET, properties));
    public static DeferredItem<Item> LIVINGMETAL_CHESTPLATE = ITEMS.registerItem("livingmetal_chestplate", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorType.CHESTPLATE, properties));
    public static DeferredItem<Item> LIVINGMETAL_LEGGINGS = ITEMS.registerItem("livingmetal_leggings", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorType.LEGGINGS, properties));
    public static DeferredItem<Item> LIVINGMETAL_BOOTS = ITEMS.registerItem("livingmetal_boots", properties -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorType.BOOTS, properties));
    public static DeferredItem<Item> LIVINGMETAL_SWORD = ITEMS.registerItem("livingmetal_sword", properties -> new SwordItem(BSToolMaterial.LIVINGMETAL, 3.0F, 2.4F, properties));
    public static DeferredItem<Item> LIVINGMETAL_PICKAXE = ITEMS.registerItem("livingmetal_pickaxe", properties -> new PickaxeItem(BSToolMaterial.LIVINGMETAL, 1.0F, -2.8F, properties));
    public static DeferredItem<Item> LIVINGMETAL_AXE = ITEMS.registerItem("livingmetal_axe", properties -> new AxeItem(BSToolMaterial.LIVINGMETAL, 6.0F, -3.0F, properties));
    public static DeferredItem<Item> LIVINGMETAL_SHOVEL = ITEMS.registerItem("livingmetal_shovel", properties -> new ShovelItem(BSToolMaterial.LIVINGMETAL, 1.5F, -3.0F, properties));
    public static DeferredItem<Item> LIVINGMETAL_HOE = ITEMS.registerItem("livingmetal_hoe", properties -> new HoeItem(BSToolMaterial.LIVINGMETAL, -2.5F, 0.0F, properties));

    // Biomass Stuff
    public static DeferredItem<Item> BIOMASS = ITEMS.registerSimpleItem("biomass");
    public static DeferredItem<Item> BIOMASS_HELMET = ITEMS.registerItem("biomass_helmet", properties -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorType.HELMET, properties));
    public static DeferredItem<Item> BIOMASS_CHESTPLATE = ITEMS.registerItem("biomass_chestplate", properties -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorType.CHESTPLATE, properties));
    public static DeferredItem<Item> BIOMASS_LEGGINGS = ITEMS.registerItem("biomass_leggings", properties -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorType.LEGGINGS, properties));
    public static DeferredItem<Item> BIOMASS_BOOTS = ITEMS.registerItem("biomass_boots", properties -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorType.BOOTS, properties));
    public static DeferredItem<Item> BIOMASS_SWORD = ITEMS.registerItem("biomass_sword", properties -> new SwordItem(BSToolMaterial.BIOMASS, 3.0F, -2.4F, properties));
    public static DeferredItem<Item> BIOMASS_PICKAXE = ITEMS.registerItem("biomass_pickaxe", properties -> new PickaxeItem(BSToolMaterial.BIOMASS, 1.0F, -2.8F, properties));
    public static DeferredItem<Item> BIOMASS_AXE = ITEMS.registerItem("biomass_axe", properties -> new AxeItem(BSToolMaterial.BIOMASS, 6.0F, -3.0F, properties));
    public static DeferredItem<Item> BIOMASS_SHOVEL = ITEMS.registerItem("biomass_shovel", properties -> new ShovelItem(BSToolMaterial.BIOMASS, 1.5F, -3.0F, properties));
    public static DeferredItem<Item> BIOMASS_HOE = ITEMS.registerItem("biomass_hoe", properties -> new HoeItem(BSToolMaterial.BIOMASS, -2.0F, -0.5F, properties));

    // Big Swords
    public static DeferredItem<Item> WOODEN_BIG_SWORD = ITEMS.registerItem("wooden_big_sword", properties -> new BigSwordItem(ToolMaterial.WOOD, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> STONE_BIG_SWORD = ITEMS.registerItem("stone_big_sword", properties -> new BigSwordItem(ToolMaterial.STONE, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> IRON_BIG_SWORD = ITEMS.registerItem("iron_big_sword", properties -> new BigSwordItem(ToolMaterial.IRON, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> GOLDEN_BIG_SWORD = ITEMS.registerItem("golden_big_sword", properties -> new BigSwordItem(ToolMaterial.GOLD, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> DIAMOND_BIG_SWORD = ITEMS.registerItem("diamond_big_sword", properties -> new BigSwordItem(ToolMaterial.DIAMOND, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> NETHERITE_BIG_SWORD = ITEMS.registerItem("netherite_big_sword", properties -> new BigSwordItem(ToolMaterial.NETHERITE, 6.5F, -2.8F, properties.fireResistant()));
    public static DeferredItem<Item> PATCHWORK_BIG_SWORD = ITEMS.registerItem("patchwork_big_sword", properties -> new BigSwordItem(BSToolMaterial.PATCHWORK, 6.5F, -2.4F, properties));
    public static DeferredItem<Item> SKULL_BIG_SWORD = ITEMS.registerItem("skull_big_sword", properties -> new BigSwordItem(BSToolMaterial.SKULL, 6.5F, -2.6F, properties));
    public static DeferredItem<Item> QUARTZ_BIG_SWORD = ITEMS.registerItem("quartz_big_sword", properties -> new BigSwordItem(BSToolMaterial.QUARTZ, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> OBSIDIAN_BIG_SWORD = ITEMS.registerItem("obsidian_big_sword", properties -> new BigSwordItem(BSToolMaterial.OBSIDIAN, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> ENDER_BIG_SWORD = ITEMS.registerItem("ender_big_sword", properties -> new BigSwordItem(BSToolMaterial.ENDER, 6.5F, -2.8F, properties.fireResistant()));
    public static DeferredItem<Item> LIVINGMETAL_BIG_SWORD = ITEMS.registerItem("livingmetal_big_sword", properties -> new BigSwordItem(BSToolMaterial.LIVINGMETAL, 6.5F, -2.8F, properties));
    public static DeferredItem<Item> BIOMASS_BIG_SWORD = ITEMS.registerItem("biomass_big_sword", properties -> new BigSwordItem(BSToolMaterial.BIOMASS, 6.5F, -2.8F, properties));

    // Glaives
    public static DeferredItem<Item> WOODEN_GLAIVE = ITEMS.registerItem("wooden_glaive", properties -> new GlaiveItem(ToolMaterial.WOOD, 2, -2.2F, 3F, 4F, properties));
    public static DeferredItem<Item> STONE_GLAIVE = ITEMS.registerItem("stone_glaive", properties -> new GlaiveItem(ToolMaterial.STONE, 2, -2.2F, 3.5F, 4.5F, properties));
    public static DeferredItem<Item> IRON_GLAIVE = ITEMS.registerItem("iron_glaive", properties -> new GlaiveItem(ToolMaterial.IRON, 2, -2.2F, 4F, 5F, properties));
    public static DeferredItem<Item> GOLDEN_GLAIVE = ITEMS.registerItem("golden_glaive", properties -> new GlaiveItem(ToolMaterial.GOLD, 2, -2.2F, 3F, 4F, properties));
    public static DeferredItem<Item> DIAMOND_GLAIVE = ITEMS.registerItem("diamond_glaive", properties -> new GlaiveItem(ToolMaterial.DIAMOND, 2, -2.2F, 4.5F, 5.5F, properties));
    public static DeferredItem<Item> NETHERITE_GLAIVE = ITEMS.registerItem("netherite_glaive", properties -> new GlaiveItem(ToolMaterial.NETHERITE, 2, -2.2F, 5.5F, 6.5F, properties.fireResistant()));
    public static DeferredItem<Item> BIOMASS_GLAIVE = ITEMS.registerItem("biomass_glaive", properties -> new GlaiveItem(BSToolMaterial.BIOMASS, 2, -2.2F, 5.4F, 6.0F, properties));
    public static DeferredItem<Item> LIVINGMETAL_GLAIVE = ITEMS.registerItem("livingmetal_glaive", properties -> new GlaiveItem(BSToolMaterial.LIVINGMETAL, 2, -2.2F, 4.5F, 5.5F, properties));

    // Scythes
    public static DeferredItem<Item> WOODEN_SCYTHE = ITEMS.registerItem("wooden_scythe", properties -> new ScytheItem(ToolMaterial.WOOD, 1, -2.0F, 2F, 3F, properties));
    public static DeferredItem<Item> STONE_SCYTHE = ITEMS.registerItem("stone_scythe", properties -> new ScytheItem(ToolMaterial.STONE, 1, -2.0F, 2.5F, 3.5F, properties));
    public static DeferredItem<Item> IRON_SCYTHE = ITEMS.registerItem("iron_scythe", properties -> new ScytheItem(ToolMaterial.IRON, 1, -2.0F, 3F, 4F, properties));
    public static DeferredItem<Item> GOLDEN_SCYTHE = ITEMS.registerItem("golden_scythe", properties -> new ScytheItem(ToolMaterial.GOLD, 1, -2.0F, 2F, 3F, properties));
    public static DeferredItem<Item> DIAMOND_SCYTHE = ITEMS.registerItem("diamond_scythe", properties -> new ScytheItem(ToolMaterial.DIAMOND, 1, -2.0F, 3.5F, 4.5F, properties));
    public static DeferredItem<Item> NETHERITE_SCYTHE = ITEMS.registerItem("netherite_scythe", properties -> new ScytheItem(ToolMaterial.NETHERITE, 1, -2.0F, 4.5F, 5.5F, properties.fireResistant()));
    public static DeferredItem<Item> BIOMASS_SCYTHE = ITEMS.registerItem("biomass_scythe", properties -> new ScytheItem(BSToolMaterial.BIOMASS, 1, -2.0F, 3F, 3.5F, properties));
    public static DeferredItem<Item> LIVINGMETAL_SCYTHE = ITEMS.registerItem("livingmetal_scythe", properties -> new ScytheItem(BSToolMaterial.LIVINGMETAL, 1, -2.0F, 3.5F, 4.5F, properties));
    public static DeferredItem<Item> BONE_SCYTHE = ITEMS.registerItem("bone_scythe", properties -> new ScytheItem(BSToolMaterial.SKULL, 1, -2.0F, 2F, 2.06F, properties));
    public static DeferredItem<Item> SOUL_REAPER = ITEMS.registerItem("soul_reaper", properties -> new ScytheItem(BSToolMaterial.REAPER, 1, -2.0F, 9F, 10F, properties.rarity(Rarity.EPIC).fireResistant()));

    // Shields
    public static DeferredItem<Item> WOODEN_SHIELD = ITEMS.registerItem("wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD, properties, 2));
    public static DeferredItem<Item> GILDED_WOODEN_SHIELD = ITEMS.registerItem("gilded_wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD, properties, 4));
    public static DeferredItem<Item> STONE_SHIELD = ITEMS.registerItem("stone_shield", properties -> new TieredShield(ToolMaterial.STONE, properties));
    public static DeferredItem<Item> GILDED_STONE_SHIELD = ITEMS.registerItem("gilded_stone_shield", properties -> new TieredShield(ToolMaterial.STONE, properties, 2));
    public static DeferredItem<Item> IRON_SHIELD = ITEMS.registerItem("iron_shield", properties -> new TieredShield(ToolMaterial.IRON, properties));
    public static DeferredItem<Item> GILDED_IRON_SHIELD = ITEMS.registerItem("gilded_iron_shield", properties -> new TieredShield(ToolMaterial.IRON, properties, 1, ToolMaterial.IRON.durability() / 2));
    public static DeferredItem<Item> DIAMOND_SHIELD = ITEMS.registerItem("diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND, properties, 1, -(ToolMaterial.DIAMOND.durability() / 2)));
    public static DeferredItem<Item> GILDED_DIAMOND_SHIELD = ITEMS.registerItem("gilded_diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND, properties, 1, -653));
    public static DeferredItem<Item> NETHERITE_SHIELD = ITEMS.registerItem("netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE, properties, 1, -(ToolMaterial.NETHERITE.durability() / 2)));
    public static DeferredItem<Item> GILDED_NETHERITE_SHIELD = ITEMS.registerItem("gilded_netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE, properties, 1, -793));
    public static DeferredItem<Item> ENDER_SHIELD = ITEMS.registerItem("ender_shield", properties -> new TieredShield(BSToolMaterial.ENDER, properties, 1, -(BSToolMaterial.ENDER.durability() / 2)));
    public static DeferredItem<Item> GILDED_ENDER_SHIELD = ITEMS.registerItem("gilded_ender_shield", properties -> new TieredShield(BSToolMaterial.ENDER, properties, 1, -1190));
    public static DeferredItem<Item> QUARTZ_SHIELD = ITEMS.registerItem("quartz_shield", properties -> new TieredShield(BSToolMaterial.QUARTZ, properties));
    public static DeferredItem<Item> GILDED_QUARTZ_SHIELD = ITEMS.registerItem("gilded_quartz_shield", properties -> new TieredShield(BSToolMaterial.QUARTZ, properties, 2));
    public static DeferredItem<Item> PATCHWORK_SHIELD = ITEMS.registerItem("patchwork_shield", properties -> new TieredShield(BSToolMaterial.PATCHWORK, properties, 2));
    public static DeferredItem<Item> GILDED_PATCHWORK_SHIELD = ITEMS.registerItem("gilded_patchwork_shield", properties -> new TieredShield(BSToolMaterial.PATCHWORK, properties, 3));
    public static DeferredItem<Item> SKULL_SHIELD = ITEMS.registerItem("skull_shield", properties -> new TieredShield(BSToolMaterial.SKULL, properties, 2));
    public static DeferredItem<Item> GILDED_SKULL_SHIELD = ITEMS.registerItem("gilded_skull_shield", properties -> new TieredShield(BSToolMaterial.SKULL, properties, 3, BSToolMaterial.SKULL.durability() / 2));
    public static DeferredItem<Item> BIOMASS_SHIELD = ITEMS.registerItem("biomass_shield", properties -> new TieredShield(BSToolMaterial.BIOMASS, properties, 1, BSToolMaterial.BIOMASS.durability() / 2));
    public static DeferredItem<Item> GILDED_BIOMASS_SHIELD = ITEMS.registerItem("gilded_biomass_shield", properties -> new TieredShield(BSToolMaterial.BIOMASS, properties, 2));
    public static DeferredItem<Item> LIVINGMETAL_SHIELD = ITEMS.registerItem("livingmetal_shield", properties -> new TieredShield(BSToolMaterial.LIVINGMETAL, properties, 1));
    public static DeferredItem<Item> GILDED_LIVINGMETAL_SHIELD = ITEMS.registerItem("gilded_livingmetal_shield", properties -> new TieredShield(BSToolMaterial.LIVINGMETAL, properties, 2, BSToolMaterial.LIVINGMETAL.durability() / 2));

    // Register
    public static DeferredItem<BlockItem> registerSimpleBlockItem(String name, Supplier<? extends Block> block) {
        return ITEMS.register(name, key -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, key))));
    }
}
