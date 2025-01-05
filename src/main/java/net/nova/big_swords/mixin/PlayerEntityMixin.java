package net.nova.big_swords.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.nova.big_swords.ShieldMechanics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @ModifyArg(method = "damageShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;)V"), index = 0)
    private int getBlockedDamage(int i) {
        ShieldMechanics.blockedDamage.set(i);
        return i;
    }

    @Redirect(method = "damageShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean modifyShieldCheck(ItemStack stack, Item item) {
        return stack.getItem() instanceof ShieldItem;
    }
}