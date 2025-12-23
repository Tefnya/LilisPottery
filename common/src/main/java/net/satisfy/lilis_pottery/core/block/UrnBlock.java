package net.satisfy.lilis_pottery.core.block;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.lilis_pottery.core.block.entity.UrnBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.satisfy.lilis_pottery.core.block.AbstractStorageBlock.nearestDyeColor;

public class UrnBlock extends AbstractFacingBlock implements EntityBlock {
    public enum Variant {
        URN,
        AMPHORE
    }

    public static final BooleanProperty PAINTED = AbstractFlowerPotBlock.PAINTED;

    private static final VoxelShape URN_SHAPE = Shapes.or(
            Block.box(4.0, 0.0, 4.0, 12.0, 10.0, 12.0),
            Block.box(5.0, 10.0, 5.0, 11.0, 14.0, 11.0),
            Block.box(4.0, 14.0, 4.0, 12.0, 16.0, 12.0)
    );

    private static final VoxelShape AMPHORE_SHAPE = Shapes.or(
            Block.box(5.0, 0.0, 5.0, 11.0, 1.0, 11.0),
            Block.box(4.0, 1.0, 4.0, 12.0, 9.0, 12.0),
            Block.box(6.0, 9.0, 6.0, 10.0, 14.0, 10.0),
            Block.box(5.0, 14.0, 5.0, 11.0, 16.0, 11.0)
    );

    private final Variant variant;

    public UrnBlock(BlockBehaviour.Properties properties, Variant variant) {
        super(properties);
        this.variant = variant;
        registerDefaultState(defaultBlockState().setValue(PAINTED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(PAINTED);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new UrnBlockEntity(blockPos, blockState);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return variant == Variant.URN ? URN_SHAPE : AMPHORE_SHAPE;
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return variant == Variant.URN ? URN_SHAPE : AMPHORE_SHAPE;
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int earthy = 0xB08D57;
        int gold = 0xFFD700;

        tooltipComponents.add(Component.translatable("tooltip.lilis_pottery.canbeplaced")
                .withStyle(Style.EMPTY.withColor(TextColor.fromRgb(earthy))));

        if (!Screen.hasShiftDown()) {
            Component key = Component.literal("[SHIFT]").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(gold)));
            tooltipComponents.add(Component.translatable("tooltip.lilis_pottery.tooltip_information.hold", key)
                    .withStyle(Style.EMPTY.withColor(TextColor.fromRgb(earthy))));
            return;
        }

        tooltipComponents.add(Component.translatable("tooltip.lilis_pottery.pot.info")
                .withStyle(Style.EMPTY.withColor(TextColor.fromRgb(earthy))));

        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            CompoundTag tag = customData.copyTag();
            boolean painted = tag.contains("painted", 1) && tag.getBoolean("painted");
            int rgb = tag.contains("sideColorRgb", 99) ? tag.getInt("sideColorRgb") : 0;

            if (painted && rgb != 0) {
                tooltipComponents.add(Component.empty());

                DyeColor nearest = nearestDyeColor(rgb);
                Component colorName = Component.translatable("color.minecraft." + nearest.getName())
                        .withStyle(style -> style.withColor(rgb & 0xFFFFFF));

                tooltipComponents.add(Component.translatable("tooltip.lilis_pottery.painted", colorName)
                        .withStyle(Style.EMPTY.withColor(TextColor.fromRgb(earthy))));
            }
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!level.isClientSide && state.getBlock() != newState.getBlock() && level instanceof ServerLevel serverLevel) {
            BlockEntity blockEntity = serverLevel.getBlockEntity(pos);
            if (blockEntity instanceof UrnBlockEntity urnBlockEntity) {
                urnBlockEntity.dropAll(serverLevel, pos);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public @NotNull BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        super.playerWillDestroy(level, pos, state, player);
        return state;
    }
}