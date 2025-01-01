package net.nova.data.models;

import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;
import net.nova.BigSwordsR;

import java.util.Optional;

public class BSModels {
    public static final Model HANDHELD_GLAIVE = item("handheld_glaive", TextureKey.LAYER0);
    public static final Model HANDHELD_SHIELD = item("template_shield", TextureKey.LAYER0);
    public static final Model HANDHELD_SHIELD_BLOCKING = item("template_shield_blocking", TextureKey.LAYER0);

    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(BigSwordsR.rl("item/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
