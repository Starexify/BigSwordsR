package net.nova.big_swords.item;

import net.minecraft.world.item.Tier;

public class GildedTieredShield extends TieredShield {
    public GildedTieredShield(Tier tier, Properties properties) {
        super(tier, properties.durability(tier.getUses() * 4));
    }
}
