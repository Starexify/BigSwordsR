package net.nova.big_swords.equipment;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.nova.big_swords.BigSwordsR;

public interface BSEquipmentAssets {
    ResourceKey<EquipmentAsset> LIVINGMETAL = EquipmentAssets.createId("livingmetal");
    ResourceKey<EquipmentAsset> BIOMASS = EquipmentAssets.createId("biomass");
}
