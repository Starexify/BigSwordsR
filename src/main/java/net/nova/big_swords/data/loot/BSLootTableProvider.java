package net.nova.big_swords.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BSLootTableProvider extends LootTableProvider {
    public BSLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(
                new SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
