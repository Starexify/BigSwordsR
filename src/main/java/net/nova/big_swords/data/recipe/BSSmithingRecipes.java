package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.nova.big_swords.init.BSItems;

import java.util.concurrent.CompletableFuture;

public class BSSmithingRecipes extends BSRecipeProvider{
    public final RecipeOutput recipeOutput;

    public BSSmithingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput recipeOutput) {
        super(output, lookupProvider);
        this.recipeOutput = recipeOutput;
    }
    public void build() {
        netheriteSmithing(recipeOutput, BSItems.DIAMOND_BIG_SWORD.asItem(), RecipeCategory.COMBAT, BSItems.NETHERITE_BIG_SWORD.asItem());
    }
}
