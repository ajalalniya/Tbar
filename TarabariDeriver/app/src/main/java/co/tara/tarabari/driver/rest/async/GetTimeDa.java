package co.tara.tarabari.driver.rest.async;

import android.os.AsyncTask;

//import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONObject;

import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.client.MyGeoCodeClient;
import co.tara.tarabari.driver.rest.request.DistanceApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 2/18/2017.
 */

public class GetTimeDa  {
//public class GetTimeDa extends AsyncTask<LatLng, Void, Object> {





   /* public AsyncResponse delegate = null;

    public GetTimeDa(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Object doInBackground(LatLng... latLngs) {

        DistanceApi distanceApi = MyGeoCodeClient.getClient().create(DistanceApi.class);

        Call<String> call = distanceApi.getDistance(latLngs[0].latitude + "," + latLngs[0].longitude, latLngs[1].latitude + "," + latLngs[1].longitude, "false", "metric", "driving");


        Object object =call;

        return object;
    }


    @Override
    protected void onPostExecute(Object object) {

        Call<String> call = (Call<String>) object;

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {

                String response2 = response.body().toString();
                try {
                    final JSONObject json = new JSONObject(response2);
                    JSONArray routeArray = json.getJSONArray("routes");
                    JSONObject routes = routeArray.getJSONObject(0);

                    JSONArray newTempARr = routes.getJSONArray("legs");
                    JSONObject newDisTimeOb = newTempARr.getJSONObject(0);

                    JSONObject distOb = newDisTimeOb.getJSONObject("distance");
                    JSONObject timeOb = newDisTimeOb.getJSONObject("duration");

                    delegate.processFinish(timeOb.getString("value"));

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // Log.i("----", "fieler");

            }
        });


    }*/
}