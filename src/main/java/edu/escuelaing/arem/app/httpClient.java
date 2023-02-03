package edu.escuelaing.arem.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpClient {
    private static final String USER_AGENT = "Mozilla/5.0";
    //private static final String GET_URL = "http://www.omdbapi.com/?i=tt3896198&apikey=2c402a46";
    
    
    /**
     * Método que permite hacer peticiones a la API
     * @param url Url con el nombre de la película a consultar
     * @return String que contiene la respuesta por parte de la API
     * @throws IOException
     */

    public static String getAnswer(String url) throws IOException {



        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        StringBuffer response = null;
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        }
        System.out.println(response.toString());

        return "[" + response.toString() + "]";
    }
}

//
//            // print result
//            System.out.println(response.toString());
//        } else {
//            System.out.println("GET request not worked");
//        }
//        System.out.println("GET DONE");
//        return response.toString;
//    }

