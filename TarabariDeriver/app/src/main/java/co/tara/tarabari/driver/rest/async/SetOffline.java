package co.tara.tarabari.driver.rest.async;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import co.tara.tarabari.driver.model.DriverRES;
import co.tara.tarabari.driver.model.VehicleDriverRES;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.client.MyScalarClient;
import co.tara.tarabari.driver.rest.request.OfflineDriverApi;
import co.tara.tarabari.driver.rest.request.VehicleListApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/16/2017.
 */

public class SetOffline extends AsyncTask<VehicleDriverRES,Void,Object> {

    public AsyncResponse delegate = null;

    public SetOffline(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object) {

        Call<String> call = (Call<String>) object;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {

                String response2 = response.body().toString();

                delegate.processFinish("success");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // Log.i("----", "fieler");

            }
        });

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Object doInBackground(VehicleDriverRES... vehicleDriverRES) {

        String drivers = new Gson().toJson(vehicleDriverRES[0]);


        OfflineDriverApi offlineDriverApi = MyScalarClient.getClient().create(OfflineDriverApi.class);
        Call<String> call = offlineDriverApi.offline(drivers, "application/json");


        Object object = call;


        return object;
    }


}


