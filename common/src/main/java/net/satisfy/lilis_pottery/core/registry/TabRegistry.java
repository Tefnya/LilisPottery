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
            .icon(() -> new ItemStack(ObjectRegistry.BRICK_GARDEN_POT.get()))
            .title(Component.translatable("creativetab.lilis_pottery.tab"))
            .displayItems((parameters, output) -> {
                output.accept(ObjectRegistry.POTTERY_TABLE.get());
                output.accept(ObjectRegistry.KILN.get());
                output.accept(Items.CLAY_BALL);
                output.accept(ObjectRegistry.RED_CLAY_BALL.get());
                output.accept(ObjectRegistry.YELLOW_CLAY_BALL.get());
                output.accept(ObjectRegistry.WHITE_CLAY_BALL.get());
                output.accept(ObjectRegistry.BLUE_CLAY_BALL.get());
                output.accept(ObjectRegistry.DARK_CLAY_BALL.get());
                output.accept(Items.BRICK);
                output.accept(ObjectRegistry.RED_BRICK.get());
                output.accept(ObjectRegistry.YELLOW_BRICK.get());
                output.accept(ObjectRegistry.WHITE_BRICK.get());
                output.accept(ObjectRegistry.BLUE_BRICK.get());
                output.accept(ObjectRegistry.DARK_BRICK.get());
                output.accept(Items.CLAY);
                output.accept(ObjectRegistry.RED_CLAY.get());
                output.accept(ObjectRegistry.YELLOW_CLAY.get());
                output.accept(ObjectRegistry.WHITE_CLAY.get());
                output.accept(ObjectRegistry.BLUE_CLAY.get());
                output.accept(ObjectRegistry.DARK_CLAY.get());
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
                output.accept(ObjectRegistry.DARK_BRICKS.get());
                output.accept(ObjectRegistry.DARK_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.DARK_BRICK_SLAB.get());
                output.accept(ObjectRegistry.DARK_BRICK_WALL.get());
                output.accept(ObjectRegistry.CHISELED_DARK_BRICKS.get());
                output.accept(ObjectRegistry.HANDMADE_BRICKS.get());
                output.accept(ObjectRegistry.HANDMADE_BRICK_STAIRS.get());
                output.accept(ObjectRegistry.HANDMADE_BRICK_SLAB.get());
                output.accept(ObjectRegistry.HANDMADE_BRICK_WALL.get());
                output.accept(ObjectRegistry.BRICK_PLANTER.get());
                output.accept(ObjectRegistry.BRICK_PLANT_BOWL.get());
                output.accept(ObjectRegistry.BRICK_CUPELLA.get());
                output.accept(ObjectRegistry.BRICK_BUD_VASE.get());
                output.accept(ObjectRegistry.BRICK_VASE.get());
                output.accept(ObjectRegistry.BRICK_GARDEN_POT.get());
                output.accept(ObjectRegistry.BRICK_SQUARE_POT.get());
                output.accept(ObjectRegistry.BRICK_AMPHORE.get());
                output.accept(ObjectRegistry.BRICK_URN.get());
                output.accept(ObjectRegistry.RED_BRICK_PLANTER.get());
                output.accept(ObjectRegistry.RED_BRICK_PLANT_BOWL.get());
                output.accept(ObjectRegistry.RED_BRICK_CUPELLA.get());
                output.accept(ObjectRegistry.RED_BRICK_BUD_VASE.get());
                output.accept(ObjectRegistry.RED_BRICK_VASE.get());
                output.accept(ObjectRegistry.RED_BRICK_GARDEN_POT.get());
                output.accept(ObjectRegistry.RED_BRICK_SQUARE_POT.get());
                output.accept(ObjectRegistry.RED_BRICK_AMPHORE.get());
                output.accept(ObjectRegistry.RED_BRICK_URN.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_PLANTER.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_PLANT_BOWL.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_CUPELLA.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_BUD_VASE.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_VASE.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_GARDEN_POT.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_SQUARE_POT.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_AMPHORE.get());
                output.accept(ObjectRegistry.YELLOW_BRICK_URN.get());
                output.accept(ObjectRegistry.WHITE_BRICK_PLANTER.get());
                output.accept(ObjectRegistry.WHITE_BRICK_PLANT_BOWL.get());
                output.accept(ObjectRegistry.WHITE_BRICK_CUPELLA.get());
                output.accept(ObjectRegistry.WHITE_BRICK_BUD_VASE.get());
                output.accept(ObjectRegistry.WHITE_BRICK_VASE.get());
                output.accept(ObjectRegistry.WHITE_BRICK_GARDEN_POT.get());
                output.accept(ObjectRegistry.WHITE_BRICK_SQUARE_POT.get());
                output.accept(ObjectRegistry.WHITE_BRICK_AMPHORE.get());
                output.accept(ObjectRegistry.WHITE_BRICK_URN.get());
                output.accept(ObjectRegistry.BLUE_BRICK_PLANTER.get());
                output.accept(ObjectRegistry.BLUE_BRICK_PLANT_BOWL.get());
                output.accept(ObjectRegistry.BLUE_BRICK_CUPELLA.get());
                output.accept(ObjectRegistry.BLUE_BRICK_BUD_VASE.get());
                output.accept(ObjectRegistry.BLUE_BRICK_VASE.get());
                output.accept(ObjectRegistry.BLUE_BRICK_GARDEN_POT.get());
                output.accept(ObjectRegistry.BLUE_BRICK_SQUARE_POT.get());
                output.accept(ObjectRegistry.BLUE_BRICK_AMPHORE.get());
                output.accept(ObjectRegistry.BLUE_BRICK_URN.get());
                output.accept(ObjectRegistry.DARK_BRICK_PLANTER.get());
                output.accept(ObjectRegistry.DARK_BRICK_PLANT_BOWL.get());
                output.accept(ObjectRegistry.DARK_BRICK_CUPELLA.get());
                output.accept(ObjectRegistry.DARK_BRICK_BUD_VASE.get());
                output.accept(ObjectRegistry.DARK_BRICK_VASE.get());
                output.accept(ObjectRegistry.DARK_BRICK_GARDEN_POT.get());
                output.accept(ObjectRegistry.DARK_BRICK_SQUARE_POT.get());
                output.accept(ObjectRegistry.DARK_BRICK_AMPHORE.get());
                output.accept(ObjectRegistry.DARK_BRICK_URN.get());
            })
            .build());

    public static void init() {
        CREATIVE_MODE_TABS.register();
    }
}
