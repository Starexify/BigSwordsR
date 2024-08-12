package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;
import net.nova.big_swords.init.BSItems;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSRecipeProvider extends RecipeProvider {
    public final PackOutput output;
    public final CompletableFuture<HolderLookup.Provider> lookupProvider;
    public static String path = MODID + ":";

    public BSRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
        this.output = output;
        this.lookupProvider = lookupProvider;
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        new CraftingRecipes(output, lookupProvider, recipeOutput).build();
        new FurnaceRecipes(output, lookupProvider, recipeOutput).build();
        new BSSmithingRecipes(output, lookupProvider, recipeOutput).build();
    }

    // Recipes
    protected static void nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeOutput pRecipeOutput, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked, String pUnpackedName, String pUnpackedGroup) {
        nineBlockStorageRecipes(pRecipeOutput, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, getSimpleRecipeName(pPacked), null, path + pUnpackedName, pUnpackedGroup);
    }

    protected static void basicGiantStick(RecipeOutput recipeOutput, Item stick, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .define('#', stick)
                .pattern(" ##")
                .pattern("###")
                .pattern("## ")
                .unlockedBy("has_" + getItemName(stick), has(stick))
                .save(recipeOutput);
    }

    protected static void basicBigSword(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicBigSword(RecipeOutput recipeOutput, Item handle, TagKey<Item> material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(recipeOutput);
    }

    protected static void enderSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.ENDER_EYE), pCategory, pResultItem
                )
                .unlocks("has_ender_eye", has(Items.ENDER_EYE))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    protected static void netheriteBlockSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_BLOCK), pCategory, pResultItem
                )
                .unlocks("has_netherite_block", has(Items.NETHERITE_BLOCK))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    protected static void copySmithingTemplate(RecipeOutput pRecipeOutput, ItemLike pTemplate, ItemLike pBaseItem, ItemLike pCopyItem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pTemplate, 2)
                .define('#', pCopyItem)
                .define('C', pBaseItem)
                .define('S', pTemplate)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .unlockedBy(getHasName(pTemplate), has(pTemplate))
                .save(pRecipeOutput);
    }
}
