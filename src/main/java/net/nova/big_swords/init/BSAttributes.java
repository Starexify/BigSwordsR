package net.nova.big_swords.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, MODID);

    public static final Holder<Attribute> MIN_CHARGED_DAMAGE = ATTRIBUTES.register("min_charged_damage", () -> new RangedAttribute("attribute.name.min_charged_damage", 0.0, 0.0, 2048.0));
    public static final Holder<Attribute> MAX_CHARGED_DAMAGE = ATTRIBUTES.register("max_charged_damage", () -> new RangedAttribute("attribute.name.max_charged_damage", 0.0, 0.0, 2048.0));

}
