package net.nova.big_swords.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.nova.big_swords.init.BSDataComponents;
import net.nova.big_swords.init.BSItems;

public class CopperShieldAxingRecipe extends CustomRecipe {
  public static final CopperShieldAxingRecipe INSTANCE = new CopperShieldAxingRecipe();
  public static final MapCodec<CopperShieldAxingRecipe> MAP_CODEC = MapCodec.unit(INSTANCE);
  public static final StreamCodec<RegistryFriendlyByteBuf, CopperShieldAxingRecipe> STREAM_CODEC = StreamCodec.unit(INSTANCE);
  public static final RecipeSerializer<CopperShieldAxingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

  @Override
  public boolean matches(CraftingInput input, Level level) {
    boolean hasShield = false;
    boolean hasTool = false;

    for (int i = 0; i < input.size(); i++) {
      ItemStack stack = input.getItem(i);
      if (stack.isEmpty()) continue;

      if (stack.getItem() instanceof ShieldItem) {
        WeatheringCopper.WeatherState state = stack.getOrDefault(BSDataComponents.OXIDATION_STATE, WeatheringCopper.WeatherState.UNAFFECTED);
        boolean canScrape = stack.getOrDefault(BSDataComponents.WAXED, false) || state != WeatheringCopper.WeatherState.UNAFFECTED;

        if (!canScrape || hasShield) return false;
        hasShield = true;
      }
      else if (stack.is(ItemTags.AXES)) {
        if (hasTool) return false;
        hasTool = true;
      }
      else return false;
    }

    return hasShield && hasTool;
  }

  @Override
  public ItemStack assemble(CraftingInput input) {
    ItemStack targetShield = ItemStack.EMPTY;

    for (int i = 0; i < input.size(); i++) {
      ItemStack stack = input.getItem(i);
      if (!stack.isEmpty() && stack.getItem() instanceof ShieldItem) {
        targetShield = stack;
        break;
      }
    }
    if (targetShield.isEmpty()) return ItemStack.EMPTY;

    Item currentItem = targetShield.getItem();
    WeatheringCopper.WeatherState currentState = targetShield.getOrDefault(BSDataComponents.OXIDATION_STATE, WeatheringCopper.WeatherState.UNAFFECTED);
    WeatheringCopper.WeatherState targetState = currentState;
    boolean isGilded = false;

    boolean isRegularCopper = BSItems.COPPER_SHIELD.asList().stream().anyMatch(h -> h.getFirst().value() == currentItem);
    if (!isRegularCopper) {
      isGilded = BSItems.GILDED_COPPER_SHIELD.asList().stream().anyMatch(h -> h.getFirst().value() == currentItem);
    }

    if (!isRegularCopper && !isGilded) return ItemStack.EMPTY;
    var activeCollection = isRegularCopper ? BSItems.COPPER_SHIELD : BSItems.GILDED_COPPER_SHIELD;

    if (!targetShield.getOrDefault(BSDataComponents.WAXED, false)) {
      targetState = switch (currentState) {
        case WEATHERED -> WeatheringCopper.WeatherState.EXPOSED;
        case OXIDIZED -> WeatheringCopper.WeatherState.WEATHERED;
        default -> WeatheringCopper.WeatherState.UNAFFECTED;
      };
    }
    Item targetItem = activeCollection.weathering().pick(targetState).getFirst().value();

    ItemStack outputStack = new ItemStack(targetItem);
    outputStack.applyComponents(targetShield.getComponentsPatch());
    outputStack.remove(BSDataComponents.WAXED);

    return outputStack;
  }

  @Override
  public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
    NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);

    for (int i = 0; i < input.size(); i++) {
      ItemStack stack = input.getItem(i);
      if (stack.is(ItemTags.AXES)) {
        ItemStack toolCopy = stack.copy();
        toolCopy.setDamageValue(toolCopy.getDamageValue() + 1);

        if (toolCopy.getDamageValue() >= toolCopy.getMaxDamage()) {
          remaining.set(i, ItemStack.EMPTY);
        }
        else {
          remaining.set(i, toolCopy);
        }
      }
    }
    return remaining;
  }

  @Override
  public RecipeSerializer<? extends CustomRecipe> getSerializer() {
    return SERIALIZER;
  }
}
