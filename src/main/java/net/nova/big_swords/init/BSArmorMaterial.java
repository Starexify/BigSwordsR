package net.nova.big_swords.init;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.BigSwordsR;

import java.util.EnumMap;
import java.util.List;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSArmorMaterial {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MODID);

    public static Holder<ArmorMaterial> LIVINGMETAL = ARMOR_MATERIALS.register("livingmetal", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }), 12, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(BSItems.LIVINGMETAL_INGOT),
            List.of(new ArmorMaterial.Layer(
                    BigSwordsR.rl("livingmetal")
            )), 0.5F, 0.0F
    ));

    public static Holder<ArmorMaterial> BIOMASS = ARMOR_MATERIALS.register("biomass", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }), 14, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(BSItems.BIOMASS),
            List.of(new ArmorMaterial.Layer(
                    BigSwordsR.rl("biomass")
            )), 0.0F, 0.0F
    ));

}
