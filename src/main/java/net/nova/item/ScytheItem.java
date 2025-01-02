package net.nova.item;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.consume.UseAction;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.nova.BigSwordsR;
import net.nova.enchantments.effects.SoulStealEffect;
import net.nova.init.BSEnchantmentEffects;
import net.nova.init.BSItems;
import net.nova.init.Sounds;

import java.util.List;
import java.util.Random;

public class ScytheItem extends HoeItem {
    public final float minDamage;
    public final float maxDamage;
    public final Random random = new Random();

    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, float minDamage, float maxDamage, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);

        tooltip.add(Text.empty());
        tooltip.add(Text.literal("Special:").formatted(Formatting.GRAY));
        tooltip.add(Text.literal(" " + this.minDamage + " - " + this.maxDamage + " Charged Damage").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.empty());
    }

    // Scythe Mechanic
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand usedHand) {
        player.setCurrentHand(usedHand);
        return ActionResult.CONSUME;
    }

    public float radius = 1.5f;  // Radius of the half-circle
    public float width = 3.0f;   // Width of the attack area
    public float height = 3.0f;  // Height of the attack area
    public float depth = 3.0f;   // Depth of the attack area
    public float distance = 0.5f; // Distance in front of the player

    @Override
    public boolean onStoppedUsing(ItemStack stack, World level, LivingEntity entity, int timeLeft) {
        if (entity instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(stack, entity) - timeLeft;
            if (i < 20) return false; // Require a minimum charge time

            if (!level.isClient) {
                Vec3d lookVec = player.getRotationVec(1.0F);
                Vec3d playerPos = player.getPos().add(0, player.getEyeHeight(player.getPose()), 0);
                Vec3d attackCenter = playerPos.add(lookVec.multiply(distance + depth / 2));
                Box boundingBox = new Box(
                        attackCenter.x - width / 2, attackCenter.y - height / 2, attackCenter.z - width / 2,
                        attackCenter.x + width / 2, attackCenter.y + height / 2, attackCenter.z + width / 2
                );

                List<LivingEntity> entities = level.getEntitiesByClass(LivingEntity.class, boundingBox,
                        e -> e != player && e.isAttackable());

                player.swingHand(Hand.MAIN_HAND, true);
                int entitiesHit = 0;
                for (LivingEntity target : entities) {
                    Vec3d targetPos = target.getPos().add(0, target.getHeight() / 2, 0);
                    Vec3d toTarget = targetPos.subtract(playerPos);

                    // Check if the entity is within the half-circle area
                    if (isInAttackArea(toTarget, lookVec)) {
                        BlockHitResult blockHit = level.raycast(new RaycastContext(playerPos, targetPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));

                        if (blockHit.getType() == HitResult.Type.MISS) {
                            scytheHits(level, player, target);
                            entitiesHit++;

                            int soulStealerEnchantment = EnchantmentHelper.getLevel(BigSwordsR.getEnchantment(level, BSEnchantmentEffects.SOUL_STEALER), stack);
                            if (soulStealerEnchantment > 0) {
                                SoulStealEffect soulStealEffect = new SoulStealEffect(200);
                                soulStealEffect.apply((ServerWorld) level, soulStealerEnchantment,
                                        new EnchantmentEffectContext(stack, entity.getPreferredEquipmentSlot(stack), entity),
                                        target, target.getPos()
                                );
                            }
                        }
                    }
                }

                if (entitiesHit > 0) {
                    int durabilityDamage = entitiesHit * 2;
                    stack.damage(durabilityDamage, player, EquipmentSlot.MAINHAND);
                    player.getItemCooldownManager().set(stack, 40);

                    // player.sendSystemMessage(Component.literal("Hit entities with dmg: " + entitiesHit)); // Debug output
                    // player.sendSystemMessage(Component.literal("Damage dealt to Item: " + durabilityDamage)); // Debug output
                } else {
                    player.getItemCooldownManager().set(stack, 10);
                }

                if (stack.isOf(BSItems.SOUL_REAPER)) {
                    BigSwordsR.playSound(level, player, Sounds.REAPER_SLASH);
                } else {
                    BigSwordsR.playSound(level, player, Sounds.SCYTHE_SLASH);
                }
            }
        }
        return false;
    }

    public boolean isInAttackArea(Vec3d toTarget, Vec3d lookVec) {
        // Create a coordinate system based on the look vector
        Vec3d up = new Vec3d(0, 1, 0);
        Vec3d right = lookVec.crossProduct(up).normalize();
        Vec3d adjustedUp = right.crossProduct(lookVec).normalize();

        // Project the toTarget vector onto this coordinate system
        double forwardProject = toTarget.dotProduct(lookVec);
        double rightProject = toTarget.dotProduct(right);
        double upProject = toTarget.dotProduct(adjustedUp);

        // Check if the entity is within the half-circle area
        boolean inRadius = Math.sqrt(rightProject * rightProject + upProject * upProject) <= radius;
        boolean inFront = forwardProject >= distance && forwardProject <= distance + depth;
        boolean inHeight = Math.abs(upProject) <= height / 2;

        return inRadius && inFront && inHeight;
    }

    public void scytheHits(World level, PlayerEntity player, LivingEntity target) {
        float damage = minDamage + random.nextFloat() * (maxDamage - minDamage);
        damage = Math.round(damage * 10.0f) / 10.0f;
        if (level instanceof ServerWorld serverWorld)
            target.damage(serverWorld, level.getDamageSources().playerAttack(player), damage);
    }

    // Bow-like Item Stuff
    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    // Sword-like Item Stuff
    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }
}
