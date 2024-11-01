package net.nova.big_swords.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

import static net.nova.big_swords.BigSwordsR.rl;

public class BSTiers {
    public static final Tier PATCHWORK = TierSortingRegistry.registerTier(
            new ForgeTier(1, 30, 1.0F, -1.5F, 16,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.ROTTEN_FLESH)),
            rl("patchwork"), List.of(), List.of());
    public static final Tier SKULL = TierSortingRegistry.registerTier(
            new ForgeTier(1, 103, 2.0F, -0.5F, 13,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.BONE)),
            rl("skull"), List.of(), List.of());
    public static final Tier QUARTZ = TierSortingRegistry.registerTier(
            new ForgeTier(2, 187, 5.0F, 1.0F, 17,
                    BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.QUARTZ)),
            rl("quartz"), List.of(), List.of());
    public static final Tier OBSIDIAN = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1171, 9.0F, 3.5F, 12,
                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.OBSIDIAN)),
            rl("obsidian"), List.of(), List.of());
    public static final Tier ENDER = TierSortingRegistry.registerTier(
            new ForgeTier(5,3046, 12.0F, 5.5F, 18,
                    Tags.BlockTags.NEEDS_ENDER_TOOL, () -> Ingredient.of(Items.ENDER_EYE)),
            rl("ender"), List.of(), List.of());
    public static final Tier REAPER = TierSortingRegistry.registerTier(
            new ForgeTier(1, 206, 2.0F, -0.5F, 18,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.BONE)),
            rl("reaper"), List.of(), List.of());
}