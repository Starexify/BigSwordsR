package net.nova.big_swords.data.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.nova.big_swords.init.BSItems;

import java.util.function.Consumer;

public class FurnaceRecipes extends BSRecipeProvider {
    public final Consumer<FinishedRecipe> recipeOutput;

    public FurnaceRecipes(PackOutput output, Consumer<FinishedRecipe> recipeOutput) {
        super(output);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        // Big Swords
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD.get()
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_BIG_SWORD.get()), has(BSItems.IRON_BIG_SWORD.get()))
                .save(recipeOutput, path + getSmeltingRecipeName(BSItems.IRON_BIG_SWORD.get()));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD.get()
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_BIG_SWORD.get()), has(BSItems.IRON_BIG_SWORD.get()))
                .save(recipeOutput, path + getBlastingRecipeName(BSItems.IRON_BIG_SWORD.get()));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD.get()
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_BIG_SWORD.get()), has(BSItems.GOLDEN_BIG_SWORD.get()))
                .save(recipeOutput, path + getSmeltingRecipeName(BSItems.GOLDEN_BIG_SWORD.get()));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD.get()
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_BIG_SWORD.get()), has(BSItems.GOLDEN_BIG_SWORD.get()))
                .save(recipeOutput, path + getBlastingRecipeName(BSItems.GOLDEN_BIG_SWORD.get()));

        // Glaives & Scythes
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.IRON_GLAIVE.get(),
                                BSItems.IRON_SCYTHE.get()
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_GLAIVE.get()), has(BSItems.IRON_GLAIVE.get()))
                .unlockedBy("has_" + getItemName(BSItems.IRON_SCYTHE.get()), has(BSItems.IRON_SCYTHE.get()))
                .save(recipeOutput, path + getSmeltingRecipeName(Items.IRON_NUGGET));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.IRON_GLAIVE.get(),
                                BSItems.IRON_SCYTHE.get()
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_GLAIVE.get()), has(BSItems.IRON_GLAIVE.get()))
                .unlockedBy("has_" + getItemName(BSItems.IRON_SCYTHE.get()), has(BSItems.IRON_SCYTHE.get()))
                .save(recipeOutput, path + getBlastingRecipeName(Items.IRON_NUGGET));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.GOLDEN_GLAIVE.get(),
                                BSItems.GOLDEN_SCYTHE.get()
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_GLAIVE.get()), has(BSItems.GOLDEN_GLAIVE.get()))
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_SCYTHE.get()), has(BSItems.GOLDEN_SCYTHE.get()))
                .save(recipeOutput, path + getSmeltingRecipeName(Items.GOLD_NUGGET));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.GOLDEN_GLAIVE.get(),
                                BSItems.GOLDEN_SCYTHE.get()
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_GLAIVE.get()), has(BSItems.GOLDEN_GLAIVE.get()))
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_SCYTHE.get()), has(BSItems.GOLDEN_SCYTHE.get()))
                .save(recipeOutput, path + getBlastingRecipeName(Items.GOLD_NUGGET));
    }
}
