package net.nova.big_swords.init;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.nova.big_swords.BigSwordsR;

public class BSAttributes {
    public static final RegistryEntry<EntityAttribute> MIN_CHARGED_DAMAGE = register("min_charged_damage", new ClampedEntityAttribute("attribute.name.min_charged_damage", 0.0, 0.0, 2048.0));
    public static final RegistryEntry<EntityAttribute> MAX_CHARGED_DAMAGE = register("max_charged_damage", new ClampedEntityAttribute("attribute.name.max_charged_damage", 0.0, 0.0, 2048.0));

    public static RegistryEntry<Attribute> register(String id, EntityAttribute attribute) {
        return Registry.registerReference(Registries.ATTRIBUTE, BigSwordsR.rl(id), attribute);
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Attributes");
    }
}
