package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.CreativeTab;

import static net.nova.big_swords.BigSwordsR.MODID;

public class LangProvider extends LanguageProvider {
    public LangProvider(PackOutput output) {
        super(output, MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(BSItems.GIANT_WOODEN_STICK, "Giant Wooden Stick");

        // Big Swords
        addItem(BSItems.WOODEN_BIG_SWORD, "Wooden Big Sword");
        addItem(BSItems.STONE_BIG_SWORD, "Stone Big Sword");
        addItem(BSItems.IRON_BIG_SWORD, "Iron Big Sword");
        addItem(BSItems.GOLDEN_BIG_SWORD, "Golden Big Sword");

        // Creative Tab
        add(CreativeTab.BIG_SWORDS_TAB_TITLE, "Big Swords R");
    }
}
