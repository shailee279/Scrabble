package com.server;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.net.ServerSocket;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/18 15:15
 */
public class Server {
    /* Setting up variables */
    private static final int PORT = 8888;
    static Logger logger = LoggerFactory.getLogger(Server.class);


    public static void main(String[] args) throws Exception {
        logger.info("The game server is running.");
        ServerSocket listener = new ServerSocket(PORT);

    }
}
