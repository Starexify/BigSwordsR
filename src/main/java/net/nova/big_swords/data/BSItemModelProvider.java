package net.nova.big_swords.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.big_swords.init.BSItems;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItemModelProvider extends ItemModelProvider {
    public BSItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Sticks
        basicItem(BSItems.GIANT_WOODEN_STICK.get());
        basicItem(BSItems.GIANT_BLAZE_ROD.get());
        basicItem(BSItems.GIANT_LIVINGMETAL_HANDLE.get());

        // Livingmetal Models
        basicItem(BSItems.LIVINGMETAL_INGOT.get());

        // Ender Upgrade
        basicItem(BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get());

        // Big Swords
        handheldItem(BSItems.WOODEN_BIG_SWORD.get());
        handheldItem(BSItems.STONE_BIG_SWORD.get());
        handheldItem(BSItems.IRON_BIG_SWORD.get());
        handheldItem(BSItems.GOLDEN_BIG_SWORD.get());
        handheldItem(BSItems.DIAMOND_BIG_SWORD.get());
        handheldItem(BSItems.NETHERITE_BIG_SWORD.get());
        handheldItem(BSItems.PATCHWORK_BIG_SWORD.get());
        handheldItem(BSItems.SKULL_BIG_SWORD.get());
        handheldItem(BSItems.QUARTZ_BIG_SWORD.get());
        handheldItem(BSItems.OBSIDIAN_BIG_SWORD.get());
        handheldItem(BSItems.ENDER_BIG_SWORD.get());
    }

    private void handheldItem(Item item) {
        String name = getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/" + name);
    }

    private String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(MODID + ":", "");
    }
}
