package net.nova.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nova.enchantments.effects.SoulStealEffect;
import net.nova.init.BSEnchantmentEffects;
import net.nova.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSEnchantments extends FabricDynamicRegistryProvider {
    public BSEnchantments(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        RegistryEntryLookup<Enchantment> registryEntryLookup = wrapperLookup.getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntryLookup<Item> registryEntryLookup1 = wrapperLookup.getOrThrow(RegistryKeys.ITEM);

        register(entries, BSEnchantmentEffects.SOUL_STEALER, Enchantment.builder(
                        Enchantment.definition(
                                registryEntryLookup1.getOrThrow(Tags.BSItemTags.SCYTHES),
                                2,
                                3,
                                Enchantment.leveledCost(17, 8),
                                Enchantment.leveledCost(36, 8),
                                3,
                                AttributeModifierSlot.MAINHAND
                        ))
                .exclusiveSet(registryEntryLookup.getOrThrow(Tags.EnchantmentTags.SCYTHE_EXCLUSIVE))
                .addEffect(
                        EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new SoulStealEffect(0)
                )
        );
    }

    public void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "BSR EnchantmentGenerator";
    }
}
