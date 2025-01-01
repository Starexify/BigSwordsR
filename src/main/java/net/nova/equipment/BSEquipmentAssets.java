package net.nova.equipment;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.nova.BigSwordsR;

public interface BSEquipmentAssets {
    RegistryKey<EquipmentAsset> LIVINGMETAL = register("livingmetal");
    RegistryKey<EquipmentAsset> BIOMASS = register("biomass");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, BigSwordsR.rl(name));
    }
}
