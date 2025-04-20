package net.nova.big_swords;

import net.fabricmc.api.ClientModInitializer;
import net.legacyfabric.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;

public class BSClient implements ClientModInitializer {
    public static final String[] RESOURCE_PACKS = {"big_swords_r_16x", "big_swords_r_modern"};

    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {

        });
    }
}