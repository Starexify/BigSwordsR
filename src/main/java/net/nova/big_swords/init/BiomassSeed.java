package net.nova.big_swords.init;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BiomassSeed extends Item {
    private Block crop;
    private Block soil;

    public BiomassSeed(Block crop, Block soil) {
        super();
        this.crop = crop;
        this.soil = soil;
    }

    @Override
    public boolean method_3355(ItemStack itemStack, PlayerEntity playerEntity, World world, int i, int j, int k, int l, float f, float g, float h) {
        return super.method_3355(itemStack, playerEntity, world, i, j, k, l, f, g, h);
    }
}
