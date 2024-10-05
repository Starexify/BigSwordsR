package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
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

        // Extra Stuff
        addBlock(BSBlocks.CREEP_BLOCK, "Creep Block");
        addItem(BSItems.CREEP_BALL, "Creep Ball");
        addItem(BSItems.BIOMASS_SEED, "Biomass Seed");
        addItem(BSItems.SOUL, "Soul");

        // Livingmetal Lang
        addItem(BSItems.LIVINGMETAL_INGOT, "Livingmetal Ingot");
        addBlock(BSBlocks.LIVINGMETAL_BLOCK, "Livingmetal Block");
        addItem(BSItems.LIVINGMETAL_HELMET, "Livingmetal Helmet");
        addItem(BSItems.LIVINGMETAL_CHESTPLATE, "Livingmetal Chestplate");
        addItem(BSItems.LIVINGMETAL_LEGGINGS, "Livingmetal Leggings");
        addItem(BSItems.LIVINGMETAL_BOOTS, "Livingmetal Boots");

        // Biomass Lang
        addItem(BSItems.BIOMASS, "Biomass");
        addBlock(BSBlocks.BIOMASS_BLOCK, "Biomass Block");
        addItem(BSItems.BIOMASS_HELMET, "Biomass Helmet");
        addItem(BSItems.BIOMASS_CHESTPLATE, "Biomass Chestplate");
        addItem(BSItems.BIOMASS_LEGGINGS, "Biomass Leggings");
        addItem(BSItems.BIOMASS_BOOTS, "Biomass Boots");

        // Smithing Template
        addItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
        add(EnderSmithingTemplate.ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.getString(), "Add Ender Eye");
        add(EnderSmithingTemplate.ENDER_UPGRADE_APPLIES_TO.getString(), "Ender Equipment");
        add(EnderSmithingTemplate.ENDER_UPGRADE_BASE_SLOT_DESCRIPTION.getString(), "Add obsidian armor, weapon, or tool");
        add(EnderSmithingTemplate.ENDER_UPGRADE_INGREDIENTS.getString(), "Ender Eye");
        add(EnderSmithingTemplate.ENDER_UPGRADE.getString(), "Ender Upgrade");

    }
}
