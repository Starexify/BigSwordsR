package net.nova.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.nova.ShieldMechanics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @ModifyArg(method = "damageShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;)V"), index = 0)
    private int getBlockedDamage(int i) {
        ShieldMechanics.blockedDamage.set(i);
        return i;
    }
}