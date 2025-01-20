package net.nova.big_swords.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.nova.big_swords.BigSwordsR;

import java.util.List;

public class BSToolMaterial {
    public static final ToolMaterial PATCHWORK = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 30, 1.0F, -1.5F, 16, Tags.BSItemTags.PATCHWORK_TOOL_MATERIALS);
    public static final ToolMaterial SKULL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 103, 2.0F, -0.5F, 13, Tags.BSItemTags.SKULL_TOOL_MATERIALS);
    public static final ToolMaterial QUARTZ = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 187, 5.0F, 1.0F, 17, Tags.BSItemTags.QUARTZ_TOOL_MATERIALS);
    public static final ToolMaterial OBSIDIAN = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1171, 9.0F, 3.5F, 12, Tags.BSItemTags.OBSIDIAN_TOOL_MATERIALS);
    public static final ToolMaterial ENDER = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3046, 12.0F, 5.5F, 18, Tags.BSItemTags.ENDER_TOOL_MATERIALS);
    public static final ToolMaterial LIVINGMETAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 7.5F, 2.5F, 16, Tags.BSItemTags.LIVINGMETAL_TOOL_MATERIALS);
    public static final ToolMaterial BIOMASS = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 188, 8.0F, 2.0F, 18, Tags.BSItemTags.BIOMASS_TOOL_MATERIALS);
    public static final ToolMaterial REAPER = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 206, 2.0F, -0.5F, 18, Tags.BSItemTags.REAPER_TOOL_MATERIALS);

    public static final Identifier MIN_CHARGED_DAMAGE_ID = BigSwordsR.rl("min_charged_damage");
    public static final Identifier MAX_CHARGED_DAMAGE_ID = BigSwordsR.rl("max_charged_damage");

    public static AttributeModifiersComponent createScytheAttributeModifier(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minDamage, float maxDamage) {
        return AttributeModifiersComponent.builder().add(
                BSEntityAttributes.CHARGED_DAMAGE,
                new EntityAttributeModifier(MIN_CHARGED_DAMAGE_ID, minDamage, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        ).add(
                BSEntityAttributes.CHARGED_DAMAGE,
                new EntityAttributeModifier(MAX_CHARGED_DAMAGE_ID, maxDamage, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        ).build();
    }

    public static Item.Settings applyBaseSettings(Item.Settings settings, ToolMaterial toolMaterial) {
        return settings.maxDamage(toolMaterial.durability()).repairable(toolMaterial.repairItems()).enchantable(toolMaterial.enchantmentValue());
    }

    public static Item.Settings applyChargedItemSettings(Item.Settings settings, ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minDamage, float maxDamage) {
        RegistryEntryLookup<Block> registryEntryLookup = Registries.createEntryLookup(Registries.BLOCK);
        return applyBaseSettings(settings,
                toolMaterial).component(DataComponentTypes.TOOL, new ToolComponent(List.of(
                        ToolComponent.Rule.ofAlwaysDropping(RegistryEntryList.of(Blocks.COBWEB.getRegistryEntry()), 15.0F),
                        ToolComponent.Rule.of(registryEntryLookup.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F))
                        , 1.0F, 2))
                .attributeModifiers(createChargedAttributeModifier(toolMaterial, attackDamage, attackSpeed, minDamage, maxDamage));
    }

    public static AttributeModifiersComponent createChargedAttributeModifier(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minDamage, float maxDamage) {
        return AttributeModifiersComponent.builder().add(
                EntityAttributes.ATTACK_DAMAGE,
                new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, attackDamage + toolMaterial.attackDamageBonus(), EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        ).add(
                EntityAttributes.ATTACK_SPEED,
                new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        ).add(
                BSEntityAttributes.CHARGED_DAMAGE,
                new EntityAttributeModifier(MIN_CHARGED_DAMAGE_ID, minDamage, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        ).add(
                BSEntityAttributes.CHARGED_DAMAGE,
                new EntityAttributeModifier(MAX_CHARGED_DAMAGE_ID, maxDamage, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        ).build();
    }
}
