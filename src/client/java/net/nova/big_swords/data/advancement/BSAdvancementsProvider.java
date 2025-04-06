package net.nova.big_swords.data.advancement;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BSAdvancementsProvider {
    public static AdvancementProvider create(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        return new AdvancementProvider(output, registries, List.of(
                new BigSwordsAdvancements()
        ));
    }
}
