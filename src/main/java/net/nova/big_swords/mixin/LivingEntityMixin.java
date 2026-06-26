package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.minecraft.world.level.gamerules.GameRules;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.nova.big_swords.ShieldMechanics.ITEM_OXIDATION_CHANCE;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

  @Shadow
  @Nullable
  public abstract ItemStack getItemBlockingWith();

  @Shadow
  public abstract ItemStack getMainHandItem();

  @Shadow
  public abstract ItemStack getOffhandItem();

  public LivingEntityMixin(EntityType<?> entityType, Level level) {
    super(entityType, level);
  }

  @Inject(method = "tick", at = @At("TAIL"))
  private void big_swords$tick(CallbackInfo ci) {
    if (!(level() instanceof ServerLevel serverLevel)) return;
    LivingEntity self = (LivingEntity) (Object) this;

    if (!self.isAlive() || self.isRemoved()) return;

    if (isInWater()) {
      handleEquippedDegradation(self, getMainHandItem(), EquipmentSlot.MAINHAND);
      handleEquippedDegradation(self, getOffhandItem(), EquipmentSlot.OFFHAND);
    }

    handleEquipmentOxidation(serverLevel, self, getMainHandItem(), EquipmentSlot.MAINHAND);
    handleEquipmentOxidation(serverLevel, self, getOffhandItem(), EquipmentSlot.OFFHAND);
  }

  @Unique
  private static void handleEquippedDegradation(LivingEntity entity, ItemStack stack, EquipmentSlot slot) {
    if (stack.isEmpty() || !stack.isDamageableItem()) return;

    if (stack.has(BSDataComponents.DEGRADES_UNDERWATER)) {
      stack.hurtAndBreak(1, entity, slot);
    }
  }

  @Unique
  private static void handleEquipmentOxidation(ServerLevel level, LivingEntity entity, ItemStack stack, EquipmentSlot slot) {
    if (entity.hasInfiniteMaterials() || stack.isEmpty() || !stack.has(BSDataComponents.OXIDATION_STATE)) return;
    if (stack.getOrDefault(BSDataComponents.WAXED, false)) return;

    WeatheringCopperCollection<Pair<Holder<Item>, ResourceKey<Item>>> activeCollection = null;
    Item currentItem = stack.getItem();
    if (BSItems.COPPER_SHIELD.asList().stream().anyMatch(holder -> holder.getFirst().value() == currentItem)) {
      activeCollection = BSItems.COPPER_SHIELD;
    }
    else if (BSItems.GILDED_COPPER_SHIELD.asList().stream().anyMatch(holder -> holder.getFirst().value() == currentItem)) {
      activeCollection = BSItems.GILDED_COPPER_SHIELD;
    }
    if (activeCollection == null) return;

    WeatheringCopper.WeatherState currentState = stack.get(BSDataComponents.OXIDATION_STATE);

    int tickSpeed = level.getGameRules().get(GameRules.RANDOM_TICK_SPEED);
    if (tickSpeed <= 0) return;

    if (stack.isDamaged()) {
      float healChancePerTick = ((float) tickSpeed / 4096) * (ITEM_OXIDATION_CHANCE * 55);
      if (level.getRandom().nextFloat() < healChancePerTick) {
        assert currentState != null;
        int healAmount = switch (currentState) {
          case EXPOSED -> 2;
          case WEATHERED -> 4;
          case OXIDIZED -> 6;
          default -> 0;
        };
        stack.setDamageValue(Math.max(0, stack.getDamageValue() - healAmount));
      }
    }

    if (currentState == WeatheringCopper.WeatherState.OXIDIZED) return;
    float vanillaBlockChancePerTick = ((float) tickSpeed / 4096) * ITEM_OXIDATION_CHANCE;

    if (level.getRandom().nextFloat() < vanillaBlockChancePerTick) {
      WeatheringCopper.WeatherState nextState = currentState.next();

      Item nextTierItem = activeCollection.weathering().pick(nextState).getFirst().value();
      ItemStack nextStack = new ItemStack(nextTierItem, stack.getCount());

      nextStack.applyComponents(stack.getComponentsPatch());
      nextStack.set(BSDataComponents.OXIDATION_STATE, nextState);

      entity.setItemSlot(slot, nextStack);
    }
  }

  @WrapWithCondition(method = "applyItemBlocking", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/component/BlocksAttacks;hurtBlockingItem(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;F)V"))
  private boolean preventShieldDamage(BlocksAttacks instance, Level level, ItemStack item, LivingEntity user, InteractionHand hand, float damage, @Local(argsOnly = true, name = "source") DamageSource source) {
    Entity attacker = source.getEntity();
    Entity entitySource = source.getDirectEntity();

    if (item != null) {
      // Stone Shields Perk
      boolean isStoneShield = item.is(BSItems.STONE_SHIELD.getFirst());
      boolean isGildedStoneShield = item.is(BSItems.GILDED_STONE_SHIELD.getFirst());
      if ((isStoneShield || isGildedStoneShield)) {
        if (attacker instanceof LivingEntity livingAttacker) {
          int fireAspectLevel = livingAttacker.getWeaponItem().getEnchantments().getLevel(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT));
          int soulFireAspectLevel = level.registryAccess()
              .lookupOrThrow(Registries.ENCHANTMENT)
              .get(Identifier.withDefaultNamespace("soul_fire_aspect"))
              .map(enchantment -> user.getWeaponItem().getEnchantments().getLevel(enchantment))
              .orElse(0);
          if (fireAspectLevel > 0 || soulFireAspectLevel > 0) return false;
        }
        if (entitySource instanceof Fireball || (entitySource instanceof Projectile projectile && projectile.isOnFire()))
          return false;
      }
    }
    return true;
  }

  @ModifyArg(method = "hurtServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;applyItemBlocking(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)F"), index = 2)
  private float bypassShield(float original, @Local(argsOnly = true) DamageSource source) {
    ItemStack stack = getItemBlockingWith();
    Entity attacker = source.getEntity();
    double randomChanceE = Math.random();

    if (stack != null) {
      // Patchwork Shields Weakness
      boolean isPatchworkShield = stack.is(BSItems.PATCHWORK_SHIELD.getFirst());
      boolean isGildedPatchworkShield = stack.is(BSItems.GILDED_PATCHWORK_SHIELD.getFirst());
      if (isPatchworkShield || isGildedPatchworkShield) {
        float weaknessChance = isGildedPatchworkShield ? 0.25f : 0.5f;
        if (randomChanceE < weaknessChance) return 0.0f;
      }

      // Ender Shields Weakness
      boolean isEnderShield = stack.is(BSItems.ENDER_SHIELD.getFirst());
      boolean isGildedEnderShield = stack.is(BSItems.GILDED_ENDER_SHIELD.getFirst());
      if (isEnderShield || isGildedEnderShield) {
        if (attacker instanceof EnderMan || attacker instanceof EnderDragon || attacker instanceof Endermite)
          return 0.0f;
      }
    }
    return original;
  }
}
