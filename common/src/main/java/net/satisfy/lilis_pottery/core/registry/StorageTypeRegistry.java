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
        blocks.add(ObjectRegistry.PLANTER.get());
        blocks.add(ObjectRegistry.PLANT_BOWL.get());
        blocks.add(ObjectRegistry.CUPELLA.get());
        blocks.add(ObjectRegistry.BUD_VASE.get());
        blocks.add(ObjectRegistry.VASE.get());
        blocks.add(ObjectRegistry.GARDEN_POT.get());
        blocks.add(ObjectRegistry.SQUARE_POT.get());
        blocks.add(ObjectRegistry.RED_PLANTER.get());
        blocks.add(ObjectRegistry.RED_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.RED_CUPELLA.get());
        blocks.add(ObjectRegistry.RED_BUD_VASE.get());
        blocks.add(ObjectRegistry.RED_VASE.get());
        blocks.add(ObjectRegistry.RED_GARDEN_POT.get());
        blocks.add(ObjectRegistry.RED_SQUARE_POT.get());
        blocks.add(ObjectRegistry.YELLOW_PLANTER.get());
        blocks.add(ObjectRegistry.YELLOW_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.YELLOW_CUPELLA.get());
        blocks.add(ObjectRegistry.YELLOW_BUD_VASE.get());
        blocks.add(ObjectRegistry.YELLOW_VASE.get());
        blocks.add(ObjectRegistry.YELLOW_GARDEN_POT.get());
        blocks.add(ObjectRegistry.YELLOW_SQUARE_POT.get());
        blocks.add(ObjectRegistry.WHITE_PLANTER.get());
        blocks.add(ObjectRegistry.WHITE_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.WHITE_CUPELLA.get());
        blocks.add(ObjectRegistry.WHITE_BUD_VASE.get());
        blocks.add(ObjectRegistry.WHITE_VASE.get());
        blocks.add(ObjectRegistry.WHITE_GARDEN_POT.get());
        blocks.add(ObjectRegistry.WHITE_SQUARE_POT.get());
        blocks.add(ObjectRegistry.BLUE_PLANTER.get());
        blocks.add(ObjectRegistry.BLUE_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.BLUE_CUPELLA.get());
        blocks.add(ObjectRegistry.BLUE_BUD_VASE.get());
        blocks.add(ObjectRegistry.BLUE_VASE.get());
        blocks.add(ObjectRegistry.BLUE_GARDEN_POT.get());
        blocks.add(ObjectRegistry.BLUE_SQUARE_POT.get());
        blocks.add(ObjectRegistry.BLACK_PLANTER.get());
        blocks.add(ObjectRegistry.BLACK_PLANT_BOWL.get());
        blocks.add(ObjectRegistry.BLACK_CUPELLA.get());
        blocks.add(ObjectRegistry.BLACK_BUD_VASE.get());
        blocks.add(ObjectRegistry.BLACK_VASE.get());
        blocks.add(ObjectRegistry.BLACK_GARDEN_POT.get());
        blocks.add(ObjectRegistry.BLACK_SQUARE_POT.get());

        return blocks;
    }
}