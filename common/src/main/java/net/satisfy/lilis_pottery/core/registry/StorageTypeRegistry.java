package net.satisfy.lilis_pottery.core.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.satisfy.lilis_pottery.LilisPottery;

import java.util.Set;

public class StorageTypeRegistry {
    public static final ResourceLocation FLOWER_POT = LilisPottery.identifier("flower_pot");
    public static final ResourceLocation TALL_FLOWER_POT = LilisPottery.identifier("tall_flower_pot");
    public static final ResourceLocation PLANTER = LilisPottery.identifier("planter");

    public static Set<Block> registerBlocks(Set<Block> blocks) {
        blocks.add(ObjectRegistry.BRICK_PLANTER.get());
        blocks.add(ObjectRegistry.BRICK_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.BRICK_CUPELLA.get());
        blocks.add(ObjectRegistry.BRICK_BUD_VASE.get());
        blocks.add(ObjectRegistry.BRICK_VASE.get());
        blocks.add(ObjectRegistry.BRICK_GARDEN_POT.get());
        blocks.add(ObjectRegistry.BRICK_SQUARE_POT.get());
        blocks.add(ObjectRegistry.RED_BRICK_PLANTER.get());
        blocks.add(ObjectRegistry.RED_BRICK_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.RED_BRICK_CUPELLA.get());
        blocks.add(ObjectRegistry.RED_BRICK_BUD_VASE.get());
        blocks.add(ObjectRegistry.RED_BRICK_VASE.get());
        blocks.add(ObjectRegistry.RED_BRICK_GARDEN_POT.get());
        blocks.add(ObjectRegistry.RED_BRICK_SQUARE_POT.get());
        blocks.add(ObjectRegistry.YELLOW_BRICK_PLANTER.get());
        blocks.add(ObjectRegistry.YELLOW_BRICK_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.YELLOW_BRICK_CUPELLA.get());
        blocks.add(ObjectRegistry.YELLOW_BRICK_BUD_VASE.get());
        blocks.add(ObjectRegistry.YELLOW_BRICK_VASE.get());
        blocks.add(ObjectRegistry.YELLOW_BRICK_GARDEN_POT.get());
        blocks.add(ObjectRegistry.YELLOW_BRICK_SQUARE_POT.get());
        blocks.add(ObjectRegistry.WHITE_BRICK_PLANTER.get());
        blocks.add(ObjectRegistry.WHITE_BRICK_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.WHITE_BRICK_CUPELLA.get());
        blocks.add(ObjectRegistry.WHITE_BRICK_BUD_VASE.get());
        blocks.add(ObjectRegistry.WHITE_BRICK_VASE.get());
        blocks.add(ObjectRegistry.WHITE_BRICK_GARDEN_POT.get());
        blocks.add(ObjectRegistry.WHITE_BRICK_SQUARE_POT.get());
        blocks.add(ObjectRegistry.BLUE_BRICK_PLANTER.get());
        blocks.add(ObjectRegistry.BLUE_BRICK_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.BLUE_BRICK_CUPELLA.get());
        blocks.add(ObjectRegistry.BLUE_BRICK_BUD_VASE.get());
        blocks.add(ObjectRegistry.BLUE_BRICK_VASE.get());
        blocks.add(ObjectRegistry.BLUE_BRICK_GARDEN_POT.get());
        blocks.add(ObjectRegistry.BLUE_BRICK_SQUARE_POT.get());
        blocks.add(ObjectRegistry.DARK_BRICK_PLANTER.get());
        blocks.add(ObjectRegistry.DARK_BRICK_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.DARK_BRICK_CUPELLA.get());
        blocks.add(ObjectRegistry.DARK_BRICK_BUD_VASE.get());
        blocks.add(ObjectRegistry.DARK_BRICK_VASE.get());
        blocks.add(ObjectRegistry.DARK_BRICK_GARDEN_POT.get());
        blocks.add(ObjectRegistry.DARK_BRICK_SQUARE_POT.get());

        return blocks;
    }
}