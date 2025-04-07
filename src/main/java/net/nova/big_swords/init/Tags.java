package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.nova.big_swords.BigSwordsR;

public class Tags {
    public interface BSItemTags {
        TagKey<Item> BIG_SWORDS = itemTag("big_swords");
        TagKey<Item> GLAIVES = itemTag("glaives");
        TagKey<Item> SCYTHES = itemTag("scythes");
        TagKey<Item> SHIELDS = itemTag("shields");
        TagKey<Item> REPAIRS_LIVINGMETAL_ARMOR = itemTag("repairs_livingmetal_armor");
        TagKey<Item> REPAIRS_BIOMASS_ARMOR = itemTag("repairs_biomass_armor");
        TagKey<Item> PATCHWORK_TOOL_MATERIALS = itemTag("patchwork_tool_materials");
        TagKey<Item> SKULL_TOOL_MATERIALS = itemTag("skull_tool_materials");
        TagKey<Item> QUARTZ_TOOL_MATERIALS = itemTag("quartz_tool_materials");
        TagKey<Item> OBSIDIAN_TOOL_MATERIALS = itemTag("obsidian_tool_materials");
        TagKey<Item> ENDER_TOOL_MATERIALS = itemTag("ender_tool_materials");
        TagKey<Item> LIVINGMETAL_TOOL_MATERIALS = itemTag("livingmetal_tool_materials");
        TagKey<Item> BIOMASS_TOOL_MATERIALS = itemTag("biomass_tool_materials");
        TagKey<Item> REAPER_TOOL_MATERIALS = itemTag("reaper_tool_materials");
    }

    public interface EnchantmentTags {
        TagKey<Enchantment> SCYTHE_EXCLUSIVE = enchantmentTag("exclusive_set/scythe_exclusive");
    }

    public interface EntityTypeTags {
        TagKey<EntityType<?>> SOULLESS = entityTypeTag("soulless");
        TagKey<EntityType<?>> BLOODLESS = entityTypeTag("bloodless");
        TagKey<EntityType<?>> HALLOWEEN_MOB = entityTypeTag("halloween_mob");
    }

    // Registers
    public static TagKey<Item> itemTag(String name) {
        return ItemTags.create(BigSwordsR.rl(name));
    }

    public static TagKey<Enchantment> enchantmentTag(String name) {
        return TagKey.create(Registries.ENCHANTMENT, BigSwordsR.rl(name));
    }

    public static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, BigSwordsR.rl(name));
    }
}
