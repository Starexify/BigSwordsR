package net.nova.big_swords.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeDispatcher;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.mixin.RecipeDispatcherAccessor;

public class BSCraftingRecipes {
    public static void initialize() {
        // Extra Recipes
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.BLOOD_VIAL),
                "XXX", "X X", " X ",
                'X', Blocks.GLASS);

        // Sticks
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_WOODEN_STICK),
                " XX", "XXX", "XX ",
                'X', Items.STICK);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_BLAZE_ROD),
                " XX", "XXX", "XX ",
                'X', Items.BLAZE_ROD);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_BLAZE_ROD),
                " LX", "LXL", "XL ",
                'X', Items.STICK, 'L', BSItems.LIVINGMETAL_INGOT);

        // Livingmetal Recipes
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_INGOT),
                " S ", "SIS", " S ",
                'I', Items.IRON_INGOT, 'S', BSItems.SOUL);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSBlocks.getBlockItem(BSBlocks.LIVINGMETAL_BLOCK)),
                "###", "###", "###",
                '#', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_INGOT, 9),
                "#",
                '#', BSBlocks.getBlockItem(BSBlocks.LIVINGMETAL_BLOCK));
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_HELMET),
                "###", "# #",
                '#', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_CHESTPLATE),
                "# #", "###", "###",
                '#', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_LEGGINGS),
                "###", "# #", "# #",
                '#', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_BOOTS),
                "# #", "# #",
                '#', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_SWORD),
                "X", "X", "#",
                '#', Items.STICK, 'X', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_PICKAXE),
                "XXX", " # ", " # ",
                '#', Items.STICK, 'X', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_AXE),
                "XX", "X#", " #",
                '#', Items.STICK, 'X', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_SHOVEL),
                "X", "#", "#",
                '#', Items.STICK, 'X', BSItems.LIVINGMETAL_INGOT);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_HOE),
                "XX", " #", " #",
                '#', Items.STICK, 'X', BSItems.LIVINGMETAL_INGOT);
    }
}
