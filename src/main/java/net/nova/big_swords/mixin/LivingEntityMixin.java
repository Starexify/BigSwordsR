package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @WrapWithCondition(method = "applyItemBlocking", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/component/BlocksAttacks;hurtBlockingItem(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;F)V"))
    private boolean preventShieldDamage(BlocksAttacks instance, Level level, ItemStack stack, LivingEntity livingEntity, InteractionHand interactionHand, float f, @Local(argsOnly = true) DamageSource source) {
        Entity attacker = source.getEntity();
        Entity entitySource = source.getDirectEntity();

        if (stack != null) {
            boolean isStoneShield = stack.is(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = stack.is(BSItems.GILDED_STONE_SHIELD);
            if ((isStoneShield || isGildedStoneShield)) {
                if (attacker instanceof LivingEntity && BigSwordsR.getItemEnchantmentLevel(stack, Enchantments.FIRE_ASPECT) > 0)
                    return false;
                if (entitySource instanceof Fireball || (entitySource instanceof Projectile projectile && projectile.isOnFire()))
                    return false;
            }
        }
        return true;
    }

/*    @ModifyReturnValue(method = "blockedByShield", at = @At("RETURN"))
    private boolean preventShieldDamage(boolean original, DamageSource source) {
        ItemStack itemStack = this.getBlockingItem();
        Entity attacker = source.getAttacker();
        double randomChanceE = Math.random();

        if (itemStack != null) {
            // Patchwork Shields
            boolean isPatchworkShield = itemStack.isOf(BSItems.PATCHWORK_SHIELD);
            boolean isGildedPatchworkShield = itemStack.isOf(BSItems.GILDED_PATCHWORK_SHIELD);
            if ((isPatchworkShield || isGildedPatchworkShield)) {
                // Weakness
                float weaknessChance = isGildedPatchworkShield ? 0.25f : 0.5f;
                if (randomChanceE < weaknessChance) {
                    return false;
                }
            }

            // Ender Shields
            boolean isEnderShield = itemStack.isOf(BSItems.ENDER_SHIELD);
            boolean isGildedEnderShield = itemStack.isOf(BSItems.GILDED_ENDER_SHIELD);
            if ((isEnderShield || isGildedEnderShield)) {
                // Weakness
                if (attacker instanceof EndermanEntity || attacker instanceof EnderDragonEntity || attacker instanceof EndermiteEntity) {
                    return false;
                }
            }
        }
        return original;
    }*/
}
