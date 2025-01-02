package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.nova.big_swords.data.BSEnchantments;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSEnchantmentTagsProvider extends EnchantmentTagsProvider {
    public BSEnchantmentTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider) {
        super(pOutput, pLookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(BSEnchantments.SOUL_STEALER.location());
        tag(Tags.EnchantmentTags.SCYTHE_EXCLUSIVE).addOptional(BSEnchantments.SOUL_STEALER.location());
    }
}
