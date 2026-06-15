package net.nova.big_swords.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.nova.big_swords.data.BSTrimMaterials;
import net.nova.big_swords.equipment.BSMaterialAssetGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(ItemModelGenerators.class)
public class ItemModelGeneratorsMixin {
  @Shadow
  @Final
  public static List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIAL_MODELS;

  static {
    TRIM_MATERIAL_MODELS = ImmutableList.<ItemModelGenerators.TrimMaterialData>builder()
        .addAll(TRIM_MATERIAL_MODELS)
        .add(new ItemModelGenerators.TrimMaterialData(BSMaterialAssetGroup.LIVINGMETAL, BSTrimMaterials.LIVINGMETAL))
        .build();
  }
}