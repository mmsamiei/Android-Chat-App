package com.mmsamiei.chatter.toolBox;

import android.util.Log;

import com.mmsamiei.chatter.interfacer.Updater;
import com.mmsamiei.chatter.typo.InfoOfFriends;
import com.mmsamiei.chatter.typo.InfoOfMessage;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Vector;

/**
 * Created by Win2 on 3/26/2016.
 */
public class ParserXML extends DefaultHandler {
    public String userKey = new String();
    public Updater updater;

    public ParserXML(Updater updater) {
        this.updater = updater;
    }

    private Vector<InfoOfFriends> mFriends = new Vector<InfoOfFriends>();
    private Vector<InfoOfFriends> mOnlineFriends = new Vector<InfoOfFriends>();
    private Vector<InfoOfFriends> mUnapprovedFriends = new Vector<InfoOfFriends>();

    private Vector<Updater> mUnreadMessages = new Vector<Updater>();

    public void endDocument() throws SAXException {
        InfoOfFriends[] friends = new InfoOfFriends[mFriends.size()+mOnlineFriends.size()];
        Updater[] messages = new Updater[mUnreadMessages.size()];

        int onlineFriendCount = mOnlineFriends.size();
        for (int i=0;i<onlineFriendCount;i++){
            friends[i]=mOnlineFriends.get(i);
        }

        int offlineFriendCount = mFriends.size();
        for (int i=0;i<onlineFriendCount;i++){
            friends[i+onlineFriendCount]=mFriends.get(i);
        }

        int unApprovedFriendCount = mUnapprovedFriends.size();
        InfoOfFriends[] unApprovedFriends = new InfoOfFriends[unApprovedFriendCount];
        for(int i=0;i<unApprovedFriendCount;i++){
            unApprovedFriends[i]=mUnapprovedFriends.get(i);
        }

        int unreadMessageCount = mUnreadMessages.size();
        for(int i=0;i<unreadMessageCount;i++){
            messages[i]=mUnreadMessages.get(i);
            Log.i("MessageLOG","i="+i);
        }
        this.updater.updateData((InfoOfMessage[])messages,friends,unApprovedFriends,userKey);
        super.endDocument();
    }
}
