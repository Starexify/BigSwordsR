package net.nova.big_swords.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.nova.big_swords.init.CreativeTab;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSArmorItem extends ArmorItem {
    private final ArmorMaterial material;

    public BSArmorItem(String id, ArmorMaterial armorMaterial, int materialId, int j) {
        super(armorMaterial, materialId, j);
        this.material = armorMaterial;
        this.setTranslationKey(id);
        this.field_6941 = MODID + ":" + id;
        this.setItemGroup(CreativeTab.BIG_SWORDS_TAB);
    }

    @Override
    public int getEnchantability() {
        return material.method_3305();
    }
}
