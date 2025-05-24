package net.nova.big_swords;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.legacyfabric.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.legacyfabric.fabric.api.logger.v1.Logger;
import net.legacyfabric.fabric.api.util.Identifier;
import net.legacyfabric.fabric.impl.resource.loader.ModNioResourcePack;
import net.minecraft.client.MinecraftClient;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.CreativeTab;
import net.nova.big_swords.recipe.BSCraftingRecipes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class BigSwordsR implements ModInitializer {
    public static final String MODID = "big_swords";
    public static final Logger LOGGER = Logger.get("Big Swords R");

    @Override
    public void onInitialize() {
        BSBlocks.initialize();
        BSItems.initialize();
        CreativeTab.initialize();
        BSCraftingRecipes.initialize();

/*        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(MODID);
            if (modContainer.isPresent()) {
                Path rootPath = modContainer.get().getRootPaths().get(0);
                Path resourcePackPath = rootPath.resolve("resourcepacks").resolve("big_swords_r16x");
                if (Files.exists(resourcePackPath)) {
                    ModNioResourcePack resourcePack = new ModNioResourcePack(modContainer.get(), resourcePackPath, null);
                    client.getResourcePackLoader().getAvailableResourcePacks().add(resourcePack);
                }
            }
        });*/
    }

    public static Identifier rl(String path) {
        return new Identifier(MODID, path);
    }
}