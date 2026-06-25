package net.nova.big_swords.data;

import net.minecraft.Bootstrap;
import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.List;

import static net.nova.big_swords.BigSwordsR.MODID;

public class DataGenerator implements ClientModInitializer {
  @Override
  public void initClient() {
    Bootstrap.init();
    File outputDir = init();

    if (outputDir == null) {
      return;
    }

    new LangProvider(outputDir, MODID, "en_US").save();

    System.exit(0);
  }

  static File init() {
    String command = System.getProperty("sun.java.command");

    if (command != null && command.contains("output")) {
      String[] args = command.split("\\s+");
      for (int i = 0; i < args.length; i++) {
        if (args[i].equals("output") && (i + 1) < args.length) {
          return new File(args[i + 1]);
        }
      }
    }

    return null;
  }
}