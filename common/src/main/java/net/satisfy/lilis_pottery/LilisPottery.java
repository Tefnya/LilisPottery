package net.satisfy.lilis_pottery;

import net.minecraft.resources.ResourceLocation;
import net.satisfy.lilis_pottery.core.event.BeePotPollinationHandler;
import net.satisfy.lilis_pottery.core.event.ClayDripstoneColoring;
import net.satisfy.lilis_pottery.core.event.UrnDeathHandler;
import net.satisfy.lilis_pottery.core.registry.*;

public class LilisPottery {
    public static final String MOD_ID = "lilis_pottery";

    public static ResourceLocation identifier(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init() {
        ObjectRegistry.init();
        EntityTypeRegistry.init();
        TabRegistry.init();
        RecipeRegistry.init();
        ScreenHandlerRegistry.init();
        UrnDeathHandler.init();
        ClayDripstoneColoring.init();
        BeePotPollinationHandler.init();
    }

    public static void commonInit() {
        FlammableBlockRegistry.init();
    }
}