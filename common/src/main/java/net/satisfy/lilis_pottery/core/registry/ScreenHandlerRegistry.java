package net.satisfy.lilis_pottery.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.core.inventory.KilnScreenHandler;
import net.satisfy.lilis_pottery.core.inventory.PotteryTableScreenHandler;

import java.util.function.Supplier;

public class ScreenHandlerRegistry {
    public static final DeferredRegister<MenuType<?>> SCREEN_TYPES = DeferredRegister.create(LilisPottery.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<PotteryTableScreenHandler>> POTTERY_TABLE_SCREEN_HANDLER = create("pottery_table", () -> new MenuType<>(PotteryTableScreenHandler::new, FeatureFlags.VANILLA_SET));
    public static final RegistrySupplier<MenuType<KilnScreenHandler>> KILN_SCREEN_HANDLER = create("kiln", () -> new MenuType<>(KilnScreenHandler::new, FeatureFlags.VANILLA_SET));

    public static void init() {
        SCREEN_TYPES.register();
    }

    private static <T extends MenuType<?>> RegistrySupplier<T> create(String name, Supplier<T> type) {
        return SCREEN_TYPES.register(name, type);
    }
}
