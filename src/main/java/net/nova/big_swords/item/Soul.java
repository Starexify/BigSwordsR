package net.nova.big_swords.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Soul extends Item {
    public Soul(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        Level level = entity.level();
        if (!level.isClientSide()) {
            BlockPos pos = entity.blockPosition();
            BlockState stateBelow = level.getBlockState(pos.below());

            if (entity.getDeltaMovement().y() == 0 && stateBelow.is(Blocks.SAND)) {

                level.setBlock(pos.below(), Blocks.SOUL_SAND.defaultBlockState(), 3);
                level.playSound(null, pos.below(), SoundEvents.SOUL_SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

                stack.shrink(1);

                if (stack.isEmpty()) {
                    entity.discard();
                    return super.onEntityItemUpdate(stack, entity);
                }
            }
        }

        return super.onEntityItemUpdate(stack, entity);
    }
}
