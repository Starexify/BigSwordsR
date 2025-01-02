package net.nova.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;
import net.nova.BigSwordsR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AtlasesProvider implements DataProvider {
    public final FabricDataOutput output;
    public final Map<Identifier, JsonObject> atlas = new HashMap<>();

    protected static final Identifier BLOCKS_ATLAS = Identifier.ofVanilla("blocks");
    protected static final Identifier ARMOR_TRIMS = Identifier.ofVanilla("armor_trims");

    public AtlasesProvider(FabricDataOutput output) {
        this.output = output;
    }

    // Add here the palettes
    public final Map<String, Identifier> permutations = Map.of(
            "livingmetal", BigSwordsR.rl("trims/color_palettes/livingmetal"),
            "livingmetal_darker", BigSwordsR.rl("trims/color_palettes/livingmetal_darker")
    );

    // Just some lists of things idk
    public final List<Identifier> textures = List.of(
            Identifier.ofVanilla("trims/items/leggings_trim"),
            Identifier.ofVanilla("trims/items/chestplate_trim"),
            Identifier.ofVanilla("trims/items/helmet_trim"),
            Identifier.ofVanilla("trims/items/boots_trim")
    );

    public final List<Identifier> trimTextures = List.of(
            Identifier.ofVanilla("trims/entity/humanoid/coast"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/coast"),
            Identifier.ofVanilla("trims/entity/humanoid/sentry"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/sentry"),
            Identifier.ofVanilla("trims/entity/humanoid/dune"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/dune"),
            Identifier.ofVanilla("trims/entity/humanoid/wild"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/wild"),
            Identifier.ofVanilla("trims/entity/humanoid/ward"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/ward"),
            Identifier.ofVanilla("trims/entity/humanoid/eye"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/eye"),
            Identifier.ofVanilla("trims/entity/humanoid/vex"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/vex"),
            Identifier.ofVanilla("trims/entity/humanoid/tide"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/tide"),
            Identifier.ofVanilla("trims/entity/humanoid/snout"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/snout"),
            Identifier.ofVanilla("trims/entity/humanoid/rib"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/rib"),
            Identifier.ofVanilla("trims/entity/humanoid/spire"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/spire"),
            Identifier.ofVanilla("trims/entity/humanoid/wayfinder"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/wayfinder"),
            Identifier.ofVanilla("trims/entity/humanoid/shaper"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/shaper"),
            Identifier.ofVanilla("trims/entity/humanoid/silence"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/silence"),
            Identifier.ofVanilla("trims/entity/humanoid/raiser"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/raiser"),
            Identifier.ofVanilla("trims/entity/humanoid/host"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/host"),
            Identifier.ofVanilla("trims/entity/humanoid/flow"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/flow"),
            Identifier.ofVanilla("trims/entity/humanoid/bolt"),
            Identifier.ofVanilla("trims/entity/humanoid_leggings/bolt")
    );

    private JsonObject createPalettedPermutationsSource(List<Identifier> textures, Identifier palette, Map<String, Identifier> permutations) {
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

    private JsonObject createAtlasDefinition(List<JsonObject> sources) {
        JsonObject definition = new JsonObject();
        JsonArray sourcesArray = new JsonArray();
        sources.forEach(sourcesArray::add);
        definition.add("sources", sourcesArray);
        return definition;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        JsonObject blocksAtlas = createAtlasDefinition(List.of(
                createPalettedPermutationsSource(
                        textures,
                        Identifier.ofVanilla("trims/color_palettes/trim_palette"),
                        permutations
                )
        ));

        JsonObject armorTrimsAtlas = createAtlasDefinition(List.of(
                createPalettedPermutationsSource(
                        trimTextures,
                        Identifier.ofVanilla("trims/color_palettes/trim_palette"),
                        permutations
                )
        ));

        // Add to atlas map
        atlas.put(BLOCKS_ATLAS, blocksAtlas);
        atlas.put(ARMOR_TRIMS, armorTrimsAtlas);

        // Write each atlas to its own file
        List<CompletableFuture<?>> futures = new ArrayList<>();

        atlas.forEach((id, definition) -> {
            futures.add(DataProvider.writeToPath(
                    writer,
                    definition,
                    output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "atlases")
                            .resolveJson(id)
            ));
        });

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "BSR Atlas Generator";
    }
}
