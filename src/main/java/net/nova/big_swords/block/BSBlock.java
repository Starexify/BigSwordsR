package net.nova.big_swords.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BSBlock extends Block {
    public String name;

    public BSBlock(Material material) {
        super(material);
    }

    public void setBlockName(String name) {
        this.name = name;
    }
}
