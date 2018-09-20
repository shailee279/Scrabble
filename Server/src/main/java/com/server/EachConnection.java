package com.server;

import com.message.Message;
import com.message.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class EachConnection implements Runnable {

    private Socket clientSocket;
    private static Server Server = new Server();
    private int clientNum;
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String clientName;
    static Logger logger = LoggerFactory.getLogger(EachConnection.class);



    public EachConnection(Socket clientSocket, int clientNum) {
        this.clientSocket = clientSocket;
        this.clientNum = clientNum;
    }


    // listening from client message
    @Override
    public void run() {

        try {
            this.in = clientSocket.getInputStream();
            this.ois = new ObjectInputStream(in);

            this.out = clientSocket.getOutputStream();
            this.oos = new ObjectOutputStream(out);

            while (clientSocket.isConnected()){
                Message clientMsg = (Message) ois.readObject();
                clientMsg.setMessageType(MessageType.NameRequest);
                nameCheck(clientMsg);

                //Join
                join(clientMsg);

                //Online
                //TODO - Ethan & Eric
                switch (clientMsg.getMessageType()){
                    case READY:
//                        ready();
                        break;
                    case GAME_CONTENT:
//                        gameContent();
                        break;
                    case VOTING:
//                        voting();
                        break;
                    case PASS:
                        break;
                }


            }

        } catch (SocketException socketException){
            logger.info("Client on port "+clientSocket.getPort()+" exited.");
            //TODO clientNum -1
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    private void nameCheck(Message m){
        String name = m.getClientName();
        Message m2Client = new Message();
    /*
    if valid
       m2Client sets userlist,gamelist and a confirm message
       write
    else
        set non-valid m
        write
     */
    }

    private void join(Message m){
        // game id
        // check list
        //check numOfPlayer
        //if < 4
        //change status
        //player.setStatus("inroom");
        Server.addNewPlayer(m);
        // if number ==0;
        // server create a thread "game"
        Server.createGameThread(m);
        // set non-valid m
        //
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    }
