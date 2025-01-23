package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.nova.big_swords.item.ScytheItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HoeItem.class)
public abstract class HoeItemMixin {
    @WrapOperation(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;hoe(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/item/Item$Settings;"))
    private static Item.Settings scytheInit(Item.Settings instance, ToolMaterial toolMaterial, float f, float g, Operation<Item.Settings> original) {
        if (ScytheItem.isScythe.get()) {
            ScytheItem.isScythe.set(false);
            return instance;
        }
        return original.call(instance, toolMaterial, f, g);
    }
}
