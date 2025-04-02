package net.nova.big_swords.block;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class CreepBlock extends Block {
    public static final BooleanProperty TILLED = BooleanProperty.create("tilled");

    public CreepBlock(Properties properties) {
        super(properties);
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
