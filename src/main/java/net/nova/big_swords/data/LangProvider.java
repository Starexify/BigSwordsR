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
        addItem(BSItems.GIANT_BLAZE_ROD, "Giant Blaze Rod");

        // Big Swords
        addItem(BSItems.WOODEN_BIG_SWORD, "Wooden Big Sword");
        addItem(BSItems.STONE_BIG_SWORD, "Stone Big Sword");
        addItem(BSItems.IRON_BIG_SWORD, "Iron Big Sword");
        addItem(BSItems.GOLDEN_BIG_SWORD, "Golden Big Sword");
        addItem(BSItems.DIAMOND_BIG_SWORD, "Diamond Big Sword");
        addItem(BSItems.NETHERITE_BIG_SWORD, "Netherite Big Sword");
        addItem(BSItems.PATCHWORK_BIG_SWORD, "Patchwork Big Sword");
        addItem(BSItems.SKULL_BIG_SWORD, "Skull Big Sword");
        addItem(BSItems.QUARTZ_BIG_SWORD, "Quartz Big Sword");

        // Creative Tab
        add(CreativeTab.BIG_SWORDS_TAB_TITLE, "Big Swords R");
    }
}
