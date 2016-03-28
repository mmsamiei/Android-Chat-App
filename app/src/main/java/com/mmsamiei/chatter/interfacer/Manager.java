package com.mmsamiei.chatter.interfacer;

import java.io.UnsupportedEncodingException;

/**
 * Created by Win2 on 3/14/2016.
 */
public interface Manager {
    public String getUsername();
    public String sendMessage(String username,String toUsername,String message) throws UnsupportedEncodingException;
    public String authenticateUser(String usernameText,String passwordText) throws UnsupportedEncodingException;
    public void messageReceived(String userName,String message);

    public boolean isNetworkConnected();
    public boolean isUserAuthenticated();
    public String getLastRawFriendList();
    public void exit();
    public String signUpUser(String usernameText,String passwordText,String email);
    public String addNewFriendRequest(String friendUsername);
    public String sendFriendReqResponse(String approvedFriendNames,String discardedFriendNames);
}
