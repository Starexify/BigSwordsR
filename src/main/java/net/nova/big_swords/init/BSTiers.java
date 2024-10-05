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
            rl("patchwork"), List.of(Tiers.WOOD), List.of());
    public static final Tier SKULL = TierSortingRegistry.registerTier(
            new ForgeTier(1, 103, 2.0F, -0.5F, 13,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.BONE)),
            rl("skull"), List.of(Tiers.WOOD), List.of());
    public static final Tier QUARTZ = TierSortingRegistry.registerTier(
            new ForgeTier(2, 187, 5.0F, 1.0F, 17,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.QUARTZ)),
            rl("quartz"), List.of(Tiers.STONE), List.of());
    public static final Tier OBSIDIAN = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1171, 9.0F, 3.5F, 12,
                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.OBSIDIAN)),
            rl("obsidian"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier ENDER = TierSortingRegistry.registerTier(
            new ForgeTier(5,3046, 12.0F, 5.5F, 18,
                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.ENDER_EYE)),
            rl("ender"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier LIVINGMETAL = TierSortingRegistry.registerTier(
            new ForgeTier(3, 375, 7.5F, 2.5F, 16,
                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(BSItems.LIVINGMETAL_INGOT.get())),
            rl("livingmetal"), List.of(Tiers.IRON), List.of());
    public static final Tier BIOMASS = TierSortingRegistry.registerTier(
            new ForgeTier(2, 188, 8.0F, 2.0F, 18,
                    BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(BSItems.BIOMASS.get())),
            rl("biomass"), List.of(Tiers.STONE), List.of());
    public static final Tier REAPER = TierSortingRegistry.registerTier(
            new ForgeTier(1, 206, 2.0F, -0.5F, 18,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.BONE)),
            rl("reaper"), List.of(Tiers.WOOD), List.of());
}