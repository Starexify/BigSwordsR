package net.nova.data.recipe;

import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nova.init.BSItems;

public class BSFurnaceRecipes extends RecipeGenerator {
    public final RegistryEntryLookup<Item> itemLookup;

    protected BSFurnaceRecipes(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
        this.itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
    }

    @Override
    public void generate() {
        // Big Swords
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        200
                )
                .criterion(hasItem(BSItems.IRON_BIG_SWORD), conditionsFromItem(BSItems.IRON_BIG_SWORD))
                .offerTo(exporter, getSmeltingItemPath(BSItems.IRON_BIG_SWORD));

        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItem(
                                BSItems.IRON_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.1F,
                        100
                )
                .criterion(hasItem(BSItems.IRON_BIG_SWORD), conditionsFromItem(BSItems.IRON_BIG_SWORD))
                .offerTo(exporter, getBlastingItemPath(BSItems.IRON_BIG_SWORD));

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        200
                )
                .criterion(hasItem(BSItems.GOLDEN_BIG_SWORD), conditionsFromItem(BSItems.GOLDEN_BIG_SWORD))
                .offerTo(exporter, getSmeltingItemPath(BSItems.GOLDEN_BIG_SWORD));

        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItem(
                                BSItems.GOLDEN_BIG_SWORD
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.1F,
                        100
                )
                .criterion(hasItem(BSItems.GOLDEN_BIG_SWORD), conditionsFromItem(BSItems.GOLDEN_BIG_SWORD))
                .offerTo(exporter, getBlastingItemPath(BSItems.GOLDEN_BIG_SWORD));

        // Glaives & Scythes
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(
                                BSItems.IRON_GLAIVE,
                                BSItems.IRON_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET,
                        0.1F,
                        200
                )
                .criterion(hasItem(BSItems.IRON_GLAIVE), conditionsFromItem(BSItems.IRON_GLAIVE))
                .criterion(hasItem(BSItems.IRON_SCYTHE), conditionsFromItem(BSItems.IRON_SCYTHE))
                .offerTo(exporter, getSmeltingItemPath(Items.IRON_NUGGET));

        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(
                                BSItems.IRON_GLAIVE,
                                BSItems.IRON_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET,
                        0.1F,
                        100
                )
                .criterion(hasItem(BSItems.IRON_GLAIVE), conditionsFromItem(BSItems.IRON_GLAIVE))
                .criterion(hasItem(BSItems.IRON_SCYTHE), conditionsFromItem(BSItems.IRON_SCYTHE))
                .offerTo(exporter, getBlastingItemPath(Items.IRON_NUGGET));

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(
                                BSItems.GOLDEN_GLAIVE,
                                BSItems.GOLDEN_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        200
                )
                .criterion(hasItem(BSItems.GOLDEN_GLAIVE), conditionsFromItem(BSItems.GOLDEN_GLAIVE))
                .criterion(hasItem(BSItems.GOLDEN_SCYTHE), conditionsFromItem(BSItems.GOLDEN_SCYTHE))
                .offerTo(exporter, getSmeltingItemPath(Items.GOLD_NUGGET));

        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(
                                BSItems.GOLDEN_GLAIVE,
                                BSItems.GOLDEN_SCYTHE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET,
                        0.1F,
                        100
                )
                .criterion(hasItem(BSItems.GOLDEN_GLAIVE), conditionsFromItem(BSItems.GOLDEN_GLAIVE))
                .criterion(hasItem(BSItems.GOLDEN_SCYTHE), conditionsFromItem(BSItems.GOLDEN_SCYTHE))
                .offerTo(exporter, getBlastingItemPath(Items.GOLD_NUGGET));
    }
}
