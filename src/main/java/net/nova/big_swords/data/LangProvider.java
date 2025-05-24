package net.nova.big_swords.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static net.nova.big_swords.BigSwordsR.MODID;

public class LangProvider {
    private static final String OUTPUT_PATH = "src/main/resources/assets/big_swords/lang/en_US.lang";
    private static final Map<String, String> translations = new HashMap<>();

    public static void generateLangFile() {
        translations.clear();

        // Items
        addItem("giant_wooden_stick", "Giant Wooden Stick");
        addItem("giant_blaze_rod", "Giant Blaze Rod");
        addItem("giant_livingmetal_handle", "Giant Livingmetal Handle");

        // Extra Stuff
        addBlock("creep_block", "Creep Block");
        addItem("creep_ball", "Creep Ball");
        addItem("biomass_seed", "Biomass Seeds");
        addItem("soul", "Soul");
        addItem("blood_vial", "Blood Vial");

        // Livingmetal Lang
        addItem("livingmetal_ingot", "Livingmetal Ingot");
        addBlock("livingmetal_block", "Livingmetal Block");
        addItem("livingmetal_helmet", "Livingmetal Helmet");
        addItem("livingmetal_chestplate", "Livingmetal Chestplate");
        addItem("livingmetal_leggings", "Livingmetal Leggings");
        addItem("livingmetal_boots", "Livingmetal Boots");
        addItem("livingmetal_sword", "Livingmetal Sword");
        addItem("livingmetal_pickaxe", "Livingmetal Pickaxe");
        addItem("livingmetal_axe", "Livingmetal Axe");
        addItem("livingmetal_shovel", "Livingmetal Shovel");
        addItem("livingmetal_hoe", "Livingmetal Hoe");

        // Biomass Lang
        addItem("biomass", "Biomass");
        addBlock("biomass_block", "Biomass Block");
        addItem("biomass_helmet", "Biomass Helmet");
        addItem("biomass_chestplate", "Biomass Chestplate");
        addItem("biomass_leggings", "Biomass Leggings");
        addItem("biomass_boots", "Biomass Boots");
        addItem("biomass_sword", "Biomass Sword");
        addItem("biomass_pickaxe", "Biomass Pickaxe");
        addItem("biomass_axe", "Biomass Axe");
        addItem("biomass_shovel", "Biomass Shovel");
        addItem("biomass_hoe", "Biomass Hoe");

        // Big Swords
        addItem("wooden_big_sword", "Wooden Big Sword");
        addItem("stone_big_sword", "Stone Big Sword");
        addItem("iron_big_sword", "Iron Big Sword");
        addItem("golden_big_sword", "Golden Big Sword");
        addItem("diamond_big_sword", "Diamond Big Sword");
        addItem("obsidian_big_sword", "Obsidian Big Sword");
        addItem("ender_big_sword", "Ender Big Sword");
        addItem("livingmetal_big_sword", "Livingmetal Big Sword");
        addItem("biomass_big_sword", "Biomass Big Sword");
        addItem("quartz_big_sword", "Quartz Big Sword");
        addItem("skull_big_sword", "Skull Big Sword");
        addItem("patchwork_big_sword", "Patchwork Big Sword");

        // Glaives
        addItem("wooden_glaive", "Wooden Glaive");
        addItem("stone_glaive", "Stone Glaive");
        addItem("iron_glaive", "Iron Glaive");
        addItem("golden_glaive", "Golden Glaive");
        addItem("diamond_glaive", "Diamond Glaive");
        addItem("biomass_glaive", "Biomass Glaive");
        addItem("livingmetal_glaive", "Livingmetal Glaive");

        // Creative Tab
        translations.put("itemGroup.big_swords.big_swords", "Big Swords");

        // Attributes
        translations.put("attribute.name.min_charged_damage", "Min Charged Damage");
        translations.put("attribute.name.max_charged_damage", "Max Charged Damage");

        writeToFile();
    }

    public static void addItem(String itemId, String translation) {
        translations.put("item." + MODID + "." + itemId + ".name", translation);
    }

    public static void addBlock(String blockId, String translation) {
        translations.put("tile." + MODID + "." + blockId + ".name", translation);
    }

    public static void writeToFile() {
        try {
            // Create directories if they don't exist
            File file = new File(OUTPUT_PATH);
            file.getParentFile().mkdirs();

            // Write translations
            FileWriter writer = new FileWriter(file);
            for (Map.Entry<String, String> entry : translations.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            writer.close();

            System.out.println("Successfully generated en_US language file at " + OUTPUT_PATH);
        } catch (IOException e) {
            System.err.println("Failed to generate language file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateLangFile();
    }
}
