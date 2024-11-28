package net.nova.big_swords.init;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSDataComponents {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MODID);

    public static final Supplier<DataComponentType<Integer>> BLOOD_LEVEL = COMPONENTS.registerComponentType(
            "blood_level", builder -> builder.persistent(ExtraCodecs.intRange(0, 9)).networkSynchronized(ByteBufCodecs.VAR_INT)
    );
}
