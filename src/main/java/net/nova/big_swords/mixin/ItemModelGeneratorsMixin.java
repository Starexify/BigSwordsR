package net.nova.big_swords.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.nova.big_swords.data.BSTrimMaterials;
import net.nova.big_swords.equipment.BSMaterialAssetGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ItemModelGenerators.class)
public class ItemModelGeneratorsMixin {
    @Mutable
    @Shadow
    @Final
    public static List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIAL_MODELS;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void injectAdditionalTrimMaterial(CallbackInfo ci) {
        try {
            TRIM_MATERIAL_MODELS = ImmutableList.<ItemModelGenerators.TrimMaterialData>builder()
                    .addAll(TRIM_MATERIAL_MODELS)
                    .add(new ItemModelGenerators.TrimMaterialData(BSMaterialAssetGroup.LIVINGMETAL, BSTrimMaterials.LIVINGMETAL))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}