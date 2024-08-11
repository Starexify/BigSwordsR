package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.nova.big_swords.BigSwordsR.MODID;

public class CreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static String BIG_SWORDS_TAB_TITLE = "big_swords.creativetab";

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BIG_SWORDS_TAB = CREATIVE_TAB.register("big_swords_tab", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();

        builder.displayItems((itemDisplay, output) -> {
            // Sticks
            output.accept(BSItems.GIANT_WOODEN_STICK);

            // Big Swords
            output.accept(BSItems.WOODEN_BIG_SWORD);
        });

        builder.icon(() -> new ItemStack(BSItems.WOODEN_BIG_SWORD.asItem()));
        builder.title(Component.translatable(BIG_SWORDS_TAB_TITLE));

        return builder.build();
    });
}
