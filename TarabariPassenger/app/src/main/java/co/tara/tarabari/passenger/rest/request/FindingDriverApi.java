package co.tara.tarabari.passenger.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/11/2017.
 */

public interface FindingDriverApi {

    @POST("p/registerTrip")
    Call<String> findDriver(@Body String driver , @Header("Content-Type") String content);


}
