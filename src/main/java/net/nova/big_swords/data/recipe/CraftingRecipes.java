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
    public CraftingRecipes(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput) {
        super(lookupProvider, recipeOutput);
    }

    public void build() {
        // Extra Recipes
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, BSItems.CREEP_BALL)
                .group(getItemName(BSItems.CREEP_BALL))
                .define('#', Items.SLIME_BALL)
                .define('O', Items.ROTTEN_FLESH)
                .define('X', Items.SPIDER_EYE)
                .pattern("XOX")
                .pattern("O#O")
                .pattern("XOX")
                .unlockedBy("has_" + getItemName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, BSItems.CREEP_BALL)
                .group(getItemName(BSItems.CREEP_BALL))
                .define('#', Items.SLIME_BALL)
                .define('O', Items.ROTTEN_FLESH)
                .define('X', Items.SPIDER_EYE)
                .pattern("OXO")
                .pattern("X#X")
                .pattern("OXO")
                .unlockedBy("has_" + getItemName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                .save(output, path + getItemName(BSItems.CREEP_BALL) + "_2");

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, BSItems.BIOMASS_SEED)
                .requires(Items.FERMENTED_SPIDER_EYE)
                .requires(Items.NETHER_WART)
                .unlockedBy("has_" + getItemName(Items.FERMENTED_SPIDER_EYE), has(Items.FERMENTED_SPIDER_EYE))
                .save(output);


        // Sticks
        basicGiantStick(output, Items.STICK, BSItems.GIANT_WOODEN_STICK);
        basicGiantStick(output, Items.BLAZE_ROD, BSItems.GIANT_BLAZE_ROD);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, BSItems.GIANT_LIVINGMETAL_HANDLE)
                .define('#', Items.STICK)
                .define('L', BSItems.LIVINGMETAL_INGOT)
                .pattern(" L#")
                .pattern("L#L")
                .pattern("#L ")
                .unlockedBy("has_" + getItemName(BSItems.LIVINGMETAL_INGOT), has(BSItems.LIVINGMETAL_INGOT))
                .save(output);

        // Livingmetal Recipes
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT)
                .define('I', Items.IRON_INGOT)
                .define('S', BSItems.SOUL)
                .pattern(" S ")
                .pattern("SIS")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(BSItems.SOUL), has(BSItems.SOUL))
                .save(output);
        nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT, RecipeCategory.BUILDING_BLOCKS, BSBlocks.LIVINGMETAL_BLOCK, getItemName(BSItems.LIVINGMETAL_INGOT) + "_from_" + getItemName(BSBlocks.LIVINGMETAL_BLOCK), getItemName(BSItems.LIVINGMETAL_INGOT));
        basicHelmet(output, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HELMET);
        basicChestplate(output, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_CHESTPLATE);
        basicLeggings(output, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_LEGGINGS);
        basicBoots(output, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BOOTS);
        basicSword(output, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SWORD);
        basicPickaxe(output, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_PICKAXE);
        basicAxe(output, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_AXE);
        basicShovel(output, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SHOVEL);
        basicHoe(output, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HOE);

        // Biomass Recipes
        nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, BSItems.BIOMASS, RecipeCategory.BUILDING_BLOCKS, BSBlocks.BIOMASS_BLOCK, getItemName(BSItems.BIOMASS) + "_from_" + getItemName(BSBlocks.BIOMASS_BLOCK), getItemName(BSItems.BIOMASS));
        basicHelmet(output, BSItems.BIOMASS.get(), BSItems.BIOMASS_HELMET);
        basicChestplate(output, BSItems.BIOMASS.get(), BSItems.BIOMASS_CHESTPLATE);
        basicLeggings(output, BSItems.BIOMASS.get(), BSItems.BIOMASS_LEGGINGS);
        basicBoots(output, BSItems.BIOMASS.get(), BSItems.BIOMASS_BOOTS);
        basicSword(output, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_SWORD);
        basicPickaxe(output, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_PICKAXE);
        basicAxe(output, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_AXE);
        basicShovel(output, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_SHOVEL);
        basicHoe(output, Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_HOE);

        // Ender Upgrade
        copySmithingTemplate(output, BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, Items.ENDER_EYE, Items.OBSIDIAN);


        // Big Swords
        basicBigSword(output, BSItems.GIANT_WOODEN_STICK.get(), ItemTags.PLANKS, BSItems.WOODEN_BIG_SWORD);
        basicBigSword(output, BSItems.GIANT_WOODEN_STICK.get(), ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_BIG_SWORD);
        basicBigSword(output, BSItems.GIANT_WOODEN_STICK.get(), Items.IRON_INGOT, BSItems.IRON_BIG_SWORD);
        basicBigSword(output, BSItems.GIANT_WOODEN_STICK.get(), Items.GOLD_INGOT, BSItems.GOLDEN_BIG_SWORD);
        basicBigSword(output, BSItems.GIANT_WOODEN_STICK.get(), Items.DIAMOND, BSItems.DIAMOND_BIG_SWORD);
        basicBigSword(output, Items.BONE, Items.ROTTEN_FLESH, BSItems.PATCHWORK_BIG_SWORD);
        basicBigSword(output, BSItems.GIANT_LIVINGMETAL_HANDLE.get(), BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BIG_SWORD);
        basicBigSwordTwoMat(output, BSItems.GIANT_BLAZE_ROD.get(), Items.QUARTZ, Items.QUARTZ_BLOCK, BSItems.QUARTZ_BIG_SWORD);
        basicBigSwordTwoMat(output, BSItems.GIANT_WOODEN_STICK.get(), BSItems.BIOMASS.get(), Items.NETHER_BRICK, BSItems.BIOMASS_BIG_SWORD);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.SKULL_BIG_SWORD)
                .define('#', BSItems.GIANT_WOODEN_STICK)
                .define('B', Items.BONE)
                .define('X', Items.BONE_BLOCK)
                .define('S', Items.SKELETON_SKULL)
                .pattern(" BB")
                .pattern("XSB")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(Items.SKELETON_SKULL), has(Items.SKELETON_SKULL))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.OBSIDIAN_BIG_SWORD)
                .define('#', BSItems.GIANT_BLAZE_ROD)
                .define('Q', Items.OBSIDIAN)
                .define('D', BSItems.DIAMOND_BIG_SWORD)
                .pattern(" QQ")
                .pattern("QDQ")
                .pattern("#Q ")
                .unlockedBy("has_" + getItemName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(output);

        // Glaives
        basicGlaive(output, Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_GLAIVE);
        basicGlaive(output, Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_GLAIVE);
        basicGlaive(output, Items.STICK, Items.IRON_INGOT, BSItems.IRON_GLAIVE);
        basicGlaive(output, Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_GLAIVE);
        basicGlaive(output, Items.STICK, Items.DIAMOND, BSItems.DIAMOND_GLAIVE);
        basicGlaive(output, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_GLAIVE);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.BIOMASS_GLAIVE)
                .define('#', Items.STICK)
                .define('X', BSItems.BIOMASS)
                .define('Y', Items.NETHER_BRICK)
                .pattern("XX ")
                .pattern("X#Y")
                .pattern(" Y#")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS), has(BSItems.BIOMASS))
                .save(output);

        // Scythes
        basicScythe(output, Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_SCYTHE);
        basicScythe(output, Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SCYTHE);
        basicScythe(output, Items.STICK, Items.IRON_INGOT, BSItems.IRON_SCYTHE);
        basicScythe(output, Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_SCYTHE);
        basicScythe(output, Items.STICK, Items.DIAMOND, BSItems.DIAMOND_SCYTHE);
        basicScythe(output, Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SCYTHE);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.BIOMASS_SCYTHE)
                .define('#', Items.STICK)
                .define('X', BSItems.BIOMASS)
                .define('Y', Items.NETHER_BRICK)
                .pattern("XX#")
                .pattern(" #Y")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS), has(BSItems.BIOMASS))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.BONE_SCYTHE)
                .define('#', Items.BONE)
                .define('Y', Items.BONE_BLOCK)
                .pattern("###")
                .pattern(" #Y")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS), has(BSItems.BIOMASS))
                .save(output);

        // Shields
        basicShield(output, ItemTags.PLANKS, BSItems.WOODEN_SHIELD);
        basicShield(output, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SHIELD);
        basicShield(output, Items.IRON_INGOT, BSItems.IRON_SHIELD);
        basicShield(output, Items.DIAMOND, BSItems.DIAMOND_SHIELD);
        basicShield(output, Items.QUARTZ, BSItems.QUARTZ_SHIELD);
        basicShield(output, BSItems.BIOMASS.get(), BSItems.BIOMASS_SHIELD);
        basicShield(output, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SHIELD);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.PATCHWORK_SHIELD)
                .define('X', Items.ROTTEN_FLESH)
                .pattern("XXX")
                .pattern("XXX")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.SKULL_SHIELD)
                .define('X', Items.BONE)
                .define('S', Items.SKELETON_SKULL)
                .define('#', Items.LEATHER)
                .pattern("XSX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.BONE), has(Items.BONE))
                .save(output);

        // Gilded Shields
        basicGildedShield(output, BSItems.WOODEN_SHIELD, BSItems.GILDED_WOODEN_SHIELD);
        basicGildedShield(output, BSItems.STONE_SHIELD, BSItems.GILDED_STONE_SHIELD);
        basicGildedShield(output, BSItems.IRON_SHIELD, BSItems.GILDED_IRON_SHIELD);
        basicGildedShield(output, BSItems.DIAMOND_SHIELD, BSItems.GILDED_DIAMOND_SHIELD);
        basicGildedShield(output, BSItems.NETHERITE_SHIELD, BSItems.GILDED_NETHERITE_SHIELD);
        basicGildedShield(output, BSItems.ENDER_SHIELD, BSItems.GILDED_ENDER_SHIELD);
        basicGildedShield(output, BSItems.QUARTZ_SHIELD, BSItems.GILDED_QUARTZ_SHIELD);
        basicGildedShield(output, BSItems.PATCHWORK_SHIELD, BSItems.GILDED_PATCHWORK_SHIELD);
        basicGildedShield(output, BSItems.BIOMASS_SHIELD, BSItems.GILDED_BIOMASS_SHIELD);
        basicGildedShield(output, BSItems.LIVINGMETAL_SHIELD, BSItems.GILDED_LIVINGMETAL_SHIELD);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BSItems.GILDED_SKULL_SHIELD)
                .define('#', BSItems.SKULL_SHIELD)
                .define('X', Items.GOLD_INGOT)
                .define('S', Items.WITHER_SKELETON_SKULL)
                .pattern("XSX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(BSItems.SKULL_SHIELD), has(BSItems.SKULL_SHIELD))
                .save(output);
    }
}
