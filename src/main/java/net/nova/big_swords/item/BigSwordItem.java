package net.nova.big_swords.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.lang.reflect.Field;

public class BigSwordItem extends SwordItem {
    private static final Field attackMultiplierField;

    static {
        try {
            attackMultiplierField = SwordItem.class.getDeclaredField("attackMultiplier");
            attackMultiplierField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Failed to access attackMultiplier field", e);
        }
    }

    public BigSwordItem(ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.setMaxDamage(toolMaterial.method_3399() * 2);
        try {
            attackMultiplierField.setFloat(this, 7.5F + toolMaterial.method_3401());
        } catch (IllegalAccessException e) {
            System.err.println("Failed to modify attack multiplier: " + e.getMessage());
        }
    }
}
