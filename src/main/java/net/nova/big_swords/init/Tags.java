package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

import static net.nova.big_swords.BigSwordsR.rl;

public class Tags {
    public static class BSItemTags {
        public static final TagKey<Item> BIG_SWORDS = itemTag("big_swords");
        public static final TagKey<Item> GLAIVES = itemTag("glaives");
        public static final TagKey<Item> SCYTHES = itemTag("scythes");
        public static final TagKey<Item> SHIELDS = itemTag("shields");
    }

    public static class EntityTypeTags {
        public static final TagKey<EntityType<?>> SOULLESS = entityTypeTag("soulless");
        public static final TagKey<EntityType<?>> HALLOWEEN_MOB = entityTypeTag("halloween_mob");
    }

    // Registers
    private static TagKey<Item> itemTag(String name) {
        return ItemTags.create(rl(name));
    }

    private static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, rl(name));
    }
}
