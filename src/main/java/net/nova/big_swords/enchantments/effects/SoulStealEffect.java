package net.nova.big_swords.enchantments.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.nova.big_swords.init.Tags;

public record SoulStealEffect(EnchantmentLevelBasedValue dropChance,
                              ItemStack droppedItem) implements EnchantmentEntityEffect {
    public static final MapCodec<SoulStealEffect> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            EnchantmentLevelBasedValue.CODEC.fieldOf("dropChance").forGetter(SoulStealEffect::dropChance),
            ItemStack.CODEC.fieldOf("droppedItem").forGetter(SoulStealEffect::droppedItem)
    ).apply(inst, SoulStealEffect::new));

    @Override
    public void apply(ServerWorld serverLevel, int enchantmentLevel, EnchantmentEffectContext context, Entity entity, Vec3d pos) {
        if (entity instanceof LivingEntity livingEntity && !livingEntity.getType().isIn(Tags.EntityTypeTags.SOULLESS) && (livingEntity.isDead()) && context.stack().isIn(Tags.BSItemTags.SCYTHES)) {
            double dropChance = this.dropChance.getValue(enchantmentLevel);
            if (serverLevel.getRandom().nextDouble() < dropChance) {
                livingEntity.dropItem(serverLevel, this.droppedItem.getItem());
                serverLevel.spawnParticles(ParticleTypes.SOUL, pos.x, pos.y, pos.z, 20, 0.5, 0.5, 0.5, 0.05);
                serverLevel.playSound(null, pos.x, pos.y, pos.z, SoundEvents.PARTICLE_SOUL_ESCAPE, entity.getSoundCategory(), 1, 1);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
