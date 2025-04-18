package net.nova.big_swords.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSHoeItem extends HoeItem {
    public BSHoeItem(String id, ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.setTranslationKey(id);
        this.field_6941 = MODID + ":" + id;
    }
}
