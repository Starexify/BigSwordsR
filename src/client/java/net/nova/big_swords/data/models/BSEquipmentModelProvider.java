package net.nova.big_swords.data.models;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSEquipmentAssets;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class BSEquipmentModelProvider implements DataProvider {
    public final FabricDataOutput output;
    public final DataOutput.PathResolver pathResolver;

    public BSEquipmentModelProvider(FabricDataOutput output) {
        this.output = output;
        this.pathResolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "equipment");
    }

    public static void bootstrap(BiConsumer<RegistryKey<EquipmentAsset>, EquipmentModel> consumer) {
        consumer.accept(BSEquipmentAssets.LIVINGMETAL, createHumanoidOnlyModel("livingmetal"));
        consumer.accept(BSEquipmentAssets.BIOMASS, createHumanoidOnlyModel("biomass"));
    }

    public static EquipmentModel createHumanoidOnlyModel(String id) {
        return EquipmentModel.builder().addHumanoidLayers(BigSwordsR.rl(id)).build();
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Map<RegistryKey<EquipmentAsset>, EquipmentModel> map = new HashMap();
        bootstrap((key, model) -> {
            if (map.putIfAbsent(key, model) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + key);
            }
        });
        return DataProvider.writeAllToPath(writer, EquipmentModel.CODEC, this.pathResolver::resolveJson, map);
    }

    @Override
    public String getName() {
        return "BSR Equipment Model Generator";
    }
}
