package net.nova.big_swords.data;

import net.minecraft.DetectedVersion;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSPackMetaGenerator extends PackMetadataGenerator {
  private final PackOutput baseOutput;

  public static final String[] RESOURCE_PACKS = {"big_swords_r_16x", "big_swords_r_old"};
  public static final String RP_16x = RESOURCE_PACKS[0];
  public static final String RP_old = RESOURCE_PACKS[1];
  public static String RP_16x_NAME = "resourcePack." + MODID + "." + RP_16x + ".name";
  public static String RP_16x_DESC = "resourcePack." + MODID + "." + RP_16x + ".description";
  public static String RP_old_NAME = "resourcePack." + MODID + "." + RP_old + ".name";
  public static String RP_old_DESC = "resourcePack." + MODID + "." + RP_old + ".description";

  public BSPackMetaGenerator(PackOutput output) {
    super(output);
    this.baseOutput = output;
  }

  @Override
  public CompletableFuture<?> run(CachedOutput cache) {
    List<CompletableFuture<?>> futures = new ArrayList<>();

    futures.add(savePackMeta(cache, RP_16x, Component.translatable("resourcePack." + MODID + "." + RP_16x + ".description")));
    futures.add(savePackMeta(cache, RP_old, Component.translatable("resourcePack." + MODID + "." + RP_old + ".description")));

    return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
  }

  private CompletableFuture<?> savePackMeta(CachedOutput cache, String packId, Component description) {
    PackOutput individualizedOutput = new PackOutput(this.baseOutput.getOutputFolder().resolve("resourcepacks").resolve(packId));
    PackMetadataGenerator miniGenerator = new PackMetadataGenerator(individualizedOutput)
        .add(PackMetadataSection.CLIENT_TYPE, new PackMetadataSection(
            description,
            new InclusiveRange<>(DetectedVersion.BUILT_IN.packVersion(PackType.CLIENT_RESOURCES))
        ));

    return miniGenerator.run(cache);
  }
}
