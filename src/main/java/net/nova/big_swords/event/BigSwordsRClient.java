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

                    Path resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/" + packId);
                    Pack.ResourcesSupplier resourcesSupplier = (suppliedPackId) -> new PathPackResources(fullPackId, resourcePath, true);
                    int currentPackVersion = SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES);
                    Pack.Info packInfo = new Pack.Info(
                            Component.translatable("resourcePack." + MODID + "." + packId + ".description"),
                            currentPackVersion,
                            currentPackVersion,
                            FeatureFlagSet.of(),
                            false
                    );

                    Pack pack = Pack.create(
                            fullPackId,
                            Component.translatable("resourcePack." + MODID + "." + packId + ".name"),
                            false,
                            resourcesSupplier,
                            packInfo,
                            PackType.CLIENT_RESOURCES,
                            Pack.Position.TOP,
                            false,
                            PackSource.BUILT_IN
                    );

                    packConsumer.accept(pack);
                }
            });
        });
    }

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        event.enqueueWork(BSItemProperties::addCustomItemProperties);
    }
}
