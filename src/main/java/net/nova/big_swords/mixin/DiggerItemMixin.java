package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import net.nova.big_swords.item.ScytheItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DiggerItem.class)
public class DiggerItemMixin {
    @WrapOperation(method = "<init>",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ToolMaterial;applyToolProperties(Lnet/minecraft/world/item/Item$Properties;Lnet/minecraft/tags/TagKey;FF)Lnet/minecraft/world/item/Item$Properties;"))
    private static Item.Properties scytheInit(ToolMaterial instance, Item.Properties properties, TagKey<Block> mineableBlocks, float attackDamage, float attackSpeed, Operation<Item.Properties> original) {
        if (ScytheItem.isScythe.get()) {
            ScytheItem.isScythe.set(false);
            return properties;
        }
        return original.call(instance, properties, mineableBlocks, attackDamage, attackSpeed);
    }
}
