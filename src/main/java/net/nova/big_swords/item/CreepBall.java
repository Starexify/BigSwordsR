package net.nova.big_swords.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.nova.big_swords.init.BSBlocks;

public class CreepBall extends Item {
    public CreepBall(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        if (!level.getBlockState(blockpos).is(Blocks.SOUL_SAND)) {
            return super.useOn(pContext);
        } else {
            level.playSound(null, blockpos, SoundEvents.SOUL_SAND_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
            Player player = pContext.getPlayer();
            ItemStack itemstack = pContext.getItemInHand();

            if (!player.isCreative()) {
                itemstack.shrink(1);
            }
            level.setBlock(blockpos, BSBlocks.CREEP_BLOCK.get().defaultBlockState(), 3);

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }
}
