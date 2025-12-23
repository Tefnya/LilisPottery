package net.satisfy.lilis_pottery.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.lilis_pottery.client.util.ClientUtil;
import net.satisfy.lilis_pottery.core.block.entity.AbstractStorageBlockEntity;

public class FlowerPotRenderer implements AbstractStorageTypeRenderer {

    @Override
    public void render(AbstractStorageBlockEntity storageBlockEntity, PoseStack poseStack, MultiBufferSource multiBufferSource, NonNullList<ItemStack> nonNullList) {
        ItemStack itemStack = nonNullList.get(0);
        if (itemStack.getItem() instanceof BlockItem blockItem) {
            BlockState state = blockItem.getBlock().defaultBlockState();
            ClientUtil.renderBlock(state, poseStack, multiBufferSource, storageBlockEntity);
        }
    }
}