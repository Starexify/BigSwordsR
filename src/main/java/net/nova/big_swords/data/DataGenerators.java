package net.nova.big_swords.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.data.tags.BSBlockTagsProvider;
import net.nova.big_swords.data.tags.BSItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

            generator.addProvider(true, new LangProvider(output));

            generator.addProvider(true, new BlockStateAndModelProvider(output, existingFileHelper));
            generator.addProvider(true, new BSItemModelProvider(output, existingFileHelper));

//            generator.addProvider(true, new BSRecipeProvider(output, lookupProvider));

            BSBlockTagsProvider modBlockTagsProvider = new BSBlockTagsProvider(output, lookupProvider, existingFileHelper);
            generator.addProvider(true, modBlockTagsProvider);
            generator.addProvider(true, new BSItemTagsProvider(output, lookupProvider, modBlockTagsProvider, existingFileHelper));
/*            generator.addProvider(true, new BSEntityTypeTagsProvider(output, lookupProvider, existingFileHelper));
            generator.addProvider(true, new BSEnchantmentTagsProvider(output, lookupProvider, existingFileHelper));

            generator.addProvider(true, new BSLootTableProvider(output, lookupProvider));

            generator.addProvider(true, new BSDataMapProvider(output, lookupProvider));

            generator.addProvider(true, new SoundsProvider(output, existingFileHelper));

            generator.addProvider(true, new BSAdvancementsProvider(output, lookupProvider, existingFileHelper));

            generator.addProvider(true, new GlobalLootModifier(output, lookupProvider));

            generator.addProvider(true, new DatapackProvider(output, lookupProvider));*/

        } catch (RuntimeException e) {
            BigSwordsR.logger.error("Cosmicore failed to gather data", e);
        }
    }
}