package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nova.big_swords.equipment.BSEquipmentAssets;

import java.util.function.BiConsumer;

public class BSEquipmentModelProvider extends EquipmentAssetProvider {
    public BSEquipmentModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(BSEquipmentAssets.LIVINGMETAL, onlyHumanoid("big_swords:livingmetal"));
        output.accept(BSEquipmentAssets.BIOMASS, onlyHumanoid("big_swords:biomass"));
    }
}
