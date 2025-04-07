package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.nova.big_swords.init.BSItems;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow
    @Nullable
    public abstract ItemStack getItemBlockingWith();

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @WrapWithCondition(method = "applyItemBlocking", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/component/BlocksAttacks;hurtBlockingItem(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;F)V"))
    private boolean preventShieldDamage(BlocksAttacks instance, Level level, ItemStack stack, LivingEntity livingEntity, InteractionHand interactionHand, float f, @Local(argsOnly = true) DamageSource source) {
        Entity attacker = source.getEntity();
        Entity entitySource = source.getDirectEntity();

        if (stack != null) {
            // Stone Shields Perk
            boolean isStoneShield = stack.is(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = stack.is(BSItems.GILDED_STONE_SHIELD);
            if ((isStoneShield || isGildedStoneShield)) {
                if (attacker instanceof LivingEntity livingAttacker) {
                    int fireAspectLevel = livingAttacker.getWeaponItem().getEnchantments().getLevel(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT));
                    int soulFireAspectLevel = level.registryAccess()
                            .lookupOrThrow(Registries.ENCHANTMENT)
                            .get(ResourceLocation.withDefaultNamespace("soul_fire_aspect"))
                            .map(enchantment -> livingEntity.getWeaponItem().getEnchantments().getLevel(enchantment))
                            .orElse(0);
                    if (fireAspectLevel > 0 || soulFireAspectLevel > 0) return false;
                }
                if (entitySource instanceof Fireball || (entitySource instanceof Projectile projectile && projectile.isOnFire()))
                    return false;
            }
        }
        return true;
    }

    @ModifyArg(method = "hurtServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;applyItemBlocking(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)F"), index = 2)
    private float bypassShield(float original, @Local(argsOnly = true) DamageSource source) {
        ItemStack stack = getItemBlockingWith();
        Entity attacker = source.getEntity();
        double randomChanceE = Math.random();

        if (stack != null) {
            // Patchwork Shields Weakness
            boolean isPatchworkShield = stack.is(BSItems.PATCHWORK_SHIELD);
            boolean isGildedPatchworkShield = stack.is(BSItems.GILDED_PATCHWORK_SHIELD);
            if ((isPatchworkShield || isGildedPatchworkShield)) {
                float weaknessChance = isGildedPatchworkShield ? 0.25f : 0.5f;
                if (randomChanceE < weaknessChance) return 0.0f;
            }

            // Ender Shields Weakness
            boolean isEnderShield = stack.is(BSItems.ENDER_SHIELD);
            boolean isGildedEnderShield = stack.is(BSItems.GILDED_ENDER_SHIELD);
            if ((isEnderShield || isGildedEnderShield)) {
                if (attacker instanceof EnderMan || attacker instanceof EnderDragon || attacker instanceof Endermite)
                    return 0.0f;
            }
        }
        return original;
    }
}
