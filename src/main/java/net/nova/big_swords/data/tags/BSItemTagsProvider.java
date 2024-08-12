package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItemTagsProvider extends ItemTagsProvider {
    public BSItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BSBlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, provider.contentsGetter(), MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(Tags.BSItemTags.BIG_SWORDS).add(
                BSItems.WOODEN_BIG_SWORD.asItem(), BSItems.STONE_BIG_SWORD.asItem(), BSItems.IRON_BIG_SWORD.asItem(), BSItems.GOLDEN_BIG_SWORD.asItem(),
                BSItems.DIAMOND_BIG_SWORD.asItem(), BSItems.NETHERITE_BIG_SWORD.asItem(), BSItems.PATCHWORK_BIG_SWORD.asItem(), BSItems.SKULL_BIG_SWORD.asItem(),
                BSItems.QUARTZ_BIG_SWORD.asItem()
        );

        tag(ItemTags.SWORDS).addTag(Tags.BSItemTags.BIG_SWORDS);
    }
}
