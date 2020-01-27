package co.tara.tarabari.driver.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/23/2017.
 */

public interface RejectTripApi {

    @POST("d/rejectTrip")
    Call<String> reject(@Body String reject, @Header("Content-Type") String content);
}
