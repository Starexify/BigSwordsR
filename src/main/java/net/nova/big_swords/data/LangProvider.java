package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.CreativeTab;
import net.nova.big_swords.init.Sounds;
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

        // Livingmetal Lang
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

        // Biomass Lang
        addItem(BSItems.BIOMASS, "Biomass");
        addItem(BSItems.BIOMASS_HELMET, "Biomass Helmet");
        addItem(BSItems.BIOMASS_CHESTPLATE, "Biomass Chestplate");
        addItem(BSItems.BIOMASS_LEGGINGS, "Biomass Leggings");
        addItem(BSItems.BIOMASS_BOOTS, "Biomass Boots");
        addItem(BSItems.BIOMASS_SWORD, "Biomass Sword");
        addItem(BSItems.BIOMASS_PICKAXE, "Biomass Pickaxe");
        addItem(BSItems.BIOMASS_AXE, "Biomass Axe");
        addItem(BSItems.BIOMASS_SHOVEL, "Biomass Shovel");
        addItem(BSItems.BIOMASS_HOE, "Biomass Hoe");

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
        addItem(BSItems.LIVINGMETAL_BIG_SWORD, "Livingmetal Big Sword");
        addItem(BSItems.BIOMASS_BIG_SWORD, "Biomass Big Sword");

        // Glaives
        addItem(BSItems.WOODEN_GLAIVE, "Wooden Glaive");
        addItem(BSItems.STONE_GLAIVE, "Stone Glaive");
        addItem(BSItems.IRON_GLAIVE, "Iron Glaive");
        addItem(BSItems.GOLDEN_GLAIVE, "Golden Glaive");
        addItem(BSItems.DIAMOND_GLAIVE, "Diamond Glaive");
        addItem(BSItems.NETHERITE_GLAIVE, "Netherite Glaive");
        addItem(BSItems.BIOMASS_GLAIVE, "Biomass Glaive");
        addItem(BSItems.LIVINGMETAL_GLAIVE, "Livingmetal Glaive");

        // Creative Tab
        add(CreativeTab.BIG_SWORDS_TAB_TITLE, "Big Swords R");

        // Smithing Template
        addItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
        add(EnderSmithingTemplate.ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.getString(), "Add Ender Eye");
        add(EnderSmithingTemplate.ENDER_UPGRADE_APPLIES_TO.getString(), "Ender Equipment");
        add(EnderSmithingTemplate.ENDER_UPGRADE_BASE_SLOT_DESCRIPTION.getString(), "Add obsidian armor, weapon, or tool");
        add(EnderSmithingTemplate.ENDER_UPGRADE_INGREDIENTS.getString(), "Ender Eye");
        add(EnderSmithingTemplate.ENDER_UPGRADE.getString(), "Ender Upgrade");

        // Sounds
        add(SoundsProvider.getSubtitle(Sounds.GLAIVE_HIT), "Glaive Hit");
        add(SoundsProvider.getSubtitle(Sounds.GLAIVE_SWING), "Glaive Swing");
    }
}
