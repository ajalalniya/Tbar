package co.tara.tarabari.passenger.rest.async;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import co.tara.tarabari.passenger.model.TripRES;
import co.tara.tarabari.passenger.rest.AsyncResponse;
import co.tara.tarabari.passenger.rest.client.MyOkClient;
import co.tara.tarabari.passenger.rest.request.FindingDriverApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 2/18/2017.
 */

public class GetFindDriverDa extends AsyncTask<TripRES, Void, Object> {


    public AsyncResponse delegate = null;

    public GetFindDriverDa(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object) {

       Call<String> call = (Call<String>) object;

        //String myStr =  str;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                if (response != null && response.body() != null) {
                    String response2 = response.body().toString();

                    TripRES tripRES = new Gson().fromJson(response2, TripRES.class);


                    delegate.processFinish(tripRES);
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("----", "fieler");

            }
        });

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Object doInBackground(TripRES... tripRES) {
        String str = "";







        String myTripres = new Gson().toJson(tripRES[0]);



            FindingDriverApi findingDriver = MyOkClient.getClient().create(FindingDriverApi.class);
        Call<String> call = findingDriver.findDriver(myTripres, "application/json");


     /*   findingDriver.findDriver(myTripres, "application/json").enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                if (response != null && response.body() != null) {
                    String response2 = response.body().toString();

                    TripRES distanceFeeRES = new Gson().fromJson(response2, TripRES.class);


                 //   delegate.processFinish(distanceFeeRES.getTripCost());
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {


            }
        });*/
        Object object = call;
        return object;
    }


}



