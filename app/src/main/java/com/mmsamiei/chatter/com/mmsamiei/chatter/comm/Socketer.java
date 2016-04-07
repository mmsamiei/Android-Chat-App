package com.mmsamiei.chatter.com.mmsamiei.chatter.comm;

import com.mmsamiei.chatter.interfacer.Socket;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.HashMap;

/**
 * Created by Win2 on 4/7/2016.
 */
public class Socketer implements Socket {

    private static final String AUTHENTICATION_SERVER_ADDRESS="http://127.0.0.1/androidchatter";

    private int listeningPort=0;
    private static final String HTTP_REQUEST_FAILED =null;
    private HashMap<InetAddress,Socket> sockets = new HashMap<InetAddress,Socket>();
    private ServerSocket serverSocket=null;
    private boolean listening;

    private class ReciveConnection extends Thread{

        Socket clientSocket = null;
        public ReciveConnection(Socket socket){
            this.clientSocket=socket;
            Socketer.this.sockets.put(((ServerSocket)socket).getInetAddress(),socket);
        }
    }

    @Override
    public String sendHTTPRequest(String Params) {
        return null;
    }

    @Override
    public String startListeningPort(int Port) {
        return null;
    }

    @Override
    public void stopListening() {

    }

    @Override
    public void exit() {

    }
}
