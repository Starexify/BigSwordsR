package net.nova.big_swords.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.nova.big_swords.data.advancement.BSAdvancementsProvider;
import net.nova.big_swords.data.loot.BSLootTableProvider;
import net.nova.big_swords.data.loot.GlobalLootModifier;
import net.nova.big_swords.data.models.BSEquipmentModelProvider;
import net.nova.big_swords.data.models.BSModelProvider;
import net.nova.big_swords.data.recipe.BSRecipeProvider;
import net.nova.big_swords.data.tags.BSBlockTagsProvider;
import net.nova.big_swords.data.tags.BSEnchantmentTagsProvider;
import net.nova.big_swords.data.tags.BSEntityTypeTagsProvider;
import net.nova.big_swords.data.tags.BSItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new LangProvider(output));

        event.addProvider(new BSModelProvider(output));
        event.addProvider(new BSEquipmentModelProvider(output));

        event.addProvider(new BSRecipeProvider.Runner(output, lookupProvider));

        BSBlockTagsProvider modBlockTagsProvider = new BSBlockTagsProvider(output, lookupProvider);
        event.addProvider(modBlockTagsProvider);
        event.addProvider(new BSItemTagsProvider(output, lookupProvider, modBlockTagsProvider));
        event.addProvider(new BSEntityTypeTagsProvider(output, lookupProvider));
        event.addProvider(new BSEnchantmentTagsProvider(output, lookupProvider));

        event.addProvider(new BSLootTableProvider(output, lookupProvider));

        event.addProvider(new BSDataMapProvider(output, lookupProvider));

        event.addProvider(new SoundsProvider(output));

        event.addProvider(BSAdvancementsProvider.create(output, lookupProvider));

        event.addProvider(new GlobalLootModifier(output, lookupProvider));

        event.addProvider(new DatapackProvider(output, lookupProvider));

        event.addProvider(new AtlasesProvider(output, lookupProvider));
    }
}
