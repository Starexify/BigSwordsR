package net.nova.big_swords.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.nova.big_swords.init.BSItems;

public class BSSmithingRecipes extends BSRecipeProvider {
    public BSSmithingRecipes(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput) {
        super(lookupProvider, recipeOutput);
    }

    public void build() {
        netheriteBlockSmithing(BSItems.DIAMOND_BIG_SWORD.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_BIG_SWORD.get());
        enderSmithing(BSItems.OBSIDIAN_BIG_SWORD.get(), RecipeCategory.COMBAT, BSItems.ENDER_BIG_SWORD.get());
        netheriteSmithing(BSItems.DIAMOND_GLAIVE.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_GLAIVE.get());
        netheriteSmithing(BSItems.DIAMOND_SCYTHE.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_SCYTHE.get());
        netheriteSmithing(BSItems.DIAMOND_SHIELD.get(), RecipeCategory.COMBAT, BSItems.NETHERITE_SHIELD.get());
        netheriteSmithing(BSItems.GILDED_DIAMOND_SHIELD.get(), RecipeCategory.COMBAT, BSItems.GILDED_NETHERITE_SHIELD.get());
        enderSmithing(BSItems.NETHERITE_SHIELD.get(), RecipeCategory.COMBAT, BSItems.ENDER_SHIELD.get());
        enderSmithing(BSItems.GILDED_NETHERITE_SHIELD.get(), RecipeCategory.COMBAT, BSItems.GILDED_ENDER_SHIELD.get());
    }
}
