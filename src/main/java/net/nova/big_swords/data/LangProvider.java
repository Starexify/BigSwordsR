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
        /*translationBuilder.add(BSItems.LIVINGMETAL_HELMET, "Livingmetal Helmet");
        translationBuilder.add(BSItems.LIVINGMETAL_CHESTPLATE, "Livingmetal Chestplate");
        translationBuilder.add(BSItems.LIVINGMETAL_LEGGINGS, "Livingmetal Leggings");
        translationBuilder.add(BSItems.LIVINGMETAL_BOOTS, "Livingmetal Boots");
        translationBuilder.add(BSItems.LIVINGMETAL_SWORD, "Livingmetal Sword");
        translationBuilder.add(BSItems.LIVINGMETAL_PICKAXE, "Livingmetal Pickaxe");
        translationBuilder.add(BSItems.LIVINGMETAL_AXE, "Livingmetal Axe");
        translationBuilder.add(BSItems.LIVINGMETAL_SHOVEL, "Livingmetal Shovel");
        translationBuilder.add(BSItems.LIVINGMETAL_HOE, "Livingmetal Hoe");*/

        // Biomass Lang
        //translationBuilder.add(BSItems.BIOMASS, "Biomass");
        addBlock("biomass_block", "Biomass Block");
/*        translationBuilder.add(BSItems.BIOMASS_HELMET, "Biomass Helmet");
        translationBuilder.add(BSItems.BIOMASS_CHESTPLATE, "Biomass Chestplate");
        translationBuilder.add(BSItems.BIOMASS_LEGGINGS, "Biomass Leggings");
        translationBuilder.add(BSItems.BIOMASS_BOOTS, "Biomass Boots");
        translationBuilder.add(BSItems.BIOMASS_SWORD, "Biomass Sword");
        translationBuilder.add(BSItems.BIOMASS_PICKAXE, "Biomass Pickaxe");
        translationBuilder.add(BSItems.BIOMASS_AXE, "Biomass Axe");
        translationBuilder.add(BSItems.BIOMASS_SHOVEL, "Biomass Shovel");
        translationBuilder.add(BSItems.BIOMASS_HOE, "Biomass Hoe");*/

        // Creative Tab
        translations.put("itemGroup.big_swords.big_swords", "Big Swords");

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
