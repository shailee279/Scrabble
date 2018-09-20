package com.model.login;

import com.view.username.UsernameController;

import java.io.IOException;
import java.net.Socket;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/20 15:07
 */
public class LoginListener implements Runnable {

    private Socket socket;
    private String host;
    private int port;
    private UsernameController usernameController;

    public LoginListener(String host, int port, UsernameController usernameController){
        this.host = host;
        this.port = port;
        this.usernameController = usernameController;
    }

    @Override
    public void run() {
        try{
            socket = new Socket(host, port);
            //TODO
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
