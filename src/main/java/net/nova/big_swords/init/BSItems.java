package net.nova.big_swords.init;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSTrimMaterials;
import net.nova.big_swords.item.*;

import java.util.function.Function;

public class BSItems {
  // Extra
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_SEED = registerItem("biomass_seed", properties -> new BlockItem(BSBlocks.BIOMASS.getFirst().value(), properties.useItemDescriptionPrefix()));
  public static Pair<Holder<Item>, ResourceKey<Item>> CREEP_BALL = registerItem("creep_ball", CreepBall::new);
  public static Pair<Holder<Item>, ResourceKey<Item>> SOUL = registerItem("soul", Item::new);
  public static Pair<Holder<Item>, ResourceKey<Item>> BLOOD_VIAL = registerItem("blood_vial", BloodVial::new);

  // Sticks
  public static Pair<Holder<Item>, ResourceKey<Item>> GIANT_WOODEN_STICK = registerItem("giant_wooden_stick", Item::new);
  public static Pair<Holder<Item>, ResourceKey<Item>> GIANT_BLAZE_ROD = registerItem("giant_blaze_rod", Item::new);
  public static Pair<Holder<Item>, ResourceKey<Item>> GIANT_LIVINGMETAL_HANDLE = registerItem("giant_livingmetal_handle", Item::new);

  // Ender Template
  public static Pair<Holder<Item>, ResourceKey<Item>> ENDER_UPGRADE_SMITHING_TEMPLATE = registerItem("ender_upgrade_smithing_template", properties -> EnderSmithingTemplate.createEnderUpgradeTemplate(properties.rarity(Rarity.RARE)));

