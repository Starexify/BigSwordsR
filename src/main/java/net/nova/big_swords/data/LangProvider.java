package net.nova.big_swords.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LangProvider {
    private static final String OUTPUT_PATH = "src/main/resources/assets/big_swords/lang/en_US.lang";
    private static final Map<String, String> translations = new HashMap<>();

    public static void generateLangFile() {
        // Add your translations
        addItem("giant_wooden_stick", "Giant Wooden Stick");
        addItem("giant_blaze_rod", "Giant Blaze Rod");
        addItem("giant_livingmetal_handle", "Giant Livingmetal Handle");
        translations.put("itemGroup.big_swords", "Big Swords"); // Creative tab name

        writeToFile();
    }

    private static void addItem(String itemName, String translation) {
        translations.put("item.big_swords." + itemName + ".name", translation);
    }

    private static void writeToFile() {
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
