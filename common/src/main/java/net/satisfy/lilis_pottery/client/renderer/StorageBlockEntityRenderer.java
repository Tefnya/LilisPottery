package net.satisfy.lilis_pottery.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.lilis_pottery.core.block.AbstractStorageBlock;
import net.satisfy.lilis_pottery.core.block.entity.AbstractStorageBlockEntity;

public class StorageBlockEntityRenderer implements BlockEntityRenderer<AbstractStorageBlockEntity> {

    private final AbstractStorageBlockEntityRenderer contentRenderer = new AbstractStorageBlockEntityRenderer();

    @Override
    public void render(AbstractStorageBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (entity == null || !entity.hasLevel()) {
            return;
        }

        BlockState blockState = entity.getBlockState();
        if (!(blockState.getBlock() instanceof AbstractStorageBlock)) {
            return;
        }

        contentRenderer.renderContent(entity, poseStack, bufferSource, packedLight, packedOverlay);
    }
}