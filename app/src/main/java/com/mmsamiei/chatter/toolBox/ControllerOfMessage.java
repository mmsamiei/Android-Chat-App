package com.mmsamiei.chatter.toolBox;

import com.mmsamiei.chatter.typo.InfoOfMessage;

/**
 * Created by Win2 on 3/18/2016.
 */
public class ControllerOfMessage {
        public static final String taken="taken";
        public static InfoOfMessage[] infoOfMessages = null;
        public static void setMessageInfo(InfoOfMessage[] infoOfMessages){
       //problem
            InfoOfMessage.infoOfMessage = infoOfMessages;
        }
        public static InfoOfMessage checkMessage(String username){
            InfoOfMessage result = null;
            for(int i=0;i<infoOfMessages.length;i++){
                result=infoOfMessages[i];
                break;
            }
            return result;
        }
    public static InfoOfMessage[] getMessage(){
        return infoOfMessages;
    }

}
