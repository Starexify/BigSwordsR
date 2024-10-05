package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nova.big_swords.init.BSItems;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItemTagsProvider extends ItemTagsProvider {
    public BSItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BSBlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, provider.contentsGetter(), MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(ItemTags.TRIMMABLE_ARMOR).add(
                BSItems.LIVINGMETAL_HELMET.get(), BSItems.BIOMASS_HELMET.get(),
                BSItems.LIVINGMETAL_CHESTPLATE.get(), BSItems.BIOMASS_CHESTPLATE.get(),
                BSItems.LIVINGMETAL_LEGGINGS.get(), BSItems.BIOMASS_LEGGINGS.get(),
                BSItems.LIVINGMETAL_BOOTS.get(), BSItems.BIOMASS_BOOTS.get());
    }
}
