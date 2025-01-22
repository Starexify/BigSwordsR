package net.nova.big_swords.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSItems;

import java.util.Optional;

public class TieredShield extends ShieldItem {
    public final ToolMaterial toolMaterial;

    public TieredShield(ToolMaterial toolMaterial, Settings properties) {
        this(toolMaterial, properties, 1, 0);
    }

    public TieredShield(ToolMaterial toolMaterial, Settings properties, int durabilityMultiplier) {
        super(properties.maxDamage(toolMaterial.durability() * durabilityMultiplier).enchantable(toolMaterial.enchantmentValue()).repairable(toolMaterial.repairItems()));
        this.toolMaterial = toolMaterial;
    }

    public TieredShield(ToolMaterial toolMaterial, Settings properties, int durabilityMultiplier, int additionalDurability) {
        super(properties.maxDamage(toolMaterial.durability() * durabilityMultiplier + additionalDurability).enchantable(toolMaterial.enchantmentValue()).repairable(toolMaterial.repairItems()));
        this.toolMaterial = toolMaterial;
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        return Optional.of(new TooltipData() {
            public Text getPerk() {
                return Text.translatable(this + ".perk").formatted(Formatting.GRAY);
            }

            public Text getWeakness() {
                return Text.translatable(this + ".weakness").formatted(Formatting.GRAY);
            }
        });
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
