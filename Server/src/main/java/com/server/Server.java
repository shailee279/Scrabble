package com.server;
import java.net.*;
import java.io.*;
import java.util.*;

import Game.GameRoom;
import Message.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/18 15:15
 */
public class Server {
    /* Setting up variables */

    // userlist
    // gamelist
    // namelist
    private Socket clientSocket = null;
    private ServerSocket listeningSocket = null;
    private static Server Server = new Server();
    private int clientNum = 0; // use to track client number
    private static final int PORT = 8888;
    static Logger logger = LoggerFactory.getLogger(Server.class);


    public static void main(String[] args) throws Exception {
        logger.info("The game server is running.");
        ServerSocket listener = new ServerSocket(PORT);


        int portNumber = 1234;

        try {
            if (args.length == 2) {
                portNumber = Integer.parseInt(args[0]);
            } else if (args.length != 0) {
                System.out.println("The system will using the default setting.");
            } else {
                System.out.println("usage: java –jar DictionaryServer.jar <port> <dictionary-file>");
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        try{

            Server.listeningSocket = new ServerSocket(portNumber);

            while (true) {

                System.out.println("Server listening on port 1234 for a connection");

                // 2. wait
                Server.clientSocket = Server.listeningSocket.accept();
                Server.clientNum++;

                String uiOutput = "Client number" + Server.clientNum + " has connected to the server";
                System.out.println("Client connection number " + Server.clientNum + " accepted:");
                System.out.println("Remote Port: " + Server.clientSocket.getPort());
                System.out.println("Remote Hostname: " + Server.clientSocket.getInetAddress().getHostName());
                System.out.println("Local Port: " + Server.clientSocket.getLocalPort());
                // a thread per connection

                EachConnection newConnection = new EachConnection(Server.clientSocket,Server.clientNum);
                Thread eachConnection = new Thread(newConnection);
                eachConnection.start();

                //Update the server state to reflect the new connected client
                ServerState.getInstance().clientConnected(newConnection);
                System.out.println(ServerState.getInstance().getConnectedClients().size());
            }
        }catch (SocketException e){
            System.out.println("The listening socket has closed!");
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (Server.listeningSocket != null){
                try{
                    Server.listeningSocket.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void createGameThread(Message m){
        GameRoom game = new GameRoom(m.getClientName(),m.getTableId());
        Thread GameRoom = new Thread(game);
        GameRoom.start();
        // server state
    }

    public void addNewPlayer(Message m){

    }

}