package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.nova.big_swords.init.BSItems;

import java.util.concurrent.CompletableFuture;

public class FurnaceRecipes extends BSRecipeProvider {
    public final RecipeOutput recipeOutput;

    public FurnaceRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput recipeOutput) {
        super(output, lookupProvider);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy("has_iron_big_sword", has(BSItems.IRON_BIG_SWORD))
                .save(recipeOutput, path + getSmeltingRecipeName(BSItems.IRON_BIG_SWORD));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy("has_iron_big_sword", has(BSItems.IRON_BIG_SWORD))
                .save(recipeOutput, path + getBlastingRecipeName(BSItems.IRON_BIG_SWORD));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy("has_golden_big_sword", has(BSItems.GOLDEN_BIG_SWORD))
                .save(recipeOutput, path + getSmeltingRecipeName(BSItems.GOLDEN_BIG_SWORD));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy("has_golden_big_sword", has(BSItems.GOLDEN_BIG_SWORD))
                .save(recipeOutput, path + getBlastingRecipeName(BSItems.GOLDEN_BIG_SWORD));
    }
}
