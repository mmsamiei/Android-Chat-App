package com.mmsamiei.chatter.interfacer;

import com.mmsamiei.chatter.typo.InfoOfFriends;
import com.mmsamiei.chatter.typo.InfoOfMessage;

/**
 * Created by Win2 on 3/14/2016.
 */
public interface Updater {
    public  void updateData(InfoOfMessage[] message,InfoOfFriends[] friends,InfoOfFriends[] unApprovedFriends,String userKey);
}
