package net.nova.big_swords.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class CreepBlock extends Block {
    public static final BooleanProperty TILLED = BooleanProperty.create("tilled");

    public CreepBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TILLED, Boolean.valueOf(false)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TILLED);
    }

    public void tillBlock(Level level, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(TILLED, true), 2);
    }
}
