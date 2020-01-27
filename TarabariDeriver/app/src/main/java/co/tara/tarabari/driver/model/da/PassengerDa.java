package co.tara.tarabari.driver.model.da;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import co.tara.tarabari.driver.model.to.Passnger;


/**
 * Created by Ali on 1/18/2017.
 */
public class PassengerDa {
    HttpURLConnection conn;
    String html = "";
    ArrayList<Passnger> myArray;
    String API = "http://192.168.0.6:8080/taxiWS/user/";

    public PassengerDa() {


    }

    public String authenticate(Object[] objects) {
        String content = "";

        try {

            String params = "?mobileNumber=" + objects[0] + "&password=" + objects[1] + "&loginType=" + "1";
            conn = (HttpURLConnection) new URL("http://192.168.0.6:8080/taxiWS/user/login" + params).openConnection();

            conn.setRequestMethod("GET");

            InputStreamReader isw = new InputStreamReader(conn.getInputStream());

            int data = 0;

            while (data != -1) {
                data = isw.read();
                char cdata = (char) data;
                content += String.valueOf(cdata);
            }
            System.out.println(content);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return content;

    }





}
