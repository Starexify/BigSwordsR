package net.nova.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.nova.BigSwordsR;

public class Tags {
    public static class BSItemTags {
        public static final TagKey<Item> BIG_SWORDS = itemTag("big_swords");
        public static final TagKey<Item> GLAIVES = itemTag("glaives");
        public static final TagKey<Item> SCYTHES = itemTag("scythes");
        public static final TagKey<Item> SHIELDS = itemTag("shields");
        public static final TagKey<Item> REPAIRS_LIVINGMETAL_ARMOR = itemTag("repairs_livingmetal_armor");
        public static final TagKey<Item> REPAIRS_BIOMASS_ARMOR = itemTag("repairs_biomass_armor");
        public static final TagKey<Item> PATCHWORK_TOOL_MATERIALS = itemTag("patchwork_tool_materials");
        public static final TagKey<Item> SKULL_TOOL_MATERIALS = itemTag("skull_tool_materials");
        public static final TagKey<Item> QUARTZ_TOOL_MATERIALS = itemTag("quartz_tool_materials");
        public static final TagKey<Item> OBSIDIAN_TOOL_MATERIALS = itemTag("obsidian_tool_materials");
        public static final TagKey<Item> ENDER_TOOL_MATERIALS = itemTag("ender_tool_materials");
        public static final TagKey<Item> LIVINGMETAL_TOOL_MATERIALS = itemTag("livingmetal_tool_materials");
        public static final TagKey<Item> BIOMASS_TOOL_MATERIALS = itemTag("biomass_tool_materials");
        public static final TagKey<Item> REAPER_TOOL_MATERIALS = itemTag("reaper_tool_materials");
    }

    public static class EnchantmentTags {
        public static final TagKey<Enchantment> IN_ENCHANTING_TABLE = enchantmentTag("in_enchanting_table");
        public static final TagKey<Enchantment> SCYTHE_EXCLUSIVE = enchantmentTag("exclusive_set/scythe_exclusive");
    }

    public static class EntityTypeTags {
        public static final TagKey<EntityType<?>> SOULLESS = entityTypeTag("soulless");
        public static final TagKey<EntityType<?>> BLOODLESS = entityTypeTag("bloodless");
        public static final TagKey<EntityType<?>> HALLOWEEN_MOB = entityTypeTag("halloween_mob");
    }

    // Registers
    public static TagKey<Item> itemTag(String id) {
        return TagKey.of(RegistryKeys.ITEM, BigSwordsR.rl(id));
    }

    public static TagKey<Enchantment> enchantmentTag(String id) {
        return TagKey.of(RegistryKeys.ENCHANTMENT, BigSwordsR.rl(id));
    }

    public static TagKey<EntityType<?>> entityTypeTag(String id) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, BigSwordsR.rl(id));
    }
}
