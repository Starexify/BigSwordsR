package net.nova.big_swords.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSDataComponentTypes;
import net.nova.big_swords.init.BSItems;

import java.util.List;

public class BloodVial extends Item {
    public static final int MAX_BLOOD_LEVEL = 9;

    public BloodVial(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        String bloodText = getBloodLevel(stack) == 0 ? "Empty" : "Blood Level: " + getBloodLevel(stack) + " / " + getMaxBloodLevel();

        tooltip.add(Text.empty());
        tooltip.add(Text.literal(bloodText).formatted(Formatting.GRAY));
    }

    @Override
    public ActionResult use(World level, PlayerEntity player, Hand usedHand) {
        ItemStack bloodVialStack = player.getStackInHand(usedHand);
        ItemStack otherHandStack = player.getStackInHand(usedHand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND);

        if (bloodVialStack.getItem() instanceof BloodVial) {
            if (otherHandStack.isOf(Items.SLIME_BALL) && getBloodLevel(bloodVialStack) >= 1) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.CREEP_BALL);
            }

            if (otherHandStack.isOf(Items.TORCHFLOWER_SEEDS) && getBloodLevel(bloodVialStack) >= 1) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.BIOMASS_SEED);
            }
        }

        return super.use(level, player, usedHand);
    }

    // Methods
    public ActionResult processInteraction(World level, PlayerEntity player, ItemStack bloodVialStack, ItemStack otherHandStack, Item resultItem) {
        if (!level.isClient) {
            otherHandStack.decrement(1);
            bloodVialStack.set(BSDataComponentTypes.BLOOD_LEVEL, getBloodLevel(bloodVialStack) - 1);
            player.giveItemStack(new ItemStack(resultItem));
        }
        return ActionResult.SUCCESS;
    }

    public void incrementBloodLevel(ItemStack stack) {
        int currentLevel = getBloodLevel(stack);
        if (currentLevel < MAX_BLOOD_LEVEL) {
            stack.set(BSDataComponentTypes.BLOOD_LEVEL, currentLevel + 1);
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
        return stack.getOrDefault(BSDataComponentTypes.BLOOD_LEVEL, 0);
    }

    public static int getMaxBloodLevel() {
        return MAX_BLOOD_LEVEL;
    }
}
