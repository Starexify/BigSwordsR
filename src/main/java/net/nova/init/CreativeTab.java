package net.nova.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.nova.BigSwordsR;

public class CreativeTab {
    public static String BIG_SWORDS_TAB_TITLE = "itemgroup.big_swords.big_swords_tab";

    public static final ItemGroup BIG_SWORDS_TAB = Registry.register(Registries.ITEM_GROUP, BigSwordsR.rl("big_swords_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BSItems.ENDER_BIG_SWORD))
                    .displayName(Text.translatable(BIG_SWORDS_TAB_TITLE))
                    .entries(((displayContext, entries) -> {
                        // Biomass
                        entries.add(BSItems.BIOMASS_HELMET);
                        entries.add(BSItems.BIOMASS_CHESTPLATE);
                        entries.add(BSItems.BIOMASS_LEGGINGS);
                        entries.add(BSItems.BIOMASS_BOOTS);
                        entries.add(BSItems.BIOMASS_SWORD);
                        entries.add(BSItems.BIOMASS_PICKAXE);
                        entries.add(BSItems.BIOMASS_AXE);
                        entries.add(BSItems.BIOMASS_SHOVEL);
                        entries.add(BSItems.BIOMASS_HOE);

                        // Livingmetal
                        entries.add(BSItems.LIVINGMETAL_HELMET);
                        entries.add(BSItems.LIVINGMETAL_CHESTPLATE);
                        entries.add(BSItems.LIVINGMETAL_LEGGINGS);
                        entries.add(BSItems.LIVINGMETAL_BOOTS);
                        entries.add(BSItems.LIVINGMETAL_SWORD);
                        entries.add(BSItems.LIVINGMETAL_PICKAXE);
                        entries.add(BSItems.LIVINGMETAL_AXE);
                        entries.add(BSItems.LIVINGMETAL_SHOVEL);
                        entries.add(BSItems.LIVINGMETAL_HOE);

                        // Extra Stuff
                        entries.add(BSItems.CREEP_BALL);
                        entries.add(BSBlocks.CREEP_BLOCK);
                        entries.add(BSItems.BIOMASS_SEED);
                        entries.add(BSItems.SOUL);
                        entries.add(BSItems.BLOOD_VIAL);

                        // Materials
                        entries.add(BSBlocks.BIOMASS_BLOCK);
                        entries.add(BSItems.BIOMASS);
                        entries.add(BSBlocks.LIVINGMETAL_BLOCK);
                        entries.add(BSItems.LIVINGMETAL_INGOT);

                        // Ender Upgrade
                        entries.add(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE);

                        // Sticks
                        entries.add(BSItems.GIANT_WOODEN_STICK);
                        entries.add(BSItems.GIANT_BLAZE_ROD);
                        entries.add(BSItems.GIANT_LIVINGMETAL_HANDLE);

                        // Big Swords
                        entries.add(BSItems.WOODEN_BIG_SWORD);
                        entries.add(BSItems.STONE_BIG_SWORD);
                        entries.add(BSItems.IRON_BIG_SWORD);
                        entries.add(BSItems.GOLDEN_BIG_SWORD);
                        entries.add(BSItems.DIAMOND_BIG_SWORD);
                        entries.add(BSItems.NETHERITE_BIG_SWORD);
                        entries.add(BSItems.OBSIDIAN_BIG_SWORD);
                        entries.add(BSItems.ENDER_BIG_SWORD);
                        entries.add(BSItems.BIOMASS_BIG_SWORD);
                        entries.add(BSItems.LIVINGMETAL_BIG_SWORD);
                        entries.add(BSItems.QUARTZ_BIG_SWORD);
                        entries.add(BSItems.SKULL_BIG_SWORD);
                        entries.add(BSItems.PATCHWORK_BIG_SWORD);

                        // Glaives
                        entries.add(BSItems.WOODEN_GLAIVE);
                        entries.add(BSItems.STONE_GLAIVE);
                        entries.add(BSItems.IRON_GLAIVE);
                        entries.add(BSItems.GOLDEN_GLAIVE);
                        entries.add(BSItems.DIAMOND_GLAIVE);
                        entries.add(BSItems.NETHERITE_GLAIVE);
                        entries.add(BSItems.BIOMASS_GLAIVE);
                        entries.add(BSItems.LIVINGMETAL_GLAIVE);

                        // Scythes
                        entries.add(BSItems.WOODEN_SCYTHE);
                        entries.add(BSItems.STONE_SCYTHE);
                        entries.add(BSItems.IRON_SCYTHE);
                        entries.add(BSItems.GOLDEN_SCYTHE);
                        entries.add(BSItems.DIAMOND_SCYTHE);
                        entries.add(BSItems.NETHERITE_SCYTHE);
                        entries.add(BSItems.BIOMASS_SCYTHE);
                        entries.add(BSItems.LIVINGMETAL_SCYTHE);
                        entries.add(BSItems.BONE_SCYTHE);
                        entries.add(BSItems.SOUL_REAPER);

                        // Shields
                        entries.add(BSItems.WOODEN_SHIELD);
                        entries.add(BSItems.GILDED_WOODEN_SHIELD);
                        entries.add(BSItems.STONE_SHIELD);
                        entries.add(BSItems.GILDED_STONE_SHIELD);
                        entries.add(BSItems.IRON_SHIELD);
                        entries.add(BSItems.GILDED_IRON_SHIELD);
                        entries.add(BSItems.DIAMOND_SHIELD);
                        entries.add(BSItems.GILDED_DIAMOND_SHIELD);
                        entries.add(BSItems.NETHERITE_SHIELD);
                        entries.add(BSItems.GILDED_NETHERITE_SHIELD);
                        entries.add(BSItems.ENDER_SHIELD);
                        entries.add(BSItems.GILDED_ENDER_SHIELD);
                        entries.add(BSItems.BIOMASS_SHIELD);
                        entries.add(BSItems.GILDED_BIOMASS_SHIELD);
                        entries.add(BSItems.LIVINGMETAL_SHIELD);
                        entries.add(BSItems.GILDED_LIVINGMETAL_SHIELD);
                        entries.add(BSItems.QUARTZ_SHIELD);
                        entries.add(BSItems.GILDED_QUARTZ_SHIELD);
                        entries.add(BSItems.SKULL_SHIELD);
                        entries.add(BSItems.GILDED_SKULL_SHIELD);
                        entries.add(BSItems.PATCHWORK_SHIELD);
                        entries.add(BSItems.GILDED_PATCHWORK_SHIELD);
                    })).build());

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Creative Tab");
    }
}
