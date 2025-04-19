package net.nova.big_swords.init;

import net.legacyfabric.fabric.api.registry.v1.RegistryHelper;
import net.minecraft.item.*;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.item.BSAxeItem;
import net.nova.big_swords.item.BSPickaxeItem;
import net.nova.big_swords.item.CreepBall;
import net.nova.big_swords.mixin.ItemAccessor;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    // Extra
    public static Item BIOMASS_SEED = registerItem("biomass_seed", () -> new BiomassSeed(BSBlocks.BIOMASS, BSBlocks.CREEP_BLOCK));
    public static Item CREEP_BALL = registerItem("creep_ball", CreepBall::new);
    public static Item SOUL = registerItem("soul", Item::new);
    public static Item BLOOD_VIAL = registerItem("blood_vial", Item::new);

    // Sticks
    public static Item GIANT_WOODEN_STICK = registerItem("giant_wooden_stick", Item::new);
    public static Item GIANT_BLAZE_ROD = registerItem("giant_blaze_rod", Item::new);
    public static Item GIANT_LIVINGMETAL_HANDLE = registerItem("giant_livingmetal_handle", Item::new);

    // Livingmetal Stuff
    public static Item LIVINGMETAL_INGOT = registerItem("livingmetal_ingot", Item::new);
    public static Item LIVINGMETAL_HELMET = registerItem("livingmetal_helmet", () -> new ArmorItem(ArmorMaterial.valueOf("LIVINGMETAL"), 5, 0));
    public static Item LIVINGMETAL_CHESTPLATE = registerItem("livingmetal_chestplate", () -> new ArmorItem(ArmorMaterial.valueOf("LIVINGMETAL"), 5, 1));
    public static Item LIVINGMETAL_LEGGINGS = registerItem("livingmetal_leggings", () -> new ArmorItem(ArmorMaterial.valueOf("LIVINGMETAL"), 5, 2));
    public static Item LIVINGMETAL_BOOTS = registerItem("livingmetal_boots", () -> new ArmorItem(ArmorMaterial.valueOf("LIVINGMETAL"), 5, 3));
    public static Item LIVINGMETAL_SWORD = registerItem("livingmetal_sword", () -> new SwordItem(ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_PICKAXE = registerItem("livingmetal_pickaxe", () -> new BSPickaxeItem(ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_AXE = registerItem("livingmetal_axe", () -> new BSAxeItem(ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_SHOVEL = registerItem("livingmetal_shovel", () -> new ShovelItem(ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item LIVINGMETAL_HOE = registerItem("livingmetal_hoe", () -> new HoeItem(ToolMaterial.valueOf("LIVINGMETAL")));

    // Biomass Stuff
    public static Item BIOMASS = registerItem("biomass", Item::new);
    public static Item BIOMASS_HELMET = registerItem("biomass_helmet", () -> new ArmorItem(ArmorMaterial.valueOf("BIOMASS"), 6, 0));
    public static Item BIOMASS_CHESTPLATE = registerItem("biomass_chestplate", () -> new ArmorItem(ArmorMaterial.valueOf("BIOMASS"), 6, 1));
    public static Item BIOMASS_LEGGINGS = registerItem("biomass_leggings", () -> new ArmorItem(ArmorMaterial.valueOf("BIOMASS"), 6, 2));
    public static Item BIOMASS_BOOTS = registerItem("biomass_boots", () -> new ArmorItem(ArmorMaterial.valueOf("BIOMASS"), 6, 3));
    public static Item BIOMASS_SWORD = registerItem("biomass_sword", () -> new SwordItem(ToolMaterial.valueOf("BIOMASS")));
    public static Item BIOMASS_PICKAXE = registerItem("biomass_pickaxe", () -> new BSPickaxeItem(ToolMaterial.valueOf("BIOMASS")));
    public static Item BIOMASS_AXE = registerItem("biomass_axe", () -> new BSAxeItem(ToolMaterial.valueOf("BIOMASS")));
    public static Item BIOMASS_SHOVEL = registerItem("biomass_shovel", () -> new ShovelItem(ToolMaterial.valueOf("BIOMASS")));
    public static Item BIOMASS_HOE = registerItem("biomass_hoe", () -> new HoeItem(ToolMaterial.valueOf("BIOMASS")));

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
    public static Item registerItem(String name, Supplier<Item> itemSupplier) {
        Item item = itemSupplier.get();
        ((ItemAccessor) item).big_swords$getFromId(MODID + ":" + name);
        RegistryHelper.registerItem(item, BigSwordsR.rl(name));
        return item;
    }
}