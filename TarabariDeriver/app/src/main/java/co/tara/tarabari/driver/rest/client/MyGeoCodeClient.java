package co.tara.tarabari.driver.rest.client;


import co.tara.tarabari.driver.Config;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by jalalnia on 5/9/2017.
 */

public class MyGeoCodeClient {
    public static final String BASE_URL = Config.BASE_URL_GEO;
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
