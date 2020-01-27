package co.tara.tarabari.passenger;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jalalnia on 4/12/2017.
 */

public interface LoginService {
    @POST("test")
    Call<String> basicLogin(@Query("id") long id);
}

