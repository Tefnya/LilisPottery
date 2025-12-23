package net.satisfy.earthernware.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.satisfy.earthernware.Earthernware;
import net.satisfy.earthernware.core.recipe.FiringRecipe;
import net.satisfy.earthernware.core.recipe.PotteringRecipe;

import java.util.function.Supplier;

public class RecipeRegistry {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Earthernware.MOD_ID, Registries.RECIPE_SERIALIZER);
    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Earthernware.MOD_ID, Registries.RECIPE_TYPE);

    public static final RegistrySupplier<RecipeType<PotteringRecipe>> POTTERING = create("pottering");
    public static final RegistrySupplier<RecipeSerializer<PotteringRecipe>> POTTERING_SERIALIZER = create("pottering", PotteringRecipe.Serializer::new);

    public static final RegistrySupplier<RecipeType<FiringRecipe>> FIRING = create("firing");
    public static final RegistrySupplier<RecipeSerializer<FiringRecipe>> FIRING_SERIALIZER = create("firing", FiringRecipe.Serializer::new);

    public static void init() {
        RECIPE_SERIALIZERS.register();
        RECIPE_TYPES.register();
    }

    private static <T extends Recipe<?>> RegistrySupplier<RecipeType<T>> create(String name) {
        Supplier<RecipeType<T>> type = () -> new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        };
        return RECIPE_TYPES.register(name, type);
    }

    private static <T extends Recipe<?>> RegistrySupplier<RecipeSerializer<T>> create(String name, Supplier<RecipeSerializer<T>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }
}
