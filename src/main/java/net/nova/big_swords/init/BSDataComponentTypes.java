package net.nova.big_swords.init;

import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.dynamic.Codecs;
import net.nova.big_swords.BigSwordsR;

import java.util.function.UnaryOperator;

public class BSDataComponentTypes {
    public static final ComponentType<Integer> BLOOD_LEVEL = register(
            "blood_level", builder -> builder.codec(Codecs.rangedInt(0, 9)).packetCodec(PacketCodecs.VAR_INT)
    );

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, BigSwordsR.rl(name), builderOperator.apply(ComponentType.builder()).build());
    }

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Data Components");
    }
}
