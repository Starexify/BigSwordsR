package net.nova.big_swords.event;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID)
public class HalloweenStuff {
    @SubscribeEvent
    public static void soulReaperHalloween(MobSpawnEvent event) {
        if (event.getEntity().getType().is(Tags.EntityTypeTags.HALLOWEEN_MOB)) {
            halloween(event.getEntity(), event.getEntity().level(), new ItemStack(BSItems.SOUL_REAPER.get()));
        }
    }

    private static void halloween(LivingEntity entity, Level level, ItemStack stack) {
        if (entity.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
            LocalDate localdate = LocalDate.now();
            RandomSource randomsource = level.getRandom();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            //if (j == 10 && i == 31 && randomsource.nextFloat() < 0.25F) {
                entity.setItemSlot(EquipmentSlot.HEAD, stack);
            //    entity.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
            //}
        }
    }
}