  // Livingmetal Stuff
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_INGOT = registerItem("livingmetal_ingot", properties -> new Item(properties.trimMaterial(BSTrimMaterials.LIVINGMETAL)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_HELMET = registerItem("livingmetal_helmet", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.HELMET)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_CHESTPLATE = registerItem("livingmetal_chestplate", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.CHESTPLATE)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_LEGGINGS = registerItem("livingmetal_leggings", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.LEGGINGS)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_BOOTS = registerItem("livingmetal_boots", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.LIVINGMETAL, ArmorType.BOOTS)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_SWORD = registerItem("livingmetal_sword", p -> new Item(p.sword(BSToolMaterial.LIVINGMETAL, 3.0F, -2.4F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_PICKAXE = registerItem("livingmetal_pickaxe", p -> new Item(p.pickaxe(BSToolMaterial.LIVINGMETAL, 1.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_AXE = registerItem("livingmetal_axe", p -> new Item(p.axe(BSToolMaterial.LIVINGMETAL, 6.0F, -2.5F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_SHOVEL = registerItem("livingmetal_shovel", p -> new Item(p.shovel(BSToolMaterial.LIVINGMETAL, 1.5F, -2.5F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_HOE = registerItem("livingmetal_hoe", p -> new Item(p.hoe(BSToolMaterial.LIVINGMETAL, -2.0F, 0.0F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_SPEAR = registerItem("livingmetal_spear", p -> new Item(p.spear(BSToolMaterial.LIVINGMETAL, 1.00F, 1.00F, 0.5F, 2.5F, 10.5F, 6.5F, 5.1F, 10.75F, 4.6F)));

  // Biomass Stuff
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS = registerItem("biomass", Item::new);
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_HELMET = registerItem("biomass_helmet", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.HELMET)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_CHESTPLATE = registerItem("biomass_chestplate", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.CHESTPLATE)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_LEGGINGS = registerItem("biomass_leggings", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.LEGGINGS)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_BOOTS = registerItem("biomass_boots", properties -> new Item(properties.humanoidArmor(BSArmorMaterial.BIOMASS, ArmorType.BOOTS)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_SWORD = registerItem("biomass_sword", p -> new Item(p.sword(BSToolMaterial.BIOMASS, 3.0F, -2.4F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_PICKAXE = registerItem("biomass_pickaxe", p -> new Item(p.pickaxe(BSToolMaterial.BIOMASS, 1.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_AXE = registerItem("biomass_axe", p -> new Item(p.axe(BSToolMaterial.BIOMASS, 6.0F, -3.0F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_SHOVEL = registerItem("biomass_shovel", p -> new Item(p.shovel(BSToolMaterial.BIOMASS, 1.5F, -3.0F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_HOE = registerItem("biomass_hoe", p -> new Item(p.hoe(BSToolMaterial.BIOMASS, -2.0F, -0.5F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_SPEAR = registerItem("biomass_spear", p -> new Item(p.spear(BSToolMaterial.BIOMASS, 1.05F, 0.95F, 0.5F, 2.5F, 10.0F, 6.75F, 5.1F, 11.0F, 4.6F)));

  // Big Swords
  public static Pair<Holder<Item>, ResourceKey<Item>> WOODEN_BIG_SWORD = registerItem("wooden_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.WOOD, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> STONE_BIG_SWORD = registerItem("stone_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.STONE, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> COPPER_BIG_SWORD = registerItem("copper_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.COPPER, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> IRON_BIG_SWORD = registerItem("iron_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.IRON, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GOLDEN_BIG_SWORD = registerItem("golden_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.GOLD, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> DIAMOND_BIG_SWORD = registerItem("diamond_big_sword", p -> new Item(BSToolMaterial.bigSword(p, ToolMaterial.DIAMOND, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> NETHERITE_BIG_SWORD = registerItem("netherite_big_sword", p -> new Item(BSToolMaterial.bigSword(p.fireResistant(), ToolMaterial.NETHERITE, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> PATCHWORK_BIG_SWORD = registerItem("patchwork_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.PATCHWORK, 6.5F, -2.4F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> SKULL_BIG_SWORD = registerItem("skull_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.SKULL, 6.5F, -2.6F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> QUARTZ_BIG_SWORD = registerItem("quartz_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.QUARTZ, 7.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> OBSIDIAN_BIG_SWORD = registerItem("obsidian_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.OBSIDIAN, 5.5F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> ENDER_BIG_SWORD = registerItem("ender_big_sword", p -> new Item(BSToolMaterial.bigSword(p.fireResistant(), BSToolMaterial.ENDER, 7.5F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_BIG_SWORD = registerItem("livingmetal_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.LIVINGMETAL, 6.0F, -2.8F)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_BIG_SWORD = registerItem("biomass_big_sword", p -> new Item(BSToolMaterial.bigSword(p, BSToolMaterial.BIOMASS, 7.0F, -2.8F)));

  // Glaives
  public static Pair<Holder<Item>, ResourceKey<Item>> WOODEN_GLAIVE = registerItem("wooden_glaive", p -> new GlaiveItem(ToolMaterial.WOOD, 2, -2.2F, 3F, 4F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> STONE_GLAIVE = registerItem("stone_glaive", p -> new GlaiveItem(ToolMaterial.STONE, 2, -2.2F, 4.0F, 5.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> COPPER_GLAIVE = registerItem("copper_glaive", p -> new GlaiveItem(ToolMaterial.COPPER, 2, -2.2F, 4.0F, 5.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> IRON_GLAIVE = registerItem("iron_glaive", p -> new GlaiveItem(ToolMaterial.IRON, 2, -2.2F, 4.0F, 5.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> GOLDEN_GLAIVE = registerItem("golden_glaive", p -> new GlaiveItem(ToolMaterial.GOLD, 2, -2.2F, 3.0F, 4.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> DIAMOND_GLAIVE = registerItem("diamond_glaive", p -> new GlaiveItem(ToolMaterial.DIAMOND, 2, -2.2F, 5.0F, 6.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> NETHERITE_GLAIVE = registerItem("netherite_glaive", p -> new GlaiveItem(ToolMaterial.NETHERITE, 2, -2.2F, 6F, 7.0F, p.fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_GLAIVE = registerItem("biomass_glaive", p -> new GlaiveItem(BSToolMaterial.BIOMASS, 2, -2.2F, 5.0F, 6.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_GLAIVE = registerItem("livingmetal_glaive", p -> new GlaiveItem(BSToolMaterial.LIVINGMETAL, 1.0F, -2.2F, 4.0F, 5.0F, p));

  // Scythes
  public static Pair<Holder<Item>, ResourceKey<Item>> WOODEN_SCYTHE = registerItem("wooden_scythe", p -> new ScytheItem(ToolMaterial.WOOD, 1, -2.0F, 2F, 3F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> STONE_SCYTHE = registerItem("stone_scythe", p -> new ScytheItem(ToolMaterial.STONE, 1, -2.0F, 3.0F, 4.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> COPPER_SCYTHE = registerItem("copper_scythe", p -> new ScytheItem(ToolMaterial.COPPER, 1, -2.0F, 3.0F, 4.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> IRON_SCYTHE = registerItem("iron_scythe", p -> new ScytheItem(ToolMaterial.IRON, 1, -2.0F, 3.0F, 4.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> GOLDEN_SCYTHE = registerItem("golden_scythe", p -> new ScytheItem(ToolMaterial.GOLD, 1, -2.0F, 2.0F, 3.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> DIAMOND_SCYTHE = registerItem("diamond_scythe", p -> new ScytheItem(ToolMaterial.DIAMOND, 1, -2.0F, 4.0F, 5.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> NETHERITE_SCYTHE = registerItem("netherite_scythe", p -> new ScytheItem(ToolMaterial.NETHERITE, 1, -2.0F, 5.0F, 6.0F, p.fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_SCYTHE = registerItem("biomass_scythe", p -> new ScytheItem(BSToolMaterial.BIOMASS, 1, -2.0F, 3.0F, 5.0F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_SCYTHE = registerItem("livingmetal_scythe", p -> new ScytheItem(BSToolMaterial.LIVINGMETAL, 2.0F, -2.0F, 5F, 6F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> BONE_SCYTHE = registerItem("bone_scythe", p -> new ScytheItem(BSToolMaterial.SKULL, 1.5F, -2.0F, 2F, 2.06F, p));
  public static Pair<Holder<Item>, ResourceKey<Item>> SOUL_REAPER = registerItem("soul_reaper", p -> new ScytheItem(BSToolMaterial.REAPER, 1.5F, -2.0F, 9F, 10F, p.rarity(Rarity.EPIC).fireResistant()));

  // Shields
  public static Pair<Holder<Item>, ResourceKey<Item>> WOODEN_SHIELD = registerItem("wooden_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.WOOD, 2)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_WOODEN_SHIELD = registerItem("gilded_wooden_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.WOOD, 4)));
  public static Pair<Holder<Item>, ResourceKey<Item>> STONE_SHIELD = registerItem("stone_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.STONE)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_STONE_SHIELD = registerItem("gilded_stone_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.STONE, 2)));
  public static WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>> COPPER_SHIELD = registerShieldCollection("copper_shield");
  public static WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>> GILDED_COPPER_SHIELD = registerShieldCollection("gilded_copper_shield", 1, ToolMaterial.COPPER.durability() / 2);
  public static Pair<Holder<Item>, ResourceKey<Item>> IRON_SHIELD = registerItem("iron_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.IRON).component(BSDataComponents.DEGRADES_UNDERWATER, Unit.INSTANCE)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_IRON_SHIELD = registerItem("gilded_iron_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.IRON, 1, ToolMaterial.IRON.durability() / 2).component(BSDataComponents.DEGRADES_UNDERWATER, Unit.INSTANCE)));
  public static Pair<Holder<Item>, ResourceKey<Item>> DIAMOND_SHIELD = registerItem("diamond_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.DIAMOND, 1, -(ToolMaterial.DIAMOND.durability() / 2))));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_DIAMOND_SHIELD = registerItem("gilded_diamond_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.DIAMOND, 1, -653)));
  public static Pair<Holder<Item>, ResourceKey<Item>> NETHERITE_SHIELD = registerItem("netherite_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.NETHERITE, 1, -(ToolMaterial.NETHERITE.durability() / 2)).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_NETHERITE_SHIELD = registerItem("gilded_netherite_shield", p -> new ShieldItem(BSToolMaterial.shield(p, ToolMaterial.NETHERITE, 1, -793).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> ENDER_SHIELD = registerItem("ender_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.ENDER, 1, -(BSToolMaterial.ENDER.durability() / 2)).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_ENDER_SHIELD = registerItem("gilded_ender_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.ENDER, 1, -1190).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> QUARTZ_SHIELD = registerItem("quartz_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.QUARTZ)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_QUARTZ_SHIELD = registerItem("gilded_quartz_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.QUARTZ, 2)));
  public static Pair<Holder<Item>, ResourceKey<Item>> PATCHWORK_SHIELD = registerItem("patchwork_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.PATCHWORK, 2)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_PATCHWORK_SHIELD = registerItem("gilded_patchwork_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.PATCHWORK, 3)));
  public static Pair<Holder<Item>, ResourceKey<Item>> SKULL_SHIELD = registerItem("skull_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.SKULL, 2)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_SKULL_SHIELD = registerItem("gilded_skull_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.SKULL, 3, BSToolMaterial.SKULL.durability() / 2)));
  public static Pair<Holder<Item>, ResourceKey<Item>> BIOMASS_SHIELD = registerItem("biomass_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.BIOMASS, 1, BSToolMaterial.BIOMASS.durability() / 2)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_BIOMASS_SHIELD = registerItem("gilded_biomass_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.BIOMASS, 2)));
  public static Pair<Holder<Item>, ResourceKey<Item>> LIVINGMETAL_SHIELD = registerItem("livingmetal_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.LIVINGMETAL, 1)));
  public static Pair<Holder<Item>, ResourceKey<Item>> GILDED_LIVINGMETAL_SHIELD = registerItem("gilded_livingmetal_shield", p -> new ShieldItem(BSToolMaterial.shield(p, BSToolMaterial.LIVINGMETAL, 2, BSToolMaterial.LIVINGMETAL.durability() / 2)));

  // Methods
  private static WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>> registerShieldCollection(String baseName) {
    return registerShieldCollection(baseName, 1, 0);
  }

  private static WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>> registerShieldCollection(String baseName, int durabilityMultiplier, int additionalDurability) {
    return WeatheringCopperCollection.PREFIXES.apply(
        weatheringPrefixes -> WeatheringCopperCollection.zipMap(
            WeatheringCopperCollection.STATES, weatheringPrefixes,
            (state, prefix) -> registerItem(prefix + baseName, p -> new ShieldItem(BSToolMaterial.copperShield(p, durabilityMultiplier, additionalDurability, state, false)))
        ),
        waxedPrefixes -> WeatheringCopperCollection.zipMap(
            WeatheringCopperCollection.STATES, waxedPrefixes,
            (state, prefix) -> registerItem(prefix + baseName, p -> new ShieldItem(BSToolMaterial.copperShield(p, durabilityMultiplier, additionalDurability, state, true)))
        )
    );
  }

  public static <T extends Item> Pair<Holder<T>, ResourceKey<Item>> registerItem(String name, Function<Item.Properties, T> function) {
    return register(name, function, new Item.Properties());
  }

  public static <T extends Item> Pair<Holder<T>, ResourceKey<Item>> register(String name, Function<Item.Properties, T> function, Item.Properties properties) {
    ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, BigSwordsR.rl(name));
    return Pair.of(Registry.registerForHolder(BuiltInRegistries.ITEM, key, function.apply(properties.setId(key))), key);
  }

  public static void initialize() {
    BigSwordsR.LOGGER.info("Registering Items");
  }
}