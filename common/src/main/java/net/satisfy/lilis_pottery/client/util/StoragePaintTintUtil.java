package net.satisfy.lilis_pottery.client.util;

import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.lilis_pottery.core.block.AbstractStorageBlock;
import net.satisfy.lilis_pottery.core.block.UrnBlock;
import net.satisfy.lilis_pottery.core.block.entity.AbstractStorageBlockEntity;
import net.satisfy.lilis_pottery.core.block.entity.UrnBlockEntity;

import java.util.ArrayList;
import java.util.List;

public final class StoragePaintTintUtil {

    private StoragePaintTintUtil() {
    }

    public static void register() {
        List<Block> tintBlocks = new ArrayList<>();

        for (Block block : BuiltInRegistries.BLOCK) {
            if (block instanceof AbstractStorageBlock || block instanceof UrnBlock) {
                tintBlocks.add(block);
            }
        }

        ColorHandlerRegistry.registerBlockColors(StoragePaintTintUtil::blockTint, tintBlocks.toArray(Block[]::new));
    }

    private static int blockTint(BlockState state, BlockAndTintGetter level, BlockPos pos, int tintIndex) {
        if (tintIndex != 0) {
            return -1;
        }

        boolean painted = false;

        if (state.hasProperty(AbstractStorageBlock.PAINTED)) {
            painted = state.getValue(AbstractStorageBlock.PAINTED);
        } else if (state.hasProperty(UrnBlock.PAINTED)) {
            painted = state.getValue(UrnBlock.PAINTED);
        }

        if (!painted) {
            return -1;
        }

        if (level == null || pos == null) {
            return PreviewTintContext.get();
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof AbstractStorageBlockEntity storageEntity) {
            int rgb = storageEntity.getSideColorRgb();
            return rgb == 0 ? -1 : (rgb & 0xFFFFFF);
        }

        if (blockEntity instanceof UrnBlockEntity urnBlockEntity) {
            int rgb = urnBlockEntity.getSideColorRgb();
            return rgb == 0 ? -1 : (rgb & 0xFFFFFF);
        }

        return -1;
    }
}