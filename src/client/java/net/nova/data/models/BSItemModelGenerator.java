package net.nova.data.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.model.RangeDispatchItemModel;
import net.minecraft.client.render.item.model.SelectItemModel;
import net.minecraft.client.render.item.property.bool.UsingItemProperty;
import net.minecraft.client.render.item.property.select.TrimMaterialProperty;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.item.equipment.trim.ArmorTrimMaterials;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.nova.BigSwordsR;
import net.nova.client.render.item.BloodLevelModelProperty;
import net.nova.data.BSTrimMaterials;
import net.nova.equipment.BSEquipmentAssets;
import net.nova.init.BSItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@Environment(EnvType.CLIENT)
public class BSItemModelGenerator extends ItemModelGenerator {
    public static final List<BSItemModelGenerator.TrimMaterial> TRIM_MATERIALS = List.of(
            new BSItemModelGenerator.TrimMaterial("quartz", ArmorTrimMaterials.QUARTZ, Map.of()),
            new BSItemModelGenerator.TrimMaterial("iron", ArmorTrimMaterials.IRON, Map.of(EquipmentAssetKeys.IRON, "iron_darker")),
            new BSItemModelGenerator.TrimMaterial("netherite", ArmorTrimMaterials.NETHERITE, Map.of(EquipmentAssetKeys.NETHERITE, "netherite_darker")),
            new BSItemModelGenerator.TrimMaterial("redstone", ArmorTrimMaterials.REDSTONE, Map.of()),
            new BSItemModelGenerator.TrimMaterial("copper", ArmorTrimMaterials.COPPER, Map.of()),
            new BSItemModelGenerator.TrimMaterial("gold", ArmorTrimMaterials.GOLD, Map.of(EquipmentAssetKeys.GOLD, "gold_darker")),
            new BSItemModelGenerator.TrimMaterial("emerald", ArmorTrimMaterials.EMERALD, Map.of()),
            new BSItemModelGenerator.TrimMaterial("diamond", ArmorTrimMaterials.DIAMOND, Map.of(EquipmentAssetKeys.DIAMOND, "diamond_darker")),
            new BSItemModelGenerator.TrimMaterial("lapis", ArmorTrimMaterials.LAPIS, Map.of()),
            new BSItemModelGenerator.TrimMaterial("amethyst", ArmorTrimMaterials.AMETHYST, Map.of()),
            new BSItemModelGenerator.TrimMaterial("resin", ArmorTrimMaterials.RESIN, Map.of()),
            new BSItemModelGenerator.TrimMaterial("livingmetal", BSTrimMaterials.LIVINGMETAL, Map.of())
    );

    public BSItemModelGenerator(ItemModelOutput output, BiConsumer<Identifier, ModelSupplier> modelCollector) {
        super(output, modelCollector);
    }

