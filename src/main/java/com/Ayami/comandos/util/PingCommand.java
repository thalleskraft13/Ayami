package com.Ayami.comandos.util;

import com.Ayami.comandos.Comando;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand implements Comando {

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        long startTime = System.currentTimeMillis();

        event.getMessage().reply("🏓 Ping?").queue(response -> {
            long latency = System.currentTimeMillis() - startTime;
            long gatewayPing = event.getJDA().getGatewayPing();

            response.editMessage("🏓 Pong! `" + latency + "ms` | WebSocket: `" + gatewayPing + "ms`").queue();
        });
    }
}
