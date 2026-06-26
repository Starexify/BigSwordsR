package net.nova.big_swords.equipment;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.nova.big_swords.BigSwordsR;

import java.util.concurrent.CompletableFuture;

public class BSTrimMaterials extends FabricDynamicRegistryProvider {
    public static ResourceKey<TrimMaterial> LIVINGMETAL = of("livingmetal");

    public BSTrimMaterials(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries context) {
        register(context, LIVINGMETAL, Style.EMPTY.withColor(TextColor.parseColor("#e0f9ff").getOrThrow()), BSMaterialAssetGroup.LIVINGMETAL);
    }

    public static void register(Entries context, ResourceKey<TrimMaterial> materialKey, Style style, MaterialAssetGroup overrideArmorMaterials) {
        context.add(materialKey, new TrimMaterial(overrideArmorMaterials, Component.translatable(Util.makeDescriptionId("trim_material", materialKey.identifier())).withStyle(style)));
    }

    private static ResourceKey<TrimMaterial> of(String id) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, BigSwordsR.rl(id));
    }

    @Override
    public String getName() {
        return "BSR TrimMaterialGenerator";
    }
}
