package net.nova.big_swords.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.nova.big_swords.init.BSBlocks;

public class CreepBall extends Item {
  public CreepBall(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult useOn(UseOnContext context) {
    BlockPos blockpos = context.getClickedPos();
    Level level = context.getLevel();

    if (!level.getBlockState(blockpos).is(Blocks.SOUL_SAND)) {
      return super.useOn(context);
    }
    else {
      level.playSound(null, blockpos, SoundEvents.SOUL_SAND_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
      context.getItemInHand().consume(1, context.getPlayer());
      level.setBlock(blockpos, BSBlocks.CREEP_BLOCK.getFirst().value().defaultBlockState(), 3);

      return InteractionResult.SUCCESS;
    }
  }
}
