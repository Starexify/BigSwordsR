package net.nova.big_swords.enchantments.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.nova.big_swords.init.Tags;

public record SoulStealEffect(LevelBasedValue dropChance, ItemStack droppedItem) implements EnchantmentEntityEffect {
    public static final MapCodec<SoulStealEffect> CODEC = RecordCodecBuilder.mapCodec(builder -> builder.group(
            LevelBasedValue.CODEC.fieldOf("dropChance").forGetter(SoulStealEffect::dropChance),
            ItemStack.CODEC.fieldOf("droppedItem").forGetter(SoulStealEffect::droppedItem)
    ).apply(builder, SoulStealEffect::new));

    @Override
    public void apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if (entity instanceof LivingEntity livingEntity && !livingEntity.getType().is(Tags.EntityTypeTags.SOULLESS) && livingEntity.isDeadOrDying()) {
            double dropChance = this.dropChance.calculate(enchantmentLevel);
            if (serverLevel.getRandom().nextDouble() < dropChance) {
                livingEntity.spawnAtLocation(serverLevel, this.droppedItem.copy());
                serverLevel.sendParticles(ParticleTypes.SOUL, origin.x, origin.y, origin.z, 20, 0.5, 0.5, 0.5, 0.05);
                serverLevel.playSound(null, origin.x(), origin.y(), origin.z(), SoundEvents.SOUL_ESCAPE, entity.getSoundSource(), 1, 1);
            }
        }
    }

    @Override
    public MapCodec<SoulStealEffect> codec() {
        return CODEC;
    }

    public LevelBasedValue dropChance() {
        return this.dropChance;
    }

    public ItemStack droppedItem() {
        return this.droppedItem;
    }
}
