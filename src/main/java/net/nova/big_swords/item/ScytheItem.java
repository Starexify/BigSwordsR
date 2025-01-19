package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Sounds;

import java.util.List;
import java.util.Random;

import static net.nova.big_swords.BigSwordsR.playSound;

public class ScytheItem extends HoeItem {
    public final float minDamage;
    public final float maxDamage;
    public final Random random = new Random();

    public ScytheItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minDamage, float maxDamage, Properties properties) {
        super(toolMaterial, attackDamage, attackSpeed, properties);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.literal("Special:").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.literal(" " + this.minDamage + " - " + this.maxDamage + " Charged Damage").withStyle(ChatFormatting.DARK_GREEN));
        pTooltipComponents.add(Component.empty());
    }

    // Scythe Mechanic
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        player.startUsingItem(usedHand);
        return InteractionResult.CONSUME;
    }

    public float radius = 1.5f;  // Radius of the half-circle
    public float width = 3.0f;   // Width of the attack area
    public float height = 3.0f;  // Height of the attack area
    public float depth = 3.0f;   // Depth of the attack area
    public float distance = 0.5f; // Distance in front of the player

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack, entity) - timeLeft;
            if (i < 20) return false; // Require a minimum charge time

            if (level instanceof ServerLevel serverLevel) {
                Vec3 lookVec = player.getLookAngle();
                Vec3 playerPos = player.position().add(0, player.getEyeHeight(), 0);
                Vec3 attackCenter = playerPos.add(lookVec.scale(distance + depth / 2));
                AABB boundingBox = new AABB(
                        attackCenter.x - width / 2, attackCenter.y - height / 2, attackCenter.z - width / 2,
                        attackCenter.x + width / 2, attackCenter.y + height / 2, attackCenter.z + width / 2
                );

                List<LivingEntity> entities = serverLevel.getEntitiesOfClass(LivingEntity.class, boundingBox, e -> e != player && e.isPickable());
                int entitiesHit = 0;

                for (LivingEntity target : entities) {
                    Vec3 targetPos = target.position().add(0, target.getBbHeight() / 2, 0);
                    Vec3 toTarget = targetPos.subtract(playerPos);

                    // Check if the entity is within the half-circle area
                    if (isInAttackArea(toTarget, lookVec)) {
                        BlockHitResult blockHit = level.clip(new ClipContext(playerPos, targetPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

                        if (blockHit.getType() == HitResult.Type.MISS) {
                            scytheHits(serverLevel, player, target);
                            EnchantedItemInUse enchantedItemInUse = new EnchantedItemInUse(stack, player.getEquipmentSlotForItem(stack), player);
                            EnchantmentHelper.runIterationOnItem(stack, (enchantmentHolder, enchantmentLevel) -> {
                                if (enchantmentHolder.value().effects().get(BSDataComponents.POST_DEATH.get()) != null) {
                                    enchantmentHolder.value().effects().get(BSDataComponents.POST_DEATH.get()).forEach(targetedEffect ->
                                            targetedEffect.effect().apply(serverLevel, enchantmentLevel, enchantedItemInUse, target, target.position())
                                    );
                                }
                            });
                            entitiesHit++;
                        }
                    }
                }

                if (entitiesHit > 0) {
                    int durabilityDamage = entitiesHit * 2;
                    stack.hurtAndBreak(durabilityDamage, player, EquipmentSlot.MAINHAND);
                    player.getCooldowns().addCooldown(stack, 40);
                } else {
                    player.getCooldowns().addCooldown(stack, 10);
                }
                player.swing(InteractionHand.MAIN_HAND, true);
                if (stack.is(BSItems.SOUL_REAPER)) playSound(level, player, Sounds.REAPER_SLASH.get());
                else playSound(level, player, Sounds.SCYTHE_SLASH.get());
            }
        }
        return false;
    }

    public boolean isInAttackArea(Vec3 toTarget, Vec3 lookVec) {
        // Create a coordinate system based on the look vector
        Vec3 up = new Vec3(0, 1, 0);
        Vec3 right = lookVec.cross(up).normalize();
        Vec3 adjustedUp = right.cross(lookVec).normalize();

        // Project the toTarget vector onto this coordinate system
        double forwardProject = toTarget.dot(lookVec);
        double rightProject = toTarget.dot(right);
        double upProject = toTarget.dot(adjustedUp);

        // Check if the entity is within the half-circle area
        boolean inRadius = Math.sqrt(rightProject * rightProject + upProject * upProject) <= radius;
        boolean inFront = forwardProject >= distance && forwardProject <= distance + depth;
        boolean inHeight = Math.abs(upProject) <= height / 2;

        return inRadius && inFront && inHeight;
    }

    public void scytheHits(ServerLevel serverLevel, Player player, LivingEntity target) {
        float damage = minDamage + random.nextFloat() * (maxDamage - minDamage);
        damage = Math.round(damage * 10.0f) / 10.0f;
        target.hurtServer(serverLevel, player.damageSources().playerAttack(player), damage);
    }

    // Bow-like Item Stuff
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack p_40678_) {
        return ItemUseAnimation.BOW;
    }

    // Sword-like Item Stuff
    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }
}
