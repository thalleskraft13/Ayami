package com.Ayami;

import com.Ayami.database.MongoManager;
import com.Ayami.listeners.MessageCreateListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Ayami {
    public static void main(String[] args) throws Exception {
        
        MongoManager.connect();

        String token = System.getenv("TOKEN");

        JDABuilder.createDefault(token)
            .enableIntents(
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT
            )
            .setActivity(Activity.playing("MiniWorld")) 
            .addEventListeners(new MessageCreateListener())
            .build();

        System.out.println("✅ Ayami está online!");
    }
}
