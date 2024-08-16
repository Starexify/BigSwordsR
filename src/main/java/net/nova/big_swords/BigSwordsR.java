package net.nova.big_swords;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.nova.big_swords.data.DataGenerators;
import net.nova.big_swords.init.*;
import org.slf4j.Logger;
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
        Sounds.SOUND_EVENTS.register(bus);

        bus.addListener(DataGenerators::gatherData);
    }

    public static void playSound(Level level, Player player, SoundEvent sound) {
        if (!player.level().isClientSide) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
        } else {
            level.playLocalSound(player.getX(), player.getY(), player.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f, false);
        }
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
