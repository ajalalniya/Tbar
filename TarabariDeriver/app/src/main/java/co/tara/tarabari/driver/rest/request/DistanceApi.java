package co.tara.tarabari.driver.rest.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ali on 2/7/2017.
 */

public interface DistanceApi {

    @GET("directions/json")
    Call<String> getDistance(@Query("origin") String orgin, @Query("destination") String destination, @Query("sensor") String sensor, @Query("units") String units, @Query("mode") String mode);
}
