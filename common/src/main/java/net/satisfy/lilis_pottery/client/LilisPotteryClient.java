package net.satisfy.lilis_pottery.client;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.satisfy.lilis_pottery.client.gui.KilnGui;
import net.satisfy.lilis_pottery.client.gui.PotteryTableGui;
import net.satisfy.lilis_pottery.client.renderer.*;
import net.satisfy.lilis_pottery.client.util.StoragePaintTintUtil;
import net.satisfy.lilis_pottery.core.block.BudVaseBlock;
import net.satisfy.lilis_pottery.core.block.CupellaBlock;
import net.satisfy.lilis_pottery.core.block.GardenPotBlock;
import net.satisfy.lilis_pottery.core.block.PlanterBlock;
import net.satisfy.lilis_pottery.core.block.PlantBowlBlock;
import net.satisfy.lilis_pottery.core.block.VaseBlock;
import net.satisfy.lilis_pottery.core.registry.EntityTypeRegistry;
import net.satisfy.lilis_pottery.core.registry.ScreenHandlerRegistry;
import net.satisfy.lilis_pottery.core.registry.StorageTypeRegistry;

import static net.satisfy.lilis_pottery.core.registry.ObjectRegistry.*;

public class LilisPotteryClient {

    public static void onInitializeClient() {
        RenderTypeRegistry.register(
                RenderType.cutout(),
                POTTERY_TABLE.get(),
                LILIS_POTTERY_TABLE.get(),
                PLANTER.get(),
                GARDEN_POT.get(),
                SQUARE_POT.get(),
                VASE.get(),
                BUD_VASE.get(),
                CUPELLA.get(),
                PLANT_BOWL.get(),
                AMPHORE.get(),
                RED_PLANTER.get(),
                RED_GARDEN_POT.get(),
                RED_SQUARE_POT.get(),
                RED_VASE.get(),
                RED_BUD_VASE.get(),
                RED_CUPELLA.get(),
                RED_PLANT_BOWL.get(),
                RED_AMPHORE.get(),
                YELLOW_PLANTER.get(),
                YELLOW_GARDEN_POT.get(),
                YELLOW_SQUARE_POT.get(),
                YELLOW_VASE.get(),
                YELLOW_BUD_VASE.get(),
                YELLOW_CUPELLA.get(),
                YELLOW_PLANT_BOWL.get(),
                YELLOW_AMPHORE.get(),
                WHITE_PLANTER.get(),
                WHITE_GARDEN_POT.get(),
                WHITE_SQUARE_POT.get(),
                WHITE_VASE.get(),
                WHITE_BUD_VASE.get(),
                WHITE_CUPELLA.get(),
                WHITE_PLANT_BOWL.get(),
                WHITE_AMPHORE.get(),
                BLUE_PLANTER.get(),
                BLUE_GARDEN_POT.get(),
                BLUE_SQUARE_POT.get(),
                BLUE_VASE.get(),
                BLUE_BUD_VASE.get(),
                BLUE_CUPELLA.get(),
                BLUE_PLANT_BOWL.get(),
                BLUE_AMPHORE.get(),
                BLACK_PLANTER.get(),
                BLACK_GARDEN_POT.get(),
                BLACK_SQUARE_POT.get(),
                BLACK_VASE.get(),
                BLACK_BUD_VASE.get(),
                BLACK_CUPELLA.get(),
                BLACK_PLANT_BOWL.get(),
                BLACK_AMPHORE.get(),
                LILITU_STATUE.get()
        );

        ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return -1;
            }
            return BiomeColors.getAverageWaterColor(world, pos);
        }, POTTERY_TABLE.get(), LILIS_POTTERY_TABLE.get());

        ColorHandlerRegistry.registerItemColors((stack, tintIndex) -> {
            if (tintIndex != 0) {
                return -1;
            }
            return 4159204;
        }, POTTERY_TABLE.get().asItem(), LILIS_POTTERY_TABLE.get().asItem());

        registerClientScreens();
        registerStorageTypeRenderers();
        registerBlockTransforms();
        registerBlockEntityRenderer();

        StoragePaintTintUtil.register();
    }

    public static void preInitClient() {
        registerEntityRenderers();
        registerEntityModelLayer();
    }

    public static void registerEntityRenderers() {
    }

    public static void registerEntityModelLayer() {
    }

    public static void registerStorageTypeRenderers() {
        AbstractStorageBlockEntityRenderer.registerStorageType(StorageTypeRegistry.PLANTER, new PlanterRenderer());
        AbstractStorageBlockEntityRenderer.registerStorageType(StorageTypeRegistry.FLOWER_POT, new FlowerPotRenderer());
        AbstractStorageBlockEntityRenderer.registerStorageType(StorageTypeRegistry.TALL_FLOWER_POT, new TallFlowerPotRenderer());
    }

    public static void registerBlockTransforms() {
        AbstractStorageBlockEntityRenderer.registerClassTransform(PlanterBlock.class, new AbstractStorageBlockEntityRenderer.RenderTransform(0.225f, 0.25f, 0f, 1.0f, -90.0f));
        AbstractStorageBlockEntityRenderer.registerClassTransform(VaseBlock.class, new AbstractStorageBlockEntityRenderer.RenderTransform(-0.5f, 0.8f, -0.5f, 1.0f, 0.0f));
        AbstractStorageBlockEntityRenderer.registerClassTransform(BudVaseBlock.class, new AbstractStorageBlockEntityRenderer.RenderTransform(-0.5f, 0.6f, -0.5f, 1.0f, 0.0f));
        AbstractStorageBlockEntityRenderer.registerClassTransform(CupellaBlock.class, new AbstractStorageBlockEntityRenderer.RenderTransform(-0.5f, 0.3f, -0.5f, 1.0f, 0.0f));
        AbstractStorageBlockEntityRenderer.registerClassTransform(PlantBowlBlock.class, new AbstractStorageBlockEntityRenderer.RenderTransform(-0.5f, 0.4f, -0.5f, 1.0f, 0.0f));
        AbstractStorageBlockEntityRenderer.registerClassTransform(GardenPotBlock.class, new AbstractStorageBlockEntityRenderer.RenderTransform(-0.5f, 0.6f, -0.5f, 1.0f, 0.0f));
    }

    private static void registerClientScreens() {
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.POTTERY_TABLE_SCREEN_HANDLER.get(), PotteryTableGui::new);
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.KILN_SCREEN_HANDLER.get(), KilnGui::new);
    }

    public static void registerBlockEntityRenderer() {
        BlockEntityRendererRegistry.register(EntityTypeRegistry.STORAGE_BLOCK_ENTITY.get(), context -> new StorageBlockEntityRenderer());
        BlockEntityRendererRegistry.register(EntityTypeRegistry.STORAGE_BLOCK_ENTITY.get(), context -> new GlazedStorageOverlayRenderer());
    }
}