package net.nova.big_swords.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSItems;

import java.util.List;
import java.util.Optional;

public class TieredShield extends ShieldItem {
    public TieredShield(ToolMaterial toolMaterial, Settings properties) {
        this(toolMaterial, properties, 1, 0);
    }

    public TieredShield(ToolMaterial toolMaterial, Settings properties, int durabilityMultiplier) {
        super(properties
                .maxDamage(toolMaterial.durability() * durabilityMultiplier)
                .enchantable(toolMaterial.enchantmentValue())
                .repairable(toolMaterial.repairItems())
                .equippableUnswappable(EquipmentSlot.OFFHAND)
                .component(DataComponentTypes.BLOCKS_ATTACKS, new BlocksAttacksComponent(
                        0.25F,
                        1.0F,
                        List.of(new BlocksAttacksComponent.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                        new BlocksAttacksComponent.ItemDamage(3.0F, 1.0F, 1.0F),
                        Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                        Optional.of(SoundEvents.ITEM_SHIELD_BLOCK),
                        Optional.of(SoundEvents.ITEM_SHIELD_BREAK)
                ))
                .component(DataComponentTypes.BREAK_SOUND, SoundEvents.ITEM_SHIELD_BREAK)
        );
    }

    public TieredShield(ToolMaterial toolMaterial, Settings properties, int durabilityMultiplier, int additionalDurability) {
        super(properties
                .maxDamage(toolMaterial.durability() * durabilityMultiplier + additionalDurability)
                .enchantable(toolMaterial.enchantmentValue())
                .repairable(toolMaterial.repairItems())
                .equippableUnswappable(EquipmentSlot.OFFHAND)
                .component(DataComponentTypes.BLOCKS_ATTACKS, new BlocksAttacksComponent(
                        0.25F,
                        1.0F,
                        List.of(new BlocksAttacksComponent.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                        new BlocksAttacksComponent.ItemDamage(3.0F, 1.0F, 1.0F),
                        Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                        Optional.of(SoundEvents.ITEM_SHIELD_BLOCK),
                        Optional.of(SoundEvents.ITEM_SHIELD_BREAK)
                ))
                .component(DataComponentTypes.BREAK_SOUND, SoundEvents.ITEM_SHIELD_BREAK)
        );
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // Iron Shields Weakness
        if (entity instanceof LivingEntity livingEntity && livingEntity.isTouchingWater()) {
            if (stack.getItem() == BSItems.IRON_SHIELD || stack.getItem() == BSItems.GILDED_IRON_SHIELD) {
                boolean isIronShieldInMainHand = livingEntity.getBlockingItem() == stack;
                boolean isIronShieldInOffHand = livingEntity.getBlockingItem() == stack;

                if ((isIronShieldInMainHand || isIronShieldInOffHand) && stack.isDamageable()) {
                    stack.damage(1, livingEntity, livingEntity.getPreferredEquipmentSlot(stack));
                }
            }
        }
    }

/*    @Override
    public void appendTooltip(TooltipContext context, Consumer<Text> textConsumer, TooltipType type, ComponentsAccess components) {
        textConsumer.accept(Text.translatable(this + ".perk").formatted(Formatting.GRAY));
        textConsumer.accept(Text.translatable(this + ".weakness").formatted(Formatting.GRAY));
        textConsumer.accept(Text.empty());
    }*/
}
