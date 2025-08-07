package com.Ayami.listeners;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("✅ Bot conectado como " + event.getJDA().getSelfUser().getName());
    }
}
