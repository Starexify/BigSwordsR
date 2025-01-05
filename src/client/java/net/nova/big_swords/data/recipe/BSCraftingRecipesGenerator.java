package net.nova.big_swords.data.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

public class BSCraftingRecipesGenerator extends RecipeGenerator {
    public final RegistryEntryLookup<Item> itemLookup;

    protected BSCraftingRecipesGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
        this.itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
    }

    @Override
    public void generate() {
        // Extra Recipes
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, BSItems.BLOOD_VIAL)
                .input('X', Blocks.GLASS)
                .pattern("XXX")
                .pattern("X X")
                .pattern(" X ")
                .criterion(hasItem(Blocks.GLASS), conditionsFromItem(Blocks.GLASS))
                .offerTo(exporter, getItemPath(BSItems.BLOOD_VIAL) + "_recipe");

        // Sticks
        basicGiantStick(Items.STICK, BSItems.GIANT_WOODEN_STICK);
        basicGiantStick(Items.BLAZE_ROD, BSItems.GIANT_BLAZE_ROD);
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, BSItems.GIANT_LIVINGMETAL_HANDLE)
                .input('#', Items.STICK)
                .input('L', BSItems.LIVINGMETAL_INGOT)
                .pattern(" L#")
                .pattern("L#L")
                .pattern("#L ")
                .criterion(hasItem(BSItems.LIVINGMETAL_INGOT), conditionsFromItem(BSItems.LIVINGMETAL_INGOT))
                .offerTo(exporter);

        // Livingmetal Recipes
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT)
                .input('I', Items.IRON_INGOT)
                .input('S', BSItems.SOUL)
                .pattern(" S ")
                .pattern("SIS")
                .pattern(" S ")
                .criterion(hasItem(BSItems.SOUL), conditionsFromItem(BSItems.SOUL))
                .offerTo(exporter);

        offerReversibleCompactingRecipesWithReverseRecipeGroup(RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT, RecipeCategory.BUILDING_BLOCKS, BSBlocks.LIVINGMETAL_BLOCK, "livingmetal_ingot_from_livingmetal_block", "livingmetal_ingot");
        basicHelmet(BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_HELMET);
        basicChestplate(BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_CHESTPLATE);
        basicLeggings(BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_LEGGINGS);
        basicBoots(BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_BOOTS);
        basicSword(Items.STICK, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_SWORD);
        basicPickaxe(Items.STICK, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_PICKAXE);
        basicAxe(Items.STICK, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_AXE);
        basicShovel(Items.STICK, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_SHOVEL);
        basicHoe(Items.STICK, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_HOE);

        // Biomass Recipes
        offerReversibleCompactingRecipesWithReverseRecipeGroup(RecipeCategory.MISC, BSItems.BIOMASS, RecipeCategory.BUILDING_BLOCKS, BSBlocks.BIOMASS_BLOCK, "biomass_from_biomass_block", "biomass");
        basicHelmet(BSItems.BIOMASS, BSItems.BIOMASS_HELMET);
        basicChestplate(BSItems.BIOMASS, BSItems.BIOMASS_CHESTPLATE);
        basicLeggings(BSItems.BIOMASS, BSItems.BIOMASS_LEGGINGS);
        basicBoots(BSItems.BIOMASS, BSItems.BIOMASS_BOOTS);
        basicSword(Items.STICK, BSItems.BIOMASS, BSItems.BIOMASS_SWORD);
        basicPickaxe(Items.STICK, BSItems.BIOMASS, BSItems.BIOMASS_PICKAXE);
        basicAxe(Items.STICK, BSItems.BIOMASS, BSItems.BIOMASS_AXE);
        basicShovel(Items.STICK, BSItems.BIOMASS, BSItems.BIOMASS_SHOVEL);
        basicHoe(Items.STICK, BSItems.BIOMASS, BSItems.BIOMASS_HOE);

        // Ender Upgrade
        offerSmithingTemplateCopyingRecipe(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, Items.ENDER_EYE, Items.OBSIDIAN);

        // Big Swords
        basicBigSword(BSItems.GIANT_WOODEN_STICK, ItemTags.PLANKS, BSItems.WOODEN_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK, Items.IRON_INGOT, BSItems.IRON_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK, Items.GOLD_INGOT, BSItems.GOLDEN_BIG_SWORD);
        basicBigSword(BSItems.GIANT_WOODEN_STICK, Items.DIAMOND, BSItems.DIAMOND_BIG_SWORD);
        basicBigSword(Items.BONE, Items.ROTTEN_FLESH, BSItems.PATCHWORK_BIG_SWORD);
        basicBigSword(BSItems.GIANT_LIVINGMETAL_HANDLE, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_BIG_SWORD);
        basicBigSwordTwoMat(BSItems.GIANT_BLAZE_ROD, Items.QUARTZ, Items.QUARTZ_BLOCK, BSItems.QUARTZ_BIG_SWORD);
        basicBigSwordTwoMat(BSItems.GIANT_WOODEN_STICK, BSItems.BIOMASS, Items.NETHER_BRICK, BSItems.BIOMASS_BIG_SWORD);

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.SKULL_BIG_SWORD)
                .input('#', BSItems.GIANT_WOODEN_STICK)
                .input('B', Items.BONE)
                .input('X', Items.BONE_BLOCK)
                .input('S', Items.SKELETON_SKULL)
                .pattern(" BB")
                .pattern("XSB")
                .pattern("#X ")
                .criterion(hasItem(Items.SKELETON_SKULL), conditionsFromItem(Items.SKELETON_SKULL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.OBSIDIAN_BIG_SWORD)
                .input('#', BSItems.GIANT_BLAZE_ROD)
                .input('Q', Items.OBSIDIAN)
                .input('D', BSItems.DIAMOND_BIG_SWORD)
                .pattern(" QQ")
                .pattern("QDQ")
                .pattern("#Q ")
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter);

        // Glaives
        basicGlaive(Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_GLAIVE);
        basicGlaive(Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_GLAIVE);
        basicGlaive(Items.STICK, Items.IRON_INGOT, BSItems.IRON_GLAIVE);
        basicGlaive(Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_GLAIVE);
        basicGlaive(Items.STICK, Items.DIAMOND, BSItems.DIAMOND_GLAIVE);
        basicGlaive(Items.STICK, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_GLAIVE);

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.BIOMASS_GLAIVE)
                .input('#', Items.STICK)
                .input('X', BSItems.BIOMASS)
                .input('Y', Items.NETHER_BRICK)
                .pattern("XX ")
                .pattern("X#Y")
                .pattern(" Y#")
                .criterion(hasItem(BSItems.BIOMASS), conditionsFromItem(BSItems.BIOMASS))
                .offerTo(exporter);

        // Scythes
        basicScythe(Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_SCYTHE);
        basicScythe(Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SCYTHE);
        basicScythe(Items.STICK, Items.IRON_INGOT, BSItems.IRON_SCYTHE);
        basicScythe(Items.STICK, Items.GOLD_INGOT, BSItems.GOLDEN_SCYTHE);
        basicScythe(Items.STICK, Items.DIAMOND, BSItems.DIAMOND_SCYTHE);
        basicScythe(Items.STICK, BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_SCYTHE);

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.BIOMASS_SCYTHE)
                .input('#', Items.STICK)
                .input('X', BSItems.BIOMASS)
                .input('Y', Items.NETHER_BRICK)
                .pattern("XX#")
                .pattern(" #Y")
                .pattern("#  ")
                .criterion(hasItem(BSItems.BIOMASS), conditionsFromItem(BSItems.BIOMASS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.BONE_SCYTHE)
                .input('#', Items.BONE)
                .input('Y', Items.BONE_BLOCK)
                .pattern("###")
                .pattern(" #Y")
                .pattern("#  ")
                .criterion(hasItem(BSItems.BIOMASS), conditionsFromItem(BSItems.BIOMASS))
                .offerTo(exporter);

        // Shields
        basicShield(ItemTags.PLANKS, BSItems.WOODEN_SHIELD);
        basicShield(ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SHIELD);
        basicShield(Items.IRON_INGOT, BSItems.IRON_SHIELD);
        basicShield(Items.DIAMOND, BSItems.DIAMOND_SHIELD);
        basicShield(Items.QUARTZ, BSItems.QUARTZ_SHIELD);
        basicShield(BSItems.BIOMASS, BSItems.BIOMASS_SHIELD);
        basicShield(BSItems.LIVINGMETAL_INGOT, BSItems.LIVINGMETAL_SHIELD);

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.PATCHWORK_SHIELD)
                .input('X', Items.ROTTEN_FLESH)
                .pattern("XXX")
                .pattern("XXX")
                .pattern(" X ")
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.SKULL_SHIELD)
                .input('X', Items.BONE)
                .input('S', Items.SKELETON_SKULL)
                .input('#', Items.LEATHER)
                .pattern("XSX")
                .pattern("X#X")
                .pattern(" X ")
                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                .offerTo(exporter);

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

        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, BSItems.GILDED_SKULL_SHIELD)
                .input('#', BSItems.SKULL_SHIELD)
                .input('X', Items.GOLD_INGOT)
                .input('S', Items.WITHER_SKELETON_SKULL)
                .pattern("XSX")
                .pattern("X#X")
                .pattern(" X ")
                .criterion(hasItem(BSItems.SKULL_SHIELD), conditionsFromItem(BSItems.SKULL_SHIELD))
                .offerTo(exporter);
    }

    // Recipes
    public void basicGiantStick(Item stick, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, result)
                .input('#', stick)
                .pattern(" ##")
                .pattern("###")
                .pattern("## ")
                .criterion(hasItem(stick), conditionsFromItem(stick))
                .offerTo(exporter);
    }

    public void basicHelmet(Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', material)
                .pattern("###")
                .pattern("# #")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicChestplate(Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', material)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicLeggings(Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicBoots(Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', material)
                .pattern("###")
                .pattern("# #")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicSword(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicPickaxe(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, result)
                .input('#', handle)
                .input('X', material)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicAxe(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, result)
                .input('#', handle)
                .input('X', material)
                .pattern("XX")
                .pattern("#X")
                .pattern("# ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicShovel(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, result)
                .input('#', handle)
                .input('X', material)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicHoe(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, result)
                .input('#', handle)
                .input('X', material)
                .pattern("XX")
                .pattern("# ")
                .pattern("# ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void offerSmithingTemplateCopyingRecipe(ItemConvertible template, ItemConvertible pBaseItem, ItemConvertible pCopyItem) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, template, 2)
                .input('#', pCopyItem)
                .input('C', pBaseItem)
                .input('S', template)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .criterion(hasItem(template), conditionsFromItem(template))
                .offerTo(exporter);
    }

    public void basicBigSword(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicBigSword(Item handle, TagKey<Item> material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .pattern(" XX")
                .pattern("XXX")
                .pattern("#X ")
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }

    public void basicBigSwordTwoMat(Item handle, Item material, Item material2, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .input('Y', material2)
                .pattern(" XX")
                .pattern("YXX")
                .pattern("#Y ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicGlaive(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicGlaive(Item handle, TagKey<Item> material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .pattern("XX ")
                .pattern("X#X")
                .pattern(" X#")
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }

    public void basicScythe(Item handle, Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicScythe(Item handle, TagKey<Item> material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', handle)
                .input('X', material)
                .pattern("XX#")
                .pattern(" #X")
                .pattern("#  ")
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }

    public void basicShield(Item material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', Items.LEATHER)
                .input('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public void basicShield(TagKey<Item> material, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', Items.LEATHER)
                .input('X', material)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter);
    }

    public void basicGildedShield(Item shield, Item result) {
        ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, result)
                .input('#', shield)
                .input('X', Items.GOLD_INGOT)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" X ")
                .criterion(hasItem(shield), conditionsFromItem(shield))
                .offerTo(exporter);
    }
}
