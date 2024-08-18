package net.nova.big_swords.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.big_swords.client.renderer.item.BSItemProperties;
import net.nova.big_swords.init.BSItems;

import java.util.LinkedHashMap;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItemModelProvider extends ItemModelProvider {
    public static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public BSItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Extra
        basicItem(BSItems.CREEP_BALL.get());
        basicItem(BSItems.BIOMASS_SEED.get());

        // Sticks
        basicItem(BSItems.GIANT_WOODEN_STICK.get());
        basicItem(BSItems.GIANT_BLAZE_ROD.get());
        basicItem(BSItems.GIANT_LIVINGMETAL_HANDLE.get());

        // Livingmetal Models
        basicItem(BSItems.LIVINGMETAL_INGOT.get());
        trimmableArmorItem(BSItems.LIVINGMETAL_HELMET.get());
        trimmableArmorItem(BSItems.LIVINGMETAL_CHESTPLATE.get());
        trimmableArmorItem(BSItems.LIVINGMETAL_LEGGINGS.get());
        trimmableArmorItem(BSItems.LIVINGMETAL_BOOTS.get());
        handheldItem(BSItems.LIVINGMETAL_SWORD.get());
        handheldItem(BSItems.LIVINGMETAL_PICKAXE.get());
        handheldItem(BSItems.LIVINGMETAL_AXE.get());
        handheldItem(BSItems.LIVINGMETAL_SHOVEL.get());
        handheldItem(BSItems.LIVINGMETAL_HOE.get());

        // Biomass Models
        trimmableArmorItem(BSItems.BIOMASS_HELMET.get());
        trimmableArmorItem(BSItems.BIOMASS_CHESTPLATE.get());
        trimmableArmorItem(BSItems.BIOMASS_LEGGINGS.get());
        trimmableArmorItem(BSItems.BIOMASS_BOOTS.get());
        handheldItem(BSItems.BIOMASS_SWORD.get());
        handheldItem(BSItems.BIOMASS_PICKAXE.get());
        handheldItem(BSItems.BIOMASS_AXE.get());
        handheldItem(BSItems.BIOMASS_SHOVEL.get());
        handheldItem(BSItems.BIOMASS_HOE.get());

        // Ender Upgrade
        basicItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get());

        // Big Swords
        handheldItem(BSItems.WOODEN_BIG_SWORD.get());
        handheldItem(BSItems.STONE_BIG_SWORD.get());
        handheldItem(BSItems.IRON_BIG_SWORD.get());
        handheldItem(BSItems.GOLDEN_BIG_SWORD.get());
        handheldItem(BSItems.DIAMOND_BIG_SWORD.get());
        handheldItem(BSItems.NETHERITE_BIG_SWORD.get());
        handheldItem(BSItems.PATCHWORK_BIG_SWORD.get());
        handheldItem(BSItems.SKULL_BIG_SWORD.get());
        handheldItem(BSItems.QUARTZ_BIG_SWORD.get());
        handheldItem(BSItems.OBSIDIAN_BIG_SWORD.get());
        handheldItem(BSItems.ENDER_BIG_SWORD.get());
        handheldItem(BSItems.LIVINGMETAL_BIG_SWORD.get());
        handheldItem(BSItems.BIOMASS_BIG_SWORD.get());

        // Glaives
        handheldGlaive(BSItems.WOODEN_GLAIVE.get());
        handheldGlaive(BSItems.STONE_GLAIVE.get());
        handheldGlaive(BSItems.IRON_GLAIVE.get());
        handheldGlaive(BSItems.GOLDEN_GLAIVE.get());
        handheldGlaive(BSItems.DIAMOND_GLAIVE.get());
        handheldGlaive(BSItems.NETHERITE_GLAIVE.get());
        handheldGlaive(BSItems.BIOMASS_GLAIVE.get());
        handheldGlaive(BSItems.LIVINGMETAL_GLAIVE.get());

        // Scythes
        handheldItem(BSItems.WOODEN_SCYTHE.get());
        handheldItem(BSItems.STONE_SCYTHE.get());
        handheldItem(BSItems.IRON_SCYTHE.get());
        handheldItem(BSItems.GOLDEN_SCYTHE.get());
        handheldItem(BSItems.DIAMOND_SCYTHE.get());
        handheldItem(BSItems.NETHERITE_SCYTHE.get());
        handheldItem(BSItems.BIOMASS_SCYTHE.get());
        handheldItem(BSItems.LIVINGMETAL_SCYTHE.get());
        handheldItem(BSItems.BONE_SCYTHE.get());
        handheldItem(BSItems.SOUL_REAPER.get());

        // Shields
        shieldItem(BSItems.WOODEN_SHIELD.get());
    }

    // Models
    private void shieldItem(Item item) {
        getBuilder(getItemName(item) + "_blocking")
                .parent(getExistingFile(modLoc("item/template_shield_blocking")))
                .texture("layer0", "item/" + getItemName(item));

        getBuilder(getItemName(item))
                .parent(getExistingFile(modLoc("item/template_shield")))
                .texture("layer0", "item/" + getItemName(item))
                .override().predicate(BSItemProperties.blockingPredicate, 1)
                .model(getExistingFile(modLoc("item/" + getItemName(item) + "_blocking")));
    }

    private void handheldGlaive(Item item) {
        getBuilder(getItemName(item))
                .parent(getExistingFile(modLoc("item/handheld_glaive")))
                .texture("layer0", "item/" + getItemName(item));
    }

    private void handheldItem(Item item) {
        getBuilder(getItemName(item))
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/" + getItemName(item));
    }

    private void trimmableArmorItem(Item item) {
        if (item instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {
                // Variables
                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String trimType = entry.getKey().location().getPath();
                String name = getItemName(item);
                float trimValue = entry.getValue();
                ResourceLocation textureLocation = mcLoc("trims/items/" + armorType + "_trim_" + trimType);
                String itemName = "item/" + name;
                ModelFile mcItem = getExistingFile(mcLoc("item/generated"));

                // Trimmed parts
                getBuilder(name + "_" + trimType + "_trim")
                        .parent(mcItem)
                        .texture("layer0", itemName)
                        .texture("layer1", textureLocation);

                // Armor with trimmed parts
                getBuilder(name)
                        .parent(mcItem)
                        .override()
                        .predicate(ResourceLocation.parse("trim_type"), trimValue)
                        .model(getExistingFile(modLoc(itemName + "_" + trimType + "_trim"))).end()
                        .texture("layer0", modLoc(itemName));
            });
        }
    }

    private String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(MODID + ":", "");
    }
}
