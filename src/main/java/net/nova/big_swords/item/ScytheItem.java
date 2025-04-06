package net.nova.big_swords.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.init.Sounds;

import java.util.List;
import java.util.Random;

public class ScytheItem extends HoeItem {
    public final Random random = new Random();
    public List<ItemAttributeModifiers.Entry> modifiers = components().get(DataComponents.ATTRIBUTE_MODIFIERS).modifiers();

    public static final ThreadLocal<Boolean> isScythe = ThreadLocal.withInitial(() -> false);
    public static Properties properties;

    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, float minChargedDamage, float maxChargedDamage, Item.Properties properties) {
        super(material, attackDamage, attackSpeed, properties(material, attackDamage, attackSpeed, minChargedDamage, maxChargedDamage, properties));
    }

    public static Item.Properties properties(ToolMaterial material, float attackDamage, float attackSpeed, float minChargedDamage, float maxChargedDamage, Item.Properties properties) {
        isScythe.set(true);
        return BSToolMaterial.applyToolSettings(properties, material, BlockTags.MINEABLE_WITH_HOE, attackDamage, attackSpeed, minChargedDamage, maxChargedDamage);
    }

    public float minChargedDamage() {
        return (float) BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MAX_CHARGED_DAMAGE_ID);
    }

    public float maxChargedDamage() {
        return (float) BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MAX_CHARGED_DAMAGE_ID);
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
                Vec3 playerPos = player.position().add(0, player.getEyeHeight(player.getPose()), 0);
                Vec3 attackCenter = playerPos.add(lookVec.scale(distance + depth / 2));
                AABB boundingBox = new AABB(
                        attackCenter.x - width / 2, attackCenter.y - height / 2, attackCenter.z - width / 2,
                        attackCenter.x + width / 2, attackCenter.y + height / 2, attackCenter.z + width / 2
                );

                List<LivingEntity> entities = serverLevel.getEntitiesOfClass(LivingEntity.class, boundingBox, e -> e != player && e.isAttackable());
                int entitiesHit = 0;

                for (LivingEntity target : entities) {
                    Vec3 targetPos = target.position().add(0, target.getBbHeight() / 2, 0);
                    Vec3 toTarget = targetPos.subtract(playerPos);

                    // Check if the entity is within the half-circle area
                    if (isInAttackArea(toTarget, lookVec)) {
                        BlockHitResult blockHit = serverLevel.clip(new ClipContext(playerPos, targetPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

                        if (blockHit.getType() == HitResult.Type.MISS) {
                            scytheHits(serverLevel, player, target);
                            EnchantedItemInUse enchantedItemInUse = new EnchantedItemInUse(stack, player.getEquipmentSlotForItem(stack), entity);
                            EnchantmentHelper.updateEnchantments(stack, enchantmentHolder -> {
                                enchantmentHolder.keySet().iterator().forEachRemaining(registryEntry -> {
                                    if (registryEntry.value().effects().get(BSDataComponents.POST_DEATH) != null)
                                        registryEntry.value().effects().get(BSDataComponents.POST_DEATH).forEach(targetedEffect -> targetedEffect.effect().apply(serverLevel, enchantmentHolder.getLevel(registryEntry), enchantedItemInUse, target, target.position()));
                                });
                            });
                            entitiesHit++;
                        }
                    }
                }

                if (entitiesHit > 0) {
                    int durabilityDamage = entitiesHit * 2;
                    stack.hurtAndBreak(durabilityDamage, player, EquipmentSlot.MAINHAND);
                    player.getCooldowns().addCooldown(stack, 40);
                    // player.sendSystemMessage(Component.literal("Hit entities with dmg: " + entitiesHit)); // Debug output
                    // player.sendSystemMessage(Component.literal("Damage dealt to Item: " + durabilityDamage)); // Debug output
                } else player.getCooldowns().addCooldown(stack, 10);

                if (stack.is(BSItems.SOUL_REAPER)) BigSwordsR.playSound(serverLevel, player, Sounds.REAPER_SLASH);
                else BigSwordsR.playSound(serverLevel, player, Sounds.SCYTHE_SLASH);
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
        float damage = minChargedDamage() + random.nextFloat() * (maxChargedDamage() - minChargedDamage());
        damage = Math.round(damage * 10.0f) / 10.0f;
        target.hurtServer(serverLevel, serverLevel.damageSources().playerAttack(player), damage);
    }

    // Bow-like Item Stuff
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BOW;
    }
}
