package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
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
    public final RecipeOutput recipeOutput;
    public final HolderLookup.Provider lookupProvider;
    public static String path = MODID + ":";
    public static HolderGetter<Item> items;

    public BSRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput) {
        super(lookupProvider, recipeOutput);
        this.lookupProvider = lookupProvider;
        this.recipeOutput = recipeOutput;
        items = lookupProvider.lookupOrThrow(Registries.ITEM);
    }

    @Override
    protected void buildRecipes() {
        new CraftingRecipes(lookupProvider, recipeOutput).build();
        new FurnaceRecipes(lookupProvider, recipeOutput).build();
        new BSSmithingRecipes(lookupProvider, recipeOutput).build();
    }

    // Recipes
    public void basicGildedShield(RecipeOutput recipeOutput, DeferredItem<Item> shield, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', shield)
                .define('X', Items.GOLD_INGOT)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(shield), has(shield))
                .save(recipeOutput);
    }

    public void basicShield(RecipeOutput recipeOutput, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', Items.LEATHER)
                .define('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicShield(RecipeOutput recipeOutput, TagKey<Item> material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', Items.LEATHER)
                .define('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.LEATHER), has(Items.LEATHER))
                .save(recipeOutput);
    }

    public void basicGiantStick(RecipeOutput recipeOutput, Item stick, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, result)
                .define('#', stick)
                .pattern(" ##")
                .pattern("###")
                .pattern("## ")
                .unlockedBy("has_" + getItemName(stick), has(stick))
                .save(recipeOutput);
    }

    public void basicBigSwordTwoMat(RecipeOutput recipeOutput, Item handle, Item material, Item material2, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .define('Y', material2)
                .pattern(" XX")
                .pattern("YXX")
                .pattern("#Y ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicScythe(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicScythe(RecipeOutput recipeOutput, Item handle, TagKey<Item> material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(recipeOutput);
    }

    public void basicGlaive(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicGlaive(RecipeOutput recipeOutput, Item handle, TagKey<Item> material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(recipeOutput);
    }

    public void basicBigSword(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicBigSword(RecipeOutput recipeOutput, Item handle, TagKey<Item> material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(recipeOutput);
    }

    public void basicHelmet(RecipeOutput recipeOutput, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicChestplate(RecipeOutput recipeOutput, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicLeggings(RecipeOutput recipeOutput, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicBoots(RecipeOutput recipeOutput, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicSword(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicPickaxe(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicAxe(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX")
                .pattern("#X")
                .pattern("# ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicShovel(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void basicHoe(RecipeOutput recipeOutput, Item handle, Item material, DeferredItem<Item> result) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX")
                .pattern("# ")
                .pattern("# ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(recipeOutput);
    }

    public void enderSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.ENDER_EYE), pCategory, pResultItem
                )
                .unlocks("has_ender_eye", has(Items.ENDER_EYE))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    public void netheriteSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_INGOT), pCategory, pResultItem
                )
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    public void netheriteBlockSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_BLOCK), pCategory, pResultItem
                )
                .unlocks("has_netherite_block", has(Items.NETHERITE_BLOCK))
                .save(pRecipeOutput, path + getItemName(pResultItem) + "_smithing");
    }

    public void copySmithingTemplate(RecipeOutput pRecipeOutput, ItemLike pTemplate, ItemLike pBaseItem, ItemLike pCopyItem) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, pTemplate, 2)
                .define('#', pCopyItem)
                .define('C', pBaseItem)
                .define('S', pTemplate)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .unlockedBy(getHasName(pTemplate), has(pTemplate))
                .save(pRecipeOutput);
    }

    @Override
    protected void nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked, String pUnpackedName, String pUnpackedGroup) {
        this.nineBlockStorageRecipes(pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, path + getSimpleRecipeName(pPacked), null, path + pUnpackedName, pUnpackedGroup);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new BSRecipeProvider(provider, output);
        }

        @Override
        public String getName() {
            return "Big Swords R Recipes";
        }
    }
}
