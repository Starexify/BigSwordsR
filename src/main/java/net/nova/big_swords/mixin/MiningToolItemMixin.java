package net.nova.big_swords.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MiningToolItem.class)
public class MiningToolItemMixin extends Item {
    public MiningToolItemMixin(Settings settings) {
        super(settings);
    }


}
