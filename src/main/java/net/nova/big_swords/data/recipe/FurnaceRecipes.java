package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.nova.big_swords.init.BSItems;

public class FurnaceRecipes extends BSRecipeProvider {
    public FurnaceRecipes(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput) {
        super(lookupProvider, recipeOutput);
    }

    public void build() {
        // Big Swords
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_BIG_SWORD), has(BSItems.IRON_BIG_SWORD))
                .save(output, path + getSmeltingRecipeName(BSItems.IRON_BIG_SWORD));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_BIG_SWORD), has(BSItems.IRON_BIG_SWORD))
                .save(output, path + getBlastingRecipeName(BSItems.IRON_BIG_SWORD));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_BIG_SWORD), has(BSItems.GOLDEN_BIG_SWORD))
                .save(output, path + getSmeltingRecipeName(BSItems.GOLDEN_BIG_SWORD));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_BIG_SWORD), has(BSItems.GOLDEN_BIG_SWORD))
                .save(output, path + getBlastingRecipeName(BSItems.GOLDEN_BIG_SWORD));

        // Glaives & Scythes
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.IRON_GLAIVE,
                                BSItems.IRON_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_GLAIVE), has(BSItems.IRON_GLAIVE))
                .unlockedBy("has_" + getItemName(BSItems.IRON_SCYTHE), has(BSItems.IRON_SCYTHE))
                .save(output, path + getSmeltingRecipeName(Items.IRON_NUGGET));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.IRON_GLAIVE,
                                BSItems.IRON_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.IRON_GLAIVE), has(BSItems.IRON_GLAIVE))
                .unlockedBy("has_" + getItemName(BSItems.IRON_SCYTHE), has(BSItems.IRON_SCYTHE))
                .save(output, path + getBlastingRecipeName(Items.IRON_NUGGET));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.GOLDEN_GLAIVE,
                                BSItems.GOLDEN_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_GLAIVE), has(BSItems.GOLDEN_GLAIVE))
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_SCYTHE), has(BSItems.GOLDEN_SCYTHE))
                .save(output, path + getSmeltingRecipeName(Items.GOLD_NUGGET));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.GOLDEN_GLAIVE,
                                BSItems.GOLDEN_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_GLAIVE), has(BSItems.GOLDEN_GLAIVE))
                .unlockedBy("has_" + getItemName(BSItems.GOLDEN_SCYTHE), has(BSItems.GOLDEN_SCYTHE))
                .save(output, path + getBlastingRecipeName(Items.GOLD_NUGGET));

    }
}
