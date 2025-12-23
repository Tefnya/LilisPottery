package net.satisfy.lilis_pottery.core.event;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.lilis_pottery.core.block.UrnBlock;
import net.satisfy.lilis_pottery.core.block.entity.UrnBlockEntity;

public final class UrnDeathHandler {
    public static void init() {
        EntityEvent.LIVING_DEATH.register(UrnDeathHandler::onLivingDeath);
    }

    private static EventResult onLivingDeath(LivingEntity livingEntity, DamageSource damageSource) {
        if (!(livingEntity instanceof ServerPlayer serverPlayer)) return EventResult.pass();

        ServerLevel level = serverPlayer.serverLevel();
        if (level.getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) return EventResult.pass();

        int urnSlot = findUrnSlot(serverPlayer);
        if (urnSlot < 0) return EventResult.pass();

        ItemStack urnStack = serverPlayer.getInventory().getItem(urnSlot);
        if (!(urnStack.getItem() instanceof BlockItem urnBlockItem)) return EventResult.pass();
        if (!(urnBlockItem.getBlock() instanceof UrnBlock)) return EventResult.pass();

        BlockPos urnPos = findPlacementPos(level, serverPlayer.blockPosition());
        if (urnPos == null) return EventResult.pass();

        BlockState urnState = urnBlockItem.getBlock().defaultBlockState();
        level.setBlock(urnPos, urnState, 3);

        BlockEntity blockEntity = level.getBlockEntity(urnPos);
        if (!(blockEntity instanceof UrnBlockEntity urnBlockEntity)) {
            level.removeBlock(urnPos, false);
            return EventResult.pass();
        }

        urnStack.shrink(1);
        urnBlockEntity.absorbFrom(serverPlayer);
        serverPlayer.getInventory().clearContent();

        return EventResult.pass();
    }

    private static int findUrnSlot(ServerPlayer serverPlayer) {
        for (int slot = 0; slot < 9; slot++) {
            ItemStack stack = serverPlayer.getInventory().getItem(slot);
            if (isUrnStack(stack)) return slot;
        }
        for (int slot = 9; slot < serverPlayer.getInventory().getContainerSize(); slot++) {
            ItemStack stack = serverPlayer.getInventory().getItem(slot);
            if (isUrnStack(stack)) return slot;
        }
        return -1;
    }

    private static boolean isUrnStack(ItemStack stack) {
        if (stack.isEmpty()) return false;
        if (!(stack.getItem() instanceof BlockItem blockItem)) return false;
        return blockItem.getBlock() instanceof UrnBlock;
    }

    private static BlockPos findPlacementPos(ServerLevel level, BlockPos origin) {
        if (canPlaceAt(level, origin)) return origin;

        BlockPos above = origin.above();
        if (canPlaceAt(level, above)) return above;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                if (dx == 0 && dz == 0) continue;

                BlockPos candidate = origin.offset(dx, 0, dz);
                if (canPlaceAt(level, candidate)) return candidate;

                BlockPos candidateAbove = candidate.above();
                if (canPlaceAt(level, candidateAbove)) return candidateAbove;
            }
        }

        return null;
    }

    private static boolean canPlaceAt(ServerLevel level, BlockPos pos) {
        return level.getWorldBorder().isWithinBounds(pos) && level.getBlockState(pos).canBeReplaced();
    }
}