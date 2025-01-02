package net.nova.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Util;
import net.nova.BigSwordsR;
import net.nova.equipment.BSEquipmentAssets;
import net.nova.init.BSItems;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BSTrimMaterials extends FabricDynamicRegistryProvider {
    public static RegistryKey<ArmorTrimMaterial> LIVINGMETAL = of("livingmetal");

    public BSTrimMaterials(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        register(entries, LIVINGMETAL, BSItems.LIVINGMETAL_INGOT, Style.EMPTY.withColor(TextColor.parse("#e0f9ff").getOrThrow()), Map.of(BSEquipmentAssets.LIVINGMETAL, "livingmetal_darker"));
    }

    public static void register(Entries entries, RegistryKey<ArmorTrimMaterial> materialKey, Item ingredient, Style style) {
        register(entries, materialKey, ingredient, style, Map.of());
    }

    public static void register(Entries entries, RegistryKey<ArmorTrimMaterial> materialKey, Item ingredient, Style style, Map<RegistryKey<EquipmentAsset>, String> overrideArmorMaterials) {
        ArmorTrimMaterial trimMaterial = ArmorTrimMaterial.of(
                materialKey.getValue().getPath(), ingredient,
                Text.translatable(Util.createTranslationKey("trim_material", materialKey.getValue())).fillStyle(style), overrideArmorMaterials
        );
        entries.add(materialKey, trimMaterial);
    }

    public static RegistryKey<ArmorTrimMaterial> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, BigSwordsR.rl(id));
    }

    @Override
    public String getName() {
        return "BSR TrimMaterialGenerator";
    }
}
