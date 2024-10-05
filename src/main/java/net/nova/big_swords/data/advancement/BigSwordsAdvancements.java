package net.nova.big_swords.data.advancement;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.registries.RegistryObject;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.function.Consumer;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BigSwordsAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> save, ExistingFileHelper existingFileHelper) {
        Advancement root = Advancement.Builder.advancement().display(
                        BSItems.ENDER_BIG_SWORD.get(),
                        Component.translatable("advancements." + MODID + ".root.title"),
                        Component.translatable("advancements." + MODID + ".root.description"),
                        BigSwordsR.rl("textures/gui/advancements/backgrounds/big_swords.png"),
                        FrameType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion("player_join", PlayerTrigger.TriggerInstance.tick())
                .save(save, MODID + ":root");

        // Big Swords
        Advancement firstBigSword = makeRoot(root, BSItems.WOODEN_BIG_SWORD, Tags.BSItemTags.BIG_SWORDS, "first_big_sword", FrameType.TASK, save);
        Advancement netheriteBigSword = makeRootXP(firstBigSword, BSItems.NETHERITE_BIG_SWORD, "get_netherite_big_sword", FrameType.CHALLENGE, 225, save);
        getItemXP(netheriteBigSword, BSItems.ENDER_BIG_SWORD, "get_ender_big_sword", FrameType.CHALLENGE, 100, true, true, true, save);

        // Scythes
        Advancement firstScythe = makeRoot(root, BSItems.WOODEN_SCYTHE, Tags.BSItemTags.SCYTHES, "first_scythe", FrameType.TASK, save);
        getItemXP(firstScythe, BSItems.NETHERITE_SCYTHE, "get_netherite_scythe", FrameType.CHALLENGE, 25, true, true, save);
        getItemXP(firstScythe, BSItems.SOUL_REAPER, "get_soul_reaper", FrameType.CHALLENGE, 200, true, true, true, save);

        // Glaives
        Advancement firstGlaive = makeRoot(root, BSItems.WOODEN_GLAIVE, Tags.BSItemTags.GLAIVES, "first_glaive", FrameType.TASK, save);
        getItemXP(firstGlaive, BSItems.NETHERITE_GLAIVE, "get_netherite_glaive", FrameType.CHALLENGE, 25, true, true, save);

        Advancement firstShield = makeRoot(root, BSItems.WOODEN_SHIELD, Tags.BSItemTags.SHIELDS, "first_shield", FrameType.TASK, save);
        Advancement netheriteShield = makeRootXP(firstShield, BSItems.NETHERITE_SHIELD, "get_netherite_shield", FrameType.CHALLENGE, 25, save);
        getItemXP(netheriteShield, BSItems.ENDER_SHIELD, "get_ender_shield", FrameType.CHALLENGE, 50, true, true, true, save);


        // Biomass Advancements
        Advancement creepABlock = Advancement.Builder.advancement().parent(root).display(
                BSBlocks.CREEP_BLOCK.get(),
                Component.translatable("advancements." + MODID + ".creep_a_block.title"),
                Component.translatable("advancements." + MODID + ".creep_a_block.description"),
                null,
                FrameType.TASK,
                true,
                false,
                false
        ).addCriterion("creep_a_block", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(BSBlocks.CREEP_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CreepBlock.TILLED, false).build()).build()),
                ItemPredicate.Builder.item().of(BSItems.CREEP_BALL.get())
        )).save(save, MODID + ":root/creep_a_block");
        Advancement tillCreep = Advancement.Builder.advancement().parent(creepABlock).display(
                BSBlocks.CREEP_BLOCK.get(),
                Component.translatable("advancements." + MODID + ".till_creep.title"),
                Component.translatable("advancements." + MODID + ".till_creep.description"),
                null,
                FrameType.TASK,
                true,
                false,
                false
        ).addCriterion("till_creep", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(BSBlocks.CREEP_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CreepBlock.TILLED, true).build()).build()),
                ItemPredicate.Builder.item().of(Tags.BSItemTags.GLAIVES)
        )).save(save, MODID + ":root/till_creep");

        // Livingmetal Advancements (Soon)
    }

    // Methods
    public static Advancement makeRoot(Advancement parent, RegistryObject<Item> displayItem, TagKey<Item> tags, String name, FrameType advancementType, Consumer<Advancement> save) {
        Advancement advancement = Advancement.Builder.advancement()
                .parent(parent)
                .display(
                        displayItem.get(),
                        Component.translatable("advancements." + MODID + "." + name + ".title"),
                        Component.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        true,
                        false,
                        false
                )
                .addCriterion("get_" + displayItem, InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(tags).build()))
                .save(save, MODID + ":root/" + name);

        return advancement;
    }

    public static Advancement makeRootXP(Advancement parent, RegistryObject<Item> displayItem, String name, FrameType advancementType, int xp, Consumer<Advancement> save) {
        Advancement advancement = Advancement.Builder.advancement()
                .parent(parent)
                .display(
                        displayItem.get(),
                        Component.translatable("advancements." + MODID + "." + name + ".title"),
                        Component.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(xp))
                .addCriterion("get_" + displayItem.get(), InventoryChangeTrigger.TriggerInstance.hasItems(displayItem.get()))
                .save(save, MODID + ":root/" + name);

        return advancement;
    }

    public static void getItemXP(Advancement parent, RegistryObject<Item> displayItem, String name, FrameType advancementType, int xp, boolean showToast, boolean announceToChat, Consumer<Advancement> save) {
        getItemXP(parent, displayItem, name, advancementType, xp, showToast, announceToChat, false, save);
    }

    public static void getItemXP(Advancement parent, RegistryObject<Item> displayItem, String name, FrameType advancementType, int xp, boolean showToast, boolean announceToChat, boolean hidden, Consumer<Advancement> save) {
        Advancement.Builder.advancement().parent(parent).display(
                        displayItem.get(),
                        Component.translatable("advancements." + MODID + "." + name + ".title"),
                        Component.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        showToast,
                        announceToChat,
                        hidden
                )
                .rewards(AdvancementRewards.Builder.experience(xp))
                .addCriterion(name, InventoryChangeTrigger.TriggerInstance.hasItems(displayItem.get()))
                .save(save, MODID + ":root/" + name);
    }

    public static void getItem(Advancement parent, RegistryObject<Item> displayItem, String name, FrameType advancementType, boolean showToast, boolean announceToChat, Consumer<Advancement> save) {
        getItem(parent, displayItem, name, advancementType, showToast, announceToChat, false, save);
    }

    public static void getItem(Advancement parent, RegistryObject<Item> displayItem, String name, FrameType advancementType, boolean showToast, boolean announceToChat, boolean hidden, Consumer<Advancement> save) {
        Advancement.Builder.advancement().parent(parent).display(
                        displayItem.get(),
                        Component.translatable("advancements." + MODID + "." + name + ".title"),
                        Component.translatable("advancements." + MODID + "." + name + ".description"),
                        null,
                        advancementType,
                        showToast,
                        announceToChat,
                        hidden
                )
                .addCriterion(name, InventoryChangeTrigger.TriggerInstance.hasItems(displayItem.get()))
                .save(save, MODID + ":root/" + name);
    }
}
