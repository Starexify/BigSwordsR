package net.nova.big_swords.item;

import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.init.Sounds;
import net.nova.big_swords.init.Tags;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import static net.nova.big_swords.BigSwordsR.playSound;

public class GlaiveItem extends Item {
  public final Random random = new Random();
  public final float range = 5.0f; // 5 block range

  public GlaiveItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float minChargedDamage, float maxChargedDamage, Properties properties) {
    super(BSToolMaterial.applyChargedProperties(properties, toolMaterial, attackDamage, attackSpeed, minChargedDamage, maxChargedDamage));
  }

  private List<ItemAttributeModifiers.Entry> getSafeModifiers() {
    ItemAttributeModifiers attributeModifiers = this.components().get(DataComponents.ATTRIBUTE_MODIFIERS);
    return attributeModifiers != null ? attributeModifiers.modifiers() : List.of();
  }

  public float minChargedDamage() {
    return (float) BigSwordsR.getModifierValue(getSafeModifiers(), BSToolMaterial.MAX_CHARGED_DAMAGE_ID);
  }

  public float maxChargedDamage() {
    return (float) BigSwordsR.getModifierValue(getSafeModifiers(), BSToolMaterial.MAX_CHARGED_DAMAGE_ID);
  }

  // Tilling Creep
  @Override
  public @NonNull InteractionResult useOn(UseOnContext context) {
    BlockPos pos = context.getClickedPos();
    Level level = context.getLevel();
    BlockState state = level.getBlockState(pos);
    Player player = context.getPlayer();
    ItemStack itemInHand = context.getItemInHand();

    if (state.getBlock() instanceof CreepBlock creepBlock && !state.getValue(CreepBlock.TILLED)) {
      if (player instanceof ServerPlayer) {
        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, itemInHand);
      }
      level.playSound(null, pos, SoundEvents.SOUL_ESCAPE.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
      creepBlock.tillBlock(level, pos, state);
      itemInHand.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());

      return InteractionResult.SUCCESS;
    }
    return super.useOn(context);
  }

  // Glaive Mechanic
  @Override
  public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
    // Check if the player is looking at a CreepBlock and pass if a CreepBlock is hit
    BlockHitResult blockHit = level.clip(new ClipContext(
        player.getEyePosition(1.0F),
        player.getEyePosition(1.0F).add(player.getLookAngle().scale(5.0)), // 5 block range
        ClipContext.Block.OUTLINE,
        ClipContext.Fluid.NONE,
        player
    ));
    if (blockHit.getType() == HitResult.Type.BLOCK && level.getBlockState(blockHit.getBlockPos()).getBlock() instanceof CreepBlock)
      return InteractionResult.PASS;

    player.startUsingItem(usedHand);
    return InteractionResult.CONSUME;
  }

  @Override
  public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
    if (entity instanceof Player player) {
      int i = this.getUseDuration(stack, entity) - timeLeft;
      if (i < 20) return false; // Require a minimum charge time

      if (!level.isClientSide()) {
        Vec3 startVec = player.getEyePosition(1.0F);
        Vec3 endVec = startVec.add(player.getLookAngle().scale(range));
        AABB boundingBox = new AABB(startVec, endVec).inflate(1.0);
        Predicate<LivingEntity> predicate = livingEntity -> livingEntity != player && livingEntity.isPickable();
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, boundingBox, predicate);

        EntityHitResult entityHitResult = getEntityHitResult(startVec, endVec, entities);

        player.swing(InteractionHand.MAIN_HAND, true);
        if (entityHitResult != null && entityHitResult.getType() == HitResult.Type.ENTITY) {
          LivingEntity target = (LivingEntity) entityHitResult.getEntity();
          BlockHitResult blockHit = level.clip(new ClipContext(startVec, target.getEyePosition(1.0F), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

          if (blockHit.getType() == HitResult.Type.MISS) glaiveHits(stack, level, player, target);
          else glaiveMiss(stack, player, level);

        } else glaiveMiss(stack, player, level);
      }
    }
    return false;
  }

  public boolean glaiveHits(ItemStack stack, Level level, Player player, LivingEntity target) {
    float damage = minChargedDamage() + random.nextFloat() * (maxChargedDamage() - minChargedDamage());
    damage = Math.round(damage * 10.0f) / 10.0f;
    if (level instanceof ServerLevel serverLevel)
      target.hurtServer(serverLevel, player.damageSources().playerAttack(player), damage);

    stack.hurtAndBreak(3, player, EquipmentSlot.MAINHAND);
    player.getCooldowns().addCooldown(stack, 40);
    playSound(level, player, Sounds.GLAIVE_HIT.get());

    // Blood Vial Mechanics
    if (target.isDeadOrDying() && !target.getType().equals(Tags.EntityTypeTags.BLOODLESS))
      BloodVial.incrementBloodVialInBothHands(player);

    return true;
  }

  public boolean glaiveMiss(ItemStack stack, Player player, Level level) {
    player.getCooldowns().addCooldown(stack, 10);
    playSound(level, player, Sounds.GLAIVE_SWING.get());
    return false;
  }

  public EntityHitResult getEntityHitResult(Vec3 startVec, Vec3 endVec, List<LivingEntity> entities) {
    for (LivingEntity entity : entities)
      if (entity.getBoundingBox().clip(startVec, endVec).isPresent()) return new EntityHitResult(entity);
    return null;
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
}
