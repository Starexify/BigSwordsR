package net.nova.big_swords.init;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    public static final ResourceLocation MIN_CHARGED_DAMAGE_ID = BigSwordsR.rl("min_charged_damage");
    public static final ResourceLocation MAX_CHARGED_DAMAGE_ID = BigSwordsR.rl("max_charged_damage");

    public static Item.Properties applyCommonProperties(Item.Properties properties, ToolMaterial toolMaterial) {
        return properties.durability(toolMaterial.durability()).repairable(toolMaterial.repairItems()).enchantable(toolMaterial.enchantmentValue());
    }

    public static Item.Properties applyChargedProperties(Item.Properties properties, ToolMaterial material, float attackDamage, float attackSpeed, float minChargedDamage, float maxChargedDamage) {
        HolderGetter<Block> holdergetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return applyCommonProperties(properties, material)
                .component(DataComponents.TOOL, new Tool(List.of(
                        Tool.Rule.minesAndDrops(HolderSet.direct(new Holder[]{Blocks.COBWEB.builtInRegistryHolder()}), 15.0F),
                        Tool.Rule.overrideSpeed(holdergetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)), 1.0F, 2))
                .attributes(createChargedWeaponAttributes(material, attackDamage, attackSpeed, minChargedDamage, maxChargedDamage));
    }

    public static Item.Properties applyChargedToolProperties(Item.Properties properties, ToolMaterial material, TagKey<Block> mineableBlocks, float attackDamage, float attackSpeed, float minChargedDamage, float maxChargedDamage) {
        HolderGetter<Block> holdergetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return applyCommonProperties(properties, material)
                .component(
                        DataComponents.TOOL,
                        new Tool(
                                List.of(
                                        Tool.Rule.deniesDrops(holdergetter.getOrThrow(material.incorrectBlocksForDrops())),
                                        Tool.Rule.minesAndDrops(holdergetter.getOrThrow(mineableBlocks), material.speed())
                                ),
                                1.0F,
                                1
                        )
                )
                .attributes(createChargedWeaponAttributes(material, attackDamage, attackSpeed, minChargedDamage, maxChargedDamage));
    }

    public static ItemAttributeModifiers createChargedWeaponAttributes(ToolMaterial material, float attackDamage, float attackSpeed, float minChargedDamage, float maxChargedDamage) {
        return ItemAttributeModifiers.builder().add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamage + material.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
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
                new AttributeModifier(MAX_CHARGED_DAMAGE_ID, maxChargedDamage, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        ).build();
    }
}
