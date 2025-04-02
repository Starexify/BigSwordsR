package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static final List<ResourceLocation> INGREDIENT_SLOTS = new ArrayList<>(Arrays.asList(
            ResourceLocation.parse("container/slot/helmet"),
            ResourceLocation.withDefaultNamespace("container/slot/chestplate"),
            ResourceLocation.withDefaultNamespace("container/slot/leggings"),
            ResourceLocation.withDefaultNamespace("container/slot/boots"),
            ResourceLocation.withDefaultNamespace("container/slot/hoe"),
            ResourceLocation.withDefaultNamespace("container/slot/axe"),
            ResourceLocation.withDefaultNamespace("container/slot/sword"),
            ResourceLocation.withDefaultNamespace("container/slot/shovel"),
            ResourceLocation.withDefaultNamespace("container/slot/pickaxe"),
            rl("container/slot/big_sword")
    ));
    public static final ResourceLocation EYE_SLOT = rl("container/slot/eye");

    public EnderSmithingTemplate(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> emptyBaseSlotTextures, List<ResourceLocation> emptyAdditionsSlotTextures, Properties properties) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, emptyBaseSlotTextures, emptyAdditionsSlotTextures, properties);
    }

    public static SmithingTemplateItem createEnderUpgradeTemplate(Properties properties) {
        return new EnderSmithingTemplate(
                ENDER_UPGRADE_APPLIES_TO,
                ENDER_UPGRADE_INGREDIENTS,
                ENDER_UPGRADE_BASE_SLOT_DESCRIPTION,
                ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                INGREDIENT_SLOTS,
                getEnderUpgradeEmptyAdditionsSlotTextures(),
                properties
        );
    }

    public static List<ResourceLocation> getEnderUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EYE_SLOT);
    }
}
