package net.nova.big_swords.item;

import net.minecraft.item.Item;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItem extends Item {
    private final String texturePath;

    public BSItem(String name) {
        super();
        this.setTranslationKey(name);
        this.texturePath = MODID + ":" + name;
    }

    // sets the texture name
    @Override
    protected String method_6324() {
        return this.texturePath;
    }
}
