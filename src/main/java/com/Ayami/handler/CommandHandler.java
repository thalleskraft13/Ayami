package com.Ayami.handler;

import com.Ayami.comandos.Comando;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandHandler {
    private final Map<String, Comando> comandos = new HashMap<>();

    public CommandHandler() {
        System.out.println("🔧 Carregando comandos...");
        Reflections reflections = new Reflections("com.Ayami.comandos");

        Set<Class<? extends Comando>> classes = reflections.getSubTypesOf(Comando.class);

        for (Class<? extends Comando> cmdClass : classes) {
            try {
                Comando cmd = cmdClass.getDeclaredConstructor().newInstance();
                String name = cmdClass.getSimpleName().replace("Command", "").toLowerCase();
                comandos.put(name, cmd);
                System.out.println("✅ Comando registrado: " + name);
            } catch (Exception e) {
                System.err.println("❌ Erro ao registrar " + cmdClass.getName());
                e.printStackTrace();
            }
        }
    }

    public Comando getComando(String name) {
        return comandos.get(name.toLowerCase());
    }
}
