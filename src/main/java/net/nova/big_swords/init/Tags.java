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
    private static TagKey<Item> itemTag(String name) {
        return ItemTags.create(BigSwordsR.rl(name));
    }

    private static TagKey<Enchantment> enchantmentTag(String name) {
        return TagKey.create(Registries.ENCHANTMENT, BigSwordsR.rl(name));
    }

    private static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, BigSwordsR.rl(name));
    }
}
