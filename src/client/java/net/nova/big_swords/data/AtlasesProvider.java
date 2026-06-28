package net.nova.big_swords.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AtlasesProvider implements DataProvider {
  public final FabricPackOutput output;
  public final Map<Identifier, JsonObject> atlas = new HashMap<>();

  protected static final Identifier ITEMS_ATLAS = Identifier.withDefaultNamespace("items");

  public AtlasesProvider(FabricPackOutput output) {
    this.output = output;
  }

  // Add here the palettes
  public final Map<String, Identifier> permutations = Map.of(
      "livingmetal", Identifier.withDefaultNamespace("trim/livingmetal"),
      "livingmetal_darker", Identifier.withDefaultNamespace("trim/livingmetal_darker")
  );

  // Just some lists of things idk
  public final List<Identifier> textures = List.of(
      Identifier.withDefaultNamespace("trims/items/leggings_trim"),
      Identifier.withDefaultNamespace("trims/items/chestplate_trim"),
      Identifier.withDefaultNamespace("trims/items/helmet_trim"),
      Identifier.withDefaultNamespace("trims/items/boots_trim")
  );

  @Override
  public CompletableFuture<?> run(CachedOutput writer) {
    JsonObject itemsAtlas = createAtlasDefinition(List.of(createPalettedPermutationsSource(textures, Identifier.withDefaultNamespace("trim_base"), permutations)));
    atlas.put(ITEMS_ATLAS, itemsAtlas);

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
