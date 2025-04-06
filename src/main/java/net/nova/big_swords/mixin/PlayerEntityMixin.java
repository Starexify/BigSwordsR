package net.nova.big_swords.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Player.class)
public abstract class PlayerEntityMixin {
/*    @ModifyArg(method = "damageShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;)V"), index = 0)
    private int getBlockedDamage(int i) {
        ShieldMechanics.blockedDamage.set(i);
        return i;
    }
*/
/*    @Redirect(method = "damageShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean modifyShieldCheck(ItemStack stack, Item item) {
        return stack.getItem() instanceof ShieldItem;
    }*/
}