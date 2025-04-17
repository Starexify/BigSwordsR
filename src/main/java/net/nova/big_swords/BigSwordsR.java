package net.nova.big_swords;

import net.fabricmc.api.ModInitializer;
import net.legacyfabric.fabric.api.util.Identifier;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.CreativeTabs;

public class BigSwordsR implements ModInitializer {
    public static final String MODID = "big_swords";

    @Override
    public void onInitialize() {
/*        Sounds.initialize();
        BSAttributes.initialize();
        BSDataComponents.initialize();
        BSEnchantmentEffects.initialize();*/
        BSItems.initialize();
//       BSBlocks.initialize();
        CreativeTabs.initialize();

        //ShieldMechanics.register();

        // Loot Table Modifier
/*        LootTableEvents.MODIFY.register((resourceKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && BuiltInLootTables.END_CITY_TREASURE.equals(resourceKey)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .when(LootItemRandomChanceCondition.randomChance(0.35f))
                        .add(LootItem.lootTableItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE));
                builder.pool(poolBuilder.build());
            }
        });*/

        // Halloween Stuff
/*        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
            if (entity.getType().is(Tags.EntityTypeTags.HALLOWEEN_MOB) && entity instanceof Mob mob)
                halloweenDrop(mob, serverWorld, new ItemStack(BSItems.SOUL_REAPER));
        });*/
    }

/*    public static void halloweenDrop(Mob entity, Level level, ItemStack stack) {
        LocalDate localDate = LocalDate.now();
        RandomSource random = level.getRandom();
        int i = localDate.get(ChronoField.DAY_OF_MONTH);
        int j = localDate.get(ChronoField.MONTH_OF_YEAR);
        if (j == 10 && i == 31 && random.nextFloat() < 0.25F) {
            entity.setItemSlot(EquipmentSlot.MAINHAND, stack);
            entity.setDropChance(EquipmentSlot.MAINHAND, 0.05F);
        }
    }*/

/*    public static void playSound(Level level, Player player, SoundEvent sound) {
        if (!player.level().isClientSide)
            level.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
    }*/

/*    public static void playSound(Level level, LivingEntity livingEntity, SoundEvent sound) {
        if (!livingEntity.level().isClientSide)
            level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
    }*/

    public static Identifier rl(String path) {
        return new Identifier(MODID, path);
    }

    public static net.minecraft.util.Identifier vanillaRl(String path) {
        return new net.minecraft.util.Identifier(MODID, path);
    }

/*    public static double getModifierValue(List<ItemAttributeModifiers.Entry> modifiers, ResourceLocation modifierId) {
        return modifiers.stream()
                .filter(entry -> entry.modifier().is(modifierId))
                .mapToDouble(entry -> entry.modifier().amount())
                .findFirst().orElse(0.0);
    }*/
}