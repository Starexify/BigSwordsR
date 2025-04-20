package net.nova.big_swords.init;

import net.legacyfabric.fabric.api.registry.v1.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.block.BSBlock;
import net.nova.big_swords.block.BiomassCrop;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.mixin.BlockAccessor;

import java.util.HashMap;
import java.util.Map;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSBlocks {
    private static final Map<String, Item> BLOCK_ITEMS = new HashMap<>();

    public static BSBlock LIVINGMETAL_BLOCK = registerBlockWithItem("livingmetal_block", new BSBlock(Material.SAND, 5.0f, Block.field_7265));
    public static BSBlock BIOMASS_BLOCK = registerBlockWithItem("biomass_block", new BSBlock(Material.STONE, 4.0f, Block.field_7262));
    public static BSBlock CREEP_BLOCK = registerBlockWithItem("creep_block", new CreepBlock(Material.SAND, 1.5f, Block.field_7265));
    public static BiomassCrop BIOMASS = registerBlock("biomass", new BiomassCrop());

    public static void initialize() {
        BigSwordsR.LOGGER.info("Registering Blocks");
    }

    // Methods

    /**
     * Helper method to register a block
     *
     * @param name  The registry name
     * @param block The block instance
     * @return The registered block
     */
    public static <T extends Block> T registerBlock(String name, T block) {
        ((BlockAccessor) block).big_swords$method_5546(MODID + ":" + name);
        if (block instanceof BSBlock) ((BSBlock) block).setBlockName(name);
        RegistryHelper.registerBlock(block, BigSwordsR.rl(name));
        return block;
    }

    /**
     * Helper method to register a block with its item
     *
     * @param name  The registry name
     * @param block The block instance
     * @return The registered block
     */
    public static <T extends Block> T registerBlockWithItem(String name, T block) {
        T blockRef = registerBlock(name, block);
        Item blockItem = BSItems.registerItem(name, () -> new BlockItem(blockRef));
        BLOCK_ITEMS.put(name, blockItem);
        return blockRef;
    }

    /**
     * Get the BlockItem directly from a block reference
     *
     * @param block The block to get the item for
     * @return The corresponding BlockItem
     */
    public static Item getBlockItem(BSBlock block) {
        return BLOCK_ITEMS.get(block.name);
    }
}