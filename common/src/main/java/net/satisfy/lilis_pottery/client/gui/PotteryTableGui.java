package net.satisfy.lilis_pottery.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.satisfy.lilis_pottery.core.inventory.PotteryTableScreenHandler;
import net.satisfy.lilis_pottery.core.recipe.PotteringRecipe;

import java.util.List;

public class PotteryTableGui extends AbstractContainerScreen<PotteryTableScreenHandler> {
    private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller");
    private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller_disabled");
    private static final ResourceLocation RECIPE_SELECTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_selected");
    private static final ResourceLocation RECIPE_HIGHLIGHTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_highlighted");
    private static final ResourceLocation RECIPE_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe");
    private static final ResourceLocation TEXTURE = ResourceLocation.withDefaultNamespace("textures/gui/container/stonecutter.png");

    private float scrollAmount;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public PotteryTableGui(PotteryTableScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
        handler.setContentsChangedListener(this::containerChanged);
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

        int scrollerOffset = (int)(41.0F * this.scrollAmount);
        ResourceLocation scrollerSprite = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
        graphics.blitSprite(scrollerSprite, left + 119, top + 15 + scrollerOffset, 12, 15);

        int recipesX = left + 52;
        int recipesY = top + 14;
        int endIndex = this.startIndex + 12;

        this.renderButtons(graphics, mouseX, mouseY, recipesX, recipesY, endIndex);
        this.renderRecipes(graphics, recipesX, recipesY, endIndex);
    }

    @Override
    protected void renderTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
        super.renderTooltip(graphics, mouseX, mouseY);

        if (!this.displayRecipes) {
            return;
        }

        int recipesX = this.leftPos + 52;
        int recipesY = this.topPos + 14;
        int endIndex = this.startIndex + 12;

        List<RecipeHolder<PotteringRecipe>> recipes = this.menu.getAvailableRecipes();

        for (int index = this.startIndex; index < endIndex && index < this.menu.getAvailableRecipeCount(); index++) {
            int localIndex = index - this.startIndex;
            int buttonX = recipesX + localIndex % 4 * 16;
            int buttonY = recipesY + localIndex / 4 * 18 + 2;

            if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                Minecraft minecraft = this.minecraft;
                if (minecraft != null && minecraft.level != null) {
                    graphics.renderTooltip(this.font, recipes.get(index).value().getResultItem(minecraft.level.registryAccess()), mouseX, mouseY);
                }
                return;
            }
        }
    }

    private void renderButtons(GuiGraphics graphics, int mouseX, int mouseY, int x, int y, int endIndex) {
        for (int index = this.startIndex; index < endIndex && index < this.menu.getAvailableRecipeCount(); index++) {
            int localIndex = index - this.startIndex;
            int buttonX = x + localIndex % 4 * 16;
            int row = localIndex / 4;
            int buttonY = y + row * 18 + 2;

            ResourceLocation sprite;
            if (index == this.menu.getSelectedRecipe()) {
                sprite = RECIPE_SELECTED_SPRITE;
            } else if (mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + 16 && mouseY < buttonY + 18) {
                sprite = RECIPE_HIGHLIGHTED_SPRITE;
            } else {
                sprite = RECIPE_SPRITE;
            }

            graphics.blitSprite(sprite, buttonX, buttonY - 1, 16, 18);
        }
    }

    private void renderRecipes(GuiGraphics graphics, int x, int y, int endIndex) {
        List<RecipeHolder<PotteringRecipe>> recipes = this.menu.getAvailableRecipes();

        for (int index = this.startIndex; index < endIndex && index < this.menu.getAvailableRecipeCount(); index++) {
            int localIndex = index - this.startIndex;
            int itemX = x + localIndex % 4 * 16;
            int row = localIndex / 4;
            int itemY = y + row * 18 + 2;

            Minecraft minecraft = this.minecraft;
            if (minecraft != null && minecraft.level != null) {
                graphics.renderItem(recipes.get(index).value().getResultItem(minecraft.level.registryAccess()), itemX, itemY);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;

        if (this.displayRecipes) {
            int recipesX = this.leftPos + 52;
            int recipesY = this.topPos + 14;
            int endIndex = this.startIndex + 12;

            for (int index = this.startIndex; index < endIndex && index < this.menu.getAvailableRecipeCount(); index++) {
                int localIndex = index - this.startIndex;
                double localMouseX = mouseX - (double)(recipesX + localIndex % 4 * 16);
                double localMouseY = mouseY - (double)(recipesY + localIndex / 4 * 18);

                if (localMouseX >= 0.0 && localMouseY >= 0.0 && localMouseX < 16.0 && localMouseY < 18.0) {
                    assert this.minecraft != null;
                    if (this.menu.clickMenuButton(this.minecraft.player, index)) {
                        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                        assert this.minecraft.gameMode != null;
                        this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, index);
                        return true;
                    }
                }
            }

            int scrollerX = this.leftPos + 119;
            int scrollerY = this.topPos + 9;
            if (mouseX >= (double)scrollerX && mouseX < (double)(scrollerX + 12) && mouseY >= (double)scrollerY && mouseY < (double)(scrollerY + 54)) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int startY = this.topPos + 14;
            int endY = startY + 54;
            this.scrollAmount = ((float)mouseY - (float)startY - 7.5F) / ((float)(endY - startY) - 15.0F);
            this.scrollAmount = Mth.clamp(this.scrollAmount, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollAmount * (float)this.getMaxScroll()) + 0.5) * 4;
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amountX, double amountY) {
        if (this.isScrollBarActive()) {
            int max = this.getMaxScroll();
            float delta = (float)amountY / (float)max;
            this.scrollAmount = Mth.clamp(this.scrollAmount - delta, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollAmount * (float)max) + 0.5) * 4;
        }
        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getAvailableRecipeCount() > 12;
    }

    protected int getMaxScroll() {
        return (this.menu.getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    private void containerChanged() {
        this.displayRecipes = this.menu.canCraft();
        if (!this.displayRecipes) {
            this.scrollAmount = 0.0F;
            this.startIndex = 0;
        }
    }
}