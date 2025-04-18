package net.nova.big_swords.init;

import net.legacyfabric.fabric.api.registry.v1.RegistryHelper;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.item.*;

public class BSItems {
    // Extra
    public static Item BIOMASS_SEED = registerItem("biomass_seed", id -> new BiomassSeed(id, BSBlocks.BIOMASS, BSBlocks.CREEP_BLOCK));
    public static Item CREEP_BALL = registerItem("creep_ball", CreepBall::new);
    public static Item SOUL = registerItem("soul", BSItem::new);
    public static Item BLOOD_VIAL = registerItem("blood_vial", BSItem::new);

    // Sticks
    public static Item GIANT_WOODEN_STICK = registerItem("giant_wooden_stick", BSItem::new);
    public static Item GIANT_BLAZE_ROD = registerItem("giant_blaze_rod", BSItem::new);
    public static Item GIANT_LIVINGMETAL_HANDLE = registerItem("giant_livingmetal_handle", BSItem::new);
    public static Item LIVINGMETAL_HELMET = registerItem("livingmetal_helmet", id -> new BSArmorItem(id, ArmorMaterial.valueOf("LIVINGMETAL"), 5, 0));
    public static Item LIVINGMETAL_CHESTPLATE = registerItem("livingmetal_chestplate", id -> new BSArmorItem(id, ArmorMaterial.valueOf("LIVINGMETAL"), 5, 1));
    public static Item LIVINGMETAL_LEGGINGS = registerItem("livingmetal_leggings", id -> new BSArmorItem(id, ArmorMaterial.valueOf("LIVINGMETAL"), 5, 2));
    public static Item LIVINGMETAL_BOOTS = registerItem("livingmetal_boots", id -> new BSArmorItem(id, ArmorMaterial.valueOf("LIVINGMETAL"), 5, 3));
    public static Item LIVINGMETAL_SWORD = registerItem("livingmetal_sword", id -> new BSSwordItem(id, ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_PICKAXE = registerItem("livingmetal_pickaxe", id -> new BSPickaxeItem(id, ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_AXE = registerItem("livingmetal_axe", id -> new BSAxeItem(id, ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_SHOVEL = registerItem("livingmetal_shovel", id -> new BSShovelItem(id, ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_HOE = registerItem("livingmetal_hoe", id -> new BSHoeItem(id, ToolMaterial.valueOf("LIVINGMETAL")));

    // Livingmetal Stuff
    public static Item LIVINGMETAL_INGOT = registerItem("livingmetal_ingot", BSItem::new);

    // Methods
    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Items");
    }

    /**
     * Helper method to register an item using a supplier
     *
     * @param name         The registry name
     * @param itemSupplier The function to create the item instance
     * @return The registered item
     */
    public static Item registerItem(String name, ItemSupplier itemSupplier) {
        Item item = itemSupplier.create(name);
        RegistryHelper.registerItem(item, BigSwordsR.rl(name));
        return item;
    }

    /**
     * Functional interface for item creation
     */
    @FunctionalInterface
    public interface ItemSupplier {
        Item create(String name);
    }
}