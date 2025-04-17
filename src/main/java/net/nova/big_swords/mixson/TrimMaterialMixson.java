package net.nova.big_swords.mixson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.nova.big_swords.equipment.BSMaterialAssetGroup;
import net.ramixin.mixson.inline.Mixson;

import static net.nova.big_swords.BigSwordsR.MODID;

public class TrimMaterialMixson {

    public static void registerMixsons() {
        for (Item item : BuiltInRegistries.ITEM) {
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            if (itemId.getNamespace().equals(MODID)) continue;
            if (!item.components().has(DataComponents.EQUIPPABLE)) continue;
            EquipmentSlot slot = item.components().get(DataComponents.EQUIPPABLE).slot();
            if (slot != EquipmentSlot.HEAD && slot != EquipmentSlot.CHEST && slot != EquipmentSlot.LEGS && slot != EquipmentSlot.FEET)
                continue;
            if (!item.components().get(DataComponents.EQUIPPABLE).assetId().isPresent()) continue;

            String clientItemLocation = "items/" + BuiltInRegistries.ITEM.getKey(item).getPath();
            ResourceLocation trimModelName = ModelLocationUtils.getModelLocation(item).withSuffix("_" + BSMaterialAssetGroup.LIVINGMETAL.base().suffix() + "_trim");

            Mixson.registerEvent(1, clientItemLocation, "Add livingmetal trim for " + clientItemLocation,
                    context -> {
                        try {
                            JsonObject json = context.getFile().getAsJsonObject();
                            JsonObject model = json.getAsJsonObject("model");
                            JsonArray cases = model.getAsJsonArray("cases");

                            JsonObject newCase = new JsonObject();
                            JsonObject newModel = new JsonObject();
                            newModel.addProperty("type", "minecraft:model");
                            newModel.addProperty("model", trimModelName.getPath());
                            newCase.add("model", newModel);
                            newCase.addProperty("when", MODID + ":livingmetal");

                            cases.add(newCase);
                        } catch (Exception e) {
                            System.err.println("Failed to process " + clientItemLocation + ": " + e.getMessage());
                        }
                    }
            );
        }
    }
}
