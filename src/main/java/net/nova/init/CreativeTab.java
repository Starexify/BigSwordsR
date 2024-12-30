package net.nova.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.nova.BigSwordsR;

public class CreativeTab {
    public static final ItemGroup BIG_SWORDS_TAB = Registry.register(Registries.ITEM_GROUP, BigSwordsR.rl("big_swords_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BSItems.BIOMASS_SEED))
                    .displayName(Text.translatable("itemgroup.big_swords.big_swords_tab"))
                    .entries(((displayContext, entries) -> {
                        entries.add(BSItems.BIOMASS_SEED);
                    })).build());

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Creative Tab");
    }
}
