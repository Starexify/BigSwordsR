package net.nova.big_swords.init;

import net.legacyfabric.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.itemgroup.ItemGroup;
import net.nova.big_swords.BigSwordsR;

public class CreativeTab {
    public static final ItemGroup BIG_SWORDS_TAB = FabricItemGroupBuilder
            .create(BigSwordsR.rl("big_swords"))
            .iconWithItem(() -> BSItems.GIANT_WOODEN_STICK)
            .appendItems((output, group) -> {
                // Biomass
                output.add(new ItemStack(BSItems.BIOMASS_HELMET));
                output.add(new ItemStack(BSItems.BIOMASS_CHESTPLATE));
                output.add(new ItemStack(BSItems.BIOMASS_LEGGINGS));
                output.add(new ItemStack(BSItems.BIOMASS_BOOTS));
                output.add(new ItemStack(BSItems.BIOMASS_SWORD));
                output.add(new ItemStack(BSItems.BIOMASS_PICKAXE));
                output.add(new ItemStack(BSItems.BIOMASS_AXE));
                output.add(new ItemStack(BSItems.BIOMASS_SHOVEL));
                output.add(new ItemStack(BSItems.BIOMASS_HOE));

                // Livingmetal
                output.add(new ItemStack(BSItems.LIVINGMETAL_HELMET));
                output.add(new ItemStack(BSItems.LIVINGMETAL_CHESTPLATE));
                output.add(new ItemStack(BSItems.LIVINGMETAL_LEGGINGS));
                output.add(new ItemStack(BSItems.LIVINGMETAL_BOOTS));
                output.add(new ItemStack(BSItems.LIVINGMETAL_SWORD));
                output.add(new ItemStack(BSItems.LIVINGMETAL_PICKAXE));
                output.add(new ItemStack(BSItems.LIVINGMETAL_AXE));
                output.add(new ItemStack(BSItems.LIVINGMETAL_SHOVEL));
                output.add(new ItemStack(BSItems.LIVINGMETAL_HOE));

                // Extra Stuff
                output.add(new ItemStack(BSItems.CREEP_BALL));
                output.add(new ItemStack(BSBlocks.getBlockItem(BSBlocks.CREEP_BLOCK)));
                output.add(new ItemStack(BSItems.BIOMASS_SEED));
                output.add(new ItemStack(BSItems.SOUL));
                output.add(new ItemStack(BSItems.BLOOD_VIAL));

                // Materials
                output.add(new ItemStack(BSBlocks.getBlockItem(BSBlocks.BIOMASS_BLOCK)));
                output.add(new ItemStack(BSItems.BIOMASS));
                output.add(new ItemStack(BSBlocks.getBlockItem(BSBlocks.LIVINGMETAL_BLOCK)));
                output.add(new ItemStack(BSItems.LIVINGMETAL_INGOT));

                // Ender Upgrade
                //output.add(new ItemStack(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE));

                // Sticks
                output.add(new ItemStack(BSItems.GIANT_WOODEN_STICK));
                output.add(new ItemStack(BSItems.GIANT_BLAZE_ROD));
                output.add(new ItemStack(BSItems.GIANT_LIVINGMETAL_HANDLE));

                // Big Swords
                output.add(new ItemStack(BSItems.WOODEN_BIG_SWORD));
                output.add(new ItemStack(BSItems.STONE_BIG_SWORD));
                output.add(new ItemStack(BSItems.IRON_BIG_SWORD));
                output.add(new ItemStack(BSItems.GOLDEN_BIG_SWORD));
                output.add(new ItemStack(BSItems.DIAMOND_BIG_SWORD));
                output.add(new ItemStack(BSItems.OBSIDIAN_BIG_SWORD));
                output.add(new ItemStack(BSItems.ENDER_BIG_SWORD));
                output.add(new ItemStack(BSItems.BIOMASS_BIG_SWORD));
                output.add(new ItemStack(BSItems.LIVINGMETAL_BIG_SWORD));
                output.add(new ItemStack(BSItems.QUARTZ_BIG_SWORD));
                output.add(new ItemStack(BSItems.SKULL_BIG_SWORD));
                output.add(new ItemStack(BSItems.PATCHWORK_BIG_SWORD));

                // Glaives
/*                output.add(new ItemStack(BSItems.WOODEN_GLAIVE));
                output.add(new ItemStack(BSItems.STONE_GLAIVE));
                output.add(new ItemStack(BSItems.IRON_GLAIVE));
                output.add(new ItemStack(BSItems.GOLDEN_GLAIVE));
                output.add(new ItemStack(BSItems.DIAMOND_GLAIVE));
                output.add(new ItemStack(BSItems.NETHERITE_GLAIVE));
                output.add(new ItemStack(BSItems.BIOMASS_GLAIVE));
                output.add(new ItemStack(BSItems.LIVINGMETAL_GLAIVE));

                // Scythes
                output.add(new ItemStack(BSItems.WOODEN_SCYTHE));
                output.add(new ItemStack(BSItems.STONE_SCYTHE));
                output.add(new ItemStack(BSItems.IRON_SCYTHE));
                output.add(new ItemStack(BSItems.GOLDEN_SCYTHE));
                output.add(new ItemStack(BSItems.DIAMOND_SCYTHE));
                output.add(new ItemStack(BSItems.NETHERITE_SCYTHE));
                output.add(new ItemStack(BSItems.BIOMASS_SCYTHE));
                output.add(new ItemStack(BSItems.LIVINGMETAL_SCYTHE));
                output.add(new ItemStack(BSItems.BONE_SCYTHE));
                output.add(new ItemStack(BSItems.SOUL_REAPER));

                // Shields
                output.add(new ItemStack(BSItems.WOODEN_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_WOODEN_SHIELD));
                output.add(new ItemStack(BSItems.STONE_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_STONE_SHIELD));
                output.add(new ItemStack(BSItems.IRON_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_IRON_SHIELD));
                output.add(new ItemStack(BSItems.DIAMOND_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_DIAMOND_SHIELD));
                output.add(new ItemStack(BSItems.NETHERITE_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_NETHERITE_SHIELD));
                output.add(new ItemStack(BSItems.ENDER_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_ENDER_SHIELD));
                output.add(new ItemStack(BSItems.BIOMASS_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_BIOMASS_SHIELD));
                output.add(new ItemStack(BSItems.LIVINGMETAL_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_LIVINGMETAL_SHIELD));
                output.add(new ItemStack(BSItems.QUARTZ_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_QUARTZ_SHIELD));
                output.add(new ItemStack(BSItems.SKULL_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_SKULL_SHIELD));
                output.add(new ItemStack(BSItems.PATCHWORK_SHIELD));
                output.add(new ItemStack(BSItems.GILDED_PATCHWORK_SHIELD));*/
            })
            .build();

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Creative Tab");
    }
}