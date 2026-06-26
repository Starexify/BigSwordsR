package net.nova.big_swords.mixin;

import net.minecraft.world.item.component.BlocksAttacks;
import net.nova.big_swords.ShieldMechanics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlocksAttacks.class)
public class BlocksAttacksMixin {
  @ModifyArg(method = "hurtBlockingItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;)V"), index = 0)
  private int getBlockedDamage(int i) {
    ShieldMechanics.blockedDamage.set(i);
    return i;
  }
}
