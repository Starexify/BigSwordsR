package net.nova.big_swords.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSArmorItem extends ArmorItem {
    private final ArmorMaterial material;

    public BSArmorItem(String id, ArmorMaterial armorMaterial, int materialId, int j) {
        super(armorMaterial, materialId, j);
        this.material = armorMaterial;
        this.setTranslationKey(id);
        this.field_6941 = MODID + ":" + id;
    }

    @Override
    public int getEnchantability() {
        return material.method_3305();
    }
}
