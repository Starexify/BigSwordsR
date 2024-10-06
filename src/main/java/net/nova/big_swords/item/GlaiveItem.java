package net.nova.big_swords.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Sounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import static net.nova.big_swords.BigSwordsR.playSound;

public class GlaiveItem extends TieredItem {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final float minDamage;
    private final float maxDamage;
    private final Random random = new Random();
    private final float range = 5.0f; // 5 block range

    public GlaiveItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, float minDamage, float maxDamage) {
        super(pTier, pProperties);
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
        pTooltipComponents.add(Component.literal(" " + this.range + " Range").withStyle(ChatFormatting.DARK_GREEN));
        pTooltipComponents.add(Component.empty());
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON;
    }

    // Tilling Creep
    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        BlockState state = level.getBlockState(blockpos);
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();

        if (state.getBlock() instanceof CreepBlock creepBlock && !state.getValue(CreepBlock.TILLED)) {
            level.playSound(null, blockpos, SoundEvents.SOUL_ESCAPE, SoundSource.PLAYERS, 1.0F, 1.0F);
            creepBlock.tillBlock(level, blockpos, state);
            itemStack.hurtAndBreak(1, player, (p_289501_) -> {
                p_289501_.broadcastBreakEvent(player.getUsedItemHand());
            });

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(context);
    }

    // Glaive Mechanic
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);

        // Check if the player is looking at a CreepBlock and pass if a CreepBlock is hit
        BlockHitResult blockHit = level.clip(new ClipContext(
                player.getEyePosition(1.0F),
                player.getEyePosition(1.0F).add(player.getLookAngle().scale(5.0)), // 5 block range
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.NONE,
                player
        ));
        if (blockHit.getType() == HitResult.Type.BLOCK && level.getBlockState(blockHit.getBlockPos()).getBlock() instanceof CreepBlock) {
            return InteractionResultHolder.pass(itemstack);
        }

        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack) - timeLeft;
            if (i < 20) return; // Require a minimum charge time

            if (!level.isClientSide) {
                Vec3 startVec = player.getEyePosition(1.0F);
                Vec3 endVec = startVec.add(player.getLookAngle().scale(range));
                AABB boundingBox = new AABB(startVec, endVec).inflate(1.0);
                Predicate<LivingEntity> predicate = livingEntity -> livingEntity != player && livingEntity.isPickable();
                List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, boundingBox, predicate);

                EntityHitResult entityHitResult = getEntityHitResult(player, startVec, endVec, entities);

                player.swing(InteractionHand.MAIN_HAND, true);
                if (entityHitResult != null && entityHitResult.getType() == HitResult.Type.ENTITY) {
                    LivingEntity target = (LivingEntity) entityHitResult.getEntity();
                    BlockHitResult blockHit = level.clip(new ClipContext(startVec, target.getEyePosition(1.0F), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

                    if (blockHit.getType() == HitResult.Type.MISS) {
                        glaiveHits(level, player, stack, target);
                    } else {
                        glaiveMiss(player, level);
                    }
                } else {
                    glaiveMiss(player, level);
                }
            }
        }
    }

    private void glaiveHits(Level level, Player player, ItemStack stack, LivingEntity target) {
        float damage = minDamage + random.nextFloat() * (maxDamage - minDamage);
        damage = Math.round(damage * 10.0f) / 10.0f;
        target.hurt(player.damageSources().playerAttack(player), damage);

        stack.hurtAndBreak(3, player, (p_289501_) -> {
            p_289501_.broadcastBreakEvent(player.getUsedItemHand());
        });
        player.getCooldowns().addCooldown(this, 40);
        playSound(level, player, Sounds.GLAIVE_HIT.get());

        // player.sendSystemMessage(Component.literal("Hit entity with dmg: " + damage)); // Debug output
    }

    private void glaiveMiss(Player player, Level level) {
        player.getCooldowns().addCooldown(this, 10);
        playSound(level, player, Sounds.GLAIVE_SWING.get());
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
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    // Sword-like Item Stuff
    public float getDamage() {
        return this.attackDamage;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (itemStack.is(BSItems.WOODEN_GLAIVE.get())) {
            return 200;
        } else {
            return super.getBurnTime(itemStack, recipeType);
        }
    }
}
