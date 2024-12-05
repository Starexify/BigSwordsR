package net.nova.big_swords.data;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSEquipmentAssets;
import net.nova.big_swords.init.BSItems;

import java.util.Map;

public class BSTrimMaterials {
    public static final ResourceKey<TrimMaterial> LIVINGMETAL = createKey("livingmetal");

    public static void bootstrap(BootstrapContext<TrimMaterial> pContext) {
        register(pContext, LIVINGMETAL, BSItems.LIVINGMETAL_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#e0f9ff").getOrThrow()), Map.of(BSEquipmentAssets.LIVINGMETAL, "livingmetal_darker"));
    }

    // Registers
    public static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> materialKey, Item ingredient, Style style) {
        register(context, materialKey, ingredient, style, Map.of());
    }

    public static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> materialKey, Item ingredient, Style style, Map<ResourceKey<EquipmentAsset>, String> overrideArmorMaterials) {
        TrimMaterial trimmaterial = TrimMaterial.create(materialKey.location().getPath(), ingredient,
                Component.translatable(Util.makeDescriptionId("trim_material", materialKey.location())).withStyle(style),
                overrideArmorMaterials
        );
        context.register(materialKey, trimmaterial);
    }

    public static ResourceKey<TrimMaterial> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, BigSwordsR.rl(name));
    }
}
