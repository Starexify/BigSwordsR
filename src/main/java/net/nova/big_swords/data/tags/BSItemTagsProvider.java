package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagCopyingItemTagProvider;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItemTagsProvider extends BlockTagCopyingItemTagProvider {
  public BSItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> provider) {
    super(output, lookupProvider, provider, MODID);
  }

  @Override
  protected void addTags(HolderLookup.Provider pProvider) {
    tag(Tags.BSItemTags.BIG_SWORDS).add(
        BSItems.WOODEN_BIG_SWORD.getKey(), BSItems.STONE_BIG_SWORD.getKey(), BSItems.COPPER_BIG_SWORD.getKey(), BSItems.IRON_BIG_SWORD.getKey(),
        BSItems.GOLDEN_BIG_SWORD.getKey(), BSItems.DIAMOND_BIG_SWORD.getKey(), BSItems.NETHERITE_BIG_SWORD.getKey(), BSItems.PATCHWORK_BIG_SWORD.getKey(),
        BSItems.SKULL_BIG_SWORD.getKey(), BSItems.QUARTZ_BIG_SWORD.getKey(), BSItems.OBSIDIAN_BIG_SWORD.getKey(), BSItems.ENDER_BIG_SWORD.getKey(),
        BSItems.LIVINGMETAL_BIG_SWORD.getKey(), BSItems.BIOMASS_BIG_SWORD.getKey()
    );

    tag(Tags.BSItemTags.GLAIVES).add(
        BSItems.WOODEN_GLAIVE.getKey(), BSItems.STONE_GLAIVE.getKey(), BSItems.COPPER_GLAIVE.getKey(), BSItems.IRON_GLAIVE.getKey(), BSItems.GOLDEN_GLAIVE.getKey(),
        BSItems.DIAMOND_GLAIVE.getKey(), BSItems.NETHERITE_GLAIVE.getKey(), BSItems.BIOMASS_GLAIVE.getKey(), BSItems.LIVINGMETAL_GLAIVE.getKey()
    );

    tag(Tags.BSItemTags.SCYTHES).add(
        BSItems.WOODEN_SCYTHE.getKey(), BSItems.STONE_SCYTHE.getKey(), BSItems.COPPER_SCYTHE.getKey(), BSItems.IRON_SCYTHE.getKey(), BSItems.GOLDEN_SCYTHE.getKey(),
        BSItems.DIAMOND_SCYTHE.getKey(), BSItems.NETHERITE_SCYTHE.getKey(), BSItems.BIOMASS_SCYTHE.getKey(), BSItems.LIVINGMETAL_SCYTHE.getKey(),
        BSItems.BONE_SCYTHE.getKey(), BSItems.SOUL_REAPER.getKey()
    );

    tag(Tags.BSItemTags.SHIELDS).add(
        BSItems.WOODEN_SHIELD.getKey(), BSItems.GILDED_WOODEN_SHIELD.getKey(), BSItems.STONE_SHIELD.getKey(), BSItems.GILDED_STONE_SHIELD.getKey(),
        BSItems.IRON_SHIELD.getKey(), BSItems.GILDED_IRON_SHIELD.getKey(), BSItems.DIAMOND_SHIELD.getKey(), BSItems.GILDED_DIAMOND_SHIELD.getKey(),
        BSItems.NETHERITE_SHIELD.getKey(), BSItems.GILDED_NETHERITE_SHIELD.getKey(), BSItems.ENDER_SHIELD.getKey(), BSItems.GILDED_ENDER_SHIELD.getKey(),
        BSItems.QUARTZ_SHIELD.getKey(), BSItems.GILDED_QUARTZ_SHIELD.getKey(), BSItems.PATCHWORK_SHIELD.getKey(), BSItems.GILDED_PATCHWORK_SHIELD.getKey(),
        BSItems.SKULL_SHIELD.getKey(), BSItems.GILDED_SKULL_SHIELD.getKey(), BSItems.BIOMASS_SHIELD.getKey(), BSItems.GILDED_BIOMASS_SHIELD.getKey(),
        BSItems.LIVINGMETAL_SHIELD.getKey(), BSItems.GILDED_LIVINGMETAL_SHIELD.getKey()
    );

    tag(ItemTags.HEAD_ARMOR).add(BSItems.LIVINGMETAL_HELMET.getKey(), BSItems.BIOMASS_HELMET.getKey());
    tag(ItemTags.CHEST_ARMOR).add(BSItems.LIVINGMETAL_CHESTPLATE.getKey(), BSItems.BIOMASS_CHESTPLATE.getKey());
    tag(ItemTags.LEG_ARMOR).add(BSItems.LIVINGMETAL_LEGGINGS.getKey(), BSItems.BIOMASS_LEGGINGS.getKey());
    tag(ItemTags.FOOT_ARMOR).add(BSItems.LIVINGMETAL_BOOTS.getKey(), BSItems.BIOMASS_BOOTS.getKey());

    tag(ItemTags.SWORDS).addTag(Tags.BSItemTags.BIG_SWORDS).add(BSItems.LIVINGMETAL_SWORD.getKey(), BSItems.BIOMASS_SWORD.getKey());
    tag(ItemTags.PICKAXES).add(BSItems.LIVINGMETAL_PICKAXE.getKey(), BSItems.LIVINGMETAL_PICKAXE.getKey());
    tag(ItemTags.AXES).add(BSItems.LIVINGMETAL_AXE.getKey(), BSItems.BIOMASS_AXE.getKey());
    tag(ItemTags.SHOVELS).add(BSItems.LIVINGMETAL_SHOVEL.getKey(), BSItems.BIOMASS_SHOVEL.getKey());
    tag(ItemTags.HOES).addTag(Tags.BSItemTags.SCYTHES).add(BSItems.LIVINGMETAL_HOE.getKey(), BSItems.BIOMASS_HOE.getKey());
    tag(ItemTags.SPEARS).add(BSItems.LIVINGMETAL_SPEAR.getKey(), BSItems.BIOMASS_SPEAR.getKey());

    tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.SHIELDS);

    tag(ItemTags.BREAKS_DECORATED_POTS).addTag(Tags.BSItemTags.GLAIVES);
    tag(ItemTags.WEAPON_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
    tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
    tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);

    tag(ItemTags.TRIM_MATERIALS).add(BSItems.LIVINGMETAL_INGOT.getKey());

    tag(Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR).add(BSItems.LIVINGMETAL_INGOT.getKey());
    tag(Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR).add(BSItems.BIOMASS.getKey());

    tag(Tags.BSItemTags.PATCHWORK_TOOL_MATERIALS).add(ItemIds.ROTTEN_FLESH);
    tag(Tags.BSItemTags.SKULL_TOOL_MATERIALS).add(ItemIds.BONE);
    tag(Tags.BSItemTags.QUARTZ_TOOL_MATERIALS).add(ItemIds.QUARTZ);
    tag(Tags.BSItemTags.OBSIDIAN_TOOL_MATERIALS).add(BlockItemIds.OBSIDIAN.item());
    tag(Tags.BSItemTags.ENDER_TOOL_MATERIALS).add(ItemIds.ENDER_EYE);
    tag(Tags.BSItemTags.LIVINGMETAL_TOOL_MATERIALS).add(BSItems.LIVINGMETAL_INGOT.getKey());
    tag(Tags.BSItemTags.BIOMASS_TOOL_MATERIALS).add(BSItems.BIOMASS.getKey());
    tag(Tags.BSItemTags.REAPER_TOOL_MATERIALS).add(ItemIds.BONE);
  }
}
