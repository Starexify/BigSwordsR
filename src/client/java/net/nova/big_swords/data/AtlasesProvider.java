package net.nova.big_swords.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.nova.big_swords.BigSwordsR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AtlasesProvider implements DataProvider {
    public final FabricDataOutput output;
    public final Map<ResourceLocation, JsonObject> atlas = new HashMap<>();

    protected static final ResourceLocation BLOCKS_ATLAS = ResourceLocation.withDefaultNamespace("blocks");
    protected static final ResourceLocation ARMOR_TRIMS = ResourceLocation.withDefaultNamespace("armor_trims");

    public AtlasesProvider(FabricDataOutput output) {
        this.output = output;
    }

    // Add here the palettes
    public final Map<String, ResourceLocation> permutations = Map.of(
            "livingmetal", BigSwordsR.rl("trims/color_palettes/livingmetal"),
            "livingmetal_darker", BigSwordsR.rl("trims/color_palettes/livingmetal_darker")
    );

    // Just some lists of things idk
    public final List<ResourceLocation> textures = List.of(
            ResourceLocation.withDefaultNamespace("trims/items/leggings_trim"),
            ResourceLocation.withDefaultNamespace("trims/items/chestplate_trim"),
            ResourceLocation.withDefaultNamespace("trims/items/helmet_trim"),
            ResourceLocation.withDefaultNamespace("trims/items/boots_trim")
    );

    public final List<ResourceLocation> trimTextures = List.of(
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/coast"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/coast"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/sentry"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/sentry"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/dune"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/dune"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/wild"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/wild"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/ward"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/ward"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/eye"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/eye"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/vex"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/vex"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/tide"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/tide"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/snout"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/snout"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/rib"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/rib"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/spire"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/spire"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/wayfinder"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/wayfinder"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/shaper"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/shaper"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/silence"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/silence"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/raiser"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/raiser"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/host"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/host"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/flow"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/flow"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/bolt"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/bolt")
    );

    @Override
    public CompletableFuture<?> run(CachedOutput writer) {
        JsonObject blocksAtlas = createAtlasDefinition(List.of(createPalettedPermutationsSource(textures, ResourceLocation.withDefaultNamespace("trims/color_palettes/trim_palette"), permutations)));
        JsonObject armorTrimsAtlas = createAtlasDefinition(List.of(createPalettedPermutationsSource(trimTextures, ResourceLocation.withDefaultNamespace("trims/color_palettes/trim_palette"), permutations)));

        // Add to atlas map
        atlas.put(BLOCKS_ATLAS, blocksAtlas);
        atlas.put(ARMOR_TRIMS, armorTrimsAtlas);

        // Write each atlas to its own file
        List<CompletableFuture<?>> futures = new ArrayList<>();

        atlas.forEach((id, definition) -> futures.add(DataProvider.saveStable(writer, definition,
                output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "atlases").json(id))
        ));
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "BSR Atlas Generator";
    }

    // Methods
    public JsonObject createPalettedPermutationsSource(List<ResourceLocation> textures, ResourceLocation palette, Map<String, ResourceLocation> permutations) {
        JsonObject source = new JsonObject();
        source.addProperty("type", "paletted_permutations");

        // Add textures array
        JsonArray texturesArray = new JsonArray();
        textures.forEach(texture -> texturesArray.add(texture.toString()));
        source.add("textures", texturesArray);

        // Add palette
        source.addProperty("palette_key", palette.toString());

        // Add permutations
        JsonObject permutationsObject = new JsonObject();
        permutations.forEach((key, value) -> permutationsObject.addProperty(key, value.toString()));
        source.add("permutations", permutationsObject);

        return source;
    }

    public JsonObject createAtlasDefinition(List<JsonObject> sources) {
        JsonObject definition = new JsonObject();
        JsonArray sourcesArray = new JsonArray();
        sources.forEach(sourcesArray::add);
        definition.add("sources", sourcesArray);
        return definition;
    }
}
