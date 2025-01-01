package net.nova.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.nova.init.BSBlocks;
import net.nova.init.BSItems;
import net.nova.init.CreativeTab;
import net.nova.init.Sounds;
import net.nova.item.EnderSmithingTemplate;

import java.util.concurrent.CompletableFuture;

public class LangProvider extends FabricLanguageProvider {
    public LangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // Items
        translationBuilder.add(BSItems.GIANT_WOODEN_STICK, "Giant Wooden Stick");
        translationBuilder.add(BSItems.GIANT_BLAZE_ROD, "Giant Blaze Rod");
        translationBuilder.add(BSItems.GIANT_LIVINGMETAL_HANDLE, "Giant Livingmetal Handle");

        // Extra Stuff
        translationBuilder.add(BSBlocks.CREEP_BLOCK, "Creep Block");
        translationBuilder.add(BSItems.CREEP_BALL, "Creep Ball");
        translationBuilder.add(BSItems.BIOMASS_SEED, "Biomass Seed");
        translationBuilder.add(BSItems.SOUL, "Soul");
        translationBuilder.add(BSItems.BLOOD_VIAL, "Blood Vial");

        // Livingmetal Lang
        translationBuilder.add(BSItems.LIVINGMETAL_INGOT, "Livingmetal Ingot");
        translationBuilder.add(BSBlocks.LIVINGMETAL_BLOCK, "Livingmetal Block");
        translationBuilder.add(BSItems.LIVINGMETAL_HELMET, "Livingmetal Helmet");
        translationBuilder.add(BSItems.LIVINGMETAL_CHESTPLATE, "Livingmetal Chestplate");
        translationBuilder.add(BSItems.LIVINGMETAL_LEGGINGS, "Livingmetal Leggings");
        translationBuilder.add(BSItems.LIVINGMETAL_BOOTS, "Livingmetal Boots");
        translationBuilder.add(BSItems.LIVINGMETAL_SWORD, "Livingmetal Sword");
        translationBuilder.add(BSItems.LIVINGMETAL_PICKAXE, "Livingmetal Pickaxe");
        translationBuilder.add(BSItems.LIVINGMETAL_AXE, "Livingmetal Axe");
        translationBuilder.add(BSItems.LIVINGMETAL_SHOVEL, "Livingmetal Shovel");
        translationBuilder.add(BSItems.LIVINGMETAL_HOE, "Livingmetal Hoe");

        // Biomass Lang
        translationBuilder.add(BSItems.BIOMASS, "Biomass");
        translationBuilder.add(BSBlocks.BIOMASS_BLOCK, "Biomass Block");
        translationBuilder.add(BSItems.BIOMASS_HELMET, "Biomass Helmet");
        translationBuilder.add(BSItems.BIOMASS_CHESTPLATE, "Biomass Chestplate");
        translationBuilder.add(BSItems.BIOMASS_LEGGINGS, "Biomass Leggings");
        translationBuilder.add(BSItems.BIOMASS_BOOTS, "Biomass Boots");
        translationBuilder.add(BSItems.BIOMASS_SWORD, "Biomass Sword");
        translationBuilder.add(BSItems.BIOMASS_PICKAXE, "Biomass Pickaxe");
        translationBuilder.add(BSItems.BIOMASS_AXE, "Biomass Axe");
        translationBuilder.add(BSItems.BIOMASS_SHOVEL, "Biomass Shovel");
        translationBuilder.add(BSItems.BIOMASS_HOE, "Biomass Hoe");

