package net.satisfy.lilis_pottery.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.client.LilisPotteryClient;
import net.satisfy.lilis_pottery.client.gui.KilnGui;
import net.satisfy.lilis_pottery.client.gui.PotteryTableGui;
import net.satisfy.lilis_pottery.core.registry.ScreenHandlerRegistry;

@EventBusSubscriber(modid = LilisPottery.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class LilisPotteryClientNeoForge {

    @SubscribeEvent
    public static void beforeClientSetup(RegisterEvent event) {
        LilisPotteryClient.preInitClient();
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        LilisPotteryClient.onInitializeClient();
    }

    @SubscribeEvent
    public static void onClientSetup(RegisterMenuScreensEvent event) {
        event.register(ScreenHandlerRegistry.POTTERY_TABLE_SCREEN_HANDLER.get(), PotteryTableGui::new);
        event.register(ScreenHandlerRegistry.KILN_SCREEN_HANDLER.get(), KilnGui::new);
    }
}
