package net.nova.big_swords.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.nova.big_swords.init.BSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ToolMaterial.class)
public class ToolMaterialMixin {
    @ModifyReturnValue(method = "method_6370", at = @At("RETURN"))
    private Item modifyRepairItem(Item original) {
        if ((Object) this == ToolMaterial.valueOf("PATCHWORK")) return Items.ROTTEN_FLESH;
        else if ((Object) this == ToolMaterial.valueOf("SKULL")) return Items.BONE;
        else if ((Object) this == ToolMaterial.valueOf("QUARTZ")) return Items.QUARTZ;
        else if ((Object) this == ToolMaterial.valueOf("OBSIDIAN")) return Item.fromBlock(Blocks.OBSIDIAN);
        else if ((Object) this == ToolMaterial.valueOf("ENDER")) return Items.EYE_OF_ENDER;
        else if ((Object) this == ToolMaterial.valueOf("LIVINGMETAL")) return BSItems.LIVINGMETAL_INGOT;
        else if ((Object) this == ToolMaterial.valueOf("BIOMASS")) return BSItems.BIOMASS;
        else if ((Object) this == ToolMaterial.valueOf("REAPER")) return Items.BONE;
        return original;
    }
}
