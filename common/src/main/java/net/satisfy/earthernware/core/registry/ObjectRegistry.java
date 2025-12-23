package net.satisfy.earthernware.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.satisfy.earthernware.Earthernware;
import net.satisfy.earthernware.core.block.*;
import net.satisfy.earthernware.core.util.GeneralUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Earthernware.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Earthernware.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> POTTERY_TABLE = registerWithItem("pottery_table", () -> new PotteryTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
    public static final RegistrySupplier<Block> KILN = registerWithItem("kiln", () -> new KilnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE)));
    public static final RegistrySupplier<Item> RED_CLAY_BALL = registerItem("red_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> YELLOW_CLAY_BALL = registerItem("yellow_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> WHITE_CLAY_BALL = registerItem("white_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> BLUE_CLAY_BALL = registerItem("blue_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> DARK_CLAY_BALL = registerItem("dark_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> RED_BRICK = registerItem("red_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> YELLOW_BRICK = registerItem("yellow_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> WHITE_BRICK = registerItem("white_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> BLUE_BRICK = registerItem("blue_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> DARK_BRICK = registerItem("dark_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Block> RED_CLAY = registerWithItem("red_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> YELLOW_CLAY = registerWithItem("yellow_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistrySupplier<Block> WHITE_CLAY = registerWithItem("white_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistrySupplier<Block> BLUE_CLAY = registerWithItem("blue_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistrySupplier<Block> DARK_CLAY = registerWithItem("dark_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> CHISELED_BRICKS = registerWithItem("chiseled_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> RED_BRICKS = registerWithItem("red_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> RED_BRICK_STAIRS = registerWithItem("red_brick_stairs", () -> new StairBlock(RED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> RED_BRICK_SLAB = registerWithItem("red_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> RED_BRICK_WALL = registerWithItem("red_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> CHISELED_RED_BRICKS = registerWithItem("chiseled_red_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> YELLOW_BRICKS = registerWithItem("yellow_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_STAIRS = registerWithItem("yellow_brick_stairs", () -> new StairBlock(YELLOW_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_SLAB = registerWithItem("yellow_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_WALL = registerWithItem("yellow_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistrySupplier<Block> CHISELED_YELLOW_BRICKS = registerWithItem("chiseled_yellow_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistrySupplier<Block> WHITE_BRICKS = registerWithItem("white_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistrySupplier<Block> WHITE_BRICK_STAIRS = registerWithItem("white_brick_stairs", () -> new StairBlock(WHITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistrySupplier<Block> WHITE_BRICK_SLAB = registerWithItem("white_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistrySupplier<Block> WHITE_BRICK_WALL = registerWithItem("white_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistrySupplier<Block> CHISELED_WHITE_BRICKS = registerWithItem("chiseled_white_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistrySupplier<Block> BLUE_BRICKS = registerWithItem("blue_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistrySupplier<Block> BLUE_BRICK_STAIRS = registerWithItem("blue_brick_stairs", () -> new StairBlock(BLUE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistrySupplier<Block> BLUE_BRICK_SLAB = registerWithItem("blue_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistrySupplier<Block> BLUE_BRICK_WALL = registerWithItem("blue_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistrySupplier<Block> CHISELED_BLUE_BRICKS = registerWithItem("chiseled_blue_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistrySupplier<Block> DARK_BRICKS = registerWithItem("dark_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> DARK_BRICK_STAIRS = registerWithItem("dark_brick_stairs", () -> new StairBlock(DARK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> DARK_BRICK_SLAB = registerWithItem("dark_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> DARK_BRICK_WALL = registerWithItem("dark_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> CHISELED_DARK_BRICKS = registerWithItem("chiseled_dark_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> HANDMADE_BRICKS = registerWithItem("handmade_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> HANDMADE_BRICK_STAIRS = registerWithItem("handmade_brick_stairs", () -> new StairBlock(HANDMADE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> HANDMADE_BRICK_SLAB = registerWithItem("handmade_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> HANDMADE_BRICK_WALL = registerWithItem("handmade_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> BRICK_PLANTER = registerWithItem("brick_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BRICK_PLANT_BOWL = registerWithItem("brick_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BRICK_CUPELLA = registerWithItem("brick_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BRICK_BUD_VASE = registerWithItem("brick_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BRICK_VASE = registerWithItem("brick_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BRICK_GARDEN_POT = registerWithItem("brick_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BRICK_SQUARE_POT = registerWithItem("brick_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BRICK_AMPHORE = registerWithItem("brick_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> BRICK_URN = registerWithItem("brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> RED_BRICK_PLANTER = registerWithItem("red_brick_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BRICK_PLANT_BOWL = registerWithItem("red_brick_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BRICK_CUPELLA = registerWithItem("red_brick_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BRICK_BUD_VASE = registerWithItem("red_brick_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BRICK_VASE = registerWithItem("red_brick_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BRICK_GARDEN_POT = registerWithItem("red_brick_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BRICK_SQUARE_POT = registerWithItem("red_brick_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BRICK_AMPHORE = registerWithItem("red_brick_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> RED_BRICK_URN = registerWithItem("red_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> YELLOW_BRICK_PLANTER = registerWithItem("yellow_brick_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_PLANT_BOWL = registerWithItem("yellow_brick_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_CUPELLA = registerWithItem("yellow_brick_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_BUD_VASE = registerWithItem("yellow_brick_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_VASE = registerWithItem("yellow_brick_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_GARDEN_POT = registerWithItem("yellow_brick_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_SQUARE_POT = registerWithItem("yellow_brick_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BRICK_AMPHORE = registerWithItem("yellow_brick_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> YELLOW_BRICK_URN = registerWithItem("yellow_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> WHITE_BRICK_PLANTER = registerWithItem("white_brick_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BRICK_PLANT_BOWL = registerWithItem("white_brick_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BRICK_CUPELLA = registerWithItem("white_brick_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BRICK_BUD_VASE = registerWithItem("white_brick_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BRICK_VASE = registerWithItem("white_brick_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BRICK_GARDEN_POT = registerWithItem("white_brick_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BRICK_SQUARE_POT = registerWithItem("white_brick_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BRICK_AMPHORE = registerWithItem("white_brick_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> WHITE_BRICK_URN = registerWithItem("white_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> BLUE_BRICK_PLANTER = registerWithItem("blue_brick_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BRICK_PLANT_BOWL = registerWithItem("blue_brick_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BRICK_CUPELLA = registerWithItem("blue_brick_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BRICK_BUD_VASE = registerWithItem("blue_brick_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BRICK_VASE = registerWithItem("blue_brick_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BRICK_GARDEN_POT = registerWithItem("blue_brick_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BRICK_SQUARE_POT = registerWithItem("blue_brick_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BRICK_AMPHORE = registerWithItem("blue_brick_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> BLUE_BRICK_URN = registerWithItem("blue_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> DARK_BRICK_PLANTER = registerWithItem("dark_brick_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> DARK_BRICK_PLANT_BOWL = registerWithItem("dark_brick_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> DARK_BRICK_CUPELLA = registerWithItem("dark_brick_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> DARK_BRICK_BUD_VASE = registerWithItem("dark_brick_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> DARK_BRICK_VASE = registerWithItem("dark_brick_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> DARK_BRICK_GARDEN_POT = registerWithItem("dark_brick_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> DARK_BRICK_SQUARE_POT = registerWithItem("dark_brick_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> DARK_BRICK_AMPHORE = registerWithItem("dark_brick_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> DARK_BRICK_URN = registerWithItem("dark_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));

    public static void init() {
        ITEMS.register();
        BLOCKS.register();
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(s -> {
        });
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return GeneralUtil.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, Earthernware.identifier(name), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return GeneralUtil.registerItem(ITEMS, ITEM_REGISTRAR, Earthernware.identifier(path), itemSupplier);
    }
}
