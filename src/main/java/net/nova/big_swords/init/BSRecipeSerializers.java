package net.nova.big_swords.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.big_swords.recipe.CopperShieldAxingRecipe;

import java.util.function.Supplier;

import static net.nova.big_swords.BigSwordsR.MODID;

public class BSRecipeSerializers {
  public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MODID);

  public static final Supplier<RecipeSerializer<CopperShieldAxingRecipe>> COPPER_SHIELD_AXING_RECIPE = RECIPE_SERIALIZERS.register("axing_copper_shield", () -> CopperShieldAxingRecipe.SERIALIZER);
}
