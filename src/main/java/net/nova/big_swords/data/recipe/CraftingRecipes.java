package net.nova.big_swords.data.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

import java.util.function.Consumer;

public class CraftingRecipes extends BSRecipeProvider {
    public final Consumer<FinishedRecipe> recipeOutput;

    public CraftingRecipes(PackOutput output, Consumer<FinishedRecipe> recipeOutput) {
        super(output);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        // Extra Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BSItems.CREEP_BALL.get())
                .group(getItemName(BSItems.CREEP_BALL.get()))
                .define('#', Items.SLIME_BALL)
                .define('O', Items.ROTTEN_FLESH)
                .define('X', Items.SPIDER_EYE)
                .pattern("XOX")
                .pattern("O#O")
                .pattern("XOX")
                .unlockedBy("has_" + getItemName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BSItems.CREEP_BALL.get())
                .group(getItemName(BSItems.CREEP_BALL.get()))
                .define('#', Items.SLIME_BALL)
                .define('O', Items.ROTTEN_FLESH)
                .define('X', Items.SPIDER_EYE)
                .pattern("OXO")
                .pattern("X#X")
                .pattern("OXO")
                .unlockedBy("has_" + getItemName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                .save(recipeOutput, path + getItemName(BSItems.CREEP_BALL.get()) + "_2");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BSItems.BIOMASS_SEED.get())
                .requires(Items.FERMENTED_SPIDER_EYE)
                .requires(Items.NETHER_WART)
                .unlockedBy("has_" + getItemName(Items.FERMENTED_SPIDER_EYE), has(Items.FERMENTED_SPIDER_EYE))
                .save(recipeOutput);

        // Sticks
        basicGiantStick(recipeOutput, Items.STICK, BSItems.GIANT_WOODEN_STICK);
        basicGiantStick(recipeOutput, Items.BLAZE_ROD, BSItems.GIANT_BLAZE_ROD);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BSItems.GIANT_LIVINGMETAL_HANDLE.get())
                .define('#', Items.STICK)
                .define('L', BSItems.LIVINGMETAL_INGOT.get())
                .pattern(" L#")
                .pattern("L#L")
                .pattern("#L ")
                .unlockedBy("has_" + getItemName(BSItems.LIVINGMETAL_INGOT.get()), has(BSItems.LIVINGMETAL_INGOT.get()))
                .save(recipeOutput);

