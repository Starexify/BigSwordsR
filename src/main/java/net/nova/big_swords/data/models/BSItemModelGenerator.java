package net.nova.big_swords.data.models;

import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.nova.big_swords.init.BSItems;

import java.util.function.BiConsumer;

@OnlyIn(Dist.CLIENT)
public class BSItemModelGenerator {
    public final ItemModelOutput output;
    public final BiConsumer<ResourceLocation, ModelInstance> modelOutput;

    public BSItemModelGenerator(ItemModelOutput output, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        this.output = output;
        this.modelOutput = modelOutput;
    }

    public void run() {
        // Extra
        generateFlatItem(BSItems.BIOMASS_SEED.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.CREEP_BALL.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.SOUL.get(), ModelTemplates.FLAT_ITEM);
        //bloodVial(BSItems.BLOOD_VIAL.get());

        // Sticks
        generateFlatItem(BSItems.GIANT_WOODEN_STICK.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_BLAZE_ROD.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(BSItems.GIANT_LIVINGMETAL_HANDLE.get(), ModelTemplates.FLAT_ITEM);

        // Livingmetal Models
        generateFlatItem(BSItems.LIVINGMETAL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        //trimmableArmorItem(BSItems.LIVINGMETAL_HELMET.get());
        //trimmableArmorItem(BSItems.LIVINGMETAL_CHESTPLATE.get());
        //trimmableArmorItem(BSItems.LIVINGMETAL_LEGGINGS.get());
        //trimmableArmorItem(BSItems.LIVINGMETAL_BOOTS.get());
        generateFlatItem(BSItems.LIVINGMETAL_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(BSItems.LIVINGMETAL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Biomass Models
        //trimmableArmorItem(BSItems.BIOMASS_HELMET.get());
        //trimmableArmorItem(BSItems.BIOMASS_CHESTPLATE.get());
        //trimmableArmorItem(BSItems.BIOMASS_LEGGINGS.get());
        //trimmableArmorItem(BSItems.BIOMASS_BOOTS.get());
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
        //shieldItem(BSItems.WOODEN_SHIELD.get());
        //shieldItem(BSItems.GILDED_WOODEN_SHIELD.get());
        //shieldItem(BSItems.STONE_SHIELD.get());
        //shieldItem(BSItems.GILDED_STONE_SHIELD.get());
        //shieldItem(BSItems.IRON_SHIELD.get());
        //shieldItem(BSItems.GILDED_IRON_SHIELD.get());
        //shieldItem(BSItems.DIAMOND_SHIELD.get());
        //shieldItem(BSItems.GILDED_DIAMOND_SHIELD.get());
        //shieldItem(BSItems.NETHERITE_SHIELD.get());
        //shieldItem(BSItems.GILDED_NETHERITE_SHIELD.get());
        //shieldItem(BSItems.ENDER_SHIELD.get());
        //shieldItem(BSItems.GILDED_ENDER_SHIELD.get());
        //shieldItem(BSItems.QUARTZ_SHIELD.get());
        //shieldItem(BSItems.GILDED_QUARTZ_SHIELD.get());
        //shieldItem(BSItems.PATCHWORK_SHIELD.get());
        //shieldItem(BSItems.GILDED_PATCHWORK_SHIELD.get());
        //shieldItem(BSItems.SKULL_SHIELD.get());
        //shieldItem(BSItems.GILDED_SKULL_SHIELD.get());
        //shieldItem(BSItems.BIOMASS_SHIELD.get());
        //shieldItem(BSItems.GILDED_BIOMASS_SHIELD.get());
        //shieldItem(BSItems.LIVINGMETAL_SHIELD.get());
        //shieldItem(BSItems.GILDED_LIVINGMETAL_SHIELD.get());
    }

    // Methods
    public ResourceLocation createFlatItemModel(Item item, ModelTemplate template) {
        return template.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(item), this.modelOutput);
    }

    public void generateFlatItem(Item item, ModelTemplate template) {
        this.output.accept(item, ItemModelUtils.plainModel(this.createFlatItemModel(item, template)));
    }
}
