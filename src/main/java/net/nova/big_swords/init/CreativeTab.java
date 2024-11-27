package net.nova.big_swords.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class CreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static String BIG_SWORDS_TAB_TITLE = "big_swords.creativetab";

    public static final Holder<CreativeModeTab> BIG_SWORDS_TAB = CREATIVE_TAB.register("big_swords_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(BSItems.ENDER_BIG_SWORD.get()))
            .title(Component.translatable(BIG_SWORDS_TAB_TITLE))
            .displayItems((itemDisplayParameters, output) -> {
                // Biomass
                output.accept(BSItems.BIOMASS_HELMET);
                output.accept(BSItems.BIOMASS_CHESTPLATE);
                output.accept(BSItems.BIOMASS_LEGGINGS);
                output.accept(BSItems.BIOMASS_BOOTS);
                output.accept(BSItems.BIOMASS_SWORD);
                output.accept(BSItems.BIOMASS_PICKAXE);
                output.accept(BSItems.BIOMASS_AXE);
                output.accept(BSItems.BIOMASS_SHOVEL);
                output.accept(BSItems.BIOMASS_HOE);

                // Livingmetal
                output.accept(BSItems.LIVINGMETAL_HELMET);
                output.accept(BSItems.LIVINGMETAL_CHESTPLATE);
                output.accept(BSItems.LIVINGMETAL_LEGGINGS);
                output.accept(BSItems.LIVINGMETAL_BOOTS);
                output.accept(BSItems.LIVINGMETAL_SWORD);
                output.accept(BSItems.LIVINGMETAL_PICKAXE);
                output.accept(BSItems.LIVINGMETAL_AXE);
                output.accept(BSItems.LIVINGMETAL_SHOVEL);
                output.accept(BSItems.LIVINGMETAL_HOE);

                // Extra Stuff
                output.accept(BSItems.CREEP_BALL);
                output.accept(BSBlocks.CREEP_BLOCK);
                output.accept(BSItems.BIOMASS_SEED);
                output.accept(BSItems.SOUL);
                output.accept(BSItems.BLOOD_VIAL);

                // Materials
                output.accept(BSBlocks.BIOMASS_BLOCK);
                output.accept(BSItems.BIOMASS);
                output.accept(BSBlocks.LIVINGMETAL_BLOCK);
                output.accept(BSItems.LIVINGMETAL_INGOT);

                // Ender Upgrade
                output.accept(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE);

                // Sticks
                output.accept(BSItems.GIANT_WOODEN_STICK);
                output.accept(BSItems.GIANT_BLAZE_ROD);
                output.accept(BSItems.GIANT_LIVINGMETAL_HANDLE);

                // Big Swords
                output.accept(BSItems.WOODEN_BIG_SWORD);
                output.accept(BSItems.STONE_BIG_SWORD);
                output.accept(BSItems.IRON_BIG_SWORD);
                output.accept(BSItems.GOLDEN_BIG_SWORD);
                output.accept(BSItems.DIAMOND_BIG_SWORD);
                output.accept(BSItems.NETHERITE_BIG_SWORD);
                output.accept(BSItems.OBSIDIAN_BIG_SWORD);
                output.accept(BSItems.ENDER_BIG_SWORD);
                output.accept(BSItems.BIOMASS_BIG_SWORD);
                output.accept(BSItems.LIVINGMETAL_BIG_SWORD);
                output.accept(BSItems.QUARTZ_BIG_SWORD);
                output.accept(BSItems.SKULL_BIG_SWORD);
                output.accept(BSItems.PATCHWORK_BIG_SWORD);

                // Glaives
                output.accept(BSItems.WOODEN_GLAIVE);
                output.accept(BSItems.STONE_GLAIVE);
                output.accept(BSItems.IRON_GLAIVE);
                output.accept(BSItems.GOLDEN_GLAIVE);
                output.accept(BSItems.DIAMOND_GLAIVE);
                output.accept(BSItems.NETHERITE_GLAIVE);
                output.accept(BSItems.BIOMASS_GLAIVE);
                output.accept(BSItems.LIVINGMETAL_GLAIVE);

                // Scythes
                output.accept(BSItems.WOODEN_SCYTHE);
                output.accept(BSItems.STONE_SCYTHE);
                output.accept(BSItems.IRON_SCYTHE);
                output.accept(BSItems.GOLDEN_SCYTHE);
                output.accept(BSItems.DIAMOND_SCYTHE);
                output.accept(BSItems.NETHERITE_SCYTHE);
                output.accept(BSItems.BIOMASS_SCYTHE);
                output.accept(BSItems.LIVINGMETAL_SCYTHE);
                output.accept(BSItems.BONE_SCYTHE);
                output.accept(BSItems.SOUL_REAPER);

                // Shields
                output.accept(BSItems.WOODEN_SHIELD);
                output.accept(BSItems.GILDED_WOODEN_SHIELD);
                output.accept(BSItems.STONE_SHIELD);
                output.accept(BSItems.GILDED_STONE_SHIELD);
                output.accept(BSItems.IRON_SHIELD);
                output.accept(BSItems.GILDED_IRON_SHIELD);
                output.accept(BSItems.DIAMOND_SHIELD);
                output.accept(BSItems.GILDED_DIAMOND_SHIELD);
                output.accept(BSItems.NETHERITE_SHIELD);
                output.accept(BSItems.GILDED_NETHERITE_SHIELD);
                output.accept(BSItems.ENDER_SHIELD);
                output.accept(BSItems.GILDED_ENDER_SHIELD);
                output.accept(BSItems.BIOMASS_SHIELD);
                output.accept(BSItems.GILDED_BIOMASS_SHIELD);
                output.accept(BSItems.LIVINGMETAL_SHIELD);
                output.accept(BSItems.GILDED_LIVINGMETAL_SHIELD);
                output.accept(BSItems.QUARTZ_SHIELD);
                output.accept(BSItems.GILDED_QUARTZ_SHIELD);
                output.accept(BSItems.SKULL_SHIELD);
                output.accept(BSItems.GILDED_SKULL_SHIELD);
                output.accept(BSItems.PATCHWORK_SHIELD);
                output.accept(BSItems.GILDED_PATCHWORK_SHIELD);
            }).build()
    );
}
