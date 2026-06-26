package net.nova.big_swords.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityTypeIds;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSEntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {
  public BSEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    builder(Tags.EntityTypeTags.SOULLESS)
        .add(EntityTypeIds.IRON_GOLEM, EntityTypeIds.SNOW_GOLEM, EntityTypeIds.BLAZE, EntityTypeIds.GUARDIAN, EntityTypeIds.ELDER_GUARDIAN, EntityTypeIds.WARDEN, EntityTypeIds.GIANT)
        .forceAddTag(EntityTypeTags.UNDEAD);
    builder(Tags.EntityTypeTags.BLOODLESS)
        .add(EntityTypeIds.IRON_GOLEM, EntityTypeIds.SNOW_GOLEM, EntityTypeIds.BLAZE, EntityTypeIds.GUARDIAN, EntityTypeIds.ELDER_GUARDIAN, EntityTypeIds.WARDEN, EntityTypeIds.GHAST,
            EntityTypeIds.SLIME, EntityTypeIds.MAGMA_CUBE, EntityTypeIds.BREEZE, EntityTypeIds.WITHER, EntityTypeIds.VEX, EntityTypeIds.ALLAY)
        .forceAddTag(EntityTypeTags.SKELETONS);
    builder(Tags.EntityTypeTags.HALLOWEEN_MOB).forceAddTag(EntityTypeTags.SKELETONS);
  }
}
