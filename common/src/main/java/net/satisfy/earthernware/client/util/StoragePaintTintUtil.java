package net.satisfy.earthernware.client.util;

import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.earthernware.core.block.AbstractStorageBlock;
import net.satisfy.earthernware.core.block.entity.AbstractStorageBlockEntity;

import java.util.ArrayList;
import java.util.List;

public final class StoragePaintTintUtil {

    private StoragePaintTintUtil() {
    }

    public static void register() {
        List<Block> storageBlocks = new ArrayList<>();

        for (Block block : BuiltInRegistries.BLOCK) {
            if (block instanceof AbstractStorageBlock) {
                storageBlocks.add(block);
            }
        }

        ColorHandlerRegistry.registerBlockColors(StoragePaintTintUtil::blockTint, storageBlocks.toArray(Block[]::new));
    }

    private static int blockTint(BlockState state, BlockAndTintGetter level, BlockPos pos, int tintIndex) {
        if (tintIndex != 0) {
            return -1;
        }
        if (!state.hasProperty(AbstractStorageBlock.PAINTED) || !state.getValue(AbstractStorageBlock.PAINTED)) {
            return -1;
        }

        if (level == null || pos == null) {
            return PreviewTintContext.get();
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof AbstractStorageBlockEntity storageEntity) {
            int rgb = storageEntity.getSideColorRgb();
            return rgb == 0 ? -1 : rgb;
        }
        return -1;
    }
}