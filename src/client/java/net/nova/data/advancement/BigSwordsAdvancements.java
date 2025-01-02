package net.nova.data.advancement;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.block.Block;
import net.minecraft.data.advancement.AdvancementTabGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.nova.BigSwordsR;
import net.nova.block.CreepBlock;
import net.nova.init.BSBlocks;
import net.nova.init.BSItems;
import net.nova.init.Tags;

import java.util.function.Consumer;

import static net.nova.BigSwordsR.MODID;

public class BigSwordsAdvancements implements AdvancementTabGenerator {

    @Override
    public void accept(RegistryWrapper.WrapperLookup registries, Consumer<AdvancementEntry> exporter) {
        RegistryEntryLookup<Block> blockGetter = registries.getOrThrow(RegistryKeys.BLOCK);
        RegistryEntryLookup<Item> itemGetter = registries.getOrThrow(RegistryKeys.ITEM);

        AdvancementEntry root = Advancement.Builder.create().display(
                        BSItems.ENDER_BIG_SWORD,
                        Text.translatable("advancements." + MODID + ".root.title"),
                        Text.translatable("advancements." + MODID + ".root.description"),
                        BigSwordsR.rl("textures/gui/advancements/backgrounds/big_swords.png"),
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("player_join", TickCriterion.Conditions.createTick())
                .build(exporter, MODID + ":root");

        // Big Swords
        AdvancementEntry firstBigSword = makeRoot(root, BSItems.WOODEN_BIG_SWORD, Tags.BSItemTags.BIG_SWORDS, "first_big_sword", AdvancementFrame.TASK, registries, exporter);
        AdvancementEntry netheriteBigSword = makeRootXP(firstBigSword, BSItems.NETHERITE_BIG_SWORD, "get_netherite_big_sword", AdvancementFrame.CHALLENGE, 225, exporter);
        getItemXP(netheriteBigSword, BSItems.ENDER_BIG_SWORD, "get_ender_big_sword", AdvancementFrame.CHALLENGE, 100, true, true, true, exporter);

        // Scythes
        AdvancementEntry firstScythe = makeRoot(root, BSItems.WOODEN_SCYTHE, Tags.BSItemTags.SCYTHES, "first_scythe", AdvancementFrame.TASK, registries, exporter);
        getItemXP(firstScythe, BSItems.NETHERITE_SCYTHE, "get_netherite_scythe", AdvancementFrame.CHALLENGE, 25, true, true, exporter);
        getItemXP(firstScythe, BSItems.SOUL_REAPER, "get_soul_reaper", AdvancementFrame.CHALLENGE, 200, true, true, true, exporter);

        // Glaives
        AdvancementEntry firstGlaive = makeRoot(root, BSItems.WOODEN_GLAIVE, Tags.BSItemTags.GLAIVES, "first_glaive", AdvancementFrame.TASK, registries, exporter);
        getItemXP(firstGlaive, BSItems.NETHERITE_GLAIVE, "get_netherite_glaive", AdvancementFrame.CHALLENGE, 25, true, true, exporter);

        AdvancementEntry firstShield = makeRoot(root, BSItems.WOODEN_SHIELD, Tags.BSItemTags.SHIELDS, "first_shield", AdvancementFrame.TASK, registries, exporter);
        AdvancementEntry netheriteShield = makeRootXP(firstShield, BSItems.NETHERITE_SHIELD, "get_netherite_shield", AdvancementFrame.CHALLENGE, 25, exporter);
        getItemXP(netheriteShield, BSItems.ENDER_SHIELD, "get_ender_shield", AdvancementFrame.CHALLENGE, 50, true, true, true, exporter);


        // Biomass Advancements
        AdvancementEntry creepABlock = Advancement.Builder.create().parent(root).display(
                BSBlocks.CREEP_BLOCK,
                Text.translatable("advancements." + MODID + ".creep_a_block.title"),
                Text.translatable("advancements." + MODID + ".creep_a_block.description"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
        ).criterion("creep_a_block", ItemCriterion.Conditions.createItemUsedOnBlock(
                LocationPredicate.Builder.create().block(BlockPredicate.Builder.create().blocks(blockGetter, BSBlocks.CREEP_BLOCK)
                        .state(StatePredicate.Builder.create().exactMatch(CreepBlock.TILLED, false))),
                ItemPredicate.Builder.create().items(itemGetter, BSItems.CREEP_BALL)
        )).build(exporter, MODID + ":root/creep_a_block");
        AdvancementEntry tillCreep = Advancement.Builder.create().parent(creepABlock).display(
                BSBlocks.CREEP_BLOCK,
                Text.translatable("advancements." + MODID + ".till_creep.title"),
                Text.translatable("advancements." + MODID + ".till_creep.description"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
        ).criterion("till_creep", ItemCriterion.Conditions.createItemUsedOnBlock(
                LocationPredicate.Builder.create().block(BlockPredicate.Builder.create().blocks(blockGetter, BSBlocks.CREEP_BLOCK)
                        .state(StatePredicate.Builder.create().exactMatch(CreepBlock.TILLED, true))),
                ItemPredicate.Builder.create().tag(itemGetter, Tags.BSItemTags.GLAIVES)
        )).build(exporter, MODID + ":root/till_creep");

        // Livingmetal Advancements
        AdvancementEntry soulHarvesting = makeRoot(root, BSItems.SOUL, BSItems.SOUL, "soul_harvesting", AdvancementFrame.TASK, registries, exporter);
    }

    // Methods
    public static AdvancementEntry makeRoot(AdvancementEntry parent, ItemConvertible displayItem, TagKey<Item> tags, String name, AdvancementFrame advancementType, RegistryWrapper.WrapperLookup registries, Consumer<AdvancementEntry> save) {
        RegistryEntryLookup<Item> itemGetter = registries.getOrThrow(RegistryKeys.ITEM);
        AdvancementEntry advancement = Advancement.Builder.create()
                .parent(parent)
                .display(
                        displayItem,
                        Text.translatable("advancements." + MODID + "." + name + ".title"),
                        Text.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        true,
                        false,
                        false
                )
                .criterion("get_" + displayItem, InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(itemGetter, tags)))
                .build(save, MODID + ":root/" + name);

        return advancement; // Return the created AdvancementEntry
    }

    public static AdvancementEntry makeRoot(AdvancementEntry parent, ItemConvertible displayItem, ItemConvertible criterionItem, String name, AdvancementFrame advancementType, RegistryWrapper.WrapperLookup registries, Consumer<AdvancementEntry> save) {
        RegistryEntryLookup<Item> itemGetter = registries.getOrThrow(RegistryKeys.ITEM);
        AdvancementEntry advancement = Advancement.Builder.create()
                .parent(parent)
                .display(
                        displayItem,
                        Text.translatable("advancements." + MODID + "." + name + ".title"),
                        Text.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        true,
                        false,
                        false
                )
                .criterion("get_" + displayItem, InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().items(itemGetter, criterionItem)))
                .build(save, MODID + ":root/" + name);

        return advancement;
    }

    public static AdvancementEntry makeRootXP(AdvancementEntry parent, ItemConvertible displayItem, String name, AdvancementFrame advancementType, int xp, Consumer<AdvancementEntry> save) {
        AdvancementEntry advancement = Advancement.Builder.create()
                .parent(parent)
                .display(
                        displayItem,
                        Text.translatable("advancements." + MODID + "." + name + ".title"),
                        Text.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(xp))
                .criterion("get_" + displayItem, InventoryChangedCriterion.Conditions.items(displayItem))
                .build(save, MODID + ":root/" + name);

        return advancement;
    }

    public static void getItemXP(AdvancementEntry parent, ItemConvertible displayItem, String name, AdvancementFrame advancementType, int xp, boolean showToast, boolean announceToChat, Consumer<AdvancementEntry> save) {
        getItemXP(parent, displayItem, name, advancementType, xp, showToast, announceToChat, false, save);
    }

    public static void getItemXP(AdvancementEntry parent, ItemConvertible displayItem, String name, AdvancementFrame advancementType, int xp, boolean showToast, boolean announceToChat, boolean hidden, Consumer<AdvancementEntry> save) {
        Advancement.Builder.create().parent(parent).display(
                        displayItem,
                        Text.translatable("advancements." + MODID + "." + name + ".title"),
                        Text.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        showToast,
                        announceToChat,
                        hidden
                )
                .rewards(AdvancementRewards.Builder.experience(xp))
                .criterion(name, InventoryChangedCriterion.Conditions.items(displayItem))
                .build(save, MODID + ":root/" + name);
    }

    public static void getItem(AdvancementEntry parent, ItemConvertible displayItem, String name, AdvancementFrame advancementType, boolean showToast, boolean announceToChat, Consumer<AdvancementEntry> save) {
        getItem(parent, displayItem, name, advancementType, showToast, announceToChat, false, save);
    }

    public static void getItem(AdvancementEntry parent, ItemConvertible displayItem, String name, AdvancementFrame advancementType, boolean showToast, boolean announceToChat, boolean hidden, Consumer<AdvancementEntry> save) {
        Advancement.Builder.create().parent(parent).display(
                        displayItem,
                        Text.translatable("advancements." + MODID + "." + name + ".title"),
                        Text.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        showToast,
                        announceToChat,
                        hidden
                )
                .criterion(name, InventoryChangedCriterion.Conditions.items(displayItem))
                .build(save, MODID + ":root/" + name);
    }

}
