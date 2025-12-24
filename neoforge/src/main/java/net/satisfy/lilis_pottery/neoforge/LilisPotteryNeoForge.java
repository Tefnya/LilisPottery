package net.satisfy.lilis_pottery.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.neoforge.core.event.VillagerTradeHandler;
import net.satisfy.lilis_pottery.neoforge.core.registry.NeoForgeVillagers;

@Mod(LilisPottery.MOD_ID)
public class LilisPotteryNeoForge {

    public LilisPotteryNeoForge(ModContainer modContainer, IEventBus modEventBus) {
        LilisPottery.init();
        NeoForgeVillagers.init(modEventBus);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LilisPottery.commonInit();
            VillagerTradeHandler.init();
        });
    }
}