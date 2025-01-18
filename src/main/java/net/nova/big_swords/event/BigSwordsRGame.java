package net.nova.big_swords.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.TargetedConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class BigSwordsRGame {
    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType().is(Tags.EntityTypeTags.HALLOWEEN_MOB) && entity instanceof Mob mob) {
            halloweenDrop(mob, event.getEntity().level(), new ItemStack(BSItems.SOUL_REAPER.get()));
        }
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event.getEntity().level() instanceof ServerLevel serverLevel) {
            doPostDeathAttack(serverLevel, event.getEntity(), event.getSource());
        }
    }

    public static void doPostDeathAttack(ServerLevel level, Entity entity, DamageSource damageSource) {
        if (damageSource.getEntity() instanceof LivingEntity livingentity) {
            doPostAttackEffectsWithItemSourceOnBreak(level, entity, damageSource, livingentity.getWeaponItem());
        } else {
            doPostAttackEffectsWithItemSourceOnBreak(level, entity, damageSource, null);
        }
    }

    public static void doPostAttackEffectsWithItemSourceOnBreak(ServerLevel level, Entity entity, DamageSource damageSource, @Nullable ItemStack itemSource) {
        if (itemSource != null) {
            if (damageSource.getEntity() instanceof LivingEntity livingentity) {
                EnchantmentHelper.runIterationOnItem(itemSource, EquipmentSlot.MAINHAND, livingentity,
                        (enchantmentHolder, enchantmentLevel, enchantediteminuse) -> {
                            List<TargetedConditionalEffect<EnchantmentEntityEffect>> effects = enchantmentHolder.value().effects().getOrDefault(BSDataComponents.POST_DEATH.get(), List.of());
                            for (TargetedConditionalEffect<EnchantmentEntityEffect> effect : effects) {
                                if (effect instanceof TargetedConditionalEffect<EnchantmentEntityEffect> targetedEffect) {
                                    if (EnchantmentTarget.ATTACKER == targetedEffect.enchanted()) {
                                        Enchantment.doPostAttack(targetedEffect, level, enchantmentLevel, enchantediteminuse, entity, damageSource);
                                    }
                                }
                            }
                        }
                );
            }
        }
    }


    public static void halloweenDrop(Mob entity, Level level, ItemStack stack) {
        LocalDate localdate = LocalDate.now();
        RandomSource randomsource = level.getRandom();
        int i = localdate.get(ChronoField.DAY_OF_MONTH);
        int j = localdate.get(ChronoField.MONTH_OF_YEAR);
        if (j == 10 && i == 31 && randomsource.nextFloat() < 0.25F) {
            entity.setItemSlot(EquipmentSlot.MAINHAND, stack);
            entity.setDropChance(EquipmentSlot.MAINHAND, 0.05F);
        }
    }
}
