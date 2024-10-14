package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;
import net.nova.big_swords.BigSwordsR;

import java.util.List;
import java.util.Map;

import static net.nova.big_swords.BigSwordsR.MODID;

public class AtlasesProvider extends SpriteSourceProvider {
    protected static final ResourceLocation ARMOR_TRIMS = new ResourceLocation("armor_trims");

    public AtlasesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper, MODID);
    }

    // Add here the palettes
    private final Map<String, ResourceLocation> permutations = Map.of(
            "livingmetal", BigSwordsR.rl("trims/color_palettes/livingmetal"),
            "livingmetal_darker", BigSwordsR.rl("trims/color_palettes/livingmetal_darker")
    );

    // Just some lists of things idk
    private final List<ResourceLocation> textures = List.of(
            new ResourceLocation("trims/items/leggings_trim"),
            new ResourceLocation("trims/items/chestplate_trim"),
            new ResourceLocation("trims/items/helmet_trim"),
            new ResourceLocation("trims/items/boots_trim")
    );

    private final List<ResourceLocation> trimTextures = List.of(
            new ResourceLocation("trims/models/armor/coast"),
            new ResourceLocation("trims/models/armor/coast_leggings"),
            new ResourceLocation("trims/models/armor/sentry"),
            new ResourceLocation("trims/models/armor/sentry_leggings"),
            new ResourceLocation("trims/models/armor/dune"),
            new ResourceLocation("trims/models/armor/dune_leggings"),
            new ResourceLocation("trims/models/armor/wild"),
            new ResourceLocation("trims/models/armor/wild_leggings"),
            new ResourceLocation("trims/models/armor/ward"),
            new ResourceLocation("trims/models/armor/ward_leggings"),
            new ResourceLocation("trims/models/armor/eye"),
            new ResourceLocation("trims/models/armor/eye_leggings"),
            new ResourceLocation("trims/models/armor/vex"),
            new ResourceLocation("trims/models/armor/vex_leggings"),
            new ResourceLocation("trims/models/armor/tide"),
            new ResourceLocation("trims/models/armor/tide_leggings"),
            new ResourceLocation("trims/models/armor/snout"),
            new ResourceLocation("trims/models/armor/snout_leggings"),
            new ResourceLocation("trims/models/armor/rib"),
            new ResourceLocation("trims/models/armor/rib_leggings"),
            new ResourceLocation("trims/models/armor/spire"),
            new ResourceLocation("trims/models/armor/spire_leggings"),
            new ResourceLocation("trims/models/armor/wayfinder"),
            new ResourceLocation("trims/models/armor/wayfinder_leggings"),
            new ResourceLocation("trims/models/armor/shaper"),
            new ResourceLocation("trims/models/armor/shaper_leggings"),
            new ResourceLocation("trims/models/armor/silence"),
            new ResourceLocation("trims/models/armor/silence_leggings"),
            new ResourceLocation("trims/models/armor/raiser"),
            new ResourceLocation("trims/models/armor/raiser_leggings"),
            new ResourceLocation("trims/models/armor/host"),
            new ResourceLocation("trims/models/armor/host_leggings"),
            new ResourceLocation("trims/models/armor/flow"),
            new ResourceLocation("trims/models/armor/flow_leggings"),
            new ResourceLocation("trims/models/armor/bolt"),
            new ResourceLocation("trims/models/armor/bolt_leggings")
    );

    @Override
    protected void addSources() {
/*        atlas(SpriteSourceProvider.BLOCKS_ATLAS).addSource(new PalettedPermutations(
                textures,
                new ResourceLocation("trims/color_palettes/trim_palette"),
                permutations
        ));

        atlas(ARMOR_TRIMS).addSource(new PalettedPermutation(
                trimTextures,
                new ResourceLocation("trims/color_palettes/trim_palette"),
                permutations
        ));*/
    }
}
