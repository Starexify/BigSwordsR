package net.nova.big_swords.mixin;

import net.minecraft.block.Block;
import net.minecraft.util.registry.IdRegistry;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.registries.DeferredRegister;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {
  @Shadow @Final public static IdRegistry<Block> REGISTRY;

  @Inject(method = "init", at = @At("TAIL"))
  private static void big_swords$init(CallbackInfo ci) {
    var trigger = BSBlocks.BLOCKS;
    DeferredRegister.Blocks.registerBlocks(REGISTRY);
  }
}