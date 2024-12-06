package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.client.renderer.item.BloodLevelModelProperty;
import net.nova.big_swords.equipment.BSEquipmentAssets;
import net.nova.big_swords.init.BSItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@OnlyIn(Dist.CLIENT)
public class BSItemModelGenerator {
    public final ItemModelOutput output;
    public final BiConsumer<ResourceLocation, ModelInstance> modelOutput;

    public static final List<BSItemModelGenerator.TrimMaterialData> TRIM_MATERIAL_MODELS = List.of(
            new BSItemModelGenerator.TrimMaterialData("quartz", TrimMaterials.QUARTZ, Map.of()),
            new BSItemModelGenerator.TrimMaterialData("iron", TrimMaterials.IRON, Map.of(EquipmentAssets.IRON, "iron_darker")),
            new BSItemModelGenerator.TrimMaterialData("netherite", TrimMaterials.NETHERITE, Map.of(EquipmentAssets.NETHERITE, "netherite_darker")),
            new BSItemModelGenerator.TrimMaterialData("redstone", TrimMaterials.REDSTONE, Map.of()),
            new BSItemModelGenerator.TrimMaterialData("copper", TrimMaterials.COPPER, Map.of()),
            new BSItemModelGenerator.TrimMaterialData("gold", TrimMaterials.GOLD, Map.of(EquipmentAssets.GOLD, "gold_darker")),
            new BSItemModelGenerator.TrimMaterialData("emerald", TrimMaterials.EMERALD, Map.of()),
            new BSItemModelGenerator.TrimMaterialData("diamond", TrimMaterials.DIAMOND, Map.of(EquipmentAssets.DIAMOND, "diamond_darker")),
            new BSItemModelGenerator.TrimMaterialData("lapis", TrimMaterials.LAPIS, Map.of()),
            new BSItemModelGenerator.TrimMaterialData("amethyst", TrimMaterials.AMETHYST, Map.of()),
            new BSItemModelGenerator.TrimMaterialData("resin", TrimMaterials.RESIN, Map.of())
    );

    public BSItemModelGenerator(ItemModelOutput output, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        this.output = output;
        this.modelOutput = modelOutput;
    }

