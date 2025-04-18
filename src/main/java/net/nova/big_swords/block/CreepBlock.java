package net.nova.big_swords.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Texture;
import net.minecraft.client.TextureRegistry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class CreepBlock extends BSBlock {
    private Texture tilledTexture;
    private Texture untilledTexture;

    public CreepBlock(Material material, float strength, BlockSoundGroup soundGroup) {
        super(material, strength, soundGroup);
    }

    @Override
    public Texture getTexture(int side, int blockData) {
        if (side == 1) {
            return this.untilledTexture;
        } else {
            return side == 0 ? Blocks.SOULSAND.getSideTexture(side) : this.side;
        }
    }

    @Override
    public Texture method_4794(BlockView blockView, int i, int j, int k, int l) {
        if (l == 1) {
            return this.untilledTexture;
        } else if (l == 0) {
            return Blocks.SOULSAND.getSideTexture(l);
        } else {
            return this.side;
        }
    }

    @Override
    public void registerTextures(TextureRegistry registry) {
        this.tilledTexture = registry.registerTexture(getTextureName() + "_tilled");
        this.untilledTexture = registry.registerTexture(getTextureName());
    }
}
