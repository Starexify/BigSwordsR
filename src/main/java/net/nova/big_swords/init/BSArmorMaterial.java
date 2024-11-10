package net.nova.big_swords.init;

import com.google.common.base.Suppliers;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.BigSwordsR;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSArmorMaterial {

    public static Supplier<ArmorMaterial> LIVINGMETAL = Suppliers.memoize(() -> new ArmorMaterial(
            29,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 7);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 5);
            }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, Tags.BSItemTags.REPAIRS_LIVINGMETAL_ARMOR, BigSwordsR.rl("livingmetal")
    ));

    public static Supplier<ArmorMaterial> BIOMASS = Suppliers.memoize(() -> new ArmorMaterial(
            29,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 7);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 5);
            }), 14, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, Tags.BSItemTags.REPAIRS_BIOMASS_ARMOR, BigSwordsR.rl("biomass")
    ));
}