    public void run() {
        // Extra
        generateFlatItem(BSItems.BIOMASS_SEED.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.CREEP_BALL.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.SOUL.get(), ModelTemplates.FLAT_ITEM);
        generateBloodVial(BSItems.BLOOD_VIAL.get());

        // Sticks
        generateFlatItem(BSItems.GIANT_WOODEN_STICK.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_BLAZE_ROD.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_LIVINGMETAL_HANDLE.get(), ModelTemplates.FLAT_ITEM);

        // Livingmetal Models
        generateFlatItem(BSItems.LIVINGMETAL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generateTrimmableItem(BSItems.LIVINGMETAL_HELMET.get(), BSEquipmentAssets.LIVINGMETAL);
        generateTrimmableItem(BSItems.LIVINGMETAL_CHESTPLATE.get(), BSEquipmentAssets.LIVINGMETAL);
        generateTrimmableItem(BSItems.LIVINGMETAL_LEGGINGS.get(), BSEquipmentAssets.LIVINGMETAL);
        generateTrimmableItem(BSItems.LIVINGMETAL_BOOTS.get(), BSEquipmentAssets.LIVINGMETAL);
        generateFlatItem(BSItems.LIVINGMETAL_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Biomass Models
        generateFlatItem(BSItems.BIOMASS.get(), ModelTemplates.FLAT_ITEM);
        generateTrimmableItem(BSItems.BIOMASS_HELMET.get(), BSEquipmentAssets.BIOMASS);
        generateTrimmableItem(BSItems.BIOMASS_CHESTPLATE.get(), BSEquipmentAssets.BIOMASS);
        generateTrimmableItem(BSItems.BIOMASS_LEGGINGS.get(), BSEquipmentAssets.BIOMASS);
        generateTrimmableItem(BSItems.BIOMASS_BOOTS.get(), BSEquipmentAssets.BIOMASS);
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
    }

    // Methods
    public ResourceLocation createFlatItemModel(Item item, ModelTemplate template) {
        return template.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(item), this.modelOutput);
    }

    public ResourceLocation createFlatItemModel(Item item, String name, ModelTemplate template) {
        return template.create(
                ModelLocationUtils.getModelLocation(item, name),
                TextureMapping.layer0(TextureMapping.getItemTexture(item)),
                this.modelOutput
        );
    }

    public void generateBooleanDispatch(Item item, ConditionalItemModelProperty p_388865_, ItemModel.Unbaked p_387060_, ItemModel.Unbaked p_388146_) {
        this.output.accept(item, ItemModelUtils.conditional(p_388865_, p_387060_, p_388146_));
    }

    public void generateFlatItem(Item item, ModelTemplate template) {
        this.output.accept(item, ItemModelUtils.plainModel(this.createFlatItemModel(item, template)));
    }

    public void generateShield(Item item) {
        ItemModel.Unbaked flatModel = ItemModelUtils.plainModel(this.createFlatItemModel(item, BSModelTemplates.FLAT_HANDHELD_SHIELD_ITEM));
        ItemModel.Unbaked blockingModel = ItemModelUtils.plainModel(this.createFlatItemModel(item, "_blocking", BSModelTemplates.FLAT_HANDHELD_SHIELD_BLOCKING_ITEM));
        this.generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), blockingModel, flatModel);
    }

    public ResourceLocation generateLayeredItem(ResourceLocation p_386992_, ResourceLocation p_386528_, ResourceLocation p_386966_) {
        return ModelTemplates.TWO_LAYERED_ITEM.create(p_386992_, TextureMapping.layered(p_386528_, p_386966_), this.modelOutput);
    }

    public void generateTrimmableItem(Item item, ResourceKey<EquipmentAsset> equipmentAsset) {
        ResourceLocation resourcelocation = ModelLocationUtils.getModelLocation(item);
        ResourceLocation resourcelocation1 = TextureMapping.getItemTexture(item);
        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> list = new ArrayList<>(TRIM_MATERIAL_MODELS.size());
        Equippable equippable = item.getDefaultInstance().get(DataComponents.EQUIPPABLE);
        EquipmentSlot slot = equippable.slot();
        String armorType = switch (slot) {
            case HEAD -> "helmet";
            case CHEST -> "chestplate";
            case LEGS -> "leggings";
            case FEET -> "boots";
            default -> "";
        };

        for (BSItemModelGenerator.TrimMaterialData trimMaterial : TRIM_MATERIAL_MODELS) {
            ResourceLocation resourcelocation3 = resourcelocation.withSuffix("_" + trimMaterial.name() + "_trim");
            ResourceLocation resourcelocation4 = ResourceLocation.withDefaultNamespace(
                    "trims/items/" + armorType + "_trim_" + trimMaterial.textureName(equipmentAsset)
            );
            ItemModel.Unbaked itemmodel$unbaked;

            this.generateLayeredItem(resourcelocation3, resourcelocation1, resourcelocation4);
            itemmodel$unbaked = ItemModelUtils.plainModel(resourcelocation3);


            list.add(ItemModelUtils.when(trimMaterial.materialKey, itemmodel$unbaked));
        }

        ItemModel.Unbaked basicModel;
        ModelTemplates.FLAT_ITEM.create(resourcelocation, TextureMapping.layer0(resourcelocation1), this.modelOutput);
        basicModel = ItemModelUtils.plainModel(resourcelocation);

        this.output.accept(item, ItemModelUtils.select(new TrimMaterialProperty(), basicModel, list));
    }

    public void generateBloodVial(Item item) {
        List<RangeSelectItemModel.Entry> list = new ArrayList<>();
        ItemModel.Unbaked basicModel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(
                ModelLocationUtils.decorateItemModelLocation("vial"),
                TextureMapping.layer0(BigSwordsR.rl("item/vial")),
                this.modelOutput
        ));
        list.add(ItemModelUtils.override(basicModel, 0.0F));

        for (int i = 1; i < 10; i++) {
            ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(
                    ModelLocationUtils.getModelLocation(item, "_" + i),
                    TextureMapping.layer0(TextureMapping.getItemTexture(item, "_" + (i - 1))),
                    this.modelOutput
            ));
            list.add(ItemModelUtils.override(itemmodel$unbaked1, (float) i));
        }
        output.accept(item, ItemModelUtils.rangeSelect(new BloodLevelModelProperty(), list));
    }

    @OnlyIn(Dist.CLIENT)
    record TrimMaterialData(String name, ResourceKey<TrimMaterial> materialKey,
                            Map<ResourceKey<EquipmentAsset>, String> overrideArmorMaterials) {
        public String textureName(ResourceKey<EquipmentAsset> p_387088_) {
            return this.overrideArmorMaterials.getOrDefault(p_387088_, this.name);
        }
    }
}
