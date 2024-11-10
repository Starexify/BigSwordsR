package net.nova.big_swords.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;

public class BigSwordItem extends SwordItem {
    private final int customDurability;

    public BigSwordItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Properties properties) {
        super(toolMaterial.applySwordProperties(properties, attackDamage, attackSpeed));
        this.customDurability = toolMaterial.durability() * 2;
    }

/*    public BigSwordItem(ToolMaterial pTier, Properties pProperties) {
        super(pTier, pProperties);
        this.customDurability = pTier.getUses() * 2;
    }*/

    @Override
    public int getMaxDamage(ItemStack stack) {
        return this.customDurability;
    }
}
