package net.nova.big_swords.data.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BSRecipeProvider extends FabricRecipeProvider {
    public BSRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        new BSSmithingRecipes(wrapperLookup, recipeExporter).generate();
        new BSFurnaceRecipes(wrapperLookup, recipeExporter).generate();
        return new BSCraftingRecipesGenerator(wrapperLookup, recipeExporter);
    }

    @Override
    public String getName() {
        return "BSR Recipes Generator";
    }
}
