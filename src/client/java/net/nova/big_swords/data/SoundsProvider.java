package net.nova.big_swords.data;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.nova.big_swords.init.Sounds;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class SoundsProvider extends FabricSoundsProvider {
    public SoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, SoundExporter soundExporter) {
        soundExporter.add(Sounds.GLAIVE_SWING, SoundTypeBuilder.of().subtitle(getSubtitle(Sounds.GLAIVE_SWING)).sound(SoundTypeBuilder.EntryBuilder.ofFile(Sounds.GLAIVE_SWING.location())));
        soundExporter.add(Sounds.GLAIVE_HIT, SoundTypeBuilder.of().subtitle(getSubtitle(Sounds.GLAIVE_HIT)).sound(SoundTypeBuilder.EntryBuilder.ofFile(Sounds.GLAIVE_SWING.location())));
        soundExporter.add(Sounds.SCYTHE_SLASH, SoundTypeBuilder.of().subtitle(getSubtitle(Sounds.SCYTHE_SLASH)).sound(SoundTypeBuilder.EntryBuilder.ofFile(Sounds.GLAIVE_SWING.location())));
        soundExporter.add(Sounds.REAPER_SLASH, SoundTypeBuilder.of().subtitle(getSubtitle(Sounds.REAPER_SLASH)).sound(SoundTypeBuilder.EntryBuilder.ofFile(Sounds.GLAIVE_SWING.location())));
    }

    public static String getSubtitle(SoundEvent soundEvent) {
        return "sounds." + MODID + "." + soundEvent.location();
    }

    @Override
    public String getName() {
        return "BSR SoundsGenerator";
    }
}
