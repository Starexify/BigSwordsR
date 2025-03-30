package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.nova.big_swords.init.BSItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class TieredShield extends ShieldItem {
    public TieredShield(ToolMaterial toolMaterial, Properties properties) {
        this(toolMaterial, properties.enchantable(toolMaterial.enchantmentValue())
                .repairable(toolMaterial.repairItems())
                .equippableUnswappable(EquipmentSlot.OFFHAND)
                .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK), 1, 0);
    }

    public TieredShield(ToolMaterial toolMaterial, Properties properties, int durabilityMultiplier) {
        super(properties.durability(toolMaterial.durability() * durabilityMultiplier)
                .enchantable(toolMaterial.enchantmentValue())
                .repairable(toolMaterial.repairItems())
                .equippableUnswappable(EquipmentSlot.OFFHAND)
                .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK));
    }

    public TieredShield(ToolMaterial toolMaterial, Properties properties, int durabilityMultiplier, int additionalDurability) {
        super(properties.durability(toolMaterial.durability() * durabilityMultiplier + additionalDurability)
                .enchantable(toolMaterial.enchantmentValue())
                .repairable(toolMaterial.repairItems())
                .equippableUnswappable(EquipmentSlot.OFFHAND)
                .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK));
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

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slotId) {
        // Iron Shields Weakness
        if (entity instanceof LivingEntity livingEntity && livingEntity.isInWater()) {
            if (stack.getItem() == BSItems.IRON_SHIELD.get() || stack.getItem() == BSItems.GILDED_IRON_SHIELD.get()) {
                boolean isIronShieldInMainHand = livingEntity.getMainHandItem() == stack;
                boolean isIronShieldInOffHand = livingEntity.getOffhandItem() == stack;

                if ((isIronShieldInMainHand || isIronShieldInOffHand) && stack.isDamageableItem()) {
                    stack.hurtAndBreak(1, livingEntity, livingEntity.getEquipmentSlotForItem(stack));
                }
            }
        }
    }
}
