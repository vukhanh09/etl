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
import java.sql.*;


public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        System.out.println(test.Test());

        try{
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Class.forName("oracle.jdbc.OracleDriver");


//step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/ORCLPDB1.localdomain","SYS as SYSDBA","Oradoc_db1");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query

//            ResultSet rs=stmt.executeQuery("create table suppliers (id number, supplier_name number)");


            ResultSet rs=stmt.executeQuery("select  * from suppliers");

//            PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO MYTABLE (USERID, USERNAME, EMAILADDRESS, PHONENUMBER, PROFILEPICTURE )"
//                    + " VALUES (?, ?, ?, ?, ?)");
//            prepareStatement.setString(1, "10");
//            prepareStatement.setString(2, "ALI");
//            prepareStatement.setString(3, "gdgrgrregeg");
//            prepareStatement.setString(4, "0501977498");
//            prepareStatement.setNull(5, NULL);
//            prepareStatement.execute();

            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

//step5 close the connection object
            con.close();

        }catch(Exception e){
            System.out.println("123");

            System.out.println(e);
        }



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