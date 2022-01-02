package com.chilicode.JFroniusTBot;

import java.io.IOException;
import java.util.Map;

import com.chilicode.JFroniusTBot.model.PowerFlowRealtimeData;
import com.google.gson.Gson;

public class FroniusController {

    String fronius_base_url;

    public FroniusController() {
        fronius_base_url = System.getenv("FRONIUS");
        System.out.println(fronius_base_url);

        Map<String, String> map = System.getenv();

        System.out.println(map);

    }

    public String getData() {
        String ppv = "";

        String urlString = "http://" + fronius_base_url + "/solar_api/v1/GetPowerFlowRealtimeData.fcgi";

        try {
            String json = HTTPHelper.executeGetRequest(urlString);

            PowerFlowRealtimeData data = new Gson().fromJson(json, PowerFlowRealtimeData.class);

            ppv = data.getBody().getData().getSite().getPPv();
            if (ppv == null) {
                ppv = "null";
            }
            System.out.println(ppv);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ppv;
    }

    public PowerFlowRealtimeData getPowerFlowRealtimeData() {
        String urlString = "http://" + fronius_base_url + "/solar_api/v1/GetPowerFlowRealtimeData.fcgi";
        PowerFlowRealtimeData data = null; 

        try {
            String json = HTTPHelper.executeGetRequest(urlString);
            data = new Gson().fromJson(json, PowerFlowRealtimeData.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }

    public String getCurrentPowerMessage(PowerFlowRealtimeData data){

        String ppv = data.getBody().getData().getSite().getPPv();
        if (ppv == null) {
            return "Zur Zeit wird kein Strom erzeugt :-(";
        }
        return "Zur Zeit werden " + ppv + "Watt erzeugt.";
    } 

    public String getSatus() {
        return "Fronius IP = " + fronius_base_url;
    }

    public String getTotalPowerMessage(PowerFlowRealtimeData data) {
        Float etotal = data.getBody().getData().getInverters().get1().getETotal();
        
        //convert to MegaWatt
        Float megawatt = etotal / 1000000; 

        return "Seit beginn wurden "+  megawatt +" MegaWatt erezugt.";
    }
}