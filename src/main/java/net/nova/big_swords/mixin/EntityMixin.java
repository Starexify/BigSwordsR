package net.nova.big_swords.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.nova.big_swords.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    protected abstract boolean shouldTickBlockCollision();

    @Shadow
    public abstract boolean isOnGround();

    @SuppressWarnings("ConstantValue")
    @Inject(method = "tickBlockCollision(Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;)V", at = @At("HEAD"))
    private void onTickBlockCollision(Vec3d lastRenderPos, Vec3d pos, CallbackInfo ci) {

        if ((Object) this instanceof ItemEntity itemEntity && shouldTickBlockCollision() && isOnGround()) {
            if (!itemEntity.getWorld().isClient()) {
                BlockPos blockPos = itemEntity.getSteppingPos();
                BlockState stateBelow = itemEntity.getWorld().getBlockState(blockPos);
                ItemStack stack = itemEntity.getStack();
                if (itemEntity.getMovement().y == 0 && stateBelow.isOf(Blocks.SAND) && stack.isOf(BSItems.SOUL)) {
                    stack.decrement(1);
                    itemEntity.getWorld().playSound(null, blockPos, SoundEvents.BLOCK_SOUL_SAND_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    itemEntity.getWorld().setBlockState(blockPos, Blocks.SOUL_SAND.getDefaultState());
                    if (stack.isEmpty()) {
                        itemEntity.discard();
                    }
                }
            }
        }
    }
}
