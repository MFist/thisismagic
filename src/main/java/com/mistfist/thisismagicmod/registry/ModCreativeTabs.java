package com.mistfist.thisismagicmod.registry;

import com.mistfist.thisismagicmod.ThisIsMagic;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThisIsMagic.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RUNES_TAB = CREATIVE_MODE_TABS.register("runes",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.thisismagicmod.runes"))
            .icon(() -> ModItems.RUNE_FORCE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.RUNE_FORCE.get());
                // Add more runes here as they are created
            })
            .build()
    );
} 