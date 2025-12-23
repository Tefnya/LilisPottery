package net.satisfy.earthernware.fabric.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.satisfy.earthernware.core.block.AbstractStorageBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrushItem.class)
public abstract class BrushItemMixin {

    @Unique
    private static final int EARTHERNWARE_UNPAINT_TICKS = 100;

    @Shadow
    private HitResult calculateHitResult(Player player) {
        return null;
    }

    @Shadow
    public abstract int getUseDuration(ItemStack itemStack, LivingEntity livingEntity);

    @Inject(method = "onUseTick", at = @At("HEAD"))
    private void earthernware$brushRemovePaint(Level level, LivingEntity livingEntity, ItemStack itemStack, int remainingUseTicks, CallbackInfo callbackInfo) {
        if (!(livingEntity instanceof Player player)) {
            return;
        }

        HitResult hitResult = this.calculateHitResult(player);
        if (!(hitResult instanceof BlockHitResult blockHitResult) || hitResult.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockPos blockPos = blockHitResult.getBlockPos();
        BlockState blockState = level.getBlockState(blockPos);

        if (!(blockState.getBlock() instanceof AbstractStorageBlock)) {
            return;
        }

        if (!blockState.hasProperty(AbstractStorageBlock.PAINTED) || !blockState.getValue(AbstractStorageBlock.PAINTED)) {
            return;
        }

        int useDuration = this.getUseDuration(itemStack, livingEntity);
        int elapsedTicks = useDuration - remainingUseTicks + 1;

        if (elapsedTicks < EARTHERNWARE_UNPAINT_TICKS) {
            return;
        }

        if (!level.isClientSide) {
            level.setBlock(blockPos, blockState.setValue(AbstractStorageBlock.PAINTED, false), Block.UPDATE_ALL);
        }
    }
}