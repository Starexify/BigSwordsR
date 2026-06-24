package net.nova.big_swords.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.skeleton.AbstractSkeleton;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import static net.minecraft.world.entity.EquipmentSlot.MAINHAND;
import static net.nova.big_swords.BigSwordsR.MODID;
import static net.nova.big_swords.BigSwordsR.playSound;

@EventBusSubscriber(modid = MODID)
public class ShieldMechanics {
  public static final float ITEM_OXIDATION_CHANCE = 0.05688889F;

  @SubscribeEvent
  public static void onShieldBlock(LivingShieldBlockEvent event) {
    if (!(event.getEntity() instanceof Player player) || !event.getBlocked()) return;

    ItemStack shield = player.getItemBlockingWith();
    BlocksAttacks blocksAttacks = shield.get(DataComponents.BLOCKS_ATTACKS);
    if (blocksAttacks == null) return;

    Level level = player.level();
    ServerLevel serverLevel = level instanceof ServerLevel sl ? sl : null;

    DamageSource damageSource = event.getDamageSource();
    Entity attacker = damageSource.getEntity();
    Entity sourceEntity = damageSource.getDirectEntity();
    float blockedDamage = event.getBlockedDamage();

    double randomChance = Math.random();
    double randomChanceE = Math.random();

    int fireAspectLevel = attacker instanceof LivingEntity livingEntity ? livingEntity.getWeaponItem().getEnchantmentLevel(player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) : 0;
    int soulFireAspectLevel = attacker instanceof LivingEntity livingEntity ?
        player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT)
            .get(Identifier.withDefaultNamespace("soul_fire_aspect"))
            .map(enchantment -> livingEntity.getWeaponItem().getEnchantmentLevel(enchantment))
            .orElse(0) : 0;

    // Wooden Shields
    boolean isWooden = shield.is(BSItems.WOODEN_SHIELD);
    boolean isGildedWooden = shield.is(BSItems.GILDED_WOODEN_SHIELD);
    if (isWooden || isGildedWooden) {
      if (damageSource.is(DamageTypes.ARROW) && sourceEntity instanceof Arrow arrow) {
        // Perk
        double catchChance = isGildedWooden ? 0.7 : 0.4;
        if (randomChance < catchChance) {
          arrow.remove(Entity.RemovalReason.DISCARDED);
          ItemStack arrowStack = new ItemStack(Items.ARROW);
          if (!player.addItem(arrowStack)) player.drop(arrowStack, false);
        }
        // Weakness
        if (arrow.isOnFire())
          blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage * 4);
      }

