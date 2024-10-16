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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.nova.big_swords.client.renderer.item.BSItemProperties;

import java.util.Collections;
import java.util.Optional;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BigSwordsRClient {
    public static String RP_16x_NAME = "resourcePack." + MODID + ".big_swords_r_16x.name";
    public static String RP_16x_DESC = "resourcePack." + MODID + ".big_swords_r_16x.description";

    // Integrated Resourcepack
    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            ModList.get().getModContainerById(MODID).ifPresent(modContainer -> {
                event.addRepositorySource((packConsumer) -> {
                    PackLocationInfo locationInfo = new PackLocationInfo(MODID + ":big_swords_r_16x", Component.translatable(RP_16x_NAME), PackSource.BUILT_IN, Optional.empty());
                    Pack.ResourcesSupplier resourcesSupplier = new PathPackResources.PathResourcesSupplier(modContainer.getModInfo().getOwningFile().getFile().findResource("resourcepacks/big_swords_r_16x"));
                    PackSelectionConfig selectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
                    Pack.Metadata metadata = new Pack.Metadata(Component.translatable(RP_16x_DESC), PackCompatibility.COMPATIBLE, FeatureFlagSet.of(), Collections.emptyList(), false);

                    Pack pack = new Pack(locationInfo, resourcesSupplier, metadata, selectionConfig);
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
