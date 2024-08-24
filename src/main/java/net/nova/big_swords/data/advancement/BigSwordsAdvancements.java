package net.nova.big_swords.data.advancement;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.VaultBlock;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.function.Consumer;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BigSwordsAdvancements implements AdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> save, ExistingFileHelper existingFileHelper) {
        AdvancementHolder root = Advancement.Builder.advancement().display(
                        BSItems.ENDER_BIG_SWORD,
                        Component.translatable("advancements." + MODID + ".root.title"),
                        Component.translatable("advancements." + MODID + ".root.description"),
                        BigSwordsR.rl("textures/gui/advancements/backgrounds/big_swords.png"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion("player_join", PlayerTrigger.TriggerInstance.tick())
                .save(save, MODID + ":root");

        // Big Swords
        AdvancementHolder firstBigSword = makeRoot(root, BSItems.WOODEN_BIG_SWORD, Tags.BSItemTags.BIG_SWORDS, "first_big_sword", AdvancementType.TASK, save);
        AdvancementHolder netheriteBigSword = makeRootXP(firstBigSword, BSItems.NETHERITE_BIG_SWORD, "get_netherite_big_sword", AdvancementType.CHALLENGE, 225, save);
        getItemXP(netheriteBigSword, BSItems.ENDER_BIG_SWORD, "get_ender_big_sword", AdvancementType.CHALLENGE, 100, true, true, true, save);

        // Scythes
        AdvancementHolder firstScythe = makeRoot(root, BSItems.WOODEN_SCYTHE, Tags.BSItemTags.SCYTHES, "first_scythe", AdvancementType.TASK, save);
        getItemXP(firstScythe, BSItems.NETHERITE_SCYTHE, "get_netherite_scythe", AdvancementType.CHALLENGE, 25, true, true, save);
        getItemXP(firstScythe, BSItems.SOUL_REAPER, "get_soul_reaper", AdvancementType.CHALLENGE, 200, true, true, true, save);

        // Glaives
        AdvancementHolder firstGlaive = makeRoot(root, BSItems.WOODEN_GLAIVE, Tags.BSItemTags.GLAIVES, "first_glaive", AdvancementType.TASK, save);
        getItemXP(firstGlaive, BSItems.NETHERITE_GLAIVE, "get_netherite_glaive", AdvancementType.CHALLENGE, 25, true, true, save);

        AdvancementHolder firstShield = makeRoot(root, BSItems.WOODEN_SHIELD, Tags.BSItemTags.SHIELDS, "first_shield", AdvancementType.TASK, save);
        AdvancementHolder netheriteShield = makeRootXP(firstShield, BSItems.NETHERITE_SHIELD, "get_netherite_shield", AdvancementType.CHALLENGE, 25, save);
        getItemXP(netheriteShield, BSItems.ENDER_SHIELD, "get_ender_shield", AdvancementType.CHALLENGE, 50, true, true, true, save);


        // Biomass Advancements
        AdvancementHolder creepABlock = Advancement.Builder.advancement().parent(root).display(
                BSBlocks.CREEP_BLOCK,
                Component.translatable("advancements." + MODID + ".creep_a_block.title"),
                Component.translatable("advancements." + MODID + ".creep_a_block.description"),
                null,
                AdvancementType.TASK,
                true,
                false,
                false
        ).addCriterion("creep_a_block", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(BSBlocks.CREEP_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CreepBlock.TILLED, false))),
                ItemPredicate.Builder.item().of(BSItems.CREEP_BALL)
        )).save(save, MODID + ":root/creep_a_block");
        AdvancementHolder tillCreep = Advancement.Builder.advancement().parent(creepABlock).display(
                BSBlocks.CREEP_BLOCK,
                Component.translatable("advancements." + MODID + ".till_creep.title"),
                Component.translatable("advancements." + MODID + ".till_creep.description"),
                null,
                AdvancementType.TASK,
                true,
                false,
                false
        ).addCriterion("till_creep", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(BSBlocks.CREEP_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CreepBlock.TILLED, true))),
                ItemPredicate.Builder.item().of(Tags.BSItemTags.GLAIVES)
        )).save(save, MODID + ":root/till_creep");

        // Livingmetal Advancements (Soon)
    }

    // Methods
    public static AdvancementHolder makeRoot(AdvancementHolder parent, ItemLike displayItem, TagKey<Item> tags, String name, AdvancementType advancementType, Consumer<AdvancementHolder> save) {
        AdvancementHolder advancement = Advancement.Builder.advancement()
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
                .addCriterion("get_" + displayItem, InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(tags)))
                .save(save, MODID + ":root/" + name);

        return advancement; // Return the created AdvancementHolder
    }

    public static AdvancementHolder makeRootXP(AdvancementHolder parent, ItemLike displayItem, String name, AdvancementType advancementType, int xp, Consumer<AdvancementHolder> save) {
        AdvancementHolder advancement = Advancement.Builder.advancement()
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

        return advancement;
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
