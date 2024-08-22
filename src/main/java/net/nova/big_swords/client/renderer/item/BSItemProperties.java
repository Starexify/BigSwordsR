package net.nova.big_swords.client.renderer.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.nova.big_swords.init.BSItems;

@OnlyIn(Dist.CLIENT)
public class BSItemProperties {
    public static ResourceLocation blockingPredicate = ResourceLocation.withDefaultNamespace("blocking");

    public static void addCustomItemProperties() {
        makeShield(BSItems.WOODEN_SHIELD.get());
        makeShield(BSItems.GILDED_WOODEN_SHIELD.get());
        makeShield(BSItems.STONE_SHIELD.get());
        makeShield(BSItems.GILDED_STONE_SHIELD.get());
        makeShield(BSItems.IRON_SHIELD.get());
        makeShield(BSItems.GILDED_IRON_SHIELD.get());
        makeShield(BSItems.DIAMOND_SHIELD.get());
        makeShield(BSItems.GILDED_DIAMOND_SHIELD.get());
        makeShield(BSItems.NETHERITE_SHIELD.get());
        makeShield(BSItems.GILDED_NETHERITE_SHIELD.get());
        makeShield(BSItems.ENDER_SHIELD.get());
        makeShield(BSItems.GILDED_ENDER_SHIELD.get());
        makeShield(BSItems.QUARTZ_SHIELD.get());
        makeShield(BSItems.GILDED_QUARTZ_SHIELD.get());
        makeShield(BSItems.PATCHWORK_SHIELD.get());
        makeShield(BSItems.GILDED_PATCHWORK_SHIELD.get());
        makeShield(BSItems.SKULL_SHIELD.get());
        makeShield(BSItems.GILDED_SKULL_SHIELD.get());
        makeShield(BSItems.BIOMASS_SHIELD.get());
        makeShield(BSItems.GILDED_BIOMASS_SHIELD.get());
        makeShield(BSItems.LIVINGMETAL_SHIELD.get());
        makeShield(BSItems.GILDED_LIVINGMETAL_SHIELD.get());
    }

    private static void makeShield(Item item) {
        ItemProperties.register(item, blockingPredicate,
                (p_174575_, p_174576_, p_174577_, p_174578_) -> p_174577_ != null && p_174577_.isUsingItem() && p_174577_.getUseItem() == p_174575_ ? 1.0F : 0.0F
        );
    }
}
