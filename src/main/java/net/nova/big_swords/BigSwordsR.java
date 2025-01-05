package net.nova.big_swords;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.nova.big_swords.init.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class BigSwordsR implements ModInitializer {
    public static final String MODID = "big_swords";
    public static final Logger LOGGER = LoggerFactory.getLogger(BigSwordsR.class);

    @Override
    public void onInitialize() {
        CreativeTab.initialize();
        BSDataComponentTypes.initialize();
        BSItems.initialize();
        BSBlocks.initialize();
        Sounds.initialize();
        BSEnchantmentEffects.initialize();

        ShieldMechanics.register();

        // Fuels
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(BSItems.GIANT_WOODEN_STICK, 700);
            builder.add(BSItems.GIANT_BLAZE_ROD, 16800);
            builder.add(BSItems.WOODEN_BIG_SWORD, 200);
            builder.add(BSItems.WOODEN_SCYTHE, 200);
            builder.add(BSItems.WOODEN_GLAIVE, 200);
        });

        // Loot Table Modifier
        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && LootTables.END_CITY_TREASURE_CHEST.equals(registryKey)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE));
                builder.pool(poolBuilder);
            }
        });


        // Halloween Stuff
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
            if (entity.getType().isIn(Tags.EntityTypeTags.HALLOWEEN_MOB) && entity instanceof MobEntity mob)
                halloweenDrop(mob, serverWorld, new ItemStack(BSItems.SOUL_REAPER));
        });
    }

    public static void halloweenDrop(MobEntity entity, World world, ItemStack stack) {
        LocalDate localDate = LocalDate.now();
        Random random = world.getRandom();
        int i = localDate.get(ChronoField.DAY_OF_MONTH);
        int j = localDate.get(ChronoField.MONTH_OF_YEAR);
        if (j == 10 && i == 31 && random.nextFloat() < 0.25F) {
            entity.equipStack(EquipmentSlot.MAINHAND, stack);
            entity.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.05F);
        }
    }

    public static RegistryEntry<Enchantment> getEnchantment(World level, RegistryKey<Enchantment> enchantment) {
        return level.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(enchantment);
    }

    public static void playSound(World level, PlayerEntity player, SoundEvent sound) {
        if (!player.getWorld().isClient) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }

    public static void playSound(World level, LivingEntity livingEntity, SoundEvent sound) {
        if (!livingEntity.getWorld().isClient) {
            level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), sound, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }

    public static Identifier rl(String path) {
        return Identifier.of(MODID, path);
    }
}