package net.nova.big_swords.equipment;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.nova.big_swords.BigSwordsR;

public interface BSEquipmentAssets {
    ResourceKey<EquipmentAsset> LIVINGMETAL = register("livingmetal");
    ResourceKey<EquipmentAsset> BIOMASS = register("biomass");

    static ResourceKey<EquipmentAsset> register(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, BigSwordsR.rl(name));
    }
}
