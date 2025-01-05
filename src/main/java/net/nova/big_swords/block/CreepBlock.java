package net.nova.big_swords.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CreepBlock extends Block {
    public static final BooleanProperty TILLED = BooleanProperty.of("tilled");

    public CreepBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TILLED, Boolean.valueOf(false)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TILLED);
    }

    public void tillBlock(World level, BlockPos pos, BlockState state) {
        level.setBlockState(pos, state.with(TILLED, true));
    }
}
