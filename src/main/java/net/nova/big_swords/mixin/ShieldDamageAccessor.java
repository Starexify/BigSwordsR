package net.nova.big_swords.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PlayerEntity.class)
public interface ShieldDamageAccessor {
    @Invoker("damageShield")
    void big_swords$damageShield(float action);
}