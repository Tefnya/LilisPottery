package net.satisfy.lilis_pottery.core.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.nbt.CompoundTag;
import net.satisfy.lilis_pottery.core.registry.EntityTypeRegistry;
import org.jetbrains.annotations.NotNull;

public class UrnBlockEntity extends BlockEntity implements Container {
    private static final int SIZE = 41;
    private final NonNullList<ItemStack> items = NonNullList.withSize(SIZE, ItemStack.EMPTY);

    public UrnBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(EntityTypeRegistry.URN_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public void absorbFrom(Player player) {
        int index = 0;

        for (int slot = 0; slot < player.getInventory().items.size() && index < SIZE; slot++) {
            ItemStack stack = player.getInventory().items.get(slot);
            if (!stack.isEmpty()) {
                items.set(index++, stack.copy());
                player.getInventory().items.set(slot, ItemStack.EMPTY);
            }
        }

        for (int slot = 0; slot < player.getInventory().armor.size() && index < SIZE; slot++) {
            ItemStack stack = player.getInventory().armor.get(slot);
            if (!stack.isEmpty()) {
                items.set(index++, stack.copy());
                player.getInventory().armor.set(slot, ItemStack.EMPTY);
            }
        }

        for (int slot = 0; slot < player.getInventory().offhand.size() && index < SIZE; slot++) {
            ItemStack stack = player.getInventory().offhand.get(slot);
            if (!stack.isEmpty()) {
                items.set(index++, stack.copy());
                player.getInventory().offhand.set(slot, ItemStack.EMPTY);
            }
        }

        setChanged();
    }

    public void dropAll(Level level, BlockPos blockPos) {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                Block.popResource(level, blockPos, stack);
            }
        }
        clearContent();
        setChanged();
    }

    @Override
    public int getContainerSize() {
        return SIZE;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public @NotNull ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public @NotNull ItemStack removeItem(int slot, int amount) {
        ItemStack stack = ContainerHelper.removeItem(items, slot, amount);
        if (!stack.isEmpty()) setChanged();
        return stack;
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(items, slot);
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        items.set(slot, itemStack);
        setChanged();
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        for (int slot = 0; slot < SIZE; slot++) {
            items.set(slot, ItemStack.EMPTY);
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        ContainerHelper.saveAllItems(compoundTag, this.items, provider);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        ContainerHelper.loadAllItems(compoundTag, this.items, provider);
    }
}