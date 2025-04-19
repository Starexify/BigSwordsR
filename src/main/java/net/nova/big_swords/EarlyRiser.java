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
                .addEnum("LIVINGMETAL", 29, new int[]{3, 5, 7, 3}, 12).build();
        ClassTinkerers.enumBuilder(armorMaterialClass, "I", "[I", "I")
                .addEnum("BIOMASS", 29, new int[]{2, 5, 7, 3}, 14).build();

        String toolMaterialClass = remapper.mapClassName("intermediary", "net.minecraft.class_1070");
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("LIVINGMETAL", 2, 375, 7.5F, 2.5F, 17).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("BIOMASS", 2, 188, 8.0F, 2.0F, 18).build();
    }
}