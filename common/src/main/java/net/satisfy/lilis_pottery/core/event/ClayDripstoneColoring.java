package net.satisfy.lilis_pottery.core.event;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;

public final class ClayDripstoneColoring {

    private static final int INTERVAL_TICKS = 5;
    private static final int HORIZONTAL_RADIUS = 16;
    private static final int VERTICAL_RADIUS = 8;
    private static final int SAMPLES_PER_PLAYER = 128;

    public static void init() {
        TickEvent.SERVER_LEVEL_POST.register(ClayDripstoneColoring::onServerLevelPost);
    }

    private static void onServerLevelPost(ServerLevel serverLevel) {
        if (serverLevel.isClientSide()) return;

        long gameTime = serverLevel.getGameTime();
        for (Player player : serverLevel.players()) {
            if (((gameTime + player.getId()) % INTERVAL_TICKS) != 0L) continue;
            processAroundPlayer(serverLevel, player);
        }
    }

    private static void processAroundPlayer(ServerLevel serverLevel, Player player) {
        RandomSource random = serverLevel.getRandom();
        BlockPos origin = player.blockPosition();

        for (int i = 0; i < SAMPLES_PER_PLAYER; i++) {
            BlockPos targetPos = origin.offset(
                    random.nextInt(HORIZONTAL_RADIUS * 2 + 1) - HORIZONTAL_RADIUS,
                    random.nextInt(VERTICAL_RADIUS * 2 + 1) - VERTICAL_RADIUS,
                    random.nextInt(HORIZONTAL_RADIUS * 2 + 1) - HORIZONTAL_RADIUS
            );

            if (!serverLevel.getChunkSource().hasChunk(
                    targetPos.getX() >> 4,
                    targetPos.getZ() >> 4
            )) continue;

            BlockState targetState = serverLevel.getBlockState(targetPos);
            if (!isSupportedTarget(targetState)) continue;

            tryTransform(serverLevel, targetPos, targetState);
        }
    }

    private static boolean isSupportedTarget(BlockState state) {
        Block block = state.getBlock();
        return block == Blocks.GRAVEL || block == Blocks.SAND || block == Blocks.CLAY;
    }

    private static void tryTransform(ServerLevel level, BlockPos targetPos, BlockState targetState) {
        if (!level.getBlockState(targetPos.above()).isAir()) return;

        BlockState dripstoneState = level.getBlockState(targetPos.above(2));
        if (!isPointedDripstoneDown(dripstoneState)) return;

        BlockState terracottaState = level.getBlockState(targetPos.above(3));
        BlockState result = getResultStateFromTerracotta(terracottaState.getBlock());
        if (result == null) return;

        if (!level.getFluidState(targetPos.above(4)).is(Fluids.WATER)) return;

        if (targetState.is(result.getBlock())) return;

        level.setBlock(targetPos, result, 3);
    }

    private static boolean isPointedDripstoneDown(BlockState state) {
        if (!(state.getBlock() instanceof PointedDripstoneBlock)) return false;
        return state.getValue(PointedDripstoneBlock.TIP_DIRECTION) == Direction.DOWN;
    }

    private static BlockState getResultStateFromTerracotta(Block terracottaBlock) {
        if (terracottaBlock == Blocks.RED_TERRACOTTA) return ObjectRegistry.RED_CLAY.get().defaultBlockState();
        if (terracottaBlock == Blocks.YELLOW_TERRACOTTA) return ObjectRegistry.YELLOW_CLAY.get().defaultBlockState();
        if (terracottaBlock == Blocks.WHITE_TERRACOTTA) return ObjectRegistry.WHITE_CLAY.get().defaultBlockState();
        if (terracottaBlock == Blocks.BLUE_TERRACOTTA) return ObjectRegistry.BLUE_CLAY.get().defaultBlockState();
        if (terracottaBlock == Blocks.BLACK_TERRACOTTA) return ObjectRegistry.BLACK_CLAY.get().defaultBlockState();
        return null;
    }
}