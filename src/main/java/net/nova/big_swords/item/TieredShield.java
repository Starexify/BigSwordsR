package net.nova.big_swords.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ToolMaterial;
import net.nova.big_swords.init.BSItems;
import org.jetbrains.annotations.Nullable;

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

/*    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        String perk = BuiltInRegistries.ITEM.getKey(pStack.getItem()) + ".perk";
        String weakness = BuiltInRegistries.ITEM.getKey(pStack.getItem()) + ".weakness";

        pTooltipComponents.add(Component.translatable(perk).withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable(weakness).withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.empty());
    }*/

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
