package net.nova.big_swords.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.enchantments.effects.SoulStealEffect;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

public class BSEnchantments {
    public static final ResourceKey<Enchantment> SOUL_STEALER = key("soul_stealer");

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Enchantment> holdergetter1 = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> holdergetter2 = context.lookup(Registries.ITEM);

        register(context, SOUL_STEALER, Enchantment.enchantment(
                        Enchantment.definition(
                                holdergetter2.getOrThrow(Tags.BSItemTags.SCYTHES),
                                2,
                                3,
                                Enchantment.dynamicCost(17, 8),
                                Enchantment.dynamicCost(36, 8),
                                3,
                                EquipmentSlotGroup.MAINHAND
                        ))
                .exclusiveWith(holdergetter1.getOrThrow(Tags.EnchantmentTags.SCYTHE_EXCLUSIVE))
                .withCustomName(component -> Component.literal("Soul Stealer"))
                .withEffect(
                        BSDataComponents.POST_DEATH.get(),
                        EnchantmentTarget.VICTIM,
                        EnchantmentTarget.ATTACKER,
                        new SoulStealEffect(new AddValue(LevelBasedValue.perLevel(0.3F, 0.3F)).value(), new ItemStack(BSItems.SOUL.get()))
                )
        );
    }

    public static void register(BootstrapContext<Enchantment> pContext, ResourceKey<Enchantment> pKey, Enchantment.Builder pBuilder) {
        pContext.register(pKey, pBuilder.build(pKey.location()));
    }

    public static ResourceKey<Enchantment> key(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, BigSwordsR.rl(name));
    }
}
