package net.nova.big_swords.event;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoulSandBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;
import net.nova.big_swords.init.Tags;

import static net.nova.big_swords.BigSwordsR.MODID;
import static net.nova.big_swords.BigSwordsR.playSound;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class GameEvents {
    // Creep Block
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        ItemStack itemStack = event.getItemStack();
        Player player = event.getEntity();

        if (level.isClientSide()) return;

        if (state.getBlock() instanceof CreepBlock creepBlock) {
            if (itemStack.is(Tags.BSItemTags.GLAIVES) && !state.getValue(CreepBlock.TILLED)) {
                creepBlock.tillBlock(level, pos, state);
                playSound(level, player, SoundEvents.SOUL_ESCAPE.value());
                itemStack.hurtAndBreak(1, event.getEntity(), event.getEntity().getEquipmentSlotForItem(itemStack));
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        } else if (state.getBlock() instanceof SoulSandBlock && itemStack.is(BSItems.CREEP_BALL)) {
            level.setBlock(pos, BSBlocks.CREEP_BLOCK.get().defaultBlockState(), 3);
            playSound(level, player, SoundEvents.SOUL_SAND_BREAK);
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
    }
}
