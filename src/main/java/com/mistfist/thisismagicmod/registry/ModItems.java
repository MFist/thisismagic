package com.mistfist.thisismagicmod.registry;

import com.mistfist.thisismagicmod.ThisIsMagic;
import com.mistfist.thisismagicmod.item.DamageRuneItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThisIsMagic.MOD_ID);

    // Runes
    public static final RegistryObject<Item> RUNE_FORCE = ITEMS.register("rune_force",
            () -> new DamageRuneItem(new Item.Properties(), 2.0f));
} 