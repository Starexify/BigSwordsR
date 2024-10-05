package net.nova.big_swords.data.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.nova.big_swords.init.BSItems;

import java.util.function.Consumer;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSRecipeProvider extends RecipeProvider {
    public final PackOutput output;
    public static String path = MODID + ":";

    public BSRecipeProvider(PackOutput output) {
        super(output);
        this.output = output;
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeOutput) {
        new CraftingRecipes(output, recipeOutput).build();
        new FurnaceRecipes(output, recipeOutput).build();
        new BSSmithingRecipes(output, recipeOutput).build();
    }

    // Recipes
    protected static void basicGildedShield(Consumer<FinishedRecipe> recipeOutput, RegistryObject<Item> shield, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', shield.get())
                .define('X', Items.GOLD_INGOT)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(shield.get()), has(shield.get()))
                .save(recipeOutput);
    }

    protected static void basicShield(Consumer<FinishedRecipe> recipeOutput, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', Items.LEATHER)
                .define('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicShield(Consumer<FinishedRecipe> recipeOutput, TagKey<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', Items.LEATHER)
                .define('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.LEATHER), has(Items.LEATHER))
                .save(recipeOutput);
    }

    protected static void nineBlockStorageRecipesRecipesWithCustomUnpacking(Consumer<FinishedRecipe> pRecipeOutput, RecipeCategory pUnpackedCategory, RegistryObject<Item> pUnpacked, RecipeCategory pPackedCategory, RegistryObject<Block> pPacked, String pUnpackedName, String pUnpackedGroup) {
        nineBlockStorageRecipes(pRecipeOutput, pUnpackedCategory, pUnpacked.get(), pPackedCategory, pPacked.get(), path + getSimpleRecipeName(pPacked.get()), null, path + pUnpackedName, pUnpackedGroup);
    }

    protected static void basicGiantStick(Consumer<FinishedRecipe> recipeOutput, Item stick, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .define('#', stick)
                .pattern(" ##")
                .pattern("###")
                .pattern("## ")
                .unlockedBy("has_" + getItemName(stick), has(stick))
                .save(recipeOutput);
    }

    protected static void basicBigSwordTwoMat(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, Item material2, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .define('Y', material2)
                .pattern(" XX")
                .pattern("YXX")
                .pattern("#Y ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicScythe(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicScythe(Consumer<FinishedRecipe> recipeOutput, Item handle, TagKey<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(recipeOutput);
    }

    protected static void basicGlaive(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicGlaive(Consumer<FinishedRecipe> recipeOutput, Item handle, TagKey<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(recipeOutput);
    }

    protected static void basicBigSword(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicBigSword(Consumer<FinishedRecipe> recipeOutput, Item handle, TagKey<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(recipeOutput);
    }

    protected static void basicHelmet(Consumer<FinishedRecipe> recipeOutput, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicChestplate(Consumer<FinishedRecipe> recipeOutput, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', material)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicLeggings(Consumer<FinishedRecipe> recipeOutput, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicBoots(Consumer<FinishedRecipe> recipeOutput, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicSword(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicPickaxe(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicAxe(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("XX")
                .pattern("#X")
                .pattern("# ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicShovel(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void basicHoe(Consumer<FinishedRecipe> recipeOutput, Item handle, Item material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get())
                .define('#', handle)
                .define('X', material)
                .pattern("XX")
                .pattern("# ")
                .pattern("# ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    protected static void enderSmithing(Consumer<FinishedRecipe> pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(pIngredientItem), Ingredient.of(Items.ENDER_EYE), pCategory, pResultItem
                )
                .unlocks("has_ender_eye", has(Items.ENDER_EYE))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    protected static void netheriteSmithing(Consumer<FinishedRecipe> pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_INGOT), pCategory, pResultItem
                )
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    protected static void netheriteBlockSmithing(Consumer<FinishedRecipe> pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_BLOCK), pCategory, pResultItem
                )
                .unlocks("has_netherite_block", has(Items.NETHERITE_BLOCK))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    protected static void copySmithingTemplate(Consumer<FinishedRecipe> pRecipeOutput, ItemLike pTemplate, ItemLike pBaseItem, ItemLike pCopyItem) {
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
