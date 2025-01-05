package net.nova.big_swords.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BigSwordItem extends SwordItem {
    public final int customDurability;

    public BigSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.customDurability = material.durability() * 2;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return this.customDurability;
    }
}
