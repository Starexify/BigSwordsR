package net.nova.big_swords.init;

import net.legacyfabric.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.itemgroup.ItemGroup;
import net.nova.big_swords.BigSwordsR;

public class CreativeTabs {
    public static final ItemGroup BIG_SWORDS_TAB = FabricItemGroupBuilder
            .create(BigSwordsR.rl("big_swords"))
            .iconWithItem(() -> Items.APPLE)
            .appendItems((items, group) -> {
                items.add(new ItemStack(Items.APPLE));
/*                items.add(new ItemStack(BSItems.GIANT_WOODEN_STICK));
                items.add(new ItemStack(BSItems.GIANT_BLAZE_ROD));
                items.add(new ItemStack(BSItems.GIANT_LIVINGMETAL_HANDLE));*/
            })
            .build();

    public static void initialize() {

    }
}