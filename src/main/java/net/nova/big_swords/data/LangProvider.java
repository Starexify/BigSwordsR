package net.nova.big_swords.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LangProvider {
  private final File output;
  private final String locale;
  private final String modid;
  private static final Map<String, String> translations = new HashMap<>();

  public LangProvider(File outputDir, String modid, String locale) {
    this.output = outputDir;
    this.locale = locale;
    this.modid = modid;
  }

  public void addTranslations() {
    translations.clear();

    // Items
    addItem(BSItems.GIANT_WOODEN_STICK.get(), "Giant Wooden Stick");
    addItem(BSItems.GIANT_BLAZE_ROD.get(), "Giant Blaze Rod");
    addItem(BSItems.GIANT_LIVINGMETAL_HANDLE.get(), "Giant Livingmetal Handle");

    // Blocks
    addBlock(BSBlocks.LIVINGMETAL_BLOCK.get(), "Livingmetal Block");
    addBlock(BSBlocks.BIOMASS_BLOCK.get(), "Biomass Block");
    addBlock(BSBlocks.CREEP_BLOCK.get(), "Creep Block");
  }

  public static void addItem(Item item, String translation) {
    translations.put(item.getTranslationKey() + ".name", translation);
  }

  public static void addBlock(Block block, String translation) {
    translations.put(block.getTranslationKey() + ".name", translation);
  }

  public void save() {
    addTranslations();

    try {
      // Create directory if it doesn't exist
      File langDir = new File(output, "assets/" + this.modid + "/lang");
      langDir.mkdirs();

      File outputFile = new File(langDir, this.locale + ".lang");

      // Write translations
      try (FileWriter writer = new FileWriter(outputFile)) {
        for (Map.Entry<String, String> entry : translations.entrySet()) {
          writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
        }
      }
    }
    catch (IOException e) {
      System.err.println("Failed to generate language file for mod (" + this.modid + ") :" + e.getMessage());
      e.printStackTrace();
    }
  }
}
