package net.nova;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.nova.init.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        BSEnchantmentEntityEffects.initialize();

        // Fuels
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(BSItems.GIANT_WOODEN_STICK, 700);
            builder.add(BSItems.GIANT_BLAZE_ROD, 16800);
            builder.add(BSItems.WOODEN_BIG_SWORD, 200);
            builder.add(BSItems.WOODEN_SCYTHE, 200);
            builder.add(BSItems.WOODEN_GLAIVE, 200);
        });
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