package net.satisfy.lilis_pottery.core.inventory;

import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.satisfy.lilis_pottery.core.block.AbstractStorageBlock;
import net.satisfy.lilis_pottery.core.block.UrnBlock;
import net.satisfy.lilis_pottery.core.block.entity.KilnBlockEntity;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;
import net.satisfy.lilis_pottery.core.registry.ScreenHandlerRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class KilnScreenHandler extends AbstractContainerMenu {

    private static final int BASE_SLOT = 0;
    private static final int MODIFIER_SLOT = 1;
    private static final int FUEL_SLOT = 2;
    private static final int RESULT_SLOT = 3;

    private final ContainerLevelAccess context;
    private final Container container;
    private final ContainerData data;

    public KilnScreenHandler(int syncId, Inventory inventory) {
        this(syncId, inventory, null, new SimpleContainerData(4), ContainerLevelAccess.NULL);
    }

    public KilnScreenHandler(int syncId, Inventory inventory, Container container, ContainerData data, ContainerLevelAccess context) {
        super(ScreenHandlerRegistry.KILN_SCREEN_HANDLER.get(), syncId);

        this.context = context;
        this.data = data;

        this.container = Objects.requireNonNullElseGet(container, () -> new SimpleContainer(4) {
            @Override
            public void setChanged() {
                super.setChanged();
                KilnScreenHandler.this.slotsChanged(this);
            }
        });

        checkContainerSize(this.container, 4);
        checkContainerDataCount(this.data, 4);

        addSlot(new Slot(this.container, BASE_SLOT, 17, 17) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                if (!(stack.getItem() instanceof BlockItem blockItem)) {
                    return false;
                }
                Block block = blockItem.getBlock();
                return block instanceof AbstractStorageBlock || block instanceof UrnBlock;
            }
        });

        addSlot(new Slot(this.container, MODIFIER_SLOT, 35, 17) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof DyeItem;
            }
        });

        addSlot(new Slot(this.container, FUEL_SLOT, 26, 53) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return AbstractFurnaceBlockEntity.isFuel(stack);
            }
        });

        addSlot(new Slot(this.container, RESULT_SLOT, 95, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });

        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; ++column) {
            addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }

        addDataSlots(this.data);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.context, player, ObjectRegistry.KILN.get());
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int index) {
        ItemStack result;
        Slot slot = slots.get(index);
        if (!slot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = slot.getItem();
        result = stack.copy();

        int containerSlotCount = 4;
        int playerInvEnd = containerSlotCount + 36;

        if (index < containerSlotCount) {
            if (!moveItemStackTo(stack, containerSlotCount, playerInvEnd, true)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (AbstractFurnaceBlockEntity.isFuel(stack)) {
                if (!moveItemStackTo(stack, KilnBlockEntity.FUEL_SLOT, KilnBlockEntity.FUEL_SLOT + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!moveItemStackTo(stack, KilnBlockEntity.INPUT_SLOT, KilnBlockEntity.MODIFIER_SLOT + 1, false)) {
                    return ItemStack.EMPTY;
                }
            }
        }

        if (stack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }

        if (stack.getCount() == result.getCount()) {
            return ItemStack.EMPTY;
        }

        slot.onTake(player, stack);
        return result;
    }

    public float getBurnProgress() {
        int progress = data.get(2);
        int total = data.get(3);
        if (total == 0 || progress == 0) {
            return 0.0F;
        }
        return Mth.clamp((float) progress / (float) total, 0.0F, 1.0F);
    }

    public float getLitProgress() {
        int total = data.get(1);
        if (total == 0) {
            total = 200;
        }
        return Mth.clamp((float) data.get(0) / (float) total, 0.0F, 1.0F);
    }

    public boolean isLit() {
        return data.get(0) > 0;
    }
}