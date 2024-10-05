package net.nova.big_swords.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.enchantments.SoulStealer;
import net.nova.big_swords.item.ScytheItem;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

    public static final EnchantmentCategory SCYTHE = EnchantmentCategory.create("SCYTHE", (item) -> item.getDefaultInstance().is(Tags.BSItemTags.SCYTHES));

    public static final RegistryObject<Enchantment> SOUL_STEALER = ENCHANTMENTS.register("soul_stealer", () -> new SoulStealer(Enchantment.Rarity.UNCOMMON, SCYTHE, EquipmentSlot.MAINHAND));
}
