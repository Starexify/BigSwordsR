package net.nova.big_swords.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeDispatcher;
import net.nova.big_swords.block.BSBlock;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.mixin.RecipeDispatcherAccessor;

public class BSCraftingRecipes {
    private static RecipeDispatcher dispatcher = RecipeDispatcher.getInstance();
    private static RecipeDispatcherAccessor accessDispatcher = (RecipeDispatcherAccessor) dispatcher;

    public static void initialize() {
        // Extra Recipes
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.BLOOD_VIAL),
                "XXX", "X X", " X ",
                'X', Blocks.GLASS);

        // Sticks
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_WOODEN_STICK),
                " XX", "XXX", "XX ",
                'X', Items.STICK);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_BLAZE_ROD),
                " XX", "XXX", "XX ",
                'X', Items.BLAZE_ROD);
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.GIANT_BLAZE_ROD),
                " LX", "LXL", "XL ",
                'X', Items.STICK, 'L', BSItems.LIVINGMETAL_INGOT);

        // Livingmetal Recipes
        ((RecipeDispatcherAccessor) RecipeDispatcher.getInstance()).big_swords$registerShapedRecipe(new ItemStack(BSItems.LIVINGMETAL_INGOT),
                " S ", "SIS", " S ",
                'I', Items.IRON_INGOT, 'S', BSItems.SOUL);
        registerBlockAndIngotExchange(BSBlocks.LIVINGMETAL_BLOCK, BSItems.LIVINGMETAL_INGOT);
        registerArmorSet(BSItems.LIVINGMETAL_HELMET, BSItems.LIVINGMETAL_CHESTPLATE, BSItems.LIVINGMETAL_LEGGINGS, BSItems.LIVINGMETAL_BOOTS,
                BSItems.LIVINGMETAL_INGOT);
        registerToolSet(BSItems.LIVINGMETAL_SWORD, BSItems.LIVINGMETAL_PICKAXE, BSItems.LIVINGMETAL_AXE, BSItems.LIVINGMETAL_SHOVEL, BSItems.LIVINGMETAL_HOE,
                BSItems.LIVINGMETAL_INGOT);

        // Biomass Recipes
        registerBlockAndIngotExchange(BSBlocks.BIOMASS_BLOCK, BSItems.BIOMASS);
        registerArmorSet(BSItems.BIOMASS_HELMET, BSItems.BIOMASS_CHESTPLATE, BSItems.BIOMASS_LEGGINGS, BSItems.BIOMASS_BOOTS,
                BSItems.BIOMASS);
        registerToolSet(BSItems.BIOMASS_SWORD, BSItems.BIOMASS_PICKAXE, BSItems.BIOMASS_AXE, BSItems.BIOMASS_SHOVEL, BSItems.BIOMASS_HOE,
                BSItems.BIOMASS);
    }

    // Methods
    private static void registerArmorSet(Item helmet, Item chestplate, Item leggings, Item boots, Item material) {
        registerShaped(new ItemStack(helmet),
                "###", "# #",
                '#', material);

        registerShaped(new ItemStack(chestplate),
                "# #", "###", "###",
                '#', material);

        registerShaped(new ItemStack(leggings),
                "###", "# #", "# #",
                '#', material);

        registerShaped(new ItemStack(boots),
                "# #", "# #",
                '#', material);
    }

    private static void registerToolSet(Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item material) {
        registerShaped(new ItemStack(sword),
                "X", "X", "#",
                '#', Items.STICK, 'X', material);

        registerShaped(new ItemStack(pickaxe),
                "XXX", " # ", " # ",
                '#', Items.STICK, 'X', material);

        registerShaped(new ItemStack(axe),
                "XX", "X#", " #",
                '#', Items.STICK, 'X', material);

        registerShaped(new ItemStack(shovel),
                "X", "#", "#",
                '#', Items.STICK, 'X', material);

        registerShaped(new ItemStack(hoe),
                "XX", " #", " #",
                '#', Items.STICK, 'X', material);
    }

    public static void registerBlockAndIngotExchange(BSBlock block, Item ingot) {
        // Block from ingots
        registerShaped(new ItemStack(BSBlocks.getBlockItem(block)),
                "###", "###", "###",
                '#', ingot);

        // Ingots from block
        registerShaped(new ItemStack(ingot, 9),
                "#",
                '#', BSBlocks.getBlockItem(block));
    }

    public static void registerShaped(ItemStack result, Object... recipe) {
        accessDispatcher.big_swords$registerShapedRecipe(result, recipe);
    }
}