package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.nova.big_swords.BigSwordsR;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class BSModelTemplates {
    public static final ModelTemplate FLAT_HANDHELD_GLAIVE_ITEM = createItem("handheld_glaive", TextureSlot.LAYER0);

    public static ModelTemplate createItem(String name, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(BigSwordsR.rl("item/" + name)), Optional.empty(), textureSlots);
    }
}
