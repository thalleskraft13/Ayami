package com.Ayami.comandos.util;

import com.Ayami.comandos.Comando;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDAInfo;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.ActionRow;

import java.awt.Color;

public class InfoCommand implements Comando {

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        Message message = event.getMessage();

        
        String botName = event.getJDA().getSelfUser().getName();
        String botAvatar = event.getJDA().getSelfUser().getEffectiveAvatarUrl();
        long totalUsuarios = event.getJDA().getGuilds().stream()
                .mapToLong(guild -> guild.getMemberCount())
                .sum();
        String jdaVersion = JDAInfo.VERSION;
        Guild guild = event.getGuild();

        
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Minhas informações :)");
        embed.setDescription(String.format("Sou uma robô exclusivamente para o servidor **%s**!", guild.getName()));
        embed.addField("Usuários únicos:", String.format("%d", totalUsuarios), false);
        embed.addField("Versão do JDA:", jdaVersion, false);
        embed.setColor(Color.CYAN);
        embed.setThumbnail(botAvatar);

    
        Button githubButton = Button.link("https://github.com/thalleskraft13/Ayami", "🌐 GitHub");

        message.reply(message.getAuthor().getAsMention())
                .setEmbeds(embed.build())
                .setActionRow(githubButton)
                .queue();
    }
}
