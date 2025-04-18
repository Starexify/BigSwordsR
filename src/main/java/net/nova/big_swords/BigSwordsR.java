package net.nova.big_swords;

import net.fabricmc.api.ModInitializer;
import net.legacyfabric.fabric.api.logger.v1.Logger;
import net.legacyfabric.fabric.api.util.Identifier;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.CreativeTab;
import net.nova.big_swords.recipe.BSCraftingRecipes;

public class BigSwordsR implements ModInitializer {
    public static final String MODID = "big_swords";
    public static final Logger LOGGER = Logger.get("Big Swords R");

    @Override
    public void onInitialize() {
        BSBlocks.initialize();
        BSItems.initialize();
        CreativeTab.initialize();
        BSCraftingRecipes.initialize();
    }

    public static Identifier rl(String path) {
        return new Identifier(MODID, path);
    }
}