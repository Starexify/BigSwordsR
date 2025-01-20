package net.nova.big_swords.item.attributes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.nova.big_swords.init.BSAttributes;
import net.nova.big_swords.init.BSToolMaterial;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BSRangedAttribute extends RangedAttribute {
    private Random random = new Random();

    public BSRangedAttribute(String descriptionId, double defaultValue, double min, double max) {
        super(descriptionId, defaultValue, min, max);
    }

    @Override
    public double getDefaultValue() {
        return super.getDefaultValue();
    }

    @Override
    public double sanitizeValue(double value) {
        return super.sanitizeValue(value);
    }

    @Override
    public @Nullable ResourceLocation getBaseId() {
        if (this == BSAttributes.CHARGED_DAMAGE.value()) return BSToolMaterial.MIN_CHARGED_DAMAGE_ID;
        if (this == BSAttributes.CHARGED_DAMAGE.value()) return BSToolMaterial.MAX_CHARGED_DAMAGE_ID;
        return super.getBaseId();
    }
}
