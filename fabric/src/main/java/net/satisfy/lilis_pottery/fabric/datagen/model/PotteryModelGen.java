package net.satisfy.lilis_pottery.fabric.datagen.model;

import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.blockstates.VariantProperties.Rotation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.satisfy.lilis_pottery.core.block.AbstractStorageBlock;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;

public interface PotteryModelGen {

    static void generate(BlockModelGenerators modelGen) {
        simplePainted(modelGen, ObjectRegistry.BRICK_PLANT_BOWL.get(), model("brick_plant_bowl"), model("brick_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.BRICK_CUPELLA.get(), model("brick_cupella"), model("brick_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.BRICK_BUD_VASE.get(), model("brick_bud_vase"), model("brick_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BRICK_VASE.get(), model("brick_vase"), model("brick_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BRICK_GARDEN_POT.get(), model("brick_garden_pot"), model("brick_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.BRICK_SQUARE_POT.get(), model("brick_square_pot"), model("brick_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BRICK_PLANTER.get(), model("brick_planter"), model("brick_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BRICK_AMPHORE.get(), model("brick_amphore"), model("brick_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BRICK_URN.get(), model("brick_urn"), model("brick_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.RED_BRICK_PLANT_BOWL.get(), model("red_brick_plant_bowl"), model("red_brick_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_BRICK_CUPELLA.get(), model("red_brick_cupella"), model("red_brick_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_BRICK_BUD_VASE.get(), model("red_brick_bud_vase"), model("red_brick_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_BRICK_VASE.get(), model("red_brick_vase"), model("red_brick_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_BRICK_GARDEN_POT.get(), model("red_brick_garden_pot"), model("red_brick_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_BRICK_SQUARE_POT.get(), model("red_brick_square_pot"), model("red_brick_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.RED_BRICK_PLANTER.get(), model("red_brick_planter"), model("red_brick_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.RED_BRICK_AMPHORE.get(), model("red_brick_amphore"), model("red_brick_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.RED_BRICK_URN.get(), model("red_brick_urn"), model("red_brick_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.YELLOW_BRICK_PLANT_BOWL.get(), model("yellow_brick_plant_bowl"), model("yellow_brick_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_BRICK_CUPELLA.get(), model("yellow_brick_cupella"), model("yellow_brick_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_BRICK_BUD_VASE.get(), model("yellow_brick_bud_vase"), model("yellow_brick_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_BRICK_VASE.get(), model("yellow_brick_vase"), model("yellow_brick_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_BRICK_GARDEN_POT.get(), model("yellow_brick_garden_pot"), model("yellow_brick_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_BRICK_SQUARE_POT.get(), model("yellow_brick_square_pot"), model("yellow_brick_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.YELLOW_BRICK_PLANTER.get(), model("yellow_brick_planter"), model("yellow_brick_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.YELLOW_BRICK_AMPHORE.get(), model("yellow_brick_amphore"), model("yellow_brick_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.YELLOW_BRICK_URN.get(), model("yellow_brick_urn"), model("yellow_brick_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.WHITE_BRICK_PLANT_BOWL.get(), model("white_brick_plant_bowl"), model("white_brick_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_BRICK_CUPELLA.get(), model("white_brick_cupella"), model("white_brick_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_BRICK_BUD_VASE.get(), model("white_brick_bud_vase"), model("white_brick_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_BRICK_VASE.get(), model("white_brick_vase"), model("white_brick_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_BRICK_GARDEN_POT.get(), model("white_brick_garden_pot"), model("white_brick_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_BRICK_SQUARE_POT.get(), model("white_brick_square_pot"), model("white_brick_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.WHITE_BRICK_PLANTER.get(), model("white_brick_planter"), model("white_brick_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.WHITE_BRICK_AMPHORE.get(), model("white_brick_amphore"), model("white_brick_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.WHITE_BRICK_URN.get(), model("white_brick_urn"), model("white_brick_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.BLUE_BRICK_PLANT_BOWL.get(), model("blue_brick_plant_bowl"), model("blue_brick_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_BRICK_CUPELLA.get(), model("blue_brick_cupella"), model("blue_brick_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_BRICK_BUD_VASE.get(), model("blue_brick_bud_vase"), model("blue_brick_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_BRICK_VASE.get(), model("blue_brick_vase"), model("blue_brick_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_BRICK_GARDEN_POT.get(), model("blue_brick_garden_pot"), model("blue_brick_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_BRICK_SQUARE_POT.get(), model("blue_brick_square_pot"), model("blue_brick_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLUE_BRICK_PLANTER.get(), model("blue_brick_planter"), model("blue_brick_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLUE_BRICK_AMPHORE.get(), model("blue_brick_amphore"), model("blue_brick_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLUE_BRICK_URN.get(), model("blue_brick_urn"), model("blue_brick_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.DARK_BRICK_PLANT_BOWL.get(), model("dark_brick_plant_bowl"), model("dark_brick_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.DARK_BRICK_CUPELLA.get(), model("dark_brick_cupella"), model("dark_brick_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.DARK_BRICK_BUD_VASE.get(), model("dark_brick_bud_vase"), model("dark_brick_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.DARK_BRICK_VASE.get(), model("dark_brick_vase"), model("dark_brick_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.DARK_BRICK_GARDEN_POT.get(), model("dark_brick_garden_pot"), model("dark_brick_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.DARK_BRICK_SQUARE_POT.get(), model("dark_brick_square_pot"), model("dark_brick_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.DARK_BRICK_PLANTER.get(), model("dark_brick_planter"), model("dark_brick_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.DARK_BRICK_AMPHORE.get(), model("dark_brick_amphore"), model("dark_brick_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.DARK_BRICK_URN.get(), model("dark_brick_urn"), model("dark_brick_urn_tinted"));
    }

    private static void simplePainted(BlockModelGenerators modelGen, Block block, ResourceLocation normalModel, ResourceLocation tintedModel) {
        modelGen.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(block).with(
                        PropertyDispatch.property(AbstractStorageBlock.PAINTED)
                                .select(false, Variant.variant().with(VariantProperties.MODEL, normalModel))
                                .select(true, Variant.variant().with(VariantProperties.MODEL, tintedModel))
                )
        );
    }

    private static void directionalPainted(BlockModelGenerators modelGen, Block block, ResourceLocation normalModel, ResourceLocation tintedModel) {
        modelGen.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(block).with(
                        PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, AbstractStorageBlock.PAINTED)
                                .select(Direction.SOUTH, false, Variant.variant().with(VariantProperties.MODEL, normalModel).with(VariantProperties.Y_ROT, Rotation.R0))
                                .select(Direction.WEST, false, Variant.variant().with(VariantProperties.MODEL, normalModel).with(VariantProperties.Y_ROT, Rotation.R90))
                                .select(Direction.NORTH, false, Variant.variant().with(VariantProperties.MODEL, normalModel).with(VariantProperties.Y_ROT, Rotation.R180))
                                .select(Direction.EAST, false, Variant.variant().with(VariantProperties.MODEL, normalModel).with(VariantProperties.Y_ROT, Rotation.R270))
                                .select(Direction.SOUTH, true, Variant.variant().with(VariantProperties.MODEL, tintedModel).with(VariantProperties.Y_ROT, Rotation.R0))
                                .select(Direction.WEST, true, Variant.variant().with(VariantProperties.MODEL, tintedModel).with(VariantProperties.Y_ROT, Rotation.R90))
                                .select(Direction.NORTH, true, Variant.variant().with(VariantProperties.MODEL, tintedModel).with(VariantProperties.Y_ROT, Rotation.R180))
                                .select(Direction.EAST, true, Variant.variant().with(VariantProperties.MODEL, tintedModel).with(VariantProperties.Y_ROT, Rotation.R270))
                )
        );
    }

    private static ResourceLocation model(String path) {
        return ResourceLocation.fromNamespaceAndPath("lilis_pottery", "block/" + path);
    }
}