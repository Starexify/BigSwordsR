package net.nova.item;

import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

import static net.nova.BigSwordsR.rl;

public class EnderSmithingTemplate extends SmithingTemplateItem {
    public static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;
    public static final Text ENDER_UPGRADE_APPLIES_TO = Text.translatable(
            Util.createTranslationKey("item", rl("smithing_template.ender_upgrade.applies_to"))
    ).formatted(DESCRIPTION_FORMATTING);

    public static final Text ENDER_UPGRADE_INGREDIENTS = Text.translatable(
            Util.createTranslationKey("item", rl("smithing_template.ender_upgrade.ingredients"))
    ).formatted(DESCRIPTION_FORMATTING);

    public static final Text ENDER_UPGRADE_BASE_SLOT_DESCRIPTION = Text.translatable(
            Util.createTranslationKey("item", rl("smithing_template.ender_upgrade.base_slot_description"))
    );

    public static final Text ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(
            Util.createTranslationKey("item", rl("smithing_template.ender_upgrade.additions_slot_description"))
    );

    public static final Identifier EMPTY_SLOT_HELMET = Identifier.ofVanilla("item/empty_armor_slot_helmet");
    public static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.ofVanilla("item/empty_armor_slot_chestplate");
    public static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.ofVanilla("item/empty_armor_slot_leggings");
    public static final Identifier EMPTY_SLOT_BOOTS = Identifier.ofVanilla("item/empty_armor_slot_boots");
    public static final Identifier EMPTY_SLOT_HOE = Identifier.ofVanilla("item/empty_slot_hoe");
    public static final Identifier EMPTY_SLOT_AXE = Identifier.ofVanilla("item/empty_slot_axe");
    public static final Identifier EMPTY_SLOT_SWORD = Identifier.ofVanilla("item/empty_slot_sword");
    public static final Identifier EMPTY_SLOT_SHOVEL = Identifier.ofVanilla("item/empty_slot_shovel");
    public static final Identifier EMPTY_SLOT_PICKAXE = Identifier.ofVanilla("item/empty_slot_pickaxe");
    public static final Identifier EMPTY_SLOT_BIG_SWORD = rl("item/empty_slot_big_sword");
    public static final Identifier EMPTY_SLOT_INGOT = Identifier.ofVanilla("item/empty_slot_ingot");

    public EnderSmithingTemplate(Text appliesTo, Text ingredients, Text baseSlotDescription, Text additionsSlotDescription, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, Settings settings) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, emptyBaseSlotTextures, emptyAdditionsSlotTextures, settings);
    }

    public static SmithingTemplateItem createEnderUpgradeTemplate(Item.Settings settings) {
        return new EnderSmithingTemplate(
                ENDER_UPGRADE_APPLIES_TO,
                ENDER_UPGRADE_INGREDIENTS,
                ENDER_UPGRADE_BASE_SLOT_DESCRIPTION,
                ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                getEnderUpgradeEmptyBaseSlotTextures(),
                getEnderUpgradeEmptyAdditionsSlotTextures(),
                settings
        );
    }

    public static List<Identifier> getEnderUpgradeEmptyBaseSlotTextures() {
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

    public static List<Identifier> getEnderUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
