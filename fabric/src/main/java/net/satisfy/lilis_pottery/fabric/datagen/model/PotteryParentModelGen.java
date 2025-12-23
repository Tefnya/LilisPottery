package net.satisfy.lilis_pottery.fabric.datagen.model;

import com.google.gson.JsonObject;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.resources.ResourceLocation;

public interface PotteryParentModelGen {

    static void generate(BlockModelGenerators modelGen) {
        generateSet(modelGen, "brick");
        generateSet(modelGen, "red_brick");
        generateSet(modelGen, "yellow_brick");
        generateSet(modelGen, "white_brick");
        generateSet(modelGen, "blue_brick");
        generateSet(modelGen, "dark_brick");
    }

    private static void generateSet(BlockModelGenerators modelGen, String prefix) {
        amphore(modelGen, prefix);
        budVase(modelGen, prefix);
        cupella(modelGen, prefix);
        gardenPot(modelGen, prefix);
        plantBowl(modelGen, prefix);
        planter(modelGen, prefix);
        squarePot(modelGen, prefix);
        urn(modelGen, prefix);
        vase(modelGen, prefix);

        amphoreTinted(modelGen, prefix);
        budVaseTinted(modelGen, prefix);
        cupellaTinted(modelGen, prefix);
        gardenPotTinted(modelGen, prefix);
        plantBowlTinted(modelGen, prefix);
        planterTinted(modelGen, prefix);
        squarePotTinted(modelGen, prefix);
        urnTinted(modelGen, prefix);
        vaseTinted(modelGen, prefix);
    }

