package net.nova.big_swords.item;

import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.nova.big_swords.BigSwordsR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.nova.big_swords.BigSwordsR.rl;

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

    public static final List<Identifier> INGREDIENT_SLOTS = new ArrayList<>(Arrays.asList(
            Identifier.of("container/slot/helmet"),
            Identifier.of("container/slot/chestplate"),
            Identifier.of("container/slot/leggings"),
            Identifier.of("container/slot/boots"),
            Identifier.of("container/slot/hoe"),
            Identifier.of("container/slot/axe"),
            Identifier.of("container/slot/sword"),
            Identifier.of("container/slot/shovel"),
            Identifier.of("container/slot/pickaxe"),
            BigSwordsR.rl("container/slot/big_sword")
    ));
    public static final Identifier EYE_SLOT = BigSwordsR.rl("container/slot/eye");

    public EnderSmithingTemplate(Text appliesTo, Text ingredients, Text baseSlotDescription, Text additionsSlotDescription, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, Settings settings) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, emptyBaseSlotTextures, emptyAdditionsSlotTextures, settings);
    }

    public static SmithingTemplateItem createEnderUpgradeTemplate(Item.Settings settings) {
        return new EnderSmithingTemplate(
                ENDER_UPGRADE_APPLIES_TO,
                ENDER_UPGRADE_INGREDIENTS,
                ENDER_UPGRADE_BASE_SLOT_DESCRIPTION,
                ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                INGREDIENT_SLOTS,
                getEnderUpgradeEmptyAdditionsSlotTextures(),
                settings
        );
    }

    public static List<Identifier> getEnderUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EYE_SLOT);
    }
}
