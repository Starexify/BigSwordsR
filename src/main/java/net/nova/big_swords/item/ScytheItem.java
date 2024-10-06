package net.nova.big_swords.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.nova.big_swords.enchantments.SoulStealer;
import net.nova.big_swords.init.BSEnchantments;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Sounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

import static net.nova.big_swords.BigSwordsR.playSound;

public class ScytheItem extends HoeItem {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final float minDamage;
    private final float maxDamage;
    private final Random random = new Random();

    public ScytheItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, float minDamage, float maxDamage) {
        super(pTier, 0, pAttackSpeedModifier, pProperties);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;

        this.attackDamage = pAttackDamageModifier + pTier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.literal("Special:").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.literal(" " + this.minDamage + " - " + this.maxDamage + " Charged Damage").withStyle(ChatFormatting.DARK_GREEN));
        pTooltipComponents.add(Component.empty());
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
            int i = this.getUseDuration(stack) - timeLeft;
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

                            int soulStealerEnchantment = stack.getEnchantmentLevel(BSEnchantments.SOUL_STEALER.get());
                            if (soulStealerEnchantment >= 0) {
                                SoulStealer soulStealer = (SoulStealer) BSEnchantments.SOUL_STEALER.get();
                                soulStealer.doPostAttack(player, target, soulStealerEnchantment);
                            }
                        }
                    }
                }

                if (entitiesHit > 0) {
                    int durabilityDamage = entitiesHit * 2;
                    stack.hurtAndBreak(durabilityDamage, player, (p_289501_) -> {
                        p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                    });
                    player.getCooldowns().addCooldown(this, 40);

                    // player.sendSystemMessage(Component.literal("Hit entities with dmg: " + entitiesHit)); // Debug output
                    // player.sendSystemMessage(Component.literal("Damage dealt to Item: " + durabilityDamage)); // Debug output
                } else {
                    player.getCooldowns().addCooldown(this, 10);
                }

                if (stack.is(BSItems.SOUL_REAPER.get())) {
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
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    // Sword-like Item Stuff
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (itemStack.is(BSItems.WOODEN_SCYTHE.get())) {
            return 200;
        } else {
            return super.getBurnTime(itemStack, recipeType);
        }
    }
}
