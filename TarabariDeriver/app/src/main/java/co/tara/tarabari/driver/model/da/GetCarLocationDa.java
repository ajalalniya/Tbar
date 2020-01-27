package co.tara.tarabari.driver.model.da;

import android.os.AsyncTask;

//import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.CarLatLngApi;
import co.tara.tarabari.driver.rest.CarLatLngClient;
import co.tara.tarabari.driver.rest.response.Response;
import co.tara.tarabari.driver.utils.ResultMessages;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 2/18/2017.
 */

public class GetCarLocationDa extends AsyncTask<Object, Void, Object[]> {


    public AsyncResponse delegate = null;

    public GetCarLocationDa(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected void onPostExecute(final Object object[]) {


        Call<Response> call = (Call<Response>) object[1];

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {


                String response2 = response.body().getMESSAGE();



                if (response2.equals(String.valueOf(ResultMessages.SUCCESS))) {



                    delegate.processFinish(null);

                } else if (response2.equals(String.valueOf(ResultMessages.UN_SUCCESS))) {


                } else if (response2.equals(String.valueOf(ResultMessages.SERVER_EXCEPTION))) {


                }


            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Object[] doInBackground(Object... objects) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");


        Calendar calendar = Calendar.getInstance();
        System.out.println("-------" + simpleDateFormat.format(calendar.getTime()));

        final CarLatLngApi carLatLngApi = CarLatLngClient.getClient().create(CarLatLngApi.class);


        int id;
        id = (int) objects[0];

        //    Log.i("----jj", " distance " + ((float) trip[0].getAllDistance1() / 1000) + " time " + simpleDateFormat.format(calendar.getTime()) + "Alldistance: " + +((float) trip[0].getAllDistance1() / 1000));
        String latLng;

   /*     latLng = ((LatLng) objects[1]).latitude + "," + ((LatLng) objects[1]).longitude;

        Call<Response> call = carLatLngApi.getLatLng(id,latLng );*/




/*
        Object[] objects = new Object[2];
        objects[0] = trip[0];
        objects[1] = call;*/
        return objects;
    }


}



