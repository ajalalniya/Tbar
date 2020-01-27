package co.tara.tarabari.driver.rest.async;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


import co.tara.tarabari.driver.model.DriverPointRES;
import co.tara.tarabari.driver.model.DriverRES;
import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.model.VehicleDriverRES;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.client.MyScalarClient;
import co.tara.tarabari.driver.rest.request.SendLatLngApi;
import co.tara.tarabari.driver.rest.request.SendLatLngInTripApi;
import co.tara.tarabari.driver.rest.request.VehicleListApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/17/2017.
 */

public class SetLatLngInTrip extends AsyncTask<DriverPointRES, Void, Object> {


    public AsyncResponse delegate = null;

    public SetLatLngInTrip(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object) {

        Call<String> call = (Call<String>) object;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {

                String response2 = response.body().toString();

                delegate.processFinish("Success");
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
    protected Object doInBackground(DriverPointRES... driverRES) {

        String drivers = new Gson().toJson(driverRES[0]);


        SendLatLngInTripApi vehicleList = MyScalarClient.getClient().create(SendLatLngInTripApi.class);
        Call<String> call = vehicleList.setLatLng(drivers, "application/json");


        Object object = call;


        return object;
    }


}



