package net.satisfy.lilis_pottery.fabric.datagen.model;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;

import java.util.List;

public interface BricksModelGen {
    List<ResourceLocation> handmadeBricksVariants = ModelGenHelpers.variantIDs("handmade_bricks_%d", 3);

    static void generateAll(BlockModelGenerators modelGen) {
        generateHandmadeBricks(modelGen);
        generateHandmadeDerivativesFixed(modelGen);

        modelGen.createTrivialCube(ObjectRegistry.RED_CLAY.get());
        modelGen.createTrivialCube(ObjectRegistry.YELLOW_CLAY.get());
        modelGen.createTrivialCube(ObjectRegistry.WHITE_CLAY.get());
        modelGen.createTrivialCube(ObjectRegistry.BLUE_CLAY.get());
        modelGen.createTrivialCube(ObjectRegistry.BLACK_CLAY.get());

        modelGen.family(ObjectRegistry.RED_BRICKS.get())
                .stairs(ObjectRegistry.RED_BRICK_STAIRS.get())
                .slab(ObjectRegistry.RED_BRICK_SLAB.get())
                .wall(ObjectRegistry.RED_BRICK_WALL.get());

        modelGen.family(ObjectRegistry.YELLOW_BRICKS.get())
                .stairs(ObjectRegistry.YELLOW_BRICK_STAIRS.get())
                .slab(ObjectRegistry.YELLOW_BRICK_SLAB.get())
                .wall(ObjectRegistry.YELLOW_BRICK_WALL.get());

        modelGen.family(ObjectRegistry.WHITE_BRICKS.get())
                .stairs(ObjectRegistry.WHITE_BRICK_STAIRS.get())
                .slab(ObjectRegistry.WHITE_BRICK_SLAB.get())
                .wall(ObjectRegistry.WHITE_BRICK_WALL.get());

        modelGen.family(ObjectRegistry.BLUE_BRICKS.get())
                .stairs(ObjectRegistry.BLUE_BRICK_STAIRS.get())
                .slab(ObjectRegistry.BLUE_BRICK_SLAB.get())
                .wall(ObjectRegistry.BLUE_BRICK_WALL.get());

        modelGen.family(ObjectRegistry.BLACK_BRICKS.get())
                .stairs(ObjectRegistry.BLACK_BRICK_STAIRS.get())
                .slab(ObjectRegistry.BLACK_BRICK_SLAB.get())
                .wall(ObjectRegistry.BLACK_BRICK_WALL.get());

        modelGen.createTrivialCube(ObjectRegistry.CHISELED_BRICKS.get());
        modelGen.createTrivialCube(ObjectRegistry.CHISELED_RED_BRICKS.get());
        modelGen.createTrivialCube(ObjectRegistry.CHISELED_YELLOW_BRICKS.get());
        modelGen.createTrivialCube(ObjectRegistry.CHISELED_WHITE_BRICKS.get());
        modelGen.createTrivialCube(ObjectRegistry.CHISELED_BLUE_BRICKS.get());
        modelGen.createTrivialCube(ObjectRegistry.CHISELED_BLACK_BRICKS.get());
    }

    static void generateHandmadeBricks(BlockModelGenerators modelGen) {
        modelGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(
                ObjectRegistry.HANDMADE_BRICKS.get(), ModelGenHelpers.variantsA(handmadeBricksVariants)
        ));

        handmadeBricksVariants.forEach(variant -> ModelTemplates.CUBE_ALL.create(
                variant, TextureMapping.cube(variant), modelGen.modelOutput
        ));

        modelGen.delegateItemModel(ObjectRegistry.HANDMADE_BRICKS.get(), handmadeBricksVariants.get(1));
    }

    static void generateHandmadeDerivativesFixed(BlockModelGenerators modelGen) {
        ResourceLocation texture = handmadeBricksVariants.getFirst();

        var familyProvider = modelGen.new BlockFamilyProvider(TextureMapping.cube(texture));
        familyProvider.stairs(ObjectRegistry.HANDMADE_BRICK_STAIRS.get())
                .wall(ObjectRegistry.HANDMADE_BRICK_WALL.get());

        ModelGenHelpers.slabFromTex(modelGen, ObjectRegistry.HANDMADE_BRICK_SLAB, texture);
    }
}