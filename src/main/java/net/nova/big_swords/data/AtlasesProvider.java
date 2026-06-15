package net.nova.big_swords.data;

import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.AtlasIds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.data.SpriteSourceProvider;
import net.nova.big_swords.BigSwordsR;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class AtlasesProvider extends SpriteSourceProvider {
  public AtlasesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(output, lookupProvider, MODID);
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
  protected void gather() {
    atlas(AtlasIds.BLOCKS).addSource(new PalettedPermutations(
        textures,
        Identifier.withDefaultNamespace("trims/color_palettes/trim_palette"),
        permutations
    ));

    atlas(AtlasIds.ARMOR_TRIMS).addSource(new PalettedPermutations(
        trimTextures,
        Identifier.withDefaultNamespace("trims/color_palettes/trim_palette"),
        permutations
    ));
  }
}
