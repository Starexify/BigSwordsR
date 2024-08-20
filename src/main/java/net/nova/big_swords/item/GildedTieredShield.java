package net.nova.big_swords.item;

import net.minecraft.world.item.Tier;

public class GildedTieredShield extends TieredShield {
    public GildedTieredShield(Tier pTier, Properties pProperties) {
        super(pTier, pProperties, 1);
    }

    public GildedTieredShield(Tier pTier, Properties pProperties, int durabilityMultiplier) {
        super(pTier, pProperties, durabilityMultiplier);
    }
}
