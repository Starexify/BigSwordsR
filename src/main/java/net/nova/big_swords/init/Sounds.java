package net.nova.big_swords.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.BigSwordsR;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class Sounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MODID);

    public static final Supplier<SoundEvent> GLAIVE_SWING = registerSoundEvents("glaive_swing");
    public static final Supplier<SoundEvent> GLAIVE_HIT = registerSoundEvents("glaive_hit");

    public static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(BigSwordsR.rl(name)));
    }
}
