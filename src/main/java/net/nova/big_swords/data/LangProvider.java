package net.nova.big_swords.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.nova.big_swords.event.BigSwordsRClient;
import net.nova.big_swords.init.*;
import net.nova.big_swords.item.EnderSmithingTemplate;

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
        addItem(BSItems.BIOMASS_SEED, "Biomass Seed");
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

        // Big Swords
        addItem(BSItems.WOODEN_BIG_SWORD, "Wooden Big Sword");
        addItem(BSItems.STONE_BIG_SWORD, "Stone Big Sword");
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
        addItem(BSItems.IRON_GLAIVE, "Iron Glaive");
        addItem(BSItems.GOLDEN_GLAIVE, "Golden Glaive");
        addItem(BSItems.DIAMOND_GLAIVE, "Diamond Glaive");
        addItem(BSItems.NETHERITE_GLAIVE, "Netherite Glaive");
        addItem(BSItems.BIOMASS_GLAIVE, "Biomass Glaive");
        addItem(BSItems.LIVINGMETAL_GLAIVE, "Livingmetal Glaive");

        // Scythes
        addItem(BSItems.WOODEN_SCYTHE, "Wooden Scythe");
        addItem(BSItems.STONE_SCYTHE, "Stone Scythe");
        addItem(BSItems.IRON_SCYTHE, "Iron Scythe");
        addItem(BSItems.GOLDEN_SCYTHE, "Golden Scythe");
        addItem(BSItems.DIAMOND_SCYTHE, "Diamond Scythe");
        addItem(BSItems.NETHERITE_SCYTHE, "Netherite Scythe");
        addItem(BSItems.BIOMASS_SCYTHE, "Biomass Scythe");
        addItem(BSItems.LIVINGMETAL_SCYTHE, "Livingmetal Scythe");
        addItem(BSItems.BONE_SCYTHE, "Bone Scythe");
        addItem(BSItems.SOUL_REAPER, "Soul Reaper");

        // Shields
        addShield(BSItems.WOODEN_SHIELD, "Wooden Shield", "Special Perk: Arrow Catch", "Weakness: Flammable");
        addShield(BSItems.GILDED_WOODEN_SHIELD, "Gilded Wooden Shield", "Special Perk: Arrow Catch", "Weakness: Flammable");
        addShield(BSItems.STONE_SHIELD, "Stone Shield", "Special Perk: Fire Resistant", "Weakness: Shattered Defense");
        addShield(BSItems.GILDED_STONE_SHIELD, "Gilded Stone Shield", "Special Perk: Fire Resistant", "Weakness: Shattered Defense");
        addShield(BSItems.IRON_SHIELD, "Iron Shield", "Special Perk: Explosive Resistant", "Weakness: Rusting");
        addShield(BSItems.GILDED_IRON_SHIELD, "Gilded Iron Shield", "Special Perk: Explosive Resistant", "Weakness: Rusting");
        addShield(BSItems.DIAMOND_SHIELD, "Diamond Shield", "Special Perk: Counter Reflect", "Weakness: Reflective Impact");
        addShield(BSItems.GILDED_DIAMOND_SHIELD, "Gilded Diamond Shield", "Special Perk: Counter Reflect", "Weakness: Reflective Impact");
        addShield(BSItems.NETHERITE_SHIELD, "Netherite Shield", "Special Perk: Reflecting Guard", "Weakness: Reflecting Pause");
        addShield(BSItems.GILDED_NETHERITE_SHIELD, "Gilded Netherite Shield", "Special Perk: Reflecting Guard", "Weakness: Reflecting Pause");
        addShield(BSItems.ENDER_SHIELD, "Ender Shield", "Special Perk: Teleport Displace", "Weakness: Ender Damage");
        addShield(BSItems.GILDED_ENDER_SHIELD, "Gilded Ender Shield", "Special Perk: Teleport Displace", "Weakness: Ender Damage");
        addShield(BSItems.QUARTZ_SHIELD, "Quartz Shield", "Special Perk: Quartz Barrier", "Weakness: Hunger Toll");
        addShield(BSItems.GILDED_QUARTZ_SHIELD, "Gilded Quartz Shield", "Special Perk: Quartz Barrier", "Weakness: Hunger Toll");
        addShield(BSItems.PATCHWORK_SHIELD, "Patchwork Shield", "Special Perk: Necrotic Weaken", "Weakness: Rotten Defense");
        addShield(BSItems.GILDED_PATCHWORK_SHIELD, "Gilded Patchwork Shield", "Special Perk: Necrotic Weaken", "Weakness: Rotten Defense");
        addShield(BSItems.SKULL_SHIELD, "Skull Shield", "Special Perk: Fear", "Weakness: Brittle Bones");
        addShield(BSItems.GILDED_SKULL_SHIELD, "Gilded Skull Shield", "Special Perk: Fear", "Weakness: Brittle Bones");
        addShield(BSItems.BIOMASS_SHIELD, "Biomass Shield", "Special Perk: Vitality Transfer", "Weakness: Life Leech");
        addShield(BSItems.GILDED_BIOMASS_SHIELD, "Gilded Biomass Shield", "Special Perk: Vitality Transfer", "Weakness: Life Leech");
        addShield(BSItems.LIVINGMETAL_SHIELD, "Livingmetal Shield", "Special Perk: Experience Infusion", "Weakness: Experience Drain");
        addShield(BSItems.GILDED_LIVINGMETAL_SHIELD, "Gilded Livingmetal Shield", "Special Perk: Experience Infusion", "Weakness: Experience Drain");

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
        addAdvancement("root", "The root of Big Swords R", "");
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
        add(BigSwordsRClient.RP_16x_NAME, "Big Swords R 16x");
        add(BigSwordsRClient.RP_16x_DESC, "16x textures for Big Swords");
        add(BigSwordsRClient.RP_old_NAME, "Big Swords R Old");
        add(BigSwordsRClient.RP_old_DESC, "The classic look of Big Swords");

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

    public void addShield(Supplier<? extends Item> key, String name, String perk, String weakness) {
        add(key.get(), name);
        add(key.get() + ".perk", perk);
        add(key.get() + ".weakness", weakness);
    }
}
