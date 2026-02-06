package com.notkpc.welcomejumpmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WelcomeJumpMod.MODID)
public class WelcomeJumpMod { // <--- Nombre de la Clase
    public static final String MODID = "welcomejump";

    // EL CONSTRUCTOR DEBE LLAMARSE IGUAL QUE LA CLASE:
    public WelcomeJumpMod() { // <--- ¡Aquí estaba el error!
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registramos los eventos
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }
}