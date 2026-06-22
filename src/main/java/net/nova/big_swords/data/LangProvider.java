package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.nova.big_swords.init.*;
import net.nova.big_swords.item.EnderSmithingTemplate;
import net.nova.big_swords.item.component.SpecialShield;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class LangProvider extends LanguageProvider {
  public LangProvider(PackOutput output) {
    super(output, MODID, "en_us");
  }

  @Override
  protected void addTranslations() {
    // Items
    addItem(BSItems.GIANT_WOODEN_STICK, "Giant Wooden Stick");
    addItem(BSItems.GIANT_BLAZE_ROD, "Giant Blaze Rod");
    addItem(BSItems.GIANT_LIVINGMETAL_HANDLE, "Giant Livingmetal Handle");

    // Extra Stuff
    addBlock(BSBlocks.CREEP_BLOCK, "Creep Block");
    addItem(BSItems.CREEP_BALL, "Creep Ball");
    addItem(BSItems.BIOMASS_SEEDS, "Biomass Seeds");
    addItem(BSItems.SOUL, "Soul");
    addItem(BSItems.BLOOD_VIAL, "Blood Vial");

    // Livingmetal Lang
    addItem(BSItems.LIVINGMETAL_INGOT, "Livingmetal Ingot");
    addBlock(BSBlocks.LIVINGMETAL_BLOCK, "Livingmetal Block");
    addItem(BSItems.LIVINGMETAL_HELMET, "Livingmetal Helmet");
    addItem(BSItems.LIVINGMETAL_CHESTPLATE, "Livingmetal Chestplate");
    addItem(BSItems.LIVINGMETAL_LEGGINGS, "Livingmetal Leggings");
    addItem(BSItems.LIVINGMETAL_BOOTS, "Livingmetal Boots");
    addItem(BSItems.LIVINGMETAL_SWORD, "Livingmetal Sword");
    addItem(BSItems.LIVINGMETAL_PICKAXE, "Livingmetal Pickaxe");
    addItem(BSItems.LIVINGMETAL_AXE, "Livingmetal Axe");
    addItem(BSItems.LIVINGMETAL_SHOVEL, "Livingmetal Shovel");
    addItem(BSItems.LIVINGMETAL_HOE, "Livingmetal Hoe");
    addItem(BSItems.LIVINGMETAL_SPEAR, "Livingmetal Spear");

    // Biomass Lang
    addItem(BSItems.BIOMASS, "Biomass");
    addBlock(BSBlocks.BIOMASS_BLOCK, "Biomass Block");
    addItem(BSItems.BIOMASS_HELMET, "Biomass Helmet");
    addItem(BSItems.BIOMASS_CHESTPLATE, "Biomass Chestplate");
    addItem(BSItems.BIOMASS_LEGGINGS, "Biomass Leggings");
    addItem(BSItems.BIOMASS_BOOTS, "Biomass Boots");
    addItem(BSItems.BIOMASS_SWORD, "Biomass Sword");
    addItem(BSItems.BIOMASS_PICKAXE, "Biomass Pickaxe");
    addItem(BSItems.BIOMASS_AXE, "Biomass Axe");
    addItem(BSItems.BIOMASS_SHOVEL, "Biomass Shovel");
    addItem(BSItems.BIOMASS_HOE, "Biomass Hoe");
    addItem(BSItems.BIOMASS_SPEAR, "Biomass Spear");

    // Big Swords
    addItem(BSItems.WOODEN_BIG_SWORD, "Wooden Big Sword");
    addItem(BSItems.STONE_BIG_SWORD, "Stone Big Sword");
    addItem(BSItems.COPPER_BIG_SWORD, "Copper Big Sword");
    addItem(BSItems.IRON_BIG_SWORD, "Iron Big Sword");
    addItem(BSItems.GOLDEN_BIG_SWORD, "Golden Big Sword");
    addItem(BSItems.DIAMOND_BIG_SWORD, "Diamond Big Sword");
    addItem(BSItems.NETHERITE_BIG_SWORD, "Netherite Big Sword");
    addItem(BSItems.PATCHWORK_BIG_SWORD, "Patchwork Big Sword");
    addItem(BSItems.SKULL_BIG_SWORD, "Skull Big Sword");
    addItem(BSItems.QUARTZ_BIG_SWORD, "Quartz Big Sword");
    addItem(BSItems.OBSIDIAN_BIG_SWORD, "Obsidian Big Sword");
    addItem(BSItems.ENDER_BIG_SWORD, "Ender Big Sword");
    addItem(BSItems.LIVINGMETAL_BIG_SWORD, "Livingmetal Big Sword");
    addItem(BSItems.BIOMASS_BIG_SWORD, "Biomass Big Sword");

    // Glaives
    addItem(BSItems.WOODEN_GLAIVE, "Wooden Glaive");
    addItem(BSItems.STONE_GLAIVE, "Stone Glaive");
    addItem(BSItems.COPPER_GLAIVE, "Copper Glaive");
    addItem(BSItems.IRON_GLAIVE, "Iron Glaive");
    addItem(BSItems.GOLDEN_GLAIVE, "Golden Glaive");
    addItem(BSItems.DIAMOND_GLAIVE, "Diamond Glaive");
    addItem(BSItems.NETHERITE_GLAIVE, "Netherite Glaive");
    addItem(BSItems.BIOMASS_GLAIVE, "Biomass Glaive");
    addItem(BSItems.LIVINGMETAL_GLAIVE, "Livingmetal Glaive");

    // Scythes
    addItem(BSItems.WOODEN_SCYTHE, "Wooden Scythe");
    addItem(BSItems.STONE_SCYTHE, "Stone Scythe");
    addItem(BSItems.COPPER_SCYTHE, "Copper Scythe");
    addItem(BSItems.IRON_SCYTHE, "Iron Scythe");
    addItem(BSItems.GOLDEN_SCYTHE, "Golden Scythe");
    addItem(BSItems.DIAMOND_SCYTHE, "Diamond Scythe");
    addItem(BSItems.NETHERITE_SCYTHE, "Netherite Scythe");
    addItem(BSItems.BIOMASS_SCYTHE, "Biomass Scythe");
    addItem(BSItems.LIVINGMETAL_SCYTHE, "Livingmetal Scythe");
    addItem(BSItems.BONE_SCYTHE, "Bone Scythe");
    addItem(BSItems.SOUL_REAPER, "Soul Reaper");

    // Shields
    addShield(BSItems.WOODEN_SHIELD, BSItems.GILDED_WOODEN_SHIELD, "Wooden Shield", ToolMaterial.WOOD,
        "Special Perk: Arrow Catch", "Has a chance to catch blocked arrows and add them to the wielder's inventory",
        "Weakness: Flammable", "Consumes more durability when blocking fire damage");
    addShield(BSItems.STONE_SHIELD, BSItems.GILDED_STONE_SHIELD, "Stone Shield", ToolMaterial.STONE,
        "Special Perk: Fire Resistant", "Completely negates all fire damage, including burning projectiles",
        "Weakness: Shattered Defense", "Vulnerable to blast damage, which pierces through blocking");
    WeatheringCopperCollection.zipApply(WeatheringCopperCollection.STATES, BSItems.COPPER_SHIELD.weathering(), (state, unwaxed) -> {
      String name = state.getSerializedName();
      String statePrefix = state == WeatheringCopper.WeatherState.UNAFFECTED ? "" : name.substring(0, 1).toUpperCase() + name.substring(1) + " ";
      if (state != WeatheringCopper.WeatherState.UNAFFECTED) addItem(unwaxed, statePrefix + "Copper Shield");
      addItem(BSItems.COPPER_SHIELD.waxed().pick(state), "Waxed " + statePrefix + "Copper Shield");
    });
    WeatheringCopperCollection.zipApply(WeatheringCopperCollection.STATES, BSItems.GILDED_COPPER_SHIELD.weathering(), (state, unwaxed) -> {
      String name = state.getSerializedName();
      String statePrefix = state == WeatheringCopper.WeatherState.UNAFFECTED ? "" : name.substring(0, 1).toUpperCase() + name.substring(1) + " ";
      if (state != WeatheringCopper.WeatherState.UNAFFECTED) addItem(unwaxed, statePrefix + "Gilded Copper Shield");
      addItem(BSItems.GILDED_COPPER_SHIELD.waxed().pick(state), "Waxed " + statePrefix + "Gilded Copper Shield");
    });
    addShield(BSItems.COPPER_SHIELD.weathering().unaffected(), BSItems.GILDED_COPPER_SHIELD.weathering().unaffected(), "Copper Shield", ToolMaterial.COPPER,
        "Special Perk: Patina Shell", "Restores durability at a rate that increases with higher oxidation levels, unless the shield is waxed",
        "Weakness: Verdigris Grip", "Can no longer block when fully oxidized");
    addShield(BSItems.IRON_SHIELD, BSItems.GILDED_IRON_SHIELD, "Iron Shield", ToolMaterial.IRON,
        "Special Perk: Explosive Resistant", "Consumes less durability when blocking blast damage",
        "Weakness: Rusting", "Durability drains if the shield is held or dropped underwater.");
    addShield(BSItems.DIAMOND_SHIELD, BSItems.GILDED_DIAMOND_SHIELD, "Diamond Shield", ToolMaterial.DIAMOND,
        "Special Perk: Counter Reflect", "Has a chance to reflect blocked projectiles back to the attacker",
        "Weakness: Reflective Impact", "Blocked projectiles have a chance to deal double damage");
    addShield(BSItems.NETHERITE_SHIELD, BSItems.GILDED_NETHERITE_SHIELD, "Netherite Shield", ToolMaterial.NETHERITE,
        "Special Perk: Reflecting Guard", "Has a chance to reflect a portion of the blocked damage back at the attacker",
        "Weakness: Reflecting Pause", "Has a chance to go on cooldown when the perk activates");
    addShield(BSItems.ENDER_SHIELD, BSItems.GILDED_ENDER_SHIELD, "Ender Shield", BSToolMaterial.ENDER,
        "Special Perk: Teleport Displace", "Has a chance to teleport melee attackers a short distance away from the wielder",
        "Weakness: Ender Damage", "Ender entities bypass its blocking");
    addShield(BSItems.QUARTZ_SHIELD, BSItems.GILDED_QUARTZ_SHIELD, "Quartz Shield", BSToolMaterial.QUARTZ,
        "Special Perk: Quartz Barrier", "Has a chance to briefly apply absorption effect wielder",
        "Weakness: Hunger Toll", "Has a chance to consume wielder's hunger in exchange for the perk's effect");
    addShield(BSItems.PATCHWORK_SHIELD, BSItems.GILDED_PATCHWORK_SHIELD, "Patchwork Shield", BSToolMaterial.PATCHWORK,
        "Special Perk: Necrotic Weaken", "Has a chance to briefly apply weakness effect to the attacker",
        "Weakness: Rotten Defense", "Blocking has a chance to fail");
    addShield(BSItems.SKULL_SHIELD, BSItems.GILDED_SKULL_SHIELD, "Skull Shield", BSToolMaterial.SKULL,
        "Special Perk: Fear", "Has a chance to force the attacker to target the next closest entity",
        "Weakness: Brittle Bones", "Blocking has a chance to consume three times the normal durability");
    addShield(BSItems.BIOMASS_SHIELD, BSItems.GILDED_BIOMASS_SHIELD, "Biomass Shield", BSToolMaterial.BIOMASS,
        "Special Perk: Vitality Transfer", "Has a chance to heal the wielder at the cost of 1 level of XP per heart",
        "Weakness: Life Leech", "Has a chance to drain additional experience");
    addShield(BSItems.LIVINGMETAL_SHIELD, BSItems.GILDED_LIVINGMETAL_SHIELD, "Livingmetal Shield", BSToolMaterial.LIVINGMETAL,
        "Special Perk: Experience Infusion", "Has a chance to heal the wielder for a portion of the blocked damage",
        "Weakness: Experience Drain", "Has a chance to damage the wielder for a portion of the blocked damage");

    add(SpecialShield.SHIFT_HELP_TIP, "(Press SHIFT for more info)");

    // Creative Tab
    add(CreativeTab.BIG_SWORDS_TAB_TITLE, "Big Swords R");

    // Smithing Template
    addItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, "Ender Upgrade");
    add(EnderSmithingTemplate.ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.getString(), "Add Ender Eye");
    add(EnderSmithingTemplate.ENDER_UPGRADE_APPLIES_TO.getString(), "Ender Equipment");
    add(EnderSmithingTemplate.ENDER_UPGRADE_BASE_SLOT_DESCRIPTION.getString(), "Add obsidian armor, weapon, or tool");
    add(EnderSmithingTemplate.ENDER_UPGRADE_INGREDIENTS.getString(), "Ender Eye");

    // Sounds
    add(SoundsProvider.getSubtitle(Sounds.GLAIVE_HIT), "Glaive Hit");
    add(SoundsProvider.getSubtitle(Sounds.GLAIVE_SWING), "Glaive Swing");
    add(SoundsProvider.getSubtitle(Sounds.SCYTHE_SLASH), "Scythe Slash");
    add(SoundsProvider.getSubtitle(Sounds.REAPER_SLASH), "Reaper Slash");

    // Advancements
    addAdvancement("root", "Big Swords R", "");
    addAdvancement("first_big_sword", "Big Swords", "Your very first Big Sword");
    addAdvancement("get_netherite_big_sword", "Equipped with Debris", "Obtain the mighty Netherite Big Sword");
    addAdvancement("get_ender_big_sword", "Blade of the Void", "The Endermen last resort");

    addAdvancement("first_scythe", "Scythes", "Your very first Scythe");
    addAdvancement("get_netherite_scythe", "Harvest Enemies with Debris", "Obtain the formidable Netherite Scythe");
    addAdvancement("get_soul_reaper", "Grim Reaper's Touch", "Reap them of their souls");

    addAdvancement("first_glaive", "Glaives", "Your very first Glaive");
    addAdvancement("get_netherite_glaive", "Reaching with Debris", "Obtain the imposing Netherite Glaive");

    addAdvancement("first_shield", "Shields", "Your very first Shield");
    addAdvancement("get_netherite_shield", "Protected with Debris", "Obtain the unyielding Netherite Shield");
    addAdvancement("get_ender_shield", "Warped Protection", "Obtain the teleporting Ender Shield");

    addAdvancement("creep_a_block", "Creep-A-Block", "Use a Creeper Ball on Soul Sand to create a Creep Block");
    addAdvancement("till_creep", "Till Creep Blocks", "Use a Glaive on Creep Blocks to till them and start your biomass farm");

    addAdvancement("soul_harvesting", "Soul Harvesting", "Claim the essence of your first fallen foe");

    // Trim Material
    add("trim_material.big_swords.livingmetal", "Livingmetal Material");

    // Attributes
    add("attribute.name.charged_damage", "Charged Damage");

    // Resourcepacks
    add(BSPackMetaGenerator.RP_16x_NAME, "Big Swords R 16x");
    add(BSPackMetaGenerator.RP_16x_DESC, "16x textures for Big Swords");
    add(BSPackMetaGenerator.RP_old_NAME, "Big Swords R Old");
    add(BSPackMetaGenerator.RP_old_DESC, "The classic look of Big Swords");

    // Mod Menu
    add(MODID + ".modrinth", "Modrinth Link");
    add(MODID + ".curseforge", "CurseForge Link");
    add(MODID + ".wiki", "Wiki Link");
  }

  // Methods
  public void addAdvancement(String advancementName, String title, String description) {
    add("advancements." + MODID + "." + advancementName + ".title", title);
    add("advancements." + MODID + "." + advancementName + ".description", description);
  }

  public void addShield(Supplier<? extends Item> item, Supplier<? extends Item> gildedItem, String name,
                        ToolMaterial material, String basePerkLabel, String basePerkDesc, String baseWeaknessLabel, String baseWeaknessDesc) {
    addItem(item, name);
    addItem(gildedItem, "Gilded " + name);

    String materialKey = BSToolMaterial.getIdFromMaterial(material);
    add("tooltip.big_swords." + materialKey + ".perk", basePerkLabel);
    add("tooltip.big_swords." + materialKey + ".weakness", baseWeaknessLabel);

    // Shift description
    add("tooltip.big_swords." + materialKey + ".perk.description", basePerkDesc);
    add("tooltip.big_swords." + materialKey + ".weakness.description", baseWeaknessDesc);
  }
}
