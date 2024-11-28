package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import java.util.List;

public class BloodVial extends Item {
    public static final int MAX_BLOOD_LEVEL = 9;

    public BloodVial(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        String bloodText = getBloodLevel(stack) == 0 ? "Empty" : "Blood Level: " + getBloodLevel(stack) + " / " + getMaxBloodLevel();

        tooltipComponents.add(Component.empty());
        tooltipComponents.add(Component.literal(bloodText).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack bloodVialStack = usedHand == InteractionHand.MAIN_HAND ?
                player.getMainHandItem() : player.getOffhandItem();
        ItemStack otherHandStack = usedHand == InteractionHand.MAIN_HAND ?
                player.getOffhandItem() : player.getMainHandItem();

        if (bloodVialStack.getItem() instanceof BloodVial &&
                otherHandStack.is(Items.SLIME_BALL) &&
                getBloodLevel(bloodVialStack) >= 1) {

            if (!level.isClientSide) {
                otherHandStack.shrink(1);
                bloodVialStack.set(BSDataComponents.BLOOD_LEVEL, getBloodLevel(bloodVialStack) - 1);

                ItemStack creepBall = new ItemStack(BSItems.CREEP_BALL.get());
                player.addItem(creepBall);
            }

            return InteractionResultHolder.success(bloodVialStack);
        }

        return super.use(level, player, usedHand);
    }

    // Methods
    public void incrementBloodLevel(ItemStack stack) {
        int currentLevel = getBloodLevel(stack);
        if (currentLevel < MAX_BLOOD_LEVEL) {
            stack.set(BSDataComponents.BLOOD_LEVEL, currentLevel + 1);
        }
    }

    public static void incrementBloodVialInBothHands(Player player) {
        incrementBloodVialInHand(player, InteractionHand.MAIN_HAND);
        incrementBloodVialInHand(player, InteractionHand.OFF_HAND);
    }

    public static void incrementBloodVialInHand(Player player, InteractionHand hand) {
        ItemStack handStack = player.getItemInHand(hand);
        if (handStack.getItem() instanceof BloodVial bloodVialItem) {
            bloodVialItem.incrementBloodLevel(handStack);
        }
    }

    public static int getBloodLevel(ItemStack stack) {
        return stack.getOrDefault(BSDataComponents.BLOOD_LEVEL, 0);
    }

    public static int getMaxBloodLevel() {
        return MAX_BLOOD_LEVEL;
    }
}