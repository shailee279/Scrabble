package com.game;

public class ScrabblePlayer {
    private String playerId;
    private int score;
    private String status;

    public ScrabblePlayer(String playerId,String status) {
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlayerId() {

        return playerId;
    }

    public int getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }
}
