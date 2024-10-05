package net.nova.big_swords.event;

import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.nova.big_swords.client.renderer.item.BSItemProperties;

import java.nio.file.Path;

import static net.nova.big_swords.BigSwordsR.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BigSwordsRClient {

    public static String RP_16x_NAME = "resourcePack." + MODID + ".big_swords_r_16x.name";
    public static String RP_16x_DESC = "resourcePack." + MODID + ".big_swords_r_16x.description";

    // Integrated Resourcepack
    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {
        String packId = MODID + ":big_swords_r_16x";

        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            ModList.get().getModContainerById(MODID).ifPresent(modContainer -> {
                event.addRepositorySource((packConsumer) -> {
                    Path resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/big_swords_r_16x");
                    Pack.ResourcesSupplier resourcesSupplier = (suppliedPackId) -> new PathPackResources(packId, resourcePath, true);

                    int currentPackVersion = SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES);
                    Pack.Info packInfo = new Pack.Info(
                            Component.translatable(RP_16x_DESC),
                            currentPackVersion,
                            currentPackVersion,
                            FeatureFlagSet.of(),
                            false
                    );

                    Pack pack = Pack.create(
                            packId,
                            Component.translatable(RP_16x_NAME),
                            false,
                            resourcesSupplier,
                            packInfo,
                            PackType.CLIENT_RESOURCES,
                            Pack.Position.TOP,
                            false,
                            PackSource.BUILT_IN
                    );

                    packConsumer.accept(pack);
                });
            });
        }
    }

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        event.enqueueWork(BSItemProperties::addCustomItemProperties);
    }
}
