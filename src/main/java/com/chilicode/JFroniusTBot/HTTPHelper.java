package com.chilicode.JFroniusTBot;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HTTPHelper {

    public static String executeGetRequest(String urlString){
        System.out.println("Execute: " + urlString);

        String result = "";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet(urlString);

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
                System.out.println(response.getProtocolVersion()); // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode()); // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    result = EntityUtils.toString(entity);
                    System.out.println(result);

                    // convert to map for debugging
                    Type mapType = new TypeToken<Map<String, Map>>() {
                    }.getType();
                    Map<String, String[]> map = new Gson().fromJson(result, mapType);

                }

            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HttpHostConnectException e) {
            // TODO Auto-generated catch block
            System.out.println("no connection");
            e.printStackTrace();
            return "no connection";
        }
         catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }

    public static Map<String, String[]> executePostRequest(String urlString, List<BasicNameValuePair> data)
            throws IOException {
        System.out.println("Execute: " + urlString);

        Map<String, String[]> map = new HashMap<>();

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpPost request = new HttpPost(urlString);

            UrlEncodedFormEntity form = new UrlEncodedFormEntity(data);

            request.setEntity(form);

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
                System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
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
