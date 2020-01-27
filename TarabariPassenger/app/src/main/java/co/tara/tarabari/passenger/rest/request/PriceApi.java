package co.tara.tarabari.passenger.rest.request;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ali on 2/5/2017.
 */

public interface PriceApi {

    @POST("p/tripFee")
    Call<String> tripFee(@Body String verify , @Header("Content-Type") String content);


}
