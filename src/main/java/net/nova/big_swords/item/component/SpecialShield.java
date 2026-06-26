package net.nova.big_swords.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.init.BSToolMaterial;

import java.util.function.Consumer;

public record SpecialShield(ToolMaterial material) implements TooltipProvider {
  public static final String SHIFT_HELP_TIP = "tooltip.big_swords.shift.help";

  public static final Codec<SpecialShield> CODEC = RecordCodecBuilder.create(instance ->
      instance.group(
          Codec.STRING.xmap(BSToolMaterial::getMaterialFromId, BSToolMaterial::getIdFromMaterial).fieldOf("material").forGetter(SpecialShield::material)
      ).apply(instance, SpecialShield::new)
  );
  public static final StreamCodec<RegistryFriendlyByteBuf, SpecialShield> STREAM_CODEC = StreamCodec.of(
      (buf, instance) -> buf.writeUtf(BSToolMaterial.getIdFromMaterial(instance.material())),
      buf -> new SpecialShield(BSToolMaterial.getMaterialFromId(buf.readUtf()))
  );

  @Override
  public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
    final String materialKey = BSToolMaterial.getIdFromMaterial(this.material);
    if (BigSwordsR.shiftHandler.getShift()) {
      consumer.accept(Component.translatable("tooltip.big_swords." + materialKey + ".perk.description").withStyle(ChatFormatting.DARK_GREEN));
      consumer.accept(Component.translatable("tooltip.big_swords." + materialKey + ".weakness.description").withStyle(ChatFormatting.RED));
    }
    else {
      consumer.accept(Component.translatable("tooltip.big_swords." + materialKey + ".perk").withStyle(ChatFormatting.DARK_GREEN));
      consumer.accept(Component.translatable("tooltip.big_swords." + materialKey + ".weakness").withStyle(ChatFormatting.RED));
      consumer.accept(Component.translatable(SHIFT_HELP_TIP).withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
    }
    consumer.accept(Component.empty());
  }
}