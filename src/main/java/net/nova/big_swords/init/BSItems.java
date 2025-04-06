package net.nova.big_swords.init;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSTrimMaterials;
import net.nova.big_swords.item.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BSItems {
    // Extra
    public static Item BIOMASS_SEED = registerItem("biomass_seed", createBlockItemWithCustomItemName(BSBlocks.BIOMASS));
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
    public static Item LIVINGMETAL_HELMET = registerItem("livingmetal_helmet", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.HELMET)));
    public static Item LIVINGMETAL_CHESTPLATE = registerItem("livingmetal_chestplate", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.CHESTPLATE)));
    public static Item LIVINGMETAL_LEGGINGS = registerItem("livingmetal_leggings", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.LEGGINGS)));
    public static Item LIVINGMETAL_BOOTS = registerItem("livingmetal_boots", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.BOOTS)));
    public static Item LIVINGMETAL_SWORD = registerItem("livingmetal_sword", properties -> new Item(properties.sword(BSToolMaterial.LIVINGMETAL, 3.0F, 2.4F)));
    public static Item LIVINGMETAL_PICKAXE = registerItem("livingmetal_pickaxe", properties -> new Item(properties.pickaxe(BSToolMaterial.LIVINGMETAL, 1.0F, -2.8F)));
    public static Item LIVINGMETAL_AXE = registerItem("livingmetal_axe", properties -> new AxeItem(BSToolMaterial.LIVINGMETAL, 6.0F, -3.0F, properties));
    public static Item LIVINGMETAL_SHOVEL = registerItem("livingmetal_shovel", properties -> new ShovelItem(BSToolMaterial.LIVINGMETAL, 1.5F, -3.0F, properties));
    public static Item LIVINGMETAL_HOE = registerItem("livingmetal_hoe", properties -> new HoeItem(BSToolMaterial.LIVINGMETAL, -2.5F, 0.0F, properties));

    // Biomass Stuff
    public static Item BIOMASS = registerItem("biomass", Item::new);
    public static Item BIOMASS_HELMET = registerItem("biomass_helmet", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.HELMET)));
    public static Item BIOMASS_CHESTPLATE = registerItem("biomass_chestplate", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.CHESTPLATE)));
    public static Item BIOMASS_LEGGINGS = registerItem("biomass_leggings", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.LEGGINGS)));
    public static Item BIOMASS_BOOTS = registerItem("biomass_boots", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.BOOTS)));
    public static Item BIOMASS_SWORD = registerItem("biomass_sword", properties -> new Item(properties.sword(BSToolMaterial.BIOMASS, 3.0F, -2.4F)));
    public static Item BIOMASS_PICKAXE = registerItem("biomass_pickaxe", properties -> new Item(properties.pickaxe(BSToolMaterial.BIOMASS, 1.0F, -2.8F)));
    public static Item BIOMASS_AXE = registerItem("biomass_axe", properties -> new AxeItem(BSToolMaterial.BIOMASS, 6.0F, -3.0F, properties));
    public static Item BIOMASS_SHOVEL = registerItem("biomass_shovel", properties -> new ShovelItem(BSToolMaterial.BIOMASS, 1.5F, -3.0F, properties));
    public static Item BIOMASS_HOE = registerItem("biomass_hoe", properties -> new HoeItem(BSToolMaterial.BIOMASS, -2.0F, -0.5F, properties));

    // Big Swords
    public static Item WOODEN_BIG_SWORD = registerItem("wooden_big_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 6.5F, -2.8F).durability(ToolMaterial.WOOD.durability() * 2)));
    public static Item STONE_BIG_SWORD = registerItem("stone_big_sword", properties -> new Item(properties.sword(ToolMaterial.STONE, 6.5F, -2.8F).durability(ToolMaterial.STONE.durability() * 2)));
    public static Item IRON_BIG_SWORD = registerItem("iron_big_sword", properties -> new Item(properties.sword(ToolMaterial.IRON, 6.5F, -2.8F).durability(ToolMaterial.IRON.durability() * 2)));
    public static Item GOLDEN_BIG_SWORD = registerItem("golden_big_sword", properties -> new Item(properties.sword(ToolMaterial.GOLD, 6.5F, -2.8F).durability(ToolMaterial.GOLD.durability() * 2)));
    public static Item DIAMOND_BIG_SWORD = registerItem("diamond_big_sword", properties -> new Item(properties.sword(ToolMaterial.DIAMOND, 6.5F, -2.8F).durability(ToolMaterial.DIAMOND.durability() * 2)));
    public static Item NETHERITE_BIG_SWORD = registerItem("netherite_big_sword", properties -> new Item(properties.sword(ToolMaterial.NETHERITE, 6.5F, -2.8F).durability(ToolMaterial.NETHERITE.durability() * 2).fireResistant()));
    public static Item PATCHWORK_BIG_SWORD = registerItem("patchwork_big_sword", properties -> new Item(properties.sword(BSToolMaterial.PATCHWORK, 6.5F, -2.4F).durability(BSToolMaterial.PATCHWORK.durability() * 2)));
    public static Item SKULL_BIG_SWORD = registerItem("skull_big_sword", properties -> new Item(properties.sword(BSToolMaterial.SKULL, 6.5F, -2.6F).durability(BSToolMaterial.SKULL.durability() * 2)));
    public static Item QUARTZ_BIG_SWORD = registerItem("quartz_big_sword", properties -> new Item(properties.sword(BSToolMaterial.QUARTZ, 6.5F, -2.8F).durability(BSToolMaterial.QUARTZ.durability() * 2)));
    public static Item OBSIDIAN_BIG_SWORD = registerItem("obsidian_big_sword", properties -> new Item(properties.sword(BSToolMaterial.OBSIDIAN, 6.5F, -2.8F).durability(BSToolMaterial.OBSIDIAN.durability() * 2)));
    public static Item ENDER_BIG_SWORD = registerItem("ender_big_sword", properties -> new Item(properties.sword(BSToolMaterial.ENDER, 6.5F, -2.8F).fireResistant().durability(BSToolMaterial.ENDER.durability() * 2)));
    public static Item LIVINGMETAL_BIG_SWORD = registerItem("livingmetal_big_sword", properties -> new Item(properties.sword(BSToolMaterial.LIVINGMETAL, 6.5F, -2.8F).durability(BSToolMaterial.LIVINGMETAL.durability() * 2)));
    public static Item BIOMASS_BIG_SWORD = registerItem("biomass_big_sword", properties -> new Item(properties.sword(BSToolMaterial.BIOMASS, 6.5F, -2.8F).durability(BSToolMaterial.BIOMASS.durability() * 2)));

    // Glaives
    public static Item WOODEN_GLAIVE = registerItem("wooden_glaive", properties -> new GlaiveItem(ToolMaterial.WOOD, 2, -2.2F, 3F, 4F, properties));
    public static Item STONE_GLAIVE = registerItem("stone_glaive", properties -> new GlaiveItem(ToolMaterial.STONE, 2, -2.2F, 3.5F, 4.5F, properties));
    public static Item IRON_GLAIVE = registerItem("iron_glaive", properties -> new GlaiveItem(ToolMaterial.IRON, 2, -2.2F, 4F, 5F, properties));
    public static Item GOLDEN_GLAIVE = registerItem("golden_glaive", properties -> new GlaiveItem(ToolMaterial.GOLD, 2, -2.2F, 3F, 4F, properties));
    public static Item DIAMOND_GLAIVE = registerItem("diamond_glaive", properties -> new GlaiveItem(ToolMaterial.DIAMOND, 2, -2.2F, 4.5F, 5.5F, properties));
    public static Item NETHERITE_GLAIVE = registerItem("netherite_glaive", properties -> new GlaiveItem(ToolMaterial.NETHERITE, 2, -2.2F, 5.5F, 6.5F, properties.fireResistant()));
    public static Item BIOMASS_GLAIVE = registerItem("biomass_glaive", properties -> new GlaiveItem(BSToolMaterial.BIOMASS, 2, -2.2F, 5.4F, 6.0F, properties));
    public static Item LIVINGMETAL_GLAIVE = registerItem("livingmetal_glaive", properties -> new GlaiveItem(BSToolMaterial.LIVINGMETAL, 2, -2.2F, 4.5F, 5.5F, properties));

    // Scythes
    public static Item WOODEN_SCYTHE = registerItem("wooden_scythe", properties -> new ScytheItem(ToolMaterial.WOOD, 1, -2.0F, 2F, 3F, properties));
    public static Item STONE_SCYTHE = registerItem("stone_scythe", properties -> new ScytheItem(ToolMaterial.STONE, 1, -2.0F, 2.5F, 3.5F, properties));
    public static Item IRON_SCYTHE = registerItem("iron_scythe", properties -> new ScytheItem(ToolMaterial.IRON, 1, -2.0F, 3F, 4F, properties));
    public static Item GOLDEN_SCYTHE = registerItem("golden_scythe", properties -> new ScytheItem(ToolMaterial.GOLD, 1, -2.0F, 2F, 3F, properties));
    public static Item DIAMOND_SCYTHE = registerItem("diamond_scythe", properties -> new ScytheItem(ToolMaterial.DIAMOND, 1, -2.0F, 3.5F, 4.5F, properties));
    public static Item NETHERITE_SCYTHE = registerItem("netherite_scythe", properties -> new ScytheItem(ToolMaterial.NETHERITE, 1, -2.0F, 4.5F, 5.5F, properties.fireResistant()));
    public static Item BIOMASS_SCYTHE = registerItem("biomass_scythe", properties -> new ScytheItem(BSToolMaterial.BIOMASS, 1, -2.0F, 3F, 3.5F, properties));
    public static Item LIVINGMETAL_SCYTHE = registerItem("livingmetal_scythe", properties -> new ScytheItem(BSToolMaterial.LIVINGMETAL, 1, -2.0F, 3.5F, 4.5F, properties));
    public static Item BONE_SCYTHE = registerItem("bone_scythe", properties -> new ScytheItem(BSToolMaterial.SKULL, 1, -2.0F, 2F, 2.06F, properties));
    public static Item SOUL_REAPER = registerItem("soul_reaper", properties -> new ScytheItem(BSToolMaterial.REAPER, 1, -2.0F, 9F, 10F, properties.rarity(Rarity.EPIC).fireResistant()));

    // Shields
    public static Item WOODEN_SHIELD = registerItem("wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 2));
    public static Item GILDED_WOODEN_SHIELD = registerItem("gilded_wooden_shield", properties -> new TieredShield(ToolMaterial.WOOD,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 4));
    public static Item STONE_SHIELD = registerItem("stone_shield", properties -> new TieredShield(ToolMaterial.STONE,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            ))));
    public static Item GILDED_STONE_SHIELD = registerItem("gilded_stone_shield", properties -> new TieredShield(ToolMaterial.STONE,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 2));
    public static Item IRON_SHIELD = registerItem("iron_shield", properties -> new TieredShield(ToolMaterial.IRON,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            ))));
    public static Item GILDED_IRON_SHIELD = registerItem("gilded_iron_shield", properties -> new TieredShield(ToolMaterial.IRON,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 1, ToolMaterial.IRON.durability() / 2));
    public static Item DIAMOND_SHIELD = registerItem("diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 1, -(ToolMaterial.DIAMOND.durability() / 2)));
    public static Item GILDED_DIAMOND_SHIELD = registerItem("gilded_diamond_shield", properties -> new TieredShield(ToolMaterial.DIAMOND,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 1, -653));
    public static Item NETHERITE_SHIELD = registerItem("netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )).fireResistant(), 1, -(ToolMaterial.NETHERITE.durability() / 2)));
    public static Item GILDED_NETHERITE_SHIELD = registerItem("gilded_netherite_shield", properties -> new TieredShield(ToolMaterial.NETHERITE,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )).fireResistant(), 1, -793));
    public static Item ENDER_SHIELD = registerItem("ender_shield", properties -> new TieredShield(BSToolMaterial.ENDER,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )).fireResistant(), 1, -(BSToolMaterial.ENDER.durability() / 2)));
    public static Item GILDED_ENDER_SHIELD = registerItem("gilded_ender_shield", properties -> new TieredShield(BSToolMaterial.ENDER,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )).fireResistant(), 1, -1190));
    public static Item QUARTZ_SHIELD = registerItem("quartz_shield", properties -> new TieredShield(BSToolMaterial.QUARTZ,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            ))));
    public static Item GILDED_QUARTZ_SHIELD = registerItem("gilded_quartz_shield", properties -> new TieredShield(BSToolMaterial.QUARTZ,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 2));
    public static Item PATCHWORK_SHIELD = registerItem("patchwork_shield", properties -> new TieredShield(BSToolMaterial.PATCHWORK,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 2));
    public static Item GILDED_PATCHWORK_SHIELD = registerItem("gilded_patchwork_shield", properties -> new TieredShield(BSToolMaterial.PATCHWORK,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 3));
    public static Item SKULL_SHIELD = registerItem("skull_shield", properties -> new TieredShield(BSToolMaterial.SKULL,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 2));
    public static Item GILDED_SKULL_SHIELD = registerItem("gilded_skull_shield", properties -> new TieredShield(BSToolMaterial.SKULL,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 3, BSToolMaterial.SKULL.durability() / 2));
    public static Item BIOMASS_SHIELD = registerItem("biomass_shield", properties -> new TieredShield(BSToolMaterial.BIOMASS,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 1, BSToolMaterial.BIOMASS.durability() / 2));
    public static Item GILDED_BIOMASS_SHIELD = registerItem("gilded_biomass_shield", properties -> new TieredShield(BSToolMaterial.BIOMASS,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 2));
    public static Item LIVINGMETAL_SHIELD = registerItem("livingmetal_shield", properties -> new TieredShield(BSToolMaterial.LIVINGMETAL,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 1));
    public static Item GILDED_LIVINGMETAL_SHIELD = registerItem("gilded_livingmetal_shield", properties -> new TieredShield(BSToolMaterial.LIVINGMETAL,
            properties.component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.25F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)
            )), 2, BSToolMaterial.LIVINGMETAL.durability() / 2));

    // Methods
    public static <T extends Item> T registerItem(String name, Function<Item.Properties, T> function) {
        return register(name, function, new Item.Properties());
    }

    public static <T extends Item> T register(String name, Function<Item.Properties, T> function, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, BigSwordsR.rl(name));
        return Registry.register(BuiltInRegistries.ITEM, key, function.apply(properties.setId(key)));
    }

    public static Function<Item.Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useBlockDescriptionPrefix());
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
