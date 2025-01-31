package net.nova.big_swords.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.nova.big_swords.BigSwordsR;

public class Sounds {
    public static final SoundEvent GLAIVE_SWING = registerSoundEvents("glaive_swing");
    public static final SoundEvent GLAIVE_HIT = registerSoundEvents("glaive_hit");
    public static final SoundEvent SCYTHE_SLASH = registerSoundEvents("scythe_slash");
    public static final SoundEvent REAPER_SLASH = registerSoundEvents("reaper_slash");

    public static SoundEvent registerSoundEvents(String id) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, BigSwordsR.rl(id), SoundEvent.createVariableRangeEvent(BigSwordsR.rl(id)));
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Sounds");
    }
}
