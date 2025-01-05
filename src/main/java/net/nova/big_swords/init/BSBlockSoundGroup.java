package net.nova.big_swords.init;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BSBlockSoundGroup {
    public static BlockSoundGroup LIVINGMETAL_BLOCK = new BlockSoundGroup(
            1.0F, 1.0F,
            SoundEvents.PARTICLE_SOUL_ESCAPE.value(),
            SoundEvents.BLOCK_SOUL_SAND_STEP,
            SoundEvents.BLOCK_METAL_PLACE,
            SoundEvents.BLOCK_SOUL_SOIL_HIT,
            SoundEvents.BLOCK_SOUL_SAND_FALL
    );
}
