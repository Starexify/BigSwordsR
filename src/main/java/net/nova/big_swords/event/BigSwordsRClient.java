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
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.client.renderer.item.BloodLevelModelProperty;

import java.util.Collections;
import java.util.Optional;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
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
            event.addRepositorySource((packConsumer) -> {
                for (String packId : RESOURCE_PACKS) {
                    String fullPackId = MODID + ":" + packId;
                    PackLocationInfo locationInfo = new PackLocationInfo(fullPackId, Component.translatable("resourcePack." + MODID + "." + packId + ".name"), PackSource.BUILT_IN, Optional.empty());
                    Pack.ResourcesSupplier resourcesSupplier = new PathPackResources.PathResourcesSupplier(modContainer.getModInfo().getOwningFile().getFile().findResource("resourcepacks/" + packId));
                    PackSelectionConfig selectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
                    Pack.Metadata metadata = new Pack.Metadata(Component.translatable("resourcePack." + MODID + "." + packId + ".description"), PackCompatibility.COMPATIBLE, FeatureFlagSet.of(), Collections.emptyList(), false);

                    Pack pack = new Pack(locationInfo, resourcesSupplier, metadata, selectionConfig);
                    packConsumer.accept(pack);
                }
            });
        });
    }

    @SubscribeEvent
    public static void addItemProperty(RegisterRangeSelectItemModelPropertyEvent event) {
        event.register(BigSwordsR.rl("blood_level"), BloodLevelModelProperty.MAP_CODEC);
    }
}
