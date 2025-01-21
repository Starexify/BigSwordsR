package net.nova.big_swords.item;

import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.consume.UseAction;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.init.Sounds;
import net.nova.big_swords.init.Tags;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class GlaiveItem extends Item {
    public final Random random = new Random();
    public final float range = 5.0f; // 5 block range
    public List<AttributeModifiersComponent.Entry> modifiers = getComponents().get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers();

    public GlaiveItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minChargedDamage, float maxChargedDamage, Item.Settings settings) {
        super(BSToolMaterial.applyChargedProperties(settings, toolMaterial, attackDamage, attackSpeed, minChargedDamage, maxChargedDamage));
    }

    public float minChargedDamage() {
        return (float) BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MAX_CHARGED_DAMAGE_ID);
    }

    public float maxChargedDamage() {
        return (float) BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MAX_CHARGED_DAMAGE_ID);
    }

    // Tilling Creep
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockpos = context.getBlockPos();
        World level = context.getWorld();
        BlockState state = level.getBlockState(blockpos);
        PlayerEntity player = context.getPlayer();
        ItemStack itemStack = context.getStack();

        if (state.getBlock() instanceof CreepBlock creepBlock && !state.get(CreepBlock.TILLED)) {
            level.playSound(null, blockpos, SoundEvents.PARTICLE_SOUL_ESCAPE.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            creepBlock.tillBlock(level, blockpos, state);
            itemStack.damage(1, player);

            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    // Glaive Mechanic
    @Override
    public ActionResult use(World level, PlayerEntity player, Hand usedHand) {
        // Check if the player is looking at a CreepBlock and pass if a CreepBlock is hit
        BlockHitResult blockHit = level.raycast(new RaycastContext(
                player.getCameraPosVec(1.0F),
                player.getRotationVec(1.0F).multiply(5.0), // 5 block range
                RaycastContext.ShapeType.OUTLINE,
                RaycastContext.FluidHandling.NONE,
                player
        ));

        if (blockHit.getType() == HitResult.Type.BLOCK && level.getBlockState(blockHit.getBlockPos()).getBlock() instanceof CreepBlock) {
            return ActionResult.PASS;
        }

        player.setCurrentHand(usedHand);
        return ActionResult.CONSUME;
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World level, LivingEntity entity, int timeLeft) {
        if (entity instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(stack, entity) - timeLeft;
            if (i < 20) return false; // Require a minimum charge time

            if (!level.isClient) {
                Vec3d startVec = player.getCameraPosVec(1.0F);
                Vec3d endVec = startVec.add(player.getRotationVec(1.0F).multiply(range));
                Box boundingBox = new Box(startVec, endVec).expand(1.0);
                Predicate<LivingEntity> predicate = livingEntity -> livingEntity != player && livingEntity.isAttackable();
                List<LivingEntity> entities = level.getEntitiesByClass(LivingEntity.class, boundingBox, predicate);

                EntityHitResult entityHitResult = getEntityHitResult(startVec, endVec, entities);

                player.swingHand(Hand.MAIN_HAND, true);
                if (entityHitResult != null && entityHitResult.getType() == HitResult.Type.ENTITY) {
                    LivingEntity target = (LivingEntity) entityHitResult.getEntity();
                    BlockHitResult blockHit = level.raycast(new RaycastContext(startVec, target.getCameraPosVec(1.0F), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));

                    if (blockHit.getType() == HitResult.Type.MISS) {
                        glaiveHits(stack, level, player, target);
                    } else {
                        glaiveMiss(stack, player, level);
                    }
                } else {
                    glaiveMiss(stack, player, level);
                }
            }
        }
        return false;
    }

    public boolean glaiveHits(ItemStack stack, World level, PlayerEntity player, LivingEntity target) {
        float damage = minChargedDamage() + random.nextFloat() * (maxChargedDamage() - minChargedDamage());
        damage = Math.round(damage * 10.0f) / 10.0f;
        if (level instanceof ServerWorld serverWorld)
            target.damage(serverWorld, level.getDamageSources().playerAttack(player), damage);

        stack.damage(3, player, EquipmentSlot.MAINHAND);
        player.getItemCooldownManager().set(stack, 40);
        BigSwordsR.playSound(level, player, Sounds.GLAIVE_HIT);

        // Blood Vial Mechanics
        if (target.isDead() && !target.getType().isIn(Tags.EntityTypeTags.BLOODLESS)) {
            BloodVial.incrementBloodVialInBothHands(player);
        }

        return true;
    }

    public boolean glaiveMiss(ItemStack stack, PlayerEntity player, World level) {
        player.getItemCooldownManager().set(stack, 10);
        BigSwordsR.playSound(level, player, Sounds.GLAIVE_SWING);
        return false;
    }

    public EntityHitResult getEntityHitResult(Vec3d startVec, Vec3d endVec, List<LivingEntity> entities) {
        for (LivingEntity entity : entities) {
            Box entityBoundingBox = entity.getBoundingBox();
            if (entityBoundingBox.raycast(startVec, endVec).isPresent()) {
                return new EntityHitResult(entity);
            }
        }
        return null;
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
