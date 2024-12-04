package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

public class CraftingRecipes extends BSRecipeProvider {
    public CraftingRecipes(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput) {
        super(lookupProvider, recipeOutput);
    }

    public void build() {
        // Extra Recipes
        shaped(RecipeCategory.MISC, BSItems.BLOOD_VIAL)
                .define('X', Blocks.GLASS)
                .pattern("XXX")
                .pattern("X X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Blocks.GLASS), has(Blocks.GLASS))
                .save(output, path + getItemName(BSItems.BLOOD_VIAL) + "_recipe");

        // Sticks
        basicGiantStick(Items.STICK, BSItems.GIANT_WOODEN_STICK);
        basicGiantStick(Items.BLAZE_ROD, BSItems.GIANT_BLAZE_ROD);
        shaped(RecipeCategory.MISC, BSItems.GIANT_LIVINGMETAL_HANDLE)
                .define('#', Items.STICK)
                .define('L', BSItems.LIVINGMETAL_INGOT)
                .pattern(" L#")
                .pattern("L#L")
                .pattern("#L ")
                .unlockedBy("has_" + getItemName(BSItems.LIVINGMETAL_INGOT), has(BSItems.LIVINGMETAL_INGOT))
                .save(output);

        // Livingmetal Recipes
        shaped(RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT)
                .define('I', Items.IRON_INGOT)
                .define('S', BSItems.SOUL)
                .pattern(" S ")
                .pattern("SIS")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(BSItems.SOUL), has(BSItems.SOUL))
                .save(output);
        nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT, RecipeCategory.BUILDING_BLOCKS, BSBlocks.LIVINGMETAL_BLOCK, getItemName(BSItems.LIVINGMETAL_INGOT) + "_from_" + getItemName(BSBlocks.LIVINGMETAL_BLOCK), getItemName(BSItems.LIVINGMETAL_INGOT));
        basicHelmet(BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HELMET);
        basicChestplate(BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_CHESTPLATE);
        basicLeggings(BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_LEGGINGS);
        basicBoots(BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BOOTS);
        basicSword(Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SWORD);
        basicPickaxe(Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_PICKAXE);
        basicAxe(Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_AXE);
        basicShovel(Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SHOVEL);
        basicHoe(Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_HOE);

