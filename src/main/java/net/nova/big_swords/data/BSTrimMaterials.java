package net.nova.big_swords.data;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSMaterialAssetGroup;

public class BSTrimMaterials {
    public static final ResourceKey<TrimMaterial> LIVINGMETAL = createKey("livingmetal");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, LIVINGMETAL, Style.EMPTY.withColor(TextColor.parseColor("#e0f9ff").getOrThrow()), BSMaterialAssetGroup.LIVINGMETAL);
    }

    // Registers
    public static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> materialKey, Style style, MaterialAssetGroup overrideArmorMaterials) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", materialKey.location())).withStyle(style);
        context.register(materialKey, new TrimMaterial(overrideArmorMaterials, component));
    }

    public static ResourceKey<TrimMaterial> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, BigSwordsR.rl(name));
    }
}
