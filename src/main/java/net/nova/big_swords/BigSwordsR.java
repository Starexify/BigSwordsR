package net.nova.big_swords;

import net.minecraft.resources.ResourceLocation;
import net.nova.big_swords.data.DataGenerators;
import net.nova.big_swords.init.BSArmorMaterial;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.CreativeTab;
import org.slf4j.Logger;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.LoggerFactory;

import static net.nova.big_swords.BigSwordsR.MODID;

@Mod(MODID)
public class BigSwordsR {
    public static final String MODID = "big_swords";
    public static final Logger logger = LoggerFactory.getLogger(BigSwordsR.class);

    public BigSwordsR(IEventBus bus) {
        BSArmorMaterial.ARMOR_MATERIALS.register(bus);
        CreativeTab.CREATIVE_TAB.register(bus);
        BSItems.ITEMS.register(bus);
        BSBlocks.BLOCKS.register(bus);

        bus.addListener(DataGenerators::gatherData);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
