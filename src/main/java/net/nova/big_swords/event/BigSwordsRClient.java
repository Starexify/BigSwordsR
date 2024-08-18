package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.nova.big_swords.client.renderer.item.BSItemProperties;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BigSwordsRClient {
    public static String RP_16x_NAME = "resourcePack." + MODID + ".big_swords_r_16x.name";
    public static String RP_16x_DESC = "resourcePack." + MODID + ".big_swords_r_16x.description";

    // Integrated Resourcepack
    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            ModList.get().getModContainerById(MODID).ifPresent(modContainer -> {
                event.addRepositorySource((packConsumer) -> {
                    PackLocationInfo locationInfo = new PackLocationInfo(MODID + ":big_swords_r_16x", Component.translatable(RP_16x_NAME), PackSource.BUILT_IN, Optional.empty());
                    Pack.ResourcesSupplier resourcesSupplier = new PathPackResources.PathResourcesSupplier(modContainer.getModInfo().getOwningFile().getFile().findResource("resourcepacks/big_swords_r_16x"));
                    PackSelectionConfig selectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
                    Pack.Metadata metadata = new Pack.Metadata(Component.translatable(RP_16x_DESC), PackCompatibility.COMPATIBLE, FeatureFlagSet.of(), Collections.emptyList(), false);

                    Pack pack = new Pack(locationInfo, resourcesSupplier, metadata, selectionConfig);
                    packConsumer.accept(pack);
                });
            });
        }
    }

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        event.enqueueWork(BSItemProperties::addCustomItemProperties);
    }

    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();

        if (tabKey.equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            putAfter(Items.NETHERITE_BLOCK, BSBlocks.BIOMASS_BLOCK, event);
            putAfter(BSBlocks.BIOMASS_BLOCK.asItem(), BSBlocks.LIVINGMETAL_BLOCK, event);
        }

        if (tabKey.equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            putAfter(Items.SOUL_SAND, BSBlocks.CREEP_BLOCK, event);
            putAfter(Items.NETHER_WART, BSItems.BIOMASS_SEED, event);
        }

        if (tabKey.equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            putAfter(Items.NETHERITE_HOE, BSItems.BIOMASS_SHOVEL, event);
            putAfter(BSItems.BIOMASS_SHOVEL.get(), BSItems.BIOMASS_PICKAXE, event);
            putAfter(BSItems.BIOMASS_PICKAXE.get(), BSItems.BIOMASS_AXE, event);
            putAfter(BSItems.BIOMASS_AXE.get(), BSItems.BIOMASS_HOE, event);
            putAfter(BSItems.BIOMASS_HOE.get(), BSItems.LIVINGMETAL_SHOVEL, event);
            putAfter(BSItems.LIVINGMETAL_SHOVEL.get(), BSItems.LIVINGMETAL_PICKAXE, event);
            putAfter(BSItems.LIVINGMETAL_PICKAXE.get(), BSItems.LIVINGMETAL_AXE, event);
            putAfter(BSItems.LIVINGMETAL_AXE.get(), BSItems.LIVINGMETAL_HOE, event);
        }

        if (tabKey.equals(CreativeModeTabs.COMBAT)) {
            // Swords Placement
            putAfter(Items.NETHERITE_SWORD, BSItems.BIOMASS_SWORD, event);
            putAfter(BSItems.BIOMASS_SWORD.get(), BSItems.LIVINGMETAL_SWORD, event);

            // Big Swords Placement
            putAfter(BSItems.LIVINGMETAL_SWORD.get(), BSItems.WOODEN_BIG_SWORD, event);
            putAfter(BSItems.WOODEN_BIG_SWORD.get(), BSItems.STONE_BIG_SWORD, event);
            putAfter(BSItems.STONE_BIG_SWORD.get(), BSItems.IRON_BIG_SWORD, event);
            putAfter(BSItems.IRON_BIG_SWORD.get(), BSItems.GOLDEN_BIG_SWORD, event);
            putAfter(BSItems.GOLDEN_BIG_SWORD.get(), BSItems.DIAMOND_BIG_SWORD, event);
            putAfter(BSItems.DIAMOND_BIG_SWORD.get(), BSItems.NETHERITE_BIG_SWORD, event);
            putAfter(BSItems.NETHERITE_BIG_SWORD.get(), BSItems.OBSIDIAN_BIG_SWORD, event);
            putAfter(BSItems.OBSIDIAN_BIG_SWORD.get(), BSItems.ENDER_BIG_SWORD, event);
            putAfter(BSItems.ENDER_BIG_SWORD.get(), BSItems.BIOMASS_BIG_SWORD, event);
            putAfter(BSItems.BIOMASS_BIG_SWORD.get(), BSItems.LIVINGMETAL_BIG_SWORD, event);
            putAfter(BSItems.LIVINGMETAL_BIG_SWORD.get(), BSItems.QUARTZ_BIG_SWORD, event);
            putAfter(BSItems.QUARTZ_BIG_SWORD.get(), BSItems.SKULL_BIG_SWORD, event);
            putAfter(BSItems.SKULL_BIG_SWORD.get(), BSItems.PATCHWORK_BIG_SWORD, event);

            // Glaives Placement
            putAfter(Items.NETHERITE_AXE, BSItems.WOODEN_GLAIVE, event);
            putAfter(BSItems.WOODEN_GLAIVE.get(), BSItems.STONE_GLAIVE, event);
            putAfter(BSItems.STONE_GLAIVE.get(), BSItems.IRON_GLAIVE, event);
            putAfter(BSItems.IRON_GLAIVE.get(), BSItems.GOLDEN_GLAIVE, event);
            putAfter(BSItems.GOLDEN_GLAIVE.get(), BSItems.DIAMOND_GLAIVE, event);
            putAfter(BSItems.DIAMOND_GLAIVE.get(), BSItems.NETHERITE_GLAIVE, event);
            putAfter(BSItems.NETHERITE_GLAIVE.get(), BSItems.BIOMASS_GLAIVE, event);
            putAfter(BSItems.BIOMASS_GLAIVE.get(), BSItems.LIVINGMETAL_GLAIVE, event);

            // Scythes Placement
            putAfter(BSItems.LIVINGMETAL_GLAIVE.get(), BSItems.WOODEN_SCYTHE, event);
            putAfter(BSItems.WOODEN_SCYTHE.get(), BSItems.STONE_SCYTHE, event);
            putAfter(BSItems.STONE_SCYTHE.get(), BSItems.IRON_SCYTHE, event);
            putAfter(BSItems.IRON_SCYTHE.get(), BSItems.GOLDEN_SCYTHE, event);
            putAfter(BSItems.GOLDEN_SCYTHE.get(), BSItems.DIAMOND_SCYTHE, event);
            putAfter(BSItems.DIAMOND_SCYTHE.get(), BSItems.NETHERITE_SCYTHE, event);
            putAfter(BSItems.NETHERITE_SCYTHE.get(), BSItems.BIOMASS_SCYTHE, event);
            putAfter(BSItems.BIOMASS_SCYTHE.get(), BSItems.LIVINGMETAL_SCYTHE, event);
            putAfter(BSItems.LIVINGMETAL_SCYTHE.get(), BSItems.BONE_SCYTHE, event);
            putAfter(BSItems.BONE_SCYTHE.get(), BSItems.SOUL_REAPER, event);

            // Shields Placement
            putAfter(Items.SHIELD, BSItems.WOODEN_SHIELD, event);

            // Armor Placement
            putAfter(Items.NETHERITE_BOOTS, BSItems.BIOMASS_HELMET, event);
            putAfter(BSItems.BIOMASS_HELMET.get(), BSItems.BIOMASS_CHESTPLATE, event);
            putAfter(BSItems.BIOMASS_CHESTPLATE.get(), BSItems.BIOMASS_LEGGINGS, event);
            putAfter(BSItems.BIOMASS_LEGGINGS.get(), BSItems.BIOMASS_BOOTS, event);
            putAfter(BSItems.BIOMASS_BOOTS.get(), BSItems.LIVINGMETAL_HELMET, event);
            putAfter(BSItems.LIVINGMETAL_HELMET.get(), BSItems.LIVINGMETAL_CHESTPLATE, event);
            putAfter(BSItems.LIVINGMETAL_CHESTPLATE.get(), BSItems.LIVINGMETAL_LEGGINGS, event);
            putAfter(BSItems.LIVINGMETAL_LEGGINGS.get(), BSItems.LIVINGMETAL_BOOTS, event);
        }

        if (tabKey.equals(CreativeModeTabs.INGREDIENTS)) {
            putAfter(Items.GOLD_INGOT, BSItems.LIVINGMETAL_INGOT, event);
            putAfter(Items.NETHERITE_INGOT, BSItems.BIOMASS, event);
            putAfter(Items.STICK, BSItems.GIANT_WOODEN_STICK, event);
            putAfter(BSItems.GIANT_WOODEN_STICK.get(), BSItems.GIANT_LIVINGMETAL_HANDLE, event);
            putAfter(Items.BLAZE_ROD, BSItems.GIANT_BLAZE_ROD, event);
            putAfter(Items.PHANTOM_MEMBRANE, BSItems.CREEP_BALL, event);
            putAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, event);
        }
    }

    private static void putAfter(Item item, Supplier<? extends ItemLike> itemAfter, BuildCreativeModeTabContentsEvent event) {
        event.insertAfter(item.getDefaultInstance(), itemAfter.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
