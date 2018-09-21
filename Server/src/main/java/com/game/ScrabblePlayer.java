package com.game;

import com.messages.PlayerStatus;

public class ScrabblePlayer {
    private String playerId;
    private int score;
    private PlayerStatus status;

    public ScrabblePlayer(String playerId,PlayerStatus status) {
        this.playerId = playerId;
        this.status = status;
    }

    private void gameStats(){

    }

    public void setPlayerId(String playerId) {

        this.playerId = playerId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerId() {

        return playerId;
    }

    public int getScore() {
        return score;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

}
