package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.item.GlaiveItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public final class ItemStackMixin {
    @ModifyVariable(method = "appendAttributeModifierTooltip", at = @At("STORE"), ordinal = 1, argsOnly = true)
    private boolean bsrModifyAttributeModifierTooltip(boolean b, @Local(argsOnly = true) Consumer<Text> textConsumer, @Local(argsOnly = true) @Nullable PlayerEntity player, @Local(argsOnly = true) EntityAttributeModifier modifier) {
        double value = modifier.value();
        boolean bool = false;
        if (player != null) {
            if (modifier.idMatches(BSToolMaterial.MIN_CHARGED_DAMAGE_ID)) {
                bool = true;
            } else if (modifier.idMatches(BSToolMaterial.MAX_CHARGED_DAMAGE_ID)) {
                bool = true;
            }
        }

        if (bool) {
            textConsumer.accept(ScreenTexts.space().append(Text.translatable(
                            "attribute.modifier.equals." + modifier.operation().getId(),
                            AttributeModifiersComponent.DECIMAL_FORMAT.format(value),
                            Text.translatable("attribute.name.charged_damage")
                    )).formatted(Formatting.DARK_GREEN)
            );
        }

        if ((Object) this instanceof GlaiveItem glaiveItem) {
            textConsumer.accept(
                    Text.literal(" " + AttributeModifiersComponent.DECIMAL_FORMAT.format(glaiveItem.range) + " Range").formatted(Formatting.DARK_GREEN)
            );
        }
        return b;
    }
}