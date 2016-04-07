package com.mmsamiei.chatter.toolBox;

import android.util.Log;

import com.mmsamiei.chatter.interfacer.Updater;
import com.mmsamiei.chatter.typo.InfoOfFriends;
import com.mmsamiei.chatter.typo.InfoOfMessage;
import com.mmsamiei.chatter.typo.InfoStatus;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Vector;
import java.util.jar.Attributes;

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
    public void startElement(String uri,String localName,String name,Attributes attributes) throws SAXException {
         if(localName == "friend"){
             InfoOfFriends friend = new InfoOfFriends();
             friend.userName= attributes.getValue(InfoOfFriends.Username);
             String status = attributes.getValue(InfoOfFriends.Status);

             friend.port=attributes.getValue(InfoOfFriends.Port);

             if(status != null && status.equals("online")){
                 friend.status = InfoStatus.ONLINE;
             }

            else if(status.equals("unApproved")){
                 friend.status=InfoStatus.UNAPPROVED;
                 mUnapprovedFriends.add(friend);
             }
             else{
                 friend.status=InfoStatus.OFFLINE;
                 mFriends.add(friend);
             }
         }
        else if (localName == "user") {
             this.userKey = attributes.getValue(InfoOfFriends.userKey);
         }
       super.startElement(uri,localName,name, (org.xml.sax.Attributes) attributes);
    }

    @Override
    public void startDocument() throws SAXException{
        this.mFriends.clear();
        this.mOnlineFriends.clear();
        this.mUnreadMessages.clear();
        super.startDocument();
    }

}
