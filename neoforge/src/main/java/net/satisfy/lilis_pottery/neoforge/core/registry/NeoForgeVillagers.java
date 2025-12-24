package net.satisfy.lilis_pottery.neoforge.core.registry;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;

public class NeoForgeVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, LilisPottery.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, LilisPottery.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> CLAYWORKER_POI = POI_TYPES.register("clayworker_poi", () ->
            new PoiType(ImmutableSet.copyOf(ObjectRegistry.POTTERY_TABLE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final DeferredHolder<VillagerProfession, VillagerProfession> CLAYWORKER = VILLAGER_PROFESSIONS.register("clayworker", () ->
            new VillagerProfession("clayworker", x -> x.value() == CLAYWORKER_POI.get(), x -> x.value() == CLAYWORKER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_SHEPHERD));

    public static void init(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
