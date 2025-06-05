package com.thisismagic.registry;

import com.thisismagic.ThisIsMagic;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThisIsMagic.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THIS_IS_MAGIC_TAB = CREATIVE_MODE_TABS.register("this_is_magic",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ThisIsMagic.MOD_ID + ".this_is_magic"))
                    .icon(() -> Items.BOOK.getDefaultInstance()) // Temporary icon, will be replaced with a magic item later
                    .displayItems((parameters, output) -> {
                        // Items will be added here as we create them
                    })
                    .build()
    );
} 