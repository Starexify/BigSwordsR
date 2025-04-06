package net.nova.big_swords.data.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class BSRecipeProvider extends FabricRecipeProvider {
    public BSRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        new BSSmithingRecipes(provider, recipeOutput).buildRecipes();
        new BSFurnaceRecipes(provider, recipeOutput).buildRecipes();
        return new CraftingRecipes(provider, recipeOutput);
    }

    @Override
    public String getName() {
        return "BSR Recipes Generator";
    }
}
