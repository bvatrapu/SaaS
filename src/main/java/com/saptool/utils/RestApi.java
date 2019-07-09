package com.saptool.utils;

import java.io.*;
import java.net.*;

public class RestApi {

    public static String callRestApi(String strurl) {
        StringBuilder stringBuilder = new StringBuilder();
        try {

            URL url = new URL(strurl);
            //  String query = INSERT_HERE_YOUR_URL_PARAMETERS;

            //make connection
            URLConnection urlc = url.openConnection();

            //use post mode
            urlc.setDoOutput(true);
            urlc.setAllowUserInteraction(false);

            //send query
//        PrintStream ps = new PrintStream(urlc.getOutputStream());
//        ps.print(query);
//        ps.close();

            //get result
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String l = null;
            while ((l = br.readLine()) != null) {
                stringBuilder.append(l);
            }
            br.close();
        } catch (Exception e){
            Log.error(e.getMessage());
            stringBuilder.append("no resp");
        }
        return stringBuilder.toString();
    }

}
