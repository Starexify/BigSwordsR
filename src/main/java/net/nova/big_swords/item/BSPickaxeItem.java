package net.nova.big_swords.item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSPickaxeItem extends PickaxeItem {
    public BSPickaxeItem(String id, ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.setTranslationKey(id);
        this.field_6941 = MODID + ":" + id;
    }
}
