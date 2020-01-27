package co.tara.tarabari.driver.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/17/2017.
 */

public interface AcceptTripApi {
    @POST("d/acceptTrip")
    Call<String> sendAccept(@Body String accept, @Header("Content-Type") String content);

}