        // Biomass Recipes
        nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, BSItems.BIOMASS, RecipeCategory.BUILDING_BLOCKS, BSBlocks.BIOMASS_BLOCK, getItemName(BSItems.BIOMASS) + "_from_" + getItemName(BSBlocks.BIOMASS_BLOCK), getItemName(BSItems.BIOMASS));
        basicHelmet(BSItems.BIOMASS.get(), BSItems.BIOMASS_HELMET);
        basicChestplate(BSItems.BIOMASS.get(), BSItems.BIOMASS_CHESTPLATE);
        basicLeggings(BSItems.BIOMASS.get(), BSItems.BIOMASS_LEGGINGS);
        basicBoots(BSItems.BIOMASS.get(), BSItems.BIOMASS_BOOTS);
        basicSword(Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_SWORD);
        basicPickaxe(Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_PICKAXE);
        basicAxe(Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_AXE);
        basicShovel(Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_SHOVEL);
        basicHoe(Items.STICK, BSItems.BIOMASS.get(), BSItems.BIOMASS_HOE);

        // Ender Upgrade
        copySmithingTemplate(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, Items.ENDER_EYE, Items.OBSIDIAN);


        // Big Swords
        basicBigSword(BSItems.GIANT_WOODEN_STICK.get(), ItemTags.PLANKS, BSItems.WOODEN_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK.get(), ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK.get(), Items.IRON_INGOT, BSItems.IRON_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK.get(), Items.GOLD_INGOT, BSItems.GOLDEN_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK.get(), Items.DIAMOND, BSItems.DIAMOND_BIG_SWORD);
        basicBigSword(Items.BONE, Items.ROTTEN_FLESH, BSItems.PATCHWORK_BIG_SWORD);
        basicBigSword(BSItems.GIANT_LIVINGMETAL_HANDLE.get(), BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_BIG_SWORD);
        basicBigSwordTwoMat(BSItems.GIANT_BLAZE_ROD.get(), Items.QUARTZ, Items.QUARTZ_BLOCK, BSItems.QUARTZ_BIG_SWORD);
        basicBigSwordTwoMat(BSItems.GIANT_WOODEN_STICK.get(), BSItems.BIOMASS.get(), Items.NETHER_BRICK, BSItems.BIOMASS_BIG_SWORD);

        shaped(RecipeCategory.COMBAT, BSItems.SKULL_BIG_SWORD)
                .define('#', BSItems.GIANT_WOODEN_STICK)
                .define('B', Items.BONE)
                .define('X', Items.BONE_BLOCK)
                .define('S', Items.SKELETON_SKULL)
                .pattern(" BB")
                .pattern("XSB")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(Items.SKELETON_SKULL), has(Items.SKELETON_SKULL))
                .save(output);

        shaped(RecipeCategory.COMBAT, BSItems.OBSIDIAN_BIG_SWORD)
                .define('#', BSItems.GIANT_BLAZE_ROD)
                .define('Q', Items.OBSIDIAN)
                .define('D', BSItems.DIAMOND_BIG_SWORD)
                .pattern(" QQ")
                .pattern("QDQ")
                .pattern("#Q ")
                .unlockedBy("has_" + getItemName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(output);

        // Glaives
        basicGlaive(Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_GLAIVE);
        basicGlaive(Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_GLAIVE);
        basicGlaive(Items.STICK, Items.IRON_INGOT, BSItems.IRON_GLAIVE);
        basicGlaive(Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_GLAIVE);
        basicGlaive(Items.STICK, Items.DIAMOND, BSItems.DIAMOND_GLAIVE);
        basicGlaive(Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_GLAIVE);

        shaped(RecipeCategory.COMBAT, BSItems.BIOMASS_GLAIVE)
                .define('#', Items.STICK)
                .define('X', BSItems.BIOMASS)
                .define('Y', Items.NETHER_BRICK)
                .pattern("XX ")
                .pattern("X#Y")
                .pattern(" Y#")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS), has(BSItems.BIOMASS))
                .save(output);

        // Scythes
        basicScythe(Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_SCYTHE);
        basicScythe(Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SCYTHE);
        basicScythe(Items.STICK, Items.IRON_INGOT, BSItems.IRON_SCYTHE);
        basicScythe(Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_SCYTHE);
        basicScythe(Items.STICK, Items.DIAMOND, BSItems.DIAMOND_SCYTHE);
        basicScythe(Items.STICK, BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SCYTHE);

        shaped(RecipeCategory.COMBAT, BSItems.BIOMASS_SCYTHE)
                .define('#', Items.STICK)
                .define('X', BSItems.BIOMASS)
                .define('Y', Items.NETHER_BRICK)
                .pattern("XX#")
                .pattern(" #Y")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS), has(BSItems.BIOMASS))
                .save(output);

        shaped(RecipeCategory.COMBAT, BSItems.BONE_SCYTHE)
                .define('#', Items.BONE)
                .define('Y', Items.BONE_BLOCK)
                .pattern("###")
                .pattern(" #Y")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(BSItems.BIOMASS), has(BSItems.BIOMASS))
                .save(output);

        // Shields
        basicShield(ItemTags.PLANKS, BSItems.WOODEN_SHIELD);
        basicShield(ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SHIELD);
        basicShield(Items.IRON_INGOT, BSItems.IRON_SHIELD);
        basicShield(Items.DIAMOND, BSItems.DIAMOND_SHIELD);
        basicShield(Items.QUARTZ, BSItems.QUARTZ_SHIELD);
        basicShield(BSItems.BIOMASS.get(), BSItems.BIOMASS_SHIELD);
        basicShield(BSItems.LIVINGMETAL_INGOT.get(), BSItems.LIVINGMETAL_SHIELD);

        shaped(RecipeCategory.COMBAT, BSItems.PATCHWORK_SHIELD)
                .define('X', Items.ROTTEN_FLESH)
                .pattern("XXX")
                .pattern("XXX")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
                .save(output);

        shaped(RecipeCategory.COMBAT, BSItems.SKULL_SHIELD)
                .define('X', Items.BONE)
                .define('S', Items.SKELETON_SKULL)
                .define('#', Items.LEATHER)
                .pattern("XSX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.BONE), has(Items.BONE))
                .save(output);

        // Gilded Shields
        basicGildedShield(BSItems.WOODEN_SHIELD, BSItems.GILDED_WOODEN_SHIELD);
        basicGildedShield(BSItems.STONE_SHIELD, BSItems.GILDED_STONE_SHIELD);
        basicGildedShield(BSItems.IRON_SHIELD, BSItems.GILDED_IRON_SHIELD);
        basicGildedShield(BSItems.DIAMOND_SHIELD, BSItems.GILDED_DIAMOND_SHIELD);
        basicGildedShield(BSItems.NETHERITE_SHIELD, BSItems.GILDED_NETHERITE_SHIELD);
        basicGildedShield(BSItems.ENDER_SHIELD, BSItems.GILDED_ENDER_SHIELD);
        basicGildedShield(BSItems.QUARTZ_SHIELD, BSItems.GILDED_QUARTZ_SHIELD);
        basicGildedShield(BSItems.PATCHWORK_SHIELD, BSItems.GILDED_PATCHWORK_SHIELD);
        basicGildedShield(BSItems.BIOMASS_SHIELD, BSItems.GILDED_BIOMASS_SHIELD);
        basicGildedShield(BSItems.LIVINGMETAL_SHIELD, BSItems.GILDED_LIVINGMETAL_SHIELD);

        shaped(RecipeCategory.COMBAT, BSItems.GILDED_SKULL_SHIELD)
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
