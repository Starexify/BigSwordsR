package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nova.big_swords.init.BSItems;

import java.util.List;

public class TieredShield extends ShieldItem {
    private final Tier tier;

    public TieredShield(Tier pTier, Properties pProperties) {
        this(pTier, pProperties, 1, 0);
    }

    public TieredShield(Tier pTier, Properties pProperties, int durabilityMultiplier) {
        super(pProperties.durability(pTier.getUses() * durabilityMultiplier));
        this.tier = pTier;
    }

    public TieredShield(Tier pTier, Properties pProperties, int durabilityMultiplier, int additionalDurability) {
        super(pProperties.durability(pTier.getUses() * durabilityMultiplier + additionalDurability));
        this.tier = pTier;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        String perk = BuiltInRegistries.ITEM.getKey(pStack.getItem()) + ".perk";
        String weakness = BuiltInRegistries.ITEM.getKey(pStack.getItem()) + ".weakness";

        pTooltipComponents.add(Component.translatable(perk).withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable(weakness).withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.empty());
    }

    // Tier Stuff
    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return this.tier.getRepairIngredient().test(pRepair) || super.isValidRepairItem(pToRepair, pRepair);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity entity, int pSlotId, boolean pIsSelected) {
        // Iron Shields Weakness
        if (entity instanceof LivingEntity livingEntity && livingEntity.isInWater()) {
            if (pStack.getItem() == BSItems.IRON_SHIELD.get() || pStack.getItem() == BSItems.GILDED_IRON_SHIELD.get()) {
                boolean isIronShieldInMainHand = livingEntity.getMainHandItem() == pStack;
                boolean isIronShieldInOffHand = livingEntity.getOffhandItem() == pStack;

                if ((isIronShieldInMainHand || isIronShieldInOffHand) && pStack.isDamageableItem()) {
                    pStack.hurtAndBreak(1, livingEntity, livingEntity.getEquipmentSlotForItem(pStack));
                }
            }
        }
    }
}
