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

public class VaseBlock extends AbstractFlowerPotBlock {
    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(5.0, 0.0, 5.0, 11.0, 2.0, 11.0),
            Block.box(4.0, 2.0, 4.0, 12.0, 10.0, 12.0),
            Block.box(5.0, 10.0, 5.0, 11.0, 12.0, 11.0),
            Block.box(4.0, 12.0, 4.0, 12.0, 14.0, 12.0)
    );

    public VaseBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}