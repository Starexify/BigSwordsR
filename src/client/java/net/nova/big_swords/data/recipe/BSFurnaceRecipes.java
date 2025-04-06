package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.nova.big_swords.init.BSItems;

public class BSFurnaceRecipes extends RecipeProvider {
    public final HolderGetter<Item> itemLookup;

    protected BSFurnaceRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
        this.itemLookup = registries.lookupOrThrow(Registries.ITEM);
    }

    @Override
    public void buildRecipes() {
        // Big Swords
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy(getHasName(BSItems.IRON_BIG_SWORD), has(BSItems.IRON_BIG_SWORD))
                .save(output, getSmeltingRecipeName(BSItems.IRON_BIG_SWORD));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy(getHasName(BSItems.IRON_BIG_SWORD), has(BSItems.IRON_BIG_SWORD))
                .save(output, getBlastingRecipeName(BSItems.IRON_BIG_SWORD));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        200
                )
                .unlockedBy(getHasName(BSItems.GOLDEN_BIG_SWORD), has(BSItems.GOLDEN_BIG_SWORD))
                .save(output, getSmeltingRecipeName(BSItems.GOLDEN_BIG_SWORD));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        100
                )
                .unlockedBy(getHasName(BSItems.GOLDEN_BIG_SWORD), has(BSItems.GOLDEN_BIG_SWORD))
                .save(output, getBlastingRecipeName(BSItems.GOLDEN_BIG_SWORD));

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
                .unlockedBy(getHasName(BSItems.IRON_GLAIVE), has(BSItems.IRON_GLAIVE))
                .unlockedBy(getHasName(BSItems.IRON_SCYTHE), has(BSItems.IRON_SCYTHE))
                .save(output, getSmeltingRecipeName(Items.IRON_NUGGET));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.IRON_GLAIVE,
                                BSItems.IRON_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET,
                        0.1F,
                        100
                )
                .unlockedBy(getHasName(BSItems.IRON_GLAIVE), has(BSItems.IRON_GLAIVE))
                .unlockedBy(getHasName(BSItems.IRON_SCYTHE), has(BSItems.IRON_SCYTHE))
                .save(output, getBlastingRecipeName(Items.IRON_NUGGET));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                                BSItems.GOLDEN_GLAIVE,
                                BSItems.GOLDEN_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        200
                )
                .unlockedBy(getHasName(BSItems.GOLDEN_GLAIVE), has(BSItems.GOLDEN_GLAIVE))
                .unlockedBy(getHasName(BSItems.GOLDEN_SCYTHE), has(BSItems.GOLDEN_SCYTHE))
                .save(output, getSmeltingRecipeName(Items.GOLD_NUGGET));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                                BSItems.GOLDEN_GLAIVE,
                                BSItems.GOLDEN_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        100
                )
                .unlockedBy(getHasName(BSItems.GOLDEN_GLAIVE), has(BSItems.GOLDEN_GLAIVE))
                .unlockedBy(getHasName(BSItems.GOLDEN_SCYTHE), has(BSItems.GOLDEN_SCYTHE))
                .save(output, getBlastingRecipeName(Items.GOLD_NUGGET));
    }
}
