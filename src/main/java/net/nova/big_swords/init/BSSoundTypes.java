package net.nova.big_swords.init;

import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.util.DeferredSoundType;

public class BSSoundTypes {
    public static DeferredSoundType LIVINGMETAL_BLOCK = new DeferredSoundType(
            1.0F, 1.0F,
            SoundEvents.SOUL_ESCAPE::value,
            () -> SoundEvents.SOUL_SAND_STEP,
            () -> SoundEvents.METAL_PLACE,
            () -> SoundEvents.SOUL_SOIL_HIT,
            () -> SoundEvents.SOUL_SAND_FALL
    );
}
