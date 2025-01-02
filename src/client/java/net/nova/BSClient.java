package net.nova;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.item.property.numeric.NumericProperties;
import net.nova.client.render.item.BloodLevelModelProperty;

public class BSClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		NumericProperties.ID_MAPPER.put(BigSwordsR.rl("blood_level"), BloodLevelModelProperty.CODEC);
	}
}