        // Big Swords
        translationBuilder.add(BSItems.WOODEN_BIG_SWORD, "Wooden Big Sword");
        translationBuilder.add(BSItems.STONE_BIG_SWORD, "Stone Big Sword");
        translationBuilder.add(BSItems.IRON_BIG_SWORD, "Iron Big Sword");
        translationBuilder.add(BSItems.GOLDEN_BIG_SWORD, "Golden Big Sword");
        translationBuilder.add(BSItems.DIAMOND_BIG_SWORD, "Diamond Big Sword");
        translationBuilder.add(BSItems.NETHERITE_BIG_SWORD, "Netherite Big Sword");
        translationBuilder.add(BSItems.PATCHWORK_BIG_SWORD, "Patchwork Big Sword");
        translationBuilder.add(BSItems.SKULL_BIG_SWORD, "Skull Big Sword");
        translationBuilder.add(BSItems.QUARTZ_BIG_SWORD, "Quartz Big Sword");
        translationBuilder.add(BSItems.OBSIDIAN_BIG_SWORD, "Obsidian Big Sword");
        translationBuilder.add(BSItems.ENDER_BIG_SWORD, "Ender Big Sword");
        translationBuilder.add(BSItems.LIVINGMETAL_BIG_SWORD, "Livingmetal Big Sword");
        translationBuilder.add(BSItems.BIOMASS_BIG_SWORD, "Biomass Big Sword");

        // Glaives
        translationBuilder.add(BSItems.WOODEN_GLAIVE, "Wooden Glaive");
        translationBuilder.add(BSItems.STONE_GLAIVE, "Stone Glaive");
        translationBuilder.add(BSItems.IRON_GLAIVE, "Iron Glaive");
        translationBuilder.add(BSItems.GOLDEN_GLAIVE, "Golden Glaive");
        translationBuilder.add(BSItems.DIAMOND_GLAIVE, "Diamond Glaive");
        translationBuilder.add(BSItems.NETHERITE_GLAIVE, "Netherite Glaive");
        translationBuilder.add(BSItems.BIOMASS_GLAIVE, "Biomass Glaive");
        translationBuilder.add(BSItems.LIVINGMETAL_GLAIVE, "Livingmetal Glaive");

        // Scythes
        translationBuilder.add(BSItems.WOODEN_SCYTHE, "Wooden Scythe");
        translationBuilder.add(BSItems.STONE_SCYTHE, "Stone Scythe");
        translationBuilder.add(BSItems.IRON_SCYTHE, "Iron Scythe");
        translationBuilder.add(BSItems.GOLDEN_SCYTHE, "Golden Scythe");
        translationBuilder.add(BSItems.DIAMOND_SCYTHE, "Diamond Scythe");
        translationBuilder.add(BSItems.NETHERITE_SCYTHE, "Netherite Scythe");
        translationBuilder.add(BSItems.BIOMASS_SCYTHE, "Biomass Scythe");
        translationBuilder.add(BSItems.LIVINGMETAL_SCYTHE, "Livingmetal Scythe");
        translationBuilder.add(BSItems.BONE_SCYTHE, "Bone Scythe");
        translationBuilder.add(BSItems.SOUL_REAPER, "Soul Reaper");

