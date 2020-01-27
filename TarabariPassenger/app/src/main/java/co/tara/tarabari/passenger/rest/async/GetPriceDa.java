package co.tara.tarabari.passenger.rest.async;

import android.os.AsyncTask;

import com.google.gson.Gson;


import co.tara.tarabari.passenger.model.DistanceFeeRES;
import co.tara.tarabari.passenger.rest.AsyncResponse;
import co.tara.tarabari.passenger.rest.client.MyScalarClient;
import co.tara.tarabari.passenger.rest.request.PriceApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 2/18/2017.
 */

public class GetPriceDa extends AsyncTask<DistanceFeeRES, Void, Object> {


    public AsyncResponse delegate = null;

    public GetPriceDa(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object) {

        Call<String> call = (Call<String>) object;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {


                String response2 = response.body().toString();

                DistanceFeeRES distanceFeeRES = new Gson().fromJson(response2, DistanceFeeRES.class);


                delegate.processFinish(distanceFeeRES.getTripCost());


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
    protected Object doInBackground(DistanceFeeRES... fee) {

        String myFee = new Gson().toJson(fee[0]);


        PriceApi priceApi = MyScalarClient.getClient().create(PriceApi.class);
        Call<String> call = priceApi.tripFee(myFee, "application/json");


        Object object = call;


        return object;
    }


}



