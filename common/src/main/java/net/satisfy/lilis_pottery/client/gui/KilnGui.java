package net.satisfy.lilis_pottery.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Inventory;
import net.satisfy.lilis_pottery.core.block.AbstractStorageBlock;
import net.satisfy.lilis_pottery.core.block.UrnBlock;
import net.satisfy.lilis_pottery.core.inventory.KilnScreenHandler;

import java.util.ArrayList;
import java.util.List;

public class KilnGui extends AbstractContainerScreen<KilnScreenHandler> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("lilis_pottery", "textures/gui/kiln.png");
    private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/burn_progress");

    private final List<ItemStack> baseSlotHints = new ArrayList<>();

    public KilnGui(KilnScreenHandler handler, Inventory inventory, net.minecraft.network.chat.Component title) {
        super(handler, inventory, title);
        this.baseSlotHints.addAll(this.collectBaseSlotHints());
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float delta, int mouseX, int mouseY) {
        int left = this.leftPos;
        int top = this.topPos;

        graphics.blit(TEXTURE, left, top, 0, 0, this.imageWidth, this.imageHeight);

        this.renderBaseSlotHint(graphics, left + 17, top + 17);

        if (this.menu.isLit()) {
            int litHeight = Mth.ceil(this.menu.getLitProgress() * 13.0F);
            graphics.blitSprite(LIT_PROGRESS_SPRITE, 14, 14, 0, 14 - litHeight, left + 26, top + 36 + 14 - litHeight, 14, litHeight);
        }

        int burnWidth = Mth.ceil(this.menu.getBurnProgress() * 24.0F);
        graphics.blitSprite(BURN_PROGRESS_SPRITE, 24, 16, 0, 0, left + 58, top + 35, burnWidth, 16);
    }

    private void renderBaseSlotHint(GuiGraphics graphics, int x, int y) {
        Minecraft minecraft = this.minecraft;
        if (minecraft == null || minecraft.level == null) {
            return;
        }

        if (!this.menu.getSlot(0).getItem().isEmpty()) {
            return;
        }

        if (this.baseSlotHints.isEmpty()) {
            return;
        }

        long time = minecraft.level.getGameTime();
        int index = (int)((time / 20L) % (long)this.baseSlotHints.size());
        ItemStack hintStack = this.baseSlotHints.get(index);

        graphics.setColor(1.0F, 1.0F, 1.0F, 0.45F);
        graphics.renderItem(hintStack, x, y);
        graphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private List<ItemStack> collectBaseSlotHints() {
        List<ItemStack> hints = new ArrayList<>();
        for (Item item : BuiltInRegistries.ITEM) {
            ResourceLocation key = BuiltInRegistries.ITEM.getKey(item);
            if (!"lilis_pottery".equals(key.getNamespace())) {
                continue;
            }
            if (!(item instanceof BlockItem blockItem)) {
                continue;
            }
            if (!(blockItem.getBlock() instanceof AbstractStorageBlock) && !(blockItem.getBlock() instanceof UrnBlock)) {
                continue;
            }
            hints.add(new ItemStack(item));
        }
        return hints;
    }
}