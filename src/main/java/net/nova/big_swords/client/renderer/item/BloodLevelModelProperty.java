package net.nova.big_swords.client.renderer.item;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class BloodLevelModelProperty implements RangeSelectItemModelProperty {

    @Override
    public float get(ItemStack p_388695_, @Nullable ClientLevel p_388363_, @Nullable LivingEntity p_387282_, int p_386614_) {
        return 0;
    }

    @Override
    public MapCodec<? extends RangeSelectItemModelProperty> type() {
        return null;
    }
}
