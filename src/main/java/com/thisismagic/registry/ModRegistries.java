package com.thisismagic.registry;

import com.thisismagic.ThisIsMagic;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ThisIsMagic.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ThisIsMagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(eventBus);
    }
} 