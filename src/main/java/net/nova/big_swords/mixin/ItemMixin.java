package net.nova.big_swords.mixin;

import net.minecraft.item.Item;
import net.minecraft.util.registry.IdRegistry;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.registries.DeferredRegister;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
  @Shadow @Final public static IdRegistry<Item> REGISTRY;

  @Inject(method = "init", at = @At("TAIL"))
  private static void big_swords$init(CallbackInfo ci) {
    var trigger = BSItems.ITEMS;
    DeferredRegister.Items.registerItems(REGISTRY);
  }
}
