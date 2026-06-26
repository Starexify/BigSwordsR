package net.nova.big_swords.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.nova.big_swords.BigSwordsR;

public interface Sounds {
  SoundEvent GLAIVE_SWING = registerSoundEvents("glaive_swing");
  SoundEvent GLAIVE_HIT = registerSoundEvents("glaive_hit");
  SoundEvent SCYTHE_SLASH = registerSoundEvents("scythe_slash");
  SoundEvent REAPER_SLASH = registerSoundEvents("reaper_slash");

  static SoundEvent registerSoundEvents(String id) {
    return Registry.register(BuiltInRegistries.SOUND_EVENT, BigSwordsR.rl(id), SoundEvent.createVariableRangeEvent(BigSwordsR.rl(id)));
  }

  static void initialize() {
    BigSwordsR.LOGGER.info("Registering Sounds");
  }
}
