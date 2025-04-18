package net.nova.big_swords;

import com.chocohead.mm.api.ClassTinkerers;

public class EarlyRiser implements Runnable {
    @Override
    public void run() {
        ClassTinkerers.enumBuilder("net.minecraft.item.ArmorMaterial", "I", "[I", "I")
                .addEnum("LIVINGMETAL", 29, new int[]{3, 5, 7, 3}, 12)
                .build();

        ClassTinkerers.enumBuilder("net.minecraft.item.ToolMaterial", "I", "I", "F", "F", "I")
                .addEnum("LIVINGMETAL", 2, 188, 8.0F, 2.0F, 18)
                .build();
    }
}
