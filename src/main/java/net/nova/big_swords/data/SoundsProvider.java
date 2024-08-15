package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import net.nova.big_swords.init.Sounds;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class SoundsProvider extends SoundDefinitionsProvider {
    protected SoundsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        addSound(Sounds.GLAIVE_SWING);
        addSound(Sounds.GLAIVE_HIT);
    }

    // Some methods for simpler generation
    protected void addSound(final Supplier<SoundEvent> soundEvent) {
        this.add(soundEvent.get(), definition()
                .subtitle(getSubtitle(soundEvent))
                .with(sound(soundEvent.get().getLocation().toString())));
    }

    public static String getSubtitle(Supplier<SoundEvent> soundEvent) {
        return "sounds." + MODID + "." + soundEvent.get().getLocation().getPath();
    }
}
