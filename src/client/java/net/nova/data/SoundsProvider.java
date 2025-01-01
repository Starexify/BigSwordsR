package net.nova.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundEvent;
import net.nova.init.Sounds;

import java.util.concurrent.CompletableFuture;

import static net.nova.BigSwordsR.MODID;

public class SoundsProvider extends FabricDynamicRegistryProvider {
    public SoundsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {

        addSound(entries, Sounds.GLAIVE_SWING);
        addSound(entries, Sounds.GLAIVE_HIT);
        addSound(entries, Sounds.SCYTHE_SLASH);
        addSound(entries, Sounds.REAPER_SLASH);
    }

    public void addSound(Entries entries, SoundEvent soundEvent) {
        entries.add(soundEvent, definition()
                .subtitle(getSubtitle(soundEvent))
                .with(sound(soundEvent.id())));
    }

    public static String getSubtitle(SoundEvent soundEvent) {
        return "sounds." + MODID + "." + soundEvent.id();
    }

    @Override
    public String getName() {
        return "BSR SoundsGenerator";
    }
}
