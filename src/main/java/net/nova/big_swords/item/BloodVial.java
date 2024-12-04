package net.nova.big_swords.item;

import net.minecraft.world.item.Item;

public class BloodVial extends Item {
    public static final int MAX_BLOOD_LEVEL = 9;

    public BloodVial(Properties properties) {
        super(properties.stacksTo(1));
    }
}
