package com.server;

import java.util.ArrayList;
import java.util.List;

import Game.GameRoom;
import Message.Message;

// add gamelist !!!
public class ServerState {

    private static ServerState instance;
    private List<EachConnection> connectedClients;
    private List<GameRoom> createdGames;

    private ServerState() {
        connectedClients = new ArrayList<>();
    }

    public static synchronized ServerState getInstance() {
        if(instance == null) {
            instance = new ServerState();
        }
        return instance;
    }

    public synchronized void clientConnected(EachConnection client) {
        connectedClients.add(client);
    }

    public synchronized void clientDisconnected(EachConnection client) {
        connectedClients.remove(client);
    }

    public synchronized List<EachConnection> getConnectedClients() {
        return connectedClients;
    }
}
