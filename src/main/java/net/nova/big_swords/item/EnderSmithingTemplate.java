package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.util.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.nova.big_swords.BigSwordsR;

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

  public static final List<Identifier> EMPTY_SLOTS = new ArrayList<>(Arrays.asList(
      Identifier.withDefaultNamespace("container/slot/helmet"),
      Identifier.withDefaultNamespace("container/slot/chestplate"),
      Identifier.withDefaultNamespace("container/slot/leggings"),
      Identifier.withDefaultNamespace("container/slot/boots"),
      Identifier.withDefaultNamespace("container/slot/hoe"),
      Identifier.withDefaultNamespace("container/slot/axe"),
      Identifier.withDefaultNamespace("container/slot/sword"),
      Identifier.withDefaultNamespace("container/slot/shovel"),
      Identifier.withDefaultNamespace("container/slot/pickaxe"),
      BigSwordsR.rl("container/slot/big_sword")
  ));

  public static final Identifier EYE_SLOT = BigSwordsR.rl("container/slot/eye");

  public EnderSmithingTemplate(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<Identifier> upgradeIconList, List<Identifier> upgradeMaterialList, Properties properties) {
    super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, upgradeIconList, upgradeMaterialList, properties);
  }

  public static EnderSmithingTemplate createEnderUpgradeTemplate(Item.Properties properties) {
    return new EnderSmithingTemplate(
        ENDER_UPGRADE_APPLIES_TO,
        ENDER_UPGRADE_INGREDIENTS,
        ENDER_UPGRADE_BASE_SLOT_DESCRIPTION,
        ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
        EMPTY_SLOTS,
        createEnderUpgradeMaterialList(),
        properties
    );
  }

  public static List<Identifier> createEnderUpgradeMaterialList() {
    return List.of(EYE_SLOT);
  }
}
