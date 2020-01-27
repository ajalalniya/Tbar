package co.tara.tarabari.passenger.rest.client;

import java.util.concurrent.TimeUnit;

import co.tara.tarabari.passenger.Config;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by jalalnia on 5/9/2017.
 */

public class MyOkClient {
    public static final String BASE_URL = Config.BASE_URL;
    private static Retrofit retrofit = null;

    private static  OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create()).client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
