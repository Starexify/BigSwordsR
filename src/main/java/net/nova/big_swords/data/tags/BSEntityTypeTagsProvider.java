package net.nova.big_swords.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nova.big_swords.init.Tags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public BSEntityTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(Tags.EntityTypeTags.SOULLESS).addTags(EntityTypeTags.SKELETONS).add(
                EntityType.ZOMBIE, EntityType.ZOGLIN, EntityType.ZOMBIFIED_PIGLIN, EntityType.WITHER, EntityType.IRON_GOLEM, EntityType.SNOW_GOLEM, EntityType.BLAZE,
                EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN, EntityType.ZOMBIE_HORSE, EntityType.ZOMBIE_VILLAGER, EntityType.DROWNED, EntityType.HUSK, EntityType.WARDEN,
                EntityType.GIANT
        );
        tag(Tags.EntityTypeTags.HALLOWEEN_MOB).addTags(EntityTypeTags.SKELETONS);
    }
}
