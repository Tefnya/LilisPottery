package net.satisfy.lilis_pottery.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.satisfy.lilis_pottery.core.block.entity.AbstractStorageBlockEntity;

public interface AbstractStorageTypeRenderer {
    void render(AbstractStorageBlockEntity abstractStorageBlockEntity, PoseStack poseStack, MultiBufferSource multiBufferSource, NonNullList<ItemStack> nonNullList);
}
