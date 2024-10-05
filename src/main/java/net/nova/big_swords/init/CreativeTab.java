package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class CreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static String BIG_SWORDS_TAB_TITLE = "big_swords.creativetab";

    public static final Supplier<CreativeModeTab> BIG_SWORDS_TAB = CREATIVE_TAB.register("big_swords_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(BSItems.ENDER_BIG_SWORD.get()))
            .title(Component.translatable(BIG_SWORDS_TAB_TITLE))
            .displayItems((itemDisplayParameters, output) -> {
                // Biomass
                output.accept(BSItems.BIOMASS_HELMET.get());
                output.accept(BSItems.BIOMASS_CHESTPLATE.get());
                output.accept(BSItems.BIOMASS_LEGGINGS.get());
                output.accept(BSItems.BIOMASS_BOOTS.get());
                output.accept(BSItems.BIOMASS_SWORD.get());
                output.accept(BSItems.BIOMASS_PICKAXE.get());
                output.accept(BSItems.BIOMASS_AXE.get());
                output.accept(BSItems.BIOMASS_SHOVEL.get());
                output.accept(BSItems.BIOMASS_HOE.get());

                // Livingmetal
                output.accept(BSItems.LIVINGMETAL_HELMET.get());
                output.accept(BSItems.LIVINGMETAL_CHESTPLATE.get());
                output.accept(BSItems.LIVINGMETAL_LEGGINGS.get());
                output.accept(BSItems.LIVINGMETAL_BOOTS.get());
                output.accept(BSItems.LIVINGMETAL_SWORD.get());
                output.accept(BSItems.LIVINGMETAL_PICKAXE.get());
                output.accept(BSItems.LIVINGMETAL_AXE.get());
                output.accept(BSItems.LIVINGMETAL_SHOVEL.get());
                output.accept(BSItems.LIVINGMETAL_HOE.get());

                // Extra Stuff
                output.accept(BSItems.CREEP_BALL.get());
                output.accept(BSBlocks.CREEP_BLOCK.get());
                output.accept(BSItems.BIOMASS_SEED.get());
                output.accept(BSItems.SOUL.get());

                // Materials
                output.accept(BSBlocks.BIOMASS_BLOCK.get());
                output.accept(BSItems.BIOMASS.get());
                output.accept(BSBlocks.LIVINGMETAL_BLOCK.get());
                output.accept(BSItems.LIVINGMETAL_INGOT.get());

                // Ender Upgrade
                output.accept(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get());

                // Sticks
                output.accept(BSItems.GIANT_WOODEN_STICK.get());
                output.accept(BSItems.GIANT_BLAZE_ROD.get());
                output.accept(BSItems.GIANT_LIVINGMETAL_HANDLE.get());

                // Big Swords
                output.accept(BSItems.WOODEN_BIG_SWORD.get());
                output.accept(BSItems.STONE_BIG_SWORD.get());
                output.accept(BSItems.IRON_BIG_SWORD.get());
                output.accept(BSItems.GOLDEN_BIG_SWORD.get());
                output.accept(BSItems.DIAMOND_BIG_SWORD.get());
                output.accept(BSItems.NETHERITE_BIG_SWORD.get());
                output.accept(BSItems.OBSIDIAN_BIG_SWORD.get());
                output.accept(BSItems.ENDER_BIG_SWORD.get());
                output.accept(BSItems.BIOMASS_BIG_SWORD.get());
                output.accept(BSItems.LIVINGMETAL_BIG_SWORD.get());
                output.accept(BSItems.QUARTZ_BIG_SWORD.get());
                output.accept(BSItems.SKULL_BIG_SWORD.get());
                output.accept(BSItems.PATCHWORK_BIG_SWORD.get());

                // Glaives
                output.accept(BSItems.WOODEN_GLAIVE.get());
                output.accept(BSItems.STONE_GLAIVE.get());
                output.accept(BSItems.IRON_GLAIVE.get());
                output.accept(BSItems.GOLDEN_GLAIVE.get());
                output.accept(BSItems.DIAMOND_GLAIVE.get());
                output.accept(BSItems.NETHERITE_GLAIVE.get());
                output.accept(BSItems.BIOMASS_GLAIVE.get());
                output.accept(BSItems.LIVINGMETAL_GLAIVE.get());

                // Scythes
                output.accept(BSItems.WOODEN_SCYTHE.get());
                output.accept(BSItems.STONE_SCYTHE.get());
                output.accept(BSItems.IRON_SCYTHE.get());
                output.accept(BSItems.GOLDEN_SCYTHE.get());
                output.accept(BSItems.DIAMOND_SCYTHE.get());
                output.accept(BSItems.NETHERITE_SCYTHE.get());
                output.accept(BSItems.BIOMASS_SCYTHE.get());
                output.accept(BSItems.LIVINGMETAL_SCYTHE.get());
                output.accept(BSItems.BONE_SCYTHE.get());
                output.accept(BSItems.SOUL_REAPER.get());

                // Shields
                output.accept(BSItems.WOODEN_SHIELD.get());
                output.accept(BSItems.GILDED_WOODEN_SHIELD.get());
                output.accept(BSItems.STONE_SHIELD.get());
                output.accept(BSItems.GILDED_STONE_SHIELD.get());
                output.accept(BSItems.IRON_SHIELD.get());
                output.accept(BSItems.GILDED_IRON_SHIELD.get());
                output.accept(BSItems.DIAMOND_SHIELD.get());
                output.accept(BSItems.GILDED_DIAMOND_SHIELD.get());
                output.accept(BSItems.NETHERITE_SHIELD.get());
                output.accept(BSItems.GILDED_NETHERITE_SHIELD.get());
                output.accept(BSItems.ENDER_SHIELD.get());
                output.accept(BSItems.GILDED_ENDER_SHIELD.get());
                output.accept(BSItems.BIOMASS_SHIELD.get());
                output.accept(BSItems.GILDED_BIOMASS_SHIELD.get());
                output.accept(BSItems.LIVINGMETAL_SHIELD.get());
                output.accept(BSItems.GILDED_LIVINGMETAL_SHIELD.get());
                output.accept(BSItems.QUARTZ_SHIELD.get());
                output.accept(BSItems.GILDED_QUARTZ_SHIELD.get());
                output.accept(BSItems.SKULL_SHIELD.get());
                output.accept(BSItems.GILDED_SKULL_SHIELD.get());
                output.accept(BSItems.PATCHWORK_SHIELD.get());
                output.accept(BSItems.GILDED_PATCHWORK_SHIELD.get());
            }).build()
    );
}
