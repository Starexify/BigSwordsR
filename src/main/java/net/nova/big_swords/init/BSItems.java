package net.nova.big_swords.init;

import net.legacyfabric.fabric.api.registry.v2.RegistryHelper;
import net.minecraft.item.*;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.item.*;

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

    // Big Swords
    public static Item WOODEN_BIG_SWORD = registerItem("wooden_big_sword", () -> new BigSwordItem(ToolMaterial.WOOD));
    public static Item STONE_BIG_SWORD = registerItem("stone_big_sword", () -> new BigSwordItem(ToolMaterial.STONE));
    public static Item IRON_BIG_SWORD = registerItem("iron_big_sword", () -> new BigSwordItem(ToolMaterial.IRON));
    public static Item GOLDEN_BIG_SWORD = registerItem("golden_big_sword", () -> new BigSwordItem(ToolMaterial.GOLD));
    public static Item DIAMOND_BIG_SWORD = registerItem("diamond_big_sword", () -> new BigSwordItem(ToolMaterial.DIAMOND));
    public static Item PATCHWORK_BIG_SWORD = registerItem("patchwork_big_sword", () -> new BigSwordItem(ToolMaterial.valueOf("PATCHWORK")));
    public static Item SKULL_BIG_SWORD = registerItem("skull_big_sword", () -> new BigSwordItem(ToolMaterial.valueOf("SKULL")));
    public static Item QUARTZ_BIG_SWORD = registerItem("quartz_big_sword", () -> new BigSwordItem(ToolMaterial.valueOf("QUARTZ")));
    public static Item OBSIDIAN_BIG_SWORD = registerItem("obsidian_big_sword", () -> new BigSwordItem(ToolMaterial.valueOf("OBSIDIAN")));
    public static Item ENDER_BIG_SWORD = registerItem("ender_big_sword", () -> new BigSwordItem(ToolMaterial.valueOf("ENDER")));
    public static Item LIVINGMETAL_BIG_SWORD = registerItem("livingmetal_big_sword", () -> new BigSwordItem(ToolMaterial.valueOf("LIVINGMETAL")));
    public static Item BIOMASS_BIG_SWORD = registerItem("biomass_big_sword", () -> new BigSwordItem(ToolMaterial.valueOf("BIOMASS")));

    // Glaives
    public static Item WOODEN_GLAIVE = registerItem("wooden_glaive", () -> new GlaiveItem(ToolMaterial.WOOD, 3F, 4F));
    public static Item STONE_GLAIVE = registerItem("stone_glaive", () -> new GlaiveItem(ToolMaterial.STONE, 3.5F, 4.5F));
    public static Item IRON_GLAIVE = registerItem("iron_glaive", () -> new GlaiveItem(ToolMaterial.IRON, 4F, 5F));
    public static Item GOLDEN_GLAIVE = registerItem("golden_glaive", () -> new GlaiveItem(ToolMaterial.GOLD, 3F, 4F));
    public static Item DIAMOND_GLAIVE = registerItem("diamond_glaive", () -> new GlaiveItem(ToolMaterial.DIAMOND, 4.5F, 5.5F));
    public static Item LIVINGMETAL_GLAIVE = registerItem("livingmetal_glaive", () -> new GlaiveItem(ToolMaterial.valueOf("LIVINGMETAL"), 4.5F, 5.5F));
    public static Item BIOMASS_GLAIVE = registerItem("biomass_glaive", () -> new GlaiveItem(ToolMaterial.valueOf("BIOMASS"), 5.4F, 6.0F));

    // Methods
    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Items");
    }

    /**
     * Helper method to register an item using a supplier
     *
     * @param name         The registry name
     * @param itemSupplier The supplier for getting the item instance
     * @return The registered item
     */
    public static Item registerItem(String name, Supplier<Item> itemSupplier) {
        Item item = itemSupplier.get().setItemGroup(CreativeTab.BIG_SWORDS_TAB).getFromId(MODID + ":" + name);
        RegistryHelper.register(Item.REGISTRY, BigSwordsR.rl(name), item);
        return item;
    }
}