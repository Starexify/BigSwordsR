package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
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
    public static String path = MODID + ":";

    public BSRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput) {
        super(lookupProvider, recipeOutput);
    }

    @Override
    protected void buildRecipes() {
        new CraftingRecipes(registries, output).build();
        new FurnaceRecipes(registries, output).build();
        new BSSmithingRecipes(registries, output).build();
    }

    // Recipes
    public void basicGildedShield(DeferredItem<Item> shield, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', shield)
                .define('X', Items.GOLD_INGOT)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(shield), has(shield))
                .save(output);
    }

    public void basicShield(Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', Items.LEATHER)
                .define('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicShield(TagKey<Item> material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', Items.LEATHER)
                .define('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .unlockedBy("has_" + getItemName(Items.LEATHER), has(Items.LEATHER))
                .save(output);
    }

    public void basicGiantStick(Item stick, DeferredItem<Item> result) {
        shaped(RecipeCategory.MISC, result)
                .define('#', stick)
                .pattern(" ##")
                .pattern("###")
                .pattern("## ")
                .unlockedBy("has_" + getItemName(stick), has(stick))
                .save(output);
    }

    public void basicBigSwordTwoMat(Item handle, Item material, Item material2, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .define('Y', material2)
                .pattern(" XX")
                .pattern("YXX")
                .pattern("#Y ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicScythe(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicScythe(Item handle, TagKey<Item> material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(output);
    }

    public void basicGlaive(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicGlaive(Item handle, TagKey<Item> material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(output);
    }

    public void basicBigSword(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicBigSword(Item handle, TagKey<Item> material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .unlockedBy("has_" + getItemName(handle), has(handle))
                .save(output);
    }

    public void basicHelmet(Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicChestplate(Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicLeggings(Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicBoots(Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicSword(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.COMBAT, result)
                .define('#', handle)
                .define('X', material)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicPickaxe(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicAxe(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX")
                .pattern("#X")
                .pattern("# ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicShovel(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void basicHoe(Item handle, Item material, DeferredItem<Item> result) {
        shaped(RecipeCategory.TOOLS, result)
                .define('#', handle)
                .define('X', material)
                .pattern("XX")
                .pattern("# ")
                .pattern("# ")
                .unlockedBy("has_" + getItemName(material), has(material))
                .save(output);
    }

    public void enderSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.ENDER_EYE), pCategory, pResultItem
                )
                .unlocks("has_ender_eye", has(Items.ENDER_EYE))
                .save(output, path + getItemName(pResultItem) + "_smithing");
    }

    public void netheriteSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_INGOT), pCategory, pResultItem
                )
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(output, path + getItemName(pResultItem) + "_smithing");
    }

    public void netheriteBlockSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem), Ingredient.of(Items.NETHERITE_BLOCK), pCategory, pResultItem
                )
                .unlocks("has_netherite_block", has(Items.NETHERITE_BLOCK))
                .save(output, path + getItemName(pResultItem) + "_smithing");
    }

    public void copySmithingTemplate(ItemLike pTemplate, ItemLike pBaseItem, ItemLike pCopyItem) {
        shaped(RecipeCategory.MISC, pTemplate, 2)
                .define('#', pCopyItem)
                .define('C', pBaseItem)
                .define('S', pTemplate)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .unlockedBy(getHasName(pTemplate), has(pTemplate))
                .save(output);
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
