package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

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
    }

    // Recipes
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
}
