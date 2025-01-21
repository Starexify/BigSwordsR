package net.nova.big_swords;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.item.property.numeric.NumericProperties;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.nova.big_swords.client.render.item.BloodLevelModelProperty;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSToolMaterial;
import net.nova.big_swords.item.GlaiveItem;
import net.nova.big_swords.item.ScytheItem;

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
        // Item Properties
        NumericProperties.ID_MAPPER.put(BigSwordsR.rl("blood_level"), BloodLevelModelProperty.CODEC);

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
/*            Item item = stack.getItem();

            if (item instanceof ScytheItem || item instanceof GlaiveItem) {
                AttributeModifiersComponent attributeComponent = item.getComponents().get(DataComponentTypes.ATTRIBUTE_MODIFIERS);
                Multimap<EntityAttribute, EntityAttributeModifier> modifiers = HashMultimap.create();

                attributeComponent.modifiers().forEach(entry -> {
                    modifiers.put(entry.attribute().value(), entry.modifier());
                });

                double minChargedDamage = modifiers.entries().stream()
                        .filter(e -> e.getValue().idMatches(BSToolMaterial.MIN_CHARGED_DAMAGE_ID))
                        .mapToDouble(e -> e.getValue().value())
                        .findFirst().orElse(0.0);
                double maxChargedDamage = modifiers.entries().stream()
                        .filter(e -> e.getValue().idMatches(BSToolMaterial.MAX_CHARGED_DAMAGE_ID))
                        .mapToDouble(e -> e.getValue().value())
                        .findFirst().orElse(0.0);

                tooltip.add(Text.literal(" " + AttributeModifiersComponent.DECIMAL_FORMAT.format(minChargedDamage) + "-" + AttributeModifiersComponent.DECIMAL_FORMAT.format(maxChargedDamage) + " ")
                        .append(Text.translatable("attribute.name.charged_damage"))
                        .formatted(Formatting.DARK_GREEN));
            }

            if (item instanceof GlaiveItem glaiveItem) {
                tooltip.add(
                        Text.literal(" " + AttributeModifiersComponent.DECIMAL_FORMAT.format(glaiveItem.range) + " Range").formatted(Formatting.DARK_GREEN)
                );
            }*/
        });
    }
}