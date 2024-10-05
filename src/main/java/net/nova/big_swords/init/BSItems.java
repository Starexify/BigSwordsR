package net.nova.big_swords.init;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nova.big_swords.item.CreepBall;
import net.nova.big_swords.item.EnderSmithingTemplate;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Extra
    public static RegistryObject<Item> BIOMASS_SEED = ITEMS.register("biomass_seed", () -> new ItemNameBlockItem(BSBlocks.BIOMASS.get(), new Item.Properties()));
    public static RegistryObject<Item> CREEP_BALL = ITEMS.register("creep_ball", () -> new CreepBall(new Item.Properties()));
    public static RegistryObject<Item> SOUL = ITEMS.register("soul", () -> new Item(new Item.Properties()));

    // Sticks
    public static RegistryObject<Item> GIANT_WOODEN_STICK = ITEMS.register("giant_wooden_stick", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> GIANT_BLAZE_ROD = ITEMS.register("giant_blaze_rod", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> GIANT_LIVINGMETAL_HANDLE = ITEMS.register("giant_livingmetal_handle", () -> new Item(new Item.Properties()));

    // Ender Template
    public static RegistryObject<Item> ENDER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ender_upgrade_smithing_template", EnderSmithingTemplate::createEnderUpgradeTemplate);

    // Livingmetal Stuff
    public static RegistryObject<Item> LIVINGMETAL_INGOT = ITEMS.register("livingmetal_ingot", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_HELMET = ITEMS.register("livingmetal_helmet", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_CHESTPLATE = ITEMS.register("livingmetal_chestplate", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_LEGGINGS = ITEMS.register("livingmetal_leggings", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static RegistryObject<Item> LIVINGMETAL_BOOTS = ITEMS.register("livingmetal_boots", () -> new ArmorItem(BSArmorMaterial.LIVINGMETAL, ArmorItem.Type.BOOTS, new Item.Properties()));
//    public static RegistryObject<Item> LIVINGMETAL_SWORD = ITEMS.register("livingmetal_sword", () -> new SwordItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(SwordItem.createAttributes(BSTiers.LIVINGMETAL, 3, -2.4F))));
//    public static RegistryObject<Item> LIVINGMETAL_PICKAXE = ITEMS.register("livingmetal_pickaxe", () -> new PickaxeItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(PickaxeItem.createAttributes(BSTiers.LIVINGMETAL, 1.0F, -2.8F))));
//    public static RegistryObject<Item> LIVINGMETAL_AXE = ITEMS.register("livingmetal_axe", () -> new AxeItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(AxeItem.createAttributes(BSTiers.LIVINGMETAL, 6.0F, -3.0F))));
//    public static RegistryObject<Item> LIVINGMETAL_SHOVEL = ITEMS.register("livingmetal_shovel", () -> new ShovelItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(ShovelItem.createAttributes(BSTiers.LIVINGMETAL, 1.5F, -3.0F))));
//    public static RegistryObject<Item> LIVINGMETAL_HOE = ITEMS.register("livingmetal_hoe", () -> new HoeItem(BSTiers.LIVINGMETAL, new Item.Properties().attributes(HoeItem.createAttributes(BSTiers.LIVINGMETAL, -2.5F, -0.5F))));

    // Biomass Stuff
    public static RegistryObject<Item> BIOMASS = ITEMS.register("biomass", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_HELMET = ITEMS.register("biomass_helmet", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_CHESTPLATE = ITEMS.register("biomass_chestplate", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_LEGGINGS = ITEMS.register("biomass_leggings", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static RegistryObject<Item> BIOMASS_BOOTS = ITEMS.register("biomass_boots", () -> new ArmorItem(BSArmorMaterial.BIOMASS, ArmorItem.Type.BOOTS, new Item.Properties()));
/*  public static RegistryObject<Item> BIOMASS_SWORD = ITEMS.register("biomass_sword", () -> new SwordItem(BSTiers.BIOMASS, new Item.Properties().attributes(SwordItem.createAttributes(BSTiers.BIOMASS, 3, -2.4F))));
    public static RegistryObject<Item> BIOMASS_PICKAXE = ITEMS.register("biomass_pickaxe", () -> new PickaxeItem(BSTiers.BIOMASS, new Item.Properties().attributes(PickaxeItem.createAttributes(BSTiers.BIOMASS, 1.0F, -2.8F))));
    public static RegistryObject<Item> BIOMASS_AXE = ITEMS.register("biomass_axe", () -> new AxeItem(BSTiers.BIOMASS, new Item.Properties().attributes(AxeItem.createAttributes(BSTiers.BIOMASS, 6.0F, -3.0F))));
    public static RegistryObject<Item> BIOMASS_SHOVEL = ITEMS.register("biomass_shovel", () -> new ShovelItem(BSTiers.BIOMASS, new Item.Properties().attributes(ShovelItem.createAttributes(BSTiers.BIOMASS, 1.5F, -3.0F))));
    public static RegistryObject<Item> BIOMASS_HOE = ITEMS.register("biomass_hoe", () -> new HoeItem(BSTiers.BIOMASS, new Item.Properties().attributes(HoeItem.createAttributes(BSTiers.BIOMASS, -2.5F, -0.5F))));
*/

}
