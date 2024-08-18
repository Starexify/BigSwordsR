package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Sounds;

import java.util.List;
import java.util.Random;

import static net.nova.big_swords.BigSwordsR.playSound;

public class ScytheItem extends HoeItem {
    private final float minDamage;
    private final float maxDamage;
    private final Random random = new Random();

    public ScytheItem(Tier pTier, Item.Properties pProperties, float minDamage, float maxDamage) {
        super(pTier, pProperties.component(DataComponents.TOOL, createToolProperties()));
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.literal("Special:").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.literal(" " + this.minDamage + " - " + this.maxDamage + " Charged Damage").withStyle(ChatFormatting.DARK_GREEN));
    }

    // Scythe Mechanic
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    public float radius = 1.5f;  // Radius of the half-circle
    public float width = 3.0f;   // Width of the attack area
    public float height = 3.0f;  // Height of the attack area
    public float depth = 3.0f;   // Depth of the attack area
    public float distance = 0.5f; // Distance in front of the player

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack, entity) - timeLeft;
            if (i < 20) return; // Require a minimum charge time

            if (!level.isClientSide) {
                Vec3 lookVec = player.getLookAngle();
                Vec3 playerPos = player.position().add(0, player.getEyeHeight(), 0);
                Vec3 attackCenter = playerPos.add(lookVec.scale(distance + depth / 2));
                AABB boundingBox = new AABB(
                        attackCenter.x - width/2, attackCenter.y - height/2, attackCenter.z - width/2,
                        attackCenter.x + width/2, attackCenter.y + height/2, attackCenter.z + width/2
                );

                List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, boundingBox,
                        e -> e != player && e.isPickable());

                player.swing(InteractionHand.MAIN_HAND, true);
                int entitiesHit = 0;
                for (LivingEntity target : entities) {
                    Vec3 targetPos = target.position().add(0, target.getBbHeight() / 2, 0);
                    Vec3 toTarget = targetPos.subtract(playerPos);

                    // Check if the entity is within the half-circle area
                    if (isInAttackArea(toTarget, lookVec)) {
                        BlockHitResult blockHit = level.clip(new ClipContext(playerPos, targetPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

                        if (blockHit.getType() == HitResult.Type.MISS) {
                            scytheHits(player, target);
                            entitiesHit++;
                        }
                    }
                }

                if (entitiesHit > 0) {
                    int durabilityDamage = entitiesHit * 2;
                    stack.hurtAndBreak(durabilityDamage, player, EquipmentSlot.MAINHAND);
                    player.getCooldowns().addCooldown(this, 40);

                    // player.sendSystemMessage(Component.literal("Hit entities with dmg: " + entitiesHit)); // Debug output
                    // player.sendSystemMessage(Component.literal("Damage dealt to Item: " + durabilityDamage)); // Debug output
                } else {
                    player.getCooldowns().addCooldown(this, 10);
                }

                if (stack.is(BSItems.SOUL_REAPER)) {
                    playSound(level, player, Sounds.REAPER_SLASH.get());
                } else {
                    playSound(level, player, Sounds.SCYTHE_SLASH.get());
                }
            }
        }
    }

    private boolean isInAttackArea(Vec3 toTarget, Vec3 lookVec) {
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

    public void scytheHits(Player player, LivingEntity target) {
        float damage = minDamage + random.nextFloat() * (maxDamage - minDamage);
        damage = Math.round(damage * 10.0f) / 10.0f;
        target.hurt(player.damageSources().playerAttack(player), damage);
    }

    @Override
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    // Sword-like Item Stuff
    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(Tier pTier, int pAttackDamage, float pAttackSpeed) {
        return createAttributes(pTier, (float) pAttackDamage, pAttackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                BASE_ATTACK_DAMAGE_ID, (double) ((float) p_331976_ + p_330371_.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, (double) p_332104_, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }
}
