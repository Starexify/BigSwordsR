package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.Sounds;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import static net.nova.big_swords.BigSwordsR.playSound;

public class GlaiveItem extends TieredItem {
    private final float minDamage;
    private final float maxDamage;
    private final Random random = new Random();

    public GlaiveItem(Tier pTier, Item.Properties pProperties, float minDamage, float maxDamage) {
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

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 36000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);

        // Check if the player is looking at a CreepBlock
        BlockHitResult blockHit = level.clip(new ClipContext(
                player.getEyePosition(1.0F),
                player.getEyePosition(1.0F).add(player.getLookAngle().scale(5.0)), // 5 block range
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.NONE,
                player
        ));

        if (blockHit.getType() == HitResult.Type.BLOCK && level.getBlockState(blockHit.getBlockPos()).getBlock() instanceof CreepBlock) {
            return InteractionResultHolder.pass(itemstack); // Pass if a CreepBlock is hit
        }

        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    // Glaive Mechanic
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack, entity) - timeLeft;
            if (i < 10) return; // Require a minimum charge time

            if (!level.isClientSide) {
                Vec3 startVec = player.getEyePosition(1.0F);
                Vec3 endVec = startVec.add(player.getLookAngle().scale(5.0)); // 5 block range
                AABB boundingBox = new AABB(startVec, endVec).inflate(1.0);
                Predicate<LivingEntity> predicate = livingEntity -> livingEntity != player && livingEntity.isPickable();
                List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, boundingBox, predicate);

                EntityHitResult entityHitResult = getEntityHitResult(player, startVec, endVec, entities);

                player.swing(InteractionHand.MAIN_HAND, true);
                if (entityHitResult != null && entityHitResult.getType() == HitResult.Type.ENTITY) {
                    LivingEntity target = (LivingEntity) entityHitResult.getEntity();
                    float damage = minDamage + random.nextFloat() * (maxDamage - minDamage);
                    damage = Math.round(damage * 10.0f) / 10.0f;
                    target.hurt(player.damageSources().playerAttack(player), damage);

                    stack.hurtAndBreak(3, player, EquipmentSlot.MAINHAND);
                    player.getCooldowns().addCooldown(this, 40);
                    playSound(level, player, Sounds.GLAIVE_HIT.get());
                    // player.sendSystemMessage(Component.literal("Hit entity with dmg: " + damage)); // Debug output
                } else {
                    player.getCooldowns().addCooldown(this, 10);
                    playSound(level, player, Sounds.GLAIVE_SWING.get());
                }
            }
        }
    }

    private EntityHitResult getEntityHitResult(Player player, Vec3 startVec, Vec3 endVec, List<LivingEntity> entities) {
        for (LivingEntity entity : entities) {
            AABB entityBoundingBox = entity.getBoundingBox();
            if (entityBoundingBox.clip(startVec, endVec).isPresent()) {
                return new EntityHitResult(entity);
            }
        }
        return null;
    }

    @Override
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, EquipmentSlot.MAINHAND);
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

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }
}
