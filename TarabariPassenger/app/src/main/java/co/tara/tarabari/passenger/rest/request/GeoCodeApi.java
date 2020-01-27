package co.tara.tarabari.passenger.rest.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ali on 2/6/2017.
 */

public interface GeoCodeApi {
    @GET("geocode/json")
    Call<String> getAddress(@Query("latlng") String latLng, @Query("language") String language);

}
