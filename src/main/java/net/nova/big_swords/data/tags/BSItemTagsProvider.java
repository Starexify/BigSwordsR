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
                BSItems.WOODEN_BIG_SWORD.get(), BSItems.STONE_BIG_SWORD.get(), BSItems.IRON_BIG_SWORD.get(), BSItems.GOLDEN_BIG_SWORD.get(),
                BSItems.DIAMOND_BIG_SWORD.get(), BSItems.NETHERITE_BIG_SWORD.get(), BSItems.PATCHWORK_BIG_SWORD.get(), BSItems.SKULL_BIG_SWORD.get(),
                BSItems.QUARTZ_BIG_SWORD.get(), BSItems.OBSIDIAN_BIG_SWORD.get(), BSItems.ENDER_BIG_SWORD.get(), BSItems.LIVINGMETAL_BIG_SWORD.get(),
                BSItems.BIOMASS_BIG_SWORD.get()
        );

        tag(ItemTags.HEAD_ARMOR).add(BSItems.LIVINGMETAL_HELMET.get(), BSItems.BIOMASS_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(BSItems.LIVINGMETAL_CHESTPLATE.get(), BSItems.BIOMASS_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(BSItems.LIVINGMETAL_LEGGINGS.get(), BSItems.BIOMASS_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(BSItems.LIVINGMETAL_BOOTS.get(), BSItems.BIOMASS_BOOTS.get());

        tag(ItemTags.SWORDS).addTag(Tags.BSItemTags.BIG_SWORDS).add(BSItems.LIVINGMETAL_SWORD.get(), BSItems.BIOMASS_SWORD.get());
        tag(ItemTags.PICKAXES).add(BSItems.LIVINGMETAL_PICKAXE.get(), BSItems.LIVINGMETAL_PICKAXE.get());
        tag(ItemTags.AXES).add(BSItems.LIVINGMETAL_AXE.get(), BSItems.BIOMASS_AXE.get());
        tag(ItemTags.SHOVELS).add(BSItems.LIVINGMETAL_SHOVEL.get(), BSItems.BIOMASS_SHOVEL.get());
        tag(ItemTags.HOES).add(BSItems.LIVINGMETAL_HOE.get(), BSItems.BIOMASS_HOE.get());
    }
}
