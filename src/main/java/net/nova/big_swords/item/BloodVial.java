package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import java.util.function.Consumer;

public class BloodVial extends Item {
  public static final int MIN_BLOOD_LEVEL = 1;
  public static final int MAX_BLOOD_LEVEL = 9;

  public BloodVial(Properties properties) {
    super(properties.stacksTo(1));
  }

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> textConsumer, TooltipFlag tooltipFlag) {
    super.appendHoverText(stack, context, tooltipDisplay, textConsumer, tooltipFlag);
    String bloodText = stack.getComponents().getOrDefault(BSDataComponents.BLOOD_LEVEL, 0) == 0 ? "Empty" : "Blood Level: " + stack.getComponents().getOrDefault(BSDataComponents.BLOOD_LEVEL, 0) + " / " + MAX_BLOOD_LEVEL;
    textConsumer.accept(Component.empty());
    textConsumer.accept(Component.literal(bloodText).withStyle(ChatFormatting.GRAY));
  }

  @Override
  public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
    ItemStack bloodVialStack = player.getItemInHand(usedHand);
    ItemStack otherHandStack = player.getItemInHand(usedHand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);

    if (bloodVialStack.getItem() instanceof BloodVial) {
      if (otherHandStack.is(Items.SLIME_BALL) && getBloodLevel(bloodVialStack) >= MIN_BLOOD_LEVEL)
        return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.CREEP_BALL.get());

      if (otherHandStack.is(Items.TORCHFLOWER_SEEDS) && getBloodLevel(bloodVialStack) >= MIN_BLOOD_LEVEL)
        return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.BIOMASS_SEEDS.get());
    }

    return super.use(level, player, usedHand);
  }

  // Methods
  public InteractionResult processInteraction(Level level, Player player, ItemStack bloodVialStack, ItemStack otherHandStack, Item resultItem) {
    BigSwordsR.playSound(level, player, SoundEvents.BOTTLE_EMPTY);
    if (!level.isClientSide()) {
      otherHandStack.shrink(1);
      bloodVialStack.set(BSDataComponents.BLOOD_LEVEL, getBloodLevel(bloodVialStack) - 1);

      ItemStack resultStack = new ItemStack(resultItem);
      if (!player.addItem(resultStack)) player.drop(resultStack, false);
    }
    return InteractionResult.SUCCESS;
  }

  public void incrementBloodLevel(Player player, ItemStack stack) {
    if (getBloodLevel(stack) < MAX_BLOOD_LEVEL) {
      BigSwordsR.playSound(player.level(), player, SoundEvents.BOTTLE_FILL);
      stack.set(BSDataComponents.BLOOD_LEVEL, getBloodLevel(stack) + 1);
    }
  }

  public static void incrementBloodVialInBothHands(Player player) {
    incrementBloodVialInHand(player, InteractionHand.MAIN_HAND);
    incrementBloodVialInHand(player, InteractionHand.OFF_HAND);
  }

  public static void incrementBloodVialInHand(Player player, InteractionHand hand) {
    ItemStack handStack = player.getItemInHand(hand);
    if (handStack.getItem() instanceof BloodVial bloodVialItem) bloodVialItem.incrementBloodLevel(player, handStack);
  }

  public static int getBloodLevel(ItemStack stack) {
    return stack.getOrDefault(BSDataComponents.BLOOD_LEVEL, 0);
  }
}
