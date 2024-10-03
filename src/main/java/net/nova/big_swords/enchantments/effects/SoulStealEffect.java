package net.nova.big_swords.enchantments.effects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

public record SoulStealEffect(int duration) implements EnchantmentEntityEffect {
    public static final MapCodec<SoulStealEffect> CODEC = RecordCodecBuilder.mapCodec(
            inst -> inst.group(Codec.INT.fieldOf("duration").forGetter(p_345622_ -> p_345622_.duration)).apply(inst, SoulStealEffect::new)
    );

    @Override
    public void apply(ServerLevel level, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity entity, Vec3 pOrigin) {
        if (entity instanceof LivingEntity livingEntity && !livingEntity.getType().is(Tags.EntityTypeTags.SOULLESS) && (livingEntity.isDeadOrDying()) && pItem.itemStack().is(Tags.BSItemTags.SCYTHES)) {
            double dropChance = switch (pEnchantmentLevel) {
                case 1 -> 0.3;
                case 2 -> 0.6;
                case 3 -> 0.9;
                default -> 0.0;
            };

            if (level.getRandom().nextDouble() < dropChance) {
                ItemStack soulItem = new ItemStack(BSItems.SOUL.get());
                livingEntity.spawnAtLocation(soulItem);

                // Spawn soul particles
                level.sendParticles(ParticleTypes.SOUL, pOrigin.x, pOrigin.y, pOrigin.z, 20, 0.5, 0.5, 0.5, 0.05);
                BigSwordsR.playSound(level, livingEntity, SoundEvents.SOUL_ESCAPE.value());
            }
        }
    }

    @Override
    public MapCodec<SoulStealEffect> codec() {
        return CODEC;
    }
}
