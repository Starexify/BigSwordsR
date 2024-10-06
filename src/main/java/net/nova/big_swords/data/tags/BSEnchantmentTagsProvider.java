package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.big_swords.data.BSEnchantments;
import net.nova.big_swords.init.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSEnchantmentTagsProvider extends EnchantmentTagsProvider {
    public BSEnchantmentTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(Tags.EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(BSEnchantments.SOUL_STEALER.location());
    }
}
