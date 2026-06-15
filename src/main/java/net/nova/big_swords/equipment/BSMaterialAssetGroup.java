package net.nova.big_swords.equipment;

import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;

import java.util.Map;

public interface BSMaterialAssetGroup {
  MaterialAssetGroup LIVINGMETAL = MaterialAssetGroup.create("livingmetal", Map.of(BSEquipmentAssets.LIVINGMETAL, "livingmetal_darker"));
}
