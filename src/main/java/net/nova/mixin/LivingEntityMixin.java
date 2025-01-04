package net.nova.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.nova.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @ModifyExpressionValue(method = "damage",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;blockedByShield(Lnet/minecraft/entity/damage/DamageSource;)Z"))
    private boolean shieldBlockDamageDisable(boolean original, @Local(argsOnly = true) DamageSource source) {
        LivingEntity self = (LivingEntity) (Object) this;
        ItemStack blockingItem = self.getBlockingItem();

        if (blockingItem != null) {
            boolean isWoodenShield = blockingItem.isOf(BSItems.WOODEN_SHIELD);
            boolean isGildedWoodenShield = blockingItem.isOf(BSItems.GILDED_WOODEN_SHIELD);
            if ((isWoodenShield || isGildedWoodenShield) && source.isIn(DamageTypeTags.IS_FIRE)) {
                return false;
            }
        }
        return original;
    }
}
