package net.nova.big_swords.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.nova.big_swords.data.advancement.BSAdvancementsProvider;
import net.nova.big_swords.data.loot.BSLootTableProvider;
import net.nova.big_swords.data.loot.GlobalLootModifier;
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
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //event.addProvider(new LangProvider(output));

        //event.addProvider(new BlockStateAndModelProvider(output, existingFileHelper));
        //event.addProvider(new BSItemModelProvider(output, existingFileHelper));
        //event.addProvider(new BSEquipmentModelProvider(output));

        //event.addProvider(new BSRecipeProvider.Runner(output, lookupProvider));

        //BSBlockTagsProvider modBlockTagsProvider = new BSBlockTagsProvider(output, lookupProvider, existingFileHelper);
        //event.addProvider(modBlockTagsProvider);
        //event.addProvider(new BSItemTagsProvider(output, lookupProvider, modBlockTagsProvider, existingFileHelper));
        //event.addProvider(new BSEntityTypeTagsProvider(output, lookupProvider, existingFileHelper));
        //event.addProvider(new BSEnchantmentTagsProvider(output, lookupProvider, existingFileHelper));

        //event.addProvider(new BSLootTableProvider(output, lookupProvider));

        //event.addProvider(new BSDataMapProvider(output, lookupProvider));

        //event.addProvider(new SoundsProvider(output, existingFileHelper));

        //event.addProvider(new BSAdvancementsProvider(output, lookupProvider, existingFileHelper));

        //event.addProvider(new GlobalLootModifier(output, lookupProvider));

        //event.addProvider(new DatapackProvider(output, lookupProvider));

        //event.addProvider(new AtlasesProvider(output, lookupProvider, existingFileHelper));
    }
}
