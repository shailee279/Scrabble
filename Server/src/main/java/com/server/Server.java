package com.server;
import java.net.*;
import java.io.*;

import com.message.Message;
import com.game.GameRoom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/18 15:15
 */
public class Server {

    /* Setting up variables */

    // use to track client number
    private static int clientNum = 0;
    private static int PORT = 8888;
    static Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws Exception {

        try {
            if (args.length == 1) {
                PORT = Integer.parseInt(args[0]);
            } else if (args.length == 0) {
                logger.info("The system will using the default setting.");
            } else {
                logger.error(" Usage: java –jar Server.jar </port/> ");
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //1. Open the server
        ServerSocket listeningSocket = new ServerSocket(PORT);
        logger.info("The game server is running on port " + PORT);
        logger.info("Waiting for a connection...");

        try {
            while (true) {

                // 2. Wait and listen for new connections
                Socket clientSocket = listeningSocket.accept();
                clientNum++;

                //TODO - output to UI
                String uiOutput = "Client number" + clientNum + " has connected to the server";
                logger.info("Client connection number: " + clientNum + " .");
                logger.info("Connected to client on port "+ clientSocket.getInetAddress().getHostName()+ clientSocket.getPort());

                //3. One thread per connection
                EachConnection newConnection = new EachConnection(clientSocket,clientNum);
                Thread eachConnection = new Thread(newConnection);
                eachConnection.start();

                // Update the server state to reflect the new connected client
                ServerState.getInstance().clientConnected(newConnection);
//                System.out.println(ServerState.getInstance().getConnectedClients().size());
            }
        } catch (SocketException so){
            logger.error("The listening socket has closed!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (listeningSocket != null){
                try{
                    listeningSocket.close();
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