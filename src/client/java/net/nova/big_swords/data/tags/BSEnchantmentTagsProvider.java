package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;
import net.nova.big_swords.init.BSEnchantmentEffects;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSEnchantmentTagsProvider extends FabricTagProvider.EnchantmentTagProvider {
    public BSEnchantmentTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(BSEnchantmentEffects.SOUL_STEALER);
        getOrCreateTagBuilder(Tags.EnchantmentTags.SCYTHE_EXCLUSIVE).addOptional(BSEnchantmentEffects.SOUL_STEALER);
    }
}
