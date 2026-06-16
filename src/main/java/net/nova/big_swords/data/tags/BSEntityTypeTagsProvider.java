package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
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
        .add(EntityType.IRON_GOLEM, EntityType.SNOW_GOLEM, EntityType.BLAZE, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN, EntityType.WARDEN, EntityType.GIANT,
            EntityType.BREEZE, EntityType.SHULKER);
    tag(Tags.EntityTypeTags.BLOODLESS)
        .addTags(EntityTypeTags.SKELETONS)
        .add(EntityType.IRON_GOLEM, EntityType.SNOW_GOLEM, EntityType.BLAZE, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN, EntityType.WARDEN, EntityType.GHAST,
            EntityType.SLIME, EntityType.MAGMA_CUBE, EntityType.BREEZE, EntityType.WITHER, EntityType.VEX, EntityType.ALLAY, EntityType.CREEPER, EntityType.PHANTOM,
            EntityType.SHULKER);

    tag(Tags.EntityTypeTags.HALLOWEEN_MOB).addTags(EntityTypeTags.SKELETONS);
  }
}
