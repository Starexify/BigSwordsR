package net.nova.big_swords.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoulSandBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import static net.nova.big_swords.BigSwordsR.MODID;
import static net.nova.big_swords.BigSwordsR.playSound;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class GameEvents {

    // Shield Mechanics

    // Wooden + Stone
    @SubscribeEvent
    public static void onArrowImpact(ProjectileImpactEvent event) {
        if (!(event.getProjectile() instanceof Arrow arrow) || !(arrow.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        Player woodenShieldHolder = findPlayerWithShield(serverLevel, arrow, BSItems.WOODEN_SHIELD.get());
        if (woodenShieldHolder != null) {
            catchArrowWithWoodenShield(woodenShieldHolder, arrow);
        }

        Player stoneShieldHolder = findPlayerWithShield(serverLevel, arrow, BSItems.STONE_SHIELD.get());
        if (stoneShieldHolder != null) {
            if (arrow.isOnFire()) {
                catchArrowWithStoneShield(stoneShieldHolder, arrow);
                event.setCanceled(true);
            }
        }
    }

    private static Player findPlayerWithShield(ServerLevel serverLevel, Arrow arrow, Item shieldItem) {
        return serverLevel.players().stream()
                .filter(player -> isPlayerBlockingWithShield(player, arrow, shieldItem))
                .findFirst()
                .orElse(null);
    }

    private static boolean isPlayerBlockingWithShield(Player player, Arrow arrow, Item shieldItem) {
        ItemStack activeItem = player.getUseItem();
        if (activeItem.getItem() != shieldItem) {
            return false;
        }

        // Check if the player has been blocking long enough (5 ticks = 0.25 seconds)
        if (player.getUseItemRemainingTicks() < 5) {
            return false;
        }

        Vec3 playerLook = player.getLookAngle();
        Vec3 arrowMotion = arrow.getDeltaMovement().normalize();
        double dotProduct = playerLook.dot(arrowMotion);

        return dotProduct < -0.5;
    }

    private static void catchArrowWithWoodenShield(Player player, Arrow arrow) {
        ItemStack shieldStack = player.getUseItem();

        if (arrow.isOnFire()) {
            shieldStack.hurtAndBreak(25, player, EquipmentSlot.MAINHAND);
        }

        // Give arrow to player
        ItemStack arrowItemStack = new ItemStack(Items.ARROW);
        if (!player.addItem(arrowItemStack)) {
            player.drop(arrowItemStack, false);
        }
        arrow.discard();
    }

    private static void catchArrowWithStoneShield(Player player, Arrow arrow) {
        ItemStack shieldStack = player.getUseItem();
        BigSwordsR.playSound(player.level(), player, SoundEvents.FIRE_EXTINGUISH);
        player.stopUsingItem();
        arrow.discard();
    }

    // Creep Block
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        ItemStack itemStack = event.getItemStack();
        Player player = event.getEntity();

        if (level.isClientSide()) return;

        if (state.getBlock() instanceof CreepBlock creepBlock) {
            if (itemStack.is(Tags.BSItemTags.GLAIVES) && !state.getValue(CreepBlock.TILLED)) {
                creepBlock.tillBlock(level, pos, state);
                playSound(level, player, SoundEvents.SOUL_ESCAPE.value());
                itemStack.hurtAndBreak(1, event.getEntity(), event.getEntity().getEquipmentSlotForItem(itemStack));
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        } else if (state.getBlock() instanceof SoulSandBlock && itemStack.is(BSItems.CREEP_BALL)) {
            level.setBlock(pos, BSBlocks.CREEP_BLOCK.get().defaultBlockState(), 3);
            playSound(level, player, SoundEvents.SOUL_SAND_BREAK);
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
    }
}
