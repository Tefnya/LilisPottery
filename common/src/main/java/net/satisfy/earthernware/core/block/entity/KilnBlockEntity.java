package net.satisfy.earthernware.core.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.satisfy.earthernware.core.inventory.KilnScreenHandler;
import net.satisfy.earthernware.core.recipe.FiringRecipe;
import net.satisfy.earthernware.core.registry.EntityTypeRegistry;
import net.satisfy.earthernware.core.registry.RecipeRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class KilnBlockEntity extends BlockEntity implements Container, MenuProvider, RecipeInput {

    public static final int INPUT_SLOT = 0;
    public static final int MODIFIER_SLOT = 1;
    public static final int FUEL_SLOT = 2;
    public static final int OUTPUT_SLOT = 3;

    private NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);

    private int burnTime;
    private int burnTimeTotal;
    private int progress;
    private int progressTotal = 200;

    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> burnTime;
                case 1 -> burnTimeTotal;
                case 2 -> progress;
                case 3 -> progressTotal;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> burnTime = value;
                case 1 -> burnTimeTotal = value;
                case 2 -> progress = value;
                case 3 -> progressTotal = value;
                default -> {
                }
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    public KilnBlockEntity(BlockPos pos, BlockState state) {
        super(EntityTypeRegistry.KILN_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, KilnBlockEntity kiln) {
        if (level.isClientSide) {
            return;
        }

        boolean wasLit = kiln.isBurning();
        boolean changed = false;

        if (kiln.burnTime > 0) {
            kiln.burnTime--;
            changed = true;
        }

        ItemStack fuelStack = kiln.items.get(FUEL_SLOT);

        Optional<RecipeHolder<FiringRecipe>> recipeHolder = kiln.getMatchingRecipe();
        FiringRecipe recipe = recipeHolder.map(RecipeHolder::value).orElse(null);
        boolean canCraft = recipe != null && kiln.canCraft(recipe);

        if (!kiln.isBurning() && canCraft && !fuelStack.isEmpty()) {
            int fuelTime = AbstractFurnaceBlockEntity.getFuel().getOrDefault(fuelStack.getItem(), 0);
            if (fuelTime > 0) {
                kiln.burnTime = fuelTime;
                kiln.burnTimeTotal = fuelTime;
                fuelStack.shrink(1);
                changed = true;
            }
        }

        if (kiln.isBurning() && canCraft) {
            kiln.progressTotal = recipe.burnTime();
            kiln.progress++;
            changed = true;

            if (kiln.progress >= kiln.progressTotal) {
                kiln.progress = 0;
                kiln.craft(recipe);
            }
        } else if (kiln.progress != 0) {
            kiln.progress = 0;
            changed = true;
        }

        boolean isLit = kiln.isBurning();
        if (wasLit != isLit) {
            level.setBlock(pos, state.setValue(BlockStateProperties.LIT, isLit), 3);
            changed = true;
        }

        if (changed) {
            kiln.setChanged();
        }
    }

    private boolean canCraft(FiringRecipe recipe) {
        ItemStack baseStack = items.get(INPUT_SLOT);
        ItemStack modifierStack = items.get(MODIFIER_SLOT);
        if (baseStack.isEmpty() || modifierStack.isEmpty()) {
            return false;
        }

        if (!recipe.base().test(baseStack) || !recipe.modifier().test(modifierStack)) {
            return false;
        }

        if (level == null) {
            return false;
        }

        ItemStack result = recipe.assemble(this, level.registryAccess());
        if (result.isEmpty()) {
            return false;
        }

        ItemStack outputStack = items.get(OUTPUT_SLOT);
        if (outputStack.isEmpty()) {
            return true;
        }

        if (!ItemStack.isSameItemSameComponents(outputStack, result)) {
            return false;
        }

        int combined = outputStack.getCount() + result.getCount();
        return combined <= outputStack.getMaxStackSize() && combined <= getMaxStackSize();
    }

    private void craft(FiringRecipe recipe) {
        ItemStack baseStack = items.get(INPUT_SLOT);
        ItemStack modifierStack = items.get(MODIFIER_SLOT);
        ItemStack outputStack = items.get(OUTPUT_SLOT);

        if (level == null) {
            return;
        }

        ItemStack result = recipe.assemble(this, level.registryAccess());
        if (result.isEmpty()) {
            return;
        }

        if (outputStack.isEmpty()) {
            items.set(OUTPUT_SLOT, result.copy());
        } else if (ItemStack.isSameItemSameComponents(outputStack, result)) {
            if (outputStack.getCount() + result.getCount() > outputStack.getMaxStackSize()) {
                return;
            }
            outputStack.grow(result.getCount());
        } else {
            return;
        }

        baseStack.shrink(1);
        modifierStack.shrink(1);
    }

    private Optional<RecipeHolder<FiringRecipe>> getMatchingRecipe() {
        if (level == null) {
            return Optional.empty();
        }
        return level.getRecipeManager().getRecipeFor(RecipeRegistry.FIRING.get(), this, level);
    }

    public boolean isBurning() {
        return burnTime > 0;
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public @NotNull ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public @NotNull ItemStack removeItem(int slot, int amount) {
        ItemStack removed = ContainerHelper.removeItem(items, slot, amount);
        if (!removed.isEmpty()) {
            setChanged();
        }
        return removed;
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int slot) {
        ItemStack removed = ContainerHelper.takeItem(items, slot);
        setChanged();
        return removed;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        items.set(slot, stack);
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
        setChanged();
    }

    @Override
    public boolean stillValid(Player player) {
        if (level == null) {
            return false;
        }
        if (level.getBlockEntity(worldPosition) != this) {
            return false;
        }
        return player.distanceToSqr(
                (double) worldPosition.getX() + 0.5D,
                (double) worldPosition.getY() + 0.5D,
                (double) worldPosition.getZ() + 0.5D
        ) <= 64.0D;
    }

    @Override
    public void clearContent() {
        items = NonNullList.withSize(4, ItemStack.EMPTY);
        setChanged();
    }

    @Override
    public @NotNull Component getDisplayName() {
        return this.getBlockState().getBlock().getName();
    }

    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new KilnScreenHandler(syncId, inventory, this, data, ContainerLevelAccess.create(level, worldPosition));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        items = NonNullList.withSize(4, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, items, provider);
        burnTime = tag.getInt("BurnTime");
        burnTimeTotal = tag.getInt("BurnTimeTotal");
        progress = tag.getInt("Progress");
        progressTotal = tag.getInt("ProgressTotal");
        super.loadAdditional(tag, provider);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        ContainerHelper.saveAllItems(tag, items, provider);
        tag.putInt("BurnTime", burnTime);
        tag.putInt("BurnTimeTotal", burnTimeTotal);
        tag.putInt("Progress", progress);
        tag.putInt("ProgressTotal", progressTotal);
        super.saveAdditional(tag, provider);
    }
}