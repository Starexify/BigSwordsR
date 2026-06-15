package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.jarcontents.FolderJarContents;
import net.neoforged.fml.jarcontents.JarContents;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.resource.JarContentsPackResources;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID)
public class BigSwordsRClient {
  public static final String[] RESOURCE_PACKS = {"big_swords_r_16x", "big_swords_r_old"};
  public static final String RP_16x = RESOURCE_PACKS[0];
  public static final String RP_old = RESOURCE_PACKS[1];
  public static String RP_16x_NAME = "resourcePack." + MODID + "." + RP_16x + ".name";
  public static String RP_16x_DESC = "resourcePack." + MODID + "." + RP_16x + ".description";
  public static String RP_old_NAME = "resourcePack." + MODID + "." + RP_old + ".name";
  public static String RP_old_DESC = "resourcePack." + MODID + "." + RP_old + ".description";

  // Integrated Resourcepack
  @SubscribeEvent
  public static void onAddPackFinders(AddPackFindersEvent event) {
    if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

    ModList.get().getModContainerById(MODID).ifPresent(modContainer -> {
      JarContents jarContents = modContainer.getModInfo().getOwningFile().getFile().getContents();

      event.addRepositorySource((packConsumer) -> {
        for (String packId : RESOURCE_PACKS) {
          PackLocationInfo locationInfo = new PackLocationInfo(
              MODID + ":" + packId,
              Component.translatable("resourcePack." + MODID + "." + packId + ".name"),
              PackSource.BUILT_IN,
              Optional.empty()
          );

          Pack.ResourcesSupplier resourcesSupplier = switch (jarContents) {
            case FolderJarContents folder -> {
              Path targetPath = folder.getPrimaryPath().resolve("resourcepacks").resolve(packId);
              yield new PathPackResources.PathResourcesSupplier(targetPath);
            }
            default -> new JarContentsPackResources.JarContentsResourcesSupplier(jarContents, "resourcepacks/" + packId);
          };

          PackSelectionConfig selectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
          Pack.Metadata metadata = new Pack.Metadata(
              Component.translatable("resourcePack." + MODID + "." + packId + ".description"),
              PackCompatibility.COMPATIBLE,
              FeatureFlagSet.of(),
              List.of(),
              false
          );

          Pack pack = new Pack(locationInfo, resourcesSupplier, metadata, selectionConfig);
          packConsumer.accept(pack);
        }
      });
    });
  }
}
