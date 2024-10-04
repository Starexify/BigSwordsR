package net.nova.big_swords.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nova.big_swords.item.CreepBall;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Extra
    //public static RegistryObject<Item> BIOMASS_SEED = ITEMS.register("biomass_seed", () -> new ItemNameBlockItem(BSBlocks.BIOMASS.get(), new Item.Properties()));
    public static RegistryObject<Item> CREEP_BALL = ITEMS.register("creep_ball", () -> new CreepBall(new Item.Properties()));
    public static RegistryObject<Item> SOUL = ITEMS.register("soul", () -> new Item(new Item.Properties()));

}
