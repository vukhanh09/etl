package org.example;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        System.out.println(test.Test());
    }

    public String Test() {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("https://fakestoreapi.com/products");

// Request parameters and other properties.
            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
            params.add(new BasicNameValuePair("title", "12345"));
            params.add(new BasicNameValuePair("price", "1123"));
            params.add(new BasicNameValuePair("description", "Hello!"));
            params.add(new BasicNameValuePair("image", "Hello!"));
            params.add(new BasicNameValuePair("category", "Hello!"));


            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));


//Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            System.out.println("123");

            String retSrc = EntityUtils.toString(entity);
            // parsing JSON
            JSONObject result = new JSONObject(retSrc);

            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return "00";

    }
}