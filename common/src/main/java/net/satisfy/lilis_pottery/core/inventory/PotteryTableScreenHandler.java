package net.satisfy.lilis_pottery.core.inventory;

import com.google.common.collect.Lists;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.satisfy.lilis_pottery.core.recipe.PotteringRecipe;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;
import net.satisfy.lilis_pottery.core.registry.RecipeRegistry;
import net.satisfy.lilis_pottery.core.registry.ScreenHandlerRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PotteryTableScreenHandler extends AbstractContainerMenu {
    private static final int INPUT_SLOT = 0;
    private static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_END = 38;

    private final ContainerLevelAccess context;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level world;

    private List<RecipeHolder<PotteringRecipe>> recipes = Lists.newArrayList();
    private ItemStack inputStack = ItemStack.EMPTY;
    private long lastSoundTime;

    private final Slot inputSlot;

    private Runnable slotUpdateListener = () -> {
    };

    public final Container inputContainer;
    private final ResultContainer resultContainer = new ResultContainer();

    public PotteryTableScreenHandler(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, null, ContainerLevelAccess.NULL);
    }

    public PotteryTableScreenHandler(int syncId, Inventory playerInventory, Container input, ContainerLevelAccess context) {
        super(ScreenHandlerRegistry.POTTERY_TABLE_SCREEN_HANDLER.get(), syncId);
        this.context = context;
        this.world = playerInventory.player.level();

        if (input == null) {
            this.inputContainer = new SimpleContainer(1) {
                @Override
                public void setChanged() {
                    super.setChanged();
                    PotteryTableScreenHandler.this.slotsChanged(this);
                    PotteryTableScreenHandler.this.slotUpdateListener.run();
                }
            };
        } else {
            this.inputContainer = new Container() {
                @Override
                public int getContainerSize() {
                    return input.getContainerSize();
                }

                @Override
                public boolean isEmpty() {
                    return input.isEmpty();
                }

                @Override
                public @NotNull ItemStack getItem(int slot) {
                    return input.getItem(slot);
                }

                @Override
                public @NotNull ItemStack removeItem(int slot, int amount) {
                    return input.removeItem(slot, amount);
                }

                @Override
                public @NotNull ItemStack removeItemNoUpdate(int slot) {
                    return input.removeItemNoUpdate(slot);
                }

                @Override
                public void setItem(int slot, ItemStack stack) {
                    input.setItem(slot, stack);
                }

                @Override
                public void setChanged() {
                    input.setChanged();
                    PotteryTableScreenHandler.this.slotsChanged(this);
                    PotteryTableScreenHandler.this.slotUpdateListener.run();
                }

                @Override
                public boolean stillValid(Player player) {
                    return input.stillValid(player);
                }

                @Override
                public void clearContent() {
                    input.clearContent();
                }
            };
        }

        this.inputSlot = this.addSlot(new Slot(this.inputContainer, 0, 20, 33));
        this.addSlot(new Slot(this.resultContainer, 0, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public boolean mayPickup(Player player) {
                return PotteryTableScreenHandler.this.isValidRecipeIndex(PotteryTableScreenHandler.this.selectedRecipeIndex.get()) && this.hasItem();
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());

                PotteryTableScreenHandler.this.resultContainer.setItem(0, ItemStack.EMPTY);

                PotteryTableScreenHandler.this.inputSlot.remove(1);

                if (PotteryTableScreenHandler.this.inputSlot.hasItem()) {
                    PotteryTableScreenHandler.this.setupResultSlot();
                } else {
                    PotteryTableScreenHandler.this.selectedRecipeIndex.set(-1);
                    PotteryTableScreenHandler.this.broadcastChanges();
                }

                PotteryTableScreenHandler.this.context.execute((level, pos) -> {
                    long time = level.getGameTime();
                    if (PotteryTableScreenHandler.this.lastSoundTime != time) {
                        level.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        PotteryTableScreenHandler.this.lastSoundTime = time;
                    }
                });

                super.onTake(player, stack);
            }
        });

        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, 8 + column * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipe() {
        return this.selectedRecipeIndex.get();
    }

    public List<RecipeHolder<PotteringRecipe>> getAvailableRecipes() {
        return this.recipes;
    }

    public int getAvailableRecipeCount() {
        return this.recipes.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.context, player, ObjectRegistry.POTTERY_TABLE.get());
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (this.isValidRecipeIndex(id)) {
            this.selectedRecipeIndex.set(id);
            this.setupResultSlot();
            return true;
        }
        return false;
    }

    private boolean isValidRecipeIndex(int id) {
        return id >= 0 && id < this.recipes.size();
    }

    @Override
    public void slotsChanged(Container container) {
        ItemStack current = this.inputSlot.getItem();
        if (!ItemStack.isSameItemSameComponents(current, this.inputStack)) {
            this.inputStack = current.copy();
            this.setupRecipeList(container, current);
        }
    }

    private static SingleRecipeInput createRecipeInput(Container container) {
        return new SingleRecipeInput(container.getItem(0));
    }

    private void setupRecipeList(Container container, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultContainer.setItem(0, ItemStack.EMPTY);

        if (!stack.isEmpty()) {
            this.recipes = this.world.getRecipeManager().getRecipesFor(RecipeRegistry.POTTERING.get(), createRecipeInput(container), this.world);
        }

        this.broadcastChanges();
    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            RecipeHolder<PotteringRecipe> recipeHolder = this.recipes.get(this.selectedRecipeIndex.get());
            ItemStack result = recipeHolder.value().assemble(createRecipeInput(this.inputContainer), this.world.registryAccess());
            if (result.isItemEnabled(this.world.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(recipeHolder);
                this.resultContainer.setItem(0, result);
            } else {
                this.resultContainer.setItem(0, ItemStack.EMPTY);
            }
        } else {
            this.resultContainer.setItem(0, ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    @Override
    public @NotNull MenuType<?> getType() {
        return ScreenHandlerRegistry.POTTERY_TABLE_SCREEN_HANDLER.get();
    }

    public void setContentsChangedListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int index) {
        ItemStack moved = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            Item item = stack.getItem();
            moved = stack.copy();

            if (index == RESULT_SLOT) {
                item.onCraftedBy(stack, player.level(), player);
                if (!this.moveItemStackTo(stack, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(stack, moved);
            } else if (index == INPUT_SLOT) {
                if (!this.moveItemStackTo(stack, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.world.getRecipeManager().getRecipeFor(RecipeRegistry.POTTERING.get(), new SingleRecipeInput(stack), this.world).isPresent()) {
                if (!this.moveItemStackTo(stack, INPUT_SLOT, RESULT_SLOT, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= INV_SLOT_START && index < INV_SLOT_END) {
                if (!this.moveItemStackTo(stack, INV_SLOT_END, USE_ROW_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= INV_SLOT_END && index < USE_ROW_SLOT_END) {
                if (!this.moveItemStackTo(stack, INV_SLOT_START, INV_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stack, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();

            if (stack.getCount() == moved.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);
            this.broadcastChanges();
        }

        return moved;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(0);
        this.context.execute((level, blockPos) -> this.clearContainer(player, this.inputContainer));
    }
}