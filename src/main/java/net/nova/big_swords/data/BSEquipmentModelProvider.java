package net.nova.big_swords.data;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.EquipmentModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentModel;
import net.nova.big_swords.equipment.BSEquipmentModels;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BSEquipmentModelProvider extends EquipmentModelProvider {
    private final PackOutput.PathProvider pathProvider;

    public BSEquipmentModelProvider(PackOutput output) {
        super(output);
        this.pathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models/equipment");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output) {
        Map<ResourceLocation, EquipmentModel> map = new HashMap<>();
        BSEquipmentModels.bootstrap((id, model) -> {
            if (map.putIfAbsent(id, model) != null) {
                throw new IllegalStateException("Tried to register equipment model twice for id: " + id);
            }
        });
        return DataProvider.saveAll(output, EquipmentModel.CODEC, this.pathProvider, map);
    }

    @Override
    public String getName() {
        return "Big Swords Equipment Model Definitions";
    }
}
