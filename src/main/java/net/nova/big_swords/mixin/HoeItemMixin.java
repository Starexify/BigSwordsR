package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.nova.big_swords.item.ScytheItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HoeItem.class)
public abstract class HoeItemMixin {
    @WrapOperation(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;hoe(Lnet/minecraft/world/item/ToolMaterial;FF)Lnet/minecraft/world/item/Item$Properties;"))
    private static Item.Properties scytheInit(Item.Properties properties, ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Operation<Item.Properties> original) {
        if (ScytheItem.isScythe.get()) {
            ScytheItem.isScythe.set(false);
            return properties;
        }
        return original.call(properties, toolMaterial, attackDamage, attackSpeed);
    }
}
