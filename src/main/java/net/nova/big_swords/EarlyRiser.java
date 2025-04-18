package net.nova.big_swords;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class EarlyRiser implements Runnable {
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

        String armorMaterialClass = remapper.mapClassName("intermediary", "net.minecraft.class_1029");
        ClassTinkerers.enumBuilder(armorMaterialClass, "I", "[I", "I")
                .addEnum("LIVINGMETAL", 29, new int[]{3, 5, 7, 3}, 12)
                .build();
    }
}
