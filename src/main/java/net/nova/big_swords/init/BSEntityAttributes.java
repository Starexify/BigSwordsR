package net.nova.big_swords.init;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.nova.big_swords.BigSwordsR;

public class BSEntityAttributes {
    public static final RegistryEntry<EntityAttribute> CHARGED_DAMAGE = register("charged_damage", new ClampedEntityAttribute("attribute.name.charged_damage", 2.0, 0.0, 2048.0));

    public static RegistryEntry<EntityAttribute> register(String id, EntityAttribute attribute) {
        return Registry.registerReference(Registries.ATTRIBUTE, BigSwordsR.rl(id), attribute);
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Attributes");
    }
}
