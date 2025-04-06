package net.nova.big_swords.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ToolMaterial.class)
public interface ToolMaterialAccessor {
    @Invoker("createSwordAttributes")
    ItemAttributeModifiers big_swords$createSwordAttributes(float attackDamage, float attackSpeed);

    @Invoker("applyCommonProperties")
    Item.Properties big_swords$applyCommonProperties(Item.Properties properties);
}