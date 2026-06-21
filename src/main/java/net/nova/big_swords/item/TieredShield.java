package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class TieredShield extends ShieldItem {
  public TieredShield(Properties properties) {
    super(properties);
  }

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> textConsumer, TooltipFlag tooltipFlag) {
    super.appendHoverText(stack, context, tooltipDisplay, textConsumer, tooltipFlag);

    String perk = BuiltInRegistries.ITEM.getKey(stack.getItem()) + ".perk";
    String weakness = BuiltInRegistries.ITEM.getKey(stack.getItem()) + ".weakness";

    textConsumer.accept(Component.translatable(perk).withStyle(ChatFormatting.GRAY));
    textConsumer.accept(Component.translatable(weakness).withStyle(ChatFormatting.GRAY));
    textConsumer.accept(Component.empty());
  }
}
