package net.satisfy.lilis_pottery.core.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.satisfy.lilis_pottery.core.registry.RecipeRegistry;
import org.jetbrains.annotations.NotNull;

public class PotteringRecipe implements Recipe<RecipeInput> {
    private final Ingredient input;
    private final ItemStack outputStack;

    public PotteringRecipe(ItemStack itemStack, Ingredient ingredient) {
        this.outputStack = itemStack;
        this.input = ingredient;
    }

    public Ingredient getInput() {
        return input;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> defaultedList = NonNullList.create();
        defaultedList.add(this.input);
        return defaultedList;
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return this.input.test(recipeInput.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return this.outputStack.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.outputStack.copy();
    }

    public ItemStack getOutputStack() {
        return getResultItem(null);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.POTTERING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RecipeRegistry.POTTERING.get();
    }

    public static class Serializer implements RecipeSerializer<PotteringRecipe> {
        public static final MapCodec<PotteringRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                        ItemStack.CODEC.fieldOf("outputItem").forGetter(recipe -> recipe.outputStack),
                        Ingredient.CODEC.fieldOf("inputItem").forGetter(PotteringRecipe::getInput)
                ).apply(instance, PotteringRecipe::new)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf, PotteringRecipe> STREAM_CODEC = StreamCodec.composite(
                ItemStack.STREAM_CODEC, PotteringRecipe::getOutputStack,
                Ingredient.CONTENTS_STREAM_CODEC, PotteringRecipe::getInput,
                PotteringRecipe::new
        );

        @Override
        public @NotNull MapCodec<PotteringRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, PotteringRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}