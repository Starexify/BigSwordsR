package net.nova.big_swords.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, MODID);

    public static final Holder<Attribute> CHARGED_DAMAGE = ATTRIBUTES.register("charged_damage", () -> new RangedAttribute("attribute.name.charged_damage", 2.0, 0.0, 2048.0));
}
