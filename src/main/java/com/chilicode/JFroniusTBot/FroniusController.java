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


    public FroniusController(){
        fronius_base_url = System.getenv("FRONIUS");
        System.out.println(fronius_base_url);

        Map <String, String> map = System.getenv();

        System.out.println(map);

    }

    public FroniusData getData(){
        System.out.println("da bin ich");

        String urlString = "http://" + fronius_base_url + "/solar_api/v1/GetPowerFlowRealtimeData.fcgi";

        try {
            Map<String, String[]> returnValue =  executeRequest(urlString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static Map<String, String[]> executeRequest(String urlString) throws IOException {
        System.out.println("Execute: " + urlString);

        Map<String, String[]> map = new HashMap<>();

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet(urlString);

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);


                    Type mapType = new TypeToken<Map<String, Map>>(){}.getType();  
                    map = new Gson().fromJson(result, mapType);
                    
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }

   
        return map;
    }

    public String getSatus() {
    

        return "Fronius IP = " + fronius_base_url;
    }
}