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
                BSItems.QUARTZ_BIG_SWORD.asItem(), BSItems.OBSIDIAN_BIG_SWORD.asItem(), BSItems.ENDER_BIG_SWORD.asItem(), BSItems.LIVINGMETAL_BIG_SWORD.asItem()
        );

        tag(ItemTags.HEAD_ARMOR).add(BSItems.LIVINGMETAL_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(BSItems.LIVINGMETAL_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(BSItems.LIVINGMETAL_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(BSItems.LIVINGMETAL_BOOTS.get());

        tag(ItemTags.SWORDS).addTag(Tags.BSItemTags.BIG_SWORDS).add(BSItems.LIVINGMETAL_SWORD.get());
        tag(ItemTags.PICKAXES).add(BSItems.LIVINGMETAL_PICKAXE.get());
        tag(ItemTags.AXES).add(BSItems.LIVINGMETAL_AXE.get());
        tag(ItemTags.SHOVELS).add(BSItems.LIVINGMETAL_SHOVEL.get());
        tag(ItemTags.HOES).add(BSItems.LIVINGMETAL_HOE.get());
    }
}
