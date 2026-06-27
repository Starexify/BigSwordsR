package net.nova.big_swords.data.models;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSEquipmentAssets;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BSItemModelGenerator extends ItemModelGenerators {
  public BSItemModelGenerator(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> biConsumer) {
    super(itemModelOutput, biConsumer);
  }

  @Override
  public void run() {
    // Extra
    generateFlatItem(BSItems.CREEP_BALL.getFirst().value(), ModelTemplates.FLAT_ITEM);
    generateFlatItem(BSItems.SOUL.getFirst().value(), ModelTemplates.FLAT_ITEM);
    generateBloodVial(BSItems.BLOOD_VIAL.getFirst().value());

    // Sticks
    generateFlatItem(BSItems.GIANT_WOODEN_STICK.getFirst().value(), ModelTemplates.FLAT_ITEM);
    generateFlatItem(BSItems.GIANT_BLAZE_ROD.getFirst().value(), ModelTemplates.FLAT_ITEM);
    generateFlatItem(BSItems.GIANT_LIVINGMETAL_HANDLE.getFirst().value(), ModelTemplates.FLAT_ITEM);

    // Livingmetal Models
    generateFlatItem(BSItems.LIVINGMETAL_INGOT.getFirst().value(), ModelTemplates.FLAT_ITEM);
    generateTrimmableItem(BSItems.LIVINGMETAL_HELMET.getFirst().value(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_HELMET, false);
    generateTrimmableItem(BSItems.LIVINGMETAL_CHESTPLATE.getFirst().value(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_CHESTPLATE, false);
    generateTrimmableItem(BSItems.LIVINGMETAL_LEGGINGS.getFirst().value(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_LEGGINGS, false);
    generateTrimmableItem(BSItems.LIVINGMETAL_BOOTS.getFirst().value(), BSEquipmentAssets.LIVINGMETAL, TRIM_PREFIX_BOOTS, false);
    generateFlatItem(BSItems.LIVINGMETAL_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_PICKAXE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_AXE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_SHOVEL.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_HOE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateSpear(BSItems.LIVINGMETAL_SPEAR.getFirst().value());

    // Biomass Models
    generateFlatItem(BSItems.BIOMASS.getFirst().value(), ModelTemplates.FLAT_ITEM);
    generateTrimmableItem(BSItems.BIOMASS_HELMET.getFirst().value(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_HELMET, false);
    generateTrimmableItem(BSItems.BIOMASS_CHESTPLATE.getFirst().value(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_CHESTPLATE, false);
    generateTrimmableItem(BSItems.BIOMASS_LEGGINGS.getFirst().value(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_LEGGINGS, false);
    generateTrimmableItem(BSItems.BIOMASS_BOOTS.getFirst().value(), BSEquipmentAssets.BIOMASS, TRIM_PREFIX_BOOTS, false);
    generateFlatItem(BSItems.BIOMASS_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_PICKAXE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_AXE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_SHOVEL.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_HOE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateSpear(BSItems.BIOMASS_SPEAR.getFirst().value());

    // Ender Upgrade
    generateFlatItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.getFirst().value(), ModelTemplates.FLAT_ITEM);

    // Big Swords
    generateFlatItem(BSItems.WOODEN_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.STONE_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.COPPER_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.IRON_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.GOLDEN_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.DIAMOND_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.NETHERITE_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.PATCHWORK_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.SKULL_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.QUARTZ_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.OBSIDIAN_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.ENDER_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_BIG_SWORD.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);

    // Glaives
    generateFlatItem(BSItems.WOODEN_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.STONE_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.COPPER_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.IRON_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.GOLDEN_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.DIAMOND_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.NETHERITE_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.BIOMASS_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_GLAIVE.getFirst().value(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);

    // Scythes
    generateFlatItem(BSItems.WOODEN_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.STONE_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.COPPER_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.IRON_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.GOLDEN_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.DIAMOND_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.NETHERITE_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BONE_SCYTHE.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.SOUL_REAPER.getFirst().value(), ModelTemplates.FLAT_HANDHELD_ITEM);

    // Shields
    generateShieldBSR(BSItems.WOODEN_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_WOODEN_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.STONE_SHIELD.getFirst().value());
    generateCopperShield(BSItems.COPPER_SHIELD);
    generateCopperShield(BSItems.GILDED_COPPER_SHIELD);
    generateShieldBSR(BSItems.GILDED_STONE_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.IRON_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_IRON_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.DIAMOND_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_DIAMOND_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.NETHERITE_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_NETHERITE_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.ENDER_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_ENDER_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.QUARTZ_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_QUARTZ_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.PATCHWORK_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_PATCHWORK_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.SKULL_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_SKULL_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.BIOMASS_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_BIOMASS_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.LIVINGMETAL_SHIELD.getFirst().value());
    generateShieldBSR(BSItems.GILDED_LIVINGMETAL_SHIELD.getFirst().value());
  }

  // Methods
  public Identifier createFlatItemModel2(Item item, String suffix, ModelTemplate model) {
    return model.create(ModelLocationUtils.getModelLocation(item, suffix), TextureMapping.layer0(TextureMapping.getItemTexture(item)), this.modelOutput);
  }

  public void generateCopperShield(WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>> itemCollection) {
    itemCollection.zipUnwaxedWaxed((unwaxed, waxed) -> {
      generateShieldBSR(unwaxed.getFirst().value());
      this.itemModelOutput.copy(unwaxed.getFirst().value(), waxed.getFirst().value());
    });
  }

  public void generateShieldBSR(Item item) {
    ItemModel.Unbaked flatModel = ItemModelUtils.plainModel(createFlatItemModel(item, item, BSModelTemplates.FLAT_HANDHELD_SHIELD_ITEM));
    ItemModel.Unbaked blockingModel = ItemModelUtils.plainModel(createFlatItemModel2(item, "_blocking", BSModelTemplates.FLAT_HANDHELD_SHIELD_BLOCKING_ITEM));
    generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), blockingModel, flatModel);
  }

  public void generateBloodVial(Item item) {
    List<SelectItemModel.SwitchCase<Integer>> list = new ArrayList<>();
    ItemModel.Unbaked basicModel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(BigSwordsR.rl("item/vial"), TextureMapping.layer0(new Material(BigSwordsR.rl("item/vial"))), modelOutput));

    for (int i = 1; i <= 9; i++) {
      ItemModel.Unbaked bloodModel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(item, "_" + i), TextureMapping.layer0(TextureMapping.getItemTexture(item, "_" + (i - 1))), modelOutput));
      list.add(ItemModelUtils.when(i, bloodModel));
    }
    itemModelOutput.accept(item, ItemModelUtils.select(new ComponentContents<>(BSDataComponents.BLOOD_LEVEL), basicModel, list));
  }
}
