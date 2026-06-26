package net.nova.big_swords.data;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.nova.big_swords.BSClient;
import net.nova.big_swords.init.*;
import net.nova.big_swords.item.EnderSmithingTemplate;
import net.nova.big_swords.item.component.SpecialShield;

import java.util.concurrent.CompletableFuture;

import static net.nova.big_swords.BigSwordsR.MODID;

public class LangProvider extends FabricLanguageProvider {
  public LangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(dataOutput, registryLookup);
  }

  @Override
  public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
    // Items
    translationBuilder.add(BSItems.GIANT_WOODEN_STICK.getFirst().value(), "Giant Wooden Stick");
    translationBuilder.add(BSItems.GIANT_BLAZE_ROD.getFirst().value(), "Giant Blaze Rod");
    translationBuilder.add(BSItems.GIANT_LIVINGMETAL_HANDLE.getFirst().value(), "Giant Livingmetal Handle");

    // Extra Stuff
    translationBuilder.add(BSBlocks.CREEP_BLOCK.getFirst().value(), "Creep Block");
    translationBuilder.add(BSItems.CREEP_BALL.getFirst().value(), "Creep Ball");
    translationBuilder.add(BSItems.BIOMASS_SEED.getFirst().value(), "Biomass Seed");
    translationBuilder.add(BSItems.SOUL.getFirst().value(), "Soul");
    translationBuilder.add(BSItems.BLOOD_VIAL.getFirst().value(), "Blood Vial");

    // Livingmetal Lang
    translationBuilder.add(BSItems.LIVINGMETAL_INGOT.getFirst().value(), "Livingmetal Ingot");
    translationBuilder.add(BSBlocks.LIVINGMETAL_BLOCK.getFirst().value(), "Livingmetal Block");
    translationBuilder.add(BSItems.LIVINGMETAL_HELMET.getFirst().value(), "Livingmetal Helmet");
    translationBuilder.add(BSItems.LIVINGMETAL_CHESTPLATE.getFirst().value(), "Livingmetal Chestplate");
    translationBuilder.add(BSItems.LIVINGMETAL_LEGGINGS.getFirst().value(), "Livingmetal Leggings");
    translationBuilder.add(BSItems.LIVINGMETAL_BOOTS.getFirst().value(), "Livingmetal Boots");
    translationBuilder.add(BSItems.LIVINGMETAL_SWORD.getFirst().value(), "Livingmetal Sword");
    translationBuilder.add(BSItems.LIVINGMETAL_PICKAXE.getFirst().value(), "Livingmetal Pickaxe");
    translationBuilder.add(BSItems.LIVINGMETAL_AXE.getFirst().value(), "Livingmetal Axe");
    translationBuilder.add(BSItems.LIVINGMETAL_SHOVEL.getFirst().value(), "Livingmetal Shovel");
    translationBuilder.add(BSItems.LIVINGMETAL_HOE.getFirst().value(), "Livingmetal Hoe");

    // Biomass Lang
    translationBuilder.add(BSItems.BIOMASS.getFirst().value(), "Biomass");
    translationBuilder.add(BSBlocks.BIOMASS_BLOCK.getFirst().value(), "Biomass Block");
    translationBuilder.add(BSItems.BIOMASS_HELMET.getFirst().value(), "Biomass Helmet");
    translationBuilder.add(BSItems.BIOMASS_CHESTPLATE.getFirst().value(), "Biomass Chestplate");
    translationBuilder.add(BSItems.BIOMASS_LEGGINGS.getFirst().value(), "Biomass Leggings");
    translationBuilder.add(BSItems.BIOMASS_BOOTS.getFirst().value(), "Biomass Boots");
    translationBuilder.add(BSItems.BIOMASS_SWORD.getFirst().value(), "Biomass Sword");
    translationBuilder.add(BSItems.BIOMASS_PICKAXE.getFirst().value(), "Biomass Pickaxe");
    translationBuilder.add(BSItems.BIOMASS_AXE.getFirst().value(), "Biomass Axe");
    translationBuilder.add(BSItems.BIOMASS_SHOVEL.getFirst().value(), "Biomass Shovel");
    translationBuilder.add(BSItems.BIOMASS_HOE.getFirst().value(), "Biomass Hoe");

    // Big Swords
    translationBuilder.add(BSItems.WOODEN_BIG_SWORD.getFirst().value(), "Wooden Big Sword");
    translationBuilder.add(BSItems.STONE_BIG_SWORD.getFirst().value(), "Stone Big Sword");
    translationBuilder.add(BSItems.COPPER_BIG_SWORD.getFirst().value(), "Copper Big Sword");
    translationBuilder.add(BSItems.IRON_BIG_SWORD.getFirst().value(), "Iron Big Sword");
    translationBuilder.add(BSItems.GOLDEN_BIG_SWORD.getFirst().value(), "Golden Big Sword");
    translationBuilder.add(BSItems.DIAMOND_BIG_SWORD.getFirst().value(), "Diamond Big Sword");
    translationBuilder.add(BSItems.NETHERITE_BIG_SWORD.getFirst().value(), "Netherite Big Sword");
    translationBuilder.add(BSItems.PATCHWORK_BIG_SWORD.getFirst().value(), "Patchwork Big Sword");
    translationBuilder.add(BSItems.SKULL_BIG_SWORD.getFirst().value(), "Skull Big Sword");
    translationBuilder.add(BSItems.QUARTZ_BIG_SWORD.getFirst().value(), "Quartz Big Sword");
    translationBuilder.add(BSItems.OBSIDIAN_BIG_SWORD.getFirst().value(), "Obsidian Big Sword");
    translationBuilder.add(BSItems.ENDER_BIG_SWORD.getFirst().value(), "Ender Big Sword");
    translationBuilder.add(BSItems.LIVINGMETAL_BIG_SWORD.getFirst().value(), "Livingmetal Big Sword");
    translationBuilder.add(BSItems.BIOMASS_BIG_SWORD.getFirst().value(), "Biomass Big Sword");

    // Glaives
    translationBuilder.add(BSItems.WOODEN_GLAIVE.getFirst().value(), "Wooden Glaive");
    translationBuilder.add(BSItems.STONE_GLAIVE.getFirst().value(), "Stone Glaive");
    translationBuilder.add(BSItems.COPPER_GLAIVE.getFirst().value(), "Copper Glaive");
    translationBuilder.add(BSItems.IRON_GLAIVE.getFirst().value(), "Iron Glaive");
    translationBuilder.add(BSItems.GOLDEN_GLAIVE.getFirst().value(), "Golden Glaive");
    translationBuilder.add(BSItems.DIAMOND_GLAIVE.getFirst().value(), "Diamond Glaive");
    translationBuilder.add(BSItems.NETHERITE_GLAIVE.getFirst().value(), "Netherite Glaive");
    translationBuilder.add(BSItems.BIOMASS_GLAIVE.getFirst().value(), "Biomass Glaive");
    translationBuilder.add(BSItems.LIVINGMETAL_GLAIVE.getFirst().value(), "Livingmetal Glaive");

    // Scythes
    translationBuilder.add(BSItems.WOODEN_SCYTHE.getFirst().value(), "Wooden Scythe");
    translationBuilder.add(BSItems.STONE_SCYTHE.getFirst().value(), "Stone Scythe");
    translationBuilder.add(BSItems.COPPER_SCYTHE.getFirst().value(), "Copper Scythe");
    translationBuilder.add(BSItems.IRON_SCYTHE.getFirst().value(), "Iron Scythe");
    translationBuilder.add(BSItems.GOLDEN_SCYTHE.getFirst().value(), "Golden Scythe");
    translationBuilder.add(BSItems.DIAMOND_SCYTHE.getFirst().value(), "Diamond Scythe");
    translationBuilder.add(BSItems.NETHERITE_SCYTHE.getFirst().value(), "Netherite Scythe");
    translationBuilder.add(BSItems.BIOMASS_SCYTHE.getFirst().value(), "Biomass Scythe");
    translationBuilder.add(BSItems.LIVINGMETAL_SCYTHE.getFirst().value(), "Livingmetal Scythe");
    translationBuilder.add(BSItems.BONE_SCYTHE.getFirst().value(), "Bone Scythe");
    translationBuilder.add(BSItems.SOUL_REAPER.getFirst().value(), "Soul Reaper");

    // Shields
    addShield(translationBuilder, BSItems.WOODEN_SHIELD, BSItems.GILDED_WOODEN_SHIELD, "Wooden Shield", ToolMaterial.WOOD,
        "Special Perk: Arrow Catch", "Has a chance to catch blocked arrows and add them to the wielder's inventory",
        "Weakness: Flammable", "Consumes more durability when blocking fire damage");
    addShield(translationBuilder, BSItems.STONE_SHIELD, BSItems.GILDED_STONE_SHIELD, "Stone Shield", ToolMaterial.STONE,
        "Special Perk: Fire Resistant", "Completely negates all fire damage, including burning projectiles",
        "Weakness: Shattered Defense", "Vulnerable to blast damage, which pierces through blocking");
    WeatheringCopperCollection.zipApply(WeatheringCopperCollection.STATES, BSItems.COPPER_SHIELD.weathering(), (state, unwaxed) -> {
      String name = state.getSerializedName();
      String statePrefix = state == WeatheringCopper.WeatherState.UNAFFECTED ? "" : name.substring(0, 1).toUpperCase() + name.substring(1) + " ";
      if (state != WeatheringCopper.WeatherState.UNAFFECTED) translationBuilder.add(unwaxed.getFirst().value(), statePrefix + "Copper Shield");
      translationBuilder.add(BSItems.COPPER_SHIELD.waxed().pick(state).getFirst().value(), "Waxed " + statePrefix + "Copper Shield");
    });
    WeatheringCopperCollection.zipApply(WeatheringCopperCollection.STATES, BSItems.GILDED_COPPER_SHIELD.weathering(), (state, unwaxed) -> {
      String name = state.getSerializedName();
      String statePrefix = state == WeatheringCopper.WeatherState.UNAFFECTED ? "" : name.substring(0, 1).toUpperCase() + name.substring(1) + " ";
      if (state != WeatheringCopper.WeatherState.UNAFFECTED) translationBuilder.add(unwaxed.getFirst().value(), statePrefix + "Gilded Copper Shield");
      translationBuilder.add(BSItems.GILDED_COPPER_SHIELD.waxed().pick(state).getFirst().value(), "Waxed " + statePrefix + "Gilded Copper Shield");
    });
    addShield(translationBuilder, BSItems.COPPER_SHIELD.weathering().unaffected(), BSItems.GILDED_COPPER_SHIELD.weathering().unaffected(), "Copper Shield", ToolMaterial.COPPER,
        "Special Perk: Patina Shell", "Restores durability at a rate that increases with higher oxidation levels, unless the shield is waxed",
        "Weakness: Verdigris Grip", "Can no longer block when fully oxidized");
    addShield(translationBuilder, BSItems.IRON_SHIELD, BSItems.GILDED_IRON_SHIELD, "Iron Shield", ToolMaterial.IRON,
        "Special Perk: Explosive Resistant", "Consumes less durability when blocking blast damage",
        "Weakness: Rusting", "Durability drains if the shield is held or dropped underwater.");
    addShield(translationBuilder, BSItems.DIAMOND_SHIELD, BSItems.GILDED_DIAMOND_SHIELD, "Diamond Shield", ToolMaterial.DIAMOND,
        "Special Perk: Counter Reflect", "Has a chance to reflect blocked projectiles back to the attacker",
        "Weakness: Reflective Impact", "Blocked projectiles have a chance to deal double damage");
    addShield(translationBuilder, BSItems.NETHERITE_SHIELD, BSItems.GILDED_NETHERITE_SHIELD, "Netherite Shield", ToolMaterial.NETHERITE,
        "Special Perk: Reflecting Guard", "Has a chance to reflect a portion of the blocked damage back at the attacker",
        "Weakness: Reflecting Pause", "Has a chance to go on cooldown when the perk activates");
    addShield(translationBuilder, BSItems.ENDER_SHIELD, BSItems.GILDED_ENDER_SHIELD, "Ender Shield", BSToolMaterial.ENDER,
        "Special Perk: Teleport Displace", "Has a chance to teleport melee attackers a short distance away from the wielder",
        "Weakness: Ender Damage", "Ender entities bypass its blocking");
    addShield(translationBuilder, BSItems.QUARTZ_SHIELD, BSItems.GILDED_QUARTZ_SHIELD, "Quartz Shield", BSToolMaterial.QUARTZ,
        "Special Perk: Quartz Barrier", "Has a chance to briefly apply absorption effect wielder",
        "Weakness: Hunger Toll", "Has a chance to consume wielder's hunger in exchange for the perk's effect");
    addShield(translationBuilder, BSItems.PATCHWORK_SHIELD, BSItems.GILDED_PATCHWORK_SHIELD, "Patchwork Shield", BSToolMaterial.PATCHWORK,
        "Special Perk: Necrotic Weaken", "Has a chance to briefly apply weakness effect to the attacker",
        "Weakness: Rotten Defense", "Blocking has a chance to fail");
    addShield(translationBuilder, BSItems.SKULL_SHIELD, BSItems.GILDED_SKULL_SHIELD, "Skull Shield", BSToolMaterial.SKULL,
        "Special Perk: Fear", "Has a chance to force the attacker to target the next closest entity",
        "Weakness: Brittle Bones", "Blocking has a chance to consume three times the normal durability");
    addShield(translationBuilder, BSItems.BIOMASS_SHIELD, BSItems.GILDED_BIOMASS_SHIELD, "Biomass Shield", BSToolMaterial.BIOMASS,
        "Special Perk: Vitality Transfer", "Has a chance to heal the wielder at the cost of 1 level of XP per heart",
        "Weakness: Life Leech", "Has a chance to drain additional experience");
    addShield(translationBuilder, BSItems.LIVINGMETAL_SHIELD, BSItems.GILDED_LIVINGMETAL_SHIELD, "Livingmetal Shield", BSToolMaterial.LIVINGMETAL,
        "Special Perk: Experience Infusion", "Has a chance to heal the wielder for a portion of the blocked damage",
        "Weakness: Experience Drain", "Has a chance to damage the wielder for a portion of the blocked damage");

    translationBuilder.add(SpecialShield.SHIFT_HELP_TIP, "(Press SHIFT for more info)");


    // Creative Tab
    translationBuilder.add(CreativeTab.BIG_SWORDS_TAB_TITLE, "Big Swords R");

    // Smithing Template
    translationBuilder.add(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.getFirst().value(), "Ender Upgrade");
    translationBuilder.add(EnderSmithingTemplate.ENDER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION.getString(), "Add Ender Eye");
    translationBuilder.add(EnderSmithingTemplate.ENDER_UPGRADE_APPLIES_TO.getString(), "Ender Equipment");
    translationBuilder.add(EnderSmithingTemplate.ENDER_UPGRADE_BASE_SLOT_DESCRIPTION.getString(), "Add obsidian armor, weapon, or tool");
    translationBuilder.add(EnderSmithingTemplate.ENDER_UPGRADE_INGREDIENTS.getString(), "Ender Eye");

    // Sounds
    translationBuilder.add(SoundsProvider.getSubtitle(Sounds.GLAIVE_HIT), "Glaive Hit");
    translationBuilder.add(SoundsProvider.getSubtitle(Sounds.GLAIVE_SWING), "Glaive Swing");
    translationBuilder.add(SoundsProvider.getSubtitle(Sounds.SCYTHE_SLASH), "Scythe Slash");
    translationBuilder.add(SoundsProvider.getSubtitle(Sounds.REAPER_SLASH), "Reaper Slash");

    // Advancements
    addAdvancement(translationBuilder, "root", "The root of Big Swords R", "");
    addAdvancement(translationBuilder, "first_big_sword", "Big Swords", "Your very first Big Sword");
    addAdvancement(translationBuilder, "get_netherite_big_sword", "Equipped with Debris", "Obtain the mighty Netherite Big Sword");
    addAdvancement(translationBuilder, "get_ender_big_sword", "Blade of the Void", "The Endermen last resort");

    addAdvancement(translationBuilder, "first_scythe", "Scythes", "Your very first Scythe");
    addAdvancement(translationBuilder, "get_netherite_scythe", "Harvest Enemies with Debris", "Obtain the formidable Netherite Scythe");
    addAdvancement(translationBuilder, "get_soul_reaper", "Grim Reaper's Touch", "Reap them of their souls");

    addAdvancement(translationBuilder, "first_glaive", "Glaives", "Your very first Glaive");
    addAdvancement(translationBuilder, "get_netherite_glaive", "Reaching with Debris", "Obtain the imposing Netherite Glaive");

    addAdvancement(translationBuilder, "first_shield", "Shields", "Your very first Shield");
    addAdvancement(translationBuilder, "get_netherite_shield", "Protected with Debris", "Obtain the unyielding Netherite Shield");
    addAdvancement(translationBuilder, "get_ender_shield", "Warped Protection", "Obtain the teleporting Ender Shield");

    addAdvancement(translationBuilder, "creep_a_block", "Creep-A-Block", "Use a Creeper Ball on Soul Sand to create a Creep Block");
    addAdvancement(translationBuilder, "till_creep", "Till Creep Blocks", "Use a Glaive on Creep Blocks to till them and start your biomass farm");

    addAdvancement(translationBuilder, "soul_harvesting", "Soul Harvesting", "Claim the essence of your first fallen foe");

    // Trim Material
    translationBuilder.add("trim_material.big_swords.livingmetal", "Livingmetal Material");

    // Enchantments
    translationBuilder.add("enchantment.big_swords.soul_stealer", "Soul Stealer");

    // Attributes
    translationBuilder.add("attribute.name.charged_damage", "Charged Damage");

    // Resourcepacks
    translationBuilder.add(BSClient.RP_16x_NAME, "Big Swords R 16x");
    translationBuilder.add(BSClient.RP_16x_DESC, "16x textures for Big Swords");
    translationBuilder.add(BSClient.RP_old_NAME, "Big Swords R Old");
    translationBuilder.add(BSClient.RP_old_DESC, "The classic look of Big Swords");
  }

  // Methods
  public void addAdvancement(TranslationBuilder translationBuilder, String advancementName, String title, String description) {
    translationBuilder.add("advancements." + MODID + "." + advancementName + ".title", title);
    translationBuilder.add("advancements." + MODID + "." + advancementName + ".description", description);
  }

  public void addShield(TranslationBuilder translationBuilder, Pair<Holder<Item>, ResourceKey<Item>> item, Pair<Holder<Item>, ResourceKey<Item>> gildedItem, String name,
                        ToolMaterial material, String basePerkLabel, String basePerkDesc, String baseWeaknessLabel, String baseWeaknessDesc) {
    translationBuilder.add(item.getFirst().value(), name);
    translationBuilder.add(gildedItem.getFirst().value(), "Gilded " + name);

    String materialKey = BSToolMaterial.getIdFromMaterial(material);
    translationBuilder.add("tooltip.big_swords." + materialKey + ".perk", basePerkLabel);
    translationBuilder.add("tooltip.big_swords." + materialKey + ".weakness", baseWeaknessLabel);

    // Shift description
    translationBuilder.add("tooltip.big_swords." + materialKey + ".perk.description", basePerkDesc);
    translationBuilder.add("tooltip.big_swords." + materialKey + ".weakness.description", baseWeaknessDesc);
  }
}
