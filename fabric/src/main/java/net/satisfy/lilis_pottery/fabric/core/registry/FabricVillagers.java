package net.satisfy.lilis_pottery.fabric.core.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.core.registry.ObjectRegistry;

@SuppressWarnings("deprecation")
public class FabricVillagers {

    private static final ResourceLocation CLAYWORKER_POI_IDENTIFIER = LilisPottery.identifier("clayworker_poi");
    public static final PoiType CLAYWORKER_POI = PointOfInterestHelper.register(CLAYWORKER_POI_IDENTIFIER, 1, 1, ObjectRegistry.POTTERY_TABLE.get());
    public static final VillagerProfession CLAYWORKER = Registry.register(
            BuiltInRegistries.VILLAGER_PROFESSION,
            LilisPottery.identifier("clayworker"),
            VillagerProfessionBuilder.create()
                    .id(LilisPottery.identifier("clayworker"))
                    .workstation(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, CLAYWORKER_POI_IDENTIFIER))
                    .build()
    );

    public static void init() {
        TradeOfferHelper.registerVillagerOffers(CLAYWORKER, 1, factories -> {
            factories.add(new SellItemFactory(ObjectRegistry.POTTERY_TABLE.get(), 3, 1, 8));
            factories.add(new SellItemFactory(ObjectRegistry.PLANTER.get(), 2, 1, 10));
            factories.add(new SellItemFactory(ObjectRegistry.PLANT_BOWL.get(), 2, 1, 10));
            factories.add(new SellItemFactory(ObjectRegistry.BUD_VASE.get(), 2, 1, 10));
            factories.add(new SellItemFactory(ObjectRegistry.CUPELLA.get(), 2, 1, 10));
        });

        TradeOfferHelper.registerVillagerOffers(CLAYWORKER, 2, factories -> {
            factories.add(new SellItemFactory(ObjectRegistry.VASE.get(), 3, 1, 10));
            factories.add(new SellItemFactory(ObjectRegistry.GARDEN_POT.get(), 3, 1, 10));
            factories.add(new SellItemFactory(ObjectRegistry.SQUARE_POT.get(), 3, 1, 10));
            factories.add(new SellItemFactory(ObjectRegistry.HANDMADE_BRICKS.get(), 1, 8, 12));
        });

        TradeOfferHelper.registerVillagerOffers(CLAYWORKER, 3, factories -> {
            factories.add(new SellItemFactory(ObjectRegistry.RED_VASE.get(), 4, 1, 8));
            factories.add(new SellItemFactory(ObjectRegistry.YELLOW_VASE.get(), 4, 1, 8));
            factories.add(new SellItemFactory(ObjectRegistry.WHITE_VASE.get(), 4, 1, 8));
            factories.add(new SellItemFactory(ObjectRegistry.BLUE_VASE.get(), 4, 1, 8));
            factories.add(new SellItemFactory(ObjectRegistry.BLACK_VASE.get(), 4, 1, 8));
        });

        TradeOfferHelper.registerVillagerOffers(CLAYWORKER, 4, factories -> {
            factories.add(new SellItemFactory(ObjectRegistry.KILN.get(), 8, 1, 6));
            factories.add(new SellItemFactory(ObjectRegistry.LILIS_POTTERY_TABLE.get(), 6, 1, 6));
            factories.add(new SellItemFactory(ObjectRegistry.RED_BRICKS.get(), 2, 16, 8));
            factories.add(new SellItemFactory(ObjectRegistry.YELLOW_BRICKS.get(), 2, 16, 8));
            factories.add(new SellItemFactory(ObjectRegistry.WHITE_BRICKS.get(), 2, 16, 8));
            factories.add(new SellItemFactory(ObjectRegistry.BLUE_BRICKS.get(), 2, 16, 8));
            factories.add(new SellItemFactory(ObjectRegistry.BLACK_BRICKS.get(), 2, 16, 8));
            factories.add(new SellItemFactory(ObjectRegistry.CHISELED_BRICKS.get(), 3, 8, 8));
        });

        TradeOfferHelper.registerVillagerOffers(CLAYWORKER, 5, factories -> {
            factories.add(new SellItemFactory(ObjectRegistry.URN.get(), 10, 1, 4));
            factories.add(new SellItemFactory(ObjectRegistry.AMPHORE.get(), 10, 1, 4));

            factories.add(new SellItemFactory(ObjectRegistry.RED_URN.get(), 12, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.YELLOW_URN.get(), 12, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.WHITE_URN.get(), 12, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.BLUE_URN.get(), 12, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.BLACK_URN.get(), 12, 1, 3));

            factories.add(new SellItemFactory(ObjectRegistry.RED_AMPHORE.get(), 14, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.YELLOW_AMPHORE.get(), 14, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.WHITE_AMPHORE.get(), 14, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.BLUE_AMPHORE.get(), 14, 1, 3));
            factories.add(new SellItemFactory(ObjectRegistry.BLACK_AMPHORE.get(), 14, 1, 3));

            factories.add(new SellItemFactory(ObjectRegistry.CHISELED_RED_BRICKS.get(), 5, 8, 6));
            factories.add(new SellItemFactory(ObjectRegistry.CHISELED_YELLOW_BRICKS.get(), 5, 8, 6));
            factories.add(new SellItemFactory(ObjectRegistry.CHISELED_WHITE_BRICKS.get(), 5, 8, 6));
            factories.add(new SellItemFactory(ObjectRegistry.CHISELED_BLUE_BRICKS.get(), 5, 8, 6));
            factories.add(new SellItemFactory(ObjectRegistry.CHISELED_BLACK_BRICKS.get(), 5, 8, 6));
        });
    }

    static class SellItemFactory implements VillagerTrades.ItemListing {
        private final ItemStack sell;
        private final int price;
        private final int count;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public SellItemFactory(Block block, int price, int count, int experience) {
            this(new ItemStack(block), price, count, 12, experience);
        }

        public SellItemFactory(Item item, int price, int count, int experience) {
            this(new ItemStack(item), price, count, 12, experience);
        }

        public SellItemFactory(Item item, int price, int count, int maxUses, int experience) {
            this(new ItemStack(item), price, count, maxUses, experience);
        }

        public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience) {
            this(stack, price, count, maxUses, experience, 0.05F);
        }

        public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience, float multiplier) {
            this.sell = stack;
            this.price = price;
            this.count = count;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        @Override
        public MerchantOffer getOffer(Entity entity, RandomSource random) {
            return new MerchantOffer(new ItemCost(Items.EMERALD, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, this.experience, this.multiplier);
        }
    }
}