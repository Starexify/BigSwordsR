package net.nova.big_swords.enchantments;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

public class SoulStealer extends Enchantment {
    public SoulStealer(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pEnchantmentLevel) {
        if (!pAttacker.level().isClientSide()) {
            ServerLevel level = ((ServerLevel) pAttacker.level());
            ItemStack attackerItem = pAttacker.getItemInHand(InteractionHand.MAIN_HAND);

            if (pTarget instanceof LivingEntity livingEntity && !livingEntity.getType().is(Tags.EntityTypeTags.SOULLESS) && (livingEntity.isDeadOrDying()) && attackerItem.is(Tags.BSItemTags.SCYTHES)) {
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
                    level.sendParticles(ParticleTypes.SOUL, pTarget.getX(), pTarget.getY(), pTarget.getZ(), 20, 0.5, 0.5, 0.5, 0.05);
                    BigSwordsR.playSound(level, livingEntity, SoundEvents.SOUL_ESCAPE);
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pEnchantmentLevel);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
