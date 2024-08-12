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
            // Livingmetal Stuff
            output.accept(BSItems.LIVINGMETAL_HELMET);
            output.accept(BSItems.LIVINGMETAL_CHESTPLATE);
            output.accept(BSItems.LIVINGMETAL_LEGGINGS);
            output.accept(BSItems.LIVINGMETAL_BOOTS);
            output.accept(BSItems.LIVINGMETAL_SWORD);
            output.accept(BSItems.LIVINGMETAL_PICKAXE);
            output.accept(BSItems.LIVINGMETAL_AXE);
            output.accept(BSItems.LIVINGMETAL_SHOVEL);
            output.accept(BSItems.LIVINGMETAL_HOE);
            output.accept(BSBlocks.LIVINGMETAL_BLOCK);
            output.accept(BSItems.LIVINGMETAL_INGOT);


            // Biomass Stuff
            output.accept(BSItems.BIOMASS_SWORD);
            output.accept(BSItems.BIOMASS_PICKAXE);
            output.accept(BSItems.BIOMASS_AXE);
            output.accept(BSItems.BIOMASS_SHOVEL);
            output.accept(BSItems.BIOMASS_HOE);
            output.accept(BSItems.BIOMASS);

            // Sticks
            output.accept(BSItems.GIANT_WOODEN_STICK);
            output.accept(BSItems.GIANT_BLAZE_ROD);
            output.accept(BSItems.GIANT_LIVINGMETAL_HANDLE);

            // Ender Upgrade
            output.accept(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE);

            // Big Swords
            output.accept(BSItems.WOODEN_BIG_SWORD);
            output.accept(BSItems.STONE_BIG_SWORD);
            output.accept(BSItems.IRON_BIG_SWORD);
            output.accept(BSItems.GOLDEN_BIG_SWORD);
            output.accept(BSItems.DIAMOND_BIG_SWORD);
            output.accept(BSItems.NETHERITE_BIG_SWORD);
            output.accept(BSItems.PATCHWORK_BIG_SWORD);
            output.accept(BSItems.SKULL_BIG_SWORD);
            output.accept(BSItems.QUARTZ_BIG_SWORD);
            output.accept(BSItems.OBSIDIAN_BIG_SWORD);
            output.accept(BSItems.ENDER_BIG_SWORD);
            output.accept(BSItems.LIVINGMETAL_BIG_SWORD);
        });

        builder.icon(() -> new ItemStack(BSItems.ENDER_BIG_SWORD.asItem()));
        builder.title(Component.translatable(BIG_SWORDS_TAB_TITLE));

        return builder.build();
    });
}