        // Livingmetal Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT.get())
                .define('I', Items.IRON_INGOT)
                .define('S', BSItems.SOUL.get())
                .pattern(" S ")
                .pattern("SIS")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(BSItems.SOUL.get()), has(BSItems.SOUL.get()))
                .save(recipeOutput);
        nineBlockStorageRecipesRecipesWithCustomUnpacking(recipeOutput, RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT, RecipeCategory.BUILDING_BLOCKS, BSBlocks.LIVINGMETAL_BLOCK, getItemName(BSItems.LIVINGMETAL_INGOT.get()) + "_from_" + getItemName(BSBlocks.LIVINGMETAL_BLOCK.get()), getItemName(BSItems.LIVINGMETAL_INGOT.get()));
        basicHelmet(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HELMET);
        basicChestplate(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_CHESTPLATE);
        basicLeggings(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_LEGGINGS);
        basicBoots(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BOOTS);
        basicSword(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SWORD);
        basicPickaxe(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_PICKAXE);
        basicAxe(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_AXE);
        basicShovel(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SHOVEL);
        basicHoe(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HOE);

        // Biomass Recipes
        nineBlockStorageRecipesRecipesWithCustomUnpacking(recipeOutput, RecipeCategory.MISC, BSItems.BIOMASS, RecipeCategory.BUILDING_BLOCKS, BSBlocks.BIOMASS_BLOCK, getItemName(BSItems.BIOMASS.get()) + "_from_" + getItemName(BSBlocks.BIOMASS_BLOCK.get()), getItemName(BSItems.BIOMASS.get()));
        basicHelmet(recipeOutput, BSItems.BIOMASS.get(), BSItems.BIOMASS_HELMET);
        basicChestplate(recipeOutput, BSItems.BIOMASS.get(), BSItems.BIOMASS_CHESTPLATE);
        basicLeggings(recipeOutput, BSItems.BIOMASS.get(), BSItems.BIOMASS_LEGGINGS);
        basicBoots(recipeOutput, BSItems.BIOMASS.get(), BSItems.BIOMASS_BOOTS);
        basicSword(recipeOutput, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_SWORD);
        basicPickaxe(recipeOutput, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_PICKAXE);
        basicAxe(recipeOutput, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_AXE);
        basicShovel(recipeOutput, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_SHOVEL);
        basicHoe(recipeOutput, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_HOE);

        // Ender Upgrade
        copySmithingTemplate(recipeOutput, BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get(), Items.ENDER_EYE, Items.OBSIDIAN);


        // Big Swords
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), ItemTags.PLANKS, BSItems.WOODEN_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), Items.IRON_INGOT, BSItems.IRON_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), Items.GOLD_INGOT, BSItems.GOLDEN_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), Items.DIAMOND, BSItems.DIAMOND_BIG_SWORD);
        basicBigSword(recipeOutput, Items.BONE, Items.ROTTEN_FLESH, BSItems.PATCHWORK_BIG_SWORD);
        basicBigSword(recipeOutput, BSItems.GIANT_LIVINGMETAL_HANDLE.get(), BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BIG_SWORD);
        basicBigSwordTwoMat(recipeOutput, BSItems.GIANT_BLAZE_ROD.get(), Items.QUARTZ, Items.QUARTZ_BLOCK, BSItems.QUARTZ_BIG_SWORD);
        basicBigSwordTwoMat(recipeOutput, BSItems.GIANT_WOODEN_STICK.get(), BSItems.BIOMASS.get(), Items.NETHER_BRICK, BSItems.BIOMASS_BIG_SWORD);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.SKULL_BIG_SWORD.get())
                .define('#', BSItems.GIANT_WOODEN_STICK.get())
                .define('B', Items.BONE)
                .define('X', Items.BONE_BLOCK)
                .define('S', Items.SKELETON_SKULL)
                .pattern(" BB")
                .pattern("XSB")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(Items.SKELETON_SKULL), has(Items.SKELETON_SKULL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.OBSIDIAN_BIG_SWORD.get())
                .define('#', BSItems.GIANT_BLAZE_ROD.get())
                .define('Q', Items.OBSIDIAN)
                .define('D', BSItems.DIAMOND_BIG_SWORD.get())
                .pattern(" QQ")
                .pattern("QDQ")
                .pattern("#Q ")
                .unlockedBy("has_" + getItemName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(recipeOutput);

        // Glaives
        basicGlaive(recipeOutput, Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_GLAIVE);
        basicGlaive(recipeOutput, Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_GLAIVE);
        basicGlaive(recipeOutput, Items.STICK, Items.IRON_INGOT, BSItems.IRON_GLAIVE);
        basicGlaive(recipeOutput, Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_GLAIVE);
        basicGlaive(recipeOutput, Items.STICK, Items.DIAMOND, BSItems.DIAMOND_GLAIVE);
        basicGlaive(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_GLAIVE);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.BIOMASS_GLAIVE.get())
                .define('#', Items.STICK)
                .define('X', BSItems.BIOMASS.get())
                .define('Y', Items.NETHER_BRICK)
                .pattern("XX ")
                .pattern("X#Y")
                .pattern(" Y#")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS.get()), has(BSItems.BIOMASS.get()))
                .save(recipeOutput);

        // Scythes
        basicScythe(recipeOutput, Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_SCYTHE);
        basicScythe(recipeOutput, Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SCYTHE);
        basicScythe(recipeOutput, Items.STICK, Items.IRON_INGOT, BSItems.IRON_SCYTHE);
        basicScythe(recipeOutput, Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_SCYTHE);
        basicScythe(recipeOutput, Items.STICK, Items.DIAMOND, BSItems.DIAMOND_SCYTHE);
        basicScythe(recipeOutput, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SCYTHE);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.BIOMASS_SCYTHE.get())
                .define('#', Items.STICK)
                .define('X', BSItems.BIOMASS.get())
                .define('Y', Items.NETHER_BRICK)
                .pattern("XX#")
                .pattern(" #Y")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS.get()), has(BSItems.BIOMASS.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.BONE_SCYTHE.get())
                .define('#', Items.BONE)
                .define('Y', Items.BONE_BLOCK)
                .pattern("###")
                .pattern(" #Y")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS.get()), has(BSItems.BIOMASS.get()))
                .save(recipeOutput);

        // Shields
        basicShield(recipeOutput, ItemTags.PLANKS, BSItems.WOODEN_SHIELD);
        basicShield(recipeOutput, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SHIELD);
        basicShield(recipeOutput, Items.IRON_INGOT, BSItems.IRON_SHIELD);
        basicShield(recipeOutput, Items.DIAMOND, BSItems.DIAMOND_SHIELD);
        basicShield(recipeOutput, Items.QUARTZ, BSItems.QUARTZ_SHIELD);
        basicShield(recipeOutput, BSItems.BIOMASS.get(), BSItems.BIOMASS_SHIELD);
        basicShield(recipeOutput, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SHIELD);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.PATCHWORK_SHIELD.get())
                .define('X', Items.ROTTEN_FLESH)
                .pattern("XXX")
                .pattern("XXX")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.SKULL_SHIELD.get())
                .define('X', Items.BONE)
                .define('S', Items.SKELETON_SKULL)
                .define('#', Items.LEATHER)
                .pattern("XSX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.BONE), has(Items.BONE))
                .save(recipeOutput);

        // Gilded Shields
        basicGildedShield(recipeOutput, BSItems.WOODEN_SHIELD, BSItems.GILDED_WOODEN_SHIELD);
        basicGildedShield(recipeOutput, BSItems.STONE_SHIELD, BSItems.GILDED_STONE_SHIELD);
        basicGildedShield(recipeOutput, BSItems.IRON_SHIELD, BSItems.GILDED_IRON_SHIELD);
        basicGildedShield(recipeOutput, BSItems.DIAMOND_SHIELD, BSItems.GILDED_DIAMOND_SHIELD);
        basicGildedShield(recipeOutput, BSItems.NETHERITE_SHIELD, BSItems.GILDED_NETHERITE_SHIELD);
        basicGildedShield(recipeOutput, BSItems.ENDER_SHIELD, BSItems.GILDED_ENDER_SHIELD);
        basicGildedShield(recipeOutput, BSItems.QUARTZ_SHIELD, BSItems.GILDED_QUARTZ_SHIELD);
        basicGildedShield(recipeOutput, BSItems.PATCHWORK_SHIELD, BSItems.GILDED_PATCHWORK_SHIELD);
        basicGildedShield(recipeOutput, BSItems.BIOMASS_SHIELD, BSItems.GILDED_BIOMASS_SHIELD);
        basicGildedShield(recipeOutput, BSItems.LIVINGMETAL_SHIELD, BSItems.GILDED_LIVINGMETAL_SHIELD);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BSItems.GILDED_SKULL_SHIELD.get())
                .define('#', BSItems.SKULL_SHIELD.get())
                .define('X', Items.GOLD_INGOT)
                .define('S', Items.WITHER_SKELETON_SKULL)
                .pattern("XSX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(BSItems.SKULL_SHIELD.get()), has(BSItems.SKULL_SHIELD.get()))
                .save(recipeOutput);
    }
}
