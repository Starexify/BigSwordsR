package net.nova.big_swords;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.nova.big_swords.init.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

public class BigSwordsR implements ModInitializer {
    public static final String MODID = "big_swords";
    public static final Logger LOGGER = LoggerFactory.getLogger(BigSwordsR.class);

    @Override
    public void onInitialize() {
        Sounds.initialize();
        BSAttributes.initialize();
        BSDataComponents.initialize();
        BSEnchantmentEffects.initialize();
        BSBlocks.initialize();
        BSItems.initialize();
        CreativeTab.initialize();

        ShieldMechanics.register();

        // Loot Table Modifier
        LootTableEvents.MODIFY.register((resourceKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && BuiltInLootTables.END_CITY_TREASURE.equals(resourceKey)) {
                LootTable.Builder poolBuilder = LootTable.lootTable()
                        .apply(LootItemRandomChanceCondition.randomChance(0.35f))
                        .withPool(LootItem.lootTableItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE));
                builder.pool(poolBuilder);
            }
        });

        // Halloween Stuff
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
            if (entity.getType().is(Tags.EntityTypeTags.HALLOWEEN_MOB) && entity instanceof Mob mob)
                halloweenDrop(mob, serverWorld, new ItemStack(BSItems.SOUL_REAPER));
        });
    }

    public static void halloweenDrop(Mob entity, Level level, ItemStack stack) {
        LocalDate localDate = LocalDate.now();
        RandomSource random = level.getRandom();
        int i = localDate.get(ChronoField.DAY_OF_MONTH);
        int j = localDate.get(ChronoField.MONTH_OF_YEAR);
        if (j == 10 && i == 31 && random.nextFloat() < 0.25F) {
            entity.setItemSlot(EquipmentSlot.MAINHAND, stack);
            entity.setDropChance(EquipmentSlot.MAINHAND, 0.05F);
        }
    }

    public static int getItemEnchantmentLevel(ItemStack item, ResourceKey<Enchantment> enchantment) {
        return item.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY)
                .entrySet().stream()
                .filter(entry -> entry.getKey().equals(enchantment))
                .findAny()
                .map(entry -> entry.getIntValue())
                .orElse(0);
    }

    public static void playSound(Level level, Player player, SoundEvent sound) {
        if (!player.level().isClientSide) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }

    public static void playSound(Level level, LivingEntity livingEntity, SoundEvent sound) {
        if (!livingEntity.level().isClientSide) {
            level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static double getModifierValue(List<ItemAttributeModifiers.Entry> modifiers, ResourceLocation modifierId) {
        return modifiers.stream()
                .filter(entry -> entry.modifier().is(modifierId))
                .mapToDouble(entry -> entry.modifier().amount())
                .findFirst().orElse(0.0);
    }
}