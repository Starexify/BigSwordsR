package net.nova.big_swords.client.renderer.item;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.nova.big_swords.item.BloodVial;

import javax.annotation.Nullable;

public class BloodLevelModelProperty implements RangeSelectItemModelProperty {
    public static final MapCodec<BloodLevelModelProperty> MAP_CODEC = MapCodec.unit(new BloodLevelModelProperty());

    @Override
    public float get(ItemStack item, @javax.annotation.Nullable ClientLevel clientLevel, @Nullable LivingEntity entity, int p_388371_) {
        return BloodVial.getBloodLevel(item);
    }

    @Override
    public MapCodec<? extends RangeSelectItemModelProperty> type() {
        return MAP_CODEC;
    }
}
