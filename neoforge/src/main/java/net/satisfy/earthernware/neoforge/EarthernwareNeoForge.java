package net.satisfy.earthernware.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.satisfy.earthernware.Earthernware;

@Mod(Earthernware.MOD_ID)
public class EarthernwareNeoForge {

    public EarthernwareNeoForge(ModContainer modContainer, final IEventBus modEventBus) {
        Earthernware.init();
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(Earthernware::commonInit);
    }
}