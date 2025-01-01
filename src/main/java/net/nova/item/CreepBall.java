package net.nova.item;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nova.init.BSBlocks;

public class CreepBall extends Item {
    public CreepBall(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockpos = context.getBlockPos();
        World level = context.getWorld();

        if (!level.getBlockState(blockpos).isOf(Blocks.SOUL_SAND)) {
            return super.useOnBlock(context);
        } else {
            level.playSound(null, blockpos, SoundEvents.BLOCK_SOUL_SAND_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
            context.getStack().decrement(1);
            level.setBlockState(blockpos, BSBlocks.CREEP_BLOCK.getDefaultState());

            return ActionResult.SUCCESS;
        }
    }
}
