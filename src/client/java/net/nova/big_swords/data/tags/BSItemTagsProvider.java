package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public BSItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(Tags.BSItemTags.BIG_SWORDS).add(
                BSItems.WOODEN_BIG_SWORD, BSItems.STONE_BIG_SWORD, BSItems.IRON_BIG_SWORD, BSItems.GOLDEN_BIG_SWORD,
                BSItems.DIAMOND_BIG_SWORD, BSItems.NETHERITE_BIG_SWORD, BSItems.PATCHWORK_BIG_SWORD, BSItems.SKULL_BIG_SWORD,
                BSItems.QUARTZ_BIG_SWORD, BSItems.OBSIDIAN_BIG_SWORD, BSItems.ENDER_BIG_SWORD, BSItems.LIVINGMETAL_BIG_SWORD,
                BSItems.BIOMASS_BIG_SWORD
        );

        getOrCreateTagBuilder(Tags.BSItemTags.GLAIVES).add(
                BSItems.WOODEN_GLAIVE, BSItems.STONE_GLAIVE, BSItems.IRON_GLAIVE, BSItems.GOLDEN_GLAIVE, BSItems.DIAMOND_GLAIVE,
                BSItems.NETHERITE_GLAIVE, BSItems.BIOMASS_GLAIVE, BSItems.LIVINGMETAL_GLAIVE
        );

        getOrCreateTagBuilder(Tags.BSItemTags.SCYTHES).add(
                BSItems.WOODEN_SCYTHE, BSItems.STONE_SCYTHE, BSItems.IRON_SCYTHE, BSItems.GOLDEN_SCYTHE, BSItems.DIAMOND_SCYTHE,
                BSItems.NETHERITE_SCYTHE, BSItems.BIOMASS_SCYTHE, BSItems.LIVINGMETAL_SCYTHE, BSItems.BONE_SCYTHE, BSItems.SOUL_REAPER
        );

        getOrCreateTagBuilder(Tags.BSItemTags.SHIELDS).add(
                BSItems.WOODEN_SHIELD, BSItems.GILDED_WOODEN_SHIELD, BSItems.STONE_SHIELD, BSItems.GILDED_STONE_SHIELD,
                BSItems.IRON_SHIELD, BSItems.GILDED_IRON_SHIELD, BSItems.DIAMOND_SHIELD, BSItems.GILDED_DIAMOND_SHIELD,
                BSItems.NETHERITE_SHIELD, BSItems.GILDED_NETHERITE_SHIELD, BSItems.ENDER_SHIELD, BSItems.GILDED_ENDER_SHIELD,
                BSItems.QUARTZ_SHIELD, BSItems.GILDED_QUARTZ_SHIELD, BSItems.PATCHWORK_SHIELD, BSItems.GILDED_PATCHWORK_SHIELD,
                BSItems.SKULL_SHIELD, BSItems.GILDED_SKULL_SHIELD, BSItems.BIOMASS_SHIELD, BSItems.GILDED_BIOMASS_SHIELD,
                BSItems.LIVINGMETAL_SHIELD, BSItems.GILDED_LIVINGMETAL_SHIELD
        );

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(BSItems.LIVINGMETAL_HELMET, BSItems.BIOMASS_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(BSItems.LIVINGMETAL_CHESTPLATE, BSItems.BIOMASS_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(BSItems.LIVINGMETAL_LEGGINGS, BSItems.BIOMASS_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(BSItems.LIVINGMETAL_BOOTS, BSItems.BIOMASS_BOOTS);

        getOrCreateTagBuilder(ItemTags.SWORDS).addTag(Tags.BSItemTags.BIG_SWORDS).add(BSItems.LIVINGMETAL_SWORD, BSItems.BIOMASS_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(BSItems.LIVINGMETAL_PICKAXE, BSItems.LIVINGMETAL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(BSItems.LIVINGMETAL_AXE, BSItems.BIOMASS_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(BSItems.LIVINGMETAL_SHOVEL, BSItems.BIOMASS_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).addTag(Tags.BSItemTags.SCYTHES).add(BSItems.LIVINGMETAL_HOE, BSItems.BIOMASS_HOE);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.SHIELDS);

        getOrCreateTagBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(Tags.BSItemTags.GLAIVES);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(Tags.BSItemTags.GLAIVES);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(BSItems.LIVINGMETAL_INGOT);

        getOrCreateTagBuilder(Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR).add(BSItems.LIVINGMETAL_INGOT);
        getOrCreateTagBuilder(Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR).add(BSItems.BIOMASS);

        getOrCreateTagBuilder(Tags.BSItemTags.PATCHWORK_TOOL_MATERIALS).add(Items.ROTTEN_FLESH);
        getOrCreateTagBuilder(Tags.BSItemTags.SKULL_TOOL_MATERIALS).add(Items.BONE);
        getOrCreateTagBuilder(Tags.BSItemTags.QUARTZ_TOOL_MATERIALS).add(Items.QUARTZ);
        getOrCreateTagBuilder(Tags.BSItemTags.OBSIDIAN_TOOL_MATERIALS).add(Items.OBSIDIAN);
        getOrCreateTagBuilder(Tags.BSItemTags.ENDER_TOOL_MATERIALS).add(Items.ENDER_EYE);
        getOrCreateTagBuilder(Tags.BSItemTags.LIVINGMETAL_TOOL_MATERIALS).add(BSItems.LIVINGMETAL_INGOT);
        getOrCreateTagBuilder(Tags.BSItemTags.BIOMASS_TOOL_MATERIALS).add(BSItems.BIOMASS);
        getOrCreateTagBuilder(Tags.BSItemTags.REAPER_TOOL_MATERIALS).add(Items.BONE);
    }
}
