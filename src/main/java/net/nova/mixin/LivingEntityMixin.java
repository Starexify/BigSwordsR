package net.nova.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nova.BigSwordsR;
import net.nova.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapWithCondition(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damageShield(F)V"))
    private boolean preventShieldDamage(LivingEntity instance, float amount, @Local(argsOnly = true) DamageSource source) {
        ItemStack itemStack = instance.getBlockingItem();
        Entity attacker = source.getAttacker();
        Entity entity = source.getSource();

        if (itemStack != null) {
            boolean isStoneShield = itemStack.isOf(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = itemStack.isOf(BSItems.GILDED_STONE_SHIELD);
            if ((isStoneShield || isGildedStoneShield)) {
                if (attacker instanceof LivingEntity livingAttacker) {
                    ItemStack attackerWeapon = livingAttacker.getWeaponStack();
                    int fireAspectLevel = attackerWeapon.getEnchantments().getLevel(BigSwordsR.getEnchantment(this.getWorld(), Enchantments.FIRE_ASPECT));
                    if (fireAspectLevel > 0) {
                        return false;
                    }
                }
                if (entity instanceof FireballEntity || (entity instanceof ProjectileEntity projectile && projectile.isOnFire())) {
                    return false;
                }
            }
        }
        return true;
    }

    /*    @ModifyReturnValue(method = "blockedByShield", at = @At("RETURN"))
    private boolean preventShieldDamage(boolean original, DamageSource source) {
        ItemStack itemStack = this.getBlockingItem();
        Entity attacker = source.getAttacker();
        Entity sourceEntity = source.getSource();
        if (itemStack != null) {
            boolean isStoneShield = itemStack.isOf(BSItems.STONE_SHIELD);
            boolean isGildedStoneShield = itemStack.isOf(BSItems.GILDED_STONE_SHIELD);
            if ((isStoneShield || isGildedStoneShield)) {
                if (attacker instanceof LivingEntity livingAttacker) {
                    ItemStack attackerWeapon = livingAttacker.getWeaponStack();
                    int fireAspectLevel = attackerWeapon.getEnchantments().getLevel(BigSwordsR.getEnchantment(level, Enchantments.FIRE_ASPECT));
                    if (fireAspectLevel > 0) {
                        return true;
                    }
                }
                return true;
            }
        }
        return original;
    }*/
}
