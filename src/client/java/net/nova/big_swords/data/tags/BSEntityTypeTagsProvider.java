package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSEntityTypeTagsProvider extends FabricTagProvider.EntityTypeTagProvider {
    public BSEntityTypeTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(Tags.EntityTypeTags.SOULLESS)
                .add(EntityType.IRON_GOLEM, EntityType.SNOW_GOLEM, EntityType.BLAZE, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN, EntityType.WARDEN, EntityType.GIANT)
                .forceAddTag(EntityTypeTags.UNDEAD);
        getOrCreateTagBuilder(Tags.EntityTypeTags.BLOODLESS)
                .add(EntityType.IRON_GOLEM, EntityType.SNOW_GOLEM, EntityType.BLAZE, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN, EntityType.WARDEN, EntityType.GHAST,
                        EntityType.SLIME, EntityType.MAGMA_CUBE, EntityType.BREEZE, EntityType.WITHER, EntityType.VEX, EntityType.ALLAY)
                .forceAddTag(EntityTypeTags.SKELETONS);
        getOrCreateTagBuilder(Tags.EntityTypeTags.HALLOWEEN_MOB).forceAddTag(EntityTypeTags.SKELETONS);
    }
}
