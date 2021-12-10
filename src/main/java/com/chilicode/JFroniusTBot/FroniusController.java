package com.chilicode.JFroniusTBot;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;





public class FroniusController {

    public FroniusController(){
    }

    public static FroniusData getData(){
        System.out.println("da bin ich");

        String urlString = "http://10.0.0.22/solar_api/v1/GetPowerFlowRealtimeData.fcgi";

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
}