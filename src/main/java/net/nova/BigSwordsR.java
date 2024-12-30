package net.nova;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.nova.init.BSItems;
import net.nova.init.CreativeTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigSwordsR implements ModInitializer {
	public static final String MODID = "big_swords";
	public static final Logger LOGGER = LoggerFactory.getLogger(BigSwordsR.class);

	@Override
	public void onInitialize() {
		BSItems.initialize();
		CreativeTab.initialize();
	}

	public static Identifier rl(String path) {
		return Identifier.of(MODID, path);
	}
}