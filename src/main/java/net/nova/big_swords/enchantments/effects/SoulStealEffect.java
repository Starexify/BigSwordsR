package net.nova.big_swords.enchantments.effects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

public record SoulStealEffect(int duration) implements EnchantmentEntityEffect {
    public static final MapCodec<SoulStealEffect> CODEC = RecordCodecBuilder.mapCodec(
            inst -> inst.group(Codec.INT.fieldOf("duration").forGetter(p_345622_ -> p_345622_.duration)).apply(inst, SoulStealEffect::new)
    );

    @Override
    public void apply(ServerWorld level, int enchantmentLevel, EnchantmentEffectContext context, Entity entity, Vec3d pos) {
        if (entity instanceof LivingEntity livingEntity && !livingEntity.getType().isIn(Tags.EntityTypeTags.SOULLESS) && (livingEntity.isDead()) && context.stack().isIn(Tags.BSItemTags.SCYTHES)) {
            double dropChance = switch (enchantmentLevel) {
                case 1 -> 0.3;
                case 2 -> 0.6;
                case 3 -> 0.9;
                default -> 0.0;
            };

            if (level.getRandom().nextDouble() < dropChance) {
                livingEntity.dropItem(level, BSItems.SOUL);

                // Spawn soul particles
                level.spawnParticles(ParticleTypes.SOUL, pos.x, pos.y, pos.z, 20, 0.5, 0.5, 0.5, 0.05);
                BigSwordsR.playSound(level, livingEntity, SoundEvents.PARTICLE_SOUL_ESCAPE.value());
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
