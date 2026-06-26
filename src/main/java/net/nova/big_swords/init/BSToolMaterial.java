package net.nova.big_swords.init;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.item.component.SpecialShield;
import net.nova.big_swords.mixin.ToolMaterialAccessor;

import java.util.List;
import java.util.Optional;

public class BSToolMaterial {
  public static final ToolMaterial PATCHWORK = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 30, 1.0F, -1.5F, 16, Tags.BSItemTags.PATCHWORK_TOOL_MATERIALS);
  public static final ToolMaterial SKULL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 103, 2.0F, -0.5F, 13, Tags.BSItemTags.SKULL_TOOL_MATERIALS);
  public static final ToolMaterial QUARTZ = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 187, 5.0F, 1.0F, 17, Tags.BSItemTags.QUARTZ_TOOL_MATERIALS);
  public static final ToolMaterial OBSIDIAN = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1171, 9.0F, 3.5F, 12, Tags.BSItemTags.OBSIDIAN_TOOL_MATERIALS);
  public static final ToolMaterial ENDER = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3046, 12.0F, 5.5F, 18, Tags.BSItemTags.ENDER_TOOL_MATERIALS);
  public static final ToolMaterial LIVINGMETAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 7.5F, 3.0F, 16, Tags.BSItemTags.LIVINGMETAL_TOOL_MATERIALS);
  public static final ToolMaterial BIOMASS = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 188, 8.0F, 2.0F, 18, Tags.BSItemTags.BIOMASS_TOOL_MATERIALS);
  public static final ToolMaterial REAPER = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 206, 2.0F, -0.5F, 18, Tags.BSItemTags.REAPER_TOOL_MATERIALS);

  public static final Identifier MIN_CHARGED_DAMAGE_ID = BigSwordsR.rl("min_charged_damage");
  public static final Identifier MAX_CHARGED_DAMAGE_ID = BigSwordsR.rl("max_charged_damage");

  public static Item.Properties copperShield(Item.Properties properties, int durabilityMultiplier, int additionalDurability, WeatheringCopper.WeatherState state, boolean isWaxed) {
    applyBaseShieldProperties(properties, ToolMaterial.COPPER, durabilityMultiplier, additionalDurability);
    if (state != WeatheringCopper.WeatherState.OXIDIZED) applyBlockingComponent(properties);
    if (isWaxed) properties.component(BSDataComponents.WAXED, true);
    properties.component(BSDataComponents.SPECIAL_SHIELD, new SpecialShield(ToolMaterial.COPPER));

    return properties.component(BSDataComponents.OXIDATION_STATE, state);
  }

  public static Item.Properties shield(Item.Properties properties, ToolMaterial material) {
    return shield(properties, material, 1, 0);
  }

  public static Item.Properties shield(Item.Properties properties, ToolMaterial material, int durabilityMultiplier) {
    return shield(properties, material, durabilityMultiplier, 0);
  }

  public static Item.Properties shield(Item.Properties properties, ToolMaterial material, int durabilityMultiplier, int additionalDurability) {
    applyBaseShieldProperties(properties, material, durabilityMultiplier, additionalDurability);
    properties.component(BSDataComponents.SPECIAL_SHIELD, new SpecialShield(material));
    return applyBlockingComponent(properties);
  }

  public static Item.Properties applyBlockingComponent(Item.Properties properties) {
    return properties
        .delayedComponent(DataComponents.BLOCKS_ATTACKS, context -> new BlocksAttacks(
            0.25F,
            1.0F,
            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
            Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)),
            Optional.of(SoundEvents.SHIELD_BLOCK),
            Optional.of(SoundEvents.SHIELD_BREAK)
        ));
  }

  public static Item.Properties applyBaseShieldProperties(Item.Properties properties, ToolMaterial material, int durabilityMultiplier, int additionalDurability) {
    return properties
        .durability(material.durability() * durabilityMultiplier + additionalDurability)
        .enchantable(material.enchantmentValue())
        .equippableUnswappable(EquipmentSlot.OFFHAND)
        .repairable(material.repairItems())
        .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK);
  }

  public static Item.Properties bigSword(Item.Properties properties, ToolMaterial material, float attackDamage, float attackSpeed) {
    return properties.sword(material, attackDamage, attackSpeed).durability(material.durability() * 2);
  }

  public static Item.Properties applyToolSettings(Item.Properties settings, ToolMaterial toolMaterial, TagKey<Block> effectiveBlocks, float attackDamage, float attackSpeed, float minChargedDamage, float maxDamage) {
    HolderGetter<Block> registryEntryLookup = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
    return ((ToolMaterialAccessor) (Object) toolMaterial).big_swords$applyCommonProperties(settings)
        .component(DataComponents.TOOL, new Tool(
            List.of(Tool.Rule.deniesDrops(registryEntryLookup.getOrThrow(toolMaterial.incorrectBlocksForDrops())),
                Tool.Rule.minesAndDrops(registryEntryLookup.getOrThrow(effectiveBlocks), toolMaterial.speed())),
            1.0F, 1, true))
        .attributes(createChargedWeaponAttributes(toolMaterial, attackDamage, attackSpeed, minChargedDamage, maxDamage)).component(DataComponents.WEAPON, new Weapon(2, 0.0F));
  }

  public static Item.Properties applyChargedProperties(Item.Properties properties, ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minChargedDamage, float maxDamage) {
    HolderGetter<Block> registryEntryLookup = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
    return ((ToolMaterialAccessor) (Object) toolMaterial).big_swords$applyCommonProperties(properties).component(DataComponents.TOOL, new Tool(
            List.of(Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F),
                Tool.Rule.overrideSpeed(registryEntryLookup.getOrThrow(BlockTags.SWORD_INSTANTLY_MINES), Float.MAX_VALUE),
                Tool.Rule.overrideSpeed(registryEntryLookup.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)),
            1.0F, 2, false))
        .attributes(createChargedWeaponAttributes(toolMaterial, attackDamage, attackSpeed, minChargedDamage, maxDamage))
        .component(DataComponents.WEAPON, new Weapon(1));
  }

  public static ItemAttributeModifiers createChargedWeaponAttributes(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minChargedDamage, float maxDamage) {
    return ItemAttributeModifiers.builder().add(
        Attributes.ATTACK_DAMAGE,
        new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamage + toolMaterial.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
        EquipmentSlotGroup.MAINHAND
    ).add(
        Attributes.ATTACK_SPEED,
        new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE),
        EquipmentSlotGroup.MAINHAND
    ).add(
        BSAttributes.MIN_CHARGED_DAMAGE,
        new AttributeModifier(MIN_CHARGED_DAMAGE_ID, minChargedDamage, AttributeModifier.Operation.ADD_VALUE),
        EquipmentSlotGroup.MAINHAND
    ).add(
        BSAttributes.MAX_CHARGED_DAMAGE,
        new AttributeModifier(MAX_CHARGED_DAMAGE_ID, maxDamage, AttributeModifier.Operation.ADD_VALUE),
        EquipmentSlotGroup.MAINHAND
    ).build();
  }

  public static ToolMaterial getMaterialFromId(String id) {
    return switch (id) {
      // BSR Tiers
      case "patchwork" -> PATCHWORK;
      case "skull" -> SKULL;
      case "quartz" -> QUARTZ;
      case "obsidian" -> OBSIDIAN;
      case "ender" -> ENDER;
      case "livingmetal" -> LIVINGMETAL;
      case "biomass" -> BIOMASS;
      case "reaper" -> REAPER;

      // Vanilla Fallbacks
      case "stone" -> ToolMaterial.STONE;
      case "copper" -> ToolMaterial.COPPER;
      case "iron" -> ToolMaterial.IRON;
      case "diamond" -> ToolMaterial.DIAMOND;
      case "gold" -> ToolMaterial.GOLD;
      case "netherite" -> ToolMaterial.NETHERITE;
      default -> ToolMaterial.WOOD;
    };
  }

  public static String getIdFromMaterial(ToolMaterial material) {
    return switch (material) {
      // BSR Tiers
      case ToolMaterial m when m == PATCHWORK -> "patchwork";
      case ToolMaterial m when m == SKULL -> "skull";
      case ToolMaterial m when m == QUARTZ -> "quartz";
      case ToolMaterial m when m == OBSIDIAN -> "obsidian";
      case ToolMaterial m when m == ENDER -> "ender";
      case ToolMaterial m when m == LIVINGMETAL -> "livingmetal";
      case ToolMaterial m when m == BIOMASS -> "biomass";
      case ToolMaterial m when m == REAPER -> "reaper";

      // Vanilla Tiers
      case ToolMaterial m when m == ToolMaterial.STONE -> "stone";
      case ToolMaterial m when m == ToolMaterial.COPPER -> "copper";
      case ToolMaterial m when m == ToolMaterial.IRON -> "iron";
      case ToolMaterial m when m == ToolMaterial.DIAMOND -> "diamond";
      case ToolMaterial m when m == ToolMaterial.GOLD -> "gold";
      case ToolMaterial m when m == ToolMaterial.NETHERITE -> "netherite";

      default -> "wood";
    };
  }
}