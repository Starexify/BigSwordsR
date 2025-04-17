package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSEquipmentAssets;
import net.nova.big_swords.equipment.BSMaterialAssetGroup;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItemModelGenerator extends ItemModelGenerators {
    public BSItemModelGenerator(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }

    @Override
    public void run() {
        // Extra
        generateFlatItem(BSItems.CREEP_BALL.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.SOUL.get(), ModelTemplates.FLAT_ITEM);
        generateBloodVial(BSItems.BLOOD_VIAL.get());

        // Sticks
        generateFlatItem(BSItems.GIANT_WOODEN_STICK.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_BLAZE_ROD.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_LIVINGMETAL_HANDLE.get(), ModelTemplates.FLAT_ITEM);

        // Livingmetal Models
        generateFlatItem(BSItems.LIVINGMETAL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generateTrimmableItem(BSItems.LIVINGMETAL_HELMET.get(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_HELMET, false);
        generateTrimmableItem(BSItems.LIVINGMETAL_CHESTPLATE.get(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_CHESTPLATE, false);
        generateTrimmableItem(BSItems.LIVINGMETAL_LEGGINGS.get(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_LEGGINGS, false);
        generateTrimmableItem(BSItems.LIVINGMETAL_BOOTS.get(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_BOOTS, false);
        generateFlatItem(BSItems.LIVINGMETAL_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Biomass Models
        generateFlatItem(BSItems.BIOMASS.get(), ModelTemplates.FLAT_ITEM);
        generateTrimmableItem(BSItems.BIOMASS_HELMET.get(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_HELMET, false);
        generateTrimmableItem(BSItems.BIOMASS_CHESTPLATE.get(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_CHESTPLATE, false);
        generateTrimmableItem(BSItems.BIOMASS_LEGGINGS.get(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_LEGGINGS, false);
        generateTrimmableItem(BSItems.BIOMASS_BOOTS.get(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_BOOTS, false);
        generateFlatItem(BSItems.BIOMASS_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Ender Upgrade
        generateFlatItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

        // Big Swords
        generateFlatItem(BSItems.WOODEN_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.STONE_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.IRON_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.GOLDEN_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.DIAMOND_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.NETHERITE_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.PATCHWORK_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.SKULL_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.QUARTZ_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.OBSIDIAN_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.ENDER_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Glaives
        generateFlatItem(BSItems.WOODEN_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.STONE_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.IRON_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.GOLDEN_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.DIAMOND_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.NETHERITE_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.BIOMASS_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);

        // Scythes
        generateFlatItem(BSItems.WOODEN_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.STONE_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.IRON_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.GOLDEN_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.DIAMOND_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.NETHERITE_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BIOMASS_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.BONE_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.SOUL_REAPER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Shields
        generateShield(BSItems.WOODEN_SHIELD.get());
        generateShield(BSItems.GILDED_WOODEN_SHIELD.get());
        generateShield(BSItems.STONE_SHIELD.get());
        generateShield(BSItems.GILDED_STONE_SHIELD.get());
        generateShield(BSItems.IRON_SHIELD.get());
        generateShield(BSItems.GILDED_IRON_SHIELD.get());
        generateShield(BSItems.DIAMOND_SHIELD.get());
        generateShield(BSItems.GILDED_DIAMOND_SHIELD.get());
        generateShield(BSItems.NETHERITE_SHIELD.get());
        generateShield(BSItems.GILDED_NETHERITE_SHIELD.get());
        generateShield(BSItems.ENDER_SHIELD.get());
        generateShield(BSItems.GILDED_ENDER_SHIELD.get());
        generateShield(BSItems.QUARTZ_SHIELD.get());
        generateShield(BSItems.GILDED_QUARTZ_SHIELD.get());
        generateShield(BSItems.PATCHWORK_SHIELD.get());
        generateShield(BSItems.GILDED_PATCHWORK_SHIELD.get());
        generateShield(BSItems.SKULL_SHIELD.get());
        generateShield(BSItems.GILDED_SKULL_SHIELD.get());
        generateShield(BSItems.BIOMASS_SHIELD.get());
        generateShield(BSItems.GILDED_BIOMASS_SHIELD.get());
        generateShield(BSItems.LIVINGMETAL_SHIELD.get());
        generateShield(BSItems.GILDED_LIVINGMETAL_SHIELD.get());

        generateTrimMaterialArmorCompat();
    }

    // Vanilla Armor Method
    public void generateTrimMaterialArmorCompat() {
        for (Item item : BuiltInRegistries.ITEM) {
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            if (itemId.getNamespace().equals(MODID)) continue;
            if (!item.components().has(DataComponents.EQUIPPABLE)) continue;
            EquipmentSlot slot = item.components().get(DataComponents.EQUIPPABLE).slot();
            if (slot != EquipmentSlot.HEAD && slot != EquipmentSlot.CHEST && slot != EquipmentSlot.LEGS && slot != EquipmentSlot.FEET)
                continue;
            if (!item.components().get(DataComponents.EQUIPPABLE).assetId().isPresent()) continue;
            String armorType = switch (slot) {
                case HEAD -> "helmet";
                case CHEST -> "chestplate";
                case LEGS -> "leggings";
                case FEET -> "boots";
                default -> "";
            };

            ResourceLocation textureLocation = TextureMapping.getItemTexture(item);
            ResourceLocation overlayTexture = TextureMapping.getItemTexture(item, "_overlay");
            ResourceLocation trimModelName = ModelLocationUtils.getModelLocation(item).withSuffix("_" + BSMaterialAssetGroup.LIVINGMETAL.base().suffix() + "_trim");
            ResourceLocation layer1Location = ResourceLocation.withDefaultNamespace("trims/items/" + armorType + "_trim_" + BSMaterialAssetGroup.LIVINGMETAL.assetId(item.components().get(DataComponents.EQUIPPABLE).assetId().get()).suffix());

            if (item.getDefaultInstance().is(ItemTags.DYEABLE))
                generateLayeredItem(trimModelName, textureLocation, overlayTexture, layer1Location);
            else generateLayeredItem(trimModelName, textureLocation, layer1Location);
        }
    }

    // Methods
    public ResourceLocation createFlatItemModel(Item item, String name, ModelTemplate modelTemplate) {
        return modelTemplate.create(ModelLocationUtils.getModelLocation(item, name), TextureMapping.layer0(TextureMapping.getItemTexture(item)), modelOutput);
    }

    public void generateShield(Item item) {
        ItemModel.Unbaked flatModel = ItemModelUtils.plainModel(createFlatItemModel(item, BSModelTemplates.FLAT_HANDHELD_SHIELD_ITEM));
        ItemModel.Unbaked blockingModel = ItemModelUtils.plainModel(createFlatItemModel(item, "_blocking", BSModelTemplates.FLAT_HANDHELD_SHIELD_BLOCKING_ITEM));
        generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), blockingModel, flatModel);
    }

    public void generateBloodVial(Item item) {
        List<SelectItemModel.SwitchCase<Integer>> list = new ArrayList<>();
        ItemModel.Unbaked basicModel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(BigSwordsR.rl("item/vial"), TextureMapping.layer0(BigSwordsR.rl("item/vial")), modelOutput));

        for (int i = 1; i <= 9; i++) {
            ItemModel.Unbaked bloodModel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(
                    ModelLocationUtils.getModelLocation(item, "_" + i),
                    TextureMapping.layer0(TextureMapping.getItemTexture(item, "_" + (i - 1))),
                    modelOutput
            ));
            list.add(ItemModelUtils.when(i, bloodModel));
        }
        itemModelOutput.accept(item, ItemModelUtils.select(new ComponentContents<>(BSDataComponents.BLOOD_LEVEL.get()), basicModel, list));
    }
}