package co.tara.tarabari.driver.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/16/2017.
 */

public interface VehicleListApi {
    @POST("d/vehicleList")
    Call<String> getVehicle(@Body String vehicleList, @Header("Content-Type") String content);
}
