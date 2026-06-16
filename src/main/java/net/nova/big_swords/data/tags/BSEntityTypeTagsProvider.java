package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityTypeIds;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSEntityTypeTagsProvider extends EntityTypeTagsProvider {
  public BSEntityTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> provider) {
    super(pOutput, provider, MODID);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    tag(Tags.EntityTypeTags.SOULLESS)
        .addTags(EntityTypeTags.UNDEAD)
        .add(EntityTypeIds.IRON_GOLEM, EntityTypeIds.SNOW_GOLEM, EntityTypeIds.BLAZE, EntityTypeIds.GUARDIAN, EntityTypeIds.ELDER_GUARDIAN, EntityTypeIds.WARDEN,
            EntityTypeIds.GIANT, EntityTypeIds.BREEZE, EntityTypeIds.SHULKER);
    tag(Tags.EntityTypeTags.BLOODLESS)
        .addTags(EntityTypeTags.SKELETONS)
        .add(EntityTypeIds.IRON_GOLEM, EntityTypeIds.SNOW_GOLEM, EntityTypeIds.BLAZE, EntityTypeIds.GUARDIAN, EntityTypeIds.ELDER_GUARDIAN, EntityTypeIds.WARDEN,EntityTypeIds.GHAST,
            EntityTypeIds.SLIME, EntityTypeIds.SULFUR_CUBE, EntityTypeIds.MAGMA_CUBE, EntityTypeIds.BREEZE, EntityTypeIds.WITHER, EntityTypeIds.VEX, EntityTypeIds.ALLAY,
            EntityTypeIds.CREEPER, EntityTypeIds.PHANTOM, EntityTypeIds.SHULKER);

    tag(Tags.EntityTypeTags.HALLOWEEN_MOB).addTags(EntityTypeTags.SKELETONS);
  }
}
