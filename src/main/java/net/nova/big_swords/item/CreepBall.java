package net.nova.big_swords.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSBlocks;

public class CreepBall extends Item {
    public CreepBall() {
        super();
    }

    @Override
    public boolean method_3355(ItemStack stack, PlayerEntity player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        Block block = world.getBlock(x, y, z);
        if (block != Blocks.SOULSAND) {
            return super.method_3355(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
        } else {
            world.playSound(x + 0.5, y + 0.5, z + 0.5, "dig.sand", 1.0F, 1.0F);
            if (!player.abilities.creativeMode) stack.count--;
            world.setBlock(x, y, z, BSBlocks.CREEP_BLOCK, 0, 3);
            return true;
        }
    }
}
