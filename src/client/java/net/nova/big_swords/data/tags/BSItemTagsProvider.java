package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
  public BSItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    builder(Tags.BSItemTags.BIG_SWORDS).add(
        BSItems.WOODEN_BIG_SWORD.getSecond(), BSItems.STONE_BIG_SWORD.getSecond(), BSItems.IRON_BIG_SWORD.getSecond(),
        BSItems.GOLDEN_BIG_SWORD.getSecond(), BSItems.DIAMOND_BIG_SWORD.getSecond(), BSItems.NETHERITE_BIG_SWORD.getSecond(),
        BSItems.PATCHWORK_BIG_SWORD.getSecond(), BSItems.SKULL_BIG_SWORD.getSecond(), BSItems.QUARTZ_BIG_SWORD.getSecond(),
        BSItems.OBSIDIAN_BIG_SWORD.getSecond(), BSItems.ENDER_BIG_SWORD.getSecond(), BSItems.LIVINGMETAL_BIG_SWORD.getSecond(),
        BSItems.BIOMASS_BIG_SWORD.getSecond()
    );

    builder(Tags.BSItemTags.GLAIVES).add(
        BSItems.WOODEN_GLAIVE.getSecond(), BSItems.STONE_GLAIVE.getSecond(), BSItems.IRON_GLAIVE.getSecond(),
        BSItems.GOLDEN_GLAIVE.getSecond(), BSItems.DIAMOND_GLAIVE.getSecond(), BSItems.NETHERITE_GLAIVE.getSecond(),
        BSItems.BIOMASS_GLAIVE.getSecond(), BSItems.LIVINGMETAL_GLAIVE.getSecond()
    );

      builder(Tags.BSItemTags.SCYTHES).add(
          BSItems.WOODEN_SCYTHE.getSecond(), BSItems.STONE_SCYTHE.getSecond(), BSItems.IRON_SCYTHE.getSecond(),
          BSItems.GOLDEN_SCYTHE.getSecond(), BSItems.DIAMOND_SCYTHE.getSecond(), BSItems.NETHERITE_SCYTHE.getSecond(),
          BSItems.BIOMASS_SCYTHE.getSecond(), BSItems.LIVINGMETAL_SCYTHE.getSecond(), BSItems.BONE_SCYTHE.getSecond(),
          BSItems.SOUL_REAPER.getSecond()
      );

      builder(Tags.BSItemTags.SHIELDS).add(
          BSItems.WOODEN_SHIELD.getSecond(), BSItems.GILDED_WOODEN_SHIELD.getSecond(), BSItems.STONE_SHIELD.getSecond(),
          BSItems.GILDED_STONE_SHIELD.getSecond(), BSItems.IRON_SHIELD.getSecond(), BSItems.GILDED_IRON_SHIELD.getSecond(),
          BSItems.DIAMOND_SHIELD.getSecond(), BSItems.GILDED_DIAMOND_SHIELD.getSecond(), BSItems.NETHERITE_SHIELD.getSecond(),
          BSItems.GILDED_NETHERITE_SHIELD.getSecond(), BSItems.ENDER_SHIELD.getSecond(), BSItems.GILDED_ENDER_SHIELD.getSecond(),
          BSItems.QUARTZ_SHIELD.getSecond(), BSItems.GILDED_QUARTZ_SHIELD.getSecond(), BSItems.PATCHWORK_SHIELD.getSecond(),
          BSItems.GILDED_PATCHWORK_SHIELD.getSecond(), BSItems.SKULL_SHIELD.getSecond(), BSItems.GILDED_SKULL_SHIELD.getSecond(),
          BSItems.BIOMASS_SHIELD.getSecond(), BSItems.GILDED_BIOMASS_SHIELD.getSecond(), BSItems.LIVINGMETAL_SHIELD.getSecond(),
          BSItems.GILDED_LIVINGMETAL_SHIELD.getSecond()
      );

      builder(ItemTags.HEAD_ARMOR).add(BSItems.LIVINGMETAL_HELMET.getSecond(), BSItems.BIOMASS_HELMET.getSecond());
      builder(ItemTags.CHEST_ARMOR).add(BSItems.LIVINGMETAL_CHESTPLATE.getSecond(), BSItems.BIOMASS_CHESTPLATE.getSecond());
      builder(ItemTags.LEG_ARMOR).add(BSItems.LIVINGMETAL_LEGGINGS.getSecond(), BSItems.BIOMASS_LEGGINGS.getSecond());
      builder(ItemTags.FOOT_ARMOR).add(BSItems.LIVINGMETAL_BOOTS.getSecond(), BSItems.BIOMASS_BOOTS.getSecond());

      builder(ItemTags.SWORDS).addTag(Tags.BSItemTags.BIG_SWORDS).add(BSItems.LIVINGMETAL_SWORD.getSecond(), BSItems.BIOMASS_SWORD.getSecond());
      builder(ItemTags.PICKAXES).add(BSItems.LIVINGMETAL_PICKAXE.getSecond(), BSItems.LIVINGMETAL_PICKAXE.getSecond());
      builder(ItemTags.AXES).add(BSItems.LIVINGMETAL_AXE.getSecond(), BSItems.BIOMASS_AXE.getSecond());
      builder(ItemTags.SHOVELS).add(BSItems.LIVINGMETAL_SHOVEL.getSecond(), BSItems.BIOMASS_SHOVEL.getSecond());
      builder(ItemTags.HOES).addTag(Tags.BSItemTags.SCYTHES).add(BSItems.LIVINGMETAL_HOE.getSecond(), BSItems.BIOMASS_HOE.getSecond());

      builder(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.SHIELDS);

      builder(ItemTags.BREAKS_DECORATED_POTS).addTag(Tags.BSItemTags.GLAIVES);
      builder(ItemTags.WEAPON_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
      builder(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
      builder(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);

      builder(ItemTags.TRIM_MATERIALS).add(BSItems.LIVINGMETAL_INGOT.getSecond());

      builder(Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR).add(BSItems.LIVINGMETAL_INGOT.getSecond());
      builder(Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR).add(BSItems.BIOMASS.getSecond());

      builder(Tags.BSItemTags.PATCHWORK_TOOL_MATERIALS).add(ItemIds.ROTTEN_FLESH);
      builder(Tags.BSItemTags.SKULL_TOOL_MATERIALS).add(ItemIds.BONE);
      builder(Tags.BSItemTags.QUARTZ_TOOL_MATERIALS).add(ItemIds.QUARTZ);
      builder(Tags.BSItemTags.OBSIDIAN_TOOL_MATERIALS).add(BlockItemIds.OBSIDIAN);
      builder(Tags.BSItemTags.ENDER_TOOL_MATERIALS).add(ItemIds.ENDER_EYE);
      builder(Tags.BSItemTags.LIVINGMETAL_TOOL_MATERIALS).add(BSItems.LIVINGMETAL_INGOT.getSecond());
      builder(Tags.BSItemTags.BIOMASS_TOOL_MATERIALS).add(BSItems.BIOMASS.getSecond());
      builder(Tags.BSItemTags.REAPER_TOOL_MATERIALS).add(ItemIds.BONE);
  }
}
