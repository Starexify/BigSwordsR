package net.nova.big_swords.data;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.nova.big_swords.data.advancement.BSAdvancementsProvider;
import net.nova.big_swords.data.loot.BlockLootTables;
import net.nova.big_swords.data.loot.GlobalLootModifier;
import net.nova.big_swords.data.models.BSEquipmentModelProvider;
import net.nova.big_swords.data.models.BSModelProvider;
import net.nova.big_swords.data.recipe.BSRecipeProvider;
import net.nova.big_swords.data.tags.BSBlockTagsProvider;
import net.nova.big_swords.data.tags.BSEnchantmentTagsProvider;
import net.nova.big_swords.data.tags.BSEntityTypeTagsProvider;
import net.nova.big_swords.data.tags.BSItemTagsProvider;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID)
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
        event.createProvider(BSDataMapProvider::new);
        event.createProvider(SoundsProvider::new);
        event.createProvider(BSAdvancementsProvider::create);
        event.createProvider(GlobalLootModifier::new);
        event.createProvider(AtlasesProvider::new);

        event.createProvider((packOutput, lookupProvider) -> new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)), lookupProvider));

        event.createDatapackRegistryObjects(new RegistrySetBuilder()
                        .add(Registries.ENCHANTMENT, BSEnchantments::bootstrap)
                        .add(Registries.TRIM_MATERIAL, BSTrimMaterials::bootstrap),
                Set.of(MODID));
    }
}
