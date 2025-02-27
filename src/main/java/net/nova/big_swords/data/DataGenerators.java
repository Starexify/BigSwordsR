package net.nova.big_swords.data;

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

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(LangProvider::new);
        event.createProvider(BSModelProvider::new);
        event.createProvider(BSEquipmentModelProvider::new);
        event.createProvider(BSRecipeProvider.Runner::new);
        event.createBlockAndItemTags(BSBlockTagsProvider::new, BSItemTagsProvider::new);
        event.createProvider(BSEntityTypeTagsProvider::new);
        event.createProvider(BSEnchantmentTagsProvider::new);
        event.createProvider(BSLootTableProvider::new);
        event.createProvider(BSDataMapProvider::new);
        event.createProvider(SoundsProvider::new);
        event.createProvider(BSAdvancementsProvider::create);
        event.createProvider(GlobalLootModifier::new);
        event.createProvider(DatapackProvider::new);
        event.createProvider(AtlasesProvider::new);
    }
}
