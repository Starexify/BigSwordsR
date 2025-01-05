package net.nova.big_swords.init;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.nova.big_swords.equipment.BSEquipmentAssets;

import java.util.EnumMap;

public interface BSArmorMaterial {
    ArmorMaterial LIVINGMETAL = new ArmorMaterial(29, Util.make(new EnumMap(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 5);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5F, 0.0F, Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR, BSEquipmentAssets.LIVINGMETAL);

    ArmorMaterial BIOMASS = new ArmorMaterial(29, Util.make(new EnumMap(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 5);
    }), 14, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR, BSEquipmentAssets.BIOMASS);
}
