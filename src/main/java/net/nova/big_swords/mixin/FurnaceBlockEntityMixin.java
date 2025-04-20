package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.nova.big_swords.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FurnaceBlockEntity.class)
public abstract class FurnaceBlockEntityMixin {
    @ModifyReturnValue(method = "getBurnTime", at = @At("RETURN"))
    private static int modifyFuelValues(int original, @Local(argsOnly = true) ItemStack stack) {
        if (stack != null) {
            if (stack.getItem() == BSItems.GIANT_WOODEN_STICK) return 700;
            else if (stack.getItem() == BSItems.GIANT_BLAZE_ROD) return 16800;
        }
        return original;
    }
}
