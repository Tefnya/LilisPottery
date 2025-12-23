package net.satisfy.lilis_pottery.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.satisfy.lilis_pottery.fabric.datagen.lang.EWEnglishLangGen;
import net.satisfy.lilis_pottery.fabric.datagen.model.EWModelGen;

public class LilisPotteryDatagen implements DataGeneratorEntrypoint {
    static FabricDataGenerator.Pack mainPack;

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        mainPack = fabricDataGenerator.createPack();

        mainPack.addProvider(EWEnglishLangGen::new);
        mainPack.addProvider(EWModelGen::new);
    }
}
