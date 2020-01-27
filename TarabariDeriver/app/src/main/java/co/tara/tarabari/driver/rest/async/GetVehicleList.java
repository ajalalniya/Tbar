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
import co.tara.tarabari.driver.rest.request.VehicleListApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/16/2017.
 */

public class GetVehicleList extends AsyncTask<DriverRES, Void, Object> {


    public AsyncResponse delegate = null;

    public GetVehicleList(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object) {

        Call<String> call = (Call<String>) object;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                if (response != null) {
                    String response2 = response.body().toString();
                    ArrayList<VehicleDriverRES> myDriverList = new Gson().fromJson(response2, new TypeToken<List<VehicleDriverRES>>() {
                    }.getType());
                    delegate.processFinish(myDriverList);
                }
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
    protected Object doInBackground(DriverRES... driverRES) {

        String drivers = new Gson().toJson(driverRES[0]);


        VehicleListApi vehicleList = MyScalarClient.getClient().create(VehicleListApi.class);
        Call<String> call = vehicleList.getVehicle(drivers, "application/json");


        Object object = call;


        return object;
    }


}



