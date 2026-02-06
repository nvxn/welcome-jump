package com.notkpc.welcomejumpmod;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class ModEvents {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player joiningPlayer = event.getEntity();

        if (!(joiningPlayer instanceof ServerPlayer)) return;
        ServerPlayer serverJoiner = (ServerPlayer) joiningPlayer;
        if (serverJoiner.getServer() == null) return;

        serverJoiner.getServer().getPlayerList().broadcastSystemMessage(
                Component.literal("§c⚠️ ¡CUIDADO! §e" + serverJoiner.getName().getString() + " ha entrado. ¡Sálvese quien pueda!"),
                false
        );

        List<ServerPlayer> playerList = serverJoiner.getServer().getPlayerList().getPlayers();

        for (ServerPlayer player : playerList) {
            if (!player.getUUID().equals(serverJoiner.getUUID())) {
                triggerTrollTrap(player);
            }
        }
    }

    private void triggerTrollTrap(ServerPlayer player) {
        Timer timer = new Timer();

        timer.schedule(new TrollTask(player), 3000); // A los 3 seg
        timer.schedule(new TrollTask(player), 4500); // A los 4.5 seg (remate)
        timer.schedule(new TrollTask(player), 6000); // A los 4.5 seg (remate)
    }

    static class TrollTask extends TimerTask {
        private final ServerPlayer player;
        private final Random random = new Random();

        public TrollTask(ServerPlayer player) {
            this.player = player;
        }

        @Override
        public void run() {
            if (player.getServer() != null) {
                player.getServer().execute(() -> {
                    if (!player.isRemoved() && player.connection != null) {

                        // 1. EL SUSTO (Audio)
                        player.playNotifySound(SoundEvents.CREEPER_PRIMED, SoundSource.HOSTILE, 1.0f, 0.5f);

                        // 2. EL MAREO (Efecto)
                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1, false, false));

                        // 3. LANZAMIENTO RANDOM
                        double randomX = (random.nextDouble() - 0.5) * 3.0;
                        double randomZ = (random.nextDouble() - 0.5) * 3.0;
                        double upForce = 0.6 + (random.nextDouble() * 0.4); // Entre 0.6 y 1.0 para arriba

                        // FUERZA
                        player.setDeltaMovement(randomX, upForce, randomZ);
                        player.hasImpulse = true;

                        player.connection.send(new ClientboundSetEntityMotionPacket(player));
                    }
                });
            }
        }
    }
}