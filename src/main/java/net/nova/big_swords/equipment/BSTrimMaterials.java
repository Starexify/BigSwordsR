package net.nova.big_swords.equipment;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.nova.big_swords.BigSwordsR;

public class BSTrimMaterials {
  public static ResourceKey<TrimMaterial> LIVINGMETAL = registryKey("livingmetal");

  public static void bootstrap(final BootstrapContext<TrimMaterial> context) {
    register(context, LIVINGMETAL, Style.EMPTY.withColor(TextColor.parseColor("#e0f9ff").getOrThrow()), TrimMaterials.Palette.valueOf("BIG_SWORDS_LIVINGMETAL"));
  }

  public static void register(final BootstrapContext<TrimMaterial> context, final ResourceKey<TrimMaterial> registryKey, final Style hoverTextStyle, final TrimMaterials.Palette palette) {
    Component description = Component.translatable(Util.makeDescriptionId("trim_material", registryKey.identifier())).withStyle(hoverTextStyle);
    context.register(registryKey, new TrimMaterial(palette.id(), description));
  }

  public static ResourceKey<TrimMaterial> registryKey(final String id) {
    return ResourceKey.create(Registries.TRIM_MATERIAL, BigSwordsR.rl(id));
  }
}
