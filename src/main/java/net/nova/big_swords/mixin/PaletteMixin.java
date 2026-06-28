package net.nova.big_swords.mixin;

import net.minecraft.world.item.equipment.trim.TrimMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TrimMaterials.Palette.class)
enum PaletteMixin {
  BIG_SWORDS_LIVINGMETAL("livingmetal"),
  BIG_SWORDS_LIVINGMETAL_DARKER("livingmetal_darker");

  @Shadow
  PaletteMixin(String name) {}
}
