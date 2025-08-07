// src/main/java/com/Ayami/database/MongoManager.java
package com.Ayami.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoManager {
    private static MongoClient client;
    private static MongoDatabase database;

    public static void connect() {
        String uri = System.getenv("MONGO"); 
        client = MongoClients.create(uri);
        database = client.getDatabase("AyamiBot");
        System.out.println("✅ Conectado ao MongoDB com sucesso!");
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void close() {
        if (client != null) client.close();
    }
}
