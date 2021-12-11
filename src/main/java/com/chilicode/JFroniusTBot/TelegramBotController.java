package com.chilicode.JFroniusTBot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

public class TelegramBotController {

    static String tbk;
    static String tcid;

    public TelegramBotController() {
        tbk = System.getenv("TBK");
        tcid = System.getenv("TCID");
    }

    public static String getTbk() {
        return tbk;
    }

    public static String getTcid() {
        return tcid;
    }

    public static void sendMessage(String message){
        
        

        List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();
        data.add(new BasicNameValuePair("chat_id", "-" + getTcid()));
        data.add( new BasicNameValuePair("text", message));

        String urlString = "https://api.telegram.org/bot"+getTbk()+"/sendMessage";

        try {
            HTTPHelper.executePostRequest(urlString, data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
