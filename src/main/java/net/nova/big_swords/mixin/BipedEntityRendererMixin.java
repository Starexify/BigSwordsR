package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.item.ArmorItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.nova.big_swords.BigSwordsR.MODID;

@Mixin(BipedEntityRenderer.class)
public class BipedEntityRendererMixin {
    @Shadow @Final private static String[] field_5195;

    static {
        List<String> armorModelList = new ArrayList<>(Arrays.asList(field_5195));
        armorModelList.add("livingmetal");
        armorModelList.add("biomass");
        field_5195 = armorModelList.toArray(new String[0]);
    }

    @ModifyArg(method = "method_5759", at = @At(value = "INVOKE", target = "Ljava/lang/String;format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;"), index = 0)
    private static String modifyArmorLayerLocation(String format, @Local(argsOnly = true) ArmorItem armorItem) {
        if (armorItem.materialId == 5 || armorItem.materialId == 6) return MODID + ":textures/models/armor/%s_layer_%d%s.png";
        return format;
    }
}
