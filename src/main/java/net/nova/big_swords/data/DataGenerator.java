package net.nova.big_swords.data;

import java.io.File;

import static net.nova.big_swords.BigSwordsR.MODID;

public class DataGenerator {
  static void main(String[] args) {
    File output = setup(args);

    new LangProvider(output, MODID, "en_US").save();
  }

  static File setup(String[] args) {
    String outputDirPath = null;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("--output") && i + 1 < args.length) {
        outputDirPath = args[i + 1];
      }
    }
    if (outputDirPath == null) {
      System.err.println("Error: Missing --output argument!");
      System.exit(1);
    }
    return new File(outputDirPath);
  }
}