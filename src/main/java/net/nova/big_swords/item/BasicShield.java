package net.nova.big_swords.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BasicShield extends ShieldItem {
    private final Tier tier;

    public BasicShield(Tier pTier, Properties pProperties) {
        super(pProperties.durability(pTier.getUses() * 2));
        this.tier = pTier;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        String perk = BuiltInRegistries.ITEM.getKey(pStack.getItem()) + ".perk";
        String weakness = BuiltInRegistries.ITEM.getKey(pStack.getItem()) + ".weakness";

        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.translatable(perk).withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable(weakness).withStyle(ChatFormatting.GRAY));
    }

    // Tier Stuff
    public Tier getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return this.tier.getRepairIngredient().test(pRepair) || super.isValidRepairItem(pToRepair, pRepair);
    }
}