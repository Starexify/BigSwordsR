package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.nova.big_swords.BigSwordsR;

import static net.nova.big_swords.BigSwordsR.rl;

public class Tags {
    public static class BSItemTags {
        public static final TagKey<Item> BIG_SWORDS = itemTag("big_swords");
        public static final TagKey<Item> GLAIVES = itemTag("glaives");
        public static final TagKey<Item> SCYTHES = itemTag("scythes");
        public static final TagKey<Item> SHIELDS = itemTag("shields");
    }

    public static class BlockTags {
        public static final TagKey<Block> NEEDS_ENDER_TOOL = blockTag("needs_ender_tool");
    }

    public static class EntityTypeTags {
        public static final TagKey<EntityType<?>> SOULLESS = entityTypeTag("soulless");
        public static final TagKey<EntityType<?>> BLOODLESS = entityTypeTag("bloodless");
        public static final TagKey<EntityType<?>> HALLOWEEN_MOB = entityTypeTag("halloween_mob");
    }

    // Registers
    private static TagKey<Block> blockTag(String pName) {
        return TagKey.create(Registries.BLOCK, BigSwordsR.rl(pName));
    }

    public static TagKey<Item> itemTag(String name) {
        return ItemTags.create(rl(name));
    }

    public static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, rl(name));
    }
}
