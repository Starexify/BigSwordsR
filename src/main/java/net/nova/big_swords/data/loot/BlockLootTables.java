package net.nova.big_swords.data.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BlockLootTables extends BlockLootSubProvider {
    protected BlockLootTables(HolderLookup.Provider pProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pProvider);
    }

    @Override
    protected void generate() {
        dropSelf(BSBlocks.LIVINGMETAL_BLOCK.get());
        dropSelf(BSBlocks.BIOMASS_BLOCK.get());

        // Creep Block Drops
        add(BSBlocks.CREEP_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.SOUL_SAND));

        // Biomass Drops
        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BSBlocks.BIOMASS.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 3));
        add(BSBlocks.BIOMASS.get(), createBiomassDrops(BSBlocks.BIOMASS.get(), BSItems.BIOMASS.get(), BSItems.BIOMASS_SEED.get(), lootitemcondition$builder1));
    }

    protected LootTable.Builder createBiomassDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return this.applyExplosionDecay(
                pCropBlock,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeedsItem)))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(MODID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
