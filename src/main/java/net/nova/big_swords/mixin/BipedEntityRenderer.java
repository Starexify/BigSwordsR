package net.nova.big_swords.mixin;

import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.nova.big_swords.BigSwordsR.MODID;

@Mixin(net.minecraft.client.render.entity.BipedEntityRenderer.class)
public class BipedEntityRenderer {
    @Inject(method = "method_5759", at = @At("HEAD"))
    private static void modifyArmorLayerLocation(ArmorItem armorItem, int i, String string, CallbackInfoReturnable<Identifier> cir) {
        if (armorItem.materialId == 64) {
            // Build texture path using your mod ID
            String texturePath = String.format(
                    MODID + ":textures/models/armor/%s_layer_%d%s.png",
                    "livingmetal",
                    i == 2 ? 2 : 1,
                    string == null ? "" : String.format("_%s", string)
            );

            // Create identifier
            Identifier identifier = new Identifier(texturePath);

            // Return it
            cir.setReturnValue(identifier);
            cir.cancel();
        }
    }
}
