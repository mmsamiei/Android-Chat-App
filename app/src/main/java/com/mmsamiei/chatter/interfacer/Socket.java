package com.mmsamiei.chatter.interfacer;

/**
 * Created by Win2 on 3/14/2016.
 */
public interface Socket {
    public String sendHTTPRequest(String Params);
    public String startListeningPort(int Port);
    public void stopListening();
    public void exit();
}
