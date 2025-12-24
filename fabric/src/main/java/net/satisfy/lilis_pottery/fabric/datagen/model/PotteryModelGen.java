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
        simplePainted(modelGen, ObjectRegistry.PLANT_BOWL.get(), model("plant_bowl"), model("plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.CUPELLA.get(), model("cupella"), model("cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.BUD_VASE.get(), model("bud_vase"), model("bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.VASE.get(), model("vase"), model("vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.GARDEN_POT.get(), model("garden_pot"), model("garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.SQUARE_POT.get(), model("square_pot"), model("square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.PLANTER.get(), model("planter"), model("planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.AMPHORE.get(), model("amphore"), model("amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.URN.get(), model("urn"), model("urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.RED_PLANT_BOWL.get(), model("red_plant_bowl"), model("red_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_CUPELLA.get(), model("red_cupella"), model("red_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_BUD_VASE.get(), model("red_bud_vase"), model("red_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_VASE.get(), model("red_vase"), model("red_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_GARDEN_POT.get(), model("red_garden_pot"), model("red_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.RED_SQUARE_POT.get(), model("red_square_pot"), model("red_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.RED_PLANTER.get(), model("red_planter"), model("red_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.RED_AMPHORE.get(), model("red_amphore"), model("red_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.RED_URN.get(), model("red_urn"), model("red_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.YELLOW_PLANT_BOWL.get(), model("yellow_plant_bowl"), model("yellow_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_CUPELLA.get(), model("yellow_cupella"), model("yellow_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_BUD_VASE.get(), model("yellow_bud_vase"), model("yellow_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_VASE.get(), model("yellow_vase"), model("yellow_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_GARDEN_POT.get(), model("yellow_garden_pot"), model("yellow_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.YELLOW_SQUARE_POT.get(), model("yellow_square_pot"), model("yellow_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.YELLOW_PLANTER.get(), model("yellow_planter"), model("yellow_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.YELLOW_AMPHORE.get(), model("yellow_amphore"), model("yellow_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.YELLOW_URN.get(), model("yellow_urn"), model("yellow_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.WHITE_PLANT_BOWL.get(), model("white_plant_bowl"), model("white_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_CUPELLA.get(), model("white_cupella"), model("white_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_BUD_VASE.get(), model("white_bud_vase"), model("white_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_VASE.get(), model("white_vase"), model("white_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_GARDEN_POT.get(), model("white_garden_pot"), model("white_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.WHITE_SQUARE_POT.get(), model("white_square_pot"), model("white_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.WHITE_PLANTER.get(), model("white_planter"), model("white_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.WHITE_AMPHORE.get(), model("white_amphore"), model("white_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.WHITE_URN.get(), model("white_urn"), model("white_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.BLUE_PLANT_BOWL.get(), model("blue_plant_bowl"), model("blue_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_CUPELLA.get(), model("blue_cupella"), model("blue_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_BUD_VASE.get(), model("blue_bud_vase"), model("blue_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_VASE.get(), model("blue_vase"), model("blue_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_GARDEN_POT.get(), model("blue_garden_pot"), model("blue_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLUE_SQUARE_POT.get(), model("blue_square_pot"), model("blue_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLUE_PLANTER.get(), model("blue_planter"), model("blue_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLUE_AMPHORE.get(), model("blue_amphore"), model("blue_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLUE_URN.get(), model("blue_urn"), model("blue_urn_tinted"));

        simplePainted(modelGen, ObjectRegistry.BLACK_PLANT_BOWL.get(), model("black_plant_bowl"), model("black_plant_bowl_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLACK_CUPELLA.get(), model("black_cupella"), model("black_cupella_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLACK_BUD_VASE.get(), model("black_bud_vase"), model("black_bud_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLACK_VASE.get(), model("black_vase"), model("black_vase_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLACK_GARDEN_POT.get(), model("black_garden_pot"), model("black_garden_pot_tinted"));
        simplePainted(modelGen, ObjectRegistry.BLACK_SQUARE_POT.get(), model("black_square_pot"), model("black_square_pot_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLACK_PLANTER.get(), model("black_planter"), model("black_planter_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLACK_AMPHORE.get(), model("black_amphore"), model("black_amphore_tinted"));
        directionalPainted(modelGen, ObjectRegistry.BLACK_URN.get(), model("black_urn"), model("black_urn_tinted"));
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