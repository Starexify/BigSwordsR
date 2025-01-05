package net.nova.big_swords.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.Sounds;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class SoundsProvider implements DataProvider {
    public final FabricDataOutput output;
    public final Map<Identifier, JsonObject> sounds = new HashMap<>();

    public SoundsProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        addSound(Sounds.GLAIVE_SWING);
        addSound(Sounds.GLAIVE_HIT);
        addSound(Sounds.SCYTHE_SLASH);
        addSound(Sounds.REAPER_SLASH);

        JsonObject json = new JsonObject();
        sounds.forEach((id, definition) -> json.add(id.getPath(), definition));

        return DataProvider.writeToPath(writer, json,
                output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "").resolveJson(BigSwordsR.rl("sounds")));
    }

    public void addSound(SoundEvent soundEvent) {
        JsonObject definition = new JsonObject();
        JsonArray soundsArray = new JsonArray();

        soundsArray.add(new JsonPrimitive(soundEvent.id().toString()));

        definition.add("sounds", soundsArray);
        definition.addProperty("subtitle", getSubtitle(soundEvent));

        sounds.put(soundEvent.id(), definition);
    }

    public static String getSubtitle(SoundEvent soundEvent) {
        return "sounds." + MODID + "." + soundEvent.id();
    }

    @Override
    public String getName() {
        return "BSR SoundsGenerator";
    }
}
