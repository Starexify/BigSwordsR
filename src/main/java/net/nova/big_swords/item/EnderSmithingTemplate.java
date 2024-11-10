package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.nova.big_swords.BigSwordsR;

import java.util.List;

import static net.nova.big_swords.BigSwordsR.rl;

public class EnderSmithingTemplate extends SmithingTemplateItem {
    public static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    public static final Component ENDER_UPGRADE_APPLIES_TO = Component.translatable(
            Util.makeDescriptionId("item", rl("smithing_template.ender_upgrade.applies_to"))
    ).withStyle(DESCRIPTION_FORMAT);

    public static final Component ENDER_UPGRADE_INGREDIENTS = Component.translatable(
            Util.makeDescriptionId("item", rl("smithing_template.ender_upgrade.ingredients"))
    ).withStyle(DESCRIPTION_FORMAT);

    public static final Component ENDER_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", rl("smithing_template.ender_upgrade.base_slot_description"))
    );

    public static final Component ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", rl("smithing_template.ender_upgrade.additions_slot_description"))
    );

    public static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    public static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    public static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    public static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    public static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    public static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    public static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    public static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    public static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    public static final ResourceLocation EMPTY_SLOT_BIG_SWORD = BigSwordsR.rl("item/empty_slot_big_sword");
    public static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");

    public EnderSmithingTemplate(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> upgradeIconList, List<ResourceLocation> upgradeMaterialList, Properties properties) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, upgradeIconList, upgradeMaterialList, properties);
    }

    public static EnderSmithingTemplate createEnderUpgradeTemplate(Item.Properties properties) {
        return new EnderSmithingTemplate(
                ENDER_UPGRADE_APPLIES_TO,
                ENDER_UPGRADE_INGREDIENTS,
                ENDER_UPGRADE_BASE_SLOT_DESCRIPTION,
                ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createEnderUpgradeIconList(),
                createEnderUpgradeMaterialList(),
                properties
        );
    }

    public static List<ResourceLocation> createEnderUpgradeIconList() {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_SWORD,
                EMPTY_SLOT_BIG_SWORD,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_AXE,
                EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_HOE,
                EMPTY_SLOT_SHOVEL
        );
    }

    public static List<ResourceLocation> createEnderUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
