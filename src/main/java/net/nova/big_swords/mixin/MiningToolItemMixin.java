package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.nova.big_swords.item.ScytheItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MiningToolItem.class)
public class MiningToolItemMixin {
    @WrapOperation(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ToolMaterial;applyToolSettings(Lnet/minecraft/item/Item$Settings;Lnet/minecraft/registry/tag/TagKey;FF)Lnet/minecraft/item/Item$Settings;"))
    private static Item.Settings scytheInit(ToolMaterial instance, Item.Settings settings, TagKey<Block> effectiveBlocks, float attackDamage, float attackSpeed, Operation<Item.Settings> original) {
        if (ScytheItem.isScythe.get()) {
            ScytheItem.isScythe.set(false);
            return settings;
        }
        return original.call(instance, settings, effectiveBlocks, attackDamage, attackSpeed);
    }
}
