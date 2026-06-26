package net.nova.big_swords.init;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.nova.big_swords.BigSwordsR;

import java.util.function.Consumer;

public class CreativeTab {
  public static String BIG_SWORDS_TAB_TITLE = "itemgroup.big_swords.big_swords_tab";

  public static final CreativeModeTab BIG_SWORDS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BigSwordsR.rl("big_swords_tab"),
      FabricCreativeModeTab.builder().icon(() -> new ItemStack(BSItems.ENDER_BIG_SWORD.getFirst()))
          .title(Component.translatable(BIG_SWORDS_TAB_TITLE))
          .displayItems(((displayContext, entries) -> {
            // Biomass
            entries.accept(BSItems.BIOMASS_HELMET.getFirst().value());
            entries.accept(BSItems.BIOMASS_CHESTPLATE.getFirst().value());
            entries.accept(BSItems.BIOMASS_LEGGINGS.getFirst().value());
            entries.accept(BSItems.BIOMASS_BOOTS.getFirst().value());
            entries.accept(BSItems.BIOMASS_SWORD.getFirst().value());
            entries.accept(BSItems.BIOMASS_PICKAXE.getFirst().value());
            entries.accept(BSItems.BIOMASS_AXE.getFirst().value());
            entries.accept(BSItems.BIOMASS_SHOVEL.getFirst().value());
            entries.accept(BSItems.BIOMASS_HOE.getFirst().value());
            entries.accept(BSItems.BIOMASS_SPEAR.getFirst().value());

            // Livingmetal
            entries.accept(BSItems.LIVINGMETAL_HELMET.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_CHESTPLATE.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_LEGGINGS.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_BOOTS.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_SWORD.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_PICKAXE.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_AXE.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_SHOVEL.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_HOE.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_SPEAR.getFirst().value());

            // Extra Stuff
            entries.accept(BSItems.CREEP_BALL.getFirst().value());
            entries.accept(BSBlocks.CREEP_BLOCK.getFirst().value());
            entries.accept(BSItems.BIOMASS_SEED.getFirst().value());
            entries.accept(BSItems.SOUL.getFirst().value());
            entries.accept(BSItems.BLOOD_VIAL.getFirst().value());

            // Materials
            entries.accept(BSBlocks.BIOMASS_BLOCK.getFirst().value());
            entries.accept(BSItems.BIOMASS.getFirst().value());
            entries.accept(BSBlocks.LIVINGMETAL_BLOCK.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_INGOT.getFirst().value());

            // Ender Upgrade
            entries.accept(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.getFirst().value());

            // Sticks
            entries.accept(BSItems.GIANT_WOODEN_STICK.getFirst().value());
            entries.accept(BSItems.GIANT_BLAZE_ROD.getFirst().value());
            entries.accept(BSItems.GIANT_LIVINGMETAL_HANDLE.getFirst().value());

            // Big Swords
            entries.accept(BSItems.WOODEN_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.STONE_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.COPPER_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.IRON_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.GOLDEN_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.DIAMOND_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.NETHERITE_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.OBSIDIAN_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.ENDER_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.BIOMASS_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.QUARTZ_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.SKULL_BIG_SWORD.getFirst().value());
            entries.accept(BSItems.PATCHWORK_BIG_SWORD.getFirst().value());

            // Glaives
            entries.accept(BSItems.WOODEN_GLAIVE.getFirst().value());
            entries.accept(BSItems.STONE_GLAIVE.getFirst().value());
            entries.accept(BSItems.COPPER_GLAIVE.getFirst().value());
            entries.accept(BSItems.IRON_GLAIVE.getFirst().value());
            entries.accept(BSItems.GOLDEN_GLAIVE.getFirst().value());
            entries.accept(BSItems.DIAMOND_GLAIVE.getFirst().value());
            entries.accept(BSItems.NETHERITE_GLAIVE.getFirst().value());
            entries.accept(BSItems.BIOMASS_GLAIVE.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_GLAIVE.getFirst().value());

            // Scythes
            entries.accept(BSItems.WOODEN_SCYTHE.getFirst().value());
            entries.accept(BSItems.STONE_SCYTHE.getFirst().value());
            entries.accept(BSItems.COPPER_SCYTHE.getFirst().value());
            entries.accept(BSItems.IRON_SCYTHE.getFirst().value());
            entries.accept(BSItems.GOLDEN_SCYTHE.getFirst().value());
            entries.accept(BSItems.DIAMOND_SCYTHE.getFirst().value());
            entries.accept(BSItems.NETHERITE_SCYTHE.getFirst().value());
            entries.accept(BSItems.BIOMASS_SCYTHE.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_SCYTHE.getFirst().value());
            entries.accept(BSItems.BONE_SCYTHE.getFirst().value());
            entries.accept(BSItems.SOUL_REAPER.getFirst().value());

            // Shields
            entries.accept(BSItems.WOODEN_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_WOODEN_SHIELD.getFirst().value());
            entries.accept(BSItems.STONE_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_STONE_SHIELD.getFirst().value());
            copperShieldFamilies(family -> family.weathering().forEach(i -> entries.accept(i.getFirst().value())));
            copperShieldFamilies(family -> family.waxed().forEach(i -> entries.accept(i.getFirst().value())));
            entries.accept(BSItems.IRON_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_IRON_SHIELD.getFirst().value());
            entries.accept(BSItems.DIAMOND_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_DIAMOND_SHIELD.getFirst().value());
            entries.accept(BSItems.NETHERITE_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_NETHERITE_SHIELD.getFirst().value());
            entries.accept(BSItems.ENDER_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_ENDER_SHIELD.getFirst().value());
            entries.accept(BSItems.BIOMASS_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_BIOMASS_SHIELD.getFirst().value());
            entries.accept(BSItems.LIVINGMETAL_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_LIVINGMETAL_SHIELD.getFirst().value());
            entries.accept(BSItems.QUARTZ_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_QUARTZ_SHIELD.getFirst().value());
            entries.accept(BSItems.SKULL_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_SKULL_SHIELD.getFirst().value());
            entries.accept(BSItems.PATCHWORK_SHIELD.getFirst().value());
            entries.accept(BSItems.GILDED_PATCHWORK_SHIELD.getFirst().value());
          })).build());

  private static void copperShieldFamilies(Consumer<WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>>> output) {
    output.accept(BSItems.COPPER_SHIELD);
    output.accept(BSItems.GILDED_COPPER_SHIELD);
  }

  public static void initialize() {
    BigSwordsR.LOGGER.info("Registering Creative Tab");
  }
}
