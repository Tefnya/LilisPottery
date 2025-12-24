package net.satisfy.lilis_pottery.fabric.core.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.satisfy.lilis_pottery.LilisPottery;

import java.util.function.Predicate;

public final class LilisPotteryFabricWorldgen {

    public static final ResourceKey<PlacedFeature> ORE_RED_CLAY = registerPlacedFeature("ore_red_clay");
    public static final ResourceKey<PlacedFeature> ORE_YELLOW_CLAY = registerPlacedFeature("ore_yellow_clay");
    public static final ResourceKey<PlacedFeature> ORE_WHITE_CLAY = registerPlacedFeature("ore_white_clay");
    public static final ResourceKey<PlacedFeature> ORE_BLUE_CLAY = registerPlacedFeature("ore_blue_clay");
    public static final ResourceKey<PlacedFeature> ORE_black_CLAY = registerPlacedFeature("ore_black_clay");

    public static final ResourceKey<PlacedFeature> ORE_RED_CLAY_SWAMP = registerPlacedFeature("ore_red_clay_swamp");
    public static final ResourceKey<PlacedFeature> ORE_YELLOW_CLAY_SWAMP = registerPlacedFeature("ore_yellow_clay_swamp");
    public static final ResourceKey<PlacedFeature> ORE_WHITE_CLAY_SWAMP = registerPlacedFeature("ore_white_clay_swamp");
    public static final ResourceKey<PlacedFeature> ORE_BLUE_CLAY_SWAMP = registerPlacedFeature("ore_blue_clay_swamp");
    public static final ResourceKey<PlacedFeature> ORE_black_CLAY_SWAMP = registerPlacedFeature("ore_black_clay_swamp");

    public static final ResourceKey<PlacedFeature> ORE_BLUE_CLAY_LUSH_CAVES = registerPlacedFeature("ore_blue_clay_lush_caves");

    private static final Predicate<BiomeSelectionContext> RED_CLAY_BIOMES = BiomeSelectors.includeByKey(
            Biomes.BADLANDS,
            Biomes.ERODED_BADLANDS,
            Biomes.WOODED_BADLANDS,
            Biomes.RIVER
    );

    private static final Predicate<BiomeSelectionContext> YELLOW_CLAY_BIOMES = BiomeSelectors.includeByKey(
            Biomes.SAVANNA,
            Biomes.SAVANNA_PLATEAU,
            Biomes.WINDSWEPT_SAVANNA,
            Biomes.RIVER
    );

    private static final Predicate<BiomeSelectionContext> WHITE_CLAY_BIOMES = BiomeSelectors.includeByKey(
            Biomes.SNOWY_PLAINS,
            Biomes.ICE_SPIKES,
            Biomes.SNOWY_TAIGA,
            Biomes.FROZEN_RIVER
    );

    private static final Predicate<BiomeSelectionContext> BLUE_CLAY_BIOMES = BiomeSelectors.includeByKey(
            Biomes.TAIGA,
            Biomes.OLD_GROWTH_PINE_TAIGA,
            Biomes.OLD_GROWTH_SPRUCE_TAIGA,
            Biomes.WINDSWEPT_HILLS,
            Biomes.WINDSWEPT_FOREST,
            Biomes.RIVER
    );

    private static final Predicate<BiomeSelectionContext> black_CLAY_BIOMES = BiomeSelectors.includeByKey(
            Biomes.SWAMP,
            Biomes.MANGROVE_SWAMP
    );

    private static final Predicate<BiomeSelectionContext> SWAMPS = BiomeSelectors.includeByKey(
            Biomes.SWAMP,
            Biomes.MANGROVE_SWAMP
    );

    private static final Predicate<BiomeSelectionContext> LUSH_CAVES = BiomeSelectors.includeByKey(Biomes.LUSH_CAVES);

    public static void init() {
        registerFeatureAdditions();
    }

    public static void registerFeatureAdditions() {
        BiomeModification world = BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(LilisPottery.MOD_ID, "world_features"));

        world.add(ModificationPhase.ADDITIONS, RED_CLAY_BIOMES, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_RED_CLAY)
        );
        world.add(ModificationPhase.ADDITIONS, YELLOW_CLAY_BIOMES, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_YELLOW_CLAY)
        );
        world.add(ModificationPhase.ADDITIONS, WHITE_CLAY_BIOMES, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_WHITE_CLAY)
        );
        world.add(ModificationPhase.ADDITIONS, BLUE_CLAY_BIOMES, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_BLUE_CLAY)
        );
        world.add(ModificationPhase.ADDITIONS, black_CLAY_BIOMES, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_black_CLAY)
        );

        world.add(ModificationPhase.ADDITIONS, SWAMPS, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_RED_CLAY_SWAMP)
        );
        world.add(ModificationPhase.ADDITIONS, SWAMPS, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_YELLOW_CLAY_SWAMP)
        );
        world.add(ModificationPhase.ADDITIONS, SWAMPS, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_WHITE_CLAY_SWAMP)
        );
        world.add(ModificationPhase.ADDITIONS, SWAMPS, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_BLUE_CLAY_SWAMP)
        );
        world.add(ModificationPhase.ADDITIONS, SWAMPS, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_black_CLAY_SWAMP)
        );

        world.add(ModificationPhase.ADDITIONS, LUSH_CAVES, context ->
                context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_BLUE_CLAY_LUSH_CAVES)
        );
    }

    public static ResourceKey<PlacedFeature> registerPlacedFeature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, LilisPottery.identifier(name));
    }
}