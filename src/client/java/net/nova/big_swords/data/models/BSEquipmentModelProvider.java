package net.nova.big_swords.data.models;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSEquipmentAssets;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class BSEquipmentModelProvider implements DataProvider {
    public final FabricDataOutput output;
    public final PackOutput.PathProvider pathProvider;

    public BSEquipmentModelProvider(FabricDataOutput output) {
        this.output = output;
        this.pathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    public static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        consumer.accept(BSEquipmentAssets.LIVINGMETAL, createHumanoidOnlyModel("livingmetal"));
        consumer.accept(BSEquipmentAssets.BIOMASS, createHumanoidOnlyModel("biomass"));
    }

    public static EquipmentClientInfo createHumanoidOnlyModel(String id) {
        return EquipmentClientInfo.builder().addHumanoidLayers(BigSwordsR.rl(id)).build();
    }

    @Override
    public CompletableFuture<?> run(CachedOutput writer) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> map = new HashMap();
        bootstrap((key, model) -> {
            if (map.putIfAbsent(key, model) != null)
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + key);
        });
        return DataProvider.saveAll(writer, EquipmentClientInfo.CODEC, this.pathProvider::json, map);
    }

    @Override
    public String getName() {
        return "BSR Equipment Model Generator";
    }
}
