package co.tara.tarabari.driver.rest;


import co.tara.tarabari.driver.rest.response.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ali on 2/5/2017.
 */

public interface CarLatLngApi {

    @GET("getTotalPrice")
    Call<Response> getLatLng(@Query("driverId") int customerId, @Query("latLng") String latLang);


}
