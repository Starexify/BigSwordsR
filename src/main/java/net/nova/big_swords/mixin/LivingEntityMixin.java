package net.nova.big_swords.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
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
