package net.nova.big_swords.item;

import net.minecraft.world.item.Tier;

public class GildedTieredShield extends TieredShield {
    public GildedTieredShield(Tier pTier, Properties pProperties) {
        super(pTier, pProperties, 1, 0);
    }

    public GildedTieredShield(Tier pTier, Properties pProperties, int durabilityMultiplier) {
        super(pTier, pProperties, durabilityMultiplier);
    }

    public GildedTieredShield(Tier pTier, Properties pProperties, int durabilityMultiplier, int additionalDurability) {
        super(pTier, pProperties, durabilityMultiplier, additionalDurability);
    }
}
