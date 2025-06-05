package com.mistfist.thisismagicmod;

import com.mojang.logging.LogUtils;
import com.mistfist.thisismagicmod.magic.MagicSystem;
import com.mistfist.thisismagicmod.registry.ModItems;
import com.mistfist.thisismagicmod.registry.ModCreativeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ThisIsMagic.MOD_ID)
public class ThisIsMagic {
    public static final String MOD_ID = "thisismagicmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ThisIsMagic() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register our mod's registries
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // Register magic system
        MagicSystem.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation makeID(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
} 