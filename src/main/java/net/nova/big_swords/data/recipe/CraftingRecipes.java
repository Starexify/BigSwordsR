package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.nova.big_swords.init.BSBlocks;
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
        basicGiantStick(recipeOutput, Items.BLAZE_ROD, BSItems.GIANT_BLAZE_ROD);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BSItems.GIANT_LIVINGMETAL_HANDLE)
                .define('#', Items.STICK)
                .define('L', BSItems.LIVINGMETAL_INGOT)
                .pattern(" L#")
                .pattern("L#L")
                .pattern("#L ")
                .unlockedBy("has_" + getItemName(BSItems.LIVINGMETAL_INGOT), has(BSItems.LIVINGMETAL_INGOT))
                .save(recipeOutput);

        // Livingmetal Recipes
        nineBlockStorageRecipesRecipesWithCustomUnpacking(recipeOutput, RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT, RecipeCategory.BUILDING_BLOCKS, BSBlocks.LIVINGMETAL_BLOCK, getItemName(BSItems.LIVINGMETAL_INGOT) + "_from_" + getItemName(BSBlocks.LIVINGMETAL_BLOCK), getItemName(BSItems.LIVINGMETAL_INGOT));
        basicHelmet(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HELMET);
        basicChestplate(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_CHESTPLATE);
        basicLeggings(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_LEGGINGS);
        basicBoots(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BOOTS);
        basicSword(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SWORD);
        basicPickaxe(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_PICKAXE);
        basicAxe(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_AXE);
        basicShovel(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SHOVEL);
        basicHoe(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HOE);

        // Ender Upgrade
        copySmithingTemplate(recipeOutput, BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, Items.ENDER_EYE, Items.OBSIDIAN);

        // Livingmetal Recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT)
                .requires(Items.SOUL_SAND)
                .requires(Items.IRON_INGOT)
                .requires(Items.GHAST_TEAR)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Big Swords
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), ItemTags.PLANKS, BSItems.WOODEN_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), Items.IRON_INGOT, BSItems.IRON_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), Items.GOLD_INGOT, BSItems.GOLDEN_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), Items.DIAMOND, BSItems.DIAMOND_BIG_SWORD);
        basicBigSword(recipeOutput, Items.BONE, Items.ROTTEN_FLESH, BSItems.PATCHWORK_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_LIVINGMETAL_HANDLE.get(), BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BIG_SWORD);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.QUARTZ_BIG_SWORD)
                .define('#', BSItems.GIANT_BLAZE_ROD)
                .define('Q', Items.QUARTZ)
                .define('X', Items.QUARTZ_BLOCK)
                .pattern(" QQ")
                .pattern("XQQ")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(Items.QUARTZ), has(Items.QUARTZ))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.OBSIDIAN_BIG_SWORD)
                .define('#', BSItems.GIANT_BLAZE_ROD)
                .define('Q', Items.OBSIDIAN)
                .define('D', BSItems.DIAMOND_BIG_SWORD)
                .pattern(" QQ")
                .pattern("QDQ")
                .pattern("#Q ")
                .unlockedBy("has_" + getItemName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(recipeOutput);

    }
}