    @Override
    public void register() {
        // Extra
        register(BSItems.CREEP_BALL, Models.GENERATED);
        register(BSItems.SOUL, Models.GENERATED);
        registerBloodVial(BSItems.BLOOD_VIAL);

        // Sticks
        register(BSItems.GIANT_WOODEN_STICK, Models.GENERATED);
        register(BSItems.GIANT_BLAZE_ROD, Models.GENERATED);
        register(BSItems.GIANT_LIVINGMETAL_HANDLE, Models.GENERATED);

        // Livingmetal Models
        register(BSItems.LIVINGMETAL_INGOT, Models.GENERATED);
        registerArmor(BSItems.LIVINGMETAL_HELMET, BSEquipmentAssets.LIVINGMETAL);
        registerArmor(BSItems.LIVINGMETAL_CHESTPLATE, BSEquipmentAssets.LIVINGMETAL);
        registerArmor(BSItems.LIVINGMETAL_LEGGINGS, BSEquipmentAssets.LIVINGMETAL);
        registerArmor(BSItems.LIVINGMETAL_BOOTS, BSEquipmentAssets.LIVINGMETAL);
        register(BSItems.LIVINGMETAL_SWORD, Models.HANDHELD);
        register(BSItems.LIVINGMETAL_PICKAXE, Models.HANDHELD);
        register(BSItems.LIVINGMETAL_AXE, Models.HANDHELD);
        register(BSItems.LIVINGMETAL_SHOVEL, Models.HANDHELD);
        register(BSItems.LIVINGMETAL_HOE, Models.HANDHELD);

        // Biomass Models
        register(BSItems.BIOMASS, Models.GENERATED);
        registerArmor(BSItems.BIOMASS_HELMET, BSEquipmentAssets.BIOMASS);
        registerArmor(BSItems.BIOMASS_CHESTPLATE, BSEquipmentAssets.BIOMASS);
        registerArmor(BSItems.BIOMASS_LEGGINGS, BSEquipmentAssets.BIOMASS);
        registerArmor(BSItems.BIOMASS_BOOTS, BSEquipmentAssets.BIOMASS);
        register(BSItems.BIOMASS_SWORD, Models.HANDHELD);
        register(BSItems.BIOMASS_PICKAXE, Models.HANDHELD);
        register(BSItems.BIOMASS_AXE, Models.HANDHELD);
        register(BSItems.BIOMASS_SHOVEL, Models.HANDHELD);
        register(BSItems.BIOMASS_HOE, Models.HANDHELD);

        // Ender Upgrade
        register(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        // Big Swords
        register(BSItems.WOODEN_BIG_SWORD, Models.HANDHELD);
        register(BSItems.STONE_BIG_SWORD, Models.HANDHELD);
        register(BSItems.IRON_BIG_SWORD, Models.HANDHELD);
        register(BSItems.GOLDEN_BIG_SWORD, Models.HANDHELD);
        register(BSItems.DIAMOND_BIG_SWORD, Models.HANDHELD);
        register(BSItems.NETHERITE_BIG_SWORD, Models.HANDHELD);
        register(BSItems.PATCHWORK_BIG_SWORD, Models.HANDHELD);
        register(BSItems.SKULL_BIG_SWORD, Models.HANDHELD);
        register(BSItems.QUARTZ_BIG_SWORD, Models.HANDHELD);
        register(BSItems.OBSIDIAN_BIG_SWORD, Models.HANDHELD);
        register(BSItems.ENDER_BIG_SWORD, Models.HANDHELD);
        register(BSItems.LIVINGMETAL_BIG_SWORD, Models.HANDHELD);
        register(BSItems.BIOMASS_BIG_SWORD, Models.HANDHELD);

        // Glaives
        register(BSItems.WOODEN_GLAIVE, BSModels.HANDHELD_GLAIVE);
        register(BSItems.STONE_GLAIVE, BSModels.HANDHELD_GLAIVE);
        register(BSItems.IRON_GLAIVE, BSModels.HANDHELD_GLAIVE);
        register(BSItems.GOLDEN_GLAIVE, BSModels.HANDHELD_GLAIVE);
        register(BSItems.DIAMOND_GLAIVE, BSModels.HANDHELD_GLAIVE);
        register(BSItems.NETHERITE_GLAIVE, BSModels.HANDHELD_GLAIVE);
        register(BSItems.BIOMASS_GLAIVE, BSModels.HANDHELD_GLAIVE);
        register(BSItems.LIVINGMETAL_GLAIVE, BSModels.HANDHELD_GLAIVE);

        // Scythes
        register(BSItems.WOODEN_SCYTHE, Models.HANDHELD);
        register(BSItems.STONE_SCYTHE, Models.HANDHELD);
        register(BSItems.IRON_SCYTHE, Models.HANDHELD);
        register(BSItems.GOLDEN_SCYTHE, Models.HANDHELD);
        register(BSItems.DIAMOND_SCYTHE, Models.HANDHELD);
        register(BSItems.NETHERITE_SCYTHE, Models.HANDHELD);
        register(BSItems.BIOMASS_SCYTHE, Models.HANDHELD);
        register(BSItems.LIVINGMETAL_SCYTHE, Models.HANDHELD);
        register(BSItems.BONE_SCYTHE, Models.HANDHELD);
        register(BSItems.SOUL_REAPER, Models.HANDHELD);

        // Shields
        generateShield(BSItems.WOODEN_SHIELD);
        generateShield(BSItems.GILDED_WOODEN_SHIELD);
        generateShield(BSItems.STONE_SHIELD);
        generateShield(BSItems.GILDED_STONE_SHIELD);
        generateShield(BSItems.IRON_SHIELD);
        generateShield(BSItems.GILDED_IRON_SHIELD);
        generateShield(BSItems.DIAMOND_SHIELD);
        generateShield(BSItems.GILDED_DIAMOND_SHIELD);
        generateShield(BSItems.NETHERITE_SHIELD);
        generateShield(BSItems.GILDED_NETHERITE_SHIELD);
        generateShield(BSItems.ENDER_SHIELD);
        generateShield(BSItems.GILDED_ENDER_SHIELD);
        generateShield(BSItems.QUARTZ_SHIELD);
        generateShield(BSItems.GILDED_QUARTZ_SHIELD);
        generateShield(BSItems.PATCHWORK_SHIELD);
        generateShield(BSItems.GILDED_PATCHWORK_SHIELD);
        generateShield(BSItems.SKULL_SHIELD);
        generateShield(BSItems.GILDED_SKULL_SHIELD);
        generateShield(BSItems.BIOMASS_SHIELD);
        generateShield(BSItems.GILDED_BIOMASS_SHIELD);
        generateShield(BSItems.LIVINGMETAL_SHIELD);
        generateShield(BSItems.GILDED_LIVINGMETAL_SHIELD);
    }

    // Methods
    public void registerBloodVial(Item item) {
        List<RangeDispatchItemModel.Entry> list = new ArrayList<>();
        ItemModel.Unbaked basicModel = ItemModels.basic(Models.GENERATED.upload(
                BigSwordsR.rl("item/vial"),
                TextureMap.layer0(BigSwordsR.rl("item/vial")),
                modelCollector
        ));
        list.add(ItemModels.rangeDispatchEntry(basicModel, 0.0F));

        for (int i = 1; i < 10; i++) {
            ItemModel.Unbaked bloodModel = ItemModels.basic(Models.GENERATED.upload(
                    ModelIds.getItemSubModelId(item, "_" + i),
                    TextureMap.layer0(TextureMap.getSubId(item, "_" + (i - 1))),
                    modelCollector
            ));
            list.add(ItemModels.rangeDispatchEntry(bloodModel, (float) i));
        }
        output.accept(item, ItemModels.rangeDispatch(new BloodLevelModelProperty(), list));
    }

    public Identifier registerSubModelWith(Item item, String suffix, Model model) {
        return model.upload(ModelIds.getItemSubModelId(item, suffix), TextureMap.layer0(TextureMap.getId(item)), this.modelCollector);
    }

    public void generateShield(Item item) {
        ItemModel.Unbaked flatModel = ItemModels.basic(uploadWithTextureSource(item, item, BSModels.HANDHELD_SHIELD));
        ItemModel.Unbaked blockingModel = ItemModels.basic(registerSubModelWith(item, "_blocking", BSModels.HANDHELD_SHIELD_BLOCKING));
        registerCondition(item, new UsingItemProperty(), blockingModel, flatModel);
    }

    public void registerArmor(Item item, RegistryKey<EquipmentAsset> equipmentKey) {
        Identifier identifier = ModelIds.getItemModelId(item);
        Identifier identifier2 = TextureMap.getId(item);
        List<SelectItemModel.SwitchCase<RegistryKey<ArmorTrimMaterial>>> list = new ArrayList(TRIM_MATERIALS.size());
        EquippableComponent equippable = item.getDefaultStack().get(DataComponentTypes.EQUIPPABLE);
        EquipmentSlot slot = equippable.slot();
        String armorType = switch (slot) {
            case HEAD -> "helmet";
            case CHEST -> "chestplate";
            case LEGS -> "leggings";
            case FEET -> "boots";
            default -> "";
        };

        for (BSItemModelGenerator.TrimMaterial trimMaterial : TRIM_MATERIALS) {
            Identifier identifier3 = identifier.withSuffixedPath("_" + trimMaterial.name() + "_trim");
            Identifier identifier4 = Identifier.ofVanilla("trims/items/" + armorType + "_trim_" + trimMaterial.texture(equipmentKey));
            ItemModel.Unbaked unbaked;
            uploadArmor(identifier3, identifier2, identifier4);
            unbaked = ItemModels.basic(identifier3);
            list.add(ItemModels.switchCase(trimMaterial.materialKey, unbaked));
        }

        ItemModel.Unbaked unbaked2;
        Models.GENERATED.upload(identifier, TextureMap.layer0(identifier2), this.modelCollector);
        unbaked2 = ItemModels.basic(identifier);

        output.accept(item, ItemModels.select(new TrimMaterialProperty(), unbaked2, list));
    }

    @Environment(EnvType.CLIENT)
    record TrimMaterial(String name, RegistryKey<ArmorTrimMaterial> materialKey, Map<RegistryKey<EquipmentAsset>, String> overrideArmorMaterials) {
        public String texture(RegistryKey<EquipmentAsset> equipmentKey) {
            return overrideArmorMaterials.getOrDefault(equipmentKey, this.name);
        }
    }
}
