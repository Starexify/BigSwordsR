package net.nova.big_swords.data;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSArmorMaterials;
import net.nova.big_swords.init.BSItems;

import java.util.Map;

public class BSTrimMaterials {
    public static final ResourceKey<TrimMaterial> LIVINGMETAL = createKey("livingmetal");

    public static void bootstrap(BootstapContext<TrimMaterial> pContext) {
        // register(pContext, LIVINGMETAL, BSItems.LIVINGMETAL_INGOT.get(), Style.EMPTY.withColor(16121855), 0.8F);
    }

    // Registers
    private static void register(BootstapContext<TrimMaterial> pContext, ResourceKey<TrimMaterial> pMaterialKey, Item pIngredient, Style pStyle, float pItemModelIndex) {
        register(pContext, pMaterialKey, pIngredient, pStyle, pItemModelIndex, Map.of());
    }

    private static void register(BootstapContext<TrimMaterial> pContext, ResourceKey<TrimMaterial> pMaterialKey, Item pIngredient, Style pStyle, float pItemModelIndex, Map<ArmorMaterials, String> pOverrideArmorMaterials) {
        TrimMaterial trimMaterial = TrimMaterial.create(
                pMaterialKey.location().getPath(),
                pIngredient,
                pItemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", pMaterialKey.location())).withStyle(pStyle),
                pOverrideArmorMaterials
        );
        pContext.register(pMaterialKey, trimMaterial);
    }

    private static ResourceKey<TrimMaterial> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, BigSwordsR.rl(name));
    }
}
