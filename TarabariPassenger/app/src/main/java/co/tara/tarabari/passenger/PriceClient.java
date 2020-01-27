package co.tara.tarabari.passenger;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Ali on 2/5/2017.
 */

public class PriceClient {
   // public static final String BASE_URL = Config.BASE_URL +"swiftRS/price/";
    public static final String BASE_URL =  "http://192.168.0.63:8001/rs/admin/testRS/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
