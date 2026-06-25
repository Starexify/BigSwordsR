package net.nova.big_swords;

import net.minecraft.client.resource.Identifier;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.ornithemc.osl.blocks.api.BlockEvents;
import net.ornithemc.osl.entrypoints.api.ModInitializer;
import net.ornithemc.osl.items.api.ItemEvents;

public class BigSwordsR implements ModInitializer {
  public static final String MODID = "big_swords";

  @Override
  public void init() {
    ItemEvents.REGISTER_ITEMS.register(BSItems::init);
    BlockEvents.REGISTER_BLOCKS.register(BSBlocks::init);
  }

  public static Identifier rl(String path) {
    return new Identifier(MODID, path);
  }
}