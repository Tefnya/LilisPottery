package net.satisfy.lilis_pottery.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.satisfy.lilis_pottery.Lilis_Pottery;
import net.satisfy.lilis_pottery.client.Lilis_PotteryClient;

@EventBusSubscriber(modid = Lilis_Pottery.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class LilisPotteryClientNeoForge {

    @SubscribeEvent
    public static void beforeClientSetup(RegisterEvent event) {
        Lilis_PotteryClient.preInitClient();
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        Lilis_PotteryClient.onInitializeClient();
    }


}
