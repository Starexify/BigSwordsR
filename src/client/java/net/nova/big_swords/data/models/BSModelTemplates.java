package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.nova.big_swords.BigSwordsR;

import java.util.Optional;

public interface BSModelTemplates {
    ModelTemplate FLAT_HANDHELD_GLAIVE_ITEM = createItem("handheld_glaive", TextureSlot.LAYER0);
    ModelTemplate FLAT_HANDHELD_SHIELD_ITEM = createItem("template_shield", TextureSlot.LAYER0);
    ModelTemplate FLAT_HANDHELD_SHIELD_BLOCKING_ITEM = createItem("template_shield_blocking", TextureSlot.LAYER0);

    static ModelTemplate createItem(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(BigSwordsR.rl("item/" + parent)), Optional.empty(), textureSlots);
    }
}
