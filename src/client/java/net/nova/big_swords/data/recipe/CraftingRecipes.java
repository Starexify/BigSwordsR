package net.nova.big_swords.data.recipe;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.recipe.CopperShieldAxingRecipe;

public class CraftingRecipes extends RecipeProvider {
  public final HolderGetter<Item> itemLookup;

  protected CraftingRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
    super(provider, recipeOutput);
    this.itemLookup = registries.lookupOrThrow(Registries.ITEM);
  }

  @Override
  public void buildRecipes() {
    SpecialRecipeBuilder.special(CopperShieldAxingRecipe::new).save(this.output, BigSwordsR.rl("unwax_copper_shield").getPath());

    // Extra Recipes
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, BSItems.BLOOD_VIAL.getFirst().value())
        .define('X', Blocks.GLASS)
        .pattern("XXX")
        .pattern("X X")
        .pattern(" X ")
        .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
        .save(output, getItemName(BSItems.BLOOD_VIAL.getFirst().value()) + "_recipe");
    waxableShield(BSItems.COPPER_SHIELD);
    waxableShield(BSItems.GILDED_COPPER_SHIELD);

    // Sticks
    basicGiantStick(Items.STICK, BSItems.GIANT_WOODEN_STICK.getFirst().value());
    basicGiantStick(Items.BLAZE_ROD, BSItems.GIANT_BLAZE_ROD.getFirst().value());
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, BSItems.GIANT_LIVINGMETAL_HANDLE.getFirst().value())
        .define('#', Items.STICK)
        .define('L', BSItems.LIVINGMETAL_INGOT.getFirst().value())
        .pattern(" L#")
        .pattern("L#L")
        .pattern("#L ")
        .unlockedBy(getHasName(BSItems.LIVINGMETAL_INGOT.getFirst().value()), has(BSItems.LIVINGMETAL_INGOT.getFirst().value()))
        .save(output);

    // Livingmetal Recipes
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT.getFirst().value())
        .define('I', Items.IRON_INGOT)
        .define('S', BSItems.SOUL.getFirst().value())
        .pattern(" S ")
        .pattern("SIS")
        .pattern(" S ")
        .unlockedBy(getHasName(BSItems.SOUL.getFirst().value()), has(BSItems.SOUL.getFirst().value()))
        .save(output);
    nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, BSItems.LIVINGMETAL_INGOT.getFirst().value(), RecipeCategory.BUILDING_BLOCKS, BSBlocks.LIVINGMETAL_BLOCK.getFirst().value(), getItemName(BSItems.LIVINGMETAL_INGOT.getFirst().value()) + "_from_" + getItemName(BSBlocks.LIVINGMETAL_BLOCK.getFirst().value()), getItemName(BSItems.LIVINGMETAL_INGOT.getFirst().value()));
    basicHelmet(BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_HELMET.getFirst().value());
    basicChestplate(BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_CHESTPLATE.getFirst().value());
    basicLeggings(BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_LEGGINGS.getFirst().value());
    basicBoots(BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_BOOTS.getFirst().value());
    basicSword(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_SWORD.getFirst().value());
    basicPickaxe(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_PICKAXE.getFirst().value());
    basicAxe(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_AXE.getFirst().value());
    basicShovel(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_SHOVEL.getFirst().value());
    basicHoe(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_HOE.getFirst().value());
    basicSpear(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_SPEAR.getFirst());

    // Biomass Recipes
    nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, BSItems.BIOMASS.getFirst().value(), RecipeCategory.BUILDING_BLOCKS, BSBlocks.BIOMASS_BLOCK.getFirst().value(), getItemName(BSItems.BIOMASS.getFirst().value()) + "_from_" + getItemName(BSBlocks.BIOMASS_BLOCK.getFirst().value()), getItemName(BSItems.BIOMASS.getFirst().value()));
    basicHelmet(BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_HELMET.getFirst().value());
    basicChestplate(BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_CHESTPLATE.getFirst().value());
    basicLeggings(BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_LEGGINGS.getFirst().value());
    basicBoots(BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_BOOTS.getFirst().value());
    basicSword(Items.STICK, BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_SWORD.getFirst().value());
    basicPickaxe(Items.STICK, BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_PICKAXE.getFirst().value());
    basicAxe(Items.STICK, BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_AXE.getFirst().value());
    basicShovel(Items.STICK, BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_SHOVEL.getFirst().value());
    basicHoe(Items.STICK, BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_HOE.getFirst().value());
    basicSpear(Items.STICK, BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_SPEAR.getFirst());

    // Ender Upgrade
    offerSmithingTemplateCopyingRecipe(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.getFirst().value(), Items.ENDER_EYE, Items.OBSIDIAN);

    // Big Swords
    basicBigSword(BSItems.GIANT_WOODEN_STICK.getFirst().value(), ItemTags.PLANKS, BSItems.WOODEN_BIG_SWORD.getFirst().value());
    basicBigSword(BSItems.GIANT_WOODEN_STICK.getFirst().value(), ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_BIG_SWORD.getFirst().value());
    basicBigSword(BSItems.GIANT_WOODEN_STICK.getFirst().value(), ItemTags.COPPER_TOOL_MATERIALS, BSItems.COPPER_BIG_SWORD.getFirst().value());
    basicBigSword(BSItems.GIANT_WOODEN_STICK.getFirst().value(), ItemTags.IRON_TOOL_MATERIALS, BSItems.IRON_BIG_SWORD.getFirst().value());
    basicBigSword(BSItems.GIANT_WOODEN_STICK.getFirst().value(), ItemTags.GOLD_TOOL_MATERIALS, BSItems.GOLDEN_BIG_SWORD.getFirst().value());
    basicBigSword(BSItems.GIANT_WOODEN_STICK.getFirst().value(), ItemTags.DIAMOND_TOOL_MATERIALS, BSItems.DIAMOND_BIG_SWORD.getFirst().value());
    basicBigSword(Items.BONE, Items.ROTTEN_FLESH, BSItems.PATCHWORK_BIG_SWORD.getFirst().value());
    basicBigSword(BSItems.GIANT_LIVINGMETAL_HANDLE.getFirst().value(), BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_BIG_SWORD.getFirst().value());
    basicBigSwordTwoMat(BSItems.GIANT_BLAZE_ROD.getFirst().value(), Items.QUARTZ, Items.QUARTZ_BLOCK, BSItems.QUARTZ_BIG_SWORD.getFirst().value());
    basicBigSwordTwoMat(BSItems.GIANT_WOODEN_STICK.getFirst().value(), BSItems.BIOMASS.getFirst().value(), Items.NETHER_BRICK, BSItems.BIOMASS_BIG_SWORD.getFirst().value());

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.SKULL_BIG_SWORD.getFirst().value())
        .define('#', BSItems.GIANT_WOODEN_STICK.getFirst().value())
        .define('B', Items.BONE)
        .define('X', Items.BONE_BLOCK)
        .define('S', Items.SKELETON_SKULL)
        .pattern(" BB")
        .pattern("XSB")
        .pattern("#X ")
        .unlockedBy(getHasName(Items.SKELETON_SKULL), has(Items.SKELETON_SKULL))
        .save(output);

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.OBSIDIAN_BIG_SWORD.getFirst().value())
        .define('#', BSItems.GIANT_BLAZE_ROD.getFirst().value())
        .define('Q', Items.OBSIDIAN)
        .define('D', BSItems.DIAMOND_BIG_SWORD.getFirst().value())
        .pattern(" QQ")
        .pattern("QDQ")
        .pattern("#Q ")
        .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
        .save(output);

    // Glaives
    basicGlaive(Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_GLAIVE.getFirst().value());
    basicGlaive(Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_GLAIVE.getFirst().value());
    basicGlaive(Items.STICK, ItemTags.COPPER_TOOL_MATERIALS, BSItems.COPPER_GLAIVE.getFirst().value());
    basicGlaive(Items.STICK, ItemTags.IRON_TOOL_MATERIALS, BSItems.IRON_GLAIVE.getFirst().value());
    basicGlaive(Items.STICK, ItemTags.GOLD_TOOL_MATERIALS, BSItems.GOLDEN_GLAIVE.getFirst().value());
    basicGlaive(Items.STICK, ItemTags.DIAMOND_TOOL_MATERIALS, BSItems.DIAMOND_GLAIVE.getFirst().value());
    basicGlaive(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_GLAIVE.getFirst().value());

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.BIOMASS_GLAIVE.getFirst().value())
        .define('#', Items.STICK)
        .define('X', BSItems.BIOMASS.getFirst().value())
        .define('Y', Items.NETHER_BRICK)
        .pattern("XX ")
        .pattern("X#Y")
        .pattern(" Y#")
        .unlockedBy(getHasName(BSItems.BIOMASS.getFirst().value()), has(BSItems.BIOMASS.getFirst().value()))
        .save(output);

    // Scythes
    basicScythe(Items.STICK, ItemTags.PLANKS, BSItems.WOODEN_SCYTHE.getFirst().value());
    basicScythe(Items.STICK, ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SCYTHE.getFirst().value());
    basicScythe(Items.STICK, ItemTags.COPPER_TOOL_MATERIALS, BSItems.COPPER_SCYTHE.getFirst().value());
    basicScythe(Items.STICK, ItemTags.IRON_TOOL_MATERIALS, BSItems.IRON_SCYTHE.getFirst().value());
    basicScythe(Items.STICK, ItemTags.GOLD_TOOL_MATERIALS, BSItems.GOLDEN_SCYTHE.getFirst().value());
    basicScythe(Items.STICK, ItemTags.DIAMOND_TOOL_MATERIALS, BSItems.DIAMOND_SCYTHE.getFirst().value());
    basicScythe(Items.STICK, BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_SCYTHE.getFirst().value());

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.BIOMASS_SCYTHE.getFirst().value())
        .define('#', Items.STICK)
        .define('X', BSItems.BIOMASS.getFirst().value())
        .define('Y', Items.NETHER_BRICK)
        .pattern("XX#")
        .pattern(" #Y")
        .pattern("#  ")
        .unlockedBy(getHasName(BSItems.BIOMASS.getFirst().value()), has(BSItems.BIOMASS.getFirst().value()))
        .save(output);

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.BONE_SCYTHE.getFirst().value())
        .define('#', Items.BONE)
        .define('Y', Items.BONE_BLOCK)
        .pattern("###")
        .pattern(" #Y")
        .pattern("#  ")
        .unlockedBy(getHasName(BSItems.BIOMASS.getFirst().value()), has(BSItems.BIOMASS.getFirst().value()))
        .save(output);

    // Shields
    basicShield(ItemTags.PLANKS, BSItems.WOODEN_SHIELD.getFirst().value());
    basicShield(ItemTags.STONE_TOOL_MATERIALS, BSItems.STONE_SHIELD.getFirst().value());
    basicShield(ItemTags.COPPER_TOOL_MATERIALS, BSItems.COPPER_SHIELD.weathering().unaffected().getFirst().value());
    basicShield(ItemTags.IRON_TOOL_MATERIALS, BSItems.IRON_SHIELD.getFirst().value());
    basicShield(ItemTags.DIAMOND_TOOL_MATERIALS, BSItems.DIAMOND_SHIELD.getFirst().value());
    basicShield(Items.QUARTZ, BSItems.QUARTZ_SHIELD.getFirst().value());
    basicShield(BSItems.BIOMASS.getFirst().value(), BSItems.BIOMASS_SHIELD.getFirst().value());
    basicShield(BSItems.LIVINGMETAL_INGOT.getFirst().value(), BSItems.LIVINGMETAL_SHIELD.getFirst().value());

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.PATCHWORK_SHIELD.getFirst().value())
        .define('X', Items.ROTTEN_FLESH)
        .pattern("XXX")
        .pattern("XXX")
        .pattern(" X ")
        .unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
        .save(output);

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.SKULL_SHIELD.getFirst().value())
        .define('X', Items.BONE)
        .define('S', Items.SKELETON_SKULL)
        .define('#', Items.LEATHER)
        .pattern("XSX")
        .pattern("X#X")
        .pattern(" X ")
        .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
        .save(output);

    // Gilded Shields
    basicGildedShield(BSItems.WOODEN_SHIELD.getFirst().value(), BSItems.GILDED_WOODEN_SHIELD.getFirst().value());
    basicGildedShield(BSItems.STONE_SHIELD.getFirst().value(), BSItems.GILDED_STONE_SHIELD.getFirst().value());
    basicGildedShield(BSItems.COPPER_SHIELD.weathering().unaffected().getFirst().value(), BSItems.GILDED_COPPER_SHIELD.weathering().unaffected().getFirst().value());
    basicGildedShield(BSItems.IRON_SHIELD.getFirst().value(), BSItems.GILDED_IRON_SHIELD.getFirst().value());
    basicGildedShield(BSItems.DIAMOND_SHIELD.getFirst().value(), BSItems.GILDED_DIAMOND_SHIELD.getFirst().value());
    basicGildedShield(BSItems.NETHERITE_SHIELD.getFirst().value(), BSItems.GILDED_NETHERITE_SHIELD.getFirst().value());
    basicGildedShield(BSItems.ENDER_SHIELD.getFirst().value(), BSItems.GILDED_ENDER_SHIELD.getFirst().value());
    basicGildedShield(BSItems.QUARTZ_SHIELD.getFirst().value(), BSItems.GILDED_QUARTZ_SHIELD.getFirst().value());
    basicGildedShield(BSItems.PATCHWORK_SHIELD.getFirst().value(), BSItems.GILDED_PATCHWORK_SHIELD.getFirst().value());
    basicGildedShield(BSItems.BIOMASS_SHIELD.getFirst().value(), BSItems.GILDED_BIOMASS_SHIELD.getFirst().value());
    basicGildedShield(BSItems.LIVINGMETAL_SHIELD.getFirst().value(), BSItems.GILDED_LIVINGMETAL_SHIELD.getFirst().value());

    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, BSItems.GILDED_SKULL_SHIELD.getFirst().value())
        .define('#', BSItems.SKULL_SHIELD.getFirst().value())
        .define('X', Items.GOLD_INGOT)
        .define('S', Items.WITHER_SKELETON_SKULL)
        .pattern("XSX")
        .pattern("X#X")
        .pattern(" X ")
        .unlockedBy(getHasName(BSItems.SKULL_SHIELD.getFirst().value()), has(BSItems.SKULL_SHIELD.getFirst().value()))
        .save(output);
  }

  // Recipes
  public void waxableShield(WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>> item) {
    item.zipUnwaxedWaxed((unwaxed, waxed) -> {
      TransmuteRecipeBuilder.transmute(
              RecipeCategory.COMBAT,
              Ingredient.of(unwaxed.getFirst().value()),
              Ingredient.of(Items.HONEYCOMB),
              waxed.getFirst().value()
          )
          .unlockedBy(getHasName(unwaxed.getFirst().value()), has(unwaxed.getFirst().value()))
          .save(output, getConversionRecipeName(waxed.getFirst().value(), Items.HONEYCOMB));
    });
  }

  public void basicGiantStick(Item stick, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, result)
        .define('#', stick)
        .pattern(" ##")
        .pattern("###")
        .pattern("## ")
        .unlockedBy(getHasName(stick), has(stick))
        .save(output);
  }

  public void basicHelmet(Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', material)
        .pattern("###")
        .pattern("# #")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicChestplate(Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', material)
        .pattern("# #")
        .pattern("###")
        .pattern("###")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicLeggings(Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', material)
        .pattern("###")
        .pattern("# #")
        .pattern("# #")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicBoots(Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', material)
        .pattern("###")
        .pattern("# #")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicSword(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .pattern("X")
        .pattern("X")
        .pattern("#")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicPickaxe(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.TOOLS, result)
        .define('#', handle)
        .define('X', material)
        .pattern("XXX")
        .pattern(" # ")
        .pattern(" # ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicAxe(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.TOOLS, result)
        .define('#', handle)
        .define('X', material)
        .pattern("XX")
        .pattern("#X")
        .pattern("# ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicShovel(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.TOOLS, result)
        .define('#', handle)
        .define('X', material)
        .pattern("X")
        .pattern("#")
        .pattern("#")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicHoe(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.TOOLS, result)
        .define('#', handle)
        .define('X', material)
        .pattern("XX")
        .pattern("# ")
        .pattern("# ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicSpear(Item handle, Item material, Holder<Item> result) {
    shaped(RecipeCategory.TOOLS, result.value())
        .define('#', handle)
        .define('X', material)
        .pattern("  X")
        .pattern(" # ")
        .pattern("#  ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void offerSmithingTemplateCopyingRecipe(ItemLike template, ItemLike baseItem, ItemLike copyItem) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, template, 2)
        .define('#', copyItem)
        .define('C', baseItem)
        .define('S', template)
        .pattern("#S#")
        .pattern("#C#")
        .pattern("###")
        .unlockedBy(getHasName(template), has(template))
        .save(output);
  }

  public void basicBigSword(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .pattern(" XX")
        .pattern("XXX")
        .pattern("#X ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicBigSword(Item handle, TagKey<Item> material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .pattern(" XX")
        .pattern("XXX")
        .pattern("#X ")
        .unlockedBy(getHasName(handle), has(handle))
        .save(output);
  }

  public void basicBigSwordTwoMat(Item handle, Item material, Item material2, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .define('Y', material2)
        .pattern(" XX")
        .pattern("YXX")
        .pattern("#Y ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicGlaive(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .pattern("XX ")
        .pattern("X#X")
        .pattern(" X#")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicGlaive(Item handle, TagKey<Item> material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .pattern("XX ")
        .pattern("X#X")
        .pattern(" X#")
        .unlockedBy(getHasName(handle), has(handle))
        .save(output);
  }

  public void basicScythe(Item handle, Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .pattern("XX#")
        .pattern(" #X")
        .pattern("#  ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicScythe(Item handle, TagKey<Item> material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', handle)
        .define('X', material)
        .pattern("XX#")
        .pattern(" #X")
        .pattern("#  ")
        .unlockedBy(getHasName(handle), has(handle))
        .save(output);
  }

  public void basicShield(Item material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', Items.LEATHER)
        .define('X', material)
        .pattern("XXX")
        .pattern("X#X")
        .pattern(" X ")
        .unlockedBy(getHasName(material), has(material))
        .save(output);
  }

  public void basicShield(TagKey<Item> material, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', Items.LEATHER)
        .define('X', material)
        .pattern("XXX")
        .pattern("X#X")
        .pattern(" X ")
        .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
        .save(output);
  }

  public void basicGildedShield(Item shield, Item result) {
    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.COMBAT, result)
        .define('#', shield)
        .define('X', Items.GOLD_INGOT)
        .pattern("XXX")
        .pattern("X#X")
        .pattern(" X ")
        .unlockedBy(getHasName(shield), has(shield))
        .save(output);
  }
}
