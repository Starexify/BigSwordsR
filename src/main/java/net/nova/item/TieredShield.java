package net.nova.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.nova.init.BSItems;

import java.util.List;

public class TieredShield extends ShieldItem {
    public final ToolMaterial toolMaterial;

    public TieredShield(ToolMaterial toolMaterial, Settings properties) {
        this(toolMaterial, properties, 1, 0);
    }

    public TieredShield(ToolMaterial toolMaterial, Settings properties, int durabilityMultiplier) {
        super(properties.maxDamage(toolMaterial.durability() * durabilityMultiplier));
        this.toolMaterial = toolMaterial;
    }

    public TieredShield(ToolMaterial toolMaterial, Settings properties, int durabilityMultiplier, int additionalDurability) {
        super(properties.maxDamage(toolMaterial.durability() * durabilityMultiplier + additionalDurability));
        this.toolMaterial = toolMaterial;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);

        tooltip.add(Text.translatable(this + ".perk").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(this + ".weakness").formatted(Formatting.GRAY));
        tooltip.add(Text.empty());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // Iron Shields Weakness
        if (entity instanceof LivingEntity livingEntity && livingEntity.isTouchingWater()) {
            if (stack.getItem() == BSItems.IRON_SHIELD || stack.getItem() == BSItems.GILDED_IRON_SHIELD) {
                boolean isIronShieldInMainHand = livingEntity.getMainHandStack() == stack;
                boolean isIronShieldInOffHand = livingEntity.getOffHandStack() == stack;

                if ((isIronShieldInMainHand || isIronShieldInOffHand) && stack.isDamageable()) {
                    stack.damage(1, livingEntity, livingEntity.getPreferredEquipmentSlot(stack));
                }
            }
        }
    }
}
