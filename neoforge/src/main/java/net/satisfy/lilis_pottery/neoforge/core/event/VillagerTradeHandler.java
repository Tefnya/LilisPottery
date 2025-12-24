package net.satisfy.lilis_pottery.neoforge.core.event;

import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Items;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;
import net.satisfy.lilis_pottery.core.util.VillagerUtil;

public final class VillagerTradeHandler {

    public static void init() {
        VillagerProfession clayworker = getProfession(LilisPottery.identifier("clayworker"));
        if (clayworker == null) return;

        TradeRegistry.registerVillagerTrade(clayworker, 1,
                new VillagerUtil.SellItemFactory(ObjectRegistry.POTTERY_TABLE.get().asItem(), 3, 1, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.PLANTER.get().asItem(), 2, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.PLANT_BOWL.get().asItem(), 2, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BUD_VASE.get().asItem(), 2, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CUPELLA.get().asItem(), 2, 1, 10),
                new VillagerUtil.SellItemFactory(Items.CLAY_BALL, 1, 8, 16)
        );

        TradeRegistry.registerVillagerTrade(clayworker, 2,
                new VillagerUtil.SellItemFactory(ObjectRegistry.VASE.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.GARDEN_POT.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.SQUARE_POT.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.HANDMADE_BRICKS.get().asItem(), 1, 8, 12),
                new VillagerUtil.SellItemFactory(ObjectRegistry.RED_BRICK.get(), 1, 6, 12),
                new VillagerUtil.SellItemFactory(ObjectRegistry.YELLOW_BRICK.get(), 1, 6, 12),
                new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_BRICK.get(), 1, 6, 12),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLUE_BRICK.get(), 1, 6, 12),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLACK_BRICK.get(), 1, 6, 12)
        );

        TradeRegistry.registerVillagerTrade(clayworker, 3,
                new VillagerUtil.SellItemFactory(ObjectRegistry.RED_PLANTER.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.YELLOW_PLANTER.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_PLANTER.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLUE_PLANTER.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLACK_PLANTER.get().asItem(), 3, 1, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.RED_VASE.get().asItem(), 4, 1, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.YELLOW_VASE.get().asItem(), 4, 1, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_VASE.get().asItem(), 4, 1, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLUE_VASE.get().asItem(), 4, 1, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLACK_VASE.get().asItem(), 4, 1, 8)
        );

        TradeRegistry.registerVillagerTrade(clayworker, 4,
                new VillagerUtil.SellItemFactory(ObjectRegistry.KILN.get().asItem(), 8, 1, 6),
                new VillagerUtil.SellItemFactory(ObjectRegistry.LILIS_POTTERY_TABLE.get().asItem(), 6, 1, 6),
                new VillagerUtil.SellItemFactory(ObjectRegistry.RED_BRICKS.get().asItem(), 2, 16, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.YELLOW_BRICKS.get().asItem(), 2, 16, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_BRICKS.get().asItem(), 2, 16, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLUE_BRICKS.get().asItem(), 2, 16, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLACK_BRICKS.get().asItem(), 2, 16, 8),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CHISELED_BRICKS.get().asItem(), 3, 8, 8)
        );

        TradeRegistry.registerVillagerTrade(clayworker, 5,
                new VillagerUtil.SellItemFactory(ObjectRegistry.URN.get().asItem(), 10, 1, 4),
                new VillagerUtil.SellItemFactory(ObjectRegistry.AMPHORE.get().asItem(), 10, 1, 4),
                new VillagerUtil.SellItemFactory(ObjectRegistry.RED_URN.get().asItem(), 12, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.YELLOW_URN.get().asItem(), 12, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_URN.get().asItem(), 12, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLUE_URN.get().asItem(), 12, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLACK_URN.get().asItem(), 12, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.RED_AMPHORE.get().asItem(), 14, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.YELLOW_AMPHORE.get().asItem(), 14, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_AMPHORE.get().asItem(), 14, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLUE_AMPHORE.get().asItem(), 14, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLACK_AMPHORE.get().asItem(), 14, 1, 3),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CHISELED_RED_BRICKS.get().asItem(), 5, 8, 6),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CHISELED_YELLOW_BRICKS.get().asItem(), 5, 8, 6),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CHISELED_WHITE_BRICKS.get().asItem(), 5, 8, 6),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CHISELED_BLUE_BRICKS.get().asItem(), 5, 8, 6),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CHISELED_BLACK_BRICKS.get().asItem(), 5, 8, 6)
        );
    }

    private static VillagerProfession getProfession(ResourceLocation professionId) {
        return BuiltInRegistries.VILLAGER_PROFESSION.getOptional(professionId).orElse(null);
    }
}