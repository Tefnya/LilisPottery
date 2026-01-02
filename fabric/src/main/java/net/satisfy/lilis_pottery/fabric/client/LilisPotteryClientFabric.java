package net.satisfy.lilis_pottery.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.satisfy.lilis_pottery.client.LilisPotteryClient;
import net.satisfy.lilis_pottery.client.gui.KilnGui;
import net.satisfy.lilis_pottery.client.gui.PotteryTableGui;
import net.satisfy.lilis_pottery.core.registry.ScreenHandlerRegistry;

public class LilisPotteryClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LilisPotteryClient.preInitClient();
        LilisPotteryClient.onInitializeClient();

        MenuScreens.register(ScreenHandlerRegistry.POTTERY_TABLE_SCREEN_HANDLER.get(), PotteryTableGui::new);
        MenuScreens.register(ScreenHandlerRegistry.KILN_SCREEN_HANDLER.get(), KilnGui::new);
    }
}