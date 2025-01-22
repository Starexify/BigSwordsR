package net.nova.big_swords;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
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
        BlockRenderLayerMap.INSTANCE.putBlock(BSBlocks.BIOMASS, RenderLayer.getCutout());

        // Resource Packs
        for (String packId : RESOURCE_PACKS) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    BigSwordsR.rl(packId),
                    FabricLoader.getInstance().getModContainer(MODID).orElseThrow(),
                    Text.translatable("resourcePack." + MODID + "." + packId + ".name"),
                    ResourcePackActivationType.NORMAL
            );
        }

        // Tooltip Stuff
        ItemTooltipCallback.EVENT.register((stack, tooltipContext, tooltipType, tooltip) -> {
            Item item = stack.getItem();

            tooltip.removeIf(text -> text.getString().contains(BSAttributes.MAX_CHARGED_DAMAGE.value().getTranslationKey()));
            Optional<Text> toModify = tooltip.stream()
                    .filter(text -> text.getString().contains(BSAttributes.MIN_CHARGED_DAMAGE.value().getTranslationKey())).findFirst();

            if (toModify.isPresent()) {
                List<AttributeModifiersComponent.Entry> modifiers = item.getComponents().get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers();
                double minChargedDamage = BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MIN_CHARGED_DAMAGE_ID);
                double maxChargedDamage = BigSwordsR.getModifierValue(modifiers, BSToolMaterial.MAX_CHARGED_DAMAGE_ID);

                int index = tooltip.indexOf(toModify.get());
                tooltip.set(index, ScreenTexts.space().append(Text.literal(
                                AttributeModifiersComponent.DECIMAL_FORMAT.format(minChargedDamage) + "-" +
                                        AttributeModifiersComponent.DECIMAL_FORMAT.format(maxChargedDamage) + " ")
                        .append(Text.translatable("attribute.name.charged_damage")).formatted(Formatting.DARK_GREEN)
                ));

                if (item instanceof GlaiveItem glaiveItem) {
                    tooltip.add(index + 1,
                            ScreenTexts.space().append(AttributeModifiersComponent.DECIMAL_FORMAT.format(glaiveItem.range) + " Charged Range").formatted(Formatting.DARK_GREEN)
                    );
                }
            }
        });
    }
}