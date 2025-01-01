package net.nova.init;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class BSToolMaterial {
    public static final ToolMaterial PATCHWORK = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 30, 1.0F, -1.5F, 16, Tags.BSItemTags.PATCHWORK_TOOL_MATERIALS);
    public static final ToolMaterial SKULL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 103, 2.0F, -0.5F, 13, Tags.BSItemTags.SKULL_TOOL_MATERIALS);
    public static final ToolMaterial QUARTZ = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 187, 5.0F, 1.0F, 17, Tags.BSItemTags.QUARTZ_TOOL_MATERIALS);
    public static final ToolMaterial OBSIDIAN = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1171, 9.0F, 3.5F, 12, Tags.BSItemTags.OBSIDIAN_TOOL_MATERIALS);
    public static final ToolMaterial ENDER = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3046, 12.0F, 5.5F, 18, Tags.BSItemTags.ENDER_TOOL_MATERIALS);
    public static final ToolMaterial LIVINGMETAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 7.5F, 2.5F, 16, Tags.BSItemTags.LIVINGMETAL_TOOL_MATERIALS);
    public static final ToolMaterial BIOMASS = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 188, 8.0F, 2.0F, 18, Tags.BSItemTags.BIOMASS_TOOL_MATERIALS);
    public static final ToolMaterial REAPER = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 206, 2.0F, -0.5F, 18, Tags.BSItemTags.REAPER_TOOL_MATERIALS);
}
