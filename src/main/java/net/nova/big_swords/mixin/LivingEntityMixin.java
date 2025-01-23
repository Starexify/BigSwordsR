package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSItems;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow
    public abstract @Nullable ItemStack getBlockingItem();

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

/*    @WrapWithCondition(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/component/type/BlocksAttacksComponent;onShieldHit(Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/util/Hand;F)V"))
    private boolean preventShieldDamage(BlocksAttacksComponent instance, World world, ItemStack stack, LivingEntity entity, Hand hand, float itemDamage, @Local(argsOnly = true) DamageSource source) {
        Entity attacker = source.getAttacker();
        Entity entitySource = source.getSource();

        if (stack != null) {
            boolean isStoneShield = stack.isOf(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = stack.isOf(BSItems.GILDED_STONE_SHIELD);
            if ((isStoneShield || isGildedStoneShield)) {
                if (attacker instanceof LivingEntity livingAttacker) {
                    ItemStack attackerWeapon = livingAttacker.getWeaponStack();
                    int fireAspectLevel = attackerWeapon.getEnchantments().getLevel(BigSwordsR.getEnchantment(world, Enchantments.FIRE_ASPECT));
                    if (fireAspectLevel > 0) {
                        return false;
                    }
                }
                if (entitySource instanceof FireballEntity || (entitySource instanceof ProjectileEntity projectile && projectile.isOnFire())) {
                    return false;
                }
            }
        }
        return true;
    }*/

    @ModifyReturnValue(method = "blockedByShield", at = @At("RETURN"))
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
    }
}
