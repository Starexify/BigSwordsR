package net.nova.big_swords.init;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.nova.big_swords.equipment.BSEquipmentAssets;

import java.util.EnumMap;

public class BSArmorMaterial {
    public static ArmorMaterial LIVINGMETAL = new ArmorMaterial(29, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 3);
        map.put(ArmorType.LEGGINGS, 5);
        map.put(ArmorType.CHESTPLATE, 7);
        map.put(ArmorType.HELMET, 3);
        map.put(ArmorType.BODY, 5);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR, BSEquipmentAssets.LIVINGMETAL);

    public static ArmorMaterial BIOMASS = new ArmorMaterial(29, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 2);
        map.put(ArmorType.LEGGINGS, 5);
        map.put(ArmorType.CHESTPLATE, 7);
        map.put(ArmorType.HELMET, 3);
        map.put(ArmorType.BODY, 5);
    }), 14, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR, BSEquipmentAssets.BIOMASS);
}
