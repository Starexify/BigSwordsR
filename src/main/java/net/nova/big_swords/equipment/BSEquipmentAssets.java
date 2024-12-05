package net.nova.big_swords.equipment;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.nova.big_swords.BigSwordsR;

public interface BSEquipmentAssets {
    ResourceKey<EquipmentAsset> LIVINGMETAL = createId("livingmetal");
    ResourceKey<EquipmentAsset> BIOMASS = createId("biomass");

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, BigSwordsR.rl(name));
    }
}
