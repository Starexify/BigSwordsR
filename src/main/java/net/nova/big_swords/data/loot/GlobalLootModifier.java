package net.nova.big_swords.data.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.loot.AddItemModifier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class GlobalLootModifier extends GlobalLootModifierProvider {
    public GlobalLootModifier(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void start() {
        add("ender_upgrade_in_end", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                BSItems.ENDER_UPGRADE_SMITHING_TEMPLATE.get()));
    }
}
