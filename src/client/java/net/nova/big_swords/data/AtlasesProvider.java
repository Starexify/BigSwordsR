package net.nova.big_swords.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.nova.big_swords.BigSwordsR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AtlasesProvider implements DataProvider {
  public final FabricPackOutput output;
  public final Map<Identifier, JsonObject> atlas = new HashMap<>();

  protected static final Identifier BLOCKS_ATLAS = Identifier.withDefaultNamespace("blocks");
  protected static final Identifier ARMOR_TRIMS = Identifier.withDefaultNamespace("armor_trims");

  public AtlasesProvider(FabricPackOutput output) {
    this.output = output;
  }

  // Add here the palettes
  public final Map<String, Identifier> permutations = Map.of(
      "livingmetal", BigSwordsR.rl("trims/color_palettes/livingmetal"),
      "livingmetal_darker", BigSwordsR.rl("trims/color_palettes/livingmetal_darker")
  );

  // Just some lists of things idk
  public final List<Identifier> textures = List.of(
      Identifier.withDefaultNamespace("trims/items/leggings_trim"),
      Identifier.withDefaultNamespace("trims/items/chestplate_trim"),
      Identifier.withDefaultNamespace("trims/items/helmet_trim"),
      Identifier.withDefaultNamespace("trims/items/boots_trim")
  );

  public final List<Identifier> trimTextures = List.of(
      Identifier.withDefaultNamespace("trims/entity/humanoid/coast"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/coast"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/sentry"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/sentry"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/dune"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/dune"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/wild"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/wild"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/ward"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/ward"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/eye"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/eye"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/vex"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/vex"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/tide"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/tide"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/snout"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/snout"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/rib"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/rib"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/spire"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/spire"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/wayfinder"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/wayfinder"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/shaper"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/shaper"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/silence"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/silence"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/raiser"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/raiser"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/host"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/host"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/flow"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/flow"),
      Identifier.withDefaultNamespace("trims/entity/humanoid/bolt"),
      Identifier.withDefaultNamespace("trims/entity/humanoid_leggings/bolt")
  );

  @Override
  public CompletableFuture<?> run(CachedOutput writer) {
    JsonObject blocksAtlas = createAtlasDefinition(List.of(createPalettedPermutationsSource(textures, Identifier.withDefaultNamespace("trims/color_palettes/trim_palette"), permutations)));
    JsonObject armorTrimsAtlas = createAtlasDefinition(List.of(createPalettedPermutationsSource(trimTextures, Identifier.withDefaultNamespace("trims/color_palettes/trim_palette"), permutations)));

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
  public JsonObject createPalettedPermutationsSource(List<Identifier> textures, Identifier palette, Map<String, Identifier> permutations) {
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
