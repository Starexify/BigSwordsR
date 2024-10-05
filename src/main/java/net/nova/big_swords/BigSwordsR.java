package net.nova.big_swords;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nova.big_swords.data.DataGenerators;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.nova.big_swords.BigSwordsR.MODID;

@Mod(MODID)
public class BigSwordsR {
    public static final String MODID = "big_swords";
    public static final Logger logger = LoggerFactory.getLogger(BigSwordsR.class);

    public BigSwordsR(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

/*       CreativeTab.CREATIVE_TAB.register(bus);*/
        BSItems.ITEMS.register(bus);
        BSBlocks.BLOCKS.register(bus);
/*        Sounds.SOUND_EVENTS.register(bus);
        BSLootModifier.LOOT_MODIFIERS.register(bus);
        BSEnchantmentEntityEffects.ENTITY_EFFECT.register(bus);*/

        bus.addListener(DataGenerators::gatherData);
    }

    // Util
    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }
}