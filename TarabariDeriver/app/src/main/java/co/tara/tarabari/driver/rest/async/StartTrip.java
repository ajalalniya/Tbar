package co.tara.tarabari.driver.rest.async;

import android.os.AsyncTask;

import com.google.gson.Gson;

import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.client.MyScalarClient;
import co.tara.tarabari.driver.rest.request.LoadingApi;
import co.tara.tarabari.driver.rest.request.StartTripApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/17/2017.
 */

public class StartTrip extends AsyncTask<TripRES, Void, Object> {


    public AsyncResponse delegate = null;

    public StartTrip(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object) {

        Call<String> call = (Call<String>) object;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {

                String response2 = response.body().toString();
                //TODO
                delegate.processFinish(null);
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
    protected Object doInBackground(TripRES... driverRES) {

        String drivers = new Gson().toJson(driverRES[0]);


        StartTripApi vehicleList = MyScalarClient.getClient().create(StartTripApi.class);
        Call<String> call = vehicleList.start(drivers, "application/json");


        Object object = call;


        return object;
    }


}



