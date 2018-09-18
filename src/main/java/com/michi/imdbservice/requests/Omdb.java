package com.michi.imdbservice.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Omdb {
    //example of omdb request
    //http://www.omdbapi.com/?s=blade+runner&apikey=e088609c

    public static String searchByNameShort(String name) throws IOException {
        name = name.replace(" ","+" );
        String url = "http://www.omdbapi.com/?s=" + name +"&apikey=e088609c";
        return makeRequest(url);
    }

    public static String searchByIDDetailed(String id) throws IOException {
        id = id.replace(" ","+" );
        String url = "http://www.omdbapi.com/?i=" + id +"&apikey=e088609c";
        return makeRequest(url);
    }

    private static String makeRequest(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }


}
