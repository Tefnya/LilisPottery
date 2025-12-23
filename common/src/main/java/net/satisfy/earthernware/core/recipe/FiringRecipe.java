package net.satisfy.earthernware.core.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.satisfy.earthernware.core.registry.RecipeRegistry;
import org.jetbrains.annotations.NotNull;

public record FiringRecipe(Ingredient base, Ingredient modifier, int burnTime) implements Recipe<RecipeInput> {

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(base);
        list.add(modifier);
        return list;
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return base.test(recipeInput.getItem(0)) && modifier.test(recipeInput.getItem(1));
    }

    @Override
    public @NotNull ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        ItemStack baseStack = recipeInput.getItem(0);
        ItemStack modifierStack = recipeInput.getItem(1);

        if (baseStack.isEmpty() || modifierStack.isEmpty()) {
            return ItemStack.EMPTY;
        }

        if (!(modifierStack.getItem() instanceof DyeItem dyeItem)) {
            return ItemStack.EMPTY;
        }

        ItemStack result = baseStack.copy();
        result.setCount(1);

        CustomData baseData = baseStack.get(DataComponents.CUSTOM_DATA);
        CompoundTag tag = baseData != null ? baseData.copyTag() : new CompoundTag();

        int oldRgb = tag.contains("sideColorRgb", 99) ? tag.getInt("sideColorRgb") : -1;
        int newRgb = dyeItem.getDyeColor().getFireworkColor();
        int mixedRgb = oldRgb == -1 ? newRgb : mixRgb(oldRgb, newRgb);

        tag.putInt("sideColorRgb", mixedRgb);
        tag.putBoolean("painted", true);

        result.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        return result;
    }

    private static int mixRgb(int firstRgb, int secondRgb) {
        int firstRed = (firstRgb >> 16) & 255;
        int firstGreen = (firstRgb >> 8) & 255;
        int firstBlue = firstRgb & 255;

        int secondRed = (secondRgb >> 16) & 255;
        int secondGreen = (secondRgb >> 8) & 255;
        int secondBlue = secondRgb & 255;

        int mixedRed = (firstRed + secondRed) / 2;
        int mixedGreen = (firstGreen + secondGreen) / 2;
        int mixedBlue = (firstBlue + secondBlue) / 2;

        return (mixedRed << 16) | (mixedGreen << 8) | mixedBlue;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.FIRING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RecipeRegistry.FIRING.get();
    }

    public static class Serializer implements RecipeSerializer<FiringRecipe> {

        public static final MapCodec<FiringRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("base").forGetter(FiringRecipe::base),
                Ingredient.CODEC.fieldOf("modifier").forGetter(FiringRecipe::modifier),
                Codec.INT.optionalFieldOf("burnTime", 200).forGetter(FiringRecipe::burnTime)
        ).apply(instance, FiringRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, FiringRecipe::base,
                Ingredient.CONTENTS_STREAM_CODEC, FiringRecipe::modifier,
                ByteBufCodecs.VAR_INT, FiringRecipe::burnTime,
                FiringRecipe::new
        );

        @Override
        public @NotNull MapCodec<FiringRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}