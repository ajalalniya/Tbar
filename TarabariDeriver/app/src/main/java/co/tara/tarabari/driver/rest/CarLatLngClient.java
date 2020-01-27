package co.tara.tarabari.driver.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ali on 2/5/2017.
 */

public class CarLatLngClient {
 //   public static final String BASE_URL = "http://192.168.0.6/taxiWS/price/";
    public static final String BASE_URL = "http://192.168.43.148/swift/getTrip.php/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
