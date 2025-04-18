package net.nova.big_swords.item;

import net.minecraft.item.Item;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItem extends Item {
    public BSItem(String id) {
        super();
        this.setTranslationKey(id);
        this.field_6941 = MODID + ":" + id;
    }
}