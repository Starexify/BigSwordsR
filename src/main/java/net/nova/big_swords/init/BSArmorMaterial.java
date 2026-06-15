package net.nova.big_swords.init;

import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.nova.big_swords.equipment.BSEquipmentAssets;

import java.util.Map;

public interface BSArmorMaterial {
  ArmorMaterial LIVINGMETAL = new ArmorMaterial(
      29, makeDefense(3, 5, 7, 3, 5), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR, BSEquipmentAssets.LIVINGMETAL
  );

  ArmorMaterial BIOMASS = new ArmorMaterial(
      29, makeDefense(2, 5,7,3,5), 14, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR, BSEquipmentAssets.BIOMASS
  );

  private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
    return Maps.newEnumMap(
        Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
    );
  }
}
