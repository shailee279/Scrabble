package com.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import Message.Message;

public class EachConnection implements Runnable {
    private Socket clientSocket = null;
    private ServerSocket listeningSocket = null;
    private static Server Server = new Server();
    private int clientNum;
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Message clientMsg;
    private String clientName;


    public EachConnection(Socket clientSocket, int clientNum) {
        try {
            this.clientSocket = clientSocket;
            this.in = clientSocket.getInputStream();
            this.ois = new ObjectInputStream(in);

            this.out = clientSocket.getOutputStream();
            this.oos = new ObjectOutputStream(out);

            this.clientNum = clientNum;
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    // listening from client message
    @Override
    public void run() {
        try {
            while (true) {
                /*
                clientMsg = (Message) ois.readObject();

                //clientMsg.getMessageType().equals("NameRequest")
                nameCheck(clientMsg);
                // Join
                join(clientMsg);
                //ingame

                if (mType.equals("ready")) {
                    ready();
                } else if (mType.equals("gameContent")) {
                    gameContent();
                } else if (mType.equals("voting")) {
                    voting();
                } else if (mType.equals("pass")) {
                }
                */
            }
        }
        catch(SocketException ex){
            ex.printStackTrace();
        }catch(EOFException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } finally{
            if (listeningSocket != null) {
                try {
                    listeningSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
