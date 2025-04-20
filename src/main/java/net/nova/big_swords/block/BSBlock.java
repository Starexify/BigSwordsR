package net.nova.big_swords.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.nova.big_swords.init.CreativeTab;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlock extends Block {
    public float strengthProperty;
    public BlockSoundGroup soundGroup;
    public String name;

    public BSBlock(Material material, float strength, BlockSoundGroup soundGroup) {
        super(material);
        this.strengthProperty = strength;
        this.soundGroup = soundGroup;
        super.setStrength(strengthProperty);
        super.setBlockSoundGroup(soundGroup);
    }

    public void setBlockName(String name) {
        this.name = name;
    }

    @Override
    protected Block setStrength(float strength) {
        return setStrength(strengthProperty);
    }

    @Override
    protected Block setBlockSoundGroup(BlockSoundGroup blockSoundGroup) {
        return setBlockSoundGroup(soundGroup);
    }
}
