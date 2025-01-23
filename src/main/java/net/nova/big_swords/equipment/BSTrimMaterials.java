package net.nova.big_swords.equipment;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Util;
import net.nova.big_swords.BigSwordsR;

import java.util.concurrent.CompletableFuture;

public class BSTrimMaterials extends FabricDynamicRegistryProvider {
    public static RegistryKey<ArmorTrimMaterial> LIVINGMETAL = of("livingmetal");

    public BSTrimMaterials(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        register(entries, LIVINGMETAL, Style.EMPTY.withColor(TextColor.parse("#e0f9ff").getOrThrow()), BSArmorTrimAssets.LIVINGMETAL);
    }

    private static void register(Entries entries, RegistryKey<ArmorTrimMaterial> key, Style style, ArmorTrimAssets armorTrimAssets) {
        Text text = Text.translatable(Util.createTranslationKey("trim_material", key.getValue())).fillStyle(style);
        entries.add(key, new ArmorTrimMaterial(armorTrimAssets, text));
    }

    private static RegistryKey<ArmorTrimMaterial> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, BigSwordsR.rl(id));
    }

    @Override
    public String getName() {
        return "BSR TrimMaterialGenerator";
    }
}
