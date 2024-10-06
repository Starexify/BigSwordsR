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
    }

    public static class EnchantmentTags {
        public static final TagKey<Enchantment> SCYTHE_EXCLUSIVE = enchantmentTag("exclusive_set/scythe_exclusive");
    }

    public static class EntityTypeTags {
        public static final TagKey<EntityType<?>> SOULLESS = entityTypeTag("soulless");
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
