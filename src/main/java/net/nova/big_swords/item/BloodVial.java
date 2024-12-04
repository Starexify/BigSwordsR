package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nova.big_swords.init.BSItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BloodVial extends Item {
    public static final int MAX_BLOOD_LEVEL = 9;
    public static final String BLOOD_LEVEL_KEY = "BloodLevel";

    public BloodVial(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, tooltipComponents, tooltipFlag);
        String bloodText = getBloodLevel(stack) == 0 ? "Empty" : "Blood Level: " + getBloodLevel(stack) + " / " + getMaxBloodLevel();

        tooltipComponents.add(Component.empty());
        tooltipComponents.add(Component.literal(bloodText).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack bloodVialStack = player.getItemInHand(usedHand);
        ItemStack otherHandStack = player.getItemInHand(usedHand == InteractionHand.MAIN_HAND ?
                InteractionHand.OFF_HAND :
                InteractionHand.MAIN_HAND);

        if (bloodVialStack.getItem() instanceof BloodVial) {
            if (otherHandStack.is(Items.SLIME_BALL) && getBloodLevel(bloodVialStack) >= 1) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.CREEP_BALL.get());
            }

            if (otherHandStack.is(Items.TORCHFLOWER_SEEDS) && getBloodLevel(bloodVialStack) >= 1) {
                return processInteraction(level, player, bloodVialStack, otherHandStack, BSItems.BIOMASS_SEED.get());
            }
        }

        return super.use(level, player, usedHand);
    }

    // Methods
    public InteractionResultHolder<ItemStack> processInteraction(Level level, Player player, ItemStack bloodVialStack, ItemStack otherHandStack, Item resultItem) {
        if (!level.isClientSide) {
            otherHandStack.shrink(1);
            setBloodLevel(bloodVialStack, getBloodLevel(bloodVialStack) - 1);
            player.addItem(new ItemStack(resultItem));
        }
        return InteractionResultHolder.success(bloodVialStack);
    }

    public void incrementBloodLevel(ItemStack stack) {
        int currentLevel = getBloodLevel(stack);
        if (currentLevel < MAX_BLOOD_LEVEL) {
            setBloodLevel(stack, currentLevel + 1);
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
        CompoundTag tag = stack.getTag();
        return tag != null && tag.contains(BLOOD_LEVEL_KEY) ? tag.getInt(BLOOD_LEVEL_KEY) : 0;
    }

    public void setBloodLevel(ItemStack stack, int level) {
        stack.getOrCreateTag().putInt(BLOOD_LEVEL_KEY, level);
    }

    public static int getMaxBloodLevel() {
        return MAX_BLOOD_LEVEL;
    }
}
