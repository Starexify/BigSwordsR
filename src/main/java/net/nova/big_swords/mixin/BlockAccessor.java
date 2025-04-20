package net.nova.big_swords.mixin;

import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Block.class)
public interface BlockAccessor {
    @Invoker("method_5546")
    Block big_swords$method_5546(String string);
}
