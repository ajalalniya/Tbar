package co.tara.tarabari.passenger.rest.request;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Ali on 2/4/2017.
 */

public interface RegisterApi {

        @POST("publicP/registerP")
        Call<String> register(@Body String register , @Header("Content-Type") String content);

}
