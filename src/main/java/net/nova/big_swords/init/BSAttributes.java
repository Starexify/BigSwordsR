package net.nova.big_swords.init;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.nova.big_swords.BigSwordsR;

public class BSAttributes {
  public static final Holder<Attribute> MIN_CHARGED_DAMAGE = register("min_charged_damage", new RangedAttribute("attribute.name.min_charged_damage", 0.0, 0.0, 2048.0));
  public static final Holder<Attribute> MAX_CHARGED_DAMAGE = register("max_charged_damage", new RangedAttribute("attribute.name.max_charged_damage", 0.0, 0.0, 2048.0));

  public static Holder<Attribute> register(String id, Attribute attribute) {
    return Registry.registerForHolder(BuiltInRegistries.ATTRIBUTE, BigSwordsR.rl(id), attribute);
  }

  public static void initialize() {
    BigSwordsR.LOGGER.info("Registering Attributes");
  }
}
