package net.satisfy.lilis_pottery.fabric.datagen.model;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;

public class EWModelGen extends FabricModelProvider {

    public EWModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGen) {
        BricksModelGen.generateAll(modelGen);
        PotteryModelGen.generate(modelGen);
        PotteryParentModelGen.generate(modelGen);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_CLAY_BALL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_CLAY_BALL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_CLAY_BALL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_CLAY_BALL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_CLAY_BALL.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK.get(), ModelTemplates.FLAT_ITEM);

        generatePotteryFlatItems(itemModelGenerator);
    }

    private static void generatePotteryFlatItems(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BRICK_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.DARK_BRICK_URN.get().asItem(), ModelTemplates.FLAT_ITEM);
    }

}
