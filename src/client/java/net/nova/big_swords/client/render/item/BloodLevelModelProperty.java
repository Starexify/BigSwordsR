package net.nova.big_swords.client.render.item;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.render.item.property.numeric.NumericProperty;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.nova.big_swords.item.BloodVial;
import org.jetbrains.annotations.Nullable;

public class BloodLevelModelProperty implements NumericProperty {
    public static final MapCodec<BloodLevelModelProperty> CODEC = MapCodec.unit(new BloodLevelModelProperty());

    @Override
    public float getValue(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity holder, int seed) {
        return BloodVial.getBloodLevel(stack);
    }

    @Override
    public MapCodec<? extends NumericProperty> getCodec() {
        return CODEC;
    }
}
