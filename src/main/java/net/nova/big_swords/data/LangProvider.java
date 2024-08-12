package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.CreativeTab;
import net.nova.big_swords.item.EnderSmithingTemplate;

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
        addItem(BSItems.GIANT_LIVINGMETAL_HANDLE, "Giant Livingmetal Handle");

        // Livingmetal Stuff
        addItem(BSItems.LIVINGMETAL_INGOT, "Livingmetal Ingot");
        addBlock(BSBlocks.LIVINGMETAL_BLOCK, "Livingmetal Block");
        addItem(BSItems.LIVINGMETAL_HELMET, "Livingmetal Helmet");
        addItem(BSItems.LIVINGMETAL_CHESTPLATE, "Livingmetal Chestplate");
        addItem(BSItems.LIVINGMETAL_LEGGINGS, "Livingmetal Leggings");
        addItem(BSItems.LIVINGMETAL_BOOTS, "Livingmetal Boots");
        addItem(BSItems.LIVINGMETAL_SWORD, "Livingmetal Sword");
        addItem(BSItems.LIVINGMETAL_PICKAXE, "Livingmetal Pickaxe");
        addItem(BSItems.LIVINGMETAL_AXE, "Livingmetal Axe");
        addItem(BSItems.LIVINGMETAL_SHOVEL, "Livingmetal Shovel");
        addItem(BSItems.LIVINGMETAL_HOE, "Livingmetal Hoe");

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
        addItem(BSItems.OBSIDIAN_BIG_SWORD, "Obsidian Big Sword");
        addItem(BSItems.ENDER_BIG_SWORD, "Ender Big Sword");

        // Creative Tab
        add(CreativeTab.BIG_SWORDS_TAB_TITLE, "Big Swords R");

        // Smithing Template
        addItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
        add(EnderSmithingTemplate.ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.getString(), "Add Ender Eye");
        add(EnderSmithingTemplate.ENDER_UPGRADE_APPLIES_TO.getString(), "Ender Equipment");
        add(EnderSmithingTemplate.ENDER_UPGRADE_BASE_SLOT_DESCRIPTION.getString(), "Add obsidian armor, weapon, or tool");
        add(EnderSmithingTemplate.ENDER_UPGRADE_INGREDIENTS.getString(), "Ender Eye");
        add(EnderSmithingTemplate.ENDER_UPGRADE.getString(), "Ender Upgrade");
    }
}
