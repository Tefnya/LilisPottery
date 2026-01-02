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
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_CLAY_BALL.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BRICK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_BRICK.get(), ModelTemplates.FLAT_ITEM);

        generatePotteryFlatItems(itemModelGenerator);
    }

    private static void generatePotteryFlatItems(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ObjectRegistry.PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.RED_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.YELLOW_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.WHITE_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLUE_URN.get().asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_PLANTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_PLANT_BOWL.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_CUPELLA.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_BUD_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_VASE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_GARDEN_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_SQUARE_POT.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_AMPHORE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.BLACK_URN.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ObjectRegistry.LILIS_STATUE.get().asItem(), ModelTemplates.FLAT_ITEM);

    }
}
