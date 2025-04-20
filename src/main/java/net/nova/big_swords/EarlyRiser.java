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
                .addEnum("PATCHWORK", 1, 30, 1.0F, -1.5F, 16).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("SKULL", 1, 103, 2.0F, -0.5F, 13).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("QUARTZ", 2, 187, 5.0F, 1.0F, 17).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("OBSIDIAN", 3, 1171, 9.0F, 3.5F, 12).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("ENDER", 4, 3046, 12.0F, 5.5F, 18).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("LIVINGMETAL", 2, 375, 7.5F, 2.5F, 17).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("BIOMASS", 2, 188, 8.0F, 2.0F, 18).build();
        ClassTinkerers.enumBuilder(toolMaterialClass, "I", "I", "F", "F", "I")
                .addEnum("REAPER", 1, 206, 2.0F, -0.5F, 18).build();
    }
}