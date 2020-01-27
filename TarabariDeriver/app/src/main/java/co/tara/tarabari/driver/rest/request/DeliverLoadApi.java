package co.tara.tarabari.driver.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/17/2017.
 */

public interface DeliverLoadApi {
    @POST("d/deliverLoad")
    Call<String> deliver(@Body String deliver, @Header("Content-Type") String content);

}
