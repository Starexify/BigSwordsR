package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.nova.big_swords.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ArmorMaterial.class)
public abstract class ArmorMaterialMixin {
    @ModifyReturnValue(method = "method_6339", at = @At("RETURN"))
    private Item modifyRepairItem(Item original) {
        if ((Object) this == ArmorMaterial.valueOf("LIVINGMETAL")) return BSItems.LIVINGMETAL_INGOT;
        if ((Object) this == ArmorMaterial.valueOf("BIOMASS")) return BSItems.BIOMASS;
        return original;
    }
}
