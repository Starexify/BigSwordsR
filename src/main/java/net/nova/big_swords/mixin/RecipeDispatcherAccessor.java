package net.nova.big_swords.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeDispatcher;
import net.minecraft.recipe.ShapedRecipeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(RecipeDispatcher.class)
public interface RecipeDispatcherAccessor {
    @Invoker("registerShapedRecipe")
    ShapedRecipeType big_swords$registerShapedRecipe(ItemStack output, Object... args);
}
