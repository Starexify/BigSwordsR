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
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.nova.big_swords.init.BSItems;

public class FurnaceRecipes extends RecipeProvider {
  public final HolderGetter<Item> itemLookup;

  protected FurnaceRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
    super(provider, recipeOutput);
    this.itemLookup = registries.lookupOrThrow(Registries.ITEM);
  }

  @Override
  public void buildRecipes() {
    // Big Swords
    SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                BSItems.IRON_BIG_SWORD.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.IRON_INGOT,
            0.1F,
            200
        )
        .unlockedBy(getHasName(BSItems.IRON_BIG_SWORD.getFirst().value()), has(BSItems.IRON_BIG_SWORD.getFirst().value()))
        .save(output, getSmeltingRecipeName(BSItems.IRON_BIG_SWORD.getFirst().value()));

    SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                BSItems.IRON_BIG_SWORD.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.IRON_INGOT,
            0.1F,
            100
        )
        .unlockedBy(getHasName(BSItems.IRON_BIG_SWORD.getFirst().value()), has(BSItems.IRON_BIG_SWORD.getFirst().value()))
        .save(output, getBlastingRecipeName(BSItems.IRON_BIG_SWORD.getFirst().value()));

    SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                BSItems.GOLDEN_BIG_SWORD.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.GOLD_INGOT,
            0.1F,
            200
        )
        .unlockedBy(getHasName(BSItems.GOLDEN_BIG_SWORD.getFirst().value()), has(BSItems.GOLDEN_BIG_SWORD.getFirst().value()))
        .save(output, getSmeltingRecipeName(BSItems.GOLDEN_BIG_SWORD.getFirst().value()));

    SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                BSItems.GOLDEN_BIG_SWORD.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.GOLD_INGOT,
            0.1F,
            100
        )
        .unlockedBy(getHasName(BSItems.GOLDEN_BIG_SWORD.getFirst().value()), has(BSItems.GOLDEN_BIG_SWORD.getFirst().value()))
        .save(output, getBlastingRecipeName(BSItems.GOLDEN_BIG_SWORD.getFirst().value()));

    // Glaives & Scythes
    SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                BSItems.IRON_GLAIVE.getFirst().value(),
                BSItems.IRON_SCYTHE.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.IRON_NUGGET,
            0.1F,
            200
        )
        .unlockedBy(getHasName(BSItems.IRON_GLAIVE.getFirst().value()), has(BSItems.IRON_GLAIVE.getFirst().value()))
        .unlockedBy(getHasName(BSItems.IRON_SCYTHE.getFirst().value()), has(BSItems.IRON_SCYTHE.getFirst().value()))
        .save(output, getSmeltingRecipeName(Items.IRON_NUGGET));

    SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                BSItems.IRON_GLAIVE.getFirst().value(),
                BSItems.IRON_SCYTHE.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.IRON_NUGGET,
            0.1F,
            100
        )
        .unlockedBy(getHasName(BSItems.IRON_GLAIVE.getFirst().value()), has(BSItems.IRON_GLAIVE.getFirst().value()))
        .unlockedBy(getHasName(BSItems.IRON_SCYTHE.getFirst().value()), has(BSItems.IRON_SCYTHE.getFirst().value()))
        .save(output, getBlastingRecipeName(Items.IRON_NUGGET));

    SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                BSItems.GOLDEN_GLAIVE.getFirst().value(),
                BSItems.GOLDEN_SCYTHE.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.GOLD_NUGGET,
            0.1F,
            200
        )
        .unlockedBy(getHasName(BSItems.GOLDEN_GLAIVE.getFirst().value()), has(BSItems.GOLDEN_GLAIVE.getFirst().value()))
        .unlockedBy(getHasName(BSItems.GOLDEN_SCYTHE.getFirst().value()), has(BSItems.GOLDEN_SCYTHE.getFirst().value()))
        .save(output, getSmeltingRecipeName(Items.GOLD_NUGGET));

    SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                BSItems.GOLDEN_GLAIVE.getFirst().value(),
                BSItems.GOLDEN_SCYTHE.getFirst().value()
            ),
            RecipeCategory.MISC,
            CookingBookCategory.MISC,
            Items.GOLD_NUGGET,
            0.1F,
            100
        )
        .unlockedBy(getHasName(BSItems.GOLDEN_GLAIVE.getFirst().value()), has(BSItems.GOLDEN_GLAIVE.getFirst().value()))
        .unlockedBy(getHasName(BSItems.GOLDEN_SCYTHE.getFirst().value()), has(BSItems.GOLDEN_SCYTHE.getFirst().value()))
        .save(output, getBlastingRecipeName(Items.GOLD_NUGGET));
  }
}
