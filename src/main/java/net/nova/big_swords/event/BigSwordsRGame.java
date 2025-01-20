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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.AddAttributeTooltipsEvent;
import net.neoforged.neoforge.common.extensions.IAttributeExtension;
import net.neoforged.neoforge.common.util.AttributeUtil;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.nova.big_swords.init.BSAttributes;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.init.Tags;
import net.nova.big_swords.item.GlaiveItem;
import net.nova.big_swords.item.ScytheItem;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Collection;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID)
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
    public static void addAttributeItemTooltips(AddAttributeTooltipsEvent event) {
        if (!event.shouldShow()) return;

        ItemStack stack = event.getStack();
        Item item = stack.getItem();
        if (item instanceof ScytheItem scytheItem) {
            event.addTooltipLines(
                    Component.literal(" " + IAttributeExtension.FORMAT.format(scytheItem.minChargedDamage) + "-" + IAttributeExtension.FORMAT.format(scytheItem.maxChargedDamage) + " ")
                            .append(Component.translatable("attribute.name.charged_damage"))
                            .withStyle(ChatFormatting.DARK_GREEN)
            );
        }

        double minChargedDamage = 0;
        double maxChargedDamage = 0;
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = AttributeUtil.getSortedModifiers(stack, EquipmentSlotGroup.MAINHAND);
        Collection<AttributeModifier> chargedModifiers = modifiers.get(BSAttributes.CHARGED_DAMAGE);

        for (AttributeModifier modifier : chargedModifiers) {
            if (modifier.is(BSToolMaterial.MIN_CHARGED_DAMAGE_ID)) {
                minChargedDamage = modifier.amount();
            } else if (modifier.is(BSToolMaterial.MAX_CHARGED_DAMAGE_ID)) {
                maxChargedDamage = modifier.amount();
            }
        }

/*        event.addTooltipLines(
                Component.literal(" " + IAttributeExtension.FORMAT.format(minChargedDamage) + "-" + IAttributeExtension.FORMAT.format(maxChargedDamage) + " ")
                        .append(Component.translatable("attribute.name.charged_damage"))
                        .withStyle(ChatFormatting.DARK_GREEN)
        );*/

        if (item instanceof GlaiveItem glaiveItem) {
            event.addTooltipLines(
                    Component.literal(" " + IAttributeExtension.FORMAT.format(glaiveItem.range) + " Range").withStyle(ChatFormatting.DARK_GREEN)
            );
        }
    }
}
