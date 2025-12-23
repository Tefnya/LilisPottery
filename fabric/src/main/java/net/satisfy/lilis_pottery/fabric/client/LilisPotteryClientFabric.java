package net.satisfy.lilis_pottery.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.satisfy.lilis_pottery.client.LilisPotteryClient;

public class LilisPotteryClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LilisPotteryClient.onInitializeClient();
        LilisPotteryClient.preInitClient();
    }
}
