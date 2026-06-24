package net.nova.big_swords;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.resource.Identifier;

public class BigSwordsR implements ModInitializer {
  public static final String MODID = "big_swords";

  @Override
  public void onInitialize() {}

  public static Identifier rl(String path) {
    return new Identifier(MODID, path);
  }
}