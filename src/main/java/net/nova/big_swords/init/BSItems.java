package net.nova.big_swords.init;

import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.data.BSTrimMaterials;
import net.nova.big_swords.item.*;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

  // Extra
  public static DeferredItem<BlockItem> BIOMASS_SEEDS = ITEMS.registerSimpleBlockItem("biomass_seed", BSBlocks.BIOMASS);
  public static DeferredItem<Item> CREEP_BALL = ITEMS.registerItem("creep_ball", CreepBall::new);
  public static DeferredItem<Item> SOUL = ITEMS.registerItem("soul", Soul::new);
  public static DeferredItem<Item> BLOOD_VIAL = ITEMS.registerItem("blood_vial", BloodVial::new);

  // Sticks
  public static DeferredItem<Item> GIANT_WOODEN_STICK = ITEMS.registerSimpleItem("giant_wooden_stick");
  public static DeferredItem<Item> GIANT_BLAZE_ROD = ITEMS.registerSimpleItem("giant_blaze_rod");
  public static DeferredItem<Item> GIANT_LIVINGMETAL_HANDLE = ITEMS.registerSimpleItem("giant_livingmetal_handle");

  // Ender Template
  public static DeferredItem<Item> ENDER_UPGRADE_SMITHING_TEMPLATE = ITEMS.registerItem("ender_upgrade_smithing_template", p -> EnderSmithingTemplate.createEnderUpgradeTemplate(p.rarity(Rarity.RARE)));

  // Livingmetal Stuff
  public static DeferredItem<Item> LIVINGMETAL_INGOT = ITEMS.registerItem("livingmetal_ingot", p -> new Item(p.trimMaterial(BSTrimMaterials.LIVINGMETAL)));
  public static DeferredItem<Item> LIVINGMETAL_HELMET = ITEMS.registerItem("livingmetal_helmet", p -> new Item(p.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.HELMET)));
  public static DeferredItem<Item> LIVINGMETAL_CHESTPLATE = ITEMS.registerItem("livingmetal_chestplate", p -> new Item(p.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.CHESTPLATE)));
  public static DeferredItem<Item> LIVINGMETAL_LEGGINGS = ITEMS.registerItem("livingmetal_leggings", p -> new Item(p.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.LEGGINGS)));
  public static DeferredItem<Item> LIVINGMETAL_BOOTS = ITEMS.registerItem("livingmetal_boots", p -> new Item(p.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.BOOTS)));
  public static DeferredItem<Item> LIVINGMETAL_SWORD = ITEMS.registerItem("livingmetal_sword", p -> new Item(p.sword(BSToolMaterial.LIVINGMETAL, 3.0F, -2.4F)));
  public static DeferredItem<Item> LIVINGMETAL_PICKAXE = ITEMS.registerItem("livingmetal_pickaxe", p -> new Item(p.pickaxe(BSToolMaterial.LIVINGMETAL, 1.0F, -2.8F)));
  public static DeferredItem<Item> LIVINGMETAL_AXE = ITEMS.registerItem("livingmetal_axe", p -> new AxeItem(BSToolMaterial.LIVINGMETAL, 6.0F, -2.5F, p));
  public static DeferredItem<Item> LIVINGMETAL_SHOVEL = ITEMS.registerItem("livingmetal_shovel", p -> new ShovelItem(BSToolMaterial.LIVINGMETAL, 1.5F, -2.5F, p));
  public static DeferredItem<Item> LIVINGMETAL_HOE = ITEMS.registerItem("livingmetal_hoe", p -> new HoeItem(BSToolMaterial.LIVINGMETAL, -2.0F, 0.0F, p));
  public static DeferredItem<Item> LIVINGMETAL_SPEAR = ITEMS.registerItem("livingmetal_spear", p -> new Item(p.spear(BSToolMaterial.LIVINGMETAL, 1.00F, 1.00F, 0.5F, 2.5F, 10.5F, 6.5F, 5.1F, 10.75F, 4.6F)));

  // Biomass Stuff
  public static DeferredItem<Item> BIOMASS = ITEMS.registerSimpleItem("biomass");
  public static DeferredItem<Item> BIOMASS_HELMET = ITEMS.registerItem("biomass_helmet", p -> new Item(p.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.HELMET)));
  public static DeferredItem<Item> BIOMASS_CHESTPLATE = ITEMS.registerItem("biomass_chestplate", p -> new Item(p.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.CHESTPLATE)));
  public static DeferredItem<Item> BIOMASS_LEGGINGS = ITEMS.registerItem("biomass_leggings", p -> new Item(p.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.LEGGINGS)));
  public static DeferredItem<Item> BIOMASS_BOOTS = ITEMS.registerItem("biomass_boots", p -> new Item(p.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.BOOTS)));
  public static DeferredItem<Item> BIOMASS_SWORD = ITEMS.registerItem("biomass_sword", p -> new Item(p.sword(BSToolMaterial.BIOMASS, 3.0F, -2.4F)));
  public static DeferredItem<Item> BIOMASS_PICKAXE = ITEMS.registerItem("biomass_pickaxe", p -> new Item(p.pickaxe(BSToolMaterial.BIOMASS, 1.0F, -2.8F)));
  public static DeferredItem<Item> BIOMASS_AXE = ITEMS.registerItem("biomass_axe", p -> new AxeItem(BSToolMaterial.BIOMASS, 6.0F, -3.0F, p));
  public static DeferredItem<Item> BIOMASS_SHOVEL = ITEMS.registerItem("biomass_shovel", p -> new ShovelItem(BSToolMaterial.BIOMASS, 1.5F, -3.0F, p));
  public static DeferredItem<Item> BIOMASS_HOE = ITEMS.registerItem("biomass_hoe", p -> new HoeItem(BSToolMaterial.BIOMASS, -2.0F, -0.5F, p));
  public static DeferredItem<Item> BIOMASS_SPEAR = ITEMS.registerItem("biomass_spear", p -> new Item(p.spear(BSToolMaterial.BIOMASS, 1.05F, 0.95F, 0.5F, 2.5F, 10.0F, 6.75F, 5.1F, 11.0F, 4.6F)));

  // Big Swords
  public static DeferredItem<Item> WOODEN_BIG_SWORD = ITEMS.registerItem("wooden_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.WOOD, 7.0F, -2.8F)));
  public static DeferredItem<Item> STONE_BIG_SWORD = ITEMS.registerItem("stone_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.STONE, 7.0F, -2.8F)));
  public static DeferredItem<Item> COPPER_BIG_SWORD = ITEMS.registerItem("copper_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.COPPER, 7.0F, -2.8F)));
  public static DeferredItem<Item> IRON_BIG_SWORD = ITEMS.registerItem("iron_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.IRON, 7.0F, -2.8F)));
  public static DeferredItem<Item> GOLDEN_BIG_SWORD = ITEMS.registerItem("golden_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.GOLD, 7.0F, -2.8F)));
  public static DeferredItem<Item> DIAMOND_BIG_SWORD = ITEMS.registerItem("diamond_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.DIAMOND, 7.0F, -2.8F)));
  public static DeferredItem<Item> NETHERITE_BIG_SWORD = ITEMS.registerItem("netherite_big_sword", p -> new Item(BSToolMaterial.bigSword(p.fireResistant(), ToolMaterial.NETHERITE, 7.0F, -2.8F)));
  public static DeferredItem<Item> PATCHWORK_BIG_SWORD = ITEMS.registerItem("patchwork_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.PATCHWORK, 6.5F, -2.4F)));
  public static DeferredItem<Item> SKULL_BIG_SWORD = ITEMS.registerItem("skull_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.SKULL, 6.5F, -2.6F)));
  public static DeferredItem<Item> QUARTZ_BIG_SWORD = ITEMS.registerItem("quartz_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.QUARTZ, 7.0F, -2.8F)));
  public static DeferredItem<Item> OBSIDIAN_BIG_SWORD = ITEMS.registerItem("obsidian_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.OBSIDIAN, 5.5F, -2.8F)));
  public static DeferredItem<Item> ENDER_BIG_SWORD = ITEMS.registerItem("ender_big_sword", p -> new Item(BSToolMaterial.bigSword(p.fireResistant(), BSToolMaterial.ENDER, 7.5F, -2.8F)));
  public static DeferredItem<Item> LIVINGMETAL_BIG_SWORD = ITEMS.registerItem("livingmetal_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.LIVINGMETAL, 6.0F, -2.8F)));
  public static DeferredItem<Item> BIOMASS_BIG_SWORD = ITEMS.registerItem("biomass_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.BIOMASS, 7.0F, -2.8F)));

  // Glaives
  public static DeferredItem<Item> WOODEN_GLAIVE = ITEMS.registerItem("wooden_glaive", p -> new GlaiveItem(ToolMaterial.WOOD, 2, -2.2F, 3F, 4F, p));
  public static DeferredItem<Item> STONE_GLAIVE = ITEMS.registerItem("stone_glaive", p -> new GlaiveItem(ToolMaterial.STONE, 2, -2.2F, 4.0F, 5.0F, p));
  public static DeferredItem<Item> COPPER_GLAIVE = ITEMS.registerItem("copper_glaive", p -> new GlaiveItem(ToolMaterial.COPPER, 2, -2.2F, 4.0F, 5.0F, p));
  public static DeferredItem<Item> IRON_GLAIVE = ITEMS.registerItem("iron_glaive", p -> new GlaiveItem(ToolMaterial.IRON, 2, -2.2F, 4.0F, 5.0F, p));
  public static DeferredItem<Item> GOLDEN_GLAIVE = ITEMS.registerItem("golden_glaive", p -> new GlaiveItem(ToolMaterial.GOLD, 2, -2.2F, 3.0F, 4.0F, p));
  public static DeferredItem<Item> DIAMOND_GLAIVE = ITEMS.registerItem("diamond_glaive", p -> new GlaiveItem(ToolMaterial.DIAMOND, 2, -2.2F, 5.0F, 6.0F, p));
  public static DeferredItem<Item> NETHERITE_GLAIVE = ITEMS.registerItem("netherite_glaive", p -> new GlaiveItem(ToolMaterial.NETHERITE, 2, -2.2F, 6F, 7.0F, p.fireResistant()));
  public static DeferredItem<Item> BIOMASS_GLAIVE = ITEMS.registerItem("biomass_glaive", p -> new GlaiveItem(BSToolMaterial.BIOMASS, 2, -2.2F, 5.0F, 6.0F, p));
  public static DeferredItem<Item> LIVINGMETAL_GLAIVE = ITEMS.registerItem("livingmetal_glaive", p -> new GlaiveItem(BSToolMaterial.LIVINGMETAL, 1.0F, -2.2F, 4.0F, 5.0F, p));

  // Scythes
  public static DeferredItem<Item> WOODEN_SCYTHE = ITEMS.registerItem("wooden_scythe", p -> new ScytheItem(ToolMaterial.WOOD, 1, -2.0F, 2F, 3F, p));
  public static DeferredItem<Item> STONE_SCYTHE = ITEMS.registerItem("stone_scythe", p -> new ScytheItem(ToolMaterial.STONE, 1, -2.0F, 3.0F, 4.0F, p));
  public static DeferredItem<Item> COPPER_SCYTHE = ITEMS.registerItem("copper_scythe", p -> new ScytheItem(ToolMaterial.COPPER, 1, -2.0F, 3.0F, 4.0F, p));
  public static DeferredItem<Item> IRON_SCYTHE = ITEMS.registerItem("iron_scythe", p -> new ScytheItem(ToolMaterial.IRON, 1, -2.0F, 3.0F, 4.0F, p));
  public static DeferredItem<Item> GOLDEN_SCYTHE = ITEMS.registerItem("golden_scythe", p -> new ScytheItem(ToolMaterial.GOLD, 1, -2.0F, 2.0F, 3.0F, p));
  public static DeferredItem<Item> DIAMOND_SCYTHE = ITEMS.registerItem("diamond_scythe", p -> new ScytheItem(ToolMaterial.DIAMOND, 1, -2.0F, 4.0F, 5.0F, p));
  public static DeferredItem<Item> NETHERITE_SCYTHE = ITEMS.registerItem("netherite_scythe", p -> new ScytheItem(ToolMaterial.NETHERITE, 1, -2.0F, 5.0F, 6.0F, p.fireResistant()));
  public static DeferredItem<Item> BIOMASS_SCYTHE = ITEMS.registerItem("biomass_scythe", p -> new ScytheItem(BSToolMaterial.BIOMASS, 1, -2.0F, 3.0F, 5.0F, p));
  public static DeferredItem<Item> LIVINGMETAL_SCYTHE = ITEMS.registerItem("livingmetal_scythe", p -> new ScytheItem(BSToolMaterial.LIVINGMETAL, 2.0F, -2.0F, 5F, 6F, p));
  public static DeferredItem<Item> BONE_SCYTHE = ITEMS.registerItem("bone_scythe", p -> new ScytheItem(BSToolMaterial.SKULL, 1.5F, -2.0F, 2F, 2.06F, p));
  public static DeferredItem<Item> SOUL_REAPER = ITEMS.registerItem("soul_reaper", p -> new ScytheItem(BSToolMaterial.REAPER, 1.5F, -2.0F, 9F, 10F, p.rarity(Rarity.EPIC).fireResistant()));

  // Shields
  public static DeferredItem<Item> WOODEN_SHIELD = ITEMS.registerItem("wooden_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.WOOD, 2)));
  public static DeferredItem<Item> GILDED_WOODEN_SHIELD = ITEMS.registerItem("gilded_wooden_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.WOOD, 4)));
  public static DeferredItem<Item> STONE_SHIELD = ITEMS.registerItem("stone_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.STONE)));
  public static DeferredItem<Item> GILDED_STONE_SHIELD = ITEMS.registerItem("gilded_stone_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.STONE, 2)));
  public static WeatheringCopperCollection<DeferredItem<Item>> COPPER_SHIELD = registerShieldCollection("copper_shield");
  public static WeatheringCopperCollection<DeferredItem<Item>> GILDED_COPPER_SHIELD = registerShieldCollection("gilded_copper_shield", 1, ToolMaterial.COPPER.durability() / 2);
  public static DeferredItem<Item> IRON_SHIELD = ITEMS.registerItem("iron_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.IRON).component(BSDataComponents.DEGRADES_UNDERWATER, Unit.INSTANCE)));
  public static DeferredItem<Item> GILDED_IRON_SHIELD = ITEMS.registerItem("gilded_iron_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.IRON, 1, ToolMaterial.IRON.durability() / 2).component(BSDataComponents.DEGRADES_UNDERWATER, Unit.INSTANCE)));
  public static DeferredItem<Item> DIAMOND_SHIELD = ITEMS.registerItem("diamond_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.DIAMOND, 1, -(ToolMaterial.DIAMOND.durability() / 2))));
  public static DeferredItem<Item> GILDED_DIAMOND_SHIELD = ITEMS.registerItem("gilded_diamond_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.DIAMOND, 1, -653)));
  public static DeferredItem<Item> NETHERITE_SHIELD = ITEMS.registerItem("netherite_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.NETHERITE, 1, -(ToolMaterial.NETHERITE.durability() / 2)).fireResistant()));
  public static DeferredItem<Item> GILDED_NETHERITE_SHIELD = ITEMS.registerItem("gilded_netherite_shield", p -> new TieredShield(BSToolMaterial.shield(p, ToolMaterial.NETHERITE, 1, -793).fireResistant()));
  public static DeferredItem<Item> ENDER_SHIELD = ITEMS.registerItem("ender_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.ENDER, 1, -(BSToolMaterial.ENDER.durability() / 2)).fireResistant()));
  public static DeferredItem<Item> GILDED_ENDER_SHIELD = ITEMS.registerItem("gilded_ender_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.ENDER, 1, -1190).fireResistant()));
  public static DeferredItem<Item> QUARTZ_SHIELD = ITEMS.registerItem("quartz_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.QUARTZ)));
  public static DeferredItem<Item> GILDED_QUARTZ_SHIELD = ITEMS.registerItem("gilded_quartz_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.QUARTZ, 2)));
  public static DeferredItem<Item> PATCHWORK_SHIELD = ITEMS.registerItem("patchwork_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.PATCHWORK, 2)));
  public static DeferredItem<Item> GILDED_PATCHWORK_SHIELD = ITEMS.registerItem("gilded_patchwork_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.PATCHWORK, 3)));
  public static DeferredItem<Item> SKULL_SHIELD = ITEMS.registerItem("skull_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.SKULL, 2)));
  public static DeferredItem<Item> GILDED_SKULL_SHIELD = ITEMS.registerItem("gilded_skull_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.SKULL, 3, BSToolMaterial.SKULL.durability() / 2)));
  public static DeferredItem<Item> BIOMASS_SHIELD = ITEMS.registerItem("biomass_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.BIOMASS, 1, BSToolMaterial.BIOMASS.durability() / 2)));
  public static DeferredItem<Item> GILDED_BIOMASS_SHIELD = ITEMS.registerItem("gilded_biomass_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.BIOMASS, 2)));
  public static DeferredItem<Item> LIVINGMETAL_SHIELD = ITEMS.registerItem("livingmetal_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.LIVINGMETAL, 1)));
  public static DeferredItem<Item> GILDED_LIVINGMETAL_SHIELD = ITEMS.registerItem("gilded_livingmetal_shield", p -> new TieredShield(BSToolMaterial.shield(p, BSToolMaterial.LIVINGMETAL, 2, BSToolMaterial.LIVINGMETAL.durability() / 2)));

  private static WeatheringCopperCollection<DeferredItem<Item>> registerShieldCollection(String baseName) {
    return registerShieldCollection(baseName, 1, 0);
  }

  private static WeatheringCopperCollection<DeferredItem<Item>> registerShieldCollection(String baseName, int durabilityMultiplier, int additionalDurability) {
    return WeatheringCopperCollection.PREFIXES.apply(
        weatheringPrefixes -> WeatheringCopperCollection.zipMap(
            WeatheringCopperCollection.STATES, weatheringPrefixes,
            (state, prefix) -> ITEMS.registerItem(prefix + baseName, p -> new TieredShield(BSToolMaterial.copperShield(p, durabilityMultiplier, additionalDurability, state, false)))
        ),
        waxedPrefixes -> WeatheringCopperCollection.zipMap(
            WeatheringCopperCollection.STATES, waxedPrefixes,
            (state, prefix) -> ITEMS.registerItem(prefix + baseName, p -> new TieredShield(BSToolMaterial.copperShield(p, durabilityMultiplier, additionalDurability, state, true).component(BSDataComponents.WAXED, true)))
        )
    );
  }
}