package co.tara.tarabari.passenger.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/6/2017.
 */

public interface VerifyApi {

    @POST("p/verificationAccount")
    Call<String> verify(@Body String verify , @Header("Content-Type") String content);
}
