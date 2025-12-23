package net.satisfy.lilis_pottery.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.satisfy.lilis_pottery.Lilis_Pottery;

@Mod(Lilis_Pottery.MOD_ID)
public class LilisPotteryNeoForge {

    public LilisPotteryNeoForge(ModContainer modContainer, final IEventBus modEventBus) {
        Lilis_Pottery.init();
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(Lilis_Pottery::commonInit);
    }
}