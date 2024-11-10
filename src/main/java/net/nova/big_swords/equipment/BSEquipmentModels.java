package net.nova.big_swords.equipment;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentModel;
import net.nova.big_swords.BigSwordsR;

import java.util.function.BiConsumer;

public interface BSEquipmentModels {
    ResourceLocation LIVINGMETAL = BigSwordsR.rl("livingmetal");
    ResourceLocation BIOMASS = BigSwordsR.rl("biomass");

    static void bootstrap(BiConsumer<ResourceLocation, EquipmentModel> registry) {
        registry.accept(LIVINGMETAL, onlyHumanoid("livingmetal"));
        registry.accept(BIOMASS, onlyHumanoid("biomass"));
    }

    static EquipmentModel onlyHumanoid(String armorId) {
        return EquipmentModel.builder().addHumanoidLayers(BigSwordsR.rl(armorId)).build();
    }
}
