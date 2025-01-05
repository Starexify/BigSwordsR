package net.nova.big_swords;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.item.property.numeric.NumericProperties;
import net.minecraft.text.Text;
import net.nova.big_swords.client.render.item.BloodLevelModelProperty;
import net.nova.big_swords.init.BSBlocks;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSClient implements ClientModInitializer {
    public static final String[] RESOURCE_PACKS = {"big_swords_r_16x", "big_swords_r_old"};
    public static final String RP_16x = RESOURCE_PACKS[0];
    public static final String RP_old = RESOURCE_PACKS[1];
    public static String RP_16x_NAME = "resourcePack." + MODID + "." + RP_16x + ".name";
    public static String RP_16x_DESC = "resourcePack." + MODID + "." + RP_16x + ".description";
    public static String RP_old_NAME = "resourcePack." + MODID + "." + RP_old + ".name";
    public static String RP_old_DESC = "resourcePack." + MODID + "." + RP_old + ".description";

    @Override
    public void onInitializeClient() {
        NumericProperties.ID_MAPPER.put(BigSwordsR.rl("blood_level"), BloodLevelModelProperty.CODEC);

        BlockRenderLayerMap.INSTANCE.putBlock(BSBlocks.BIOMASS, RenderLayer.getCutout());

        for (String packId : RESOURCE_PACKS) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    BigSwordsR.rl(packId),
                    FabricLoader.getInstance().getModContainer(MODID).orElseThrow(),
                    Text.translatable("resourcePack." + MODID + "." + packId + ".name"),
                    ResourcePackActivationType.NORMAL
            );
        }
    }
}