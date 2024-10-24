package net.nova.big_swords.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class BSTiers {
    public static final Tier PATCHWORK = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 30, 1.0F, -1.5F, 16, () -> Ingredient.of(Items.ROTTEN_FLESH));
    public static final Tier SKULL = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 103, 2.0F, -0.5F, 13, () -> Ingredient.of(Items.BONE));
    public static final Tier QUARTZ = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 187, 5.0F, 1.0F, 17, () -> Ingredient.of(Items.QUARTZ));
    public static final Tier OBSIDIAN = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1171, 9.0F, 3.5F, 12, () -> Ingredient.of(Items.OBSIDIAN));
    public static final Tier ENDER = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3046, 12.0F, 5.5F, 18, () -> Ingredient.of(Items.ENDER_EYE));
    public static final Tier LIVINGMETAL = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 7.5F, 2.5F, 16, () -> Ingredient.of(BSItems.LIVINGMETAL_INGOT));
    public static final Tier BIOMASS = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 188, 8.0F, 2.0F, 18, () -> Ingredient.of(BSItems.BIOMASS));
    public static final Tier REAPER = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 206, 2.0F, -0.5F, 18, () -> Ingredient.of(Items.BONE));
}
