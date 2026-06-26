package net.nova.big_swords.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.nova.big_swords.init.BSDataComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
  @Shadow
  public abstract ItemStack getItem();

  @Inject(method = "tick", at = @At(value = "HEAD"))
  private void big_swords$degradeUnderwater(CallbackInfo ci) {
    ItemEntity self = (ItemEntity) (Object) this;
    if (!(self.level() instanceof ServerLevel serverLevel)) return;
    ItemStack stack = this.getItem();
    if (stack.isEmpty()) return;
    if (self.isInWater() && self.getFluidHeight(FluidTags.WATER) > 0.1D) {
      if (stack.isDamageableItem() && stack.has(BSDataComponents.DEGRADES_UNDERWATER)) {
        stack.hurtAndBreak(1, serverLevel, null, brokenItem -> self.discard());
      }
    }
  }
}