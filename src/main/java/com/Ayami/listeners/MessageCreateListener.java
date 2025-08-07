package com.Ayami.listeners;

import com.Ayami.comandos.Comando;
import com.Ayami.handler.CommandHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageCreateListener extends ListenerAdapter {
    private final CommandHandler handler = new CommandHandler();

    @Override
public void onMessageReceived(MessageReceivedEvent event) {
    
    if (event.getAuthor().isBot()) return;

    String content = event.getMessage().getContentRaw();
    if (!content.startsWith("mw!")) return;

    String[] args = content.substring("mw!".length()).split(" ");
    String commandName = args[0].toLowerCase();

    Comando cmd = handler.getComando(commandName);
    if (cmd != null) {
        cmd.execute(event);
    } else {
        event.getChannel().sendMessage("❌ Comando `" + commandName + "` não encontrado.").queue();
    }
}

}
