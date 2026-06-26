package net.nova.big_swords.mixin;

import com.google.common.collect.ImmutableList;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.SmithingTemplateItem;
import net.nova.big_swords.BigSwordsR;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(SmithingTemplateItem.class)
public class SmithingTemplateItemMixin {
  @Unique
  private static final Identifier EMPTY_SLOT_SCYTHE = BigSwordsR.rl("container/slot/scythe");
  @Unique
  private static final Identifier EMPTY_SLOT_GLAIVE = BigSwordsR.rl("container/slot/glaive");
  @Unique
  private static final Identifier EMPTY_SLOT_BIG_SWORD = BigSwordsR.rl("container/slot/big_sword");

  @ModifyReturnValue(method = "createTrimmableMaterialIconList", at = @At(value = "RETURN"))
  private static List<Identifier> redirectListCreation(List<Identifier> original) {
    return ImmutableList.<Identifier>builder()
        .addAll(original)
        .add(EMPTY_SLOT_SCYTHE, EMPTY_SLOT_GLAIVE, EMPTY_SLOT_BIG_SWORD)
        .build();
  }
}