package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItemTagsProvider extends ItemTagsProvider {
    public BSItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BSBlockTagsProvider provider) {
        super(output, lookupProvider, provider.contentsGetter(), MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(Tags.BSItemTags.BIG_SWORDS).add(
                BSItems.WOODEN_BIG_SWORD.get(), BSItems.STONE_BIG_SWORD.get(), BSItems.IRON_BIG_SWORD.get(), BSItems.GOLDEN_BIG_SWORD.get(),
                BSItems.DIAMOND_BIG_SWORD.get(), BSItems.NETHERITE_BIG_SWORD.get(), BSItems.PATCHWORK_BIG_SWORD.get(), BSItems.SKULL_BIG_SWORD.get(),
                BSItems.QUARTZ_BIG_SWORD.get(), BSItems.OBSIDIAN_BIG_SWORD.get(), BSItems.ENDER_BIG_SWORD.get(), BSItems.LIVINGMETAL_BIG_SWORD.get(),
                BSItems.BIOMASS_BIG_SWORD.get()
        );

        tag(Tags.BSItemTags.GLAIVES).add(
                BSItems.WOODEN_GLAIVE.get(), BSItems.STONE_GLAIVE.get(), BSItems.IRON_GLAIVE.get(), BSItems.GOLDEN_GLAIVE.get(), BSItems.DIAMOND_GLAIVE.get(),
                BSItems.NETHERITE_GLAIVE.get(), BSItems.BIOMASS_GLAIVE.get(), BSItems.LIVINGMETAL_GLAIVE.get()
        );

        tag(Tags.BSItemTags.SCYTHES).add(
                BSItems.WOODEN_SCYTHE.get(), BSItems.STONE_SCYTHE.get(), BSItems.IRON_SCYTHE.get(), BSItems.GOLDEN_SCYTHE.get(), BSItems.DIAMOND_SCYTHE.get(),
                BSItems.NETHERITE_SCYTHE.get(), BSItems.BIOMASS_SCYTHE.get(), BSItems.LIVINGMETAL_SCYTHE.get(), BSItems.BONE_SCYTHE.get(), BSItems.SOUL_REAPER.get()
        );

        tag(Tags.BSItemTags.SHIELDS).add(
                BSItems.WOODEN_SHIELD.get(), BSItems.GILDED_WOODEN_SHIELD.get(), BSItems.STONE_SHIELD.get(), BSItems.GILDED_STONE_SHIELD.get(),
                BSItems.IRON_SHIELD.get(), BSItems.GILDED_IRON_SHIELD.get(), BSItems.DIAMOND_SHIELD.get(), BSItems.GILDED_DIAMOND_SHIELD.get(),
                BSItems.NETHERITE_SHIELD.get(), BSItems.GILDED_NETHERITE_SHIELD.get(), BSItems.ENDER_SHIELD.get(), BSItems.GILDED_ENDER_SHIELD.get(),
                BSItems.QUARTZ_SHIELD.get(), BSItems.GILDED_QUARTZ_SHIELD.get(), BSItems.PATCHWORK_SHIELD.get(), BSItems.GILDED_PATCHWORK_SHIELD.get(),
                BSItems.SKULL_SHIELD.get(), BSItems.GILDED_SKULL_SHIELD.get(), BSItems.BIOMASS_SHIELD.get(), BSItems.GILDED_BIOMASS_SHIELD.get(),
                BSItems.LIVINGMETAL_SHIELD.get(), BSItems.GILDED_LIVINGMETAL_SHIELD.get()
        );

        tag(ItemTags.HEAD_ARMOR).add(BSItems.LIVINGMETAL_HELMET.get(), BSItems.BIOMASS_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(BSItems.LIVINGMETAL_CHESTPLATE.get(), BSItems.BIOMASS_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(BSItems.LIVINGMETAL_LEGGINGS.get(), BSItems.BIOMASS_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(BSItems.LIVINGMETAL_BOOTS.get(), BSItems.BIOMASS_BOOTS.get());

        tag(ItemTags.SWORDS).addTag(Tags.BSItemTags.BIG_SWORDS).add(BSItems.LIVINGMETAL_SWORD.get(), BSItems.BIOMASS_SWORD.get());
        tag(ItemTags.PICKAXES).add(BSItems.LIVINGMETAL_PICKAXE.get(), BSItems.LIVINGMETAL_PICKAXE.get());
        tag(ItemTags.AXES).add(BSItems.LIVINGMETAL_AXE.get(), BSItems.BIOMASS_AXE.get());
        tag(ItemTags.SHOVELS).add(BSItems.LIVINGMETAL_SHOVEL.get(), BSItems.BIOMASS_SHOVEL.get());
        tag(ItemTags.HOES).addTag(Tags.BSItemTags.SCYTHES).add(BSItems.LIVINGMETAL_HOE.get(), BSItems.BIOMASS_HOE.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.SHIELDS);

        tag(ItemTags.BREAKS_DECORATED_POTS).addTag(Tags.BSItemTags.GLAIVES);
        tag(ItemTags.SWORD_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
        tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);

        tag(ItemTags.TRIM_MATERIALS).add(BSItems.LIVINGMETAL_INGOT.get());

        tag(Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR).add(BSItems.LIVINGMETAL_INGOT.get());
        tag(Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR).add(BSItems.BIOMASS.get());

        tag(Tags.BSItemTags.PATCHWORK_TOOL_MATERIALS).add(Items.ROTTEN_FLESH);
        tag(Tags.BSItemTags.SKULL_TOOL_MATERIALS).add(Items.BONE);
        tag(Tags.BSItemTags.QUARTZ_TOOL_MATERIALS).add(Items.QUARTZ);
        tag(Tags.BSItemTags.OBSIDIAN_TOOL_MATERIALS).add(Items.OBSIDIAN);
        tag(Tags.BSItemTags.ENDER_TOOL_MATERIALS).add(Items.ENDER_EYE);
        tag(Tags.BSItemTags.LIVINGMETAL_TOOL_MATERIALS).add(BSItems.LIVINGMETAL_INGOT.get());
        tag(Tags.BSItemTags.BIOMASS_TOOL_MATERIALS).add(BSItems.BIOMASS.get());
        tag(Tags.BSItemTags.REAPER_TOOL_MATERIALS).add(Items.BONE);
    }
}
