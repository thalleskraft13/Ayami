package com.Ayami.comandos;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Comando {
    String getName();
    void execute(MessageReceivedEvent event);
}
