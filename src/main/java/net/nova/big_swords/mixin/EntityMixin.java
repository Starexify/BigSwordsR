package net.nova.big_swords.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.nova.big_swords.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow
    protected abstract boolean isAffectedByBlocks();

    @Shadow
    public abstract boolean onGround();

    @SuppressWarnings("ConstantValue")
    @Inject(method = "applyEffectsFromBlocks(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V", at = @At("HEAD"))
    private void onTickBlockCollision(Vec3 lastRenderPos, Vec3 pos, CallbackInfo ci) {
        if ((Object) this instanceof ItemEntity itemEntity && isAffectedByBlocks() && onGround()) {
            if (!itemEntity.level().isClientSide) {
                BlockPos blockPos = itemEntity.getOnPos();
                BlockState stateBelow = itemEntity.level().getBlockState(blockPos);
                ItemStack stack = itemEntity.getItem();
                if (itemEntity.getKnownMovement().y == 0 && stateBelow.is(Blocks.SAND) && stack.is(BSItems.SOUL)) {
                    stack.shrink(1);
                    itemEntity.level().playSound(null, blockPos, SoundEvents.SOUL_SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    itemEntity.level().setBlockAndUpdate(blockPos, Blocks.SOUL_SAND.defaultBlockState());
                    if (stack.isEmpty()) itemEntity.discard();
                }
            }
        }
    }
}
