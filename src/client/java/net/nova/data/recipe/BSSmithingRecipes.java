package net.nova.data.recipe;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nova.init.BSItems;

public class BSSmithingRecipes extends RecipeGenerator {
    public final RegistryEntryLookup<Item> itemLookup;

    protected BSSmithingRecipes(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
        this.itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
    }

    @Override
    public void generate() {
        netheriteBlockSmithing(BSItems.DIAMOND_BIG_SWORD, RecipeCategory.COMBAT, BSItems.NETHERITE_BIG_SWORD);
        enderSmithing(BSItems.OBSIDIAN_BIG_SWORD, RecipeCategory.COMBAT, BSItems.ENDER_BIG_SWORD);
        offerNetheriteUpgradeRecipe(BSItems.DIAMOND_GLAIVE, RecipeCategory.COMBAT, BSItems.NETHERITE_GLAIVE);
        offerNetheriteUpgradeRecipe(BSItems.DIAMOND_SCYTHE, RecipeCategory.COMBAT, BSItems.NETHERITE_SCYTHE);
        offerNetheriteUpgradeRecipe(BSItems.DIAMOND_SHIELD, RecipeCategory.COMBAT, BSItems.NETHERITE_SHIELD);
        offerNetheriteUpgradeRecipe(BSItems.GILDED_DIAMOND_SHIELD, RecipeCategory.COMBAT, BSItems.GILDED_NETHERITE_SHIELD);
        enderSmithing(BSItems.NETHERITE_SHIELD, RecipeCategory.COMBAT, BSItems.ENDER_SHIELD);
        enderSmithing(BSItems.GILDED_NETHERITE_SHIELD, RecipeCategory.COMBAT, BSItems.GILDED_ENDER_SHIELD);
    }

    public void netheriteBlockSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItem(pIngredientItem), Ingredient.ofItem(Items.NETHERITE_BLOCK), pCategory, pResultItem
                )
                .criterion("has_netherite_block", conditionsFromItem(Items.NETHERITE_BLOCK))
                .offerTo(exporter, getItemPath(pResultItem) + "_smithing");
    }

    public void enderSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItem(pIngredientItem), Ingredient.ofItem(Items.ENDER_EYE), pCategory, pResultItem
                )
                .criterion("has_ender_eye", conditionsFromItem(Items.ENDER_EYE))
                .offerTo(exporter, getItemPath(pResultItem) + "_smithing");
    }
}
