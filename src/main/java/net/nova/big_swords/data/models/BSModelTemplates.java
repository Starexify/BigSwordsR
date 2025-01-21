package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.nova.big_swords.BigSwordsR;

import java.util.Optional;

public class BSModelTemplates {
    public static final ModelTemplate FLAT_HANDHELD_GLAIVE_ITEM = createItem("handheld_glaive", TextureSlot.LAYER0);
    public static final ModelTemplate FLAT_HANDHELD_SHIELD_ITEM = createItem("template_shield", TextureSlot.LAYER0);
    public static final ModelTemplate FLAT_HANDHELD_SHIELD_BLOCKING_ITEM = createItem("template_shield_blocking", TextureSlot.LAYER0);

    public static ModelTemplate createItem(String name, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(BigSwordsR.rl("item/" + name)), Optional.empty(), textureSlots);
    }
}
