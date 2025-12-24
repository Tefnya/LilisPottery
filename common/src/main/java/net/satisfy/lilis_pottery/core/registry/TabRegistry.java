package net.satisfy.lilis_pottery.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.satisfy.lilis_pottery.LilisPottery;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(LilisPottery.MOD_ID, Registries.CREATIVE_MODE_TAB);

    @SuppressWarnings("unused")
    public static final RegistrySupplier<CreativeModeTab> LILIS_POTTERY_TAB = CREATIVE_MODE_TABS.register("lilis_pottery", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ObjectRegistry.RED_AMPHORE.get()))
            .title(Component.translatable("creativetab.lilis_pottery.tab"))
            .displayItems((parameters, output) -> {
                output.accept(ObjectRegistry.POTTERY_TABLE.get());
                output.accept(ObjectRegistry.KILN.get());
                output.accept(Items.CLAY_BALL);
                output.accept(ObjectRegistry.RED_CLAY_BALL.get());
                output.accept(ObjectRegistry.YELLOW_CLAY_BALL.get());
                output.accept(ObjectRegistry.WHITE_CLAY_BALL.get());
                output.accept(ObjectRegistry.BLUE_CLAY_BALL.get());
                output.accept(ObjectRegistry.BLACK_CLAY_BALL.get());
                output.accept(Items.BRICK);
                output.accept(ObjectRegistry.RED_BRICK.get());
                output.accept(ObjectRegistry.YELLOW_BRICK.get());
                output.accept(ObjectRegistry.WHITE_BRICK.get());
                output.accept(ObjectRegistry.BLUE_BRICK.get());
                output.accept(ObjectRegistry.BLACK_BRICK.get());
                output.accept(Items.CLAY);
                output.accept(ObjectRegistry.RED_CLAY.get());
                output.accept(ObjectRegistry.YELLOW_CLAY.get());
                output.accept(ObjectRegistry.WHITE_CLAY.get());
                output.accept(ObjectRegistry.BLUE_CLAY.get());
                output.accept(ObjectRegistry.BLACK_CLAY.get());
                output.accept(Items.BRICKS);
                output.accept(Items.BRICK_STAIRS);
                output.accept(Items.BRICK_SLAB);
                output.accept(Items.BRICK_WALL);
                output.accept(ObjectRegistry.CHISELED_BRICKS.get());
                output.accept(ObjectRegistry.RED_BRICKS.get());
                output.accept(ObjectRegistry.RED_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.RED_BRICK_SLAB.get());
                output.accept(ObjectRegistry.RED_BRICK_WALL.get());
                output.accept(ObjectRegistry.CHISELED_RED_BRICKS.get());
                output.accept(ObjectRegistry.YELLOW_BRICKS.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_SLAB.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_WALL.get());
                output.accept(ObjectRegistry.CHISELED_YELLOW_BRICKS.get());
                output.accept(ObjectRegistry.WHITE_BRICKS.get());
                output.accept(ObjectRegistry.WHITE_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.WHITE_BRICK_SLAB.get());
                output.accept(ObjectRegistry.WHITE_BRICK_WALL.get());
                output.accept(ObjectRegistry.CHISELED_WHITE_BRICKS.get());
                output.accept(ObjectRegistry.BLUE_BRICKS.get());
                output.accept(ObjectRegistry.BLUE_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.BLUE_BRICK_SLAB.get());
                output.accept(ObjectRegistry.BLUE_BRICK_WALL.get());
                output.accept(ObjectRegistry.CHISELED_BLUE_BRICKS.get());
                output.accept(ObjectRegistry.BLACK_BRICKS.get());
                output.accept(ObjectRegistry.BLACK_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.BLACK_BRICK_SLAB.get());
                output.accept(ObjectRegistry.BLACK_BRICK_WALL.get());
                output.accept(ObjectRegistry.CHISELED_BLACK_BRICKS.get());
                output.accept(ObjectRegistry.HANDMADE_BRICKS.get());
                output.accept(ObjectRegistry.HANDMADE_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.HANDMADE_BRICK_SLAB.get());
                output.accept(ObjectRegistry.HANDMADE_BRICK_WALL.get());
                output.accept(ObjectRegistry.PLANTER.get());
                output.accept(ObjectRegistry.PLANT_BOWL.get());
                output.accept(ObjectRegistry.CUPELLA.get());
                output.accept(ObjectRegistry.BUD_VASE.get());
                output.accept(ObjectRegistry.VASE.get());
                output.accept(ObjectRegistry.GARDEN_POT.get());
                output.accept(ObjectRegistry.SQUARE_POT.get());
                output.accept(ObjectRegistry.AMPHORE.get());
                output.accept(ObjectRegistry.URN.get());
                output.accept(ObjectRegistry.RED_PLANTER.get());
                output.accept(ObjectRegistry.RED_PLANT_BOWL.get());
                output.accept(ObjectRegistry.RED_CUPELLA.get());
                output.accept(ObjectRegistry.RED_BUD_VASE.get());
                output.accept(ObjectRegistry.RED_VASE.get());
                output.accept(ObjectRegistry.RED_GARDEN_POT.get());
                output.accept(ObjectRegistry.RED_SQUARE_POT.get());
                output.accept(ObjectRegistry.RED_AMPHORE.get());
                output.accept(ObjectRegistry.RED_URN.get());
                output.accept(ObjectRegistry.YELLOW_PLANTER.get());
                output.accept(ObjectRegistry.YELLOW_PLANT_BOWL.get());
                output.accept(ObjectRegistry.YELLOW_CUPELLA.get());
                output.accept(ObjectRegistry.YELLOW_BUD_VASE.get());
                output.accept(ObjectRegistry.YELLOW_VASE.get());
                output.accept(ObjectRegistry.YELLOW_GARDEN_POT.get());
                output.accept(ObjectRegistry.YELLOW_SQUARE_POT.get());
                output.accept(ObjectRegistry.YELLOW_AMPHORE.get());
                output.accept(ObjectRegistry.YELLOW_URN.get());
                output.accept(ObjectRegistry.WHITE_PLANTER.get());
                output.accept(ObjectRegistry.WHITE_PLANT_BOWL.get());
                output.accept(ObjectRegistry.WHITE_CUPELLA.get());
                output.accept(ObjectRegistry.WHITE_BUD_VASE.get());
                output.accept(ObjectRegistry.WHITE_VASE.get());
                output.accept(ObjectRegistry.WHITE_GARDEN_POT.get());
                output.accept(ObjectRegistry.WHITE_SQUARE_POT.get());
                output.accept(ObjectRegistry.WHITE_AMPHORE.get());
                output.accept(ObjectRegistry.WHITE_URN.get());
                output.accept(ObjectRegistry.BLUE_PLANTER.get());
                output.accept(ObjectRegistry.BLUE_PLANT_BOWL.get());
                output.accept(ObjectRegistry.BLUE_CUPELLA.get());
                output.accept(ObjectRegistry.BLUE_BUD_VASE.get());
                output.accept(ObjectRegistry.BLUE_VASE.get());
                output.accept(ObjectRegistry.BLUE_GARDEN_POT.get());
                output.accept(ObjectRegistry.BLUE_SQUARE_POT.get());
                output.accept(ObjectRegistry.BLUE_AMPHORE.get());
                output.accept(ObjectRegistry.BLUE_URN.get());
                output.accept(ObjectRegistry.BLACK_PLANTER.get());
                output.accept(ObjectRegistry.BLACK_PLANT_BOWL.get());
                output.accept(ObjectRegistry.BLACK_CUPELLA.get());
                output.accept(ObjectRegistry.BLACK_BUD_VASE.get());
                output.accept(ObjectRegistry.BLACK_VASE.get());
                output.accept(ObjectRegistry.BLACK_GARDEN_POT.get());
                output.accept(ObjectRegistry.BLACK_SQUARE_POT.get());
                output.accept(ObjectRegistry.BLACK_AMPHORE.get());
                output.accept(ObjectRegistry.BLACK_URN.get());
                output.accept(ObjectRegistry.LILITU_STATUE.get());
            })
            .build());

    public static void init() {
        CREATIVE_MODE_TABS.register();
    }
}
