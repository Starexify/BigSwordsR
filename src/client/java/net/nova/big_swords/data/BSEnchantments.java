package net.nova.big_swords.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.nova.big_swords.enchantments.effects.SoulStealEffect;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSEnchantmentEffects;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BSEnchantments extends FabricDynamicRegistryProvider {
    public BSEnchantments(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        HolderLookup<Enchantment> registryEntryLookup = provider.lookupOrThrow(Registries.ENCHANTMENT);
        HolderLookup<Item> registryEntryLookup1 = provider.lookupOrThrow(Registries.ITEM);

        register(entries, BSEnchantmentEffects.SOUL_STEALER, Enchantment.enchantment(
                        Enchantment.definition(
                                registryEntryLookup1.getOrThrow(Tags.BSItemTags.SCYTHES),
                                2,
                                3,
                                Enchantment.dynamicCost(17, 8),
                                Enchantment.dynamicCost(36, 8),
                                3,
                                EquipmentSlotGroup.MAINHAND
                        ))
                .exclusiveWith(registryEntryLookup.getOrThrow(Tags.EnchantmentTags.SCYTHE_EXCLUSIVE))
                .withEffect(
                        BSDataComponents.POST_DEATH,
                        EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM,
                        new SoulStealEffect(LevelBasedValue.perLevel(0.3F), new ItemStack(BSItems.SOUL))
                )
        );
    }

    public void register(Entries entries, ResourceKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.location()), resourceConditions);
    }

    @Override
    public String getName() {
        return "BSR EnchantmentGenerator";
    }
}
