package net.nova.big_swords.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nova.big_swords.BigSwordsR;

public class CreativeTab {
    public static String BIG_SWORDS_TAB_TITLE = "itemgroup.big_swords.big_swords_tab";

    public static final CreativeModeTab BIG_SWORDS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BigSwordsR.rl("big_swords_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BSItems.ENDER_BIG_SWORD))
                    .title(Component.translatable(BIG_SWORDS_TAB_TITLE))
                    .displayItems(((displayContext, entries) -> {
                        // Biomass
                        entries.accept(BSItems.BIOMASS_HELMET);
                        entries.accept(BSItems.BIOMASS_CHESTPLATE);
                        entries.accept(BSItems.BIOMASS_LEGGINGS);
                        entries.accept(BSItems.BIOMASS_BOOTS);
                        entries.accept(BSItems.BIOMASS_SWORD);
                        entries.accept(BSItems.BIOMASS_PICKAXE);
                        entries.accept(BSItems.BIOMASS_AXE);
                        entries.accept(BSItems.BIOMASS_SHOVEL);
                        entries.accept(BSItems.BIOMASS_HOE);

                        // Livingmetal
                        entries.accept(BSItems.LIVINGMETAL_HELMET);
                        entries.accept(BSItems.LIVINGMETAL_CHESTPLATE);
                        entries.accept(BSItems.LIVINGMETAL_LEGGINGS);
                        entries.accept(BSItems.LIVINGMETAL_BOOTS);
                        entries.accept(BSItems.LIVINGMETAL_SWORD);
                        entries.accept(BSItems.LIVINGMETAL_PICKAXE);
                        entries.accept(BSItems.LIVINGMETAL_AXE);
                        entries.accept(BSItems.LIVINGMETAL_SHOVEL);
                        entries.accept(BSItems.LIVINGMETAL_HOE);

                        // Extra Stuff
                        entries.accept(BSItems.CREEP_BALL);
                        entries.accept(BSBlocks.CREEP_BLOCK);
                        entries.accept(BSItems.BIOMASS_SEED);
                        entries.accept(BSItems.SOUL);
                        entries.accept(BSItems.BLOOD_VIAL);

                        // Materials
                        entries.accept(BSBlocks.BIOMASS_BLOCK);
                        entries.accept(BSItems.BIOMASS);
                        entries.accept(BSBlocks.LIVINGMETAL_BLOCK);
                        entries.accept(BSItems.LIVINGMETAL_INGOT);

                        // Ender Upgrade
                        entries.accept(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE);

                        // Sticks
                        entries.accept(BSItems.GIANT_WOODEN_STICK);
                        entries.accept(BSItems.GIANT_BLAZE_ROD);
                        entries.accept(BSItems.GIANT_LIVINGMETAL_HANDLE);

                        // Big Swords
                        entries.accept(BSItems.WOODEN_BIG_SWORD);
                        entries.accept(BSItems.STONE_BIG_SWORD);
                        entries.accept(BSItems.IRON_BIG_SWORD);
                        entries.accept(BSItems.GOLDEN_BIG_SWORD);
                        entries.accept(BSItems.DIAMOND_BIG_SWORD);
                        entries.accept(BSItems.NETHERITE_BIG_SWORD);
                        entries.accept(BSItems.OBSIDIAN_BIG_SWORD);
                        entries.accept(BSItems.ENDER_BIG_SWORD);
                        entries.accept(BSItems.BIOMASS_BIG_SWORD);
                        entries.accept(BSItems.LIVINGMETAL_BIG_SWORD);
                        entries.accept(BSItems.QUARTZ_BIG_SWORD);
                        entries.accept(BSItems.SKULL_BIG_SWORD);
                        entries.accept(BSItems.PATCHWORK_BIG_SWORD);

                        // Glaives
                        entries.accept(BSItems.WOODEN_GLAIVE);
                        entries.accept(BSItems.STONE_GLAIVE);
                        entries.accept(BSItems.IRON_GLAIVE);
                        entries.accept(BSItems.GOLDEN_GLAIVE);
                        entries.accept(BSItems.DIAMOND_GLAIVE);
                        entries.accept(BSItems.NETHERITE_GLAIVE);
                        entries.accept(BSItems.BIOMASS_GLAIVE);
                        entries.accept(BSItems.LIVINGMETAL_GLAIVE);

                        // Scythes
                        entries.accept(BSItems.WOODEN_SCYTHE);
                        entries.accept(BSItems.STONE_SCYTHE);
                        entries.accept(BSItems.IRON_SCYTHE);
                        entries.accept(BSItems.GOLDEN_SCYTHE);
                        entries.accept(BSItems.DIAMOND_SCYTHE);
                        entries.accept(BSItems.NETHERITE_SCYTHE);
                        entries.accept(BSItems.BIOMASS_SCYTHE);
                        entries.accept(BSItems.LIVINGMETAL_SCYTHE);
                        entries.accept(BSItems.BONE_SCYTHE);
                        entries.accept(BSItems.SOUL_REAPER);

                        // Shields
                        entries.accept(BSItems.WOODEN_SHIELD);
                        entries.accept(BSItems.GILDED_WOODEN_SHIELD);
                        entries.accept(BSItems.STONE_SHIELD);
                        entries.accept(BSItems.GILDED_STONE_SHIELD);
                        entries.accept(BSItems.IRON_SHIELD);
                        entries.accept(BSItems.GILDED_IRON_SHIELD);
                        entries.accept(BSItems.DIAMOND_SHIELD);
                        entries.accept(BSItems.GILDED_DIAMOND_SHIELD);
                        entries.accept(BSItems.NETHERITE_SHIELD);
                        entries.accept(BSItems.GILDED_NETHERITE_SHIELD);
                        entries.accept(BSItems.ENDER_SHIELD);
                        entries.accept(BSItems.GILDED_ENDER_SHIELD);
                        entries.accept(BSItems.BIOMASS_SHIELD);
                        entries.accept(BSItems.GILDED_BIOMASS_SHIELD);
                        entries.accept(BSItems.LIVINGMETAL_SHIELD);
                        entries.accept(BSItems.GILDED_LIVINGMETAL_SHIELD);
                        entries.accept(BSItems.QUARTZ_SHIELD);
                        entries.accept(BSItems.GILDED_QUARTZ_SHIELD);
                        entries.accept(BSItems.SKULL_SHIELD);
                        entries.accept(BSItems.GILDED_SKULL_SHIELD);
                        entries.accept(BSItems.PATCHWORK_SHIELD);
                        entries.accept(BSItems.GILDED_PATCHWORK_SHIELD);
                    })).build());

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Creative Tab");
    }
}
