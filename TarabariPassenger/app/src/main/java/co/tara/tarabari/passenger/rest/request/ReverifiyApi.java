package co.tara.tarabari.passenger.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/6/2017.
 */

public interface ReverifiyApi {
    @POST("p/tryAgainVerification")
    Call<String> reVerification(@Body String verify , @Header("Content-Type") String content);

}