    private static void amphore(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "amphore_side"));
        textures.addProperty("1", tex(prefix, "urn_top"));
        textures.addProperty("2", tex(prefix, "urn_bottom"));
        textures.addProperty("particle", tex(prefix, "amphore_side"));
        parented(modelGen, prefix, "amphore", textures);
    }

    private static void budVase(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "bud_vase_side"));
        textures.addProperty("1", tex(prefix, "bud_vase_top"));
        textures.addProperty("2", tex(prefix, "bud_vase_bottom"));
        textures.addProperty("3", soil());
        textures.addProperty("particle", tex(prefix, "bud_vase_side"));
        parented(modelGen, prefix, "bud_vase", textures);
    }

    private static void cupella(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "cupella_side"));
        textures.addProperty("1", tex(prefix, "bud_vase_bottom"));
        textures.addProperty("2", tex(prefix, "bud_vase_top"));
        textures.addProperty("3", soil());
        textures.addProperty("particle", tex(prefix, "cupella_side"));
        parented(modelGen, prefix, "cupella", textures);
    }

    private static void gardenPot(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("1", tex(prefix, "garden_pot_side"));
        textures.addProperty("2", tex(prefix, "garden_pot_top"));
        textures.addProperty("3", soil());
        textures.addProperty("4", tex(prefix, "plant_bowl_bottom"));
        textures.addProperty("particle", tex(prefix, "garden_pot_side"));
        parented(modelGen, prefix, "garden_pot", textures);
    }

    private static void plantBowl(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "plant_bowl_bottom"));
        textures.addProperty("1", tex(prefix, "plant_bowl_side"));
        textures.addProperty("2", tex(prefix, "plant_bowl_top"));
        textures.addProperty("3", soil());
        textures.addProperty("particle", tex(prefix, "plant_bowl_bottom"));
        parented(modelGen, prefix, "plant_bowl", textures);
    }

    private static void planter(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "planter_side"));
        textures.addProperty("1", tex(prefix, "planter_top"));
        textures.addProperty("2", tex(prefix, "bud_vase_side"));
        textures.addProperty("3", soil());
        textures.addProperty("particle", tex(prefix, "planter_side"));
        parented(modelGen, prefix, "planter", textures);
    }

    private static void squarePot(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("1", tex(prefix, "garden_pot_side"));
        textures.addProperty("2", tex(prefix, "garden_pot_top"));
        textures.addProperty("3", soil());
        textures.addProperty("4", tex(prefix, "plant_bowl_bottom"));
        textures.addProperty("particle", tex(prefix, "garden_pot_side"));
        parented(modelGen, prefix, "square_pot", textures);
    }

    private static void urn(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "urn_side"));
        textures.addProperty("1", tex(prefix, "urn_top"));
        textures.addProperty("2", tex(prefix, "urn_bottom"));
        textures.addProperty("particle", tex(prefix, "urn_side"));
        parented(modelGen, prefix, "urn", textures);
    }

    private static void vase(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "vase_side"));
        textures.addProperty("2", tex(prefix, "bud_vase_bottom"));
        textures.addProperty("3", tex(prefix, "urn_bottom"));
        textures.addProperty("4", tex(prefix, "vase_top"));
        textures.addProperty("5", soil());
        textures.addProperty("particle", tex(prefix, "vase_side"));
        parented(modelGen, prefix, "vase", textures);
    }

    private static void amphoreTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "amphore_tinted_side"));
        textures.addProperty("1", tex(prefix, "urn_top"));
        textures.addProperty("2", tex(prefix, "urn_bottom"));
        textures.addProperty("3", pattern("amphore_pattern"));
        textures.addProperty("particle", tex(prefix, "amphore_tinted_side"));
        parentedTinted(modelGen, prefix, "amphore", textures);
    }

    private static void budVaseTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "bud_vase_tinted_side"));
        textures.addProperty("1", tex(prefix, "bud_vase_top"));
        textures.addProperty("2", tex(prefix, "bud_vase_bottom"));
        textures.addProperty("3", soil());
        textures.addProperty("4", pattern("bud_vase_pattern"));
        textures.addProperty("particle", tex(prefix, "bud_vase_tinted_side"));
        parentedTinted(modelGen, prefix, "bud_vase", textures);
    }

    private static void cupellaTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "cupella_tinted_side"));
        textures.addProperty("1", tex(prefix, "bud_vase_bottom"));
        textures.addProperty("2", tex(prefix, "bud_vase_top"));
        textures.addProperty("3", soil());
        textures.addProperty("4", pattern("cupella_pattern"));
        textures.addProperty("particle", tex(prefix, "cupella_tinted_side"));
        parentedTinted(modelGen, prefix, "cupella", textures);
    }

    private static void gardenPotTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("1", tex(prefix, "garden_pot_tinted_side"));
        textures.addProperty("2", tex(prefix, "garden_pot_top"));
        textures.addProperty("3", soil());
        textures.addProperty("4", tex(prefix, "plant_bowl_bottom"));
        textures.addProperty("5", pattern("garden_pot_pattern"));
        textures.addProperty("particle", tex(prefix, "garden_pot_tinted_side"));
        parentedTinted(modelGen, prefix, "garden_pot", textures);
    }

    private static void plantBowlTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "plant_bowl_bottom"));
        textures.addProperty("1", tex(prefix, "plant_bowl_tinted_side"));
        textures.addProperty("2", tex(prefix, "plant_bowl_top"));
        textures.addProperty("3", soil());
        textures.addProperty("4", pattern("plant_bowl_pattern"));
        textures.addProperty("particle", tex(prefix, "plant_bowl_tinted_side"));
        parentedTinted(modelGen, prefix, "plant_bowl", textures);
    }

    private static void planterTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "planter_tinted_side"));
        textures.addProperty("1", tex(prefix, "planter_top"));
        textures.addProperty("2", tex(prefix, "bud_vase_side"));
        textures.addProperty("3", soil());
        textures.addProperty("4", pattern("planter_pattern"));
        textures.addProperty("particle", tex(prefix, "planter_tinted_side"));
        parentedTinted(modelGen, prefix, "planter", textures);
    }

    private static void squarePotTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("1", tex(prefix, "garden_pot_tinted_side"));
        textures.addProperty("2", tex(prefix, "garden_pot_top"));
        textures.addProperty("3", soil());
        textures.addProperty("4", tex(prefix, "plant_bowl_bottom"));
        textures.addProperty("5", pattern("garden_pot_pattern"));
        textures.addProperty("particle", tex(prefix, "garden_pot_tinted_side"));
        parentedTinted(modelGen, prefix, "square_pot", textures);
    }

    private static void urnTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "urn_tinted_side"));
        textures.addProperty("1", tex(prefix, "urn_top"));
        textures.addProperty("2", tex(prefix, "urn_bottom"));
        textures.addProperty("3", pattern("urn_pattern"));
        textures.addProperty("particle", tex(prefix, "urn_tinted_side"));
        parentedTinted(modelGen, prefix, "urn", textures);
    }

    private static void vaseTinted(BlockModelGenerators modelGen, String prefix) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0", tex(prefix, "vase_tinted_side"));
        textures.addProperty("2", tex(prefix, "bud_vase_bottom"));
        textures.addProperty("3", tex(prefix, "urn_bottom"));
        textures.addProperty("4", tex(prefix, "vase_top"));
        textures.addProperty("5", soil());
        textures.addProperty("6", pattern("vase_pattern"));
        textures.addProperty("particle", tex(prefix, "vase_tinted_side"));
        parentedTinted(modelGen, prefix, "vase", textures);
    }

    private static void parented(BlockModelGenerators modelGen, String prefix, String name, JsonObject textures) {
        JsonObject root = new JsonObject();
        root.addProperty("parent", template(name).toString());
        root.add("textures", textures);
        modelGen.modelOutput.accept(model(prefix, name), () -> root);
    }

    private static void parentedTinted(BlockModelGenerators modelGen, String prefix, String name, JsonObject textures) {
        JsonObject root = new JsonObject();
        root.addProperty("parent", templateTinted(name).toString());
        root.add("textures", textures);
        modelGen.modelOutput.accept(modelTinted(prefix, name), () -> root);
    }

    private static ResourceLocation model(String prefix, String name) {
        return ResourceLocation.fromNamespaceAndPath("lilis_pottery", "block/" + prefix + "_" + name);
    }

    private static ResourceLocation modelTinted(String prefix, String name) {
        return ResourceLocation.fromNamespaceAndPath("lilis_pottery", "block/" + prefix + "_" + name + "_tinted");
    }

    private static ResourceLocation template(String name) {
        return ResourceLocation.fromNamespaceAndPath("lilis_pottery", "block/template_" + name);
    }

    private static ResourceLocation templateTinted(String name) {
        return ResourceLocation.fromNamespaceAndPath("lilis_pottery", "block/template_tinted_" + name);
    }

    private static String tex(String prefix, String suffix) {
        return "lilis_pottery:block/" + prefix + "_" + suffix;
    }

    private static String soil() {
        return "lilis_pottery:block/plant_soil";
    }

    private static String pattern(String name) {
        return "lilis_pottery:block/pattern/" + name;
    }
}