        // Shields
        addShield(translationBuilder, BSItems.WOODEN_SHIELD, "Wooden Shield", "Special Perk: Arrow Catch", "Weakness: Flammable");
        addShield(translationBuilder, BSItems.GILDED_WOODEN_SHIELD, "Gilded Wooden Shield", "Special Perk: Arrow Catch", "Weakness: Flammable");
        addShield(translationBuilder, BSItems.STONE_SHIELD, "Stone Shield", "Special Perk: Fire Resistant", "Weakness: Shattered Defense");
        addShield(translationBuilder, BSItems.GILDED_STONE_SHIELD, "Gilded Stone Shield", "Special Perk: Fire Resistant", "Weakness: Shattered Defense");
        addShield(translationBuilder, BSItems.IRON_SHIELD, "Gilded Iron Shield", "Special Perk: Explosive Resistant", "Weakness: Rusting");
        addShield(translationBuilder, BSItems.GILDED_IRON_SHIELD, "Gilded Iron Shield", "Special Perk: Explosive Resistant", "Weakness: Rusting");
        addShield(translationBuilder, BSItems.DIAMOND_SHIELD, "Diamond Shield", "Special Perk: Counter Reflect", "Weakness: Reflective Impact");
        addShield(translationBuilder, BSItems.GILDED_DIAMOND_SHIELD, "Gilded Diamond Shield", "Special Perk: Counter Reflect", "Weakness: Reflective Impact");
        addShield(translationBuilder, BSItems.NETHERITE_SHIELD, "Netherite Shield", "Special Perk: Reflecting Guard", "Weakness: Reflecting Pause");
        addShield(translationBuilder, BSItems.GILDED_NETHERITE_SHIELD, "Gilded Netherite Shield", "Special Perk: Reflecting Guard", "Weakness: Reflecting Pause");
        addShield(translationBuilder, BSItems.ENDER_SHIELD, "Ender Shield", "Special Perk: Teleport Displace", "Weakness: Ender Damage");
        addShield(translationBuilder, BSItems.GILDED_ENDER_SHIELD, "Gilded Ender Shield", "Special Perk: Teleport Displace", "Weakness: Ender Damage");
        addShield(translationBuilder, BSItems.QUARTZ_SHIELD, "Quartz Shield", "Special Perk: Quartz Barrier", "Weakness: Hunger Toll");
        addShield(translationBuilder, BSItems.GILDED_QUARTZ_SHIELD, "Gilded Quartz Shield", "Special Perk: Quartz Barrier", "Weakness: Hunger Toll");
        addShield(translationBuilder, BSItems.PATCHWORK_SHIELD, "Gilded Patchwork Shield", "Special Perk: Necrotic Weaken", "Weakness: Rotten Defense");
        addShield(translationBuilder, BSItems.GILDED_PATCHWORK_SHIELD, "Gilded Patchwork Shield", "Special Perk: Necrotic Weaken", "Weakness: Rotten Defense");
        addShield(translationBuilder, BSItems.SKULL_SHIELD, "Skull Shield", "Special Perk: Fear", "Weakness: Brittle Bones");
        addShield(translationBuilder, BSItems.GILDED_SKULL_SHIELD, "Gilded Skull Shield", "Special Perk: Fear", "Weakness: Brittle Bones");
        addShield(translationBuilder, BSItems.BIOMASS_SHIELD, "Biomass Shield", "Special Perk: Vitality Transfer", "Weakness: Life Leech");
        addShield(translationBuilder, BSItems.GILDED_BIOMASS_SHIELD, "Gilded Biomass Shield", "Special Perk: Vitality Transfer", "Weakness: Life Leech");
        addShield(translationBuilder, BSItems.LIVINGMETAL_SHIELD, "Livingmetal Shield", "Special Perk: Experience Infusion", "Weakness: Experience Drain");
        addShield(translationBuilder, BSItems.GILDED_LIVINGMETAL_SHIELD, "Gilded Livingmetal Shield", "Special Perk: Experience Infusion", "Weakness: Experience Drain");

        // Creative Tab
        translationBuilder.add(CreativeTab.BIG_SWORDS_TAB_TITLE, "Big Swords R");

        // Smithing Template
        translationBuilder.add(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE, "Ender Upgrade");
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
/*        addAdvancement("root", "The root of Big Swords R", "");
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

        addAdvancement("soul_harvesting", "Soul Harvesting", "Claim the essence of your first fallen foe");*/

        // Trim Material
        translationBuilder.add("trim_material.big_swords.livingmetal", "Livingmetal Material");

        // Resourcepacks
/*        add(BigSwordsRClient.RP_16x_NAME, "Big Swords R 16x");
        add(BigSwordsRClient.RP_16x_DESC, "16x textures for Big Swords");
        add(BigSwordsRClient.RP_old_NAME, "Big Swords R Old");
        add(BigSwordsRClient.RP_old_DESC, "The classic look of Big Swords");*/

        // Mod Menu
/*        add(MODID + ".modrinth", "Modrinth Link");
        add(MODID + ".curseforge", "CurseForge Link");
        add(MODID + ".wiki", "Wiki Link");*/
    }

    public void addShield(TranslationBuilder translationBuilder, Item key, String name, String perk, String weakness) {
        translationBuilder.add(key, name);
        translationBuilder.add(key + ".perk", perk);
        translationBuilder.add(key + ".weakness", weakness);
    }
}
