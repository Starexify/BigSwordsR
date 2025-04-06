package net.nova.big_swords;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.nova.big_swords.init.BSAttributes;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.item.GlaiveItem;

import java.util.List;
import java.util.Optional;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSClient implements ClientModInitializer {
    public static final String[] RESOURCE_PACKS = {"big_swords_r_16x", "big_swords_r_old"};
    public static final String RP_16x = RESOURCE_PACKS[0];
    public static final String RP_old = RESOURCE_PACKS[1];
    public static String RP_16x_NAME = "resourcePack." + MODID + "." + RP_16x + ".name";
    public static String RP_16x_DESC = "resourcePack." + MODID + "." + RP_16x + ".description";
    public static String RP_old_NAME = "resourcePack." + MODID + "." + RP_old + ".name";
    public static String RP_old_DESC = "resourcePack." + MODID + "." + RP_old + ".description";

    @Override
    public void onInitializeClient() {
        // RenderLayers
        BlockRenderLayerMap.INSTANCE.putBlock(BSBlocks.BIOMASS, RenderType.cutout());

        // Resource Packs
        for (String packId : RESOURCE_PACKS) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    BigSwordsR.rl(packId),
                    FabricLoader.getInstance().getModContainer(MODID).orElseThrow(),
                    Component.translatable("resourcePack." + MODID + "." + packId + ".name"),
                    ResourcePackActivationType.NORMAL
            );
        }

        // Tooltip Stuff
        ItemTooltipCallback.EVENT.register((stack, tooltipContext, tooltipType, tooltip) -> {
            Item item = stack.getItem();

            tooltip.removeIf(text -> text.getString().contains(BSAttributes.MAX_CHARGED_DAMAGE.value().getDescriptionId()));
            Optional<Component> toModify = tooltip.stream()
                    .filter(text -> text.getString().contains(BSAttributes.MIN_CHARGED_DAMAGE.value().getDescriptionId())).findFirst();

            if (toModify.isPresent()) {
                List<ItemAttributeModifiers.Entry> modifiers = item.components().get(DataComponents.ATTRIBUTE_MODIFIERS).modifiers();
                double minChargedDamage = BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MIN_CHARGED_DAMAGE_ID);
                double maxChargedDamage = BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MAX_CHARGED_DAMAGE_ID);

                int index = tooltip.indexOf(toModify.get());
                tooltip.set(index, CommonComponents.space().append(Component.literal(
                                ItemAttributeModifiers.ATTRIBUTE_MODIFIER_FORMAT.format(minChargedDamage) + "-" +
                                        ItemAttributeModifiers.ATTRIBUTE_MODIFIER_FORMAT.format(maxChargedDamage) + " ")
                        .append(Component.translatable("attribute.name.charged_damage")).withStyle(ChatFormatting.DARK_GREEN)
                ));

                if (item instanceof GlaiveItem glaiveItem)
                    tooltip.add(index + 1, CommonComponents.space().append(ItemAttributeModifiers.ATTRIBUTE_MODIFIER_FORMAT.format(glaiveItem.range) + " Charged Range").withStyle(ChatFormatting.DARK_GREEN));
            }
        });
    }
}