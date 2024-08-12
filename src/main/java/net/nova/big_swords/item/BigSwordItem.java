package net.nova.big_swords.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class BigSwordItem extends SwordItem {
    private final int customDurability;

    public BigSwordItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
        this.customDurability = pTier.getUses() * 2;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return this.customDurability;
    }
}
