package net.nova.big_swords.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.nova.big_swords.BigSwordsR;

public class Sounds {
    public static final SoundEvent GLAIVE_SWING = registerSoundEvents("glaive_swing");
    public static final SoundEvent GLAIVE_HIT = registerSoundEvents("glaive_hit");
    public static final SoundEvent SCYTHE_SLASH = registerSoundEvents("scythe_slash");
    public static final SoundEvent REAPER_SLASH = registerSoundEvents("reaper_slash");

    public static SoundEvent registerSoundEvents(String id) {
        return Registry.register(Registries.SOUND_EVENT, BigSwordsR.rl(id), SoundEvent.of(BigSwordsR.rl(id)));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Sounds");
    }
}
