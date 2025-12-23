package net.satisfy.earthernware.core.event;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.server.level.ServerLevel;
import net.satisfy.earthernware.core.block.AbstractFlowerPotBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class BeePotPollinationHandler {

    private static final int INTERVAL_TICKS = 10;
    private static final int COOLDOWN_TICKS = 20 * 10;
    private static final int SEARCH_RADIUS = 24;
    private static final double BEE_RANGE = 2.5;
    private static final int POT_SAMPLES = 24;
    private static final double MAX_SPEED_SQR = 0.02;
    private static final double MAX_Y_DIFF = 1.25;

    private static final Map<UUID, Long> beeCooldownUntil = new HashMap<>();

    public static void init() {
        TickEvent.SERVER_LEVEL_POST.register(BeePotPollinationHandler::onServerLevelPost);
    }

    private static void onServerLevelPost(ServerLevel level) {
        if (level.isClientSide()) return;

        long gameTime = level.getGameTime();
        cleanupCooldowns(gameTime);

        for (Player player : level.players()) {
            if (((gameTime + player.getId()) % INTERVAL_TICKS) != 0L) continue;

            AABB beeBox = new AABB(player.blockPosition()).inflate(SEARCH_RADIUS);
            List<Bee> bees = level.getEntitiesOfClass(Bee.class, beeBox, bee -> canAttemptPollination(level, bee, gameTime));
            if (bees.isEmpty()) continue;

            for (Bee bee : bees) {
                tryGiveNectarFromNearbyPot(level, bee, gameTime);
            }
        }
    }

    private static void cleanupCooldowns(long gameTime) {
        if ((gameTime % 200L) != 0L) return;
        beeCooldownUntil.entrySet().removeIf(entry -> entry.getValue() <= gameTime);
    }

    private static boolean canAttemptPollination(ServerLevel level, Bee bee, long gameTime) {
        if (!bee.isAlive()) return false;
        if (bee.hasNectar()) return false;
        if (bee.isAngry()) return false;
        if (bee.getTarget() != null) return false;
        if (bee.isInWaterOrBubble()) return false;
        if (bee.isPassenger()) return false;

        Vec3 motion = bee.getDeltaMovement();
        if (motion.lengthSqr() > MAX_SPEED_SQR) return false;

        long until = beeCooldownUntil.getOrDefault(bee.getUUID(), 0L);
        return gameTime >= until;
    }

    private static void tryGiveNectarFromNearbyPot(ServerLevel level, Bee bee, long gameTime) {
        RandomSource random = level.getRandom();
        BlockPos center = bee.blockPosition();
        double beeY = bee.getY();

        for (int i = 0; i < POT_SAMPLES; i++) {
            BlockPos potPos = center.offset(
                    random.nextInt(7) - 3,
                    random.nextInt(5) - 2,
                    random.nextInt(7) - 3
            );

            if (!level.getChunkSource().hasChunk(potPos.getX() >> 4, potPos.getZ() >> 4)) continue;

            BlockState potState = level.getBlockState(potPos);
            if (!(potState.getBlock() instanceof AbstractFlowerPotBlock)) continue;

            BlockEntity blockEntity = level.getBlockEntity(potPos);
            if (!hasFlower(blockEntity)) continue;

            double potCenterX = potPos.getX() + 0.5;
            double potCenterY = potPos.getY() + 0.5;
            double potCenterZ = potPos.getZ() + 0.5;

            if (Math.abs(beeY - potCenterY) > MAX_Y_DIFF) continue;

            if (bee.distanceToSqr(potCenterX, potCenterY, potCenterZ) > (BEE_RANGE * BEE_RANGE)) continue;

            bee.setHasNectar(true);
            beeCooldownUntil.put(bee.getUUID(), gameTime + COOLDOWN_TICKS);
            return;
        }

        beeCooldownUntil.put(bee.getUUID(), gameTime + COOLDOWN_TICKS);
    }

    private static boolean hasFlower(BlockEntity blockEntity) {
        if (!(blockEntity instanceof Container container)) return false;
        if (container.getContainerSize() <= 0) return false;
        return container.getItem(0).is(ItemTags.SMALL_FLOWERS);
    }
}