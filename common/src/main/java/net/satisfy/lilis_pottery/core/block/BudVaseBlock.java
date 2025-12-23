package net.satisfy.lilis_pottery.core.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BudVaseBlock extends AbstractFlowerPotBlock {
    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(6.0, 0.0, 6.0, 10.0, 1.0, 10.0),
            Block.box(5.0, 1.0, 5.0, 11.0, 7.0, 11.0),
            Block.box(6.0, 7.0, 6.0, 10.0, 9.0, 10.0),
            Block.box(5.0, 9.0, 5.0, 11.0, 11.0, 11.0)
    );

    public BudVaseBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}