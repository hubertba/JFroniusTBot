package com.chilicode.JFroniusTBot;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FroniusController {

    String fronius_base_url;

    public FroniusController() {
        fronius_base_url = System.getenv("FRONIUS");
        System.out.println(fronius_base_url);

        Map<String, String> map = System.getenv();

        System.out.println(map);

    }

    public FroniusData getData() {
        String power = "-1";

        String urlString = "http://" + fronius_base_url + "/solar_api/v1/GetPowerFlowRealtimeData.fcgi";

        try {
            Map<String, String[]> returnValue = HTTPHelper.executeGetRequest(urlString);


            power = "testPower";
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new FroniusData(power);
    }



    public String getSatus() {
        return "Fronius IP = " + fronius_base_url;
    }
}