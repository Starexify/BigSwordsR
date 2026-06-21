package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.neoforged.neoforge.registries.DeferredItem;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.equipment.BSEquipmentAssets;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BSItemModelGenerator extends ItemModelGenerators {
  public BSItemModelGenerator(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
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
    generateArmor(BSItems.LIVINGMETAL_HELMET.get(), TRIM_PREFIX_HELMET);
    generateArmor(BSItems.LIVINGMETAL_CHESTPLATE.get(), TRIM_PREFIX_CHESTPLATE);
    generateArmor(BSItems.LIVINGMETAL_LEGGINGS.get(), TRIM_PREFIX_LEGGINGS);
    generateArmor(BSItems.LIVINGMETAL_BOOTS.get(), TRIM_PREFIX_BOOTS);
    generateFlatItem(BSItems.LIVINGMETAL_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateSpear(BSItems.LIVINGMETAL_SPEAR.get());

    // Biomass Models
    generateFlatItem(BSItems.BIOMASS.get(), ModelTemplates.FLAT_ITEM);
    generateArmor(BSItems.BIOMASS_HELMET.get(), TRIM_PREFIX_HELMET);
    generateArmor(BSItems.BIOMASS_CHESTPLATE.get(), TRIM_PREFIX_CHESTPLATE);
    generateArmor(BSItems.BIOMASS_LEGGINGS.get(), TRIM_PREFIX_LEGGINGS);
    generateArmor(BSItems.BIOMASS_BOOTS.get(), TRIM_PREFIX_BOOTS);
    generateFlatItem(BSItems.BIOMASS_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.BIOMASS_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateSpear(BSItems.BIOMASS_SPEAR.get());

    // Ender Upgrade
    generateFlatItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

    // Big Swords
    generateFlatItem(BSItems.WOODEN_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.STONE_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.COPPER_BIG_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
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
    generateFlatItem(BSItems.COPPER_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.IRON_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.GOLDEN_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.DIAMOND_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.NETHERITE_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.BIOMASS_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);
    generateFlatItem(BSItems.LIVINGMETAL_GLAIVE.get(), BSModelTemplates.FLAT_HANDHELD_GLAIVE_ITEM);

    // Scythes
    generateFlatItem(BSItems.WOODEN_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.STONE_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    generateFlatItem(BSItems.COPPER_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
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
    generateCopperShield(BSItems.COPPER_SHIELD);
    generateCopperShield(BSItems.GILDED_COPPER_SHIELD);
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
  }

  // Methods
  public void generateArmor(Item armor, Identifier slotTrimPrefix) {
    // Generate model json because the game doesn't do that for some reason
    ModelTemplates.FLAT_ITEM.create(
        ModelLocationUtils.getModelLocation(armor),
        TextureMapping.layer0(TextureMapping.getItemTexture(armor)),
        this.modelOutput
    );
    generateDynamicTrimmableItem(armor, slotTrimPrefix);
  }

  public Identifier createFlatItemModel(Item item, String name, ModelTemplate modelTemplate) {
    return modelTemplate.create(ModelLocationUtils.getModelLocation(item, name), TextureMapping.layer0(TextureMapping.getItemTexture(item)), modelOutput);
  }

  public void generateCopperShield(WeatheringCopperCollection<DeferredItem<Item>> itemCollection) {
    itemCollection.zipUnwaxedWaxed((unwaxed, waxed) -> {
      generateShield(unwaxed.get());
      this.itemModelOutput.copy(unwaxed.get(), waxed.get());
    });
  }

  public void generateShield(Item item) {
    ItemModel.Unbaked flatModel = ItemModelUtils.plainModel(createFlatItemModel(item, BSModelTemplates.FLAT_HANDHELD_SHIELD_ITEM));
    ItemModel.Unbaked blockingModel = ItemModelUtils.plainModel(createFlatItemModel(item, "_blocking", BSModelTemplates.FLAT_HANDHELD_SHIELD_BLOCKING_ITEM));
    generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), blockingModel, flatModel);
  }

  public void generateBloodVial(Item item) {
    List<SelectItemModel.SwitchCase<Integer>> list = new ArrayList<>();
    ItemModel.Unbaked basicModel = ItemModelUtils.plainModel(
        ModelTemplates.FLAT_ITEM.create(BigSwordsR.rl("item/vial"), TextureMapping.layer0(new Material(BigSwordsR.rl("item/vial"))), modelOutput)
    );

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