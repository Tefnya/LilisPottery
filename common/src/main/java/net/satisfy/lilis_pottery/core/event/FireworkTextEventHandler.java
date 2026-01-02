package net.satisfy.lilis_pottery.core.event;

import dev.architectury.event.events.common.TickEvent;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.Fireworks;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class FireworkTextEventHandler {
    private static final int[] FW_PALETTE = {
            0xFF0000, 0xFFA500, 0xFFFF00, 0x00FF00, 0x00FFFF,
            0x0000FF, 0x8A2BE2, 0xFF00FF, 0xFFFFFF, 0xFFD700
    };

    private static final List<Task> TASKS = new ArrayList<>();

    private FireworkTextEventHandler() {
    }

    public static void init() {
        TickEvent.SERVER_POST.register(FireworkTextEventHandler::tick);
    }

    public static void launch(ServerLevel level, Vec3 startPos, Direction facing, Vec3 playerLook, String text) {
        Vec3 up = new Vec3(0.0, 1.0, 0.0);

        Vec3 right = Vec3.atLowerCornerOf(facing.getCounterClockWise().getNormal()).normalize();

        Vec3 forward = new Vec3(playerLook.x, 0.0, playerLook.z);
        if (forward.lengthSqr() < 1.0E-6) {
            forward = Vec3.atLowerCornerOf(facing.getNormal());
        }
        forward = forward.normalize();

        FireworkRocketEntity rocket = new FireworkRocketEntity(
                level,
                new ItemStack(Items.FIREWORK_ROCKET),
                startPos.x,
                startPos.y,
                startPos.z,
                false
        );

        double dx = forward.x * 0.12;
        double dz = forward.z * 0.12;
        double dy = 1.20;

        rocket.setDeltaMovement(dx, dy, dz);
        level.addFreshEntity(rocket);

        level.playSound(null, startPos.x, startPos.y, startPos.z, SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.BLOCKS, 1.0F, 1.0F);

        Vec3 explosionPos = startPos.add(dx * 20.0, dy * 20.0, dz * 20.0);

        TASKS.add(new Task(
                level.dimension(),
                rocket.getUUID(),
                explosionPos,
                right,
                up,
                0,
                160,
                buildTextPoints(text)
        ));
    }

    private static void tick(MinecraftServer server) {
        Iterator<Task> iterator = TASKS.iterator();

        while (iterator.hasNext()) {
            Task task = iterator.next();
            ServerLevel level = server.getLevel(task.dimension);
            if (level == null) {
                iterator.remove();
                continue;
            }

            int age = task.age + 1;

            if (age == 20) {
                level.playSound(null, task.basePos.x, task.basePos.y, task.basePos.z, SoundEvents.FIREWORK_ROCKET_BLAST, SoundSource.BLOCKS, 1.25F, 1.0F);
                level.playSound(null, task.basePos.x, task.basePos.y, task.basePos.z, SoundEvents.FIREWORK_ROCKET_TWINKLE, SoundSource.BLOCKS, 0.9F, 1.0F);
            }

            if (age == 20 || age == 26 || age == 32) {
                fireworkRing(level, task.basePos, task.right, task.up, task.points);
            }

            if (age >= 20 && age <= task.lifeTicks) {
                double sink = (age - 20) * 0.018;
                Vec3 anchor = task.basePos.add(0.0, -sink, 0.0);

                float fade = age >= (task.lifeTicks - 28) ? (age - (task.lifeTicks - 28)) / 28.0F : 0.0F;
                fade = Mth.clamp(fade, 0.0F, 1.0F);
                int step = 1 + (int)(fade * 3.0F);

                for (int i = 0; i < task.points.size(); i += step) {
                    Vec3 p = task.points.get(i);
                    Vec3 world = anchor.add(task.right.scale(p.x)).add(task.up.scale(p.y));
                    level.sendParticles(ParticleTypes.END_ROD, world.x, world.y, world.z, 1, 0.0, 0.0, 0.0, 0.0);
                }
            }

            if (age > task.lifeTicks) {
                iterator.remove();
                continue;
            }

            TASKS.set(TASKS.indexOf(task), task.withAge(age));
        }
    }

    private static void fireworkRing(ServerLevel level, Vec3 center, Vec3 right, Vec3 up, List<Vec3> points) {
        Bounds bounds = bounds(points);
        RandomSource random = level.getRandom();

        int rockets = 6 + random.nextInt(3);
        for (int i = 0; i < rockets; i++) {
            double angle = random.nextDouble() * (Math.PI * 2.0);
            double radius = 1.6 + random.nextDouble() * 1.2;

            double ox = Math.cos(angle) * (bounds.width * 0.45 + radius);
            double oy = (random.nextDouble() - 0.35) * (bounds.height * 0.55);

            Vec3 spawnPos = center.add(right.scale(bounds.centerX + ox)).add(up.scale(bounds.centerY + oy)).add(new Vec3(0.0, 0.2, 0.0));
            ItemStack rocketStack = createRocketItem(random);

            FireworkRocketEntity rocket = new FireworkRocketEntity(level, rocketStack, spawnPos.x, spawnPos.y, spawnPos.z, false);

            double dx = (random.nextDouble() - 0.5) * 0.08;
            double dz = (random.nextDouble() - 0.5) * 0.08;
            double dy = 0.10 + random.nextDouble() * 0.10;

            rocket.setDeltaMovement(dx, dy, dz);
            level.addFreshEntity(rocket);
        }
    }

    private static ItemStack createRocketItem(RandomSource random) {
        int flight = 1 + random.nextInt(1);
        List<FireworkExplosion> explosions = new ArrayList<>(1);
        explosions.add(randomExplosion(random));

        ItemStack stack = new ItemStack(Items.FIREWORK_ROCKET);
        stack.set(DataComponents.FIREWORKS, new Fireworks(flight, explosions));
        return stack;
    }

    private static FireworkExplosion randomExplosion(RandomSource random) {
        FireworkExplosion.Shape shape = FireworkExplosion.Shape.BURST;
        IntList colors = randomPaletteColors(random, 2, Math.max(2, 4));
        IntList fade = randomPaletteColors(random, 0, 2);
        boolean trail = random.nextBoolean();
        boolean twinkle = random.nextInt(3) == 0;
        return new FireworkExplosion(shape, colors, fade, trail, twinkle);
    }

    private static IntList randomPaletteColors(RandomSource random, int min, int maxInclusive) {
        int n = min + random.nextInt(maxInclusive - min + 1);
        IntList out = new IntArrayList(n);
        for (int i = 0; i < n; i++) {
            out.add(FW_PALETTE[random.nextInt(FW_PALETTE.length)]);
        }
        return out;
    }

    private static List<Vec3> buildTextPoints(String text) {
        List<Vec3> points = new ArrayList<>();
        float pixel = 0.25F;
        float spacing = 0.70F;

        float cursor = 0.0F;
        for (int i = 0; i < text.length(); i++) {
            int[] glyph = glyph(text.charAt(i));
            if (glyph != null) {
                for (int row = 0; row < 7; row++) {
                    int bits = glyph[row];
                    for (int col = 0; col < 5; col++) {
                        if (((bits >> (4 - col)) & 1) != 0) {
                            points.add(new Vec3(cursor + col * pixel, (6 - row) * pixel, 0.0));
                        }
                    }
                }
            }
            cursor += spacing;
        }

        Bounds bounds = bounds(points);
        for (int i = 0; i < points.size(); i++) {
            Vec3 p = points.get(i);
            points.set(i, new Vec3(p.x - bounds.centerX, p.y - bounds.centerY, 0.0));
        }

        return points;
    }

    private static Bounds bounds(List<Vec3> points) {
        if (points.isEmpty()) {
            return new Bounds(0.0, 0.0, 1.0, 1.0, 0.0, 0.0);
        }

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;

        for (Vec3 p : points) {
            if (p.x < minX) minX = p.x;
            if (p.y < minY) minY = p.y;
            if (p.x > maxX) maxX = p.x;
            if (p.y > maxY) maxY = p.y;
        }

        double width = Math.max(1.0, maxX - minX);
        double height = Math.max(1.0, maxY - minY);

        return new Bounds(width, height, minX + width * 0.5, minY + height * 0.5, 0.0, 0.0);
    }

    private static int[] glyph(char c) {
        return switch (c) {
            case '\'' -> new int[]{0b00100, 0b00100, 0b00000, 0b00000, 0b00000, 0b00000, 0b00000};
            case 'L' -> new int[]{0b10000, 0b10000, 0b10000, 0b10000, 0b10000, 0b10000, 0b11111};
            case 'i' -> new int[]{0b00100, 0b00000, 0b01100, 0b00100, 0b00100, 0b00100, 0b01110};
            case 'l' -> new int[]{0b01100, 0b00100, 0b00100, 0b00100, 0b00100, 0b00100, 0b01110};
            case 's' -> new int[]{0b00000, 0b01111, 0b10000, 0b01110, 0b00001, 0b11110, 0b00000};
            case 'P' -> new int[]{0b11110, 0b10001, 0b10001, 0b11110, 0b10000, 0b10000, 0b10000};
            case 'o' -> new int[]{0b00000, 0b01110, 0b10001, 0b10001, 0b10001, 0b01110, 0b00000};
            case 't' -> new int[]{0b00100, 0b00100, 0b11111, 0b00100, 0b00100, 0b00100, 0b00011};
            case 'e' -> new int[]{0b00000, 0b01110, 0b10001, 0b11111, 0b10000, 0b01110, 0b00000};
            case 'r' -> new int[]{0b00000, 0b10110, 0b11001, 0b10000, 0b10000, 0b10000, 0b00000};
            case 'y' -> new int[]{0b00000, 0b10001, 0b10001, 0b01111, 0b00001, 0b01110, 0b00000};
            default -> null;
        };
    }

    private record Bounds(double width, double height, double centerX, double centerY, double unused0, double unused1) {
    }

    private record Task(
            ResourceKey<Level> dimension,
            UUID rocketId,
            Vec3 basePos,
            Vec3 right,
            Vec3 up,
            int age,
            int lifeTicks,
            List<Vec3> points
    ) {
        private Task withAge(int nextAge) {
            return new Task(dimension, rocketId, basePos, right, up, nextAge, lifeTicks, points);
        }
    }
}