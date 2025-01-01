package net.nova.data.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nova.init.BSBlocks;
import net.nova.init.BSItems;
import net.nova.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BlockLootTables extends FabricBlockLootTableProvider {
    public BlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Item> itemHolder = this.registries.getOrThrow(RegistryKeys.ITEM);
        addDrop(BSBlocks.LIVINGMETAL_BLOCK);
        addDrop(BSBlocks.BIOMASS_BLOCK);

        // Creep Block Drops
        addDrop(BSBlocks.CREEP_BLOCK, block -> this.drops(block, Blocks.SOUL_SAND));

        // Biomass Drops
        LootCondition.Builder ageCondition = BlockStatePropertyLootCondition.builder(BSBlocks.BIOMASS)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 3));
        LootCondition.Builder scytheCondition = EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().equipment(
                EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(itemHolder, Tags.BSItemTags.SCYTHES)).build()).build());
        addDrop(BSBlocks.BIOMASS, createBiomassDrops(BSBlocks.BIOMASS, BSItems.BIOMASS, BSItems.BIOMASS_SEED, ageCondition, scytheCondition));
    }

    // Loot method
    public LootTable.Builder createBiomassDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootCondition.Builder pDropGrownCropCondition, LootCondition.Builder scytheCondition) {
        return this.applyExplosionDecay(
                pCropBlock, LootTable.builder()
                        .pool(LootPool.builder().with(ItemEntry.builder(pGrownCropItem).conditionally(pDropGrownCropCondition)))
                        .pool(LootPool.builder().with(ItemEntry.builder(pGrownCropItem).conditionally(scytheCondition).conditionally(pDropGrownCropCondition)))
                        .pool(LootPool.builder().with(ItemEntry.builder(pSeedsItem)))
        );
    }
}
