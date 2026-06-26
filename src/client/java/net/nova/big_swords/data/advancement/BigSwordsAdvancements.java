package net.nova.big_swords.data.advancement;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.BlockPredicate;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.function.Consumer;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BigSwordsAdvancements implements AdvancementSubProvider {
  @Override
  public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> save) {
    HolderGetter<Block> blockGetter = registries.lookupOrThrow(Registries.BLOCK);
    HolderGetter<Item> itemGetter = registries.lookupOrThrow(Registries.ITEM);

    AdvancementHolder root = Advancement.Builder.advancement().display(
            BSItems.ENDER_BIG_SWORD.getFirst().value(),
            Component.translatable("advancements." + MODID + ".root.title"),
            Component.translatable("advancements." + MODID + ".root.description"),
            BigSwordsR.rl("textures/gui/advancements/backgrounds/big_swords.png"),
            AdvancementType.TASK, true, false, false)
        .addCriterion("player_join", PlayerTrigger.TriggerInstance.tick())
        .save(save, MODID + ":root");

    // Big Swords
    AdvancementHolder firstBigSword = makeRoot(root, BSItems.WOODEN_BIG_SWORD.getFirst().value(), Tags.BSItemTags.BIG_SWORDS, "first_big_sword", AdvancementType.TASK, registries, save);
    AdvancementHolder netheriteBigSword = makeRootXP(firstBigSword, BSItems.NETHERITE_BIG_SWORD.getFirst().value(), "get_netherite_big_sword", AdvancementType.CHALLENGE, 225, save);
    getItemXP(netheriteBigSword, BSItems.ENDER_BIG_SWORD.getFirst().value(), "get_ender_big_sword", AdvancementType.CHALLENGE, 100, true, true, true, save);

    // Scythes
    AdvancementHolder firstScythe = makeRoot(root, BSItems.WOODEN_SCYTHE.getFirst().value(), Tags.BSItemTags.SCYTHES, "first_scythe", AdvancementType.TASK, registries, save);
    getItemXP(firstScythe, BSItems.NETHERITE_SCYTHE.getFirst().value(), "get_netherite_scythe", AdvancementType.CHALLENGE, 25, true, true, save);
    getItemXP(firstScythe, BSItems.SOUL_REAPER.getFirst().value(), "get_soul_reaper", AdvancementType.CHALLENGE, 200, true, true, true, save);

    // Glaives
    AdvancementHolder firstGlaive = makeRoot(root, BSItems.WOODEN_GLAIVE.getFirst().value(), Tags.BSItemTags.GLAIVES, "first_glaive", AdvancementType.TASK, registries, save);
    getItemXP(firstGlaive, BSItems.NETHERITE_GLAIVE.getFirst().value(), "get_netherite_glaive", AdvancementType.CHALLENGE, 25, true, true, save);

    AdvancementHolder firstShield = makeRoot(root, BSItems.WOODEN_SHIELD.getFirst().value(), Tags.BSItemTags.SHIELDS, "first_shield", AdvancementType.TASK, registries, save);
    AdvancementHolder netheriteShield = makeRootXP(firstShield, BSItems.NETHERITE_SHIELD.getFirst().value(), "get_netherite_shield", AdvancementType.CHALLENGE, 25, save);
    getItemXP(netheriteShield, BSItems.ENDER_SHIELD.getFirst().value(), "get_ender_shield", AdvancementType.CHALLENGE, 50, true, true, true, save);

    // Biomass Advancements
    AdvancementHolder creepABlock = Advancement.Builder.advancement().parent(root).display(
        BSBlocks.CREEP_BLOCK.getFirst().value(),
        Component.translatable("advancements." + MODID + ".creep_a_block.title"),
        Component.translatable("advancements." + MODID + ".creep_a_block.description"),
        null,
        AdvancementType.TASK,
        true,
        false,
        false
    ).addCriterion("creep_a_block", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
        LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blockGetter, BSBlocks.CREEP_BLOCK.getFirst().value())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CreepBlock.TILLED, false))),
        ItemPredicate.Builder.item().of(itemGetter, BSItems.CREEP_BALL.getFirst().value())
    )).save(save, MODID + ":root/creep_a_block");
    AdvancementHolder tillCreep = Advancement.Builder.advancement().parent(creepABlock).display(
        BSBlocks.CREEP_BLOCK.getFirst().value(),
        Component.translatable("advancements." + MODID + ".till_creep.title"),
        Component.translatable("advancements." + MODID + ".till_creep.description"),
        null,
        AdvancementType.TASK,
        true,
        false,
        false
    ).addCriterion("till_creep", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
        LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blockGetter, BSBlocks.CREEP_BLOCK.getFirst().value())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CreepBlock.TILLED, true))),
        ItemPredicate.Builder.item().of(itemGetter, Tags.BSItemTags.GLAIVES)
    )).save(save, MODID + ":root/till_creep");

    // Livingmetal Advancements
    AdvancementHolder soulHarvesting = makeRoot(root, BSItems.SOUL.getFirst().value(), BSItems.SOUL.getFirst().value(), "soul_harvesting", AdvancementType.TASK, registries, save);
  }

  // Methods
  public static AdvancementHolder makeRoot(AdvancementHolder parent, ItemLike displayItem, TagKey<Item> tags, String name, AdvancementType advancementType, HolderLookup.Provider registries, Consumer<AdvancementHolder> save) {
    HolderGetter<Item> itemGetter = registries.lookupOrThrow(Registries.ITEM);
    return Advancement.Builder.advancement()
        .parent(parent)
        .display(
            displayItem,
            Component.translatable("advancements." + MODID + "." + name + ".title"),
            Component.translatable("advancements." + MODID + "." + name + ".description"),
            null,
            advancementType,
            true,
            false,
            false
        )
        .addCriterion("get_" + displayItem, InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemGetter, tags)))
        .save(save, MODID + ":root/" + name); // Return the created AdvancementHolder
  }

  public static AdvancementHolder makeRoot(AdvancementHolder parent, ItemLike displayItem, ItemLike criterionItem, String name, AdvancementType advancementType, HolderLookup.Provider registries, Consumer<AdvancementHolder> save) {
    HolderGetter<Item> itemGetter = registries.lookupOrThrow(Registries.ITEM);
    return Advancement.Builder.advancement()
        .parent(parent)
        .display(
            displayItem,
            Component.translatable("advancements." + MODID + "." + name + ".title"),
            Component.translatable("advancements." + MODID + "." + name + ".description"),
            null,
            advancementType,
            true,
            false,
            false
        )
        .addCriterion("get_" + displayItem, InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemGetter, criterionItem)))
        .save(save, MODID + ":root/" + name);
  }

  public static AdvancementHolder makeRootXP(AdvancementHolder parent, ItemLike displayItem, String name, AdvancementType advancementType, int xp, Consumer<AdvancementHolder> save) {
    return Advancement.Builder.advancement()
        .parent(parent)
        .display(
            displayItem,
            Component.translatable("advancements." + MODID + "." + name + ".title"),
            Component.translatable("advancements." + MODID + "." + name + ".description"),
            null,
            advancementType,
            true,
            true,
            false
        )
        .rewards(AdvancementRewards.Builder.experience(xp))
        .addCriterion("get_" + displayItem, InventoryChangeTrigger.TriggerInstance.hasItems(displayItem))
        .save(save, MODID + ":root/" + name);
  }

  public static void getItemXP(AdvancementHolder parent, ItemLike displayItem, String name, AdvancementType advancementType, int xp, boolean showToast, boolean announceToChat, Consumer<AdvancementHolder> save) {
    getItemXP(parent, displayItem, name, advancementType, xp, showToast, announceToChat, false, save);
  }

  public static void getItemXP(AdvancementHolder parent, ItemLike displayItem, String name, AdvancementType advancementType, int xp, boolean showToast, boolean announceToChat, boolean hidden, Consumer<AdvancementHolder> save) {
    Advancement.Builder.advancement().parent(parent).display(
            displayItem,
            Component.translatable("advancements." + MODID + "." + name + ".title"),
            Component.translatable("advancements." + MODID + "." + name + ".description"),
            null,
            advancementType,
            showToast,
            announceToChat,
            hidden
        )
        .rewards(AdvancementRewards.Builder.experience(xp))
        .addCriterion(name, InventoryChangeTrigger.TriggerInstance.hasItems(displayItem))
        .save(save, MODID + ":root/" + name);
  }

  public static void getItem(AdvancementHolder parent, ItemLike displayItem, String name, AdvancementType advancementType, boolean showToast, boolean announceToChat, Consumer<AdvancementHolder> save) {
    getItem(parent, displayItem, name, advancementType, showToast, announceToChat, false, save);
  }

  public static void getItem(AdvancementHolder parent, ItemLike displayItem, String name, AdvancementType advancementType, boolean showToast, boolean announceToChat, boolean hidden, Consumer<AdvancementHolder> save) {
    Advancement.Builder.advancement().parent(parent).display(
            displayItem,
            Component.translatable("advancements." + MODID + "." + name + ".title"),
            Component.translatable("advancements." + MODID + "." + name + ".description"),
            null,
            advancementType,
            showToast,
            announceToChat,
            hidden
        )
        .addCriterion(name, InventoryChangeTrigger.TriggerInstance.hasItems(displayItem))
        .save(save, MODID + ":root/" + name);
  }
}
