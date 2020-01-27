package co.tara.tarabari.driver.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/17/2017.
 */

public interface EndTripApi {
    @POST("d/endTrip")
    Call<String> end(@Body String end, @Header("Content-Type") String content);

}
