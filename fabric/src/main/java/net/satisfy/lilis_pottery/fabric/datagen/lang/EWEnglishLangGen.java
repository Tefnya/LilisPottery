package net.satisfy.lilis_pottery.fabric.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;

import java.util.concurrent.CompletableFuture;

public class EWEnglishLangGen extends FabricLanguageProvider {

    public EWEnglishLangGen(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder texts) {
        texts.add("creativetab.lilis_pottery.tab", "[Let's Do] Lili's Pottery");
        texts.add(ObjectRegistry.POTTERY_TABLE.get(), "Pottery Table");
        texts.add(ObjectRegistry.KILN.get(), "Kiln");

        texts.add(ObjectRegistry.RED_CLAY.get(), "Red Clay");
        texts.add(ObjectRegistry.YELLOW_CLAY.get(), "Yellow Clay");
        texts.add(ObjectRegistry.WHITE_CLAY.get(), "White Clay");
        texts.add(ObjectRegistry.BLUE_CLAY.get(), "Blue Clay");
        texts.add(ObjectRegistry.DARK_CLAY.get(), "Dark Clay");

        texts.add(ObjectRegistry.RED_CLAY_BALL.get(), "Red Clay Ball");
        texts.add(ObjectRegistry.YELLOW_CLAY_BALL.get(), "Yellow Clay Ball");
        texts.add(ObjectRegistry.WHITE_CLAY_BALL.get(), "White Clay Ball");
        texts.add(ObjectRegistry.BLUE_CLAY_BALL.get(), "Blue Clay Ball");
        texts.add(ObjectRegistry.DARK_CLAY_BALL.get(), "Dark Clay Ball");

        texts.add(ObjectRegistry.RED_BRICK.get(), "Red Brick");
        texts.add(ObjectRegistry.YELLOW_BRICK.get(), "Yellow Brick");
        texts.add(ObjectRegistry.WHITE_BRICK.get(), "White Brick");
        texts.add(ObjectRegistry.BLUE_BRICK.get(), "Blue Brick");
        texts.add(ObjectRegistry.DARK_BRICK.get(), "Dark Brick");

        texts.add(ObjectRegistry.RED_BRICKS.get(), "Red Bricks");
        texts.add(ObjectRegistry.RED_BRICK_STAIRS.get(), "Red Brick Stairs");
        texts.add(ObjectRegistry.RED_BRICK_SLAB.get(), "Red Brick Slab");
        texts.add(ObjectRegistry.RED_BRICK_WALL.get(), "Red Brick Wall");
        texts.add(ObjectRegistry.CHISELED_RED_BRICKS.get(), "Chiseled Red Bricks");

        texts.add(ObjectRegistry.YELLOW_BRICKS.get(), "Yellow Bricks");
        texts.add(ObjectRegistry.YELLOW_BRICK_STAIRS.get(), "Yellow Brick Stairs");
        texts.add(ObjectRegistry.YELLOW_BRICK_SLAB.get(), "Yellow Brick Slab");
        texts.add(ObjectRegistry.YELLOW_BRICK_WALL.get(), "Yellow Brick Wall");
        texts.add(ObjectRegistry.CHISELED_YELLOW_BRICKS.get(), "Chiseled Yellow Bricks");

        texts.add(ObjectRegistry.WHITE_BRICKS.get(), "White Bricks");
        texts.add(ObjectRegistry.WHITE_BRICK_STAIRS.get(), "White Brick Stairs");
        texts.add(ObjectRegistry.WHITE_BRICK_SLAB.get(), "White Brick Slab");
        texts.add(ObjectRegistry.WHITE_BRICK_WALL.get(), "White Brick Wall");
        texts.add(ObjectRegistry.CHISELED_WHITE_BRICKS.get(), "Chiseled White Bricks");

        texts.add(ObjectRegistry.BLUE_BRICKS.get(), "Blue Bricks");
        texts.add(ObjectRegistry.BLUE_BRICK_STAIRS.get(), "Blue Brick Stairs");
        texts.add(ObjectRegistry.BLUE_BRICK_SLAB.get(), "Blue Brick Slab");
        texts.add(ObjectRegistry.BLUE_BRICK_WALL.get(), "Blue Brick Wall");
        texts.add(ObjectRegistry.CHISELED_BLUE_BRICKS.get(), "Chiseled Blue Bricks");

        texts.add(ObjectRegistry.DARK_BRICKS.get(), "Dark Bricks");
        texts.add(ObjectRegistry.DARK_BRICK_STAIRS.get(), "Dark Brick Stairs");
        texts.add(ObjectRegistry.DARK_BRICK_SLAB.get(), "Dark Brick Slab");
        texts.add(ObjectRegistry.DARK_BRICK_WALL.get(), "Dark Brick Wall");
        texts.add(ObjectRegistry.CHISELED_DARK_BRICKS.get(), "Chiseled Dark Bricks");

        texts.add(ObjectRegistry.HANDMADE_BRICKS.get(), "Handmade Bricks");
        texts.add(ObjectRegistry.HANDMADE_BRICK_STAIRS.get(), "Handmade Brick Stairs");
        texts.add(ObjectRegistry.HANDMADE_BRICK_SLAB.get(), "Handmade Brick Slab");
        texts.add(ObjectRegistry.HANDMADE_BRICK_WALL.get(), "Handmade Brick Wall");
        texts.add(ObjectRegistry.CHISELED_BRICKS.get(), "Chiseled Bricks");

        texts.add(ObjectRegistry.BRICK_PLANTER.get(), "Brick Planter");
        texts.add(ObjectRegistry.BRICK_PLANT_BOWL.get(), "Brick Plant Bowl");
        texts.add(ObjectRegistry.BRICK_CUPELLA.get(), "Brick Cupella");
        texts.add(ObjectRegistry.BRICK_BUD_VASE.get(), "Brick Bud Vase");
        texts.add(ObjectRegistry.BRICK_VASE.get(), "Brick Vase");
        texts.add(ObjectRegistry.BRICK_GARDEN_POT.get(), "Brick Garden Pot");
        texts.add(ObjectRegistry.BRICK_SQUARE_POT.get(), "Brick Square Pot");
        texts.add(ObjectRegistry.BRICK_AMPHORE.get(), "Brick Amphore");
        texts.add(ObjectRegistry.BRICK_URN.get(), "Brick Urn");

        texts.add(ObjectRegistry.RED_BRICK_PLANTER.get(), "Red Brick Planter");
        texts.add(ObjectRegistry.RED_BRICK_PLANT_BOWL.get(), "Red Brick Plant Bowl");
        texts.add(ObjectRegistry.RED_BRICK_CUPELLA.get(), "Red Brick Cupella");
        texts.add(ObjectRegistry.RED_BRICK_BUD_VASE.get(), "Red Brick Bud Vase");
        texts.add(ObjectRegistry.RED_BRICK_VASE.get(), "Red Brick Vase");
        texts.add(ObjectRegistry.RED_BRICK_GARDEN_POT.get(), "Red Brick Garden Pot");
        texts.add(ObjectRegistry.RED_BRICK_SQUARE_POT.get(), "Red Brick Square Pot");
        texts.add(ObjectRegistry.RED_BRICK_AMPHORE.get(), "Red Brick Amphore");
        texts.add(ObjectRegistry.RED_BRICK_URN.get(), "Red Brick Urn");

        texts.add(ObjectRegistry.YELLOW_BRICK_PLANTER.get(), "Yellow Brick Planter");
        texts.add(ObjectRegistry.YELLOW_BRICK_PLANT_BOWL.get(), "Yellow Brick Plant Bowl");
        texts.add(ObjectRegistry.YELLOW_BRICK_CUPELLA.get(), "Yellow Brick Cupella");
        texts.add(ObjectRegistry.YELLOW_BRICK_BUD_VASE.get(), "Yellow Brick Bud Vase");
        texts.add(ObjectRegistry.YELLOW_BRICK_VASE.get(), "Yellow Brick Vase");
        texts.add(ObjectRegistry.YELLOW_BRICK_GARDEN_POT.get(), "Yellow Brick Garden Pot");
        texts.add(ObjectRegistry.YELLOW_BRICK_SQUARE_POT.get(), "Yellow Brick Square Pot");
        texts.add(ObjectRegistry.YELLOW_BRICK_AMPHORE.get(), "Yellow Brick Amphore");
        texts.add(ObjectRegistry.YELLOW_BRICK_URN.get(), "Yellow Brick Urn");

        texts.add(ObjectRegistry.WHITE_BRICK_PLANTER.get(), "White Brick Planter");
        texts.add(ObjectRegistry.WHITE_BRICK_PLANT_BOWL.get(), "White Brick Plant Bowl");
        texts.add(ObjectRegistry.WHITE_BRICK_CUPELLA.get(), "White Brick Cupella");
        texts.add(ObjectRegistry.WHITE_BRICK_BUD_VASE.get(), "White Brick Bud Vase");
        texts.add(ObjectRegistry.WHITE_BRICK_VASE.get(), "White Brick Vase");
        texts.add(ObjectRegistry.WHITE_BRICK_GARDEN_POT.get(), "White Brick Garden Pot");
        texts.add(ObjectRegistry.WHITE_BRICK_SQUARE_POT.get(), "White Brick Square Pot");
        texts.add(ObjectRegistry.WHITE_BRICK_AMPHORE.get(), "White Brick Amphore");
        texts.add(ObjectRegistry.WHITE_BRICK_URN.get(), "White Brick Urn");

        texts.add(ObjectRegistry.BLUE_BRICK_PLANTER.get(), "Blue Brick Planter");
        texts.add(ObjectRegistry.BLUE_BRICK_PLANT_BOWL.get(), "Blue Brick Plant Bowl");
        texts.add(ObjectRegistry.BLUE_BRICK_CUPELLA.get(), "Blue Brick Cupella");
        texts.add(ObjectRegistry.BLUE_BRICK_BUD_VASE.get(), "Blue Brick Bud Vase");
        texts.add(ObjectRegistry.BLUE_BRICK_VASE.get(), "Blue Brick Vase");
        texts.add(ObjectRegistry.BLUE_BRICK_GARDEN_POT.get(), "Blue Brick Garden Pot");
        texts.add(ObjectRegistry.BLUE_BRICK_SQUARE_POT.get(), "Blue Brick Square Pot");
        texts.add(ObjectRegistry.BLUE_BRICK_AMPHORE.get(), "Blue Brick Amphore");
        texts.add(ObjectRegistry.BLUE_BRICK_URN.get(), "Blue Brick Urn");

        texts.add(ObjectRegistry.DARK_BRICK_PLANTER.get(), "Dark Brick Planter");
        texts.add(ObjectRegistry.DARK_BRICK_PLANT_BOWL.get(), "Dark Brick Plant Bowl");
        texts.add(ObjectRegistry.DARK_BRICK_CUPELLA.get(), "Dark Brick Cupella");
        texts.add(ObjectRegistry.DARK_BRICK_BUD_VASE.get(), "Dark Brick Bud Vase");
        texts.add(ObjectRegistry.DARK_BRICK_VASE.get(), "Dark Brick Vase");
        texts.add(ObjectRegistry.DARK_BRICK_GARDEN_POT.get(), "Dark Brick Garden Pot");
        texts.add(ObjectRegistry.DARK_BRICK_SQUARE_POT.get(), "Dark Brick Square Pot");
        texts.add(ObjectRegistry.DARK_BRICK_AMPHORE.get(), "Dark Brick Amphore");
        texts.add(ObjectRegistry.DARK_BRICK_URN.get(), "Dark Brick Urn");
        texts.add("tooltip.lilis_pottery.canbeplaced", "Can be placed");
        texts.add("tooltip.lilis_pottery.tooltip_information.hold", "Hold %s for more Information");
        texts.add("tooltip.lilis_pottery.pot.info", "Keeps your Items safe when carried in your Inventory upon death.");
        texts.add("tooltip.lilis_pottery.painted", "This Block has been Fired with Dye: %s");    }
}