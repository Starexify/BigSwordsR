package net.nova.big_swords.init;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nova.big_swords.BigSwordsR;

public class Tags {
    public static class BSItemTags {
        public static final TagKey<Item> BIG_SWORDS = itemTag("big_swords");
        public static final TagKey<Item> GLAIVES = itemTag("glaives");
    }

    private static TagKey<Item> itemTag(String name) {
        return ItemTags.create(BigSwordsR.rl(name));
    }
}
