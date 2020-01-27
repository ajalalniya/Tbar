package co.tara.tarabari.driver.rest.async;

import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.google.gson.Gson;

import co.tara.tarabari.driver.Config;
import co.tara.tarabari.driver.model.VehicleDriverRES;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.client.MyScalarClient;
import co.tara.tarabari.driver.rest.request.ActiveVehicleApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/16/2017.
 */

public class ActiveVehicle extends AsyncTask<VehicleDriverRES,Void,Object> {
    public AsyncResponse delegate = null;

    public ActiveVehicle(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object) {

        Call<String> call = (Call<String>) object;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {

                String response2 = response.body().toString();

              VehicleDriverRES vehicleDriverRES=  new Gson().fromJson(response2,VehicleDriverRES.class);

                SharedPreferences.Editor editor = Config.preferences.edit();
                editor.putLong("pk_vehicle_id", vehicleDriverRES.getPk_vehicle_id());
                editor.commit();

                delegate.processFinish("success");
             //   delegate.processFinish();
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

        String vehicles = new Gson().toJson(vehicleDriverRES[0]);


       ActiveVehicleApi sendVehicleApi = MyScalarClient.getClient().create(ActiveVehicleApi.class);
        Call<String> call = sendVehicleApi.sendVehicle(vehicles, "application/json");


        Object object = call;


        return object;
    }


}



