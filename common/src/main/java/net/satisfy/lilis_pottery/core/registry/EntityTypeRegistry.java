package net.satisfy.lilis_pottery.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.satisfy.lilis_pottery.LilisPottery;
import net.satisfy.lilis_pottery.core.block.entity.AbstractStorageBlockEntity;
import net.satisfy.lilis_pottery.core.block.entity.KilnBlockEntity;
import net.satisfy.lilis_pottery.core.block.entity.PotteryTableBlockEntity;
import net.satisfy.lilis_pottery.core.block.entity.UrnBlockEntity;

import java.util.HashSet;
import java.util.function.Supplier;

public class EntityTypeRegistry {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(LilisPottery.MOD_ID, Registries.BLOCK_ENTITY_TYPE);
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(LilisPottery.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<AbstractStorageBlockEntity>> STORAGE_BLOCK_ENTITY = registerBlockEntity("storage_block", () -> BlockEntityType.Builder.of(AbstractStorageBlockEntity::new, StorageTypeRegistry.registerBlocks(new HashSet<>()).toArray(new Block[0])).build(null));
    public static final RegistrySupplier<BlockEntityType<PotteryTableBlockEntity>> POTTERY_TABLE_BLOCK_ENTITY = registerBlockEntity("pottery_table", () -> BlockEntityType.Builder.of(PotteryTableBlockEntity::new, ObjectRegistry.POTTERY_TABLE.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<UrnBlockEntity>> URN_BLOCK_ENTITY = registerBlockEntity("urn", () -> BlockEntityType.Builder.of(UrnBlockEntity::new, ObjectRegistry.BRICK_URN.get(), ObjectRegistry.BRICK_AMPHORE.get(), ObjectRegistry.RED_BRICK_URN.get(), ObjectRegistry.RED_BRICK_AMPHORE.get(), ObjectRegistry.YELLOW_BRICK_URN.get(), ObjectRegistry.YELLOW_BRICK_AMPHORE.get(), ObjectRegistry.WHITE_BRICK_URN.get(), ObjectRegistry.WHITE_BRICK_AMPHORE.get(), ObjectRegistry.BLUE_BRICK_URN.get(), ObjectRegistry.BLUE_BRICK_AMPHORE.get(), ObjectRegistry.DARK_BRICK_URN.get(), ObjectRegistry.DARK_BRICK_AMPHORE.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<KilnBlockEntity>> KILN_BLOCK_ENTITY = registerBlockEntity("kiln", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ObjectRegistry.KILN.get()).build(null));


    public static <T extends EntityType<?>> RegistrySupplier<T> registerEntity(final String path, final Supplier<T> type) {
        return ENTITY_TYPES.register(LilisPottery.identifier(path), type);
    }

    private static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(LilisPottery.identifier(path), type);
    }

    public static void init() {
        ENTITY_TYPES.register();
        BLOCK_ENTITY_TYPES.register();
    }
}
