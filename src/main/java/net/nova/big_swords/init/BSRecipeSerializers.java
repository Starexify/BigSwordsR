package net.nova.big_swords.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.recipe.CopperShieldAxingRecipe;

public class BSRecipeSerializers {
  public static final RecipeSerializer<CopperShieldAxingRecipe> COPPER_SHIELD_AXING_RECIPE = Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, BigSwordsR.rl("axing_copper_shield"), CopperShieldAxingRecipe.SERIALIZER);

  public static void initialize() {
    BigSwordsR.LOGGER.info("Registering Recipe Serializers");
  }
}