      // Weakness (Comp with Soul fire'd)
      if (fireAspectLevel > 0) {
        float multiplier = switch (fireAspectLevel) {
          case 1 -> 3;
          case 2 -> 5;
          default -> 1;
        };
        blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage * multiplier);
      }
      if (soulFireAspectLevel > 0) {
        float multiplier = switch (soulFireAspectLevel) {
          case 1 -> 6;
          case 2 -> 10;
          default -> 1;
        };
        blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage * multiplier);
      }
    }

    // Stone Shields
    boolean isStone = shield.is(BSItems.STONE_SHIELD);
    boolean isGildedStone = shield.is(BSItems.GILDED_STONE_SHIELD);
    if (isStone || isGildedStone) {
      // Special
      if (attacker instanceof LivingEntity livingAttacker) {
        ItemStack weapon = livingAttacker.getMainHandItem();
        if (weapon.is(ItemTags.PICKAXES)) blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage);
      }

      // Perk
      if (fireAspectLevel > 0 || soulFireAspectLevel > 0) {
        event.setShieldDamage(0);
        playSound(level, player, SoundEvents.FIRE_EXTINGUISH);
      }
      if (sourceEntity instanceof Fireball || (sourceEntity instanceof Projectile projectile && projectile.isOnFire())) {
        event.setShieldDamage(0);
        sourceEntity.remove(Entity.RemovalReason.DISCARDED);
        playSound(level, player, SoundEvents.FIRE_EXTINGUISH);
      }

      // Weakness
      if ((damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION))) {
        int damageToPlayer = (int) blockedDamage / 3;
        event.setBlockedDamage(blockedDamage - damageToPlayer);
        blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage + damageToPlayer);
      }
    }

    // Iron Shields Perk
    boolean isIron = shield.is(BSItems.IRON_SHIELD);
    boolean isGildedIron = shield.is(BSItems.GILDED_IRON_SHIELD);
    if ((isIron || isGildedIron) && (damageSource.is(DamageTypes.EXPLOSION) || damageSource.is(DamageTypes.PLAYER_EXPLOSION)))
      blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), isGildedIron ? 0 : blockedDamage / 2);

    // Diamond Shields
    boolean isDiamond = shield.is(BSItems.DIAMOND_SHIELD);
    boolean isGildedDiamond = shield.is(BSItems.GILDED_DIAMOND_SHIELD);
    if (isDiamond || isGildedDiamond) {
      float reflectChance = isGildedDiamond ? 0.75f : 0.5f;
      // Perk
      if (randomChance < reflectChance) {
        if (sourceEntity instanceof Projectile projectile && !(projectile instanceof ThrownTrident))
          handleReflection(level, player, attacker, projectile, blocksAttacks, shield, blockedDamage);
      }
    }

    // Netherite Shields
    boolean isNetherite = shield.is(BSItems.NETHERITE_SHIELD);
    boolean isGildedNetherite = shield.is(BSItems.GILDED_NETHERITE_SHIELD);
    if (isNetherite || isGildedNetherite) {
      // Perk
      if (randomChance < 0.5 && attacker != null && serverLevel != null) {
        int cooldownTime = isGildedNetherite ? 80 : 160;
        float damageToReflect = isGildedNetherite ? blockedDamage * 0.5f : blockedDamage * 0.3f;
        float cooldownChance = isGildedNetherite ? 0.1f : 0.15f;
        attacker.hurtServer(serverLevel, damageSource, damageToReflect);

        // Weakness
        if (randomChanceE < cooldownChance)
          blocksAttacks.disable(serverLevel, player, cooldownTime, shield);
      }
    }

    // Ender Shields
    boolean isEnder = shield.is(BSItems.ENDER_SHIELD);
    boolean isGildedEnder = shield.is(BSItems.GILDED_ENDER_SHIELD);
    if (isEnder || isGildedEnder) {
      // Perk
      float teleportDisplaceChance = isGildedEnder ? 0.4f : 0.2f;
      if ((randomChance < teleportDisplaceChance) && attacker != null && !(attacker instanceof AbstractSkeleton || attacker instanceof WitherBoss)) {
        handleTeleport(level, player, attacker, randomChance);
      }

      // Weakness
      if (attacker instanceof EnderMan || attacker instanceof EnderDragon || attacker instanceof Endermite)
        event.setBlocked(false);
    }

    // Quartz Shields
    boolean isQuartz = shield.is(BSItems.QUARTZ_SHIELD);
    boolean isGildedQuartz = shield.is(BSItems.GILDED_QUARTZ_SHIELD);
    if ((isQuartz || isGildedQuartz)) {
      // Perk
      float quartzBarrierChance = isGildedQuartz ? 0.25f : 0.15f;
      if (randomChance < quartzBarrierChance) {
        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 30 * 20, 2, false, false));

        // Weakness
        float hungerChance = isGildedQuartz ? 0.3f : 0.2f;
        if (randomChanceE < hungerChance)
          player.getFoodData().eat(-8, -10.5f); // Reduces 1 full food bar (2 hunger points)
      }
    }

    // Patchwork Shields
    boolean isPatchwork = shield.is(BSItems.PATCHWORK_SHIELD);
    boolean isGildedPatchwork = shield.is(BSItems.GILDED_PATCHWORK_SHIELD);
    if (isPatchwork || isGildedPatchwork) {
      // Perk
      float perkChance = isGildedPatchwork ? 0.5f : 0.25f;
      if (randomChance < perkChance && attacker instanceof LivingEntity livingAttacker)
        livingAttacker.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10 * 20, 0, false, false));

      // Weakness
      float weaknessChance = isGildedPatchwork ? 0.25f : 0.5f;
      if (randomChanceE < weaknessChance) event.setBlocked(false);
    }

    // Skull Shields
    boolean isSkull = shield.is(BSItems.SKULL_SHIELD);
    boolean isGildedSkull = shield.is(BSItems.GILDED_SKULL_SHIELD);
    if (isSkull || isGildedSkull) {
      // Perk
      float perkChance = isGildedSkull ? 0.25f : 0.15f;
      if (randomChance < perkChance && attacker instanceof Mob mob) setNearestTarget(mob, player);

      // Weakness
      float weaknessChance = isGildedSkull ? 0.15f : 0.35f;
      if (randomChance < weaknessChance)
        blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage * 3);
    }

    // Biomass Shields
    boolean isBiomass = shield.is(BSItems.BIOMASS_SHIELD);
    boolean isGildedBiomass = shield.is(BSItems.GILDED_BIOMASS_SHIELD);
    if (isBiomass || isGildedBiomass) {
      // Perk
      if (randomChance < 0.45) {
        float healthToRestore = blockedDamage * 0.30f;
        player.heal(healthToRestore);
      }

      // Weakness
      if (randomChanceE < 0.15) {
        float damagePercentage = isGildedBiomass ? 0.2f : 0.4f;
        float healthToDamage = blockedDamage - (blockedDamage * damagePercentage);
        event.setBlockedDamage(healthToDamage);
      }
    }

    // Livingmetal Shields
    boolean isLivingmetal = shield.is(BSItems.LIVINGMETAL_SHIELD);
    boolean isGildedLivingmetal = shield.is(BSItems.GILDED_LIVINGMETAL_SHIELD);
    if (isLivingmetal || isGildedLivingmetal) {
      // Perk
      float perkChance = isGildedLivingmetal ? 0.4f : 0.25f;
      if (randomChance < perkChance) {
        // Weakness
        RandomSource random = level.getRandom();
        float chanceToUseMoreXP = isGildedLivingmetal ? 0.15f : 0.2f;
        int minXP = 2;
        int maxXP = 4;
        int xpToUse = randomChanceE < chanceToUseMoreXP ? maxXP + random.nextInt(3) : minXP + random.nextInt(3);

        float xpToHealthRatio = 2.0f;
        float healthToHeal = xpToUse * xpToHealthRatio;

        if (player.experienceLevel >= xpToUse && player.getMaxHealth() - 2 > player.getHealth()) {
          player.heal(healthToHeal);
          player.giveExperienceLevels(-xpToUse);
        }
      }
    }
  }

  public static void handleTeleport(Level level, Player player, Entity attacker, double randomChance) {
    Vec3 playerPos = player.position();
    Vec3 playerFacing = player.getLookAngle().normalize();

    // Random angle between -45 and 45 degrees
    double angle = (randomChance * 90 - 45) * Math.PI / 180;

    // Calculate the teleport vector
    Vec3 randomVector = new Vec3(Math.cos(angle), 0, Math.sin(angle)).normalize();
    double blendFactor = 0.7;
    Vec3 teleportVector = playerFacing.scale(blendFactor).add(randomVector.scale(1 - blendFactor)).normalize();

    // Find position
    double teleportDistance = 10 + (randomChance * 5);
    Vec3 newAttackerPosition = playerPos.add(teleportVector.scale(teleportDistance));

    // Adjust Y to find safe spot to not suffocate entity
    BlockPos blockPos = new BlockPos((int) Math.floor(newAttackerPosition.x), (int) Math.floor(newAttackerPosition.y), (int) Math.floor(newAttackerPosition.z));
    BlockPos safePos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos);

    attacker.teleportTo(safePos.getX() + 0.5, safePos.getY(), safePos.getZ() + 0.5);
    attacker.playSound(SoundEvents.ENDERMAN_TELEPORT);
  }

  public static void handleReflection(Level level, Player player, Entity attacker, Projectile originalProjectile, BlocksAttacks blocksAttacks, ItemStack shield, float blockedDamage) {
    if (attacker == null) {
      blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage * 4);
      return;
    }

    boolean wasOnFire = originalProjectile.isOnFire();
    originalProjectile.discard();
    Projectile newProjectile = (Projectile) originalProjectile.getType().create(level, EntitySpawnReason.EVENT);
    if (newProjectile == null) {
      blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage * 4);
      return;
    }

    newProjectile.setPos(player.getX(), originalProjectile.getY(), player.getZ());
    newProjectile.setOwner(player);
    if (wasOnFire) newProjectile.igniteForSeconds(100);

    Vec3 directionToAttacker = attacker.position().subtract(player.position()).normalize();
    newProjectile.shoot(directionToAttacker.x, directionToAttacker.y, directionToAttacker.z, 1.0f, 0.0f);
    level.addFreshEntity(newProjectile);

    blocksAttacks.hurtBlockingItem(level, shield, player, player.getUsedItemHand(), blockedDamage * 4);
  }

  public static void setNearestTarget(Mob mob, Player blockingPlayer) {
    double SEARCH_RANGE = 16.0;
    Level level = mob.level();
    AABB boundingBox = new AABB(
        mob.getX() - SEARCH_RANGE, mob.getY() - SEARCH_RANGE, mob.getZ() - SEARCH_RANGE,
        mob.getX() + SEARCH_RANGE, mob.getY() + SEARCH_RANGE, mob.getZ() + SEARCH_RANGE
    );

    // Find entities in the bounding box
    LivingEntity nearestEntity = null;
    double nearestDistance = Double.MAX_VALUE;

    for (Entity entity : level.getEntities(mob, boundingBox, e -> e instanceof LivingEntity && !e.equals(blockingPlayer))) {
      if (entity instanceof LivingEntity livingEntity) {
        double distance = mob.distanceToSqr(livingEntity);
        if (distance < nearestDistance) {
          nearestDistance = distance;
          nearestEntity = livingEntity;
        }
      }
    }

    mob.setTarget(nearestEntity);
  }

  @SubscribeEvent
  public static void onLivingTick(EntityTickEvent.Post event) {
    final Entity entity = event.getEntity();
    if (!(entity.level() instanceof ServerLevel serverLevel)) return;
    boolean inWater = entity.isInWater();

    // Handle water degradation / oxidation component when used by living entities
    if (entity instanceof LivingEntity livingEntity) {
      if (inWater) {
        handleEquippedDegradation(livingEntity, livingEntity.getMainHandItem(), MAINHAND);
        handleEquippedDegradation(livingEntity, livingEntity.getOffhandItem(), EquipmentSlot.OFFHAND);
      }

      handleEquipmentOxidation(serverLevel, livingEntity, livingEntity.getMainHandItem(), MAINHAND);
      handleEquipmentOxidation(serverLevel, livingEntity, livingEntity.getOffhandItem(), EquipmentSlot.OFFHAND);
    }
    // Handle water degradation and oxidation for dropped item
    else if (entity instanceof ItemEntity itemEntity) {
      ItemStack stack = itemEntity.getItem();
      if (!stack.isEmpty() && stack.isDamageableItem() && stack.has(BSDataComponents.DEGRADES_UNDERWATER.get())) {
        stack.hurtAndBreak(1, serverLevel, (LivingEntity) null, brokenItem -> itemEntity.discard());
      }
    }
  }

  public static void handleEquippedDegradation(LivingEntity entity, ItemStack stack, EquipmentSlot slot) {
    if (stack.isEmpty() || !stack.isDamageableItem()) return;

    if (stack.has(BSDataComponents.DEGRADES_UNDERWATER.get())) {
      stack.hurtAndBreak(1, entity, slot);
    }
  }

  public static void handleEquipmentOxidation(ServerLevel level, LivingEntity entity, ItemStack stack, EquipmentSlot slot) {
    if (entity.hasInfiniteMaterials() || stack.isEmpty() || !stack.has(BSDataComponents.OXIDATION_STATE.get())) return;
    if (stack.getOrDefault(BSDataComponents.WAXED.get(), false)) return;

    WeatheringCopperCollection<DeferredItem<Item>> activeCollection = null;
    Item currentItem = stack.getItem();
    if (BSItems.COPPER_SHIELD.asList().stream().anyMatch(holder -> holder.get() == currentItem)) {
      activeCollection = BSItems.COPPER_SHIELD;
    }
    else if (BSItems.GILDED_COPPER_SHIELD.asList().stream().anyMatch(holder -> holder.get() == currentItem)) {
      activeCollection = BSItems.GILDED_COPPER_SHIELD;
    }
    if (activeCollection == null) return;

    WeatheringCopper.WeatherState currentState = stack.get(BSDataComponents.OXIDATION_STATE.get());

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

      Item nextTierItem = activeCollection.weathering().pick(nextState).get();
      ItemStack nextStack = new ItemStack(nextTierItem, stack.getCount());

      nextStack.applyComponents(stack.getComponentsPatch());
      nextStack.set(BSDataComponents.OXIDATION_STATE.get(), nextState);

      entity.setItemSlot(slot, nextStack);
    }
  }
}
