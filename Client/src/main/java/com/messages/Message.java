package com.messages;

import java.io.Serializable;

public class Message implements Serializable{

    private MessageType messageType;
    private Character gameCharacter;
    private String gameLocation;
    private String gameWord;
    private String clientName;
    private int tableId;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Character getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(Character gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public String getGameWord() {
        return gameWord;
    }

    public void setGameWord(String gameWord) {
        this.gameWord = gameWord;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

}
