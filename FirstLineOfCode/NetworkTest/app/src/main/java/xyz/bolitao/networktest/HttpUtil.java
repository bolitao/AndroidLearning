package xyz.bolitao.networktest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
//    public static String sendHttpRequest(String address) {
//        HttpURLConnection connection = null;
//        try {
//            URL url = new URL(address);
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setReadTimeout(8000);
//            connection.setConnectTimeout(8000);
//            connection.setDoInput(true);
//            connection.setDoOutput(true);
//            InputStream stream = connection.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//            StringBuilder response = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            return response.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
