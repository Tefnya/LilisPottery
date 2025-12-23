package net.satisfy.lilis_pottery.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.client.util.PreviewTintContext;
import net.satisfy.lilis_pottery.core.block.AbstractStorageBlock;
import net.satisfy.lilis_pottery.core.inventory.KilnScreenHandler;

public class KilnGui extends AbstractContainerScreen<KilnScreenHandler> {
    private static final ResourceLocation TEXTURE = LilisPottery.identifier("textures/gui/kiln.png");
    private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/burn_progress");

    public KilnGui(KilnScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
        this.titleLabelY--;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float delta, int mouseX, int mouseY) {
        int left = this.leftPos;
        int top = this.topPos;

        graphics.blit(TEXTURE, left, top, 0, 0, this.imageWidth, this.imageHeight);

        if (this.menu.isLit()) {
            int lit = Mth.ceil(this.menu.getLitProgress() * 13.0F) + 1;
            graphics.blitSprite(LIT_PROGRESS_SPRITE, 14, 14, 0, 14 - lit, left + 26, top + 36 + 14 - lit, 14, lit);
        }

        int burn = Mth.ceil(this.menu.getBurnProgress() * 24.0F);
        graphics.blitSprite(BURN_PROGRESS_SPRITE, 24, 16, 0, 0, left + 58, top + 35, burn, 16);

        Preview preview = getPreview();
        if (preview.state != null) {
            renderBlockPreview(graphics, preview.state, preview.rgb, left + 140, top + 52);
        }
    }

    private Preview getPreview() {
        ItemStack baseStack = this.menu.getSlot(0).getItem();
        if (baseStack.isEmpty()) {
            return new Preview(null, -1);
        }
        if (!(baseStack.getItem() instanceof BlockItem blockItem)) {
            return new Preview(null, -1);
        }

        ItemStack modifierStack = this.menu.getSlot(1).getItem();

        int baseRgb = getSideRgb(baseStack);
        boolean basePainted = isPainted(baseStack, baseRgb);

        int dyeRgb = getDyeRgb(modifierStack);

        int previewRgb;
        boolean previewPainted;

        if (dyeRgb != -1) {
            previewRgb = baseRgb == -1 ? dyeRgb : mixRgb(baseRgb, dyeRgb);
            previewPainted = true;
        } else {
            previewRgb = baseRgb;
            previewPainted = basePainted;
        }

        BlockState state = blockItem.getBlock().defaultBlockState();
        state = setBooleanIfPresent(state, AbstractStorageBlock.PAINTED.getName(), previewPainted);

        return new Preview(state, previewRgb);
    }

    private int getDyeRgb(ItemStack stack) {
        if (stack.getItem() instanceof DyeItem dyeItem) {
            return dyeItem.getDyeColor().getFireworkColor();
        }
        return -1;
    }

    private int getSideRgb(ItemStack stack) {
        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData == null) {
            return -1;
        }
        CompoundTag tag = customData.copyTag();
        if (!tag.contains("sideColorRgb", 99)) {
            return -1;
        }
        int rgb = tag.getInt("sideColorRgb");
        return rgb == 0 ? -1 : rgb;
    }

    private boolean isPainted(ItemStack stack, int rgb) {
        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData == null) {
            return rgb != -1;
        }
        CompoundTag tag = customData.copyTag();
        if (tag.contains("painted", 1)) {
            return tag.getBoolean("painted");
        }
        return rgb != -1;
    }

    private int mixRgb(int firstRgb, int secondRgb) {
        int firstRed = (firstRgb >> 16) & 255;
        int firstGreen = (firstRgb >> 8) & 255;
        int firstBlue = firstRgb & 255;

        int secondRed = (secondRgb >> 16) & 255;
        int secondGreen = (secondRgb >> 8) & 255;
        int secondBlue = secondRgb & 255;

        int mixedRed = (firstRed + secondRed) / 2;
        int mixedGreen = (firstGreen + secondGreen) / 2;
        int mixedBlue = (firstBlue + secondBlue) / 2;

        return (mixedRed << 16) | (mixedGreen << 8) | mixedBlue;
    }

    private BlockState setBooleanIfPresent(BlockState state, String name, boolean value) {
        StateDefinition<?, ?> definition = state.getBlock().getStateDefinition();
        for (Property<?> property : definition.getProperties()) {
            if (property instanceof BooleanProperty booleanProperty && name.equals(booleanProperty.getName())) {
                return state.setValue(booleanProperty, value);
            }
        }
        return state;
    }

    private void renderBlockPreview(GuiGraphics graphics, BlockState state, int rgb, int x, int y) {
        Minecraft minecraft = Minecraft.getInstance();

        RenderSystem.enableDepthTest();
        RenderSystem.disableCull();

        if (rgb != -1) {
            PreviewTintContext.set(rgb);
        } else {
            PreviewTintContext.clear();
        }

        PoseStack poseStack = graphics.pose();
        poseStack.pushPose();
        poseStack.translate(x, y, 150.0F);
        poseStack.scale(32.0F, 32.0F, 32.0F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        poseStack.mulPose(Axis.XP.rotationDegrees(30.0F));
        poseStack.mulPose(Axis.YP.rotationDegrees(225.0F));
        poseStack.translate(-0.8F, -0.5F, 0.0F);

        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        minecraft.getBlockRenderer().renderSingleBlock(state, poseStack, bufferSource, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);
        bufferSource.endBatch();

        poseStack.popPose();

        PreviewTintContext.clear();
        RenderSystem.enableCull();
    }

    private record Preview(BlockState state, int rgb) {
    }
}