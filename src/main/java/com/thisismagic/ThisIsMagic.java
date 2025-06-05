package com.thisismagic;

import com.mojang.logging.LogUtils;
import com.thisismagic.magic.MagicSystem;
import com.thisismagic.registry.ModRegistries;
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
        ModRegistries.register(modEventBus);

        // Register magic system
        MagicSystem.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation makeID(String path) {
        return ResourceLocation.tryParse(MOD_ID + ":" + path);
    }
} 