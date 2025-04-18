package net.nova.big_swords.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeDispatcher;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.mixin.RecipeDispatcherAccessor;

public class BSCraftingRecipes {
    public static void initialize() {
        // Extra Recipes
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.BLOOD_VIAL, 1),
                "XXX", "X X", " X ",
                'X', Blocks.GLASS);

        // Sticks
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_WOODEN_STICK, 1),
                " XX", "XXX", "XX ",
                'X', Items.STICK);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_BLAZE_ROD, 1),
                " XX", "XXX", "XX ",
                'X', Items.BLAZE_ROD);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_BLAZE_ROD, 1),
                " LX", "LXL", "XL ",
                'X', Items.STICK, 'L', BSItems.LIVINGMETAL_INGOT);
    }
}
