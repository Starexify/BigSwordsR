package net.nova.big_swords.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlockItem extends BlockItem {
    public BSBlockItem(String id, Block block) {
        super(block);
        this.setTranslationKey(id);
        this.field_6941 = MODID + ":" + id;
    }

    @Override
    public int method_5463() {
        return 0;
    }
}
