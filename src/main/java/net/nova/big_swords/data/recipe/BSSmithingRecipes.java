package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.nova.big_swords.init.BSItems;

import java.util.concurrent.CompletableFuture;

public class BSSmithingRecipes extends BSRecipeProvider {
    public final RecipeOutput recipeOutput;

    public BSSmithingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput recipeOutput) {
        super(output, lookupProvider);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        netheriteBlockSmithing(recipeOutput, BSItems.DIAMOND_BIG_SWORD.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_BIG_SWORD.get());
        enderSmithing(recipeOutput, BSItems.OBSIDIAN_BIG_SWORD.get(), RecipeCategory.COMBAT, BSItems.ENDER_BIG_SWORD.get());
        netheriteSmithing(recipeOutput, BSItems.DIAMOND_GLAIVE.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_GLAIVE.get());
        netheriteSmithing(recipeOutput, BSItems.DIAMOND_SCYTHE.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_SCYTHE.get());
        netheriteSmithing(recipeOutput, BSItems.DIAMOND_SHIELD.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_SHIELD.get());
        netheriteSmithing(recipeOutput, BSItems.GILDED_DIAMOND_SHIELD.get(), RecipeCategory.COMBAT, BSItems.GILDED_NETHERITE_SHIELD.get());
        enderSmithing(recipeOutput, BSItems.NETHERITE_SHIELD.get(), RecipeCategory.COMBAT, BSItems.ENDER_SHIELD.get());
        enderSmithing(recipeOutput, BSItems.GILDED_NETHERITE_SHIELD.get(), RecipeCategory.COMBAT, BSItems.GILDED_ENDER_SHIELD.get());
    }
}
