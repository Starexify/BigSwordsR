package net.nova.big_swords.event;

import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.AddAttributeTooltipsEvent;
import net.neoforged.neoforge.common.util.AttributeUtil;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.nova.big_swords.init.BSAttributes;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.init.Tags;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class BigSwordsRGame {
    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType().is(Tags.EntityTypeTags.HALLOWEEN_MOB) && entity instanceof Mob mob) {
            halloweenDrop(mob, event.getEntity().level(), new ItemStack(BSItems.SOUL_REAPER.get()));
        }
    }

    public static void halloweenDrop(Mob entity, Level level, ItemStack stack) {
        LocalDate localdate = LocalDate.now();
        RandomSource randomsource = level.getRandom();
        int i = localdate.get(ChronoField.DAY_OF_MONTH);
        int j = localdate.get(ChronoField.MONTH_OF_YEAR);
        if (j == 10 && i == 31 && randomsource.nextFloat() < 0.25F) {
            entity.setItemSlot(EquipmentSlot.MAINHAND, stack);
            entity.setDropChance(EquipmentSlot.MAINHAND, 0.05F);
        }
    }

    @SubscribeEvent
    public static void addItemTooltips(AddAttributeTooltipsEvent event) {
        if (!event.shouldShow()) return;

        ItemStack stack = event.getStack();
        AtomicReference<Double> minDamage = new AtomicReference<>((double) 0);
        AtomicReference<Double> maxDamage = new AtomicReference<>((double) 0);
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = AttributeUtil.getSortedModifiers(stack, EquipmentSlotGroup.MAINHAND);
        Collection<AttributeModifier> chargedModifiers = modifiers.get(BSAttributes.CHARGED_DAMAGE);

        for (AttributeModifier modifier : chargedModifiers) {
            if (modifier.is(BSToolMaterial.MIN_CHARGED_DAMAGE_ID)) {
                minDamage.set(modifier.amount());
            } else if (modifier.is(BSToolMaterial.MAX_CHARGED_DAMAGE_ID)) {
                maxDamage.set(modifier.amount());
            }
        }

        event.addTooltipLines(
                Component.translatable("attribute.name.charged_damage")
                        .append(": ")
                        .append(Component.literal(minDamage.toString()))
                        .append(" - ")
                        .append(Component.literal(maxDamage.toString()))
                        .withStyle(ChatFormatting.DARK_GREEN)
        );
    }
}
