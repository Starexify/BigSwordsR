package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.nova.big_swords.init.BSItems;

import java.util.concurrent.CompletableFuture;

public class CraftingRecipes extends BSRecipeProvider {
    public final RecipeOutput recipeOutput;

    public CraftingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput recipeOutput) {
        super(output, lookupProvider);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        // Sticks
        basicGiantStick(recipeOutput, Items.STICK, BSItems.GIANT_WOODEN_STICK);

        // Big Swords
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.asItem(), ItemTags.PLANKS, BSItems.WOODEN_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.asItem(), ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.asItem(), Items.IRON_INGOT, BSItems.IRON_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.asItem(), Items.GOLD_INGOT, BSItems.GOLDEN_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.asItem(), Items.DIAMOND, BSItems.DIAMOND_BIG_SWORD);
        basicBigSword(recipeOutput, Items.BONE, Items.ROTTEN_FLESH, BSItems.PATCHWORK_BIG_SWORD);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.SKULL_BIG_SWORD)
                .define('#', BSItems.GIANT_WOODEN_STICK)
                .define('B', Items.BONE)
                .define('X', Items.BONE_BLOCK)
                .define('S', Items.SKELETON_SKULL)
                .pattern(" BB")
                .pattern("XSB")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(Items.SKELETON_SKULL), has(Items.SKELETON_SKULL))
                .save(recipeOutput);
    }
}
