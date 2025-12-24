package net.satisfy.lilis_pottery.fabric;

import net.fabricmc.api.ModInitializer;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.fabric.core.registry.FabricVillagers;
import net.satisfy.lilis_pottery.fabric.core.world.LilisPotteryFabricWorldgen;

public class LilisPotteryFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LilisPottery.init();
        LilisPotteryFabricWorldgen.init();
        FabricVillagers.init();
    }
}
