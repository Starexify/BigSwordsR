package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSEquipmentAssets;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BSItemModelGenerator extends ItemModelGenerators {
    public BSItemModelGenerator(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> biConsumer) {
        super(itemModelOutput, biConsumer);
    }

    @Override
    public void run() {
        // Extra
        generateFlatItem(BSItems.CREEP_BALL, ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.SOUL, ModelTemplates.FLAT_ITEM);
        generateBloodVial(BSItems.BLOOD_VIAL);

        // Sticks
        generateFlatItem(BSItems.GIANT_WOODEN_STICK, ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_BLAZE_ROD, ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_LIVINGMETAL_HANDLE, ModelTemplates.FLAT_ITEM);

        // Livingmetal Models
        generateFlatItem(BSItems.LIVINGMETAL_INGOT, ModelTemplates.FLAT_ITEM);
        generateTrimmableItem(BSItems.LIVINGMETAL_HELMET, BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_HELMET, false);
        generateTrimmableItem(BSItems.LIVINGMETAL_CHESTPLATE, BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_CHESTPLATE, false);
        generateTrimmableItem(BSItems.LIVINGMETAL_LEGGINGS, BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_LEGGINGS, false);
        generateTrimmableItem(BSItems.LIVINGMETAL_BOOTS, BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_BOOTS, false);
        generateFlatItem(BSItems.LIVINGMETAL_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        // Biomass Models
        generateFlatItem(BSItems.BIOMASS, ModelTemplates.FLAT_ITEM);
        generateTrimmableItem(BSItems.BIOMASS_HELMET, BSEquipmentAssets.BIOMASS, TRIM_PREFIX_HELMET, false);
        generateTrimmableItem(BSItems.BIOMASS_CHESTPLATE, BSEquipmentAssets.BIOMASS, TRIM_PREFIX_CHESTPLATE, false);
        generateTrimmableItem(BSItems.BIOMASS_LEGGINGS, BSEquipmentAssets.BIOMASS, TRIM_PREFIX_LEGGINGS, false);
        generateTrimmableItem(BSItems.BIOMASS_BOOTS, BSEquipmentAssets.BIOMASS, TRIM_PREFIX_BOOTS, false);
        generateFlatItem(BSItems.BIOMASS_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        // Ender Upgrade
        generateFlatItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

        // Big Swords
        generateFlatItem(BSItems.WOODEN_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.STONE_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.IRON_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.GOLDEN_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.DIAMOND_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.NETHERITE_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.PATCHWORK_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.SKULL_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.QUARTZ_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.OBSIDIAN_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.ENDER_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_BIG_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);

        // Glaives
        generateFlatItem(BSItems.WOODEN_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.STONE_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.IRON_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.GOLDEN_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.DIAMOND_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.NETHERITE_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.BIOMASS_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_GLAIVE, BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);

        // Scythes
        generateFlatItem(BSItems.WOODEN_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.STONE_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.IRON_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.GOLDEN_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.DIAMOND_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.NETHERITE_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BONE_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.SOUL_REAPER, ModelTemplates.FLAT_HANDHELD_ITEM);

        // Shields
        generateShieldBSR(BSItems.WOODEN_SHIELD);
        generateShieldBSR(BSItems.GILDED_WOODEN_SHIELD);
        generateShieldBSR(BSItems.STONE_SHIELD);
        generateShieldBSR(BSItems.GILDED_STONE_SHIELD);
        generateShieldBSR(BSItems.IRON_SHIELD);
        generateShieldBSR(BSItems.GILDED_IRON_SHIELD);
        generateShieldBSR(BSItems.DIAMOND_SHIELD);
        generateShieldBSR(BSItems.GILDED_DIAMOND_SHIELD);
        generateShieldBSR(BSItems.NETHERITE_SHIELD);
        generateShieldBSR(BSItems.GILDED_NETHERITE_SHIELD);
        generateShieldBSR(BSItems.ENDER_SHIELD);
        generateShieldBSR(BSItems.GILDED_ENDER_SHIELD);
        generateShieldBSR(BSItems.QUARTZ_SHIELD);
        generateShieldBSR(BSItems.GILDED_QUARTZ_SHIELD);
        generateShieldBSR(BSItems.PATCHWORK_SHIELD);
        generateShieldBSR(BSItems.GILDED_PATCHWORK_SHIELD);
        generateShieldBSR(BSItems.SKULL_SHIELD);
        generateShieldBSR(BSItems.GILDED_SKULL_SHIELD);
        generateShieldBSR(BSItems.BIOMASS_SHIELD);
        generateShieldBSR(BSItems.GILDED_BIOMASS_SHIELD);
        generateShieldBSR(BSItems.LIVINGMETAL_SHIELD);
        generateShieldBSR(BSItems.GILDED_LIVINGMETAL_SHIELD);
    }

    // Methods
    public ResourceLocation createFlatItemModel2(Item item, String suffix, ModelTemplate model) {
        return model.create(ModelLocationUtils.getModelLocation(item, suffix), TextureMapping.layer0(TextureMapping.getItemTexture(item)), this.modelOutput);
    }

    public void generateShieldBSR(Item item) {
        ItemModel.Unbaked flatModel = ItemModelUtils.plainModel(createFlatItemModel(item, item, BSModelTemplates.FLAT_HANDHELD_SHIELD_ITEM));
        ItemModel.Unbaked blockingModel = ItemModelUtils.plainModel(createFlatItemModel2(item, "_blocking", BSModelTemplates.FLAT_HANDHELD_SHIELD_BLOCKING_ITEM));
        generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), blockingModel, flatModel);
    }

    public void generateBloodVial(Item item) {
        List<SelectItemModel.SwitchCase<Integer>> list = new ArrayList<>();
        ItemModel.Unbaked basicModel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(BigSwordsR.rl("item/vial"), TextureMapping.layer0(BigSwordsR.rl("item/vial")), modelOutput));

        for (int i = 1; i <= 9; i++) {
            ItemModel.Unbaked bloodModel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(item, "_" + i), TextureMapping.layer0(TextureMapping.getItemTexture(item, "_" + (i - 1))), modelOutput));
            list.add(ItemModelUtils.when(i, bloodModel));
        }
        itemModelOutput.accept(item, ItemModelUtils.select(new ComponentContents<>(BSDataComponents.BLOOD_LEVEL), basicModel, list));
    }
}
