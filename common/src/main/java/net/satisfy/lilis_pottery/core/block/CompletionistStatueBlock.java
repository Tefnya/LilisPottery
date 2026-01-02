package net.satisfy.lilis_pottery.core.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.lilis_pottery.core.event.FireworkTextEventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompletionistStatueBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private static final int COOLDOWN_TICKS = 600;

    private static final VoxelShape BOTTOM_SHAPE = makeBottomShape();
    private static final VoxelShape TOP_SHAPE = makeTopShape();

    private static final Map<Direction, VoxelShape> TOP_SHAPES = new HashMap<>();
    private static final Map<Direction, VoxelShape> BOTTOM_SHAPES = new HashMap<>();

    static {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            TOP_SHAPES.put(direction, rotateShape(direction, TOP_SHAPE));
            BOTTOM_SHAPES.put(direction, rotateShape(direction, BOTTOM_SHAPE));
        }
    }

    public CompletionistStatueBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        BlockPos abovePos = blockPos.above();

        if (blockPos.getY() >= level.getMaxBuildHeight() - 1) {
            return null;
        }

        if (!level.getBlockState(abovePos).canBeReplaced(context)) {
            return null;
        }

        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(HALF, DoubleBlockHalf.LOWER);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
        super.setPlacedBy(level, pos, state, placer, stack);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return InteractionResult.PASS;
        }

        if (player.getCooldowns().isOnCooldown(this.asItem())) {
            return InteractionResult.SUCCESS;
        }

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (!(level instanceof ServerLevel serverLevel)) {
            return InteractionResult.SUCCESS;
        }

        Vec3 launchPos = hit.getLocation().add(0.0, 0.1, 0.0);
        Direction facing = state.getValue(CompletionistStatueBlock.FACING);

        FireworkTextEventHandler.launch(serverLevel, launchPos, facing, player.getLookAngle(), "Lili's Pottery");
        player.getCooldowns().addCooldown(this.asItem(), COOLDOWN_TICKS);

        return InteractionResult.CONSUME;
    }


    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            BlockPos otherPos = state.getValue(HALF) == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.is(this)) {
                level.setBlock(otherPos, Blocks.AIR.defaultBlockState(), 35);
            }
        }

        super.onRemove(state, level, pos, newState, moved);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf half = state.getValue(HALF);

        if (direction == Direction.DOWN && half == DoubleBlockHalf.UPPER && neighborState.getBlock() != this) {
            return Blocks.AIR.defaultBlockState();
        }

        if (direction == Direction.UP && half == DoubleBlockHalf.LOWER && neighborState.getBlock() != this) {
            return Blocks.AIR.defaultBlockState();
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public @NotNull BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            DoubleBlockHalf half = state.getValue(HALF);
            BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.is(this) && otherState.getValue(HALF) != half) {
                boolean dropOther = half == DoubleBlockHalf.UPPER && !player.isCreative();
                level.destroyBlock(otherPos, dropOther, player);
            }
        }

        super.playerWillDestroy(level, pos, state, player);
        return state;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState belowState = level.getBlockState(pos.below());
            return belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
        return super.canSurvive(state, level, pos);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return state.getValue(HALF) == DoubleBlockHalf.UPPER ? TOP_SHAPES.get(facing) : BOTTOM_SHAPES.get(facing);
    }

    @Override
    public @NotNull List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            return Collections.emptyList();
        }
        return super.getDrops(state, builder);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    private static VoxelShape makeBottomShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.1875, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.1875, 0.375, 0.74375, 1, 0.625), BooleanOp.OR);
        return shape;
    }

    private static VoxelShape makeTopShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, -0.125, 0.375, 0.25, 0.625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.375, -0.190625, 1, 0.625, 0.559375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0, 0.375, 0.75, 0.6875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.6875, 0.25, 0.75, 1.1875, 0.75), BooleanOp.OR);
        return shape;
    }

    private static VoxelShape rotateShape(Direction to, VoxelShape shape) {
        if (Direction.NORTH == to) {
            return shape;
        }

        int steps = ((to.get2DDataValue() - Direction.NORTH.get2DDataValue()) + 4) % 4;
        VoxelShape rotated = shape;

        for (int i = 0; i < steps; i++) {
            VoxelShape[] next = new VoxelShape[]{Shapes.empty()};
            rotated.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
                double newMinX = 1.0 - maxZ;
                double newMaxX = 1.0 - minZ;
                next[0] = Shapes.or(next[0], Shapes.box(newMinX, minY, minX, newMaxX, maxY, maxX));
            });
            rotated = next[0];
        }

        return rotated;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int earthy = 0xB08D57;
        tooltipComponents.add(
                Component.translatable("tooltip.lilis_pottery.completionist_statue.thanks")
                        .withStyle(style -> style.withColor(TextColor.fromRgb(earthy)))
        );
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}