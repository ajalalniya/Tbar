package co.tara.tarabari.driver.rest.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jalalnia on 5/6/2017.
 */

public interface LoginApi {

    @POST("d/loginState")
    Call<String> login(@Body String login, @Header("Content-Type") String content);
}
