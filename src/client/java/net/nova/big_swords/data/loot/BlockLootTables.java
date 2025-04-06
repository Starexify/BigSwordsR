package net.nova.big_swords.data.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.util.concurrent.CompletableFuture;

public class BlockLootTables extends FabricBlockLootTableProvider {
    public BlockLootTables(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        HolderLookup.RegistryLookup<Item> itemHolder = this.registries.lookupOrThrow(Registries.ITEM);
        dropSelf(BSBlocks.LIVINGMETAL_BLOCK);
        dropSelf(BSBlocks.BIOMASS_BLOCK);

        // Creep Block Drops
        add(BSBlocks.CREEP_BLOCK, block -> this.createSingleItemTableWithSilkTouch(block, Blocks.SOUL_SAND));

        // Biomass Drops
        LootItemCondition.Builder ageCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BSBlocks.BIOMASS)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 3));
        LootItemCondition.Builder scytheCondition = LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().equipment(
                EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(itemHolder, Tags.BSItemTags.SCYTHES)).build()).build());

        add(BSBlocks.BIOMASS, createBiomassDrops(BSBlocks.BIOMASS, BSItems.BIOMASS, BSItems.BIOMASS_SEED, ageCondition, scytheCondition));
    }

    // Loot method
    public LootTable.Builder createBiomassDrops(Block cropBlock, Item grownCropItem, Item seedsItem, LootItemCondition.Builder dropGrownCropCondition, LootItemCondition.Builder scytheCondition) {
        return this.applyExplosionDecay(
                cropBlock, LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(grownCropItem).when(dropGrownCropCondition)))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(grownCropItem).when(scytheCondition).when(dropGrownCropCondition)))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(seedsItem)))
        );
    }
}
