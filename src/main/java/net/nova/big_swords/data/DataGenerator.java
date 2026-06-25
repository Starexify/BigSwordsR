package net.nova.big_swords.data;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.Bootstrap;
import net.ornithemc.osl.entrypoints.api.ModInitializer;
import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;

import java.io.File;

import static net.nova.big_swords.BigSwordsR.MODID;

public class DataGenerator implements ClientModInitializer {
  static void main(String[] args) {
    FabricLoader.getInstance().invokeEntrypoints(
        ModInitializer.ENTRYPOINT_KEY,
        ModInitializer.class,
        ModInitializer::init
    );
    Bootstrap.init();

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

  @Override
  public void initClient() {
    Bootstrap.init();

    File outputDir = new File(".", "src/generated/resources");
    LangProvider provider = new LangProvider(outputDir, MODID, "en_US");
    provider.save();
  }
}