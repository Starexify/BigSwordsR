package net.nova.big_swords.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

public class BloodVial extends Item {
    public static final int MIN_BLOOD_LEVEL = 1;
    public static final int MAX_BLOOD_LEVEL = 9;

    public BloodVial(Properties properties) {
        super(properties.stacksTo(1));
    }

/*    @Override
    public void appendTooltip(TooltipContext context, Consumer<Text> textConsumer, TooltipType type, ComponentsAccess components) {
        String bloodText = components.getOrDefault(BSDataComponents.BLOOD_LEVEL, 0) == 0 ? "Empty" : "Blood Level: " + components.getOrDefault(BSDataComponents.BLOOD_LEVEL, 0) + " / " + MAX_BLOOD_LEVEL;
        textConsumer.accept(Text.empty());
        textConsumer.accept(Text.literal(bloodText).formatted(Formatting.GRAY));
    }*/

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        ItemStack bloodVialStack = player.getItemInHand(usedHand);
        ItemStack otherHandStack = player.getItemInHand(usedHand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);

        if (bloodVialStack.getItem() instanceof BloodVial) {
            if (otherHandStack.is(Items.SLIME_BALL) && getBloodLevel(bloodVialStack) >= MIN_BLOOD_LEVEL) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.CREEP_BALL);
            }

            if (otherHandStack.is(Items.TORCHFLOWER_SEEDS) && getBloodLevel(bloodVialStack) >= MIN_BLOOD_LEVEL) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.BIOMASS_SEED);
            }
        }

        return super.use(level, player, usedHand);
    }

    // Methods
    public InteractionResult processInteraction(Level level, Player player, ItemStack stack, ItemStack otherHandStack, Item resultItem) {
        if (!level.isClientSide) {
            otherHandStack.shrink(1);
            stack.set(BSDataComponents.BLOOD_LEVEL, getBloodLevel(stack) - 1);
            player.addItem(new ItemStack(resultItem));
        }
        return InteractionResult.SUCCESS;
    }

    public void incrementBloodLevel(ItemStack stack) {
        if (getBloodLevel(stack) < MAX_BLOOD_LEVEL) {
            stack.set(BSDataComponents.BLOOD_LEVEL, getBloodLevel(stack) + 1);
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
}
