package net.satisfy.lilis_pottery.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.core.block.*;
import net.satisfy.lilis_pottery.core.util.GeneralUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(LilisPottery.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(LilisPottery.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> POTTERY_TABLE = registerWithItem("pottery_table", () -> new PotteryTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
    public static final RegistrySupplier<Block> LILIS_POTTERY_TABLE = registerWithItem("lilis_pottery_table", () -> new PotteryTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
    public static final RegistrySupplier<Block> KILN = registerWithItem("kiln", () -> new KilnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE)));
    public static final RegistrySupplier<Item> RED_CLAY_BALL = registerItem("red_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> YELLOW_CLAY_BALL = registerItem("yellow_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> WHITE_CLAY_BALL = registerItem("white_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> BLUE_CLAY_BALL = registerItem("blue_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> BLACK_CLAY_BALL = registerItem("black_clay_ball", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> RED_BRICK = registerItem("red_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> YELLOW_BRICK = registerItem("yellow_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> WHITE_BRICK = registerItem("white_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> BLUE_BRICK = registerItem("blue_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> BLACK_BRICK = registerItem("black_brick", () -> new Item(getSettings()));
    public static final RegistrySupplier<Block> RED_CLAY = registerWithItem("red_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RegistrySupplier<Block> YELLOW_CLAY = registerWithItem("yellow_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistrySupplier<Block> WHITE_CLAY = registerWithItem("white_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistrySupplier<Block> BLUE_CLAY = registerWithItem("blue_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistrySupplier<Block> BLACK_CLAY = registerWithItem("black_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.TERRACOTTA_BLACK)));
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
    public static final RegistrySupplier<Block> BLACK_BRICKS = registerWithItem("black_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> BLACK_BRICK_STAIRS = registerWithItem("black_brick_stairs", () -> new StairBlock(BLACK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> BLACK_BRICK_SLAB = registerWithItem("black_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> BLACK_BRICK_WALL = registerWithItem("black_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> CHISELED_BLACK_BRICKS = registerWithItem("chiseled_black_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistrySupplier<Block> HANDMADE_BRICKS = registerWithItem("handmade_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> HANDMADE_BRICK_STAIRS = registerWithItem("handmade_brick_stairs", () -> new StairBlock(HANDMADE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> HANDMADE_BRICK_SLAB = registerWithItem("handmade_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> HANDMADE_BRICK_WALL = registerWithItem("handmade_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> PLANTER = registerWithItem("planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> PLANT_BOWL = registerWithItem("plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> CUPELLA = registerWithItem("cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BUD_VASE = registerWithItem("bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> VASE = registerWithItem("vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> GARDEN_POT = registerWithItem("garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> SQUARE_POT = registerWithItem("square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> AMPHORE = registerWithItem("amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> URN = registerWithItem("urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> RED_PLANTER = registerWithItem("red_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_PLANT_BOWL = registerWithItem("red_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_CUPELLA = registerWithItem("red_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_BUD_VASE = registerWithItem("red_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_VASE = registerWithItem("red_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_GARDEN_POT = registerWithItem("red_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_SQUARE_POT = registerWithItem("red_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> RED_AMPHORE = registerWithItem("red_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> RED_URN = registerWithItem("red_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> YELLOW_PLANTER = registerWithItem("yellow_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_PLANT_BOWL = registerWithItem("yellow_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_CUPELLA = registerWithItem("yellow_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_BUD_VASE = registerWithItem("yellow_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_VASE = registerWithItem("yellow_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_GARDEN_POT = registerWithItem("yellow_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_SQUARE_POT = registerWithItem("yellow_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> YELLOW_AMPHORE = registerWithItem("yellow_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> YELLOW_URN = registerWithItem("yellow_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> WHITE_PLANTER = registerWithItem("white_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_PLANT_BOWL = registerWithItem("white_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_CUPELLA = registerWithItem("white_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_BUD_VASE = registerWithItem("white_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_VASE = registerWithItem("white_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_GARDEN_POT = registerWithItem("white_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_SQUARE_POT = registerWithItem("white_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> WHITE_AMPHORE = registerWithItem("white_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> WHITE_URN = registerWithItem("white_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> BLUE_PLANTER = registerWithItem("blue_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_PLANT_BOWL = registerWithItem("blue_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_CUPELLA = registerWithItem("blue_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_BUD_VASE = registerWithItem("blue_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_VASE = registerWithItem("blue_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_GARDEN_POT = registerWithItem("blue_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_SQUARE_POT = registerWithItem("blue_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLUE_AMPHORE = registerWithItem("blue_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> BLUE_URN = registerWithItem("blue_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> BLACK_PLANTER = registerWithItem("black_planter", () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLACK_PLANT_BOWL = registerWithItem("black_plant_bowl", () -> new PlantBowlBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLACK_CUPELLA = registerWithItem("black_cupella", () -> new CupellaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLACK_BUD_VASE = registerWithItem("black_bud_vase", () -> new BudVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLACK_VASE = registerWithItem("black_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLACK_GARDEN_POT = registerWithItem("black_garden_pot", () -> new GardenPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLACK_SQUARE_POT = registerWithItem("black_square_pot", () -> new SquarePotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));
    public static final RegistrySupplier<Block> BLACK_AMPHORE = registerWithItem("black_amphore", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.AMPHORE));
    public static final RegistrySupplier<Block> BLACK_URN = registerWithItem("black_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT), UrnBlock.Variant.URN));
    public static final RegistrySupplier<Block> LILITU_STATUE = registerWithItem("lilitu_statue", () -> new CompletionistStatueBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));



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
        return GeneralUtil.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, LilisPottery.identifier(name), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return GeneralUtil.registerItem(ITEMS, ITEM_REGISTRAR, LilisPottery.identifier(path), itemSupplier);
    }
}
