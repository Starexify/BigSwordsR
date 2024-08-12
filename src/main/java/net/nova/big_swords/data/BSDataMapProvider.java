package net.nova.big_swords.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.nova.big_swords.init.BSItems;

import java.util.concurrent.CompletableFuture;

public class BSDataMapProvider extends DataMapProvider {
    protected BSDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        builder(NeoForgeDataMaps.FURNACE_FUELS).add(BSItems.WOODEN_BIG_SWORD, new FurnaceFuel(200), false)
                .add(BSItems.GIANT_BLAZE_ROD, new FurnaceFuel(16800), false);
    }
}
