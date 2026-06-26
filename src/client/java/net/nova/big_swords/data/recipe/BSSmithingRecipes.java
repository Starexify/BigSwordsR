package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.nova.big_swords.init.BSItems;

public class BSSmithingRecipes extends RecipeProvider {
    public final HolderGetter<Item> itemLookup;

    protected BSSmithingRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
        this.itemLookup = registries.lookupOrThrow(Registries.ITEM);
    }

    @Override
    public void buildRecipes() {
        netheriteBlockSmithing(BSItems.DIAMOND_BIG_SWORD.getFirst().value(), RecipeCategory.COMBAT, BSItems.NETHERITE_BIG_SWORD.getFirst().value());
        enderSmithing(BSItems.OBSIDIAN_BIG_SWORD.getFirst().value(), RecipeCategory.COMBAT, BSItems.ENDER_BIG_SWORD.getFirst().value());
        netheriteSmithing(BSItems.DIAMOND_GLAIVE.getFirst().value(), RecipeCategory.COMBAT, BSItems.NETHERITE_GLAIVE.getFirst().value());
        netheriteSmithing(BSItems.DIAMOND_SCYTHE.getFirst().value(), RecipeCategory.COMBAT, BSItems.NETHERITE_SCYTHE.getFirst().value());
        netheriteSmithing(BSItems.DIAMOND_SHIELD.getFirst().value(), RecipeCategory.COMBAT, BSItems.NETHERITE_SHIELD.getFirst().value());
        netheriteSmithing(BSItems.GILDED_DIAMOND_SHIELD.getFirst().value(), RecipeCategory.COMBAT, BSItems.GILDED_NETHERITE_SHIELD.getFirst().value());
        enderSmithing(BSItems.NETHERITE_SHIELD.getFirst().value(), RecipeCategory.COMBAT, BSItems.ENDER_SHIELD.getFirst().value());
        enderSmithing(BSItems.GILDED_NETHERITE_SHIELD.getFirst().value(), RecipeCategory.COMBAT, BSItems.GILDED_ENDER_SHIELD.getFirst().value());
    }

    // Recipes
    public void netheriteBlockSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_BLOCK), pCategory, pResultItem)
                .unlocks(getHasName(Items.NETHERITE_BLOCK), has(Items.NETHERITE_BLOCK))
                .save(output, getItemName(pResultItem) + "_smithing");
    }

    public void enderSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.getFirst().value()), Ingredient.of(pIngredientItem), Ingredient.of(Items.ENDER_EYE), pCategory, pResultItem)
                .unlocks(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .save(output, getItemName(pResultItem) + "_smithing");
    }
}
