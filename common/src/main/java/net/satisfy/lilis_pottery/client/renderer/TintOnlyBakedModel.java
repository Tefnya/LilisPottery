package net.satisfy.lilis_pottery.client.renderer;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TintOnlyBakedModel implements BakedModel {

    private final BakedModel parent;

    public TintOnlyBakedModel(BakedModel parent) {
        this.parent = parent;
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource random) {
        List<BakedQuad> quads = parent.getQuads(state, side, random);
        if (quads.isEmpty()) {
            return quads;
        }

        List<BakedQuad> tinted = new ArrayList<>(quads.size());
        for (BakedQuad quad : quads) {
            if (quad.getTintIndex() != -1) {
                tinted.add(quad);
            }
        }
        return tinted;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return parent.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return parent.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return parent.usesBlockLight();
    }

    @Override
    public boolean isCustomRenderer() {
        return parent.isCustomRenderer();
    }

    @Override
    public @NotNull TextureAtlasSprite getParticleIcon() {
        return parent.getParticleIcon();
    }

    @Override
    public @NotNull ItemTransforms getTransforms() {
        return parent.getTransforms();
    }

    @Override
    public @NotNull ItemOverrides getOverrides() {
        return parent.getOverrides();
    }
}