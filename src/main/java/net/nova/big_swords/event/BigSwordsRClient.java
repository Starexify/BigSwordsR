package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.resource.JarContentsPackResources;
import net.neoforged.neoforgespi.language.IModInfo;
import net.nova.big_swords.BigSwordsR;

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

    IModInfo modInfo = ModList.get().getModContainerById(MODID)
        .orElseThrow(() -> new IllegalArgumentException("Mod not found: " + MODID))
        .getModInfo();

    for (String packId : RESOURCE_PACKS) {
      Identifier packPath = BigSwordsR.rl("resourcepacks/" + packId);

      Component packNameDisplay = Component.translatable("resourcePack." + MODID + "." + packId + ".name");
      Component packDescription = Component.translatable("resourcePack." + MODID + "." + packId + ".description");
      PackLocationInfo locationInfo = new PackLocationInfo(
          "mod/" + packPath,
          packNameDisplay,
          PackSource.BUILT_IN,
          Optional.empty()
      );

      Pack.Metadata metadata = new Pack.Metadata(
          packDescription,
          PackCompatibility.COMPATIBLE,
          FeatureFlagSet.of(),
          List.of(),
          false
      );

      JarContentsPackResources.JarContentsResourcesSupplier resourceSupplier = new JarContentsPackResources.JarContentsResourcesSupplier(modInfo.getOwningFile().getFile().getContents(), packPath.getPath());
      PackSelectionConfig config = new PackSelectionConfig(false, Pack.Position.TOP, false);

      Pack pack = new Pack(locationInfo, resourceSupplier, metadata, config);
      event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }
  }
}
