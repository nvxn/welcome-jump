package com.notkpc.welcomejumpmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WelcomeJumpMod.MODID)
public class WelcomeJumpMod { 
    public static final String MODID = "welcomejump";

    public WelcomeJumpMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }
}