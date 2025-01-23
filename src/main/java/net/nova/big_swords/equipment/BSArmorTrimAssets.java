package net.nova.big_swords.equipment;

import com.google.common.collect.Maps;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.registry.RegistryKey;

import java.util.Map;

public class BSArmorTrimAssets {
    public static ArmorTrimAssets LIVINGMETAL = of("livingmetal", Map.of(BSEquipmentAssets.LIVINGMETAL, "livingmetal_darker"));

    public static ArmorTrimAssets of(String suffix, Map<RegistryKey<EquipmentAsset>, String> overrides) {
        return new ArmorTrimAssets(new ArmorTrimAssets.AssetId(suffix), Map.copyOf(Maps.transformValues(overrides, ArmorTrimAssets.AssetId::new)));
    }
}
