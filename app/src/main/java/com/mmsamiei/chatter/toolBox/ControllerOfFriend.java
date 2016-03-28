package com.mmsamiei.chatter.toolBox;

import com.mmsamiei.chatter.typo.InfoOfFriends;

/**
 * Created by Win2 on 3/14/2016.
 */
public class ControllerOfFriend {
    public static InfoOfFriends[] friendsInfo = null;
    public static InfoOfFriends[] unapprovedFriends;
    public String activeFriends;

    public static void setFriendsInfo(InfoOfFriends[] friends) {
        ControllerOfFriend.friendsInfo = friends;
    }

    public static InfoOfFriends checkFriends(String username, String userKey) {
        InfoOfFriends result = null;
        if (friendsInfo != null) {
            for (int i = 0; i < friendsInfo.length; i++) {
                if (friendsInfo[i].Username.equals(username) && friendsInfo[i].Userkey.equals(userKey)) {
                    result = friendsInfo[i];
                    break;
                }
            }
        }
        return result;
    }
    public static InfoOfFriends getFriendInfo(String username){
        InfoOfFriends result = null;
        if (friendsInfo != null) {
            for (int i = 0; i < friendsInfo.length; i++) {
                if (friendsInfo[i].Username.equals(username)) {
                    result = friendsInfo[i];
                    break;
                }
            }
        }
        return result;
    }
}
