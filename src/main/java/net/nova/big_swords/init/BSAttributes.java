package net.nova.big_swords.init;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;

import java.util.UUID;

public class BSAttributes {
    public static final UUID MIN_CHARGED_DAMAGE_MODIFIER_UUID = UUID.fromString("8B48A3E9-F1A5-4D2E-8342-AEC05A487F9B");
    public static final UUID MAX_CHARGED_DAMAGE_MODIFIER_UUID = UUID.fromString("1D5E72F8-B037-4E92-A7C1-3F858BE12D6A");

    public static final EntityAttribute MIN_CHARGED_DAMAGE = new ClampedEntityAttribute("min_charged_damage", 0.0, 0.0, Double.MAX_VALUE);
    public static final EntityAttribute MAX_CHARGED_DAMAGE = new ClampedEntityAttribute("max_charged_damage", 0.0, 0.0, Double.MAX_VALUE);
}
