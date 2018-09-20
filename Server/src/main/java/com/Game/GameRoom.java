package com.game;

import com.message.Message;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class GameRoom implements Runnable{
    private static int MAXIMUMPLAYERNUMBER = 100;              // assuming there are up to 100 players
    private static int MINIMUMPLAYERNUMBER = 2;
    private int numOfPlayer = 0;                               // tracking number of total players
    private ScrabblePlayer[] playerList = new ScrabblePlayer[MAXIMUMPLAYERNUMBER];
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private int spaceRemain = 400;
    private int gameId;

    public GameRoom(String playerName,int gameId) {
        this.playerList[numOfPlayer] = new ScrabblePlayer(playerName,"inroom");
        this.numOfPlayer +=1;
        this.gameId = gameId;
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }

    // listening from clients' game info
    @Override
    public void run() {
        while (true) {
            /*
            // m = (message) ois.readObject();
            // String mType = m.getType();
            String mType = "";

            if (mType.equals("ready")) {
                ready();
            } else if (mType.equals("gameContent")) {
                gameContent();
            } else if (mType.equals("voting")) {
                voting();
            } else if (mType.equals("pass")){
                pass();
            } else if (mType.equals("addPlayer")){
                addPlayer();
            } else if (mType.equals("addPlayer")) {
                deletePlayer();
            }
            */
        }
    }

    // when click ready button

    private void addPlayer(Message m){
        this.playerList[numOfPlayer] = new ScrabblePlayer(m.getClientName(),"inroom");
        this.numOfPlayer+=1;
    }

    private void deletePlayer(Message m){
        int index = indexOf(m.getClientName());
        if (index != -1){
            playerList[index] = null;
            for (int x = 0; x < numOfPlayer ; x++) {
                if(x>=index){
                    playerList[x] = playerList[x+1];
                }
            }
        }
        this.numOfPlayer-=1;
    }

    private int indexOf(String userName){
        for (int i = 0; i <numOfPlayer ; i++) {
            if (playerList[i].getPlayerId().equals(userName)){
                return i;
            }
        }
        return -1;
    }

    private void ready(){
        int numReady= 0;
        //change status
        //player.setStatus("ready");
        // send message to other players

        //check how many players are in ready condition
        for (ScrabblePlayer scrabblePlayer : playerList) {
            if (scrabblePlayer.getStatus().equals("ready")){
                numReady +=1;
            }
        }

        if (numReady == numOfPlayer && numReady >= MINIMUMPLAYERNUMBER ){
            startGame();
        }

    }

    public void startGame(){
        broadCast(); // players
        sequenceDecision();
    }

    private void sequenceDecision(){
        //return the message that who should go first
    }

    private void gameContent(Message m){
//        Character Gamecharacter = m.getGamecharacter();
//        String Gamelocation = m.getGamelocation();
//        String Gameword = m.getGameword();

        // send message to other players
        for (ScrabblePlayer scrabblePlayer : playerList) {
            broadCast();
        }
    }

    private void voting(){
        // if one N
        //  write "Player X loses this turn"
        if (!gameEnd()){
            sequenceDecision();
        }

        // else{
        //    change score and broadcast
        if (!gameEnd()){
            sequenceDecision();
        }

        gameResult();
    }

    private void pass(){
        // check number of pass numbers
        // == K, then end game
        // broadcast
    }

    private boolean gameEnd(){
        if (numOfPlayer < MINIMUMPLAYERNUMBER|| spaceRemain == 0){
            return true;
        }
        return false;
    }

    private void broadCast(){
        //Broadcast to other players
    }

    private void gameResult(){

    }

    public int getGameId() {
        return gameId;
    }
}
