package net.nova.big_swords.item;

import net.minecraft.component.ComponentsAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipAppender;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

import java.util.function.Consumer;

public class BloodVial extends Item implements TooltipAppender {
    public static final int MIN_BLOOD_LEVEL = 1;
    public static final int MAX_BLOOD_LEVEL = 9;

    public BloodVial(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public void appendTooltip(TooltipContext context, Consumer<Text> textConsumer, TooltipType type, ComponentsAccess components) {
        String bloodText = components.getOrDefault(BSDataComponents.BLOOD_LEVEL, 0) == 0 ? "Empty" : "Blood Level: " + components.getOrDefault(BSDataComponents.BLOOD_LEVEL, 0) + " / " + MAX_BLOOD_LEVEL;
        textConsumer.accept(Text.empty());
        textConsumer.accept(Text.literal(bloodText).formatted(Formatting.GRAY));
    }

    @Override
    public ActionResult use(World level, PlayerEntity player, Hand usedHand) {
        ItemStack bloodVialStack = player.getStackInHand(usedHand);
        ItemStack otherHandStack = player.getStackInHand(usedHand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND);

        if (bloodVialStack.getItem() instanceof BloodVial) {
            if (otherHandStack.isOf(Items.SLIME_BALL) && getBloodLevel(bloodVialStack) >= MIN_BLOOD_LEVEL) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.CREEP_BALL);
            }

            if (otherHandStack.isOf(Items.TORCHFLOWER_SEEDS) && getBloodLevel(bloodVialStack) >= MIN_BLOOD_LEVEL) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.BIOMASS_SEED);
            }
        }

        return super.use(level, player, usedHand);
    }

    // Methods
    public ActionResult processInteraction(World level, PlayerEntity player, ItemStack stack, ItemStack otherHandStack, Item resultItem) {
        if (!level.isClient) {
            otherHandStack.decrement(1);
            stack.set(BSDataComponents.BLOOD_LEVEL, getBloodLevel(stack) - 1);
            player.giveItemStack(new ItemStack(resultItem));
        }
        return ActionResult.SUCCESS;
    }

    public void incrementBloodLevel(ItemStack stack) {
        if (getBloodLevel(stack) < MAX_BLOOD_LEVEL) {
            stack.set(BSDataComponents.BLOOD_LEVEL, getBloodLevel(stack) + 1);
        }
    }

    public static void incrementBloodVialInBothHands(PlayerEntity player) {
        incrementBloodVialInHand(player, Hand.MAIN_HAND);
        incrementBloodVialInHand(player, Hand.OFF_HAND);
    }

    public static void incrementBloodVialInHand(PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getStackInHand(hand);
        if (handStack.getItem() instanceof BloodVial bloodVialItem) {
            bloodVialItem.incrementBloodLevel(handStack);
        }
    }

    public static int getBloodLevel(ItemStack stack) {
        return stack.getOrDefault(BSDataComponents.BLOOD_LEVEL, 0);
    }